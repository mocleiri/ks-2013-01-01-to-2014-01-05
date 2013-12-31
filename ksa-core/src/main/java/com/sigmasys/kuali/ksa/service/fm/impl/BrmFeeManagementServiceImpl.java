package com.sigmasys.kuali.ksa.service.fm.impl;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.KeyPairService;
import com.sigmasys.kuali.ksa.service.atp.AtpService;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;
import com.sigmasys.kuali.ksa.service.brm.BrmMethodInterceptor;
import com.sigmasys.kuali.ksa.service.brm.BrmService;
import com.sigmasys.kuali.ksa.service.fm.BrmFeeManagementService;
import com.sigmasys.kuali.ksa.service.fm.FeeManagementService;
import com.sigmasys.kuali.ksa.service.fm.RateService;
import com.sigmasys.kuali.ksa.service.hold.HoldService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import com.sigmasys.kuali.ksa.util.CommonUtils;
import com.sigmasys.kuali.ksa.util.EnumUtils;
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

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
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

    @Autowired
    private BrmService brmService;

    @Autowired
    private AccountService accountService;

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
    private FeeManagementService fmService;


    // Relational operators
    private static enum Operator implements Identifiable {

        EQUAL(Operator.EQUAL_OPERATOR),
        UNEQUAL(Operator.UNEQUAL_OPERATOR),
        GREATER(Operator.GREATER_OPERATOR),
        LESS(Operator.LESS_OPERATOR),
        GREATER_EQUAL(Operator.GREATER_EQUAL_OPERATOR),
        LESS_EQUAL(Operator.LESS_EQUAL_OPERATOR);

        private static final String EQUAL_OPERATOR = "=";
        private static final String UNEQUAL_OPERATOR = "!=";
        private static final String GREATER_OPERATOR = ">";
        private static final String LESS_OPERATOR = "<";
        private static final String GREATER_EQUAL_OPERATOR = ">=";
        private static final String LESS_EQUAL_OPERATOR = "<=";

        private String id;

        private Operator(String id) {
            this.id = id;
        }

        @Override
        public Serializable getId() {
            return id;
        }
    }


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

        Operator operatorValue = EnumUtils.findById(Operator.class, operator);

        switch (operatorValue) {
            case EQUAL:
                return object1.compareTo(object2) == 0;
            case UNEQUAL:
                return object1.compareTo(object2) != 0;
            case GREATER:
                return object1.compareTo(object2) > 0;
            case LESS:
                return object1.compareTo(object2) < 0;
            case GREATER_EQUAL:
                return object1.compareTo(object2) >= 0;
            case LESS_EQUAL:
                return object1.compareTo(object2) <= 0;
            default:
                String errMsg = "Unknown relational operator '" + operator + "'";
                logger.error(errMsg);
                throw new IllegalStateException(errMsg);
        }

    }

    private <T extends KeyPairAware> boolean compareKeyPair(T entity, String key, String value, String operator) {

        List<KeyPair> keyPairs = keyPairService.getKeyPairsByKey(entity, key);

        if (CollectionUtils.isNotEmpty(keyPairs)) {

            Operator operatorValue = EnumUtils.findById(Operator.class, operator);

            for (KeyPair keyPair : keyPairs) {

                Comparable object1;
                Comparable object2;

                if (operatorValue != Operator.EQUAL && operatorValue != Operator.UNEQUAL) {
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

    private boolean matchesPatterns(String value, Collection<String> patterns) {
        for (String pattern : patterns) {
            if (Pattern.compile(pattern).matcher(value).matches()) {
                return true;
            }
        }
        return false;
    }

    private boolean collectionHasMatch(Collection<String> values, String patternValue) {
        Pattern pattern = Pattern.compile(patternValue);
        for (String value : values) {
            if (pattern.matcher(value).matches()) {
                return true;
            }
        }
        return false;
    }

    private List<String> getMatches(Collection<String> values, String patternValue) {
        List<String> matches = new LinkedList<String>();
        Pattern pattern = Pattern.compile(patternValue);
        for (String value : values) {
            if (pattern.matcher(value).matches()) {
                matches.add(value);
            }
        }
        return matches;
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

    private BigDecimal getSignupAmount(FeeManagementSignup signup) {

        BigDecimal signupAmount = BigDecimal.ZERO;

        Set<FeeManagementSignupRate> signupRates = signup.getSignupRates();

        if (CollectionUtils.isNotEmpty(signupRates)) {

            for (FeeManagementSignupRate signupRate : signupRates) {

                Rate rate = signupRate.getRate();

                if (rate != null) {

                    Set<RateAmount> rateAmounts = rate.getRateAmounts();

                    if (CollectionUtils.isNotEmpty(rateAmounts)) {

                        for (RateAmount rateAmount : rateAmounts) {

                            if (rateAmount.getAmount() != null) {
                                signupAmount = signupAmount.add(rateAmount.getAmount());
                            }
                        }
                    }
                }
            }
        }

        return signupAmount;
    }

    private Set<FeeManagementManifest> filterManifests(Collection<FeeManagementManifest> manifests,
                                                       String rateCodes,
                                                       String rateTypeCodes,
                                                       String rateCatalogCodes) {

        Set<FeeManagementManifest> filteredManifests = new HashSet<FeeManagementManifest>();

        List<String> rateCodeValues = CommonUtils.split(rateCodes, MULTI_VALUE_DELIMITER);
        List<String> rateTypeCodeValues = CommonUtils.split(rateTypeCodes, MULTI_VALUE_DELIMITER);
        List<String> rateCatalogCodeValues = CommonUtils.split(rateCatalogCodes, MULTI_VALUE_DELIMITER);

        for (FeeManagementManifest manifest : manifests) {

            Rate rate = manifest.getRate();
            RateType rateType = rate.getRateType();
            RateCatalog rateCatalog = rate.getRateCatalogAtp().getRateCatalog();

            boolean rateCodesComply = StringUtils.isEmpty(rateCodes) ||
                    matchesPatterns(rate.getCode(), rateCodeValues);

            boolean rateTypeCodesComply = StringUtils.isEmpty(rateTypeCodes) ||
                    (rateType != null && matchesPatterns(rateType.getCode(), rateTypeCodeValues));

            boolean rateCatalogCodesComply = StringUtils.isEmpty(rateCatalogCodes) ||
                    (rateCatalog != null && matchesPatterns(rateCatalog.getCode(), rateCatalogCodeValues));

            if (rateCodesComply && rateTypeCodesComply && rateCatalogCodesComply) {
                filteredManifests.add(manifest);
            }
        }

        return filteredManifests;
    }

    private Set<FeeManagementSignup> filterSignups(Collection<FeeManagementSignup> signups,
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
                        if (rateType != null && Pattern.compile(rateTypeCode).matcher(rateType.getCode()).matches()) {
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
                        if (rateCatalog != null && Pattern.compile(catalogCode).matcher(rateCatalog.getCode()).matches()) {
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

    private void addTagsToManifest(Collection<Tag> tags, FeeManagementManifest manifest) {

        Set<Tag> manifestTags = manifest.getTags();

        if (manifestTags == null) {
            manifestTags = new HashSet<Tag>();
            manifest.setTags(manifestTags);
        }

        for (Tag tag : tags) {
            manifestTags.add(tag);
        }

        persistEntity(manifest);
    }

    @SuppressWarnings("unchecked")
    private List<Tag> getTagsByCodes(List<String> tagCodes) {
        Query query = em.createQuery("select t from Tag t where t.code in (:tagCodes)");
        query.setParameter("tagCodes", tagCodes);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    private Rollup getRollupByCode(String rollupCode) {
        Query query = em.createQuery("select r from Rollup r where r.code = :rollupCode");
        query.setParameter("rollupCode", rollupCode);
        List<Rollup> rollups = query.getResultList();
        return CollectionUtils.isNotEmpty(rollups) ? rollups.get(0) : null;
    }

    private void addManifestToSession(FeeManagementManifest manifest, FeeManagementSession session) {
        manifest.setSession(session);
        Set<FeeManagementManifest> manifests = session.getManifests();
        if (manifests == null) {
            manifests = new HashSet<FeeManagementManifest>();
            session.setManifests(manifests);
        }
        manifests.add(manifest);
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

        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        // Calling BrmService with payment application rules
        BrmContext brmContext = new BrmContext();
        brmContext.setAccount(account);

        Map<String, Object> globalParams = new HashMap<String, Object>();

        // TODO: Figure out how to retrieve the FM session by accountId and atpId
        globalParams.put(FM_SESSION_VAR_NAME, null);

        brmContext.setGlobalVariables(globalParams);

        brmService.fireRules(Constants.BRM_FM_RULE_SET_NAME_1, brmContext);

        FeeManagementSession session = (FeeManagementSession) globalParams.get(FM_SESSION_VAR_NAME);

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
     * @param milestoneName Milestone name
     * @param operator      Relational operator. For example, "==" or "!="
     * @param context       BRM context
     * @return boolean value
     */
    @Override
    public boolean compareSignupEffectiveDateToAtpMilestone(String milestoneName, String operator, BrmContext context) {

        FeeManagementSignup signup = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        if (signup.getEffectiveDate() == null) {
            String errMsg = "Signup effective date cannot be null";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }

        String atpId = signup.getAtpId();

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

            Date signupDate = CalendarUtils.removeTime(signup.getEffectiveDate());

            List<MilestoneInfo> milestones = atpService.getMilestonesForAtp(atpId, atpService.getAtpContextInfo());

            for (MilestoneInfo milestone : milestones) {

                if (milestoneName.equals(milestone.getName())) {

                    Date milestoneStartDate = milestone.getStartDate();
                    Date milestoneEndDate = milestone.getEndDate();

                    if (milestoneStartDate != null && milestoneEndDate != null) {

                        switch (EnumUtils.findById(Operator.class, operator)) {
                            case EQUAL:
                                if (signupDate.compareTo(milestoneStartDate) >= 0 && signupDate.compareTo(milestoneEndDate) <= 0) {
                                    return true;
                                }
                                break;
                            case UNEQUAL:
                                if (signupDate.compareTo(milestoneStartDate) < 0 || signupDate.compareTo(milestoneEndDate) > 0) {
                                    return true;
                                }
                                break;
                            case GREATER:
                                if (signupDate.compareTo(milestoneEndDate) > 0) {
                                    return true;
                                }
                                break;
                            case LESS:
                                if (signupDate.compareTo(milestoneStartDate) < 0) {
                                    return true;
                                }
                                break;
                            case GREATER_EQUAL:
                                if (signupDate.compareTo(milestoneEndDate) >= 0) {
                                    return true;
                                }
                                break;
                            case LESS_EQUAL:
                                if (signupDate.compareTo(milestoneStartDate) <= 0) {
                                    return true;
                                }
                        }
                    }

                    if (milestoneStartDate != null && milestoneEndDate == null) {
                        if (compareObjects(signupDate, milestoneStartDate, operator)) {
                            return true;
                        }
                    } else if (milestoneStartDate == null && milestoneEndDate != null) {
                        if (compareObjects(signupDate, milestoneEndDate, operator)) {
                            return true;
                        }
                    }

                    break;
                }
            }


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return false;
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
                filterSignups(session.getSignups(), rateCodes, rateTypeCodes, null, signupOperations, null);

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
            return compareObjects(signup.getUnits() != null ? signup.getUnits() : signupUnits, numberOfUnits, operator);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups =
                filterSignups(session.getSignups(), rateCodes, rateTypeCodes, null, signupOperations, null);

        for (FeeManagementSignup fmSignup : signups) {
            if (fmSignup.getUnits() != null) {
                signupUnits += fmSignup.getUnits();
            }
        }

        return compareObjects(signupUnits, numberOfUnits, operator);
    }

    /**
     * Compares the number of units to the number of units of taken signups.
     *
     * @param rateCodes      List of Rate codes of all signups separated by ","
     * @param takenRateCodes List of Rate codes of taken signups separated by ","
     * @param operator       Relational operator. For example, "==" or "!="
     * @param context        BRM context
     * @return boolean value
     */
    @Override
    public boolean compareNumberOfTakenUnits(String rateCodes, String takenRateCodes, String operator, BrmContext context) {

        int sessionUnits = 0;
        int takenUnits = 0;

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = filterSignups(session.getSignups(), rateCodes, null, null, null, null);

        for (FeeManagementSignup signup : signups) {

            if (signup.getUnits() != null) {
                sessionUnits += signup.getUnits();
            }
        }

        signups = filterSignups(session.getSignups(), takenRateCodes, null, null, null, null);

        for (FeeManagementSignup signup : signups) {

            if (signup.getUnits() != null && signup.isTaken()) {
                takenUnits += signup.getUnits();
            }
        }

        return compareObjects(sessionUnits, takenUnits, operator);
    }

    /**
     * Compares the amount of all session signups to the amount of taken signups.
     *
     * @param rateCodes      List of Rate codes of all signups separated by ","
     * @param takenRateCodes List of Rate codes of taken signups separated by ","
     * @param operator       Relational operator. For example, "==" or "!="
     * @param context        BRM context
     * @return boolean value
     */
    @Override
    public boolean compareAmountOfTakenSignups(String rateCodes, String takenRateCodes, String operator, BrmContext context) {

        BigDecimal sessionAmount = BigDecimal.ZERO;
        BigDecimal takenAmount = BigDecimal.ZERO;

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = filterSignups(session.getSignups(), rateCodes, null, null, null, null);

        for (FeeManagementSignup signup : signups) {
            sessionAmount = sessionAmount.add(getSignupAmount(signup));
        }

        signups = filterSignups(session.getSignups(), takenRateCodes, null, null, null, null);

        for (FeeManagementSignup signup : signups) {
            if (signup.isTaken()) {
                takenAmount = takenAmount.add(getSignupAmount(signup));
            }
        }

        return compareObjects(sessionAmount, takenAmount, operator);
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
            return CollectionUtils.isNotEmpty(filterSignups(Arrays.asList(signup), rateCodes, null, null, null, null));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSignups(session.getSignups(), rateCodes, null, null, null, null));
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
            return CollectionUtils.isNotEmpty(filterSignups(Arrays.asList(signup), null, rateTypeCodes, null, null, null));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSignups(session.getSignups(), null, rateTypeCodes, null, null, null));
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
            return CollectionUtils.isNotEmpty(filterSignups(Arrays.asList(signup), null, null, rateCatalogCodes, null, null));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSignups(session.getSignups(), null, null, rateCatalogCodes, null, null));
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
            return CollectionUtils.isNotEmpty(filterSignups(Arrays.asList(signup), null, null, null, null, offeringIds));
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        return CollectionUtils.isNotEmpty(filterSignups(session.getSignups(), null, null, null, null, offeringIds));
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
     * Sets a FeeManagementSession KeyPair specified by "key" to the unit number of signups with
     * "includedSignupOperations" minus "excludedSignupOperations"
     *
     * @param key                      KeyPair key
     * @param includedSignupOperations List of included signup operation values separated by ","
     * @param excludedSignupOperations List of excluded signup operation values separated by ","
     * @param context                  BRM context
     */
    @Override
    public void setSessionKeyPairToUnitNumber(String key,
                                              String includedSignupOperations,
                                              String excludedSignupOperations,
                                              BrmContext context) {
        int includedUnits = 0;
        int excludedUnits = 0;

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups = session.getSignups();

        if (CollectionUtils.isNotEmpty(signups)) {

            List<String> includedOperations = CommonUtils.split(includedSignupOperations, MULTI_VALUE_DELIMITER);
            List<String> excludedOperations = CommonUtils.split(excludedSignupOperations, MULTI_VALUE_DELIMITER);

            for (FeeManagementSignup signup : signups) {

                FeeManagementSignupOperation signupOperation = signup.getOperation();

                if (signupOperation != null && signup.getUnits() != null) {
                    if (includedOperations.contains(signupOperation.name())) {
                        includedUnits += signup.getUnits();
                    } else if (excludedOperations.contains(signupOperation.name())) {
                        excludedUnits += signup.getUnits();
                    }
                }
            }
        }

        setKeyPair(session, key, Integer.toString(includedUnits - excludedUnits));
    }

    /**
     * Sets a FeeManagementSession KeyPair specified by "key" to the unit number of signups on which a boolean method
     * specified by "signupBooleanMethod" method name returns true.
     * It throws IllegalArgumentException if the boolean method does not exist or returns a non-boolean value.
     *
     * @param key                 KeyPair key
     * @param signupBooleanMethod The name of the boolean method on FeeManagementSignup class.
     * @param context             BRM context
     * @throws IllegalArgumentException
     */
    @Override
    public void setSessionKeyPairToUnitNumberWithSignupMethod(String key, String signupBooleanMethod, BrmContext context) {

        try {

            int units = 0;

            FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

            Set<FeeManagementSignup> signups = session.getSignups();

            if (CollectionUtils.isNotEmpty(signups)) {

                Method method = FeeManagementSignup.class.getDeclaredMethod(signupBooleanMethod);

                Class<?> methodType = method.getReturnType();

                if (!Boolean.class.equals(methodType)) {
                    String errMsg = "The signup method must return a boolean value, actual type = " + methodType.getName();
                    logger.error(errMsg);
                    throw new IllegalArgumentException(errMsg);
                }

                for (FeeManagementSignup signup : signups) {
                    if (signup.getUnits() != null && (Boolean) method.invoke(signup)) {
                        units += signup.getUnits();
                    }
                }
            }

            setKeyPair(session, key, Integer.toString(units));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
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
    public void setPrecedingOfferingsComplete(boolean isComplete, String signupOperations, BrmContext context) {

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
    public void setPrecedingOfferingsTaken(boolean isTaken, String signupOperations, BrmContext context) {

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
     * @param rateCodes            List of rate codes separated by ","
     * @param rateTypeCodes        List of rate type codes separated by ","
     * @param rateCatalogCodes     List of rate catalog codes separated by ","
     * @param removeFromSignupOnly If true the rates will be removed from the signup only
     * @param context              BRM context
     */
    @Override
    public void removeRatesFromSignupAndPrecedingOfferings(String rateCodes,
                                                           String rateTypeCodes,
                                                           String rateCatalogCodes,
                                                           boolean removeFromSignupOnly,
                                                           BrmContext context) {

        FeeManagementSignup signup = getRequiredGlobalVariable(context, FM_SIGNUP_VAR_NAME);

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups =
                filterSignups(!removeFromSignupOnly ? session.getIncompleteSignups() : Arrays.asList(signup),
                        rateCodes, rateTypeCodes, rateCatalogCodes, null, signup.getOfferingId());

        if (CollectionUtils.isNotEmpty(signups)) {

            for (FeeManagementSignup fmSignup : signups) {

                Set<FeeManagementSignupRate> signupRates = fmSignup.getIncompleteSignupRates();

                if (CollectionUtils.isNotEmpty(signupRates)) {

                    for (FeeManagementSignupRate signupRate : new HashSet<FeeManagementSignupRate>(signupRates)) {

                        if (fmSignup.getEffectiveDate().compareTo(signup.getEffectiveDate()) <= 0) {

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

            if (!signup.isComplete()) {
                addRateToSignup(rate, signup);
            }

        } else {

            Set<FeeManagementSignup> signups = session.getIncompleteSignups();

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

            if (!signup.isComplete()) {
                replaceRateOnSignup(rate.getId(), newRate, signup);
            }

        } else {

            Set<FeeManagementSignup> signups = session.getIncompleteSignups();

            if (CollectionUtils.isNotEmpty(signups)) {

                for (FeeManagementSignup fmSignup : signups) {
                    replaceRateOnSignup(rate.getId(), newRate, fmSignup);
                }
            }
        }
    }

    /**
     * Charges rates on the signups from FeeManagementSession.
     *
     * @param rateCodes        List of rate codes separated by ","
     * @param rateSubCodes     List of rate sub-codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void chargeSignupRates(String rateCodes,
                                  String rateSubCodes,
                                  String rateTypeCodes,
                                  String rateCatalogCodes,
                                  BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementSignup> signups =
                filterSignups(session.getIncompleteSignups(), rateCodes, rateTypeCodes, rateCatalogCodes, null, null);

        // Map of [Rate ID, Date]
        Map<Long, Date> rateBaseDateMap = new HashMap<Long, Date>();

        // Map of [Rate ID, [Rate code, number of units]]
        Map<Long, Pair<String, Integer>> rateUnitsMap = new HashMap<Long, Pair<String, Integer>>();

        List<String> rateSubCodeValues = CommonUtils.split(rateSubCodes, MULTI_VALUE_DELIMITER);

        for (FeeManagementSignup signup : signups) {

            Set<FeeManagementSignupRate> signupRates = signup.getIncompleteSignupRates();

            if (CollectionUtils.isNotEmpty(signupRates)) {

                for (FeeManagementSignupRate signupRate : new HashSet<FeeManagementSignupRate>(signupRates)) {

                    Rate rate = signupRate.getRate();

                    boolean rateSubCodesComply = StringUtils.isEmpty(rateSubCodes) ||
                            matchesPatterns(rate.getSubCode(), rateSubCodeValues);

                    if (rateSubCodesComply) {

                        Date baseDate = rateBaseDateMap.get(rate.getId());

                        if (baseDate == null) {
                            baseDate = new Date(System.currentTimeMillis() * 1000000);
                        }

                        if (signup.getEffectiveDate().before(baseDate)) {
                            rateBaseDateMap.put(rate.getId(), signup.getEffectiveDate());
                        }

                        RateType rateType = rate.getRateType();

                        if (rateType != null && rateType.isGrouping()) {

                            Pair<String, Integer> rateCodeUnits = rateUnitsMap.get(rate.getId());

                            if (rateCodeUnits == null) {
                                rateCodeUnits = new Pair<String, Integer>(rate.getCode(), 0);
                                rateUnitsMap.put(rate.getId(), rateCodeUnits);
                            }

                            if (signup.getUnits() != null) {
                                rateCodeUnits.setB(rateCodeUnits.getB() + signup.getUnits());
                            }

                        } else {

                            int numberOfUnits = (signup.getUnits() != null) ? signup.getUnits() : 0;

                            BigDecimal amount = rateService.getAmountFromRate(rate.getId(), numberOfUnits);

                            Date effectiveDate = rateService.getEffectiveDateFromRate(rate.getId(), signup.getEffectiveDate());
                            Date recognitionDate = rateService.getRecognitionDateFromRate(rate.getId(), signup.getEffectiveDate());

                            String transactionTypeId = rateService.getTransactionTypeIdFromRate(rate.getId(), numberOfUnits);

                            FeeManagementManifest manifest = fmService.createFeeManagementManifest(
                                    FeeManagementManifestType.CHARGE,
                                    FeeManagementManifestStatus.PENDING,
                                    transactionTypeId,
                                    rate.getId(),
                                    null,
                                    signup.getRegistrationId(),
                                    signup.getOfferingId(),
                                    effectiveDate,
                                    recognitionDate,
                                    amount,
                                    true);

                            addManifestToSession(manifest, session);
                        }

                        signupRate.setComplete(true);

                        persistEntity(signupRate);
                    }
                }
            }

            if (CollectionUtils.isEmpty(signup.getIncompleteSignupRates())) {
                signup.setComplete(true);
                persistEntity(signup);
            }
        }

        // Creating Grouping Manifests
        for (Map.Entry<Long, Pair<String, Integer>> entry : rateUnitsMap.entrySet()) {

            Long rateId = entry.getKey();

            String rateCode = entry.getValue().getA();

            Integer numberOfUnits = entry.getValue().getB();

            BigDecimal amount = rateService.getAmountFromRate(rateId, numberOfUnits);

            Date effectiveDate = rateService.getEffectiveDateFromRate(rateId, rateBaseDateMap.get(rateId));
            Date recognitionDate = rateService.getRecognitionDateFromRate(rateId, rateBaseDateMap.get(rateId));

            String transactionTypeId = rateService.getTransactionTypeIdFromRate(rateId, numberOfUnits);

            FeeManagementManifest manifest = fmService.createFeeManagementManifest(
                    FeeManagementManifestType.CHARGE,
                    FeeManagementManifestStatus.PENDING,
                    transactionTypeId,
                    rateId,
                    rateCode,
                    null,
                    null,
                    effectiveDate,
                    recognitionDate,
                    amount,
                    true);

            addManifestToSession(manifest, session);
        }

        persistEntity(session);
    }

    /**
     * Charges the incidental rate on the FeeManagementSession.
     *
     * @param rateCode         List of rate codes separated by ","
     * @param rateSubCode      List of rate sub-codes separated by ","
     * @param internalChargeId Manifest internal charge ID
     * @param numberOfUnits    Number of units
     * @param amount           Manifest amount
     * @param context          BRM context
     */
    @Override
    public void chargeIncidentalRate(String rateCode,
                                     String rateSubCode,
                                     String internalChargeId,
                                     int numberOfUnits,
                                     BigDecimal amount,
                                     BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Rate rate = rateService.getRate(rateCode, rateSubCode, session.getAtpId());

        if (rate == null) {
            String errMsg = "Cannot find a rate for rateCode = " + rateCode + ", rateSubCode = " + rateSubCode +
                    ", ATP ID = " + session.getAtpId();
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (amount == null) {
            amount = rateService.getAmountFromRate(rate.getId(), numberOfUnits);
        }

        Date currentDate = new Date();

        Date effectiveDate = rateService.getEffectiveDateFromRate(rate.getId(), currentDate);
        Date recognitionDate = rateService.getRecognitionDateFromRate(rate.getId(), currentDate);

        String transactionTypeId = rateService.getTransactionTypeIdFromRate(rate.getId(), numberOfUnits);

        FeeManagementManifest manifest = fmService.createFeeManagementManifest(FeeManagementManifestType.CHARGE,
                FeeManagementManifestStatus.PENDING,
                transactionTypeId,
                rate.getId(),
                internalChargeId,
                null,
                null,
                effectiveDate,
                recognitionDate,
                amount,
                true);

        addManifestToSession(manifest, session);

        persistEntity(session);
    }


    /**
     * Adds tags to FM manifests filtering them by rate, rate type and catalog codes.
     *
     * @param tagCodes         List of tag codes separated by ","
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void addTagsToManifests(String tagCodes, String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            List<String> tagCodeValues = CommonUtils.split(tagCodes, MULTI_VALUE_DELIMITER);

            List<Tag> tags = getTagsByCodes(tagCodeValues);
            if (CollectionUtils.isEmpty(tags)) {
                String errMsg = "No tags found with codes: " + tagCodes;
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }

            Set<FeeManagementManifest> filteredManifests = filterManifests(manifests, rateCodes, rateTypeCodes, rateCatalogCodes);

            for (FeeManagementManifest manifest : filteredManifests) {
                addTagsToManifest(tags, manifest);
            }
        }

    }

    /**
     * Adds tags to FM manifests that have the specified internal charge ID.
     *
     * @param tagCodes         List of tag codes separated by ","
     * @param internalChargeId Manifest internal charge ID
     * @param context          BRM context
     */
    @Override
    public void addTagsToManifests(String tagCodes, String internalChargeId, BrmContext context) {

        if (StringUtils.isBlank(internalChargeId)) {
            String errMsg = "Internal charge ID must not be blank";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            List<String> tagCodeValues = CommonUtils.split(tagCodes, MULTI_VALUE_DELIMITER);

            List<Tag> tags = getTagsByCodes(tagCodeValues);
            if (CollectionUtils.isEmpty(tags)) {
                String errMsg = "No tags found with codes: " + tagCodes;
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }

            for (FeeManagementManifest manifest : manifests) {
                if (internalChargeId.equals(manifest.getInternalChargeId())) {
                    addTagsToManifest(tags, manifest);
                }
            }
        }
    }

    /**
     * Adds a rollup to FM manifests filtering them by rate, rate type and catalog codes.
     *
     * @param rollupCode       Rollup code
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void addRollupToManifests(String rollupCode, String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            Rollup rollup = getRollupByCode(rollupCode);

            if (rollup == null) {
                String errMsg = "Rollup with code = " + rollupCode + " does not exist";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }

            Set<FeeManagementManifest> filteredManifests = filterManifests(manifests, rateCodes, rateTypeCodes, rateCatalogCodes);

            for (FeeManagementManifest manifest : filteredManifests) {
                manifest.setRollup(rollup);
                persistEntity(manifest);
            }
        }
    }

    /**
     * Adds a rollup to FM manifests that have the specified internal charge ID.
     *
     * @param rollupCode       Rollup code
     * @param internalChargeId Manifest internal charge ID
     * @param context          BRM context
     */
    @Override
    public void addRollupToManifests(String rollupCode, String internalChargeId, BrmContext context) {

        if (StringUtils.isBlank(internalChargeId)) {
            String errMsg = "Internal charge ID must not be blank";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            Rollup rollup = getRollupByCode(rollupCode);

            if (rollup == null) {
                String errMsg = "Rollup with code = " + rollupCode + " does not exist";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }

            for (FeeManagementManifest manifest : manifests) {
                if (internalChargeId.equals(manifest.getInternalChargeId())) {
                    manifest.setRollup(rollup);
                    persistEntity(manifest);
                }
            }
        }
    }

    /**
     * Sets the effective date on FM manifests filtering them by rate, rate type and catalog codes.
     *
     * @param effectiveDate    Manifest effective date
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void setManifestEffectiveDate(String effectiveDate, String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            try {

                Date date = new SimpleDateFormat(Constants.DATE_FORMAT_US).parse(effectiveDate);

                Set<FeeManagementManifest> filteredManifests = filterManifests(manifests, rateCodes, rateTypeCodes, rateCatalogCodes);

                for (FeeManagementManifest manifest : filteredManifests) {
                    manifest.setEffectiveDate(date);
                    persistEntity(manifest);
                }

            } catch (ParseException pe) {
                logger.error(pe.getMessage(), pe);
                throw new RuntimeException(pe.getMessage(), pe);
            }
        }
    }

    /**
     * Sets the effective date on FM manifests that have the specified internal charge ID.
     *
     * @param effectiveDate    Manifest effective date
     * @param internalChargeId Manifest internal charge ID
     * @param context          BRM context
     */
    @Override
    public void setManifestEffectiveDate(String effectiveDate, String internalChargeId, BrmContext context) {

        if (StringUtils.isBlank(internalChargeId)) {
            String errMsg = "Internal charge ID must not be blank";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            try {

                Date date = new SimpleDateFormat(Constants.DATE_FORMAT_US).parse(effectiveDate);

                for (FeeManagementManifest manifest : manifests) {
                    if (internalChargeId.equals(manifest.getInternalChargeId())) {
                        manifest.setEffectiveDate(date);
                        persistEntity(manifest);
                    }
                }

            } catch (ParseException pe) {
                logger.error(pe.getMessage(), pe);
                throw new RuntimeException(pe.getMessage(), pe);
            }
        }
    }

    /**
     * Sets the recognition date on FM manifests filtering them by rate, rate type and catalog codes.
     *
     * @param recognitionDate  Manifest recognition date
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void setManifestRecognitionDate(String recognitionDate, String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            try {

                Date date = new SimpleDateFormat(Constants.DATE_FORMAT_US).parse(recognitionDate);

                Set<FeeManagementManifest> filteredManifests = filterManifests(manifests, rateCodes, rateTypeCodes, rateCatalogCodes);

                for (FeeManagementManifest manifest : filteredManifests) {
                    manifest.setRecognitionDate(date);
                    persistEntity(manifest);
                }

            } catch (ParseException pe) {
                logger.error(pe.getMessage(), pe);
                throw new RuntimeException(pe.getMessage(), pe);
            }
        }
    }

    /**
     * Sets the recognition date on FM manifests that have the specified internal charge ID.
     *
     * @param recognitionDate  Manifest recognition date
     * @param internalChargeId Manifest internal charge ID
     * @param context          BRM context
     */
    @Override
    public void setManifestRecognitionDate(String recognitionDate, String internalChargeId, BrmContext context) {

        if (StringUtils.isBlank(internalChargeId)) {
            String errMsg = "Internal charge ID must not be blank";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            try {

                Date date = new SimpleDateFormat(Constants.DATE_FORMAT_US).parse(recognitionDate);

                for (FeeManagementManifest manifest : manifests) {
                    if (internalChargeId.equals(manifest.getInternalChargeId())) {
                        manifest.setRecognitionDate(date);
                        persistEntity(manifest);
                    }
                }

            } catch (ParseException pe) {
                logger.error(pe.getMessage(), pe);
                throw new RuntimeException(pe.getMessage(), pe);
            }
        }
    }

    /**
     * Sets the GL account ID on FM manifests filtering them by rate, rate type and catalog codes.
     *
     * @param glAccountId      Manifest GL Account ID
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void setManifestGlAccount(String glAccountId, String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            Set<FeeManagementManifest> filteredManifests = filterManifests(manifests, rateCodes, rateTypeCodes, rateCatalogCodes);

            for (FeeManagementManifest manifest : filteredManifests) {

                Set<ManifestGlBreakdownOverride> glBreakdownOverrides = manifest.getGlBreakdownOverrides();

                if (CollectionUtils.isNotEmpty(glBreakdownOverrides)) {
                    for (ManifestGlBreakdownOverride glBreakdownOverride : glBreakdownOverrides) {
                        glBreakdownOverride.setGlAccount(glAccountId);
                        persistEntity(glBreakdownOverride);
                    }
                }
            }
        }
    }

    /**
     * Sets the GL account on FM manifests that have the specified internal charge ID.
     *
     * @param glAccountId      Manifest GL Account ID
     * @param internalChargeId Manifest internal charge ID
     * @param context          BRM context
     */
    @Override
    public void setManifestGlAccount(String glAccountId, String internalChargeId, BrmContext context) {

        if (StringUtils.isBlank(internalChargeId)) {
            String errMsg = "Internal charge ID must not be blank";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            for (FeeManagementManifest manifest : manifests) {

                if (internalChargeId.equals(manifest.getInternalChargeId())) {

                    Set<ManifestGlBreakdownOverride> glBreakdownOverrides = manifest.getGlBreakdownOverrides();

                    if (CollectionUtils.isNotEmpty(glBreakdownOverrides)) {
                        for (ManifestGlBreakdownOverride glBreakdownOverride : glBreakdownOverrides) {
                            glBreakdownOverride.setGlAccount(glAccountId);
                            persistEntity(glBreakdownOverride);
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the amount on FM manifests filtering them by rate, rate type and catalog codes.
     *
     * @param amount           Manifest amount
     * @param rateCodes        List of rate codes separated by ","
     * @param rateTypeCodes    List of rate type codes separated by ","
     * @param rateCatalogCodes List of rate catalog codes separated by ","
     * @param context          BRM context
     */
    @Override
    public void setManifestAmount(BigDecimal amount, String rateCodes, String rateTypeCodes, String rateCatalogCodes, BrmContext context) {

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            Set<FeeManagementManifest> filteredManifests = filterManifests(manifests, rateCodes, rateTypeCodes, rateCatalogCodes);

            for (FeeManagementManifest manifest : filteredManifests) {
                manifest.setAmount(amount);
                persistEntity(manifest);
            }
        }
    }

    /**
     * Sets the amount on FM manifests that have the specified internal charge ID.
     *
     * @param amount           Manifest amount
     * @param internalChargeId Manifest internal charge ID
     * @param context          BRM context
     */
    @Override
    public void setManifestAmount(BigDecimal amount, String internalChargeId, BrmContext context) {

        if (StringUtils.isBlank(internalChargeId)) {
            String errMsg = "Internal charge ID must not be blank";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeManagementSession session = getRequiredGlobalVariable(context, FM_SESSION_VAR_NAME);

        Set<FeeManagementManifest> manifests = session.getManifests();

        if (CollectionUtils.isNotEmpty(manifests)) {

            for (FeeManagementManifest manifest : manifests) {
                if (internalChargeId.equals(manifest.getInternalChargeId())) {
                    manifest.setAmount(amount);
                    persistEntity(manifest);
                }
            }
        }
    }


}
