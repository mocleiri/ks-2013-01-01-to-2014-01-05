package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.krad.util.AuditTooltipUtil;
import com.sigmasys.kuali.ksa.model.Information;
import com.sigmasys.kuali.ksa.model.InformationAccessLevel;

import java.util.Date;


public class InformationModel {
    private Information parentEntity;

    public InformationModel() {

    }

    public InformationModel(Information i){
        parentEntity = i;
    }

    public Information getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(Information parentEntity) {
        this.parentEntity = parentEntity;
    }

    public Long getId(){
        return parentEntity.getId();
    }

    public String getText(){
        return parentEntity.getText();
    }

    public String getDisplayValue(){
        return parentEntity.getDisplayValue();
    }

    public Date getEffectiveDate(){
        return parentEntity.getEffectiveDate();
    }

    public String getAccessLevel(){
        InformationAccessLevel level = parentEntity.getAccessLevel();
        String accessLevel = "";
        if(level != null){
            accessLevel = level.getName();
        }
        return accessLevel;
    }

    public String getAuditTooltip(){
        return AuditTooltipUtil.getAuditTooltip(parentEntity);
    }
}
