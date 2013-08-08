package com.sigmasys.kuali.ksa.service.fm;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;

import javax.jws.WebService;

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
}
