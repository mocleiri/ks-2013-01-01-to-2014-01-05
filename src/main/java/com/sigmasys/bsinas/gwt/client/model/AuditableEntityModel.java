package com.sigmasys.bsinas.gwt.client.model;

import java.util.Date;

/**
 * GWT version of AuditableEntity.
 * It provides basic information about who/when created/updated the entity
 * <p/>
 * @author Michael Ivanov
 * Date: 3/13/12
 * Time: 3:56 PM
 */
public abstract class AuditableEntityModel extends AbstractModel {


    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String CREATOR_ID = "creatorId";
    private static final String EDITOR_ID = "editorId";
    private static final String LAST_UPDATE = "lastUpdate";


    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public String getName() {
        return get(NAME);
    }

    public void setName(String name) {
        set(NAME, name);
    }

    public String getCreatorId() {
        return get(CREATOR_ID);
    }

    public void setCreatorId(String creatorId) {
        set(CREATOR_ID, creatorId);
    }

    public String getEditorId() {
        return get(EDITOR_ID);
    }

    public void setEditorId(String editorId) {
        set(EDITOR_ID, editorId);
    }

    public Date getLastUpdate() {
        return get(LAST_UPDATE);
    }

    public void setLastUpdate(Date lastUpdate) {
        set(LAST_UPDATE, lastUpdate);
    }

    public String getDescription() {
        return get(DESCRIPTION);
    }

    public void setDescription(String description) {
        set(DESCRIPTION, description);
    }


}