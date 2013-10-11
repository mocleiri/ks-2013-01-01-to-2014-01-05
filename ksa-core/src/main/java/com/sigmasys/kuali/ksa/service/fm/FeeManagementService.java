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

    /**
     * Checks if the rules engine is processing a quote generation/assessment scenario.
     *
     * @return <code>true</code> if the rules engine is processing a "What-If" scenario or <code>false</code> otherwise.
     */
    boolean isCalculating();

    /**
     * Checks if the rules engine performs Fee Management that will result in real Account charges/credits.
     *
     * @return <code>true</code> if the FM is in the real charge mode, <code>false</code> otherwise.
     */
    boolean isCharging();

    /**
     * Queues a FeeManagementSession.
     *
     * @param feeManagementSessionId ID of an FM Session to queue.
     */
    void addSessionToQueue(Long feeManagementSessionId);

    /**
     * Dequeues a FeeManagementSession.
     *
     * @param feeManagementSessionId ID of an FM Session to dequeue.
     */
    void removeSessionFromQueue(Long feeManagementSessionId);

    Long assessRealTimeFeeManagement(FeeManagementTermRecord feeManagementTermRecord);

    FeeManagementReportInfo simulateRealTimeFeeManagement(FeeManagementTermRecord feeManagementTermRecord);

    /**
     * This method kicks off the workflow for assessing fees by creating a fee management session and then
     * queuing it up for later execution.
     *
     * @param feeManagementTermRecord   FM Term Record for FM Session creation.
     */
    void queueFeeManagement(FeeManagementTermRecord feeManagementTermRecord);

    /**
     * Accesses an FM Session and invokes the Rules Engine to create a Manifest.
     *
     * @param feeManagementSessionId    ID of an FM session to process.
     * @return  ID of a created Manifest.
     */
    Long processFeeManagementSession(Long feeManagementSessionId);

    /**
     * Creates a new FM Session using the given FM TermRecord.
     *
     * @param feeManagementTermRecord   FM TermRecord.
     * @return The newly generated FM Session.
     */
    Long createFeeManagementSession(FeeManagementTermRecord feeManagementTermRecord);

    FeeManagementReportInfo createFeeManagementReport(Long feeManagementSessionId);
}
