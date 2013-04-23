package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.annotation.Url;
import com.sigmasys.kuali.ksa.model.Constants;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

/**
 * Transaction Export Service.
 *
 * @author Michael Ivanov
 */
@Url(TransactionExportService.SERVICE_URL)
@WebService(serviceName = TransactionExportService.SERVICE_NAME, portName = TransactionExportService.PORT_NAME,
        targetNamespace = Constants.WS_NAMESPACE)
public interface TransactionExportService {

    String SERVICE_URL = "transactionExport.webservice";
    String SERVICE_NAME = "TransactionExportService";
    String PORT_NAME = SERVICE_NAME + "Port";

    /**
     * Gets all the GlTransmission objects with a result that is blank and
     * returns the completed XML file that will be uploaded to KFS or any other external system.
     *
     * @return XML content that contains the transactions to be exported
     */
    String exportTransactions();

    /**
     * Gets GlTransmission objects for the given effective/recognition dates with a result that is blank and
     * returns the completed XML file that will be uploaded to KFS or any other external system.
     *
     * @param startDate       Transaction effective or recognition start date
     * @param endDate         Transaction effective or recognition end date
     * @param isEffectiveDate if "true" this parameter indicates that transaction effective date should be used,
     *                        if "false" - transaction recognition date
     * @return XML content that contains the transactions to be exported
     */
    String exportTransactionsForDates(Date startDate, Date endDate, boolean isEffectiveDate);

    /**
     * Gets GlTransmission objects persisted in the database as XML for the given batch ID
     *
     * @param batchId GL transmission batch ID
     * @return XML content that contains the transactions to be exported
     */
    String exportTransactionsForBatch(String batchId);

    /**
     * Parses the GL account and returns the list of <code>java.util.String</code> values.
     * The format of GL account is organization-specific. The current implementation supports the UMD format.
     *
     * @param glAccount GL account number
     * @return list of String values
     */
    List<String> parseGlAccount(String glAccount);


}
