package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.CashLimitEvent;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A model object for the "Combined Cash Limit" collection of CashLimitEvents.
 *
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 11/5/13
 * Time: 3:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class CashLimitEventModel implements Serializable {

    /**
     * A CashLimitEvent object.
     */
    private CashLimitEvent cashLimitEvent;

    /**
     * Whether this row is marked selected.
     */
    private boolean selected;

    /**
     * CashLimitEvent status string for display.
     */
    private String statusString;

    /**
     * Total cash amount.
     */
    private BigDecimal totalCashAmount;


    public CashLimitEvent getCashLimitEvent() {
        return cashLimitEvent;
    }

    public void setCashLimitEvent(CashLimitEvent cashLimitEvent) {
        this.cashLimitEvent = cashLimitEvent;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public BigDecimal getTotalCashAmount() {
        return totalCashAmount;
    }

    public void setTotalCashAmount(BigDecimal totalCashAmount) {
        this.totalCashAmount = totalCashAmount;
    }
}
