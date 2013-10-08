package com.sigmasys.kuali.ksa.service.fm;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;
import com.sigmasys.kuali.ksa.model.KeyPair;
import com.sigmasys.kuali.ksa.model.fm.FeeManagementManifest;
import com.sigmasys.kuali.ksa.model.fm.FeeManagementManifestType;
import com.sigmasys.kuali.ksa.model.fm.FeeManagementReportInfo;
import com.sigmasys.kuali.ksa.model.fm.FeeManagementTermRecord;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * FeeManagementService.
 * <p/>
 * This interface describes the new FeeManagement Service defined in the "Process Diagrams" document.
 *
 * @author Sergey Godunov
 */
@Url(RateService.SERVICE_URL)
@WebService(serviceName = FeeManagementService.SERVICE_NAME, portName = FeeManagementService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface FeeManagementService {

    String SERVICE_URL = "feeManagement.webservice";
    String SERVICE_NAME = "FeeManagementService";
    String PORT_NAME = SERVICE_NAME + "Port";

    /**
     * Reconciles a FeeManagement session.
     * Session reconciliation takes former sessions and ensures that charges that need to be removed are
     * accurately recorded in the new session.
     *
     * @param feeManagementSessionId FeeManagementSession ID
     */
    void reconcileSession(Long feeManagementSessionId);

    /**
     * Creates charges on the current Fee Management session.
     * Creates reversals and cancellations and also rate transactions.
     *
     * @param feeManagementSessionId FeeManagementSession ID
     */
    void chargeSession(Long feeManagementSessionId);

    /**
     * Returns all FM Manifests associated with an FM Session with the given ID.
     *
     * @param feeManagementSessionId An FM Session ID.
     * @return All associated FM Manifests.
     */
    List<FeeManagementManifest> getManifests(Long feeManagementSessionId);

    /**
     * Returns all FM Manifests of given types associated with an FM Session with the given ID.
     *
     * @param feeManagementSessionId An FM Session ID.
     * @param manifestTypes          Types of FM Manifests to retrieve.
     * @return All associated FM Manifests of given types.
     */
    @WebMethod(exclude = true)
    List<FeeManagementManifest> getManifests(Long feeManagementSessionId, FeeManagementManifestType... manifestTypes);

    boolean isProcessingWhatIfScenarios(String atpId);

    boolean isProcessingRealTimeFm(String atpId);

    void addFeeManagementPeriodSetting(String atpId, String key, String value);

    String getFeeManagementPeriodSetting(String atpId, String key);

    String removeFeeManagementPeriodSetting(String atpId, String key);

    KeyPair getKeyPair(String accountId, String key);

    KeyPair addKeyPair(String accountId, String key, String value);

    KeyPair removeKeyPair(String accountId, String key);

    void addSessionToQueue(Long feeManagementSessionId);

    void removeSessionFromQueue(Long feeManagementSessionId);

    Long assessRealTimeFeeManagement(FeeManagementTermRecord feeManagementTermRecord);

    FeeManagementReportInfo simulateRealTimeFeeManagement(FeeManagementTermRecord feeManagementTermRecord);

    void queueFeeManagement(FeeManagementTermRecord feeManagementTermRecord);

    Long processFeeManagementSession(Long feeManagementSessionId);

    Long createFeeManagementSession(FeeManagementTermRecord feeManagementTermRecord);

    FeeManagementReportInfo createFeeManagementReport(Long feeManagementSessionId);
}
