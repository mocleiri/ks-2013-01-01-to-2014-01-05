package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.krad.util.AuditTooltipUtil;
import com.sigmasys.kuali.ksa.model.Information;
import com.sigmasys.kuali.ksa.model.InformationAccessLevel;

import java.util.Date;


public class InformationModel {

    private Information information;

    public InformationModel() {

    }

    public InformationModel(Information information) {
        this.information = information;
    }

    public Information getParentEntity() {
        return information;
    }

    public void setParentEntity(Information parentEntity) {
        this.information = parentEntity;
    }

    public Long getId() {
        return information.getId();
    }

    public String getText() {
        return information.getText();
    }

    public String getDisplayValue() {
        return information.getDisplayValue();
    }

    public Date getEffectiveDate() {
        return information.getEffectiveDate();
    }

    public String getAccessLevel() {
        InformationAccessLevel level = information.getAccessLevel();
        return (level != null) ? level.getName() : "";
    }

    public String getAuditTooltip() {
        return AuditTooltipUtil.getAuditTooltip(information);
    }
}
