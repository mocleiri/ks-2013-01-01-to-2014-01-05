package com.sigmasys.kuali.ksa.service.fm.impl;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.KeyPairService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.atp.AtpService;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;
import com.sigmasys.kuali.ksa.service.brm.BrmMethodInterceptor;
import com.sigmasys.kuali.ksa.service.fm.BrmFeeManagementService;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import com.sigmasys.kuali.ksa.service.hold.HoldService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.util.CommonUtils;
import org.aopalliance.aop.Advice;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.student.r2.core.atp.dto.MilestoneInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


/**
 * BRM FeeManagementService implementation.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Service("brmFeeManagementService")
@Transactional(timeout = 1200)
public class BrmFeeManagementServiceImpl extends GenericPersistenceService implements BrmFeeManagementService {

    private static final Log logger = LogFactory.getLog(BrmFeeManagementServiceImpl.class);

    // Global variable names
    private static final String FM_SESSION_VAR_NAME = "fmSession";
    private static final String FM_SIGNUP_VAR_NAME = "fmSignup";


    // Default multi-value delimiter
    private static final String MULTI_VALUE_DELIMITER = ",";

    // Relational operators
    private static final String EQUAL_OPERATOR = "=";
    private static final String UNEQUAL_OPERATOR = "!=";
    private static final String GREATER_OPERATOR = ">";
    private static final String LESS_OPERATOR = "<";
    private static final String GREATER_EQUAL_OPERATOR = ">=";
    private static final String LESS_EQUAL_OPERATOR = "<=";


    @Autowired
    private KeyPairService keyPairService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private HoldService holdService;

    @Autowired
    private AtpService atpService;

    @Autowired
    private RateService rateService;

    @Autowired
    private TransactionService transactionService;


    /**
     * Adds an AOP proxy to the current instance.
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Advice> getAdvices(BeanFactory beanFactory) {
        List<Advice> advices = super.getAdvices(beanFactory);
        if (advices == null) {
            advices = new LinkedList<Advice>();
        }
        advices.add(new BrmMethodInterceptor(this));
        return advices;
    }

    private <T extends Comparable<T>> boolean compareObjects(T object1, T object2, String operator) {

        if (EQUAL_OPERATOR.equals(operator)) {
            return object1.compareTo(object2) == 0;
        } else if (UNEQUAL_OPERATOR.equals(operator)) {
            return object1.compareTo(object2) != 0;
        } else if (GREATER_OPERATOR.equals(operator)) {
            return object1.compareTo(object2) > 0;
        } else if (LESS_OPERATOR.equals(operator)) {
            return object1.compareTo(object2) < 0;
        } else if (GREATER_EQUAL_OPERATOR.equals(operator)) {
            return object1.compareTo(object2) >= 0;
        } else if (LESS_EQUAL_OPERATOR.equals(operator)) {
            return object1.compareTo(object2) <= 0;
        }

        String errMsg = "Unknown relational operator " + operator;
        logger.error(errMsg);
        throw new IllegalArgumentException(errMsg);
    }

    private <T extends KeyPairAware> boolean compareKeyPair(T entity, String key, String value, String operator) {

        List<KeyPair> keyPairs = keyPairService.getKeyPairsByKey(entity, key);

        if (CollectionUtils.isNotEmpty(keyPairs)) {
            for (KeyPair keyPair : keyPairs) {

                Comparable object1;
                Comparable object2;

                if (!EQUAL_OPERATOR.equals(operator) || !UNEQUAL_OPERATOR.equals(operator)) {
                    object1 = (keyPair.getValue() != null) ? new BigDecimal(keyPair.getValue()) : BigDecimal.ZERO;
                    object2 = (value != null) ? new BigDecimal(value) : BigDecimal.ZERO;
                } else {
                    object1 = CommonUtils.nvl(keyPair.getValue());
                    object2 = CommonUtils.nvl(value);
                }

                if (compareObjects(object1, object2, operator)) {
                    return true;
                }
            }
        }

        return false;
    }

    private <T extends KeyPairAware> void setKeyPair(T entity, String key, String value) {
        keyPairService.removeKeyPairsByKeys(entity, key);
        keyPairService.addKeyPairs(entity, new KeyPair(key, value));
    }

    @SuppressWarnings("unchecked")
    private <T> T getGlobalVariable(BrmContext context, String variableName) {
        return (T) context.getGlobalVariables().get(variableName);
    }

    private <T> T getRequiredGlobalVariable(BrmContext context, String variableName) {
        T variable = getGlobalVariable(context, variableName);
        if (variable == null) {
            String errMsg = "Global variable '" + variableName + "' has not been found";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return variable;
    }

    private void addRateToSignup(Rate rate, FeeManagementSignup signup) {

        FeeManagementSignupRate signupRate = new FeeManagementSignupRate();

        signupRate.setRate(rate);
        signupRate.setSignup(signup);
        signupRate.setComplete(false);

        persistEntity(signupRate);

        Set<FeeManagementSignupRate> signupRates = signup.getSignupRates();

        if (signupRates == null) {
            signupRates = new HashSet<FeeManagementSignupRate>();
        }

        signupRates.add(signupRate);
        signup.setSignupRates(signupRates);

        persistEntity(signup);
    }

    private void replaceRateOnSignup(Long rateId, Rate newRate, FeeManagementSignup signup) {

        Set<FeeManagementSignupRate> signupRates = signup.getSignupRates();

        if (CollectionUtils.isNotEmpty(signupRates)) {
            for (FeeManagementSignupRate signupRate : signupRates) {

                if (rateId.equals(signupRate.getRate().getId())) {
                    signupRate.setRate(newRate);
                    persistEntity(signupRate);
                }
            }
        }
    }

    private Set<FeeManagementSignup> filterSessionSignups(Collection<FeeManagementSignup> signups,
                                                          String rateCodes,
                                                          String rateTypeCodes,
                                                          String rateCatalogCodes,
                                                          String signupOperations,
                                                          String offeringIds) {

        Set<FeeManagementSignup> filteredSignups = new HashSet<FeeManagementSignup>();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> rateCodeValues = CommonUtils.split(rateCodes, MULTI_VALUE_DELIMITER);
            List<String> rateTypeCodeValues = CommonUtils.split(rateTypeCodes, MULTI_VALUE_DELIMITER);
            List<String> rateCatalogCodeValues = CommonUtils.split(rateCatalogCodes, MULTI_VALUE_DELIMITER);
            List<String> operationValues = CommonUtils.split(signupOperations, MULTI_VALUE_DELIMITER);
            List<String> offeringIdValues = CommonUtils.split(offeringIds, MULTI_VALUE_DELIMITER);

            Set<FeeManagementSignup> rateCodeSignups = new HashSet<FeeManagementSignup>();
            Set<FeeManagementSignup> rateTypeCodeSignups = new HashSet<FeeManagementSignup>();
            Set<FeeManagementSignup> rateCatalogCodeSignups = new HashSet<FeeManagementSignup>();
            Set<FeeManagementSignup> operationSignups = new HashSet<FeeManagementSignup>();
            Set<FeeManagementSignup> offeringIdSignups = new HashSet<FeeManagementSignup>();

            for (FeeManagementSignup signup : signups) {

                Set<FeeManagementSignupRate> signupRates = signup.getSignupRates();

                boolean signupAdded = false;

                for (String rateTypeCode : rateTypeCodeValues) {
                    for (FeeManagementSignupRate signupRate : signupRates) {
                        RateType rateType = signupRate.getRate().getRateType();
                        if (Pattern.compile(rateTypeCode).matcher(rateType.getCode()).matches()) {
                            rateTypeCodeSignups.add(signup);
                            signupAdded = true;
                            break;
                        }
                    }
                    if (signupAdded) {
                        break;
                    }
                }

                signupAdded = false;

                for (String rateCode : rateCodeValues) {
                    for (FeeManagementSignupRate signupRate : signupRates) {
                        Rate rate = signupRate.getRate();
                        if (Pattern.compile(rateCode).matcher(rate.getCode()).matches()) {
                            rateCodeSignups.add(signup);
                            signupAdded = true;
                            break;
                        }
                    }
                    if (signupAdded) {
                        break;
                    }
                }

                signupAdded = false;

                for (String catalogCode : rateCatalogCodeValues) {
                    for (FeeManagementSignupRate signupRate : signupRates) {
                        Rate rate = signupRate.getRate();
                        RateCatalog rateCatalog = rate.getRateCatalogAtp().getRateCatalog();
                        if (Pattern.compile(catalogCode).matcher(rateCatalog.getCode()).matches()) {
                            rateCatalogCodeSignups.add(signup);
                            signupAdded = true;
                            break;
                        }
                    }
                    if (signupAdded) {
                        break;
                    }
                }

                for (String offeringId : offeringIdValues) {
                    if (Pattern.compile(offeringId).matcher(signup.getOfferingId()).matches()) {
                        offeringIdSignups.add(signup);
                        break;
                    }
                }

                FeeManagementSignupOperation signupOperation = signup.getOperation();

                if (signupOperation != null) {
                    for (String operation : operationValues) {
                        if (operation.equals(signupOperation.name())) {
                            operationSignups.add(signup);
                            break;
                        }
                    }
                }
            }

            Collection intersection = null;

            if (StringUtils.isNotEmpty(rateCodes)) {
                intersection = CollectionUtils.intersection(signups, rateCodeSignups);
            }

            if (StringUtils.isNotEmpty(rateTypeCodes)) {
                if (intersection != null) {
                    intersection = CollectionUtils.intersection(intersection, rateTypeCodeSignups);
                } else {
                    intersection = rateTypeCodeSignups;
                }

            }

            if (StringUtils.isNotEmpty(rateCatalogCodes)) {
                if (intersection != null) {
                    intersection = CollectionUtils.intersection(intersection, rateCatalogCodeSignups);
                } else {
                    intersection = rateCatalogCodeSignups;
                }
            }


            if (StringUtils.isNotEmpty(signupOperations)) {
                if (intersection != null) {
                    intersection = CollectionUtils.intersection(intersection, operationSignups);
                } else {
                    intersection = operationSignups;
                }
            }

            if (StringUtils.isNotEmpty(offeringIds)) {
                if (intersection != null) {
                    intersection = CollectionUtils.intersection(intersection, offeringIdSignups);
                } else {
                    intersection = operationSignups;
                }
            }

            if (intersection != null) {
                for (Object signupRef : intersection) {
                    filteredSignups.add((FeeManagementSignup) signupRef);
                }
            }
        }

        return filteredSignups;
    }

    /**
     * Executes the rule-based logic to assess fees for the given Account and ATP IDs.
     *
     * @param accountId Account ID
     * @param atpId     ATP ID
     * @return FeeManagementManifest instance
     */
    @Override
    public FeeManagementManifest assessFees(String accountId, String atpId) {
        // TODO
        return null;
    }

    /**
     * Compares the value of the Account KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    @Override
    public boolean compareAccountKeyPair(String key, String value, String operator, BrmContext context) {
        return compareKeyPair(context.getAccount(), key, value, operator);
    }

    /**
     * Compares the value of the FeeManagementSession KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    @Override
    public boolean compareSessionKeyPair(String key, String value, String operator, BrmContext context) {
        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);
        return compareKeyPair(session, key, value, operator);
    }

    /**
     * Compares the value of the FeeManagementSignup KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    @Override
    public boolean compareSignupKeyPair(String key, String value, String operator, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            return compareKeyPair(signup, key, value, operator);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {
            for (FeeManagementSignup fmSignup : signups) {
                if (compareKeyPair(fmSignup, key, value, operator)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Compares the value of any FeeManagementSignup's Rate KeyPair specified by "key" to the given "value".
     *
     * @param key      KeyPair's key
     * @param value    Value to compare
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return true if the KeyPair's value satisfies the given value and relational operator, false - otherwise.
     */
    @Override
    public boolean compareSignupRateKeyPair(String key, String value, String operator, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            Set<FeeManagementSignupRate> signupRates = signup.getSignupRates();
            if (CollectionUtils.isNotEmpty(signupRates)) {
                for (FeeManagementSignupRate signupRate : signupRates) {
                    Rate rate = signupRate.getRate();
                    if (rate != null && compareKeyPair(rate, key, value, operator)) {
                        return true;
                    }
                }
            }
            return false;
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {
            for (FeeManagementSignup fmSignup : signups) {
                Set<FeeManagementSignupRate> signupRates = fmSignup.getSignupRates();
                if (CollectionUtils.isNotEmpty(signupRates)) {
                    for (FeeManagementSignupRate signupRate : signupRates) {
                        Rate rate = signupRate.getRate();
                        if (rate != null && compareKeyPair(rate, key, value, operator)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Compares the current account type code to the given value.
     *
     * @param accountTypeCode AccountType code
     * @param operator        Relational operator. For example, "==" or "!="
     * @param context         BRM context
     * @return boolean value
     */
    @Override
    public boolean compareAccountType(String accountTypeCode, String operator, BrmContext context) {
        AccountType accountType = context.getAccount().getAccountType();
        if (accountType == null) {
            String errMsg = "AccountType cannot be null";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return compareObjects(accountType.getCode(), accountTypeCode, operator);
    }

    /**
     * Compares the current account status type code to the given value.
     *
     * @param accountStatusCode AccountStatusType code
     * @param operator          Relational operator. For example, "==" or "!="
     * @param context           BRM context
     * @return boolean value
     */
    @Override
    public boolean compareAccountStatus(String accountStatusCode, String operator, BrmContext context) {
        AccountStatusType statusType = context.getAccount().getStatusType();
        if (statusType == null) {
            String errMsg = "AccountStatusType cannot be null";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return compareObjects(statusType.getCode(), accountStatusCode, operator);
    }

    /**
     * Compares the FeeManagementSession ATP ID to the given value.
     *
     * @param atpId    ATP ID
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return boolean value
     */
    @Override
    public boolean compareSessionAtp(String atpId, String operator, BrmContext context) {
        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);
        String sessionAtpId = session.getAtpId();
        if (sessionAtpId == null) {
            String errMsg = "FeeManagementSession ATP ID cannot be null";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return compareObjects(sessionAtpId, atpId, operator);
    }

    /**
     * Checks if the account has a flag specified by FlagType code with the given severity value.
     *
     * @param flagTypeCode FlagType code
     * @param severity     Severity value
     * @param operator     Relational operator. For example, "==" or "!="
     * @param context      BRM context
     * @return boolean value
     */
    @Override
    public boolean accountHasFlag(String flagTypeCode, Integer severity, String operator, BrmContext context) {
        List<Flag> flags = informationService.getFlags(context.getAccount().getId());
        if (CollectionUtils.isNotEmpty(flags)) {
            for (Flag flag : flags) {
                if (flag.getType().getCode().equals(flagTypeCode)) {
                    if (severity != null) {
                        Integer flagSeverity = flag.getSeverity();
                        if (flagSeverity != null && compareObjects(flagSeverity, severity, operator)) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Compares the FeeManagementSession ATP ID to the given value.
     *
     * @param holdIssueName HoldIssue name
     * @param context       BRM context
     * @return boolean value
     */
    @Override
    public boolean accountHasAppliedHold(String holdIssueName, BrmContext context) {
        List<String> holdIssueNames = holdService.getHoldIssueNamesByUserId(holdIssueName);
        if (CollectionUtils.isNotEmpty(holdIssueNames)) {
            if (holdIssueNames.contains(holdIssueName)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Compares the FeeManagementSignup operation to the list of values separated by "," in one line.
     *
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     * @return boolean value
     */
    @Override
    public boolean compareSignupOperations(String signupOperations, BrmContext context) {

        List<String> operationValues = CommonUtils.split(signupOperations, MULTI_VALUE_DELIMITER);

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            FeeManagementSignupOperation signupOperation = signup.getOperation();
            if (signupOperation != null) {
                if (operationValues.contains(signupOperation.name())) {
                    return true;
                }
            }
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {
            for (FeeManagementSignup fmSignup : signups) {
                FeeManagementSignupOperation signupOperation = fmSignup.getOperation();
                if (signupOperation != null) {
                    if (operationValues.contains(signupOperation.name())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    /**
     * Compares the FeeManagementSignup effective date to the given date.
     *
     * @param date     Date in "MM/dd/yyyy"format
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return boolean value
     */
    @Override
    public boolean compareSignupEffectiveDate(String date, String operator, BrmContext context) {

        try {

            Date dateValue = new SimpleDateFormat(Constants.DATE_FORMAT_US).parse(date);

            FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

            if (signup != null) {
                return compareObjects(signup.getEffectiveDate(), dateValue, operator);
            }

            FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {
                for (FeeManagementSignup fmSignup : signups) {
                    if (compareObjects(fmSignup.getEffectiveDate(), dateValue, operator)) {
                        return true;
                    }
                }
            }

            return false;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Compares the FeeManagementSignup effective date to the signup or session ATP milestone.
     *
     * @param date     Date in "MM/dd/yyyy"format
     * @param operator Relational operator. For example, "==" or "!="
     * @param context  BRM context
     * @return boolean value
     */
    @Override
    public boolean compareSignupEffectiveDateToAtpMilestone(String date, String operator, BrmContext context) {

        String atpId = null;

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);
        if (signup != null) {
            atpId = signup.getAtpId();
        }

        if (atpId == null) {
            FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);
            atpId = session.getAtpId();
        }

        if (StringUtils.isBlank(atpId)) {
            String errMsg = "Neither FM signup nor session has a valid non-empty ATP ID";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        if (!atpService.atpExists(atpId)) {
            String errMsg = "ATP ID = " + atpId + " does not exist";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        try {

            List<MilestoneInfo> milestones = atpService.getMilestonesForAtp(atpId, atpService.getAtpContextInfo());

            for (MilestoneInfo milestone : milestones) {
                //TODO
            }


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return true;
    }


    /**
     * Compares the number of FeeManagementSignup objects to the given number.
     *
     * @param numberOfSignups  Number of FeeManagementSignup objects in the current FeeManagementSession
     * @param rateCodes        List of Rate codes separated by ","
     * @param rateTypeCodes    List of RateType codes separated by ","
     * @param signupOperations List of signup operation values separated by ","
     * @param operator         Relational operator. For example, "==" or "!="
     * @param context          BRM context
     * @return boolean value
     */
    @Override
    public boolean compareNumberOfSignups(int numberOfSignups, String rateCodes, String rateTypeCodes,
                                          String signupOperations, String operator, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups =
                filterSessionSignups(session.getSignups(), rateCodes, rateTypeCodes, null, signupOperations, null);

        return compareObjects(signups.size(), numberOfSignups, operator);
    }

    /**
     * Compares the number of units to the given number.
     *
     * @param numberOfUnits    Number of units in the current FeeManagementSession
     * @param rateCodes        List of Rate codes separated by ","
     * @param rateTypeCodes    List of RateType codes separated by ","
     * @param signupOperations List of signup operation values separated by ","
     * @param operator         Relational operator. For example, "==" or "!="
     * @param context          BRM context
     * @return boolean value
     */
    @Override
    public boolean compareNumberOfUnits(int numberOfUnits, String rateCodes, String rateTypeCodes,
                                        String signupOperations, String operator, BrmContext context) {

        int signupUnits = 0;

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);
        if (signup != null) {
            return compareObjects(signup.getUnit() != null ? signup.getUnit() : signupUnits, numberOfUnits, operator);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups =
                filterSessionSignups(session.getSignups(), rateCodes, rateTypeCodes, null, signupOperations, null);

        for (FeeManagementSignup fmSignup : signups) {
            if (fmSignup.getUnit() != null) {
                signupUnits++;
            }
        }

        return compareObjects(signupUnits, numberOfUnits, operator);
    }


    /**
     * Checks if the current signup in the context is taken.
     *
     * @param context BRM context
     * @return boolean value
     */
    @Override
    public boolean signupIsTaken(BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            return signup.isTaken();
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {
            for (FeeManagementSignup fmSignup : signups) {
                if (!fmSignup.isTaken()) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    /**
     * Checks if the current signup in the context is complete.
     *
     * @param context BRM context
     * @return boolean value
     */
    @Override
    public boolean signupIsComplete(BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            return signup.isComplete();
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {
            for (FeeManagementSignup fmSignup : signups) {
                if (!fmSignup.isComplete()) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }


    /**
     * Checks if the signup has rates specified by the codes.
     *
     * @param rateCodes List of Rate codes separated by ","
     * @param context   BRM context
     * @return boolean value
     */
    @Override
    public boolean signupHasRates(String rateCodes, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);
        if (signup != null) {
            return CollectionUtils.isNotEmpty(filterSessionSignups(Arrays.asList(signup), rateCodes, null, null, null, null));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSessionSignups(session.getSignups(), rateCodes, null, null, null, null));
    }

    /**
     * Checks if the signup has rate types specified by the codes.
     *
     * @param rateTypeCodes List of RateType codes separated by ","
     * @param context       BRM context
     * @return boolean value
     */
    @Override
    public boolean signupHasRateTypes(String rateTypeCodes, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            return CollectionUtils.isNotEmpty(filterSessionSignups(Arrays.asList(signup), null, rateTypeCodes, null, null, null));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSessionSignups(session.getSignups(), null, rateTypeCodes, null, null, null));
    }

    /**
     * Checks if the signup has rate catalogs specified by the codes.
     *
     * @param rateCatalogCodes List of RateCatalog codes separated by ","
     * @param context          BRM context
     * @return boolean value
     */
    @Override
    public boolean signupHasRateCatalogs(String rateCatalogCodes, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            return CollectionUtils.isNotEmpty(filterSessionSignups(Arrays.asList(signup), null, null, rateCatalogCodes, null, null));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSessionSignups(session.getSignups(), null, null, rateCatalogCodes, null, null));
    }

    /**
     * Checks if the signup has Offering IDs.
     *
     * @param offeringIds List of Offering IDs separated by ","
     * @param context     BRM context
     * @return boolean value
     */
    @Override
    public boolean signupHasOfferingIds(String offeringIds, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            return CollectionUtils.isNotEmpty(filterSessionSignups(Arrays.asList(signup), null, null, null, null, offeringIds));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSessionSignups(session.getSignups(), null, null, null, null, offeringIds));
    }

    /**
     * Checks if the signup has Offering Types.
     *
     * @param offeringTypes List of OfferingType values by ","
     * @param context       BRM context
     * @return boolean value
     */
    @Override
    public boolean signupHasOfferingTypes(String offeringTypes, BrmContext context) {

        List<String> offeringTypeValues = CommonUtils.split(offeringTypes, MULTI_VALUE_DELIMITER);

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            OfferingType offeringType = signup.getOfferingType();
            if (offeringType != null) {
                if (offeringTypeValues.contains(offeringType.name())) {
                    return true;
                }
            }
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {
            for (FeeManagementSignup fmSignup : signups) {
                OfferingType offeringType = fmSignup.getOfferingType();
                if (offeringType != null) {
                    if (offeringTypeValues.contains(offeringType.name())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    // TODO


    // RHS methods start here

    /**
     * Sets an Account KeyPair specified by "key" and "value".
     *
     * @param key     KeyPair key
     * @param value   KeyPair value
     * @param context BRM context
     */
    @Override
    public void setAccountKeyPair(String key, String value, BrmContext context) {
        setKeyPair(context.getAccount(), key, value);
    }

    /**
     * Sets a FeeManagementSession KeyPair specified by "key" and "value".
     *
     * @param key     KeyPair key
     * @param value   KeyPair value
     * @param context BRM context
     */
    @Override
    public void setSessionKeyPair(String key, String value, BrmContext context) {
        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);
        setKeyPair(session, key, value);
    }

    /**
     * Sets a FeeManagementSignup KeyPair specified by "key" and "value".
     *
     * @param key     KeyPair key
     * @param value   KeyPair value
     * @param context BRM context
     */
    @Override
    public void setSignupKeyPair(String key, String value, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            setKeyPair(signup, key, value);
        } else {

            FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {
                for (FeeManagementSignup fmSignup : signups) {
                    setKeyPair(fmSignup, key, value);
                }
            }
        }
    }

    /**
     * Sets "isReviewRequired" to true or false on FeeManagementSession.
     *
     * @param isReviewRequired Boolean value
     * @param context          BRM context
     */
    @Override
    public void setSessionReviewRequired(boolean isReviewRequired, BrmContext context) {
        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);
        session.setReviewRequired(isReviewRequired);
    }

    /**
     * Sets "isReviewComplete" to true or false on FeeManagementSession.
     *
     * @param isReviewComplete Boolean value
     * @param context          BRM context
     */
    @Override
    public void setSessionReviewComplete(boolean isReviewComplete, BrmContext context) {
        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);
        session.setReviewComplete(isReviewComplete);
    }

    /**
     * Sets "isComplete" to true or false on FeeManagementSignup.
     *
     * @param isComplete Boolean value
     * @param context    BRM context
     */
    @Override
    public void setSignupComplete(boolean isComplete, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            signup.setComplete(isComplete);
        } else {

            FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {
                for (FeeManagementSignup fmSignup : signups) {
                    fmSignup.setComplete(isComplete);
                }
            }
        }
    }

    /**
     * Sets "isComplete" to true or false on all FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations.
     *
     * @param isComplete       Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    @Override
    public void setSessionSignupsComplete(boolean isComplete, String signupOperations, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> signupOperationValues = CommonUtils.split(signupOperations, MULTI_VALUE_DELIMITER);

            boolean signupOperationsExist = StringUtils.isNotEmpty(signupOperations);

            for (FeeManagementSignup fmSignup : signups) {

                FeeManagementSignupOperation signupOperation = fmSignup.getOperation();

                if (!signupOperationsExist || (signupOperation != null && signupOperationValues.contains(signupOperation.name()))) {
                    fmSignup.setComplete(isComplete);
                }
            }
        }
    }

    /**
     * Sets "isTaken" to true or false on FeeManagementSignup.
     *
     * @param isTaken Boolean value
     * @param context BRM context
     */
    @Override
    public void setSignupTaken(boolean isTaken, BrmContext context) {

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            signup.setTaken(isTaken);
        } else {

            FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {
                for (FeeManagementSignup fmSignup : signups) {
                    fmSignup.setTaken(isTaken);
                }
            }
        }
    }

    /**
     * Sets "isTaken" to true or false on all FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations.
     *
     * @param isTaken          Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    @Override
    public void setSessionSignupsTaken(boolean isTaken, String signupOperations, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> signupOperationValues = CommonUtils.split(signupOperations, MULTI_VALUE_DELIMITER);

            boolean signupOperationsExist = StringUtils.isNotEmpty(signupOperations);

            for (FeeManagementSignup fmSignup : signups) {

                FeeManagementSignupOperation signupOperation = fmSignup.getOperation();

                if (!signupOperationsExist || (signupOperation != null && signupOperationValues.contains(signupOperation.name()))) {
                    fmSignup.setTaken(isTaken);
                }
            }
        }
    }

    /**
     * Sets "isComplete" to true or false on all preceding FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations with the same Offering ID.
     *
     * @param isComplete       Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    @Override
    public void setPrecedingSignupsComplete(boolean isComplete, String signupOperations, BrmContext context) {

        FeeManagementSignup signup = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> signupOperationValues = CommonUtils.split(signupOperations, MULTI_VALUE_DELIMITER);

            for (FeeManagementSignup fmSignup : signups) {

                String offeringId = fmSignup.getOfferingId();
                FeeManagementSignupOperation signupOperation = fmSignup.getOperation();
                Date effectiveDate = fmSignup.getEffectiveDate();

                boolean operationsComply = StringUtils.isEmpty(signupOperations) || signupOperationValues.contains(signupOperation.name());

                if (offeringId.equals(signup.getOfferingId()) && effectiveDate.before(signup.getEffectiveDate()) && operationsComply) {
                    fmSignup.setComplete(isComplete);
                }
            }
        }
    }

    /**
     * Sets "isTaken" to true or false on all preceding FeeManagementSignup objects from FeeManagementSession
     * that have certain signup operations with the same Offering ID.
     *
     * @param isTaken          Boolean value
     * @param signupOperations List of signup operation values separated by ","
     * @param context          BRM context
     */
    @Override
    public void setPrecedingSignupsTaken(boolean isTaken, String signupOperations, BrmContext context) {

        FeeManagementSignup signup = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> signupOperationValues = CommonUtils.split(signupOperations, MULTI_VALUE_DELIMITER);

            for (FeeManagementSignup fmSignup : signups) {

                String offeringId = fmSignup.getOfferingId();
                FeeManagementSignupOperation signupOperation = fmSignup.getOperation();
                Date effectiveDate = fmSignup.getEffectiveDate();

                boolean operationsComply = StringUtils.isEmpty(signupOperations) || signupOperationValues.contains(signupOperation.name());

                if (offeringId.equals(signup.getOfferingId()) && effectiveDate.before(signup.getEffectiveDate()) && operationsComply) {
                    fmSignup.setTaken(isTaken);
                }
            }
        }
    }

    /**
     * Removes all rates on the current signup and all preceding signups (offerings) based on the given parameters.
     *
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void removeRatesFromSignupAndPrecedingOfferings(String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSignup signup = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> rateCodeValues = CommonUtils.split(rateCodes, MULTI_VALUE_DELIMITER);
            List<String> rateTypeCodeValues = CommonUtils.split(rateTypeCodes, MULTI_VALUE_DELIMITER);
            List<String> rateCatalogCodeValues = CommonUtils.split(rateCatalogCodes, MULTI_VALUE_DELIMITER);

            for (FeeManagementSignup fmSignup : signups) {

                Set<FeeManagementSignupRate> signupRates = fmSignup.getSignupRates();

                if (CollectionUtils.isNotEmpty(signupRates)) {

                    for (FeeManagementSignupRate signupRate : new HashSet<FeeManagementSignupRate>(signupRates)) {

                        Rate rate = signupRate.getRate();
                        RateType rateType = rate.getRateType();
                        RateCatalog rateCatalog = rate.getRateCatalogAtp().getRateCatalog();

                        boolean rateCodesComply = StringUtils.isEmpty(rateCodes) || rateCodeValues.contains(rate.getCode());
                        boolean rateTypeCodesComply = StringUtils.isEmpty(rateTypeCodes) || rateTypeCodeValues.contains(rateType.getCode());
                        boolean rateCatalogCodesComply = StringUtils.isEmpty(rateCatalogCodes) || rateCatalogCodeValues.contains(rateCatalog.getCode());

                        if (rateCodesComply && rateTypeCodesComply && rateCatalogCodesComply &&
                                fmSignup.getOfferingId().equals(signup.getOfferingId()) &&
                                fmSignup.getEffectiveDate().before(signup.getEffectiveDate())) {

                            signupRates.remove(signupRate);

                            if (signupRate.getId() != null) {
                                deleteEntity(signupRate.getId(), FeeManagementSignupRate.class);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Adds a rate to a FeeManagementSignup object from the BRM context.
     *
     * @param rateCode    Rate code
     * @param rateSubCode Rate sub-code
     */
    @Override
    public void addRateToSignup(String rateCode, String rateSubCode, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        String atpId = session.getAtpId();

        Rate rate = rateService.getRate(rateCode, rateSubCode, atpId);
        if (rate == null) {
            String errMsg = "Cannot find Rate [" + rateCode + ", " + rateSubCode + ", " + atpId + "]";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            addRateToSignup(rate, signup);
        } else {

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {
                for (FeeManagementSignup fmSignup : signups) {
                    addRateToSignup(rate, fmSignup);
                }
            }
        }
    }

    /**
     * Replaces a rate on FeeManagementSignup object with the new rate specified by code and sub-code.
     *
     * @param rateCode       Code of the rate to be replaced
     * @param rateSubCode    Sub-code of the rate to be replaced
     * @param newRateCode    Code of the new rate
     * @param newRateSubCode Sub-code of the new rate
     */
    @Override
    public void replaceRateOnSignup(String rateCode, String rateSubCode, String newRateCode, String newRateSubCode, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        String atpId = session.getAtpId();

        Rate rate = rateService.getRate(rateCode, rateSubCode, atpId);
        if (rate == null) {
            String errMsg = "Cannot find Rate [" + rateCode + ", " + rateSubCode + ", " + atpId + "]";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        Rate newRate = rateService.getRate(newRateCode, newRateSubCode, atpId);
        if (newRate == null) {
            String errMsg = "Cannot find Rate [" + newRateCode + ", " + newRateSubCode + ", " + atpId + "]";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSignup signup = getGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup != null) {
            replaceRateOnSignup(rate.getId(), newRate, signup);
        } else {

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {
                for (FeeManagementSignup fmSignup : signups) {
                    replaceRateOnSignup(rate.getId(), newRate, fmSignup);
                }
            }
        }
    }

    /**
     * Charges rates on the manifests from FeeManagementSession.
     *
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void chargeManifestRates(String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            List<String> rateCodeValues = CommonUtils.split(rateCodes, MULTI_VALUE_DELIMITER);
            List<String> rateTypeCodeValues = CommonUtils.split(rateTypeCodes, MULTI_VALUE_DELIMITER);
            List<String> rateCatalogCodeValues = CommonUtils.split(rateCatalogCodes, MULTI_VALUE_DELIMITER);

            for (FeeManagementManifest manifest : manifests) {

                Rate rate = manifest.getRate();
                RateType rateType = rate.getRateType();
                RateCatalog rateCatalog = rate.getRateCatalogAtp().getRateCatalog();

                boolean rateCodesComply = StringUtils.isEmpty(rateCodes) || rateCodeValues.contains(rate.getCode());
                boolean rateTypeCodesComply = StringUtils.isEmpty(rateTypeCodes) || rateTypeCodeValues.contains(rateType.getCode());
                boolean rateCatalogCodesComply = StringUtils.isEmpty(rateCatalogCodes) || rateCatalogCodeValues.contains(rateCatalog.getCode());

                if (rateCodesComply && rateTypeCodesComply && rateCatalogCodesComply) {

                    RateAmount rateAmount = rate.getDefaultRateAmount();

                    // TODO: Create a new charge
                    transactionService.createCharge(rateAmount.getTransactionTypeId(),
                            context.getAccount().getId(),
                            new Date(),
                            rateAmount.getAmount());

                }
            }
        }
    }


}
