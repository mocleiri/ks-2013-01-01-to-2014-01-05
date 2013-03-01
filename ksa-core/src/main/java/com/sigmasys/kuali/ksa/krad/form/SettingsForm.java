package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.AuditableEntityModel;
import com.sigmasys.kuali.ksa.model.*;
import org.kuali.rice.krad.uif.component.BindingInfo;
import org.kuali.rice.krad.uif.component.DataBinding;

import java.util.ArrayList;
import java.util.List;

public class SettingsForm extends AbstractViewModel {

   // Currency stuff

   private Account account;

   private List<AuditableEntityModel> entities;

   private AuditableEntityModel auditableEntity;

   private String statusMessage;

   /*
     Get/Set methods
   */

   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

    public List<AuditableEntityModel> getAuditableEntities() {
        return entities;
    }

    public <T extends AuditableEntity> void setAuditableEntities(List<T> entities) {
        List<AuditableEntityModel> list = new ArrayList<AuditableEntityModel>(entities.size());

        for(AuditableEntity entity : entities){
            AuditableEntityModel m;
            if(entity instanceof AuditableEntityModel){
                m = (AuditableEntityModel)entity;
            } else {
                m = new AuditableEntityModel(entity);
            }
            list.add(m);
        }

        this.entities = list;
    }

    public AuditableEntityModel getAuditableEntity() {
        return auditableEntity;
    }

    public void setAuditableEntity(AuditableEntityModel auditableEntity) {
        if(this.auditableEntity == null){
            this.auditableEntity = auditableEntity;
        }
    }


    public <T extends AuditableEntity> void setAuditableEntity(T auditableEntity) {
        if(auditableEntity instanceof AuditableEntityModel){
            this.auditableEntity = (AuditableEntityModel)auditableEntity;
        } else {
            this.auditableEntity = new AuditableEntityModel(auditableEntity);
        }

    }

    public String getType(){
        if(auditableEntity == null){ return "null"; }
        return auditableEntity.getParentEntity().getClass().getName();
    }

    public String getSimpleType(){
        if(auditableEntity == null){ return "null"; }
        return auditableEntity.getParentEntity().getClass().getSimpleName();
    }

    public String getHumanType(){
            if(auditableEntity == null){ return "Unknown Entity Type"; }
        AuditableEntity parent = auditableEntity.getParentEntity();
        if(parent == null){ return "Unknown Type"; }
        if(parent instanceof AccountStatusType) { return "Account Status Type"; }
        else if (parent instanceof ActivityType) { return "Activity Type"; }
        else if(parent instanceof BankType) { return "Bank Type"; }
        else if(parent instanceof Currency) { return "Currency Type"; }
        else if(parent instanceof FlagType) { return "Flag Type"; }
        else if(parent instanceof LatePeriod) { return "Late Period Type"; }
        else if(parent instanceof Rollup){ return "Rollup Type"; }
        else if(parent instanceof TaxType) { return "Tax Type"; }

        return this.getSimpleType();
    }

    public String getStatusMessage() {
      return statusMessage;
   }

   public void setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
   }
}
