package com.sigmasys.kuali.ksa.service.tp;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyAllowableCharge;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyPlan;
import com.sigmasys.kuali.ksa.model.tp.ThirdPartyTransferDetail;

import javax.jws.WebMethod;
import javax.jws.WebService;
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
     * Retrieves ThirdPartyPlan instance by ID from the persistent store.
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @return ThirdPartyPlan instance
     */
    ThirdPartyPlan getThirdPartyPlan(Long thirdPartyPlanId);

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
     * Returns the list of third-party allowable charges by ThirdPartyPlan ID sorted by priority in the descending order.
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
     * Generates the third-party transfers for the given account ID and open period date.
     *
     * @param accountId      DirectChargeAccount ID
     * @param openPeriodDate Date between the open period start and end dates.
     * @param ignoreExecuted if "true" the method ignores "isExecuted" value
     * @return list of ThirdPartyTransferDetail instances
     */
    List<ThirdPartyTransferDetail> generateThirdPartyTransfers(String accountId, Date openPeriodDate, boolean ignoreExecuted);

    /**
     * Generates the third-party transfers for each eligible account with the given plan ID
     *
     * @param thirdPartyPlanId ThirdPartyPlan ID
     * @param ignoreExecuted   if "true" the method ignores "isExecuted" value
     * @return list of ThirdPartyTransferDetail instances
     */
    @WebMethod(exclude = true)
    List<ThirdPartyTransferDetail> generateThirdPartyTransfers(Long thirdPartyPlanId, boolean ignoreExecuted);

    /**
     * Reverses the third-party transaction transfer specified by ThirdPartyTransferDetail ID.
     *
     * @param transferDetailId ThirdPartyTransferDetail ID
     * @param memoText         Memo text
     * @return ThirdPartyTransferDetail instance
     */
    ThirdPartyTransferDetail reverseThirdPartyTransfer(Long transferDetailId, String memoText);


}
