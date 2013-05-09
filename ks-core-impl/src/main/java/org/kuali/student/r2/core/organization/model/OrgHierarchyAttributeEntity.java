package org.kuali.student.r2.core.organization.model;


import org.kuali.student.r2.common.entity.BaseAttributeEntity;
import org.kuali.student.r2.common.infc.Attribute;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class OrgHierarchyAttributeEntity extends BaseAttributeEntity<OrgHierarchyEntity> {

    public OrgHierarchyAttributeEntity() {
        super();
    }

    public OrgHierarchyAttributeEntity(Attribute att, OrgHierarchyEntity owner) {
        super(att, owner);
    }
}
