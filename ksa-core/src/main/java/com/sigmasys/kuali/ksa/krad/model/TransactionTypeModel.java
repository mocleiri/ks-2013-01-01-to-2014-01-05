package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.*;

/**
 * User: timb
 * Date: 11/29/12
 * Time: 11:43 AM
 */
public class TransactionTypeModel extends TransactionType {

    private TransactionType parentEntity;

    public TransactionTypeModel() {
    }

    public TransactionTypeModel(TransactionType entity) {
        setTransactionType(entity);
    }

    public void setTransactionType(TransactionType entity) {
        parentEntity = entity;
    }

    public TransactionType getTransactionType() {
        return parentEntity;
    }
/*
    @Override
    public Long getId() {
        return parentEntity.getId();
    }

    @Override
    public void setId(Long id) {
        parentEntity.setId(id);
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
    */

    @Override
    public TransactionTypeId getId() {
        return parentEntity.getId();
    }
}
