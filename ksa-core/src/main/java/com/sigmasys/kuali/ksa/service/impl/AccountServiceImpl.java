package com.sigmasys.kuali.ksa.service.impl;

import com.sigmasys.kuali.ksa.exception.AccountTypeNotFoundException;
import com.sigmasys.kuali.ksa.exception.ConfigurationException;
import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.security.Permission;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.ActivityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.jaxb.Ach;
import com.sigmasys.kuali.ksa.service.security.PermissionUtils;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import com.sigmasys.kuali.ksa.util.CommonUtils;
import com.sigmasys.kuali.ksa.util.RequestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.rice.kim.api.identity.CodedAttribute;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kim.api.identity.PersonService;
import org.kuali.rice.kim.api.identity.address.EntityAddress;
import org.kuali.rice.kim.api.identity.email.EntityEmail;
import org.kuali.rice.kim.api.identity.entity.Entity;
import org.kuali.rice.kim.api.identity.name.EntityName;
import org.kuali.rice.kim.api.identity.phone.EntityPhone;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.identity.type.EntityTypeContactInfo;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.kim.impl.identity.address.EntityAddressBo;
import org.kuali.rice.kim.impl.identity.email.EntityEmailBo;
import org.kuali.rice.kim.impl.identity.entity.EntityBo;
import org.kuali.rice.kim.impl.identity.name.EntityNameBo;
import org.kuali.rice.kim.impl.identity.phone.EntityPhoneBo;
import org.kuali.rice.kim.impl.identity.principal.PrincipalBo;
import org.kuali.rice.kim.impl.identity.type.EntityTypeContactInfoBo;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.KRADServiceLocator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account service implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("accountService")
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class AccountServiceImpl extends GenericPersistenceService implements AccountService, BeanFactoryAware {

    private static final Log logger = LogFactory.getLog(AccountServiceImpl.class);

    private static final String GET_FULL_ACCOUNTS_QUERY = "select distinct a from Account a " +
            "left outer join fetch a.personNames pn " +
            "left outer join fetch a.postalAddresses pa " +
            "left outer join fetch a.electronicContacts ec " +
            "left outer join fetch a.statusType st " +
            "left outer join fetch a.latePeriod lp " +
            "where pn.default = true and " +
            "      pa.default = true and " +
            "      ec.default = true";

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ActivityService activityService;


    private PlatformTransactionManager transactionManager;
    private DefaultTransactionDefinition transactionDefinition;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        transactionManager = beanFactory.getBean("transactionManager", PlatformTransactionManager.class);
        transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    }

    /**
     * This process creates a temporary subset of the account as if the account were being administered
     * as a balance forward account. This permits aging the account in a way that is not affected by the
     * payment application methodology. This temporary array is passed to the ageDebt() method.
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return a list of pairs [Debit, BigDecimal]
     */
    @Override
    public List<Pair<Debit, BigDecimal>> rebalance(String userId, boolean ignoreDeferment) {

        PermissionUtils.checkPermission(Permission.REBALANCE_ACCOUNT);

        Query query = em.createQuery("select t from Transaction t " +
                " where t.account.id = :userId and " +
                "       t.effectiveDate <= CURRENT_DATE and type(t) in (:chargeCode) " +
                " order by t.effectiveDate desc");

        query.setParameter("userId", userId);
        query.setParameter("chargeCode", Charge.class);

        List<Debit> debits = query.getResultList();

        List<Pair<Debit, BigDecimal>> balancedDebits = new LinkedList<Pair<Debit, BigDecimal>>();

        // Distributing balance due among the most recent debits
        BigDecimal dueBalance = getDueBalance(userId, ignoreDeferment);
        BigDecimal remainingBalance = dueBalance;

        for (Debit debit : debits) {
            BigDecimal amount = debit.getAmount() != null ? debit.getAmount() : BigDecimal.ZERO;
            if (amount.compareTo(remainingBalance) < 0) {
                balancedDebits.add(new Pair<Debit, BigDecimal>(debit, amount));
                remainingBalance = remainingBalance.subtract(amount);
            } else {
                balancedDebits.add(new Pair<Debit, BigDecimal>(debit, remainingBalance));
                break;
            }
        }

        // Checking that the due balance equals the sum of split amounts
        BigDecimal accountBalance = BigDecimal.ZERO;
        for (Pair<Debit, BigDecimal> pair : balancedDebits) {
            accountBalance = accountBalance.add(pair.getB());
        }

        if (accountBalance.compareTo(dueBalance) != 0) {
            String errMsq = "The balance due " + dueBalance + " does not match " +
                    "the summarized distributed amount " + accountBalance;
            logger.error(errMsq);
            throw new IllegalStateException(errMsq);
        }

        return balancedDebits;

    }

    /**
     * Aging debts for all chargeable accounts in KSA
     *
     * @param ignoreDeferment boolean value
     */
    @Override
    @Transactional(readOnly = false)
    public void ageDebt(boolean ignoreDeferment) {

        PermissionUtils.checkPermission(Permission.AGE_ACCOUNT);

        String ageDebtMethodName = configService.getParameter(Constants.AGE_DEBT_METHOD);
        if (StringUtils.isBlank(ageDebtMethodName)) {
            String errMsg = "Configuration parameter '" + Constants.AGE_DEBT_METHOD + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }

        AgeDebtMethod ageDebtMethod = AgeDebtMethod.valueOf(ageDebtMethodName);
        List<Account> accounts = getFullAccounts();

        for (Account account : accounts) {
            if (account instanceof ChargeableAccount) {
                ageDebt((ChargeableAccount) account, ageDebtMethod, ignoreDeferment);
            }
        }
    }

    protected ChargeableAccount ageDebt(ChargeableAccount chargeableAccount, AgeDebtMethod ageDebtMethod,
                                        boolean ignoreDeferment) {

        PermissionUtils.checkPermission(Permission.AGE_ACCOUNT);

        LatePeriod latePeriod = chargeableAccount.getLatePeriod();

        final Date curDate = new Date();
        final Date lateDate1 = CalendarUtils.addCalendarDays(curDate, -latePeriod.getDaysLate1());
        final Date lateDate2 = CalendarUtils.addCalendarDays(curDate, -latePeriod.getDaysLate2());
        final Date lateDate3 = CalendarUtils.addCalendarDays(curDate, -latePeriod.getDaysLate3());

        BigDecimal lateAmount1 = BigDecimal.ZERO;
        BigDecimal lateAmount2 = BigDecimal.ZERO;
        BigDecimal lateAmount3 = BigDecimal.ZERO;

        switch (ageDebtMethod) {
            case BALANCE_FORWARD:
                List<Pair<Debit, BigDecimal>> balancedDebits = rebalance(chargeableAccount.getId(), ignoreDeferment);
                for (Pair<Debit, BigDecimal> pair : balancedDebits) {
                    Debit debit = pair.getA();
                    BigDecimal amount = pair.getB();
                    Date effectiveDate = debit.getEffectiveDate();
                    if (effectiveDate.compareTo(lateDate1) <= 0 && effectiveDate.compareTo(lateDate2) > 0) {
                        lateAmount1 = lateAmount1.add(amount);
                    } else if (effectiveDate.compareTo(lateDate2) <= 0 && effectiveDate.compareTo(lateDate3) > 0) {
                        lateAmount2 = lateAmount2.add(amount);
                    } else if (effectiveDate.compareTo(lateDate3) <= 0) {
                        lateAmount3 = lateAmount3.add(amount);
                    }
                }
                break;
            case OPEN_ITEM:
                for (Transaction transaction : transactionService.getTransactions(chargeableAccount.getId())) {
                    Date effectiveDate = transaction.getEffectiveDate();
                    BigDecimal amount = (transaction.getAmount() != null) ? transaction.getAmount() : BigDecimal.ZERO;
                    switch (transaction.getTransactionTypeValue()) {
                        case CHARGE:
                            if (effectiveDate.compareTo(lateDate1) <= 0 && effectiveDate.compareTo(lateDate2) > 0) {
                                lateAmount1 = lateAmount1.add(amount);
                            } else if (effectiveDate.compareTo(lateDate2) <= 0 && effectiveDate.compareTo(lateDate3) > 0) {
                                lateAmount2 = lateAmount2.add(amount);
                            } else if (effectiveDate.compareTo(lateDate3) <= 0) {
                                lateAmount3 = lateAmount3.add(amount);
                            }
                            break;
                        case PAYMENT:
                            if (effectiveDate.compareTo(lateDate1) <= 0 && effectiveDate.compareTo(lateDate2) > 0) {
                                lateAmount1 = lateAmount1.subtract(amount);
                            } else if (effectiveDate.compareTo(lateDate2) <= 0 && effectiveDate.compareTo(lateDate3) > 0) {
                                lateAmount2 = lateAmount2.subtract(amount);
                            } else if (effectiveDate.compareTo(lateDate3) <= 0) {
                                lateAmount3 = lateAmount3.subtract(amount);
                            }
                            break;
                        case DEFERMENT:
                            if (!ignoreDeferment) {
                                if (effectiveDate.compareTo(lateDate1) <= 0 && effectiveDate.compareTo(lateDate2) > 0) {
                                    lateAmount1 = lateAmount1.subtract(amount);
                                } else if (effectiveDate.compareTo(lateDate2) <= 0 && effectiveDate.compareTo(lateDate3) > 0) {
                                    lateAmount2 = lateAmount2.subtract(amount);
                                } else if (effectiveDate.compareTo(lateDate3) <= 0) {
                                    lateAmount3 = lateAmount3.subtract(amount);
                                }
                            }
                            break;
                        default:
                            String errMsg = "Transaction type '" + transaction.getTransactionTypeValue() + "' is not supported";
                            logger.error(errMsg);
                            throw new IllegalArgumentException(errMsg);
                    }
                }
                break;
            default:
                String errMsg = "Age debt method '" + ageDebtMethod.name() + "' is not supported";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
        }

        chargeableAccount.setAmountLate1(lateAmount1);
        chargeableAccount.setAmountLate2(lateAmount2);
        chargeableAccount.setAmountLate3(lateAmount3);
        chargeableAccount.setLateLastUpdate(curDate);

        persistEntity(chargeableAccount);

        return chargeableAccount;
    }


    /**
     * Aging debts for a chargeable account.
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return a chargeable account being updated
     */
    @Override
    @Transactional(readOnly = false)
    public ChargeableAccount ageDebt(String userId, boolean ignoreDeferment) {

        PermissionUtils.checkPermission(Permission.AGE_ACCOUNT);

        String ageDebtMethodName = configService.getParameter(Constants.AGE_DEBT_METHOD);
        if (StringUtils.isBlank(ageDebtMethodName)) {
            String errMsg = "Configuration parameter '" + Constants.AGE_DEBT_METHOD + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }

        AgeDebtMethod ageDebtMethod = AgeDebtMethod.valueOf(ageDebtMethodName);

        return ageDebt(userId, ageDebtMethod, ignoreDeferment);
    }

    /**
     * Aging debts for a chargeable account.
     *
     * @param userId          Account ID
     * @param ageDebtMethod   Age Debt method
     * @param ignoreDeferment boolean value
     * @return a chargeable account being updated
     */
    @Override
    @Transactional(readOnly = false)
    public ChargeableAccount ageDebt(String userId, AgeDebtMethod ageDebtMethod, boolean ignoreDeferment) {

        PermissionUtils.checkPermission(Permission.AGE_ACCOUNT);

        Account account = getFullAccount(userId);
        if (account == null) {
            String errMsg = "Account with ID '" + userId + "' does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (!(account instanceof ChargeableAccount)) {
            String errMsg = "Account must be of '" + ChargeableAccount.class.getName() + "' type";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        return ageDebt((ChargeableAccount) account, ageDebtMethod, ignoreDeferment);
    }

    /**
     * Returns the total balance due of all active transactions.
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return total amount of balance due
     */
    @Override
    public BigDecimal getDueBalance(String userId, boolean ignoreDeferment) {
        return getBalance(userId, ignoreDeferment, false);
    }

    /**
     * Returns the total balance to date for the given user ID.
     *
     * @param userId Account ID
     * @param toDate To Date
     * @return Amount
     */
    @Override
    public BigDecimal getBalance(String userId, Date toDate) {

        PermissionUtils.checkPermission(Permission.READ_BALANCE);

        if (toDate == null) {
            return BigDecimal.ZERO;
        }

        // getTransactions is <= end date, for this it needs to be < end date
        toDate = DateUtils.addDays(toDate, -1);

        List<Transaction> transactions = transactionService.getTransactions(userId, null, toDate);

        BigDecimal balance = BigDecimal.ZERO;
        for (Transaction t : transactions) {
            if (t instanceof Charge) {
                BigDecimal amount = t.getAmount();
                if (amount != null) {
                    balance = balance.add(t.getAmount());
                }
            } else {
                BigDecimal allocated = t.getAllocatedAmount();
                BigDecimal locked = t.getLockedAllocatedAmount();
                if (allocated != null) {
                    balance = balance.subtract(allocated);
                }
                if (locked != null) {
                    balance = balance.subtract(locked);
                }
            }
        }

        return balance;
    }

    /**
     * Returns the outstanding balance for the given account
     *
     * @param userId          Account ID
     * @param ignoreDeferment boolean value
     * @return total amount of outstanding balance
     */
    @Override
    public BigDecimal getOutstandingBalance(String userId, boolean ignoreDeferment) {
        return getBalance(userId, ignoreDeferment, true);
    }

    public BigDecimal getBalance(String userId, boolean ignoreDeferment, boolean notYetEffective) {

        PermissionUtils.checkPermission(Permission.READ_BALANCE);

        final String sign = notYetEffective ? ">" : "<=";
        Query query = em.createQuery("select t from Transaction t " +
                " where t.account.id = :userId and t.effectiveDate " + sign + " CURRENT_DATE");
        query.setParameter("userId", userId);
        List<Transaction> transactions = query.getResultList();
        BigDecimal amountBilled = BigDecimal.ZERO;
        BigDecimal amountPaid = BigDecimal.ZERO;
        for (Transaction transaction : transactions) {
            if (transaction instanceof Debit) {
                Debit debit = (Debit) transaction;
                BigDecimal amount = debit.getAmount() != null ? debit.getAmount() : BigDecimal.ZERO;
                amountBilled = amountBilled.add(amount);
            } else if (transaction instanceof Credit) {
                boolean includeAmount = true;
                if (transaction instanceof Deferment) {
                    if (ignoreDeferment || ((Deferment) transaction).isExpired()) {
                        includeAmount = false;
                    }
                }
                if (includeAmount) {
                    Credit credit = (Credit) transaction;
                    BigDecimal allocatedAmount = credit.getAllocatedAmount();
                    if (allocatedAmount == null) {
                        allocatedAmount = BigDecimal.ZERO;
                    }
                    BigDecimal lockedAllocatedAmount = credit.getLockedAllocatedAmount();
                    if (lockedAllocatedAmount == null) {
                        lockedAllocatedAmount = BigDecimal.ZERO;
                    }
                    amountPaid = amountPaid.add(allocatedAmount);
                    amountPaid = amountPaid.add(lockedAllocatedAmount);
                }
            }
        }

        return amountBilled.subtract(amountPaid);
    }

    /**
     * Returns unallocated balance for the given Account ID
     *
     * @param userId Account ID
     * @return unallocated balance
     */
    @Override
    public BigDecimal getUnallocatedBalance(String userId) {

        PermissionUtils.checkPermission(Permission.READ_BALANCE);

        List<Payment> payments = transactionService.getPayments(userId);
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Payment payment : payments) {
            BigDecimal amount = (payment.getAmount() != null) ? payment.getAmount() : BigDecimal.ZERO;
            BigDecimal allocatedAmount = (payment.getAllocatedAmount() != null) ?
                    payment.getAllocatedAmount() : BigDecimal.ZERO;
            BigDecimal lockedAllocatedAmount = (payment.getLockedAllocatedAmount() != null) ?
                    payment.getLockedAllocatedAmount() : BigDecimal.ZERO;
            BigDecimal difference = amount.subtract(allocatedAmount.add(lockedAllocatedAmount));
            if (difference.compareTo(BigDecimal.ZERO) > 0) {
                totalAmount = totalAmount.add(difference);
            }
        }
        return totalAmount;
    }

    /**
     * Returns the deferred amount
     *
     * @param userId Account ID
     * @return deferred amount
     */
    @Override
    public BigDecimal getDeferredAmount(String userId) {
        List<Deferment> deferments = transactionService.getDeferments(userId);
        BigDecimal totalAmount = BigDecimal.ZERO;
        Date curDate = new Date();
        for (Deferment deferment : deferments) {
            Date expirationDate = deferment.getExpirationDate();
            if (expirationDate == null || curDate.before(expirationDate)) {
                totalAmount = totalAmount.add(deferment.getAmount());
            }
        }
        return totalAmount;
    }

    /**
     * Checks if KSA account exists
     *
     * @param userId Account ID
     * @return true if the account exists, false otherwise
     */
    @Override
    public boolean ksaAccountExists(String userId) {
        return getEntity(userId, Account.class) != null;
    }

    /**
     * Checks if KSA account exists. If the KSA account does not exist, it tries to look for the existing KIM account
     * and create a new KSA account, if the account does not exist returns false, otherwise true.
     *
     * @param userId Account ID
     * @return true if the account exists, false otherwise
     */
    @Override
    public boolean accountExists(String userId) {
        if (StringUtils.isNotEmpty(userId)) {
            try {
                return getOrCreateAccount(userId) != null;
            } catch (UserNotFoundException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return false;
    }

    /**
     * This methods fetches Account and all its associations by account ID.
     *
     * @param userId Account ID
     * @return the account instance or null if the account does not exist
     */
    @Override
    public Account getFullAccount(String userId) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT);

        Query query = em.createQuery("select a from Account a " +
                "left outer join fetch a.personNames pn " +
                "left outer join fetch a.postalAddresses pa " +
                "left outer join fetch a.electronicContacts ec " +
                "left outer join fetch a.statusType st " +
                "left outer join fetch a.latePeriod lp " +
                "where a.id = :id");
        query.setParameter("id", userId);
        List<Account> accounts = query.getResultList();
        return (accounts != null && !accounts.isEmpty()) ? accounts.get(0) : null;
    }

    /**
     * This methods fetches all KSA accounts and all their associations.
     *
     * @return the list account instances
     */
    @Override
    public List<Account> getFullAccounts() {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT);

        Query query = em.createQuery(GET_FULL_ACCOUNTS_QUERY);
        return query.getResultList();
    }

    /**
     * This method fetches all KSA accounts that match the substring %name%
     *
     * @param pattern Name pattern
     * @return the list of Account instances
     */
    @Override
    public List<Account> getAccountsByNamePattern(String pattern) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT);

        Query query = em.createQuery(GET_FULL_ACCOUNTS_QUERY + " and upper(a.id) like upper(:pattern)");
        query.setParameter("pattern", "%" + pattern + "%");
        return query.getResultList();
    }

    /**
     * This method is used to verify that an account exists before a transaction or other operations are
     * performed on the account. There is an initial inquiry into the KSA store. If no account exist, then there is
     * an inquiry into KIM. If KIM also returns no result, then false is returned. If a KIM account does exist, then
     * a KSA account is created, using the KIM information as a template.
     *
     * @param userId Account ID
     * @return the account instance or null if the account does not exist
     */
    @Override
    @Transactional(readOnly = false)
    public Account getOrCreateAccount(String userId) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT);

        Account account = getEntity(userId, Account.class);
        if (account == null) {
            PersonService personService = KimApiServiceLocator.getPersonService();
            Person person = personService.getPersonByPrincipalName(userId);
            if (person == null) {
                String errMsg = "The user '" + person + "' does not exist";
                logger.error(errMsg);
                throw new UserNotFoundException(errMsg);
            }
            // If the person exists in KIM we have to create a new KSA account based on that
            account = createAccount(person);
        }

        return account;
    }

    private Account createAccount(Person person) {

        PermissionUtils.checkPermission(Permission.CREATE_ACCOUNT);

        TransactionStatus transaction = transactionManager.getTransaction(transactionDefinition);

        try {

            // TODO - populate the missing fields
            // TODO: figure out how to distinguish Delegate and DirectCharge account types

            String creatorId = null;

            HttpServletRequest request = RequestUtils.getThreadRequest();
            if (request != null) {
                creatorId = userSessionManager.getUserId(request);
            }

            if (creatorId == null) {
                creatorId = "system";
            }

            final Date creationDate = new Date();

            Account account = new DirectChargeAccount();

            account.setId(person.getPrincipalName());

            account.setCreatorId(creatorId);
            account.setCreationDate(creationDate);

            account.setAbleToAuthenticate(true);
            account.setEntityId(person.getEntityId());
            account.setKimAccount(true);
            account.setCreditLimit(new BigDecimal(0.0));

            PersonName personName = new PersonName();
            personName.setCreatorId(creatorId);
            personName.setLastUpdate(creationDate);
            personName.setDefault(true);
            personName.setFirstName(person.getFirstName());
            personName.setMiddleName(person.getMiddleName());
            personName.setLastName(person.getLastName());
            personName.setKimNameType(person.getEntityTypeCode());
            personName.setDefault(true);

            // Making PersonName persistent and generate ID
            persistEntity(personName);

            PostalAddress address = new PostalAddress();
            address.setCreatorId(creatorId);
            address.setLastUpdate(creationDate);
            address.setDefault(true);
            address.setPostalCode(person.getAddressPostalCode());
            address.setCountry(person.getAddressCountryCode());
            address.setState(person.getAddressStateProvinceCode());
            address.setCity(person.getAddressCity());
            address.setStreetAddress1(person.getAddressLine1());
            address.setStreetAddress2(person.getAddressLine2());
            address.setStreetAddress3(person.getAddressLine3());

            // Making PostalAddress persistent and generate ID
            persistEntity(address);

            ElectronicContact electronicContact = new ElectronicContact();
            electronicContact.setCreatorId(creatorId);
            electronicContact.setLastUpdate(creationDate);
            electronicContact.setDefault(true);
            electronicContact.setEmailAddress(person.getEmailAddress());
            electronicContact.setPhoneNumber(person.getPhoneNumber());
            electronicContact.setPhoneCountry(person.getAddressCountryCode());

            // Making ElectronicContact persistent and generate ID
            persistEntity(electronicContact);

            // Setting references to Account
            account.setPersonNames(new HashSet<PersonName>(Arrays.asList(personName)));
            account.setPostalAddresses(new HashSet<PostalAddress>(Arrays.asList(address)));
            account.setElectronicContacts(new HashSet<ElectronicContact>(Arrays.asList(electronicContact)));

            // "Account is in good standing" (Paul) ID = 1
            AccountStatusType statusType = getEntity(1L, AccountStatusType.class);
            if (statusType != null) {
                account.setStatusType(statusType);
            }

            // Late Period with ID = 1
            LatePeriod latePeriod = getEntity(1L, LatePeriod.class);
            if (latePeriod != null) {
                account.setLatePeriod(latePeriod);
            }

            // Making Account persistent
            persistEntity(account);

            // Linking PersonName, PostalAddress and ElectronicContact back to already persisted Account
            //personName.setAccount(account);
            //address.setAccount(account);
            //electronicContact.setAccount(account);

            transactionManager.commit(transaction);

            return account;

        } catch (Throwable t) {
            transactionManager.rollback(transaction);
            logger.error(t.getMessage(), t);
            throw new RuntimeException(t);
        }

    }

    /**
     * Creates and associates a new person name object with the given Account ID.
     *
     * @param userId     Account ID
     * @param personName Person name
     * @return new PersonName instance with ID
     */
    @Override
    @Transactional(readOnly = false)
    public PersonName addPersonName(String userId, PersonName personName) {
        return addPersonName(userId, personName, true);
    }

    protected PersonName addPersonName(String userId, PersonName personName, boolean createKimName) {

        PermissionUtils.checkPermission(Permission.UPDATE_ACCOUNT);

        Account account = getFullAccount(userId);
        if (account == null) {
            String errMsg = "Account with ID = " + userId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Set<PersonName> personNames = account.getPersonNames();
        if (personNames == null) {
            personNames = new HashSet<PersonName>();
        }

        if (personName.isDefault() != null && personName.isDefault()) {
            for (PersonName name : personNames) {
                name.setDefault(false);
            }
        }

        personName.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));
        personName.setLastUpdate(new Date());
        //personName.setAccount(account);

        persistEntity(personName);

        personNames.add(personName);
        account.setPersonNames(personNames);

        if (createKimName && account.isKimAccount()) {
            addKimPersonName(userId, personName);
        }

        return personName;
    }

    /**
     * Creates and associates a new postal address object with the given Account ID.
     *
     * @param userId        Account ID
     * @param postalAddress Postal address
     * @return new PostalAddress instance with ID
     */
    @Override
    @Transactional(readOnly = false)
    public PostalAddress addPostalAddress(String userId, PostalAddress postalAddress) {
        return addPostalAddress(userId, postalAddress, true);
    }

    protected PostalAddress addPostalAddress(String userId, PostalAddress postalAddress, boolean createKimAddress) {

        PermissionUtils.checkPermission(Permission.UPDATE_ACCOUNT);

        Account account = getFullAccount(userId);
        if (account == null) {
            String errMsg = "Account with ID = " + userId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Set<PostalAddress> addresses = account.getPostalAddresses();
        if (addresses == null) {
            addresses = new HashSet<PostalAddress>();
        }

        if (postalAddress.isDefault() != null && postalAddress.isDefault()) {
            for (PostalAddress address : addresses) {
                address.setDefault(false);
            }
        }

        postalAddress.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));
        postalAddress.setLastUpdate(new Date());
        //postalAddress.setAccount(account);

        persistEntity(postalAddress);

        addresses.add(postalAddress);
        account.setPostalAddresses(addresses);

        if (createKimAddress && account.isKimAccount()) {
            addKimPostalAddress(userId, postalAddress);
        }

        return postalAddress;
    }

    /**
     * Creates and associates a new electronic contact with the given Account ID.
     *
     * @param userId            Account ID
     * @param electronicContact Electronic contact
     * @return new ElectronicContact instance with ID
     */
    @Override
    @Transactional(readOnly = false)
    public ElectronicContact addElectronicContact(String userId, ElectronicContact electronicContact) {
        return addElectronicContact(userId, electronicContact, true);
    }

    protected ElectronicContact addElectronicContact(String userId, ElectronicContact electronicContact, boolean createKimContact) {

        PermissionUtils.checkPermission(Permission.UPDATE_ACCOUNT);

        Account account = getFullAccount(userId);
        if (account == null) {
            String errMsg = "Account with ID = " + userId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Set<ElectronicContact> contacts = account.getElectronicContacts();
        if (contacts == null) {
            contacts = new HashSet<ElectronicContact>();
        }

        if (electronicContact.isDefault() != null && electronicContact.isDefault()) {
            for (ElectronicContact contact : contacts) {
                contact.setDefault(false);
            }
        }

        electronicContact.setCreatorId(userSessionManager.getUserId(RequestUtils.getThreadRequest()));
        electronicContact.setLastUpdate(new Date());
        //electronicContact.setAccount(account);

        persistEntity(electronicContact);

        contacts.add(electronicContact);
        account.setElectronicContacts(contacts);

        if (createKimContact && account.isKimAccount()) {
            addKimElectronicContact(userId, electronicContact);
        }

        return electronicContact;
    }

    /**
     * Get ACH looks into the AccountProtectedInformation class (which triggers a system event) to look for
     * the ACH information for the user
     *
     * @param userId Account ID
     * @return Ach instance
     */
    @Override
    public Ach getAch(String userId) {

        PermissionUtils.checkPermission(Permission.READ_ACH);

        String errMsg = "ACH Account with ID = " + userId + " does not exist";

        AccountProtectedInfo account = getAccountProtectedInfo(userId);
        if (account == null) {
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        String achBankType = configService.getParameter(Constants.REFUND_ACH_BANK_TYPE);
        if (StringUtils.isBlank(achBankType)) {
            errMsg = "Configuration parameter '" + Constants.REFUND_ACH_BANK_TYPE + "' is required";
            logger.error(errMsg);
            throw new ConfigurationException(errMsg);
        }

        String details = account.getBankDetails();
        String[] detailsArr = details.split(":");

        if (detailsArr.length < 3) {
            logger.error(errMsg);
            throw new AccountTypeNotFoundException(errMsg);
        }
        String routingNumber = detailsArr[0];
        String act = detailsArr[1];
        String type = detailsArr[2];

        if (!("C".equals(type) || "S".equals(type))) {
            logger.error(errMsg);
            throw new AccountTypeNotFoundException(errMsg);
        }

        Pattern p = Pattern.compile("^(\\d{7}|\\d{9})$");
        Matcher m = p.matcher(routingNumber);
        if (!m.matches()) {
            errMsg = "Routing number '" + routingNumber + "' is invalid";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Ach ach = new Ach();
        ach.setAccountType(type);
        ach.setAccountNumber(act);
        ach.setRoutingNumber(routingNumber);

        return ach;
    }

    /**
     * Returns the account protected information by user ID.
     *
     * @param userId Account ID
     * @return AccountProtectedInfo instance
     */
    @Override
    public AccountProtectedInfo getAccountProtectedInfo(String userId) {

        PermissionUtils.checkPermission(Permission.VIEW_ACCOUNT_PROTECTED_INFO);

        Query query = em.createQuery("select a from AccountProtectedInfo a " +
                " left outer join fetch a.bankType" +
                " left outer join fetch a.taxType" +
                " left outer join fetch a.identityType" +
                " where a.id = :id");
        query.setParameter("id", userId);
        List<AccountProtectedInfo> protectedInfoList = query.getResultList();
        if (CollectionUtils.isNotEmpty(protectedInfoList)) {
            AccountProtectedInfo accountInfo = protectedInfoList.get(0);
            if (accountInfo != null) {
                Activity activity = new Activity();
                activity.setAccountId(userId);
                activity.setEntityId(accountInfo.getId());
                activity.setEntityType(AccountProtectedInfo.class.getSimpleName());
                activity.setIpAddress(RequestUtils.getClientIpAddress());
                activity.setLogDetail("Account Protected Info access [" + userId + "]");
                activityService.persistActivity(activity);
            }
            return accountInfo;
        }

        return null;
    }

    /**
     * Returns the list of matching accounts for the given name pattern.
     *
     * @param namePattern Name pattern
     * @return List of Account instances
     */
    @Override
    public List<Account> findAccountsByNamePattern(String namePattern) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT);

        boolean patternIsNotEmpty = (namePattern != null) && !namePattern.isEmpty();

        StringBuilder builder = new StringBuilder(GET_FULL_ACCOUNTS_QUERY);

        if (patternIsNotEmpty) {
            builder.append(" and (lower(a.id) like :pattern or lower(pn.firstName) like :pattern or " +
                    "lower(pn.middleName) like :pattern or lower(pn.lastName) like :pattern)");
        }

        builder.append(" order by a.id");

        Query query = em.createQuery(builder.toString());

        if (patternIsNotEmpty) {
            query.setParameter("pattern", "%" + namePattern.toLowerCase() + "%");
        }

        return query.getResultList();
    }

    /**
     * Expanded search for Accounts using multiple search criteria.
     *
     * @param searchPatterns Multiple search patterns.
     * @return List of matching Accounts.
     */
    @Override
    public List<Account> findAccountsByExpandedSearchPatterns(String... searchPatterns) {

        PermissionUtils.checkPermission(Permission.READ_ACCOUNT);

        // Remove empty elements resulted from extra spaces in the search string:
        searchPatterns = removeEmptyStrings(searchPatterns);

        // A list of properties used to search Accounts:
        List<String> searchAttributes = Arrays.asList(
                "a.id",
                "pn.firstName",
                "pn.middleName",
                "pn.lastName",
                "pa.streetAddress1",
                "pa.postalCode",
                "pa.city",
                "pa.state",
                "pa.country"
        );

        // Get the Account search query and build additional search conditions:
        StringBuilder accountSearchQuery = new StringBuilder(GET_FULL_ACCOUNTS_QUERY);

        boolean searchPatternsExist = searchPatterns != null && searchPatterns.length > 0;

        if (searchPatternsExist) {

            accountSearchQuery.append(" and (");

            // Add conditions for each search attribute:
            int i = 0;
            while (i++ < searchPatterns.length) {
                // Add conditions using bind variables:
                for (String searchAttribute : searchAttributes) {
                    accountSearchQuery.append("lower(").append(searchAttribute).append(") like ? or ");
                }
            }

            accountSearchQuery.setLength(accountSearchQuery.length() - 3);
            accountSearchQuery.append(")");
        }

        // Add "order by":
        accountSearchQuery.append(" order by a.id");

        Query query = em.createQuery(accountSearchQuery.toString());
        int searchAttributeCount = searchAttributes.size();

        if (searchPatternsExist) {
            for (int i = 0; i < searchPatterns.length; i++) {
                // Set parameter for each search attribute:
                String pattern = "%" + StringUtils.lowerCase(searchPatterns[i]) + "%";

                for (int j = 0; j < searchAttributeCount; j++) {
                    query.setParameter(i * searchAttributeCount + j + 1, pattern);
                }
            }
        }

        return query.getResultList();
    }

    private String[] removeEmptyStrings(String[] array) {

        List<String> temp = new LinkedList<String>();

        for (String s : array) {
            if (StringUtils.isNotEmpty(s)) {
                temp.add(s);
            }
        }

        return temp.toArray(new String[temp.size()]);
    }

    private Principal getPrincipal(String userId) {
        IdentityService identityService = KimApiServiceLocator.getIdentityService();
        Principal principal = identityService.getPrincipal(userId);
        if (principal == null) {
            String errMsg = "Principal does not exist, Account ID = " + userId;
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return principal;
    }

    /**
     * Retrieves KIM's EntityBo instance by entity ID.
     *
     * @param entityId Entity ID
     * @return EntityBo instance
     */
    private EntityBo getEntityBo(String entityId) {
        BusinessObjectService boService = KRADServiceLocator.getBusinessObjectService();
        return boService.findByPrimaryKey(EntityBo.class, Collections.singletonMap("id", entityId));
    }

    protected void addKimPersonName(String userId, PersonName personName) {
        addKimPersonName(getPrincipal(userId), personName);
    }

    protected void addKimPersonName(Principal principal, PersonName personName) {

        // Creating EntityName Builder
        EntityName.Builder entityNameBuilder = EntityName.Builder.create(
                String.valueOf(CommonUtils.generateUuid()),
                principal.getEntityId(),
                personName.getFirstName(),
                personName.getLastName(),
                false);

        entityNameBuilder.setMiddleName(personName.getMiddleName());
        entityNameBuilder.setNameTitle(personName.getTitle());
        entityNameBuilder.setNameSuffix(personName.getSuffix());

        String nameTypeCode = personName.getKimNameType();
        if (StringUtils.isBlank(nameTypeCode)) {
            nameTypeCode = Constants.KIM_DEFAULT_NAME_TYPE;
        }

        IdentityService identityService = KimApiServiceLocator.getIdentityService();

        CodedAttribute nameType = identityService.getNameType(nameTypeCode);

        entityNameBuilder.setNameType(CodedAttribute.Builder.create(nameType));

        entityNameBuilder.setObjectId(principal.getEntityId());
        entityNameBuilder.setDefaultValue(personName.isDefault());
        entityNameBuilder.setActive(true);
        entityNameBuilder.setVersionNumber(1L);

        // Adding EntityName to Entity
        identityService.addNameToEntity(entityNameBuilder.build());
    }

    protected void addKimPostalAddress(String userId, PostalAddress postalAddress) {
        addKimPostalAddress(getPrincipal(userId), postalAddress);
    }

    protected void addKimPostalAddress(Principal principal, PostalAddress postalAddress) {

        // Creating EntityAddress Builder
        EntityAddress.Builder entityAddressBuilder = EntityAddress.Builder.create();
        entityAddressBuilder.setId(String.valueOf(CommonUtils.generateUuid()));
        entityAddressBuilder.setEntityId(principal.getEntityId());
        entityAddressBuilder.setLine1(postalAddress.getStreetAddress1());
        entityAddressBuilder.setLine2(postalAddress.getStreetAddress2());
        entityAddressBuilder.setLine3(postalAddress.getStreetAddress3());
        entityAddressBuilder.setCity(postalAddress.getCity());

        String stateCode = postalAddress.getState();
        if (stateCode != null && stateCode.length() > 2) {
            stateCode = stateCode.substring(0, 2);
        }
        entityAddressBuilder.setStateProvinceCode(stateCode);

        entityAddressBuilder.setPostalCode(postalAddress.getPostalCode());

        String countryCode = postalAddress.getCountry();
        if (countryCode != null && countryCode.length() > 2) {
            countryCode = countryCode.substring(0, 2);
        }
        entityAddressBuilder.setCountryCode(countryCode);

        entityAddressBuilder.setEntityTypeCode(Constants.KIM_ENTITY_TYPE_CODE);

        String addressTypeCode = postalAddress.getKimAddressType();
        if (StringUtils.isBlank(addressTypeCode)) {
            addressTypeCode = Constants.KIM_DEFAULT_ADDRESS_TYPE;
        }

        IdentityService identityService = KimApiServiceLocator.getIdentityService();

        CodedAttribute addressType = identityService.getAddressType(addressTypeCode);

        entityAddressBuilder.setAddressType(CodedAttribute.Builder.create(addressType));
        entityAddressBuilder.setDefaultValue(postalAddress.isDefault());
        entityAddressBuilder.setActive(true);
        entityAddressBuilder.setVersionNumber(1L);

        // Adding EntityAddress to Entity
        identityService.addAddressToEntity(entityAddressBuilder.build());
    }

    protected void addKimElectronicContact(String userId, ElectronicContact contact) {
        addKimElectronicContact(getPrincipal(userId), contact);
    }

    protected void addKimElectronicContact(Principal principal, ElectronicContact contact) {

        // Creating EntityEmail Builder
        EntityEmail.Builder entityEmailBuilder = EntityEmail.Builder.create();
        entityEmailBuilder.setId(String.valueOf(CommonUtils.generateUuid()));
        entityEmailBuilder.setEntityId(principal.getEntityId());
        entityEmailBuilder.setEntityTypeCode(Constants.KIM_ENTITY_TYPE_CODE);

        String emailTypeCode = contact.getKimEmailAddressType();
        if (StringUtils.isBlank(emailTypeCode)) {
            emailTypeCode = Constants.KIM_DEFAULT_ADDRESS_TYPE;
        }

        IdentityService identityService = KimApiServiceLocator.getIdentityService();

        CodedAttribute emailType = identityService.getEmailType(emailTypeCode);

        entityEmailBuilder.setEmailType(CodedAttribute.Builder.create(emailType));
        entityEmailBuilder.setDefaultValue(contact.isDefault());
        entityEmailBuilder.setActive(true);
        entityEmailBuilder.setVersionNumber(1L);

        // Adding EntityEmail to Entity
        identityService.addEmailToEntity(entityEmailBuilder.build());

        // Creating EntityPhone Builder
        EntityPhone.Builder entityPhoneBuilder = EntityPhone.Builder.create();
        entityPhoneBuilder.setId(String.valueOf(CommonUtils.generateUuid()));
        entityPhoneBuilder.setEntityId(principal.getEntityId());
        entityPhoneBuilder.setPhoneNumber(contact.getPhoneNumber());
        entityPhoneBuilder.setExtensionNumber(contact.getPhoneExtension());

        String countryCode = contact.getPhoneCountry();
        if (countryCode != null && countryCode.length() > 2) {
            countryCode = countryCode.substring(0, 2);
        }
        entityPhoneBuilder.setCountryCode(countryCode);

        entityPhoneBuilder.setEntityTypeCode(Constants.KIM_ENTITY_TYPE_CODE);

        String phoneTypeCode = contact.getKimPhoneType();
        if (StringUtils.isBlank(phoneTypeCode)) {
            phoneTypeCode = Constants.KIM_DEFAULT_ADDRESS_TYPE;
        }

        CodedAttribute phoneType = identityService.getPhoneType(phoneTypeCode);

        entityPhoneBuilder.setPhoneType(CodedAttribute.Builder.create(phoneType));
        entityPhoneBuilder.setDefaultValue(true);
        entityPhoneBuilder.setActive(true);
        entityPhoneBuilder.setVersionNumber(1L);

        // Adding EntityPhone to Entity
        identityService.addPhoneToEntity(entityPhoneBuilder.build());
    }


    protected void updateKimAccount(Account account, String password) {

        final Date currentDate = new Date();
        final Timestamp timestamp = new Timestamp(currentDate.getTime());

        BusinessObjectService boService = KRADServiceLocator.getBusinessObjectService();

        Principal principal = getPrincipal(account.getId());

        PrincipalBo principalBo = PrincipalBo.from(principal);
        principalBo.setPassword(password);

        // Persisting PrincipalBo
        boService.save(principalBo);

        EntityBo entity = getEntityBo(principal.getEntityId());

        // TODO: Saving only default ones? if not, how to merge their lists and our sets?

        PersonName personName = account.getDefaultPersonName();
        if (personName != null) {
            List<EntityNameBo> names = entity.getNames();
            if (CollectionUtils.isNotEmpty(names)) {
                for (EntityNameBo name : names) {
                    if (name.isActive()) {
                        name.setDefaultValue(personName.isDefault());
                        name.setFirstName(personName.getFirstName());
                        name.setMiddleName(personName.getMiddleName());
                        name.setLastName(personName.getLastName());
                        name.setNameChangedDate(timestamp);
                        name.setNameTitle(personName.getTitle());
                        name.setNameSuffix(personName.getSuffix());
                        // Persisting EntityNameBo
                        boService.save(name);
                        personName.setKimNameType(name.getNameCode());
                        persistEntity(personName);
                        break;
                    }
                }
            }
        }

        List<EntityTypeContactInfoBo> contactInfos = entity.getEntityTypeContactInfos();
        if (CollectionUtils.isNotEmpty(contactInfos)) {
            for (EntityTypeContactInfoBo contactInfo : contactInfos) {
                if (contactInfo.isActive()) {
                    EntityAddressBo address = contactInfo.getDefaultAddress();
                    if (address != null) {
                        PostalAddress postalAddress = account.getDefaultPostalAddress();
                        if (postalAddress != null) {
                            address.setPostalCode(postalAddress.getPostalCode());
                            address.setCountryCode(postalAddress.getCountry());
                            address.setStateProvinceCode(postalAddress.getState());
                            address.setCity(postalAddress.getCity());
                            address.setLine1(postalAddress.getStreetAddress1());
                            address.setLine2(postalAddress.getStreetAddress2());
                            address.setLine3(postalAddress.getStreetAddress3());
                            address.setDefaultValue(postalAddress.isDefault());
                            address.setModifiedDate(timestamp);
                            // Saving EntityAddressBo
                            boService.save(address);
                            postalAddress.setKimAddressType(address.getAddressTypeCode());
                            persistEntity(postalAddress);
                        }
                    }
                    ElectronicContact contact = account.getDefaultElectronicContact();
                    if (contact != null) {
                        EntityPhoneBo phone = contactInfo.getDefaultPhoneNumber();
                        if (phone != null) {
                            phone.setCountryCode(contact.getPhoneCountry());
                            phone.setPhoneNumber(contact.getPhoneNumber());
                            phone.setExtensionNumber(contact.getPhoneExtension());
                            phone.setDefaultValue(contact.isDefault());
                            // Saving EntityPhoneBo
                            boService.save(phone);
                            contact.setKimPhoneType(phone.getPhoneTypeCode());
                        }
                        EntityEmailBo email = contactInfo.getDefaultEmailAddress();
                        if (email != null) {
                            email.setEmailAddress(contact.getEmailAddress());
                            email.setDefaultValue(contact.isDefault());
                            // Saving  EntityEmailBo
                            boService.save(email);
                            contact.setKimEmailAddressType(email.getEmailTypeCode());
                        }
                        if (phone != null || email != null) {
                            persistEntity(contact);
                        }
                    }
                    break;
                }
            }
        }

    }

    protected void createKimAccount(Account account, PersonName name, PostalAddress address, ElectronicContact contact,
                                    String password) {

        final String entityId = String.valueOf(CommonUtils.generateUuid());

        IdentityService identityService = KimApiServiceLocator.getIdentityService();
        BusinessObjectService boService = KRADServiceLocator.getBusinessObjectService();

        // Creating EntityBuilder
        Entity.Builder entityBuilder = Entity.Builder.create();

        entityBuilder.setId(entityId);
        entityBuilder.setObjectId(entityId);
        entityBuilder.setActive(true);
        entityBuilder.setVersionNumber(1L);
        entityBuilder.setEntityTypes(Arrays.asList(EntityTypeContactInfo.Builder.create(entityId, Constants.KIM_ENTITY_TYPE_CODE)));

        // Creating KIM Entity
        Entity entity = identityService.createEntity(entityBuilder.build());

        // Creating Principal Builder
        Principal.Builder principalBuilder = Principal.Builder.create(account.getId());
        principalBuilder.setPrincipalId(account.getId());
        principalBuilder.setEntityId(entity.getId());
        principalBuilder.setObjectId(entity.getObjectId());
        principalBuilder.setActive(true);
        principalBuilder.setVersionNumber(1L);

        // Building Principle, converting it to PrincipalBo and setting the new password
        Principal principal = principalBuilder.build();
        PrincipalBo principalBo = PrincipalBo.from(principal);

        // This seems to be the only way to set password for Principal
        principalBo.setPassword(password);

        // Persisting PrincipalBo
        boService.save(principalBo);

        // Adding person name, postal address and contact information
        addKimPersonName(principal, name);
        addKimPostalAddress(principal, address);
        addKimElectronicContact(principal, contact);

    }


    /**
     * Updates the user account in both places - KSA and KIM
     *
     * @param account  Account instance to be updated
     * @param password User password
     */
    @Override
    @Transactional(readOnly = false)
    public void updateAccount(Account account, String password) {

        PermissionUtils.checkPermission(Permission.UPDATE_ACCOUNT);

        if (!ksaAccountExists(account.getId())) {
            String errMsg = "Account '" + account.getId() + "' does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (StringUtils.isBlank(password)) {
            String errMsg = "Password cannot be empty, Account ID = " + account.getId();
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        persistEntity(account);

        if (account.isKimAccount()) {
            updateKimAccount(account, password);
        }
    }

    /**
     * Creates the user account in both places - KSA and KIM
     *
     * @param account        Account instance to be created
     * @param defaultName    Default PersonName
     * @param defaultAddress Default PersonAddress
     * @param defaultContact Default ElectronicContact
     * @param password       User password
     * @return Account instance
     */
    @Override
    @Transactional(readOnly = false)
    public Account createAccount(Account account, PersonName defaultName, PostalAddress defaultAddress,
                                 ElectronicContact defaultContact, String password) {

        PermissionUtils.checkPermission(Permission.CREATE_ACCOUNT);

        if (StringUtils.isBlank(password)) {
            String errMsg = "Password cannot be empty";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        persistEntity(account);

        addPersonName(account.getId(), defaultName, false);
        addPostalAddress(account.getId(), defaultAddress, false);
        addElectronicContact(account.getId(), defaultContact, false);

        if (account.isKimAccount()) {
            createKimAccount(account, defaultName, defaultAddress, defaultContact, password);
        }

        return account;
    }


}
