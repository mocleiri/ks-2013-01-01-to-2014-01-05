package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.Refund;

/**
 * This class represents a single row in the "Refund Status" table on the Account Refund or Batch Refund screen.
 *
 * User: Sergey
 * Date: 5/18/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RefundModel {

    /**
     * Associated refund.
     */
    private Refund refund;

    /**
     * Whether this Refund is selected for Verification or Cancellation.
     */
    private boolean selected;

    /**
     * The displayable value of the refund status.
     */
    private String refundStatusDisplay;


    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getRefundStatusDisplay() {
        return refundStatusDisplay;
    }

    public void setRefundStatusDisplay(String refundStatusDisplay) {
        this.refundStatusDisplay = refundStatusDisplay;
    }
}
