package com.sigmasys.kuali.ksa.service.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.sigmasys.kuali.ksa.exception.UserNotFoundException;
import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.service.AccountService;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.service.TransactionService;
import com.sigmasys.kuali.ksa.service.brm.BrmContext;
import com.sigmasys.kuali.ksa.service.brm.BrmService;
import com.sigmasys.kuali.ksa.util.BeanUtils;
import com.sigmasys.kuali.ksa.util.CalendarUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigmasys.kuali.ksa.service.FeeManagementService;

@Deprecated
@Service("feeManagementService")
@Transactional(timeout = 600)
@SuppressWarnings("unchecked")
public class FeeManagementServiceImpl extends GenericPersistenceService implements FeeManagementService {

    /**
     * The logger.
     */
    private static final Log logger = LogFactory.getLog(FeeManagementServiceImpl.class);

    /**
     * Used in rules to separate multiple pattern items from each other
     */
    private static final String PATTERN_DELIMITER = ",";

    /**
     * ThreadLocal variable for the LearningPeriod currently used for Fee Assessment.
     */
    private static final ThreadLocal<LearningPeriod> currentPeriod = new ThreadLocal<LearningPeriod>();


    @Autowired
    private AuditableEntityService entityService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private BrmService brmService;


    /**
     * Performs all the necessary operations to calculate fees for the given account.
     * Most of this logic is usually performed by a rule engine (Drools).
     *
     * @param accountId Account ID
     */
    @Override
    public void assessFees(String accountId) {

        // Getting the fee base for the user
        FeeBase feeBase = getFeeBase(accountId);

        BrmContext brmContext = new BrmContext();
        brmContext.setAccount(feeBase.getAccount());

        Map<String, Object> globalParams = new HashMap<String, Object>();
        globalParams.put("feeBase", feeBase);

        brmContext.setGlobalVariables(globalParams);

        brmService.fireRules(Constants.DROOLS_FM_RULE_SET_NAME, brmContext);
    }


    /**
     * Returns an account's Set of student data in form of KeyPair objects.
     *
     * @param accountId Id of an account for which to get its student data.
     * @return Account's student data.
     */
    @Override
    public List<DeprecatedKeyPair> getStudentData(String accountId) {
        return findKeyPairs(accountId, DeprecatedKeyPair.class, KeyPairType.KEY_PAIR);
    }

    /**
     * Returns an account's Set of learning period data in form of PeriodKeyPair objects.
     *
     * @param accountId Id of an account for which to get its learning period data.
     * @return Account's learning period data.
     */
    @Override
    public List<PeriodKeyPair> getLearningPeriodData(String accountId) {
        return findKeyPairs(accountId, PeriodKeyPair.class, KeyPairType.PERIOD_KEY_PAIR);
    }

    /**
     * Returns an account's study data in form of PeriodKeyPair objects.
     *
     * @param accountId Id of an account for which to get its study data.
     * @return Account's study data.
     */
    @Override
    public List<LearningUnit> getLearningUnits(String accountId) {
        // Find associated LearningUnits using a query by a foreign key in the LearningUnit table:
        String sql = "select lu from LearningUnit lu where lu.account.id = :accountId";
        Query query = em.createQuery(sql).setParameter("accountId", accountId);
        return query.getResultList();
    }

    /**
     * Returns a {@link FeeBase} object containing all information necessary for a
     * fee assessment process for an account.
     *
     * @param accountId Id of an account for which to retrieve its fee assessment data.
     * @return FeeBase An object containing all account's fee assessment data.
     */
    @Override
    public FeeBase getFeeBase(String accountId) {

        // Retrieve the Account and other data:
        Account account = accountService.getFullAccount(accountId);
        if (account == null) {
            String errMsg = "Account with ID = " + accountId + " does not exist";
            logger.error(errMsg);
            throw new UserNotFoundException(errMsg);
        }

        List<DeprecatedKeyPair> studentData = getStudentData(accountId);
        List<PeriodKeyPair> periodData = getLearningPeriodData(accountId);
        List<LearningUnit> study = getLearningUnits(accountId);

        // Build the resulting object:
        FeeBase feeBase = new FeeBase();

        feeBase.setAccount(account);
        feeBase.setStudentData(studentData);
        feeBase.setPeriodData(periodData);
        feeBase.setLearningUnits(study);

        return feeBase;
    }

    @Override
    public BigDecimal calculateFees(FeeBase feeBase, LearningPeriod period) {
        // Set the current period:
        currentPeriod.set(period);

        // TODO: Perform fee calculation for the given period


        // Remove the current period:
        currentPeriod.remove();

        return new BigDecimal(0);
    }

    /**
     * Calculates the total payment amount for the given amount of credits not to exceed
     * the maximum amount <code>maxAmount</code>. If <code>maxAmount</code> is equal to <code>-1</code>,
     * there is no total amount limit.
     *
     * @param numOfCredits    Amount of credits.
     * @param amountPerCredit Cost of each credit.
     * @param maxAmount       Maximum total payment cap.
     * @return The total payment limited by <code>maxAmount</code> or the total amount if <code>maxAmount</code> is <code>-1</code>.
     */
    @Override
    public BigDecimal calculateChargeByCreditToMax(int numOfCredits, BigDecimal amountPerCredit, BigDecimal maxAmount) {
        // Validate the input:
        if ((amountPerCredit == null) || (maxAmount == null)) {
            throw new IllegalArgumentException("Amount Per Credit and Max Amount cannot be null.");
        }

        BigDecimal totalCharge = amountPerCredit.multiply(new BigDecimal(numOfCredits));

        return (maxAmount.doubleValue() < 0d) ? totalCharge : totalCharge.min(maxAmount);
    }

    /**
     * Creates a new <code>KeyPair</code> object for the specified <code>FeeBase</code>
     *
     * @param feeBase A <code>FeeBase</code> object associated with an account.
     * @param name    Name of the new <code>KeyPair</code>.
     * @param value   Value of the new <code>KeyPair</code>.
     * @return The newly created <code>KeyPair</code>.
     */
    @Override
    public DeprecatedKeyPair createKeyPair(FeeBase feeBase, String name, String value) {
        return createFeeBaseKeyPairInternal(feeBase, name, value, null, DeprecatedKeyPair.class);
    }

    /**
     * Creates a new <code>KeyPair</code> object for the specified <code>FeeBase</code>
     *
     * @param feeBase A <code>FeeBase</code> object associated with an account.
     * @param name    Name of the new <code>KeyPair</code>.
     * @param value   Value of the new <code>KeyPair</code>.
     * @param period  The learning period.
     * @return The newly created <code>KeyPair</code>.
     */
    @Override
    public PeriodKeyPair createKeyPair(FeeBase feeBase, String name, String value, LearningPeriod period) {
        return createFeeBaseKeyPairInternal(feeBase, name, value, period, PeriodKeyPair.class);
    }

    /**
     * Creates a new <code>KeyPair</code> object for the specified <code>LearningUnit</code>
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         Name of the new <code>KeyPair</code>.
     * @param value        Value of the new <code>KeyPair</code>.
     * @return The newly created <code>KeyPair</code>.
     */
    @Override
    public DeprecatedKeyPair setKeyPair(LearningUnit learningUnit, String name, String value) {

        // Validate the input:
        validateInputParameters(learningUnit, name, value);
        //validateKeyPairNameUnique(learningUnit, name);

        try {

            // Create and persist a new KeyPair:
            DeprecatedKeyPair newKeyPair = setKeyPairInternal(name, value, null, DeprecatedKeyPair.class);

            // Add the new KeyPair to the LearningUnit's set of KeyPairs if it does not already exist there
            Set<DeprecatedKeyPair> keyPairs = learningUnit.getKeyPairs();
            if (keyPairs != null) {
                if (keyPairs.contains(newKeyPair)) {
                    keyPairs.remove(newKeyPair);
                }
                keyPairs.add(newKeyPair);
            }

            // Update the associations:
            persistEntity(learningUnit);

            // Flush the EM to the persistent storage:
            em.flush();

            return newKeyPair;

        } catch (Throwable t) {
            // Log error:
            String errMsg = "Error creating a KeyPair for a LearningPeriod: " + t.getMessage();
            logger.error(errMsg, t);

            // Re-throw the error:
            throw new RuntimeException(errMsg, t);
        }
    }

    /**
     * Returns the value of a <code>KeyPair</code> with the specified name within the given <code>FeeBase</code>.
     * Returns <code>null</code> if there is such <code>KeyPair</code> with the given name in the specified <code>FeeBase</code>.
     *
     * @param feeBase A <code>FeeBase</code> object associated with an account.
     * @param name    Name of a <code>KeyPair</code> which value to retrieve.
     * @return The value of a <code>KeyPair</code> with the given name in the specified <code>FeeBase</code>
     *         or <code>null</code> is such a name does not exist.
     */
    @Override
    public String getKeyPairValue(FeeBase feeBase, String name) {
        // Validate the input:
        validateInputParameters(feeBase, name);

        // Try to find a KeyPair in the StudentData:
        DeprecatedKeyPair keyPair = getKeyPairInternal(feeBase.getStudentData(), name);

        // If not found, try to find in PeriodData:
        if (keyPair == null) {
            keyPair = getKeyPairInternal(feeBase.getPeriodData(), name);
        }

        return (keyPair != null) ? keyPair.getValue() : null;
    }

    /**
     * Returns the value of a <code>KeyPair</code> with the specified name within the given <code>LearningUnit</code>.
     * Returns <code>null</code> if there is such <code>KeyPair</code> with the given name in the specified <code>FeeBase</code>.
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         Name of a <code>KeyPair</code> which value to retrieve.
     * @return The value of a <code>KeyPair</code> with the given name in the specified <code>LearningUnit</code>
     *         or <code>null</code> is such a name does not exist.
     */
    @Override
    public String getKeyPairValue(LearningUnit learningUnit, String name) {
        // Validate the input:
        validateInputParameters(learningUnit, name);

        // Merge the entity to attach it to the persistent context if it is detached:
        if (!em.contains(learningUnit)) {
            learningUnit = em.merge(learningUnit);
        }

        // Iterate through the "extended" attribute of the "learningUnit"
        // to find the one that has the "name" attribute equals to the argument:
        for (DeprecatedKeyPair keyPair : learningUnit.getKeyPairs()) {
            if (StringUtils.equalsIgnoreCase(keyPair.getName(), name)) {
                return keyPair.getValue();
            }
        }

        return null;
    }

    /**
     * Updates the <code>KeyPair</code> with the specified name with a new value.
     *
     * @param feeBase  A <code>FeeBase</code> object.
     * @param name     <code>KeyPair</code> name.
     * @param newValue The new <code>KeyPair</code> value.
     */
    @Override
    public void updateKeyPair(FeeBase feeBase, String name, String newValue) {
        // Validate the input:
        validateInputParameters(feeBase, name, newValue, null, DeprecatedKeyPair.class);

        // Update the KeyPair value:
        updateKeyPairInternal(feeBase.getStudentData(), name, newValue, null, DeprecatedKeyPair.class);
    }

    /**
     * Updates the <code>PeriodKeyPair</code> with the specified name with a new value and/or a new <code>LearningPeriod</code>.
     * If either <code>newValue</code> or <code>newPeriod</code> is <code>null</code>, it's not updated.
     *
     * @param feeBase   A <code>FeeBase</code> object.
     * @param name      <code>PeriodKeyPair</code> name.
     * @param newValue  New <code>PeriodKeyPair</code> value.
     * @param newPeriod New <code>Learning</code> period.
     */
    @Override
    public void updateKeyPair(FeeBase feeBase, String name, String newValue, LearningPeriod newPeriod) {
        // Validate the input:
        validateInputParameters(feeBase, name, newValue, newPeriod, PeriodKeyPair.class);

        // Update the KeyPair value:
        updateKeyPairInternal(feeBase.getPeriodData(), name, newValue, newPeriod, PeriodKeyPair.class);
    }

    /**
     * Updates the <code>KeyPair</code> with the specified name with a new value.
     *
     * @param learningUnit A <code>LearningUnit</code> instance.
     * @param name         <code>KeyPair</code> name.
     * @param newValue     The new <code>KeyPair</code> value.
     */
    @Override
    public void updateKeyPair(LearningUnit learningUnit, String name, String newValue) {
        // Validate the input:
        validateInputParameters(learningUnit, name, newValue);

        // Update the KeyPair value:
        updateKeyPairInternal(learningUnit.getKeyPairs(), name, newValue, null, DeprecatedKeyPair.class);
    }

    /**
     * Removes a <code>KeyPair</code> with the specified name from a <code>FeeBase</code>.
     *
     * @param feeBase A <code>FeeBase</code> object.
     * @param name    <code>KeyPair</code> name.
     */
    @Override
    public void removeKeyPair(FeeBase feeBase, String name) {
        // Validate the input:
        validateInputParameters(feeBase, name);

        // Find the KeyPair to remove in "studentData":
        List<? extends DeprecatedKeyPair> removeFrom = feeBase.getStudentData();
        DeprecatedKeyPair removeKeyPair = getKeyPairInternal(removeFrom, name);

        // If not found in the "studentData", find in the "periodData":
        if (removeKeyPair == null) {
            removeFrom = feeBase.getPeriodData();
            removeKeyPair = getKeyPairInternal(removeFrom, name);
        }

        // If a KeyPair was found and removed, delete the entity and disassociate the Account and KeyPair:
        if (removeKeyPair != null) {
            try {
                // Delete the entity:
                em.remove(removeKeyPair);

                // Remove the association record:
                removeKeyPairAssociationRecord(feeBase.getAccount(), removeKeyPair);

                // Flush the EM to the persistent storage:
                em.flush();

                // Remove from the Collection:
                removeFrom.remove(removeKeyPair);
            } catch (Throwable t) {
                // Log error:
                logger.error("Error removing KeyPair.", t);

                // Re-throw the error:
                throw new RuntimeException(t);
            }
        }
    }

    /**
     * Removes a <code>KeyPair</code> with the specified name from a LearningUnit</code>.
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         <code>KeyPair</code> name.
     */
    @Override
    public void removeKeyPair(LearningUnit learningUnit, String name) {
        // Validate input:
        validateInputParameters(learningUnit, name);

        // Remove the KeyPair with the given name from the "extended" Set:
        removeKeyPairInternal(learningUnit.getKeyPairs(), name);

        // Update the persistent context:
        persistEntity(learningUnit);
    }

    /**
     * Checks if the given FeeBase contains a KeyPair or its subtype with the given name.
     *
     * @param feeBase A FeeBase to check.
     * @param name    Name of a KeyPair to locate within the FeeBase.
     * @return <code>true</code> if a KeyPair or its subtype with the given name exists within the specified FeeBase.
     *         Returns <code>false</code> otherwise.
     */
    @Override
    public boolean containsKeyPair(FeeBase feeBase, String name) {
        // Validate input:
        validateInputParameters(feeBase, name);

        return containsKeyPairInternal(feeBase.getStudentData(), name)
                || containsKeyPairInternal(feeBase.getPeriodData(), name);
    }

    /**
     * Checks if the given LearningUnit contains a KeyPair or its subtype with the given name.
     *
     * @param learningUnit A LearningUnit to check.
     * @param name         Name of a KeyPair to locate within the LearningUnit.
     * @return <code>true</code> if a KeyPair with the given name exists within the specified LearningUnit.
     *         Returns <code>false</code> otherwise.
     */
    @Override
    public boolean containsKeyPair(LearningUnit learningUnit, String name) {
        // Validate input:
        validateInputParameters(learningUnit, name);

        return containsKeyPairInternal(learningUnit.getKeyPairs(), name);
    }

    /**
     * Saves a <code>LearningUnit</code>. This method is helpful when making modifications to a <code>LearningUnit</code>, such as setting new Status,
     * changing details, such as Campus, Add Date, Drop Date, etc.
     *
     * @param learningUnit A <code>LearningUnit</code> to be updated.
     * @returns The entity that was attached to the persistent context.
     */
    @Override
    public void persistLearningUnit(LearningUnit learningUnit) {
        // Validate input:
        validateInputParameters(learningUnit);

        // Persist the entity
        persistEntity(learningUnit);
    }

    /**
     * Returns the period that the rules are currently working on.
     *
     * @return The period that the rules are currently working on.
     */
    @Override
    public LearningPeriod getCurrentPeriod() {
        return currentPeriod.get();
    }

    /**
     * Finds all <code>LearningPeriod</code>s that fall into the specified date range.
     *
     * @param dateFrom Beginning of the search date range.
     * @param dateTo   End of the search date range.
     * @return All <code>LearningPeriod</code> objects that fall into the given date range.
     */
    @Override
    public List<LearningPeriod> findLearningPeriods(Date dateFrom, Date dateTo) {
        // Create a Query:
        Query query = em.createQuery("select lp from LearningPeriod lp where lp.startDate >= :dateFrom " +
                " and lp.endDate <= :dateTo");

        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateTo);

        return query.getResultList();
    }

    /**
     * Attempts to find a <code>LearningPeriod</code> with the specified name.
     * Returns <code>null</code> if no such <code>LearningPeriod</code> is found.
     * This method performs CASE-INSENSITIVE search.
     *
     * @param name Name of a <code>LearningPeriod</code> to locate.
     * @return <code>LearningPeriod</code> with the given name or <code>null</code> if none found.
     */
    @Override
    public LearningPeriod getLearningPeriod(String name) {
        // Create a Query:
        Query query = em.createQuery("select lp from LearningPeriod lp where UPPER(lp.name) = :name")
                .setParameter("name", name.toUpperCase())
                .setMaxResults(1);
        List<LearningPeriod> result = query.getResultList();

        return CollectionUtils.isEmpty(result) ? null : result.get(0);
    }

    /**
     * Returns the major course codes. This includes the major and the second major courses
     * from a students's profile.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return Major course codes.
     */
    @Override
    public List<String> getMajorCodes(FeeBase feeBase) {
        List<String> majorCodes = new LinkedList<String>();
        String majorCourseCode = getKeyPairValue(feeBase, "program-of-study-major");
        if (majorCourseCode != null) {
            majorCodes.add(majorCourseCode.toUpperCase());
        }
        String secondMajorCourseCode = getKeyPairValue(feeBase, "program-of-study-second-major");
        if (secondMajorCourseCode != null) {
            majorCodes.add(secondMajorCourseCode.toUpperCase());
        }

        return majorCodes;
    }

    /**
     * Check the existence of at least one of the given major codes in a <code>FeeBase</code> object.
     *
     * @param majorCodes a list of major codes represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one major code, <code>false</code> - otherwise.
     */
    @Override
    public boolean containsMajorCode(FeeBase feeBase, String majorCodes) {
        return matchOneOrMoreValues(majorCodes, getMajorCodes(feeBase));
    }

    /**
     * Returns the codes of all classes taken by a student.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return All study course codes.
     */
    @Override
    public List<String> getLearningUnitCodes(FeeBase feeBase) {
        return getLearningUnitCodes(feeBase, (String[]) null);
    }

    private Set<String> toSet(String... items) {
        Set<String> itemSet = new HashSet<String>();
        if (items != null) {
            for (String item : items) {
                if (item != null) {
                    itemSet.add(item.trim());
                }
            }
        }
        return itemSet;
    }

    /**
     * Returns the codes of all classes taken by a student for the given set of LU statuses.
     *
     * @param feeBase  A <code>FeeBase</code> that contains a student's information.
     * @param statuses A <code>java.util.String</code> array of statuses
     * @return All study course codes.
     */
    @Override
    public List<String> getLearningUnitCodes(FeeBase feeBase, String... statuses) {
        Set<String> statusSet = toSet(statuses);
        List<String> studyCodes = new LinkedList<String>();
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            String luUnitCode = lu.getUnitCode();
            String luStatus = lu.getStatus();
            if (luUnitCode != null && (statusSet.isEmpty() || (luStatus != null && statusSet.contains(luStatus)))) {
                studyCodes.add(luUnitCode.toUpperCase());
            }
        }
        return studyCodes;
    }

    /**
     * Returns the LU section codes of all classes taken by a student for the given set of LU statuses.
     *
     * @param feeBase  A <code>FeeBase</code> that contains a student's information.
     * @param statuses A <code>java.util.String</code> array of statuses
     * @return All study course codes.
     */
    @Override
    public List<String> getSectionCodes(FeeBase feeBase, String... statuses) {
        Set<String> statusSet = toSet(statuses);
        List<String> sectionCodes = new LinkedList<String>();
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            String luSectionCode = lu.getUnitSection();
            String luStatus = lu.getStatus();
            if (luSectionCode != null && (statusSet.isEmpty() || (luStatus != null && statusSet.contains(luStatus)))) {
                sectionCodes.add(luSectionCode.toUpperCase());
            }
        }
        return sectionCodes;
    }

    /**
     * Check the existence of at least one of the given LU section codes in a <code>FeeBase</code> object.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCodes a list of section codes represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    @Override
    public boolean containsSectionCode(FeeBase feeBase, String sectionCodes) {
        return containsSectionCode(feeBase, sectionCodes, null);
    }

    /**
     * Check the existence of at least one of the given LU section codes in a <code>FeeBase</code> object.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCodes a list of section codes represented by a <code>String</code> value and separated by commas.
     * @param statuses     a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    @Override
    public boolean containsSectionCode(FeeBase feeBase, String sectionCodes, String statuses) {
        String[] statusArray = (statuses != null && statuses.trim().length() > 0) ? statuses.split(PATTERN_DELIMITER) : null;
        return matchOneOrMoreValues(sectionCodes, getSectionCodes(feeBase, statusArray));
    }


    /**
     * Check the existence of at least one of the given LU codes in a <code>FeeBase</code> object.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param learningUnitCodes a list of LU codes represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    @Override
    public boolean containsLearningUnitCode(FeeBase feeBase, String learningUnitCodes) {
        return containsLearningUnitCode(feeBase, learningUnitCodes, null);
    }

    /**
     * Check the existence of at least one of the given LU codes in a <code>FeeBase</code> object.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param learningUnitCodes a list of LU codes represented by a <code>String</code> value and separated by commas.
     * @param statuses          a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    @Override
    public boolean containsLearningUnitCode(FeeBase feeBase, String learningUnitCodes, String statuses) {
        String[] statusArray = (statuses != null && statuses.trim().length() > 0) ? statuses.split(PATTERN_DELIMITER) : null;
        return matchOneOrMoreValues(learningUnitCodes, getLearningUnitCodes(feeBase, statusArray));
    }


    /**
     * Checks if a KeyPair exists in the given <code>FeeBase</code>
     *
     * @param feeBase       A <code>FeeBase</code> that contains a student's information.
     * @param keyPairName   The name of a <code>KeyPair</code> to check.
     * @param keyPairValues The values of a <code>KeyPair</code> to check represented by a <code>String</code> and
     *                      separated by commas
     * @return <code>true</code> if a KeyPair exists, <code>false</code> - otherwise
     */
    @Override
    public boolean containsKeyPair(FeeBase feeBase, String keyPairName, String keyPairValues) {
        return matchOneOrMoreValues(keyPairValues, getKeyPairValue(feeBase, keyPairName));
    }


    /**
     * Checks if a student is a resident.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return <code>true</code> if a student is a resident, <code>false</code> otherwise.
     */
    @Override
    public boolean isResident(FeeBase feeBase) {
        String kpValue = getKeyPairValue(feeBase, "residency");

        return StringUtils.equalsIgnoreCase(kpValue, "TRUE")
                || StringUtils.equalsIgnoreCase(kpValue, "T")
                || StringUtils.equalsIgnoreCase(kpValue, "Y");
    }

    /**
     * Checks if a student is a graduate.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return <code>true</code> if a student is a graduate, <code>false</code> otherwise.
     */
    @Override
    public boolean isGraduate(FeeBase feeBase) {
        String levelOfStudy = getKeyPairValue(feeBase, "level-of-study");

        return StringUtils.equalsIgnoreCase(levelOfStudy, "MASTERS")
                || StringUtils.equalsIgnoreCase(levelOfStudy, "PHD");
    }

    /**
     * Sets a course's status and saves it.
     *
     * @param learningUnit A study course.
     * @param status       The new course status.
     */
    @Override
    public void setCourseStatus(LearningUnit learningUnit, String status) {
        // Set the new status:
        learningUnit.setStatus(status);

        // Save the LearningUnit:
        persistLearningUnit(learningUnit);
    }


    /**
     * Sets a course's status and add a <code>KeyPair</code> with the specified name and value.
     *
     * @param learningUnit A study course.
     * @param status       The new course status.
     * @param keyPairName  The name of a <code>KeyPair</code> to add.
     * @param keyPairValue The value of a <code>KeyPair</code> to add.
     */
    @Override
    public void setCourseStatus(LearningUnit learningUnit, String status, String keyPairName, String keyPairValue) {
        // Set the course's status:
        setCourseStatus(learningUnit, status);

        // Add a KeyPair:
        setKeyPair(learningUnit, keyPairName, keyPairValue);
    }

    /**
     * Sets a course's status and add a <code>KeyPair</code> with the specified name and value to all LUs for
     * the given FeeBase and LU code.
     *
     * @param feeBase       A <code>FeeBase</code> that contains a student's information.
     * @param luCodePattern A LU code or a regular expression.
     * @param status        The new course status.
     * @param keyPairName   The name of a <code>KeyPair</code> to add.
     * @param keyPairValue  The value of a <code>KeyPair</code> to add.
     */
    @Override
    public void setCourseStatusForLearningUnits(FeeBase feeBase, String luCodePattern, String status,
                                                String keyPairName, String keyPairValue) {
        Set<LearningUnit> learningUnits = new HashSet<LearningUnit>();
        for (String luCode : getLearningUnitCodes(feeBase)) {
            if (luCodePattern.equals(luCode) || Pattern.matches(luCodePattern, luCode)) {
                learningUnits.add(feeBase.getLearningUnit(luCode));
            }
        }
        for (LearningUnit learningUnit : learningUnits) {
            setCourseStatus(learningUnit, status, keyPairName, keyPairValue);
        }
    }

    /**
     * Sets a course's status and add a <code>KeyPair</code> with the specified name and value to all LUs for
     * the given FeeBase and section code.
     *
     * @param feeBase        A <code>FeeBase</code> that contains a student's information.
     * @param sectionPattern A LU section code or a regular expressions
     * @param status         The new course status.
     * @param keyPairName    The name of a <code>KeyPair</code> to add.
     * @param keyPairValue   The value of a <code>KeyPair</code> to add.
     */
    @Override
    public void setCourseStatusForSections(FeeBase feeBase, String sectionPattern, String status, String keyPairName, String keyPairValue) {
        Set<LearningUnit> learningUnits = new HashSet<LearningUnit>();
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            String sectionCode = lu.getUnitSection();
            if (sectionCode != null && (sectionCode.equals(sectionPattern) || Pattern.matches(sectionPattern, sectionCode))) {
                learningUnits.addAll(feeBase.getLearningUnitsBySectionCode(sectionCode));
            }
        }
        for (LearningUnit learningUnit : learningUnits) {
            setCourseStatus(learningUnit, status, keyPairName, keyPairValue);
        }
    }

    /**
     * Sets a course's new status and add a <code>KeyPair</code> with the specified name and value to all LUs for
     * the given FeeBase and old status.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param oldStatus    The old course status.
     * @param newStatus    The new course status.
     * @param keyPairName  The name of a <code>KeyPair</code> to add.
     * @param keyPairValue The value of a <code>KeyPair</code> to add.
     */
    @Override
    public void setCourseStatusForStatus(FeeBase feeBase, String oldStatus, String newStatus, String keyPairName, String keyPairValue) {
        List<LearningUnit> learningUnits = feeBase.getLearningUnits();
        for (LearningUnit learningUnit : learningUnits) {
            String status = learningUnit.getStatus();
            if ((StringUtils.isBlank(status) && StringUtils.isBlank(oldStatus)) ||
                    (oldStatus != null && oldStatus.equals(status))) {
                setCourseStatus(learningUnit, status, keyPairName, keyPairValue);
            }
        }
    }


    /**
     * Creates transaction for the given amount per credit, UL section codes and statuses.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param transactionTypeId Transaction type ID
     * @param amountPerCredit   Amount per one credit
     * @param sectionCodes      a list of LU section codes represented by a <code>String</code> value and separated by commas.
     * @param statuses          a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return a new transaction instance
     */
    @Override
    public Transaction createTransactionForNumberOfCredits(FeeBase feeBase,
                                                           String transactionTypeId,
                                                           BigDecimal amountPerCredit,
                                                           String sectionCodes,
                                                           String statuses) {
        int numberOfCredits = getNumOfCreditsBySectionCodes(feeBase, sectionCodes, statuses);
        BigDecimal amount = amountPerCredit.multiply(new BigDecimal(numberOfCredits));
        return transactionService.createTransaction(transactionTypeId, feeBase.getAccount().getId(), new Date(), amount);
    }


    /**
     * Returns the total number of credits of all LU courses with the specified status, which can be <code>null</code>.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param learningUnitCodes a list of LU codes represented by a <code>String</code> value and separated by commas.
     * @param statuses          a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return The number of credits
     */
    @Override
    public int getNumOfCreditsByLearningUnitCodes(FeeBase feeBase, String learningUnitCodes, String statuses) {
        int numOfCredits = 0;
        String[] statusArray = (statuses != null && statuses.trim().length() > 0) ? statuses.split(PATTERN_DELIMITER) : null;
        String[] luCodeArray = learningUnitCodes.split(PATTERN_DELIMITER);
        for (String luCode : getLearningUnitCodes(feeBase, statusArray)) {
            for (String luPattern : luCodeArray) {
                if (luCode.equals(luPattern) || Pattern.matches(luPattern, luCode)) {
                    LearningUnit learningUnit = feeBase.getLearningUnit(luCode);
                    if (learningUnit.getCredit() != null) {
                        numOfCredits += learningUnit.getCredit().intValue();
                    }
                }
            }
        }
        return numOfCredits;
    }

    /**
     * Returns the total number of credits of all LU courses with the specified section codes and statuses, which can be <code>null</code>.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCodes a list of LU section codes represented by a <code>String</code> value and separated by commas.
     * @param statuses     a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return The number of credits
     */
    @Override
    public int getNumOfCreditsBySectionCodes(FeeBase feeBase, String sectionCodes, String statuses) {
        int numOfCredits = 0;
        String[] statusArray = (statuses != null && statuses.trim().length() > 0) ? statuses.split(PATTERN_DELIMITER) : null;
        String[] sectionCodeArray = sectionCodes.split(PATTERN_DELIMITER);
        Set<LearningUnit> visitedUnits = new HashSet<LearningUnit>();
        for (String sectionCode : getSectionCodes(feeBase, statusArray)) {
            for (String sectionPattern : sectionCodeArray) {
                if (sectionCode.equals(sectionPattern) || Pattern.matches(sectionPattern, sectionCode)) {
                    for (LearningUnit learningUnit : feeBase.getLearningUnitsBySectionCode(sectionCode)) {
                        if (!visitedUnits.contains(learningUnit)) {
                            if (learningUnit.getCredit() != null) {
                                numOfCredits += learningUnit.getCredit().intValue();
                            }
                            visitedUnits.add(learningUnit);
                        }
                    }
                }
            }
        }
        return numOfCredits;
    }

    /**
     * Returns the total number of credits of all LU courses with the specified status, which can be <code>null</code>.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param courseStatus The status of courses for which to calculate the total number of credits. Allows <code>null</code> as a status.
     * @return The total number of credits of study courses with the specified status.
     */
    @Override
    public int getNumOfCredits(FeeBase feeBase, String courseStatus) {
        int numOfCredits = 0;
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            if (StringUtils.equalsIgnoreCase(lu.getStatus(), courseStatus)) {
                if (lu.getCredit() != null) {
                    numOfCredits += lu.getCredit().intValue();
                }
            }
        }
        return numOfCredits;
    }

    /**
     * Returns the total number of credits that has a <code>KeyPair</code> with the given name and value or does not exists.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param keyPairName  Name of a <code>KeyPair</code> to check (required).
     * @param keyPairValue Value of a <code>KeyPair</code> to check (required).
     * @return Total number of credits.
     */
    @Override
    public int getNumOfCredits(FeeBase feeBase, String keyPairName, String keyPairValue) {
        int numOfCredits = 0;
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            String kpValue = getKeyPairValue(feeBase, keyPairName);

            if (StringUtils.equalsIgnoreCase(kpValue, keyPairValue) || StringUtils.isBlank(kpValue)) {
                if (lu.getCredit() != null) {
                    numOfCredits += lu.getCredit().intValue();
                }
            }
        }

        return numOfCredits;
    }

    /**
     * Returns the total number of credits with the given section code and that has a <code>KeyPair</code> with the given name and value or does not exists.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCode  Section code of courses to count.
     * @param keyPairName  Name of a <code>KeyPair</code> to check (required).
     * @param keyPairValue Value of a <code>KeyPair</code> to check (required).
     * @return Total number of credits.
     */
    @Override
    public int getNumOfCredits(FeeBase feeBase, String sectionCode, String keyPairName, String keyPairValue) {
        int numOfCredits = 0;
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            String kpValue = getKeyPairValue(feeBase, keyPairName);

            if (StringUtils.equalsIgnoreCase(lu.getUnitSection(), sectionCode)
                    && (StringUtils.equalsIgnoreCase(kpValue, keyPairValue) || StringUtils.isBlank(kpValue))) {
                if (lu.getCredit() != null) {
                    numOfCredits += lu.getCredit().intValue();
                }
            }
        }
        return numOfCredits;
    }

    /**
     * Returns the total number of credits that has both <code>KeyPair</code>s with the given name and value or either is optional.
     *
     * @param feeBase            A <code>FeeBase</code> that contains a student's information.
     * @param keyPairName        Name of a <code>KeyPair</code> to check (required).
     * @param keyPairValue       Value of a <code>KeyPair</code> to check (required).
     * @param secondKeyPairName  Name of a second <code>KeyPair</code> to check (required).
     * @param secondKeyPairValue Value of a second <code>KeyPair</code> to check (required).
     * @return Total number of credits.
     */
    @Override
    public int getNumOfCredits(FeeBase feeBase, String keyPairName, String keyPairValue, String secondKeyPairName, String secondKeyPairValue) {
        int numOfCredits = 0;
        for (LearningUnit lu : feeBase.getLearningUnits()) {
            String kpValue = getKeyPairValue(feeBase, keyPairName);
            String kpValue2 = getKeyPairValue(feeBase, secondKeyPairName);

            if ((StringUtils.equalsIgnoreCase(kpValue, keyPairValue) || StringUtils.isBlank(kpValue))
                    && (StringUtils.equalsIgnoreCase(kpValue2, secondKeyPairValue) || StringUtils.isBlank(kpValue2))) {
                if (lu.getCredit() != null) {
                    numOfCredits += lu.getCredit().intValue();
                }
            }
        }
        return numOfCredits;
    }

    /**
     * Retrieves FeeDetail instance from a persistent store by code.
     *
     * @param code FeeDetail code
     * @param date FeeDetail date. Can be null.
     * @return FeeDetail instance or null if it does not exist
     */
    @Override
    public FeeDetail getFeeDetail(String code, Date date) {
        if (date != null) {
            date = CalendarUtils.removeTime(date);
        }
        StringBuilder builder = new StringBuilder("select fd from FeeDetail fd " +
                " left outer join fetch fd.feeType ft " +
                " left outer join fetch fd.amounts fa " +
                " where fd.code = :code and ");
        builder.append(
                (date != null) ?
                        ":date between fd.startDate and fd.endDate" :
                        "(fd.startDate is null or fd.endDate is null)");
        Query query = em.createQuery(builder.toString());
        query.setParameter("code", code);
        if (date != null) {
            query.setParameter("date", date, TemporalType.DATE);
        }
        List<FeeDetail> results = query.getResultList();
        return CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
    }

    /**
     * Creates and persists FeeType instance based on the given parameters.
     *
     * @param code        FeeType code
     * @param name        FeeType name
     * @param description FeeType description
     * @return FeeType instance
     */
    @Override
    @Transactional(readOnly = false)
    public FeeType createFeeType(String code, String name, String description) {
        return entityService.createAuditableEntity(code, name, description, FeeType.class);
    }

    /**
     * Retrieves FeeDetail instances from a persistent store by a date range
     *
     * @param code      FeeDetail code
     * @param startDate FeeDetail start date. Can be null.
     * @param endDate   FeeDetail end date. Can be null.
     * @return list of FeeDetail instances
     */
    @Override
    public List<FeeDetail> getFeeDetails(String code, Date startDate, Date endDate) {

        if (startDate != null) {
            startDate = CalendarUtils.removeTime(startDate);
        }

        if (endDate != null) {
            endDate = CalendarUtils.removeTime(endDate);
        }

        StringBuilder builder = new StringBuilder("select fd from FeeDetail fd " +
                " left outer join fetch fd.feeType ft where fd.code = :code");

        if (startDate != null || endDate != null) {
            builder.append(" and ");
        }

        builder.append((startDate != null) ? " :startDate >= fd.startDate " : "");

        if (startDate != null && endDate != null) {
            builder.append(" and ");
        }

        builder.append((endDate != null) ? " :endDate <= fd.endDate " : "");

        builder.append(" order by fd.id desc ");

        Query query = em.createQuery(builder.toString());

        query.setParameter("code", code);

        if (startDate != null) {
            query.setParameter("startDate", startDate, TemporalType.DATE);
        }

        if (endDate != null) {
            query.setParameter("endDate", endDate, TemporalType.DATE);
        }

        return query.getResultList();
    }

    /**
     * Retrieves FeeType entity by code.
     *
     * @param code FeeType code
     * @return FeeType instance
     */
    @Override
    public FeeType getFeeTypeByCode(String code) {
        Query query = em.createQuery("select ft from FeeType ft where ft.code = :code");
        query.setParameter("code", code);
        query.setMaxResults(1);
        List<FeeType> feeTypes = query.getResultList();
        return CollectionUtils.isNotEmpty(feeTypes) ? feeTypes.get(0) : null;
    }

    /**
     * Checks if the FeeDetail exists.
     *
     * @param code FeeDetail code
     * @return "true" if the FeeDetail exists, false - otherwise
     */
    @Override
    public boolean feeDetailExists(String code) {
        Query query = em.createQuery("select 1 from FeeDetail where code = :code");
        query.setParameter("code", code);
        query.setMaxResults(1);
        return CollectionUtils.isNotEmpty(query.getResultList());
    }

    /**
     * Creates and persists a new instance of FeeDetail object for the given parameters.
     *
     * @param feeTypeCode       FeeType code
     * @param code              FeeDetail code
     * @param name              FeeDetail name
     * @param description       FeeDetail description
     * @param startDate         FeeDetail start date
     * @param endDate           FeeDetail end date
     * @param transactionTypeId Default transaction type ID
     * @param transactionAmount Default transaction amount
     * @param transactionDate   Default transaction date
     * @param recognitionDate   Default recognition date
     * @param dateType          FeeDetailDateType enum value
     * @param amountType        FeeDetailAmountType enum value
     * @param amounts           List of FeeDetailAmount instances
     * @return a new persistent instance of FeeDetail
     */
    @Override
    public FeeDetail createFeeDetail(String feeTypeCode, String code, String name, String description, Date startDate, Date endDate,
                                     String transactionTypeId, BigDecimal transactionAmount, Date transactionDate,
                                     Date recognitionDate, FeeDetailDateType dateType, FeeDetailAmountType amountType,
                                     List<FeeDetailAmount> amounts) {

        if (startDate == null) {
            String errMsg = "Start Date cannot be null";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (endDate != null && startDate.after(endDate)) {
            String errMsg = "Start Date cannot be greater than End Date: Start Date = " + startDate +
                    ", End Date = " + endDate;
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        if (!transactionService.transactionTypeExists(transactionTypeId)) {
            String errMsg = "Transaction type with ID = " + transactionTypeId + " does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        FeeType feeType = getFeeTypeByCode(feeTypeCode);
        if (feeType == null) {
            String errMsg = "Fee type '" + feeTypeCode + "' does not exist";
            logger.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }

        for (FeeDetailAmount amount : amounts) {
            if (amount.getCode() == null) {
                String errMsg = "FeeDetailAmount code cannot be null";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }
            if (amount.getAmount() == null) {
                String errMsg = "FeeDetailAmount amount cannot be null";
                logger.error(errMsg);
                throw new IllegalArgumentException(errMsg);
            }
            // We have to make sure that a new JPA entity is created, hence ID should be null
            amount.setId(null);
        }

        FeeDetail startFeeDetail = getFeeDetail(code, startDate);
        FeeDetail endFeeDetail = getFeeDetail(code, endDate);

        boolean createNewFeeDetail = true;

        if (startFeeDetail != null && endFeeDetail != null && match(startFeeDetail, endFeeDetail)) {

            if (endDate != null) {

                boolean noDatesMatch = false;

                Date newStartDate = startFeeDetail.getStartDate();
                Date newEndDate = startFeeDetail.getEndDate();

                if (startDate.equals(startFeeDetail.getStartDate()) && endDate.equals(startFeeDetail.getEndDate())) {
                    createNewFeeDetail = false;
                } else if (startDate.equals(startFeeDetail.getStartDate())) {
                    newStartDate = CalendarUtils.addCalendarDays(endDate, 1);
                } else if (endDate.equals(startFeeDetail.getEndDate())) {
                    newEndDate = CalendarUtils.addCalendarDays(startDate, -1);
                } else {
                    newEndDate = CalendarUtils.addCalendarDays(startDate, -1);
                    noDatesMatch = true;
                }

                startFeeDetail.setStartDate(newStartDate);
                startFeeDetail.setEndDate(newEndDate);

                persistEntity(startFeeDetail);

                if (noDatesMatch) {

                    // Creating a new FeeDetail instance based on the existing one
                    FeeDetail feeDetailCopy = BeanUtils.getDeepCopy(startFeeDetail);

                    // Persisting a new JPA entity so we have to set the ID to null and increment the sub-code
                    feeDetailCopy.setId(null);
                    feeDetailCopy.setAmounts(null);
                    feeDetailCopy.setSubCode(getNextSubCode(code));
                    feeDetailCopy.setStartDate(CalendarUtils.addCalendarDays(endDate, 1));
                    feeDetailCopy.setEndDate(startFeeDetail.getEndDate());

                    persistEntity(feeDetailCopy);

                    // Copying fee detail amounts if there are any
                    Set<FeeDetailAmount> feeDetailAmounts = startFeeDetail.getAmounts();
                    if (CollectionUtils.isNotEmpty(feeDetailAmounts)) {
                        Set<FeeDetailAmount> newAmounts = new HashSet<FeeDetailAmount>(feeDetailAmounts.size());
                        for (FeeDetailAmount amount : feeDetailAmounts) {
                            FeeDetailAmount amountCopy = BeanUtils.getDeepCopy(amount);
                            // Persisting a new JPA entity so we have to set the ID to null
                            amountCopy.setId(null);
                            amountCopy.setFeeDetail(feeDetailCopy);
                            persistEntity(amountCopy);
                            newAmounts.add(amountCopy);
                        }
                        feeDetailCopy.setAmounts(newAmounts);
                    }

                }

                // When endDate is null
            } else {
                startFeeDetail.setEndDate(CalendarUtils.addCalendarDays(startDate, -1));
                persistEntity(startFeeDetail);
            }

            // When startFeeDetail and endFeeDetail are different
        } else {

            boolean startFeeDetailIsRemoved = false;
            boolean endFeeDetailIsRemoved = false;

            List<FeeDetail> feeDetails = getFeeDetails(code, startDate, endDate);

            if (CollectionUtils.isNotEmpty(feeDetails)) {
                for (Iterator<FeeDetail> iterator = feeDetails.iterator(); iterator.hasNext(); ) {
                    FeeDetail feeDetail = iterator.next();
                    deleteEntity(feeDetail.getId(), FeeDetail.class);
                    feeDetails.remove(feeDetail);
                    if (startFeeDetail != null && !startFeeDetailIsRemoved && match(startFeeDetail, feeDetail)) {
                        startFeeDetailIsRemoved = true;
                    } else if (endFeeDetail != null && !endFeeDetailIsRemoved && match(endFeeDetail, feeDetail)) {
                        endFeeDetailIsRemoved = true;
                    }
                }
            }

            if (startFeeDetail != null && !startFeeDetailIsRemoved) {
                startFeeDetail.setEndDate(CalendarUtils.addCalendarDays(startDate, -1));
                persistEntity(startFeeDetail);
            }

            if (endFeeDetail != null && !endFeeDetailIsRemoved) {
                endFeeDetail.setStartDate(CalendarUtils.addCalendarDays(endDate, 1));
                persistEntity(endFeeDetail);
            }
        }

        FeeDetail newFeeDetail = createNewFeeDetail ? new FeeDetail() : startFeeDetail;

        newFeeDetail.setCode(code);
        if (newFeeDetail.getSubCode() == null) {
            newFeeDetail.setSubCode(getNextSubCode(code));
        }
        newFeeDetail.setName(name);
        newFeeDetail.setDescription(description);
        newFeeDetail.setStartDate(startDate);
        newFeeDetail.setEndDate(endDate);
        newFeeDetail.setDefaultTransactionTypeId(transactionTypeId);
        newFeeDetail.setDefaultTransactionDate(transactionDate);
        newFeeDetail.setDefaultRecognitionDate(recognitionDate);
        newFeeDetail.setDefaultTransactionAmount(transactionAmount);
        newFeeDetail.setFeeType(feeType);
        newFeeDetail.setDateType(dateType);
        newFeeDetail.setAmountType(amountType);

        persistEntity(newFeeDetail);

        if (CollectionUtils.isNotEmpty(amounts)) {
            for (FeeDetailAmount amount : amounts) {
                amount.setFeeDetail(newFeeDetail);
                persistEntity(amount);
            }
            newFeeDetail.setAmounts(new HashSet<FeeDetailAmount>(amounts));
        }

        return newFeeDetail;
    }

    private int getNextSubCode(String feeCode) {
        Query query = em.createQuery("select max(subCode) from FeeDetail where code = :code");
        query.setParameter("code", feeCode);
        List<Integer> results = query.getResultList();
        Integer currentSubCode = CollectionUtils.isNotEmpty(results) ? results.get(0) : null;
        return (currentSubCode != null) ? ++currentSubCode : 1;
    }

    private Date nvl(Date date) {
        return (date != null) ? CalendarUtils.removeTime(date) : new Date(0);
    }

    private boolean match(FeeDetail feeDetail1, FeeDetail feeDetail2) {
        if (feeDetail1.getId() != null && feeDetail2.getId() == null) {
            return false;
        } else if (feeDetail1.getId() == null && feeDetail2.getId() != null) {
            return false;
        } else if (!feeDetail1.getId().equals(feeDetail2.getId())) {
            return false;
        }
        if (!feeDetail1.getCode().equals(feeDetail2.getCode())) {
            return false;
        }
        Date startDate1 = nvl(feeDetail1.getStartDate());
        Date endDate1 = nvl(feeDetail1.getEndDate());
        Date startDate2 = nvl(feeDetail2.getStartDate());
        Date endDate2 = nvl(feeDetail2.getEndDate());
        return (startDate1.equals(startDate2) && endDate1.equals(endDate2));
    }


    /* ***********************************************************
   *
   * Utility methods.
   *
   * ***********************************************************/

    /**
     * Loads either of the KeyPair type or sub-type object associated with an account with the given ID.
     *
     * @param accountId   Id of an account for which to load pairs.
     * @param resultClass Class of an object to load.
     * @return Associated objects.
     */
    private <T extends DeprecatedKeyPair> List<T> findKeyPairs(String accountId, Class<T> resultClass, KeyPairType keyPairType) {
        // Since associations between Account and KeyPair/PeriodKeyPair are not defined
        // neither in Account nor KeyPair/PeriodKeyPair, we have to load them using
        // the physical association table join.
        String sql = "select kp.* from ksa.kssa_kypr kp, ksa.kssa_acnt_kypr akp where kp.id = akp.kypr_id_fk " +
                " and akp.acnt_id_fk = :accountId and kp.type = :keypairType";
        Query query = em.createNativeQuery(sql, resultClass).setParameter("accountId", accountId).setParameter("keypairType", keyPairType.getCode());
        return query.getResultList();
    }

    /**
     * A generic method to create a new KeyPair or its subclass for a FeeBase.
     *
     * @param feeBase     A FeeBase for which to create a KeyPair.
     * @param name        The "name" property of the new object.
     * @param value       The "value" property of the new object.
     * @param period      The "period" property of the new object, only if the type contains a <code>LearningPeriod</code>.
     * @param entityClass The type of the new object to create.
     * @return The newly created object.
     */
    private <T extends DeprecatedKeyPair> T createFeeBaseKeyPairInternal(FeeBase feeBase, String name, String value, LearningPeriod period, Class<T> entityClass) {
        // Validate the input:
        validateInputParameters(feeBase, name, value, period, entityClass);
        validateKeyPairNameUnique(feeBase, name);

        try {
            // Create and persist a new KeyPair:
            T newKeyPair = setKeyPairInternal(name, value, period, entityClass);

            // Create an association record:
            createKeyPairAssociationRecord(feeBase.getAccount(), newKeyPair);

            // Flush the EM to the persistent storage:
            em.flush();

            // Add the new KeyPair to an appropriate list in FeeBase:
            if (entityClass.equals(PeriodKeyPair.class)) {
                feeBase.getPeriodData().add(PeriodKeyPair.class.cast(newKeyPair));
            } else {
                feeBase.getStudentData().add(newKeyPair);
            }

            return newKeyPair;
        } catch (Throwable t) {
            // Log an error:
            logger.error("Error creating a new KeyPair object.", t);

            // Re-throw the error:
            throw new RuntimeException("Error creating a new KeyPair object.", t);
        }
    }

    /**
     * Creates an instance of either <code>KeyPair</code> or one of its subclasses of the given type.
     *
     * @param name        The "name" property of the new object.
     * @param value       The "value" property of the new object.
     * @param period      The "period" property of the new object, only if the type contains a <code>LearningPeriod</code>.
     * @param entityClass The type of the new object to create.
     * @return The newly created object.
     */
    private <T extends DeprecatedKeyPair> T setKeyPairInternal(String name, String value, LearningPeriod period, Class<T> entityClass) throws Exception {

        Query query = em.createQuery("select kp from KeyPair kp where kp.name = :name");
        query.setParameter("name", name);
        List<T> keyPairs = query.getResultList();
        T keyPair = CollectionUtils.isNotEmpty(keyPairs) ? keyPairs.get(0) : null;

        if (keyPair == null) {
            keyPair = entityClass.newInstance();
        }

        // Set common properties:
        keyPair.setName(name);
        keyPair.setValue(value);

        // Set PeriodKeyPair properties:
        if (keyPair instanceof PeriodKeyPair) {
            ((PeriodKeyPair) keyPair).setLearningPeriod(period);
        }

        // Persist the new instance:
        persistEntity(keyPair);

        return keyPair;
    }

    /**
     * Creates an association record in the KSSA_ACNT_KYPR table.
     *
     * @param account Account to associate with a KeyPair.
     * @param keyPair KeyPair to associate with an Account.
     * @throws Exception If there are errors creating a new association record.
     */
    private void createKeyPairAssociationRecord(Account account, DeprecatedKeyPair keyPair) throws Exception {
        createKeyPairAssociationRecord(account.getId(), keyPair);
    }

    /**
     * Creates an association record in the KSSA_ACNT_KYPR table.
     *
     * @param accountId Account ID to associate with a KeyPair.
     * @param keyPair   KeyPair to associate with an Account ID.
     * @throws Exception If there are errors creating a new association record.
     */
    private void createKeyPairAssociationRecord(String accountId, DeprecatedKeyPair keyPair) throws Exception {
        // Create and execute an INSERT statement:
        Query query = em.createNativeQuery("insert into ksa.kssa_acnt_kypr (acnt_id_fk, kypr_id_fk) values (:accountId, :keypairId)");
        query.setParameter("accountId", accountId).setParameter("keypairId", keyPair.getId());

        query.executeUpdate();
    }

    /**
     * Removes an association record from the KSSA_ACNT_KYPR table.
     *
     * @param account Account to disassociate from the given KeyPair.
     * @param keyPair KeyPair to disassociate from the given Account.
     * @throws Exception If a persistent storage operation error occurs.
     */
    private void removeKeyPairAssociationRecord(Account account, DeprecatedKeyPair keyPair) throws Exception {
        removeKeyPairAssociationRecord(account.getId(), keyPair);
    }

    /**
     * Removes an association record from the KSSA_ACNT_KYPR table.
     *
     * @param accountId Account ID to disassociate from the given KeyPair.
     * @param keyPair   KeyPair to disassociate from the given Account ID.
     * @throws Exception If a persistent storage operation error occurs.
     */
    private void removeKeyPairAssociationRecord(String accountId, DeprecatedKeyPair keyPair) throws Exception {
        // Create an execute a DELETE statement:
        Query query = em.createNativeQuery("delete from ksa.kssa_acnt_kypr where acnt_id_fk = :accountId and kypr_id_fk = :keypairId")
                .setParameter("accountId", accountId).setParameter("keypairId", keyPair.getId());

        query.executeUpdate();
    }

    /**
     * Updates a KeyPair with the specified name with the new "value" and optionally with the new "period" properties
     * depending on the type of the instance to be updated.
     *
     * @param keyPairs    A Collection of KeyPair or its subclasses.
     * @param name        The "name" attribute of a KeyPair to update.
     * @param newValue    The new "value" attribute.
     * @param newPeriod   The new "period" attribute for PeriodKeyPairs.
     * @param keyPairType Type of the KeyPair.
     */
    private <T extends DeprecatedKeyPair> void updateKeyPairInternal(Collection<T> keyPairs, String name, String newValue, LearningPeriod newPeriod, Class<T> keyPairType) {
        // Get the KeyPairs, find the one with the given name and set the new value:
        boolean isPeriodKeyPair = keyPairType.equals(PeriodKeyPair.class);

        for (T keyPair : keyPairs) {
            if (StringUtils.equalsIgnoreCase(keyPair.getName(), name)) {
                // Set the new values:
                keyPair.setValue(newValue);

                if (isPeriodKeyPair) {
                    PeriodKeyPair.class.cast(keyPair).setLearningPeriod(newPeriod);
                }

                // Persist the entity:
                persistEntity(keyPair);

                break;
            }
        }

    }

    /**
     * Removes a KeyPair or its subtype with the specified "name" from the given Collection.
     * Does NOT remove from the Persistent Store.
     *
     * @param keyPairs A Collection of KeyPairs to remove from.
     * @param name     The "name" property of the KeyPair to remove from the given Collection.
     * @return The KeyPair that has been removed or <code>null</code> if no such KeyPair with
     *         the specified "name" attribute exists in the given Collection.
     */
    private <T extends DeprecatedKeyPair> T removeKeyPairInternal(Collection<T> keyPairs, String name) {
        T keyPair = getKeyPairInternal(keyPairs, name);

        if (keyPair != null) {
            keyPairs.remove(keyPair);
        }

        return keyPair;
    }

    /**
     * Checks if a KeyPair with the specified name exists in the given Collection.
     *
     * @param keyPairs A Collection of KeyPairs to check.
     * @param name     Name of a KeyPair to check.
     * @return true if exists, false otherwise.
     */
    private <T extends DeprecatedKeyPair> boolean containsKeyPairInternal(Collection<T> keyPairs, String name) {
        return (getKeyPairInternal(keyPairs, name) != null);
    }

    /**
     * Finds a KeyPair with the specified name within the given Collection.
     *
     * @param keyPairs A Collection of KeyPairs.
     * @param name     Name of a KeyPair to find.
     * @return The KeyPair with the given name found in the given Collection or <code>null</code>
     *         if a KeyPair with such a name does not exist.
     */
    private <T extends DeprecatedKeyPair> T getKeyPairInternal(Collection<T> keyPairs, String name) {
        for (T keyPair : keyPairs) {
            if (StringUtils.equalsIgnoreCase(keyPair.getName(), name)) {
                return keyPair;
            }
        }

        return null;
    }

    protected boolean matchOneOrMoreValues(String pattern, String... values) {
        return matchOneOrMoreValues(pattern, Arrays.asList(values));
    }

    protected boolean matchOneOrMoreValues(String pattern, Collection<String> values) {
        if (values == null || values.isEmpty()) {
            return false;
        }
        if (pattern == null || !pattern.contains(PATTERN_DELIMITER)) {
            for (String value : values) {
                if ((value == null && pattern == null) ||
                        (value != null && (value.equals(pattern) || Pattern.matches(pattern, value)))) {
                    return true;
                }
            }
            return false;
        }
        for (String patternItem : pattern.split(PATTERN_DELIMITER)) {
            patternItem = patternItem.trim();
            for (String value : values) {
                if (value != null && (value.equals(patternItem) || Pattern.matches(patternItem, value))) {
                    return true;
                }
            }
        }
        return false;
    }


    /* *****************************************************************************
      *
      * Parameter validation methods.
      *
      * *****************************************************************************/

    private void validateInputParameters(FeeBase feeBase, String name, String value, LearningPeriod period, Class<? extends DeprecatedKeyPair> keyPairType) {

        validateInputParameters(feeBase, name);

        boolean isPeriodKeyPair = keyPairType.equals(PeriodKeyPair.class);

        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("KeyPair.value property cannot be null.");
        }

        if (isPeriodKeyPair && (period == null)) {
            throw new IllegalArgumentException("PeriodKeyPair.period property cannot be null.");
        }
    }

    private void validateInputParameters(FeeBase feeBase, String name) {
        if ((feeBase == null) || (feeBase.getAccount() == null)) {
            throw new IllegalArgumentException("FeeBase.account or Account.id property cannot be null.");
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("KeyPair.name property cannot be null.");
        }
    }

    private void validateInputParameters(LearningUnit learningUnit, String name, String value) {
        validateInputParameters(learningUnit, name);

        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("KeyPair.value property cannot be null.");
        }
    }

    private void validateInputParameters(LearningUnit learningUnit, String name) {
        validateInputParameters(learningUnit);

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("KeyPair.name property cannot be null.");
        }
    }

    private void validateInputParameters(LearningUnit learningUnit) {
        if (learningUnit == null) {
            throw new IllegalArgumentException("LearningUnit cannot be null.");
        }
    }

    private void validateKeyPairNameUnique(FeeBase feeBase, String name) {
        if (containsKeyPairInternal(feeBase.getStudentData(), name)
                || containsKeyPairInternal(feeBase.getPeriodData(), name)) {
            throw new IllegalArgumentException("Such KeyPair name [" + name + "] already exists for Account with ID [" + feeBase.getAccount().getId() + "].");
        }
    }

    private void validateKeyPairNameUnique(LearningUnit learningUnit, String name) {
        if (containsKeyPairInternal(learningUnit.getKeyPairs(), name)) {
            throw new IllegalArgumentException("Such KeyPair name [" + name + "] already exists for LearningUnit with code [" + learningUnit.getUnitCode() + "].");
        }
    }
}
