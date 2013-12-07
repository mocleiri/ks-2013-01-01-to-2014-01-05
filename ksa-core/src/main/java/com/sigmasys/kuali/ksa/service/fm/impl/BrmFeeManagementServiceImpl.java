package com.sigmasys.kuali.ksa.service.fm.impl;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.fm.*;
import com.sigmasys.kuali.ksa.service.InformationService;
import com.sigmasys.kuali.ksa.service.KeyPairService;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;
import com.sigmasys.kuali.ksa.service.brm.BrmMethodInterceptor;
import com.sigmasys.kuali.ksa.service.fm.BrmFeeManagementService;
import com.sigmasys.kuali.ksa.service.impl.GenericPersistenceService;
import com.sigmasys.kuali.ksa.util.CommonUtils;
import org.aopalliance.aop.Advice;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


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

    // Relational operators
    private static final String EQUAL_OPERATOR = "=";
    private static final String UNEQUAL_OPERATOR = "!=";
    private static final String GREATER_OPERATOR = ">";
    private static final String LESS_OPERATOR = "<";
    private static final String GREATER_EQUAL_OPERATOR = ">=";
    private static final String LESS_EQUAL_OPERATOR = "<=";

    // Global variable names
    private static final String FM_SESSION_VAR_NAME = "fmSession";
    private static final String FM_SIGNUP_VAR_NAME = "fmSignup";


    @Autowired
    private KeyPairService keyPairService;

    @Autowired
    private InformationService informationService;


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

    private <T> T getNonNullGlobalVariable(BrmContext context, String variableName) {
        T variable = getGlobalVariable(context, variableName);
        if (variable == null) {
            String errMsg = "Global variable '" + variableName + "' has not been found";
            logger.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return variable;
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
        FeeManagementSession session = getNonNullGlobalVariable(context, FM_SESSION_VAR_NAME);
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

        FeeManagementSession session = getNonNullGlobalVariable(context, FM_SESSION_VAR_NAME);

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
        }

        FeeManagementSession session = getNonNullGlobalVariable(context, FM_SESSION_VAR_NAME);

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
        FeeManagementSession session = getNonNullGlobalVariable(context, FM_SESSION_VAR_NAME);
        setKeyPair(session, key, value);
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
        FeeManagementSession session = getNonNullGlobalVariable(context, FM_SESSION_VAR_NAME);
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
    public boolean accountHasFlag(String flagTypeCode, int severity, String operator, BrmContext context) {
        List<Flag> flags = informationService.getFlags(context.getAccount().getId());
        if (CollectionUtils.isNotEmpty(flags)) {
            for (Flag flag : flags) {
                if (flag.getType().getCode().equals(flagTypeCode)) {
                    Integer flagSeverity = flag.getSeverity();
                    if (flagSeverity != null && compareObjects(flagSeverity, severity, operator)) {
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
        // TODO
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
        // TODO
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
        // TODO
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
        // TODO
        return false;
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
        // TODO
        return false;
    }


    /**
     * Checks if the current signup in the context is taken.
     *
     * @param context BRM context
     * @return boolean value
     */
    @Override
    public boolean signupIsTaken(BrmContext context) {
        // TODO
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
        // TODO
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
        // TODO
        return false;
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
        // TODO
        return false;
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
        // TODO
        return false;
    }


    // TODO

}
