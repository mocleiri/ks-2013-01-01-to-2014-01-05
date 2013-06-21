package com.sigmasys.kuali.ksa.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.model.DeprecatedKeyPair;
import com.sigmasys.kuali.ksa.model.LearningPeriod;
import com.sigmasys.kuali.ksa.model.LearningUnit;
import com.sigmasys.kuali.ksa.model.PeriodKeyPair;

/**
 * This interface represents a service object to work with Fee Assessments of ChargeableAccounts.
 * The methods of this interface give an ability to load the necessary information to start
 * assessing courses taken on a particular account and also load account specific student and period data.
 * This interface includes a convenience method "getFeeBase" that creates a holder class that contains
 * all pertinent information in addition to individual data access methods.
 *
 * @author Sergey Godunov
 * @author Michael Ivanov
 * @version 1.0
 */
@Deprecated
public interface FeeManagementService {

    /**
     * Performs all the necessary operations to calculate fees for the given account.
     * Most of this logic is usually performed by a rule engine (Drools).
     *
     * @param accountId Account ID
     */
    void assessFees(String accountId);

    /**
     * Returns an account's Set of student data in form of KeyPair objects.
     *
     * @param accountId Id of an account for which to get its student data.
     * @return Account's student data.
     */
    List<DeprecatedKeyPair> getStudentData(String accountId);

    /**
     * Returns an account's Set of learning period data in form of PeriodKeyPair objects.
     *
     * @param accountId Id of an account for which to get its learning period data.
     * @return Account's learning period data.
     */
    List<PeriodKeyPair> getLearningPeriodData(String accountId);

    /**
     * Returns an account's study data in form of PeriodKeyPair objects.
     *
     * @param accountId Id of an account for which to get its study data.
     * @return Account's study data.
     */
    List<LearningUnit> getLearningUnits(String accountId);

    /**
     * Returns a {@link FeeBase} object containing all information necessary for a
     * fee assessment process for an account.
     *
     * @param accountId Id of an account for which to retrieve its fee assessment data.
     * @return FeeBase An object containing all account's fee assessment data.
     */
    FeeBase getFeeBase(String accountId);

    /**
     * Calculates fees for the given account for during the specified period.
     *
     * @param feeBase FeeBase used for assessing the fees.
     * @param period  Period during which to calculate fees.
     * @return The total fees amount.
     */
    BigDecimal calculateFees(FeeBase feeBase, LearningPeriod period);

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
    BigDecimal calculateChargeByCreditToMax(int numOfCredits, BigDecimal amountPerCredit, BigDecimal maxAmount);

    /**
     * Creates a new <code>KeyPair</code> object for the specified <code>FeeBase</code>
     *
     * @param feeBase A <code>FeeBase</code> object associated with an account.
     * @param name    Name of the new <code>KeyPair</code>.
     * @param value   Value of the new <code>KeyPair</code>.
     * @return The newly created <code>KeyPair</code>.
     */
    DeprecatedKeyPair createKeyPair(FeeBase feeBase, String name, String value);

    /**
     * Creates a new <code>PeriodKeyPair</code> object for the specified <code>FeeBase</code>
     *
     * @param feeBase A <code>FeeBase</code> object associated with an account.
     * @param name    Name of the new <code>PeriodKeyPair</code>.
     * @param value   Value of the new <code>PeriodKeyPair</code>.
     * @param period  A <code>LearningPeriod</code> to be associated with the new <code>KeyPair</code>.
     * @return The newly created <code>PeriodKeyPair</code>.
     */
    PeriodKeyPair createKeyPair(FeeBase feeBase, String name, String value, LearningPeriod period);

    /**
     * Creates a new <code>KeyPair</code> object for the specified <code>LearningUnit</code>
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         Name of the new <code>KeyPair</code>.
     * @param value        Value of the new <code>KeyPair</code>.
     * @return The newly created <code>KeyPair</code>.
     */
    DeprecatedKeyPair setKeyPair(LearningUnit learningUnit, String name, String value);

    /**
     * Returns the value of a <code>KeyPair</code> with the specified name within the given <code>FeeBase</code>.
     * Returns <code>null</code> if there is such <code>KeyPair</code> with the given name in the specified <code>FeeBase</code>.
     *
     * @param feeBase A <code>FeeBase</code> object associated with an account.
     * @param name    Name of a <code>KeyPair</code> which value to retrieve.
     * @return The value of a <code>KeyPair</code> with the given name in the specified <code>FeeBase</code>
     *         or <code>null</code> is such a name does not exist.
     */
    String getKeyPairValue(FeeBase feeBase, String name);

    /**
     * Returns the value of a <code>KeyPair</code> with the specified name within the given <code>LearningUnit</code>.
     * Returns <code>null</code> if there is such <code>KeyPair</code> with the given name in the specified <code>FeeBase</code>.
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         Name of a <code>KeyPair</code> which value to retrieve.
     * @return The value of a <code>KeyPair</code> with the given name in the specified <code>LearningUnit</code>
     *         or <code>null</code> is such a name does not exist.
     */
    String getKeyPairValue(LearningUnit learningUnit, String name);

    /**
     * Removes a <code>KeyPair</code> with the specified name from a <code>FeeBase</code>.
     *
     * @param feeBase A <code>FeeBase</code> object.
     * @param name    <code>KeyPair</code> name.
     */
    void removeKeyPair(FeeBase feeBase, String name);

    /**
     * Removes a <code>KeyPair</code> with the specified name from a LearningUnit</code>.
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         <code>KeyPair</code> name.
     */
    void removeKeyPair(LearningUnit learningUnit, String name);

    /**
     * Updates the <code>KeyPair</code> with the specified name with a new value.
     *
     * @param feeBase  A <code>FeeBase</code> object.
     * @param name     <code>KeyPair</code> name.
     * @param newValue The new <code>KeyPair</code> value.
     */
    void updateKeyPair(FeeBase feeBase, String name, String newValue);

    /**
     * Updates the <code>PeriodKeyPair</code> with the specified name with a new value and/or a new <code>LearningPeriod</code>.
     * If either <code>newValue</code> or <code>newPeriod</code> is <code>null</code>, it's not updated.
     *
     * @param feeBase   A <code>FeeBase</code> object.
     * @param name      <code>PeriodKeyPair</code> name.
     * @param newValue  New <code>PeriodKeyPair</code> value.
     * @param newPeriod New <code>Learning</code> period.
     */
    void updateKeyPair(FeeBase feeBase, String name, String newValue, LearningPeriod newPeriod);

    /**
     * Updates the <code>KeyPair</code> with the specified name with a new value.
     *
     * @param learningUnit A <code>LearningUnit</code> object.
     * @param name         <code>KeyPair</code> name.
     * @param newValue     The new <code>KeyPair</code> value.
     */
    void updateKeyPair(LearningUnit learningUnit, String name, String newValue);

    /**
     * Checks if the given FeeBase contains a KeyPair or its subtype with the given name.
     *
     * @param feeBase A FeeBase to check.
     * @param name    Name of a KeyPair to locate within the FeeBase.
     * @return <code>true</code> if a KeyPair or its subtype with the given name exists within the specified FeeBase.
     *         Returns <code>false</code> otherwise.
     */
    boolean containsKeyPair(FeeBase feeBase, String name);

    /**
     * Checks if the given LearningUnit contains a KeyPair or its subtype with the given name.
     *
     * @param learningUnit A LearningUnit to check.
     * @param name         Name of a KeyPair to locate within the LearningUnit.
     * @return <code>true</code> if a KeyPair with the given name exists within the specified LearningUnit.
     *         Returns <code>false</code> otherwise.
     */
    boolean containsKeyPair(LearningUnit learningUnit, String name);

    /**
     * Checks if a KeyPair exists in the given <code>FeeBase</code>
     *
     * @param feeBase       A <code>FeeBase</code> that contains a student's information.
     * @param keyPairName   The name of a <code>KeyPair</code> to check.
     * @param keyPairValues The values of a <code>KeyPair</code> to check represented by a <code>String</code> and
     *                      separated by commas
     * @return <code>true</code> if a KeyPair exists, <code>false</code> - otherwise
     */
    boolean containsKeyPair(FeeBase feeBase, String keyPairName, String keyPairValues);

    /**
     * Saves a <code>LearningUnit</code>. This method is helpful when making modifications to a <code>LearningUnit</code>, such as setting new Status,
     * changing details, such as Campus, Add Date, Drop Date, etc.
     *
     * @param learningUnit A <code>LearningUnit</code> to be updated.
     */
    void persistLearningUnit(LearningUnit learningUnit);

    /**
     * Returns the period that the rules are currently working on.
     *
     * @return The period that the rules are currently working on.
     */
    LearningPeriod getCurrentPeriod();

    /**
     * Finds all <code>LearningPeriod</code>s that fall into the specified date range.
     *
     * @param dateFrom Beginning of the search date range.
     * @param dateTo   End of the search date range.
     * @return All <code>LearningPeriod</code> objects that fall into the given date range.
     */
    List<LearningPeriod> findLearningPeriods(Date dateFrom, Date dateTo);

    /**
     * Attempts to find a <code>LearningPeriod</code> with the specified name.
     * Returns <code>null</code> if no such <code>LearningPeriod</code> is found.
     * This method performs CASE-INSENSITIVE search.
     *
     * @param name Name of a <code>LearningPeriod</code> to locate.
     * @return <code>LearningPeriod</code> with the given name or <code>null</code> if none found.
     */
    LearningPeriod getLearningPeriod(String name);

    /**
     * Returns the major course codes. This includes the major and the second major courses
     * from a students's profile.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return Major course codes.
     */
    List<String> getMajorCodes(FeeBase feeBase);

    /**
     * Check the existence of at least one of the given major codes in a <code>FeeBase</code> object.
     *
     * @param feeBase    A <code>FeeBase</code> that contains a student's information.
     * @param majorCodes a list of major codes represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one major code, <code>false</code> - otherwise.
     */
    boolean containsMajorCode(FeeBase feeBase, String majorCodes);

    /**
     * Returns the LU codes of all classes taken by a student.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return All study course codes.
     */
    List<String> getLearningUnitCodes(FeeBase feeBase);

    /**
     * Returns the LU codes of all classes taken by a student for the given set of LU statuses.
     *
     * @param feeBase  A <code>FeeBase</code> that contains a student's information.
     * @param statuses A <code>java.util.String</code> array of statuses
     * @return All study course codes.
     */
    List<String> getLearningUnitCodes(FeeBase feeBase, String... statuses);

    /**
     * Returns the LU section codes of all classes taken by a student for the given set of LU statuses.
     *
     * @param feeBase  A <code>FeeBase</code> that contains a student's information.
     * @param statuses A <code>java.util.String</code> array of statuses
     * @return All study course codes.
     */
    List<String> getSectionCodes(FeeBase feeBase, String... statuses);

    /**
     * Check the existence of at least one of the given LU section codes in a <code>FeeBase</code> object.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCodes a list of section codes represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    boolean containsSectionCode(FeeBase feeBase, String sectionCodes);

    /**
     * Check the existence of at least one of the given LU section codes in a <code>FeeBase</code> object.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCodes a list of section codes represented by a <code>String</code> value and separated by commas.
     * @param statuses     a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    boolean containsSectionCode(FeeBase feeBase, String sectionCodes, String statuses);

    /**
     * Check the existence of at least one of the given LU codes in a <code>FeeBase</code> object.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param learningUnitCodes a list of LU codes represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    boolean containsLearningUnitCode(FeeBase feeBase, String learningUnitCodes);

    /**
     * Check the existence of at least one of the given LU codes in a <code>FeeBase</code> object.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param learningUnitCodes a list of LU codes represented by a <code>String</code> value and separated by commas.
     * @param statuses          a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return <code>true</code> if <code>FeeBase</code> contains at least one LU code, <code>false</code> - otherwise.
     */
    boolean containsLearningUnitCode(FeeBase feeBase, String learningUnitCodes, String statuses);

    /**
     * Checks if a student is a resident.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return <code>true</code> if a student is a resident, <code>false</code> otherwise.
     */
    boolean isResident(FeeBase feeBase);

    /**
     * Checks if a student is a graduate.
     *
     * @param feeBase A <code>FeeBase</code> that contains a student's information.
     * @return <code>true</code> if a student is a graduate, <code>false</code> otherwise.
     */
    boolean isGraduate(FeeBase feeBase);

    /**
     * Sets a course's status and saves it.
     *
     * @param learningUnit A LU course.
     * @param status       The new course status.
     */
    void setCourseStatus(LearningUnit learningUnit, String status);

    /**
     * Sets a course's status and add a <code>KeyPair</code> with the specified name and value.
     *
     * @param learningUnit A LU course.
     * @param status       The new course status.
     * @param keyPairName  The name of a <code>KeyPair</code> to add.
     * @param keyPairValue The value of a <code>KeyPair</code> to add.
     */
    void setCourseStatus(LearningUnit learningUnit, String status, String keyPairName, String keyPairValue);

    /**
     * Sets a course's status and add a <code>KeyPair</code> with the specified name and value to all LUs for
     * the given FeeBase and LU code.
     *
     * @param feeBase       A <code>FeeBase</code> that contains a student's information.
     * @param luCodePattern A LU code or a regular expression
     * @param status        The new course status.
     * @param keyPairName   The name of a <code>KeyPair</code> to add.
     * @param keyPairValue  The value of a <code>KeyPair</code> to add.
     */
    void setCourseStatusForLearningUnits(FeeBase feeBase, String luCodePattern, String status, String keyPairName, String keyPairValue);

    /**
     * Sets a course's status and add a <code>KeyPair</code> with the specified name and value to all LUs for
     * the given FeeBase and section code.
     *
     * @param feeBase        A <code>FeeBase</code> that contains a student's information.
     * @param sectionPattern A LU section code or a regular expression.
     * @param status         The new course status.
     * @param keyPairName    The name of a <code>KeyPair</code> to add.
     * @param keyPairValue   The value of a <code>KeyPair</code> to add.
     */
    void setCourseStatusForSections(FeeBase feeBase, String sectionPattern, String status, String keyPairName, String keyPairValue);

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
    void setCourseStatusForStatus(FeeBase feeBase, String oldStatus, String newStatus, String keyPairName, String keyPairValue);

    /**
     * Returns the total number of credits of all study courses with the specified status, which can be <code>null</code>.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param courseStatus The status of courses for which to calculate the total number of credits. Allows <code>null</code> as a status.
     * @return The total number of credits of study courses with the specified status.
     */
    int getNumOfCredits(FeeBase feeBase, String courseStatus);

    /**
     * Returns the total number of credits that has a <code>KeyPair</code> with the given name and value or does not exists.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param keyPairName  Name of a <code>KeyPair</code> to check (required).
     * @param keyPairValue Value of a <code>KeyPair</code> to check (required).
     * @return Total number of credits.
     */
    int getNumOfCredits(FeeBase feeBase, String keyPairName, String keyPairValue);

    /**
     * Returns the total number of credits with the given section code and that has a <code>KeyPair</code> with the given name and value or does not exists.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCode  Section code of courses to count.
     * @param keyPairName  Name of a <code>KeyPair</code> to check (required).
     * @param keyPairValue Value of a <code>KeyPair</code> to check (required).
     * @return Total number of credits.
     */
    int getNumOfCredits(FeeBase feeBase, String sectionCode, String keyPairName, String keyPairValue);

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
    int getNumOfCredits(FeeBase feeBase, String keyPairName, String keyPairValue, String secondKeyPairName, String secondKeyPairValue);

    /**
     * Returns the total number of credits of all LU courses with the specified unit codes and statuses, which can be <code>null</code>.
     *
     * @param feeBase           A <code>FeeBase</code> that contains a student's information.
     * @param learningUnitCodes a list of LU unit codes represented by a <code>String</code> value and separated by commas.
     * @param statuses          a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return The number of credits
     */
    int getNumOfCreditsByLearningUnitCodes(FeeBase feeBase, String learningUnitCodes, String statuses);

    /**
     * Returns the total number of credits of all LU courses with the specified section codes and statuses, which can be <code>null</code>.
     *
     * @param feeBase      A <code>FeeBase</code> that contains a student's information.
     * @param sectionCodes a list of LU section codes represented by a <code>String</code> value and separated by commas.
     * @param statuses     a list of LU statuses represented by a <code>String</code> value and separated by commas.
     * @return The number of credits
     */
    int getNumOfCreditsBySectionCodes(FeeBase feeBase, String sectionCodes, String statuses);

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
    Transaction createTransactionForNumberOfCredits(FeeBase feeBase,
                                                    String transactionTypeId,
                                                    BigDecimal amountPerCredit,
                                                    String sectionCodes,
                                                    String statuses);

    /**
     * Retrieves FeeDetail instance from a persistent store by code.
     *
     * @param code FeeDetail code
     * @param date FeeDetail date. Can be null.
     * @return FeeDetail instance or null if it does not exist
     */
    FeeDetail getFeeDetail(String code, Date date);

    /**
     * Retrieves FeeDetail instances from a persistent store by a date range
     *
     * @param code      FeeDetail code
     * @param startDate FeeDetail start date. Can be null.
     * @param endDate   FeeDetail end date. Can be null.
     * @return list of FeeDetail instances
     */
    List<FeeDetail> getFeeDetails(String code, Date startDate, Date endDate);


    /**
     * Creates and persists FeeType instance based on the given parameters.
     *
     * @param code        FeeType code
     * @param name        FeeType name
     * @param description FeeType description
     * @return FeeType instance
     */
    FeeType createFeeType(String code, String name, String description);

    /**
     * Retrieves FeeType entity by code.
     *
     * @param code FeeType code
     * @return FeeType instance
     */
    FeeType getFeeTypeByCode(String code);

    /**
     * Checks if the FeeDetail exists.
     *
     * @param code FeeDetail code
     * @return "true" if the FeeDetail exists, false - otherwise
     */
    boolean feeDetailExists(String code);

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
    FeeDetail createFeeDetail(String feeTypeCode, String code, String name, String description, Date startDate, Date endDate,
                              String transactionTypeId, BigDecimal transactionAmount, Date transactionDate,
                              Date recognitionDate, FeeDetailDateType dateType, FeeDetailAmountType amountType,
                              List<FeeDetailAmount> amounts);


}
