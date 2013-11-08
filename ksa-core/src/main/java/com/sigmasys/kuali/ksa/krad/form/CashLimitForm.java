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
     * Error message.
     */
    private String xmlGenerationError;

    /**
     * A comma-separated string of IDs of last completed CashLimitEvents.
     * This is needed to generate an archive of the generated IRS forms 8300.
     */
    private String lastCompletedCashLimitEventIds;


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

    public String getXmlGenerationError() {
        return xmlGenerationError;
    }

    public void setXmlGenerationError(String xmlGenerationError) {
        this.xmlGenerationError = xmlGenerationError;
    }

    public String getLastCompletedCashLimitEventIds() {
        return lastCompletedCashLimitEventIds;
    }

    public void setLastCompletedCashLimitEventIds(String lastCompletedCashLimitEventIds) {
        this.lastCompletedCashLimitEventIds = lastCompletedCashLimitEventIds;
    }
}
