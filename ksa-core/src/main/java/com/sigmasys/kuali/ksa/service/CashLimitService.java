package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.*;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;

/**
 * Cash limit service API.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Url(CashLimitService.SERVICE_URL)
@WebService(serviceName = CashLimitService.SERVICE_NAME, portName = CashLimitService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface CashLimitService {

    String SERVICE_URL = "cashLimit.webservice";
    String SERVICE_NAME = "CashLimitService";
    String PORT_NAME = SERVICE_NAME + "Port";

    /**
     * Creates a new cash limit parameter for the given parameters.
     *
     * @param code          Parameter code
     * @param name          Parameter name
     * @param description   Parameter description
     * @param tag           Parameter tag
     * @param lowerLimit    Lower limit
     * @param upperLimit    Upper limit
     * @param isActive      Indicates whether the new parameter should be active upon creation
     * @param authorityName Authority name
     * @param xmlElement    XML element name
     * @return a new instance of CashLimitParameter
     */
    CashLimitParameter createCashLimitParameter(String code, String name, String description, Tag tag,
                                                BigDecimal lowerLimit, BigDecimal upperLimit, boolean isActive,
                                                String authorityName, String xmlElement);

    /**
     * Persists the given cash limit parameter in the persistent store
     *
     * @param cashLimitParameter CashLimitParameter instance
     * @return Cash limit parameter ID
     */
    Long persistCashLimitParameter(CashLimitParameter cashLimitParameter);

    /**
     * This method will return true if there has been a cash limit event. A <code>CashLimitEvent</code> object will be
     * created and persisted and an email will be sent to the appropriate administrator to allow them to check
     * up on the event. A further step will be required to actually register the event (by producing an 8300
     * form to be filed with the IRS).
     *
     * @param userId Account ID
     * @return true if there has been a cash limit event, otherwise false
     */
    boolean checkCashLimit(String userId);

    /**
     * Retrieves all CashLimitEvent objects for the given user ID and CashLimitEventStatus.
     *
     * @param userId Account ID
     * @param status CashLimitEvent status
     * @return a list of cash limit events
     */
    List<CashLimitEvent> getCashLimitEvents(String userId, CashLimitEventStatus status);


    /**
     * Returns CashLimitEvent object by ID.
     *
     * @param id Cash limit event ID
     * @return CashLimitEvent instance
     */
    CashLimitEvent getCashLimitEvent(Long id);

    /**
     * Retrieves cash limit parameters.
     *
     * @param activeOnly if true only active parameters will be retrieved.
     * @return a list of cash limit parameters
     */
    List<CashLimitParameter> getCashLimitParameters(boolean activeOnly);

    /**
     * Checks if the cash limit parameter exists by code.
     *
     * @param code CashLimitParameter's code
     * @return true if it exists, false - otherwise
     */
    boolean cashLimitParameterExists(String code);

    /**
     * Returns the cash limit parameter by code.
     *
     * @param code CashLimitParameter's code
     * @return CashLimitParameter instance
     */
    CashLimitParameter getCashLimitParameterByCode(String code);

    /**
     * Returns the cash limit parameter by ID.
     *
     * @param id CashLimitParameter's ID
     * @return CashLimitParameter instance
     */
    CashLimitParameter getCashLimitParameter(Long id);

}
