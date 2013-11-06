package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.CashLimitEventModel;
import com.sigmasys.kuali.ksa.model.CashLimitEvent;

import java.util.List;

/**
 * The form behind the Batch - Combined Cash Limit view.
 *
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 11/5/13
 * Time: 3:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class CashLimitForm extends TransactionFilterForm {

    /**
     * A List of CashLimitEventModel object displayed in the screen.
     */
    private List<CashLimitEventModel> cashLimitEvents;

    /**
     * Whether to generate XML documents from selected CashLimitEvents.
     */
    private boolean generateDocumentsFromSelected = true;

    /**
     * Whether to start download of the generated archive after submission.
     */
    private boolean downloadGeneratedArchive = true;

    /**
     * Error message.
     */
    private String xmlGenerationError;


    public List<CashLimitEventModel> getCashLimitEvents() {
        return cashLimitEvents;
    }

    public void setCashLimitEvents(List<CashLimitEventModel> cashLimitEvents) {
        this.cashLimitEvents = cashLimitEvents;
    }

    public boolean isGenerateDocumentsFromSelected() {
        return generateDocumentsFromSelected;
    }

    public void setGenerateDocumentsFromSelected(boolean generateDocumentsFromSelected) {
        this.generateDocumentsFromSelected = generateDocumentsFromSelected;
    }

    public boolean isDownloadGeneratedArchive() {
        return downloadGeneratedArchive;
    }

    public void setDownloadGeneratedArchive(boolean downloadGeneratedArchive) {
        this.downloadGeneratedArchive = downloadGeneratedArchive;
    }

    public String getXmlGenerationError() {
        return xmlGenerationError;
    }

    public void setXmlGenerationError(String xmlGenerationError) {
        this.xmlGenerationError = xmlGenerationError;
    }
}
