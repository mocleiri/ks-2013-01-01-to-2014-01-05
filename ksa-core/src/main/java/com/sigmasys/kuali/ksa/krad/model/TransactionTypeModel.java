package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.*;

import java.security.PrivateKey;
import java.util.Date;

/**
 * User: timb
 * Date: 11/29/12
 * Time: 11:43 AM
 */
public class TransactionTypeModel extends TransactionType {

    private TransactionType parentEntity;

    private String rollupText;

    private String glBreakdownType;

    private String glBreakdownTooltip;

    public TransactionTypeModel() {
    }

    public TransactionTypeModel(TransactionType entity) {
        setTransactionType(entity);
    }

    public void setTransactionType(TransactionType entity) {
        parentEntity = entity;

        Rollup r = parentEntity.getRollup();
        if(r == null){
            setRollupText("");
        } else {
            setRollupText(r.getDescription());
        }

        this.setGlBreakdownType("Default");
        this.setGlBreakdownTooltip("I don't know how to do this yet");


    }

    public TransactionType getTransactionType() {
        return parentEntity;
    }

    @Override
    public String getCode() {
        if (parentEntity == null || parentEntity.getCode() == null) {
            return "";
        }
        return parentEntity.getCode();
    }

    @Override
    public void setCode(String code) {
        parentEntity.setCode(code);
    }

    @Override
    public String getName() {
        return parentEntity.getName();
    }

    @Override
    public void setName(String name) {
        parentEntity.setName(name);
    }

    @Override
    public String getCreatorId() {
        return parentEntity.getCreatorId();
    }

    @Override
    public void setCreatorId(String creatorId) {
        parentEntity.setCreatorId(creatorId);
    }

    @Override
    public String getEditorId() {
        return parentEntity.getEditorId();
    }

    @Override
    public void setEditorId(String editorId) {
        parentEntity.setEditorId(editorId);
    }

    @Override
    public Date getLastUpdate() {
        return parentEntity.getLastUpdate();
    }

    @Override
    public void setLastUpdate(Date lastUpdate) {
        parentEntity.setLastUpdate(lastUpdate);
    }

    @Override
    public String getDescription() {
        return parentEntity.getDescription();
    }

    @Override
    public void setDescription(String description) {
        parentEntity.setDescription(description);
    }

    @Override
    public Date getCreationDate() {
        return parentEntity.getCreationDate();
    }

    @Override
    public void setCreationDate(Date creationDate) {
        parentEntity.setCreationDate(creationDate);
    }

    @Override
    public String toString() {
        String str = "Auditable Entity Model parent: ";
        if(parentEntity == null){
            return str + null;
        } else {
            return str + parentEntity.toString();
        }
    }

    @Override
    public TransactionTypeId getId() {
        return parentEntity.getId();
    }

    public String getType(){
        if(parentEntity instanceof CreditType){
            return "Credit";
        } else if(parentEntity instanceof DebitType){
            return "Debit";
        } else {
            return "Unknown";
        }
    }

    public String getRollupText() {
        return rollupText;
    }

    public void setRollupText(String rollupText) {
        this.rollupText = rollupText;
    }

    public String getGlBreakdownType() {
        return glBreakdownType;
    }

    public void setGlBreakdownType(String glBreakdownType) {
        this.glBreakdownType = glBreakdownType;
    }

    public String getGlBreakdownTooltip() {
        return glBreakdownTooltip;
    }

    public void setGlBreakdownTooltip(String glBreakdownTooltip) {
        this.glBreakdownTooltip = glBreakdownTooltip;
    }
}
