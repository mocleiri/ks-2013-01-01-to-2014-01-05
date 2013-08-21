package com.sigmasys.kuali.ksa.service.tp;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.tp.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The third-party billing service is responsible for the transfer of responsibility for transactions
 * from a “student’s” account to a third-party (sponsorship) account. Once the plans are established,
 * the system can automatically calculate the appropriate transactions to transfer, in what amount,
 * and move them to the third-party account.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Url(ThirdPartyTransferService.SERVICE_URL)
@WebService(serviceName = ThirdPartyTransferService.SERVICE_NAME, portName = ThirdPartyTransferService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface ThirdPartyTransferService {

    String SERVICE_URL = "thirdPartyTransfer.webservice";
    String SERVICE_NAME = "ThirdPartyTransferService";
    String PORT_NAME = SERVICE_NAME + "Port";

    /**
     * Creates and persists a new third-party billing plan based on the given parameters.
     *
     * @param code                  ThirdPartyPlan code
     * @param name                  ThirdPartyPlan name
     * @param description           ThirdPartyPlan description
     * @param transferTypeId        TransferType ID
     * @param thirdPartyAccountId   ThirdPartyAccount ID
     * @param maxAmount             Maximum transfer amount
     * @param effectiveDate         Effective Date
     * @param recognitionDate       Recognition Date
     * @param openPeriodStartDate   Open Period Start Date
     * @param openPeriodEndDate     Open Period End Date
     * @param chargePeriodStartDate Charge Period Start Date
     * @param chargePeriodEndDate   Charge Period End Date
     * @return ThirdPartyPlan instance
     */
    ThirdPartyPlan createThirdPartyPlan(String code,
                                        String name,
                                        String description,
                                        Long transferTypeId,
                                        String thirdPartyAccountId,
                                        BigDecimal maxAmount,
                                        Date effectiveDate,
                                        Date recognitionDate,
                                        Date openPeriodStartDate,
                                        Date openPeriodEndDate,
                                        Date chargePeriodStartDate,
                                        Date chargePeriodEndDate);


    /**
     * Creates and persists a new third-party plan member for the given account and plan IDs
     *
     * @param accountId        Account ID
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param priority         Priority
     * @return ThirdPartyPlanMember instance
     */
    ThirdPartyPlanMember createThirdPartyPlanMember(String accountId, Long thirdPartyPlanId, int priority);


    /**
     * Creates and persists a new ThirdPartyAllowableCharge instance for the given parameters.
     *
     * @param thirdPartyPlanId    ThirdPartyPlan ID
     * @param transactionTypeMask Transaction Type Mask
     * @param maxAmount           Maximum amount
     * @param maxPercentage       Maximum percentage
     * @param priority            Priority
     * @param distributionPlan    Charge Distribution Plan
     * @return ThirdPartyAllowableCharge instance
     */
    ThirdPartyAllowableCharge createThirdPartyAllowableCharge(Long thirdPartyPlanId,
                                                              String transactionTypeMask,
                                                              BigDecimal maxAmount,
                                                              BigDecimal maxPercentage,
                                                              int priority,
                                                              ChargeDistributionPlan distributionPlan);

    /**
     * Retrieves ThirdPartyPlan instance by ID from the persistent store.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return ThirdPartyPlan instance
     */
    ThirdPartyPlan getThirdPartyPlan(Long thirdPartyPlanId);

    /**
     * Retrieves ThirdPartyPlan by searching for matchin names
     */
    List<ThirdPartyPlan> getThirdPartyPlanByNamePattern(String pattern);

    /**
     * Retrieves ThirdPartyTransferDetail with ACTIVE status by ID from the persistent store.
     *
     * @param thirdPartyTransferDetailId ThirdPartyTransferDetail ID
     * @return ThirdPartyTransferDetail instance
     */
    ThirdPartyTransferDetail getThirdPartyTransferDetail(Long thirdPartyTransferDetailId);

    /**
     * Retrieves ThirdPartyTransferDetail with ACTIVE status by ThirdPartyPlan and Account IDs
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        Account ID
     * @return ThirdPartyTransferDetail instance
     */
    @WebMethod(exclude = true)
    ThirdPartyTransferDetail getThirdPartyTransferDetail(Long thirdPartyPlanId, String accountId);

    /**
     * Returns a list of third-party allowable charges by ThirdPartyPlan ID sorted by priority in the descending order.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return list of ThirdPartyAllowableCharge instances
     */
    List<ThirdPartyAllowableCharge> getThirdPartyAllowableCharges(Long thirdPartyPlanId);

    /**
     * This method takes an account and follows the established third-party plan and applies it to the account.
     * The return value is a ThirdPartyTransferDetail object that explains what occurred during the plan execution.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param accountId        DirectChargeAccount ID
     * @param initiationDate   Initiation date
     * @return ThirdPartyTransferDetail instance
     */
    ThirdPartyTransferDetail generateThirdPartyTransfer(Long thirdPartyPlanId, String accountId, Date initiationDate);

    /**
     * Generates third-party transfers for the given account ID and current date as an open period date
     * ignoring already executed transfers
     *
     * @param accountId DirectChargeAccount ID
     * @return list of ThirdPartyTransferDetail instances
     */
    @WebMethod(exclude = true)
    List<ThirdPartyTransferDetail> generateThirdPartyTransfers(String accountId);

    /**
     * Generates third-party transfers for the given account ID and open period date.
     *
     * @param accountId      DirectChargeAccount ID
     * @param openPeriodDate Date between the open period start and end dates.
     * @param ignoreExecuted if "true" the method ignores "isExecuted" value
     * @return list of ThirdPartyTransferDetail instances
     */
    List<ThirdPartyTransferDetail> generateThirdPartyTransfers(String accountId, Date openPeriodDate, boolean ignoreExecuted);

    /**
     * Generates third-party transfers for each eligible account with the given plan ID
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param ignoreExecuted   if "true" the method ignores "isExecuted" value
     * @return list of ThirdPartyTransferDetail instances
     */
    @WebMethod(exclude = true)
    List<ThirdPartyTransferDetail> generateThirdPartyTransfers(Long thirdPartyPlanId, boolean ignoreExecuted);

    /**
     * Reverses a third-party transaction transfer specified by ThirdPartyTransferDetail ID.
     *
     * @param transferDetailId ThirdPartyTransferDetail ID
     * @param memoText         Memo text
     * @return ThirdPartyTransferDetail instance
     */
    ThirdPartyTransferDetail reverseThirdPartyTransfer(Long transferDetailId, String memoText);


}
