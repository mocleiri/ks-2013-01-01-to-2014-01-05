package com.sigmasys.kuali.ksa.model;

import java.math.BigDecimal;

/**
 * General Ledger domain object that contains overridden GL information.
 *
 * @author Michael Ivanov
 */
public class GlOverride implements Identifiable {

    private String glAccountId;

    private BigDecimal percentageBreakdown;

    public GlOverride() {
    }

    public GlOverride(String glAccountId, BigDecimal percentageBreakdown) {
        this.glAccountId = glAccountId;
        this.percentageBreakdown = percentageBreakdown;
    }

    @Override
    public String getId() {
        return getGlAccountId() + ":" + getPercentageBreakdown();
    }

    public String getGlAccountId() {
        return glAccountId;
    }

    public void setGlAccountId(String glAccountId) {
        this.glAccountId = glAccountId;
    }

    public BigDecimal getPercentageBreakdown() {
        return percentageBreakdown;
    }

    public void setPercentageBreakdown(BigDecimal percentageBreakdown) {
        this.percentageBreakdown = percentageBreakdown;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof GlOverride)) {
            return false;
        }

        GlOverride glOverride = (GlOverride) object;

        return getId().equals(glOverride.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return getId();
    }

}
