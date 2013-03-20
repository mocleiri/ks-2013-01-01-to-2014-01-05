/*
 * Copyright 2011 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.r2.core.organization.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.common.UUIDHelper;
import org.kuali.student.common.mock.MockService;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.MetaInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.AlreadyExistsException;
import org.kuali.student.r2.common.exceptions.DataValidationErrorException;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.exceptions.ReadOnlyException;
import org.kuali.student.r2.common.exceptions.VersionMismatchException;
import org.kuali.student.r2.core.class1.type.dto.TypeInfo;
import org.kuali.student.r2.core.organization.dto.OrgHierarchyInfo;
import org.kuali.student.r2.core.organization.dto.OrgInfo;
import org.kuali.student.r2.core.organization.dto.OrgOrgRelationInfo;
import org.kuali.student.r2.core.organization.dto.OrgPersonRelationInfo;
import org.kuali.student.r2.core.organization.dto.OrgPositionRestrictionInfo;
import org.kuali.student.r2.core.organization.dto.OrgTreeViewInfo;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.dto.SearchResultInfo;

import javax.jws.WebParam;


public class OrganizationServiceMockImpl implements MockService, OrganizationService
{
    /**
     * List of hash maps for each entity
     */
    // cache variable
    // The LinkedHashMap is just so the values come back in a predictable order
    private Map<String, OrgHierarchyInfo> orgHierarchyMap = new LinkedHashMap<String, OrgHierarchyInfo>();
    // cache variable
    // The LinkedHashMap is just so the values come back in a predictable order
    private Map<String, OrgInfo> orgMap = new LinkedHashMap<String, OrgInfo>();
    // cache variable
    // The LinkedHashMap is just so the values come back in a predictable order
    private Map<String, OrgOrgRelationInfo> orgOrgRelationMap = new LinkedHashMap<String, OrgOrgRelationInfo>();
    // cache variable
    // The LinkedHashMap is just so the values come back in a predictable order
    private Map<String, OrgPersonRelationInfo> orgPersonRelationMap = new LinkedHashMap<String, OrgPersonRelationInfo>();
    // cache variable
    // The LinkedHashMap is just so the values come back in a predictable order
    private Map<String, OrgPositionRestrictionInfo> orgPositionRestrictionMap = new LinkedHashMap<String, OrgPositionRestrictionInfo>();

    /**
     * clear() should clear all maps.  There should be a map for each entity/DTO.
     */
    @Override
    public void clear() {
        orgHierarchyMap.clear();
        orgMap.clear();
        orgOrgRelationMap.clear();
        orgPersonRelationMap.clear();
        orgPersonRelationMap.clear();
        orgPositionRestrictionMap.clear();
    }

    @Override
    public OrgHierarchyInfo getOrgHierarchy(String orgHierarchyId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (!this.orgHierarchyMap.containsKey(orgHierarchyId)) {
            throw new DoesNotExistException(orgHierarchyId);
        }
        return new OrgHierarchyInfo(this.orgHierarchyMap.get (orgHierarchyId));
    }

    @Override
    public List<OrgHierarchyInfo> getOrgHierarchiesByIds(List<String> orgHierarchyIds, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgHierarchyInfo> list = new ArrayList<OrgHierarchyInfo> ();
        for (String id: orgHierarchyIds) {
            list.add (this.getOrgHierarchy(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getOrgHierarchyIdsByType(String orgHierarchyTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<String> list = new ArrayList<String> ();
        for (OrgHierarchyInfo info: orgHierarchyMap.values ()) {
            if (orgHierarchyTypeKey.equals(info.getTypeKey())) {
                list.add (info.getId ());
            }
        }
        return list;
    }

    @Override
    public List<OrgHierarchyInfo> getOrgHierarchies(ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgHierarchyInfo> orgHierarchies = new ArrayList<OrgHierarchyInfo>();
        for(OrgHierarchyInfo info : orgHierarchyMap.values()) {
            orgHierarchies.add(new OrgHierarchyInfo(info));
        }

        return orgHierarchies;
    }

    @Override
    public List<String> searchForOrgHierarchyIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<OrgHierarchyInfo> searchForOrgHierarchies(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("\"not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<ValidationResultInfo> validateOrgHierarchy(String validationTypeKey, String orgHierarchyTypeKey, OrgHierarchyInfo orgHierarchyInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        // validate
        return new ArrayList<ValidationResultInfo> ();
    }

    @Override
    public OrgHierarchyInfo createOrgHierarchy(String orgHierarchyTypeKey, OrgHierarchyInfo orgHierarchyInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
    {
        // create
        if (!orgHierarchyTypeKey.equals (orgHierarchyInfo.getTypeKey())) {
            throw new InvalidParameterException ("The type parameter does not match the type on the info object");
        }
        OrgHierarchyInfo copy = new OrgHierarchyInfo(orgHierarchyInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        orgHierarchyMap.put(copy.getId(), copy);
        return new OrgHierarchyInfo(copy);
    }

    @Override
    public OrgHierarchyInfo updateOrgHierarchy(String orgHierarchyId, OrgHierarchyInfo orgHierarchyInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
            ,VersionMismatchException
    {
        // update
        if (!orgHierarchyId.equals (orgHierarchyInfo.getId())) {
            throw new InvalidParameterException ("The id parameter does not match the id on the info object");
        }
        OrgHierarchyInfo copy = new OrgHierarchyInfo(orgHierarchyInfo);
        OrgHierarchyInfo old = this.getOrgHierarchy(orgHierarchyInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.orgHierarchyMap .put(orgHierarchyInfo.getId(), copy);
        return new OrgHierarchyInfo(copy);
    }

    @Override
    public StatusInfo deleteOrgHierarchy(String orgHierarchyId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (this.orgHierarchyMap.remove(orgHierarchyId) == null) {
            throw new DoesNotExistException(orgHierarchyId);
        }
        return newStatus();
    }

    @Override
    public List<TypeInfo> getOrgTypes(ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException("not implemented because it has been deprecated");
    }

    @Override
    public OrgInfo getOrg(String orgId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (!this.orgMap.containsKey(orgId)) {
            throw new DoesNotExistException(orgId);
        }
        return new OrgInfo(this.orgMap.get (orgId));
    }

    @Override
    public List<OrgInfo> getOrgsByIds(List<String> orgIds, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgInfo> list = new ArrayList<OrgInfo> ();
        for (String id: orgIds) {
            list.add (this.getOrg(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getOrgIdsByType(String orgTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<String> list = new ArrayList<String> ();
        for (OrgInfo info: orgMap.values ()) {
            if (orgTypeKey.equals(info.getTypeKey())) {
                list.add (info.getId ());
            }
        }
        return list;
    }

    @Override
    public List<String> searchForOrgIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<OrgInfo> searchForOrgs(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<ValidationResultInfo> validateOrg(String validationTypeKey, String orgTypeKey, OrgInfo orgInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        // validate
        return new ArrayList<ValidationResultInfo> ();
    }

    @Override
    public OrgInfo createOrg(String orgTypeKey, OrgInfo orgInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
    {
        // create
        if (!orgTypeKey.equals (orgInfo.getTypeKey())) {
            throw new InvalidParameterException ("The type parameter does not match the type on the info object");
        }
        OrgInfo copy = new OrgInfo(orgInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        orgMap.put(copy.getId(), copy);
        return new OrgInfo(copy);
    }

    @Override
    public OrgInfo updateOrg(String orgId, OrgInfo orgInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
            ,VersionMismatchException
    {
        // update
        if (!orgId.equals (orgInfo.getId())) {
            throw new InvalidParameterException ("The id parameter does not match the id on the info object");
        }
        OrgInfo copy = new OrgInfo(orgInfo);
        OrgInfo old = this.getOrg(orgInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.orgMap .put(orgInfo.getId(), copy);
        return new OrgInfo(copy);
    }

    @Override
    public StatusInfo deleteOrg(String orgId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (this.orgMap.remove(orgId) == null) {
            throw new DoesNotExistException(orgId);
        }
        return newStatus();
    }

    @Override
    public List<TypeInfo> getOrgOrgRelationTypes(ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException("not implemented because deprecated");
    }

    @Override
    public List<TypeInfo> getOrgOrgRelationTypesForOrgType(String orgTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException("not implemented because deprecated");
    }

    @Override
    public List<TypeInfo> getOrgOrgRelationTypesForOrgHierarchy(String orgHierarchyId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException("not implemented because deprecated");
    }

    @Override
    public Boolean hasOrgOrgRelation(String orgId, String comparisonOrgId, String orgOrgRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException {
        for(OrgOrgRelationInfo relationInfo : orgOrgRelationMap.values()) {
            if(relationInfo.getTypeKey().equals(orgOrgRelationTypeKey)) {
                if(relationInfo.getOrgId().equals(orgId) && relationInfo.getRelatedOrgId().equals(comparisonOrgId)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public OrgOrgRelationInfo getOrgOrgRelation(String orgOrgRelationId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (!this.orgOrgRelationMap.containsKey(orgOrgRelationId)) {
            throw new DoesNotExistException(orgOrgRelationId);
        }
        return new OrgOrgRelationInfo(this.orgOrgRelationMap.get (orgOrgRelationId));
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByIds(List<String> orgOrgRelationIds, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgOrgRelationInfo> list = new ArrayList<OrgOrgRelationInfo> ();
        for (String id: orgOrgRelationIds) {
            list.add (this.getOrgOrgRelation(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getOrgOrgRelationIdsByType(String orgOrgRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<String> list = new ArrayList<String> ();
        for (OrgOrgRelationInfo info: orgOrgRelationMap.values ()) {
            if (orgOrgRelationTypeKey.equals(info.getTypeKey())) {
                list.add (info.getId ());
            }
        }
        return list;
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByOrg(String orgId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgOrgRelationInfo> list = new ArrayList<OrgOrgRelationInfo> ();
        for (OrgOrgRelationInfo info: orgOrgRelationMap.values ()) {
            if (orgId.equals(info.getOrgId())) {
                list.add (new OrgOrgRelationInfo(info));
            }
        }
        return list;
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByOrgs(String orgId, String peerOrgId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgOrgRelationInfo> list = new ArrayList<OrgOrgRelationInfo> ();
        for (OrgOrgRelationInfo info: orgOrgRelationMap.values ()) {
            if (orgId.equals(info.getOrgId()) && peerOrgId.equals(info.getRelatedOrgId())) {
                list.add (new OrgOrgRelationInfo(info));
            }
        }
        return list;
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByTypeAndOrg(String orgId, String orgOrgRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgOrgRelationInfo> list = new ArrayList<OrgOrgRelationInfo> ();
        for (OrgOrgRelationInfo info: orgOrgRelationMap.values ()) {
            if (orgId.equals(info.getOrgId())) {
                if (orgOrgRelationTypeKey.equals(info.getTypeKey())) {
                    list.add (new OrgOrgRelationInfo(info));
                }
            }
        }
        return list;
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByTypeAndRelatedOrg(String relatedOrgId, String orgOrgRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgOrgRelationInfo> list = new ArrayList<OrgOrgRelationInfo> ();
        for (OrgOrgRelationInfo info: orgOrgRelationMap.values ()) {
            if (relatedOrgId.equals(info.getRelatedOrgId())) {
                if (orgOrgRelationTypeKey.equals(info.getTypeKey())) {
                    list.add (new OrgOrgRelationInfo(info));
                }
            }
        }
        return list;
    }

    @Override
    public List<String> searchForOrgOrgRelationIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<OrgOrgRelationInfo> searchForOrgOrgRelations(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<ValidationResultInfo> validateOrgOrgRelation(String validationTypeKey, String orgId, String orgPeerId, String orgOrgRelationTypeKey, OrgOrgRelationInfo orgOrgRelationInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        // validate
        return new ArrayList<ValidationResultInfo> ();
    }


    @Override
    public OrgOrgRelationInfo createOrgOrgRelation(String orgId, String orgPeerId, String orgOrgRelationTypeKey, OrgOrgRelationInfo orgOrgRelationInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,DataValidationErrorException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException {
        // create
        if (!orgOrgRelationTypeKey.equals (orgOrgRelationInfo.getTypeKey())) {
            throw new InvalidParameterException ("The type parameter does not match the type on the info object");
        }
        if(!orgId.equals(orgOrgRelationInfo.getOrgId())) {
            throw new InvalidParameterException("The orgId parameter does not match the orgId given on the info object");
        }
        if(!orgPeerId.equals(orgOrgRelationInfo.getRelatedOrgId())) {
            throw new InvalidParameterException("The orgPeerId parameter does not match the relatedOrgId given on the info object");
        }


        OrgOrgRelationInfo copy = new OrgOrgRelationInfo(orgOrgRelationInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        orgOrgRelationMap.put(copy.getId(), copy);
        return new OrgOrgRelationInfo(copy);
    }

    @Override
    public OrgOrgRelationInfo updateOrgOrgRelation(String orgOrgRelationId, OrgOrgRelationInfo orgOrgRelationInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
            ,VersionMismatchException
    {
        // update
        if (!orgOrgRelationId.equals (orgOrgRelationInfo.getId())) {
            throw new InvalidParameterException ("The id parameter does not match the id on the info object");
        }
        OrgOrgRelationInfo copy = new OrgOrgRelationInfo(orgOrgRelationInfo);
        OrgOrgRelationInfo old = this.getOrgOrgRelation(orgOrgRelationInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.orgOrgRelationMap .put(orgOrgRelationInfo.getId(), copy);
        return new OrgOrgRelationInfo(copy);
    }

    @Override
    public StatusInfo deleteOrgOrgRelation(String orgOrgRelationId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (this.orgOrgRelationMap.remove(orgOrgRelationId) == null) {
            throw new DoesNotExistException(orgOrgRelationId);
        }
        return newStatus();
    }

    @Override
    public List<TypeInfo> getOrgPersonRelationTypes(ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException("not implemented because deprecated");
    }

    @Override
    public List<TypeInfo> getOrgPersonRelationTypesForOrgType(String orgTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException("not implemented because deprecated");
    }

    @Override
    public Boolean hasOrgPersonRelation(String orgId, String personId, String orgPersonRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("hasOrgPersonRelation has not been implemented");
    }

    @Override
    public OrgPersonRelationInfo getOrgPersonRelation(String orgPersonRelationId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (!this.orgPersonRelationMap.containsKey(orgPersonRelationId)) {
            throw new DoesNotExistException(orgPersonRelationId);
        }
        return new OrgPersonRelationInfo(this.orgPersonRelationMap.get (orgPersonRelationId));
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByIds(List<String> orgPersonRelationIds, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (String id: orgPersonRelationIds) {
            list.add (this.getOrgPersonRelation(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getOrgPersonRelationIdsByType(String orgPersonRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<String> list = new ArrayList<String> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (orgPersonRelationTypeKey.equals(info.getTypeKey())) {
                list.add (info.getId ());
            }
        }
        return list;
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByOrg(String orgId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (orgId.equals(info.getOrgId())) {
                list.add (new OrgPersonRelationInfo(info));
            }
        }
        return list;
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndOrg(String orgPersonRelationTypeKey, String orgId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (orgPersonRelationTypeKey.equals(info.getTypeKey())) {
                if (orgId.equals(info.getOrgId())) {
                    list.add (new OrgPersonRelationInfo(info));
                }
            }
        }
        return list;
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByPerson(String personId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (personId.equals(info.getPersonId())) {
                list.add (new OrgPersonRelationInfo(info));
            }
        }
        return list;
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndPerson(String orgPersonRelationTypeKey, String personId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (orgPersonRelationTypeKey.equals(info.getTypeKey())) {
                if (personId.equals(info.getPersonId())) {
                    list.add (new OrgPersonRelationInfo(info));
                }
            }
        }
        return list;
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByOrgAndPerson(String orgId, String personId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (orgId.equals(info.getOrgId())) {
                if (personId.equals(info.getPersonId())) {
                    list.add (new OrgPersonRelationInfo(info));
                }
            }
        }
        return list;
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndOrgAndPerson(String orgPersonRelationTypeKey, String orgId, String personId, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPersonRelationInfo> list = new ArrayList<OrgPersonRelationInfo> ();
        for (OrgPersonRelationInfo info: orgPersonRelationMap.values ()) {
            if (orgPersonRelationTypeKey.equals(info.getTypeKey())) {
                if (orgId.equals(info.getOrgId())) {
                    if (personId.equals(info.getPersonId())) {
                        list.add (new OrgPersonRelationInfo(info));
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<String> searchForOrgPersonRelationIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<OrgPersonRelationInfo> searchForOrgPersonRelations(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<ValidationResultInfo> validateOrgPersonRelation(String validationTypeKey, String orgId, String personId, String orgPersonRelationTypeKey, OrgPersonRelationInfo orgPersonRelationInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        // validate
        return new ArrayList<ValidationResultInfo> ();
    }

    @Override
    public OrgPersonRelationInfo createOrgPersonRelation(String orgId, String personId, String orgPersonRelationTypeKey, OrgPersonRelationInfo orgPersonRelationInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,DataValidationErrorException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
    {
        // create
        if (!orgPersonRelationTypeKey.equals (orgPersonRelationInfo.getTypeKey())) {
            throw new InvalidParameterException ("The type parameter does not match the type on the info object");
        }
        if(!orgId.equals(orgPersonRelationInfo.getOrgId())) {
            throw new InvalidParameterException ("The orgId parameter does not match the orgId on the info object");
        }
        if(!personId.equals(orgPersonRelationInfo.getPersonId())) {
            throw new InvalidParameterException ("The personId parameter does not match the personId on the info object");
        }

        OrgPersonRelationInfo copy = new OrgPersonRelationInfo(orgPersonRelationInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        orgPersonRelationMap.put(copy.getId(), copy);
        return new OrgPersonRelationInfo(copy);
    }

    @Override
    public OrgPersonRelationInfo updateOrgPersonRelation(String orgPersonRelationId, OrgPersonRelationInfo orgPersonRelationInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
            ,VersionMismatchException
    {
        // update
        if (!orgPersonRelationId.equals (orgPersonRelationInfo.getId())) {
            throw new InvalidParameterException ("The id parameter does not match the id on the info object");
        }
        OrgPersonRelationInfo copy = new OrgPersonRelationInfo(orgPersonRelationInfo);
        OrgPersonRelationInfo old = this.getOrgPersonRelation(orgPersonRelationInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.orgPersonRelationMap .put(orgPersonRelationInfo.getId(), copy);
        return new OrgPersonRelationInfo(copy);
    }

    @Override
    public StatusInfo deleteOrgPersonRelation(String orgPersonRelationId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (this.orgPersonRelationMap.remove(orgPersonRelationId) == null) {
            throw new DoesNotExistException(orgPersonRelationId);
        }
        return newStatus();
    }

    @Override
    public OrgPositionRestrictionInfo getOrgPositionRestriction(String orgPositionRestrictionId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (!this.orgPositionRestrictionMap.containsKey(orgPositionRestrictionId)) {
            throw new DoesNotExistException(orgPositionRestrictionId);
        }
        return new OrgPositionRestrictionInfo(this.orgPositionRestrictionMap.get (orgPositionRestrictionId));
    }

    @Override
    public List<OrgPositionRestrictionInfo> getOrgPositionRestrictionsByIds(List<String> orgPositionRestrictionIds, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<OrgPositionRestrictionInfo> list = new ArrayList<OrgPositionRestrictionInfo> ();
        for (String id: orgPositionRestrictionIds) {
            list.add (this.getOrgPositionRestriction(id, contextInfo));
        }
        return list;
    }

    @Override
    public List<String> getOrgPositionRestrictionIdsByType(String orgPersonRelationTypeKey, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException {
        List<String> list = new ArrayList<String> ();

        for(OrgPositionRestrictionInfo info : orgPositionRestrictionMap.values()) {
            if(info.getOrgPersonRelationTypeKey().equals(orgPersonRelationTypeKey)) {
                list.add(info.getId());
            }
        }

        return list;
    }

    @Override
    public List<String> getOrgPositionRestrictionIdsByOrg(String orgId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        List<String> list = new ArrayList<String> ();
        for (OrgPositionRestrictionInfo info: orgPositionRestrictionMap.values ()) {
            if (orgId.equals(info.getOrgId())) {
                list.add (info.getId ());
            }
        }
        return list;
    }

    @Override
    public List<String> searchForOrgPositionRestrictionIds(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<OrgPositionRestrictionInfo> searchForOrgPositionRestrictions(QueryByCriteria criteria, ContextInfo contextInfo)
            throws InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("not implemented because search isn't conveniently mockable");
    }

    @Override
    public List<ValidationResultInfo> validateOrgPositionRestriction(String validationTypeKey, String orgId, String orgPersonRelationTypeKey, OrgPositionRestrictionInfo orgPositionRestrictionInfo, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        // validate
        return new ArrayList<ValidationResultInfo> ();
    }

    @Override
    public OrgPositionRestrictionInfo createOrgPositionRestriction(String orgId, String orgPersonRelationTypeKey, OrgPositionRestrictionInfo orgPositionRestrictionInfo, ContextInfo contextInfo)
            throws AlreadyExistsException
            ,DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException {
        if (!orgId.equals(orgPositionRestrictionInfo.getOrgId())) {
            throw new InvalidParameterException("The orgId parameter does not match the orgId on the info object");
        }
        if (!orgPersonRelationTypeKey.equals(orgPositionRestrictionInfo.getOrgPersonRelationTypeKey())) {
            throw new InvalidParameterException("The orgPersonRelationTypeKey parameter does not match the orgPersonRelationTypeKey on the info object");
        }
        OrgPositionRestrictionInfo copy = new OrgPositionRestrictionInfo(orgPositionRestrictionInfo);
        if (copy.getId() == null) {
            copy.setId(UUIDHelper.genStringUUID());
        }
        copy.setMeta(newMeta(contextInfo));
        orgPositionRestrictionMap.put(copy.getId(), copy);
        return new OrgPositionRestrictionInfo(copy);
    }

    @Override
    public OrgPositionRestrictionInfo updateOrgPositionRestriction(String orgPositionRestrictionId, OrgPositionRestrictionInfo orgPositionRestrictionInfo, ContextInfo contextInfo)
            throws DataValidationErrorException
            ,DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
            ,ReadOnlyException
            ,VersionMismatchException
    {
        // update
        if (!orgPositionRestrictionId.equals (orgPositionRestrictionInfo.getId())) {
            throw new InvalidParameterException ("The id parameter does not match the id on the info object");
        }
        OrgPositionRestrictionInfo copy = new OrgPositionRestrictionInfo(orgPositionRestrictionInfo);
        OrgPositionRestrictionInfo old = this.getOrgPositionRestriction(orgPositionRestrictionInfo.getId(), contextInfo);
        if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
            throw new VersionMismatchException(old.getMeta().getVersionInd());
        }
        copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
        this.orgPositionRestrictionMap .put(orgPositionRestrictionInfo.getId(), copy);
        return new OrgPositionRestrictionInfo(copy);
    }

    @Override
    public StatusInfo deleteOrgPositionRestriction(String orgPositionRestrictionId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        if (this.orgPositionRestrictionMap.remove(orgPositionRestrictionId) == null) {
            throw new DoesNotExistException(orgPositionRestrictionId);
        }
        return newStatus();
    }

    @Override
    public Boolean isDescendant(String orgId, String descendantOrgId, String orgHierarchyId, ContextInfo contextInfo)
            throws InvalidParameterException
            , MissingParameterException
            , OperationFailedException
            , PermissionDeniedException {
        OrgHierarchyInfo orgHierarchyInfo = null;
        try {
            orgHierarchyInfo = getOrgHierarchy(orgHierarchyId, contextInfo);
        } catch (DoesNotExistException e) {
            throw new InvalidParameterException("orgHierarchy with given orgHierarchyId does not exist.");
        }

        for (String type : orgHierarchyInfo.getOrgOrgRelationTypes()) {
            for (OrgOrgRelationInfo info : orgOrgRelationMap.values()) {
                if (info.getTypeKey().equals(type)) {
                    if (isDescendant(orgId, descendantOrgId, info.getOrgId(), new HashSet<String>(), contextInfo)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /*
     * Determines if descendantOrgId is a descendent of orgId using the given currentOrgId.
     */
    private boolean isDescendant(String orgId, String descendantOrgId, String currentOrgId, Set<String> visitedOrgIds, ContextInfo contextInfo)
            throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        for (OrgOrgRelationInfo relationInfo : getOrgOrgRelationsByOrg(currentOrgId, contextInfo)) {
            //don't visit an org if we have already visited it.
            if (visitedOrgIds.add(relationInfo.getRelatedOrgId())) {
                if (relationInfo.getOrgId().equals(orgId)) {
                    //we found the parent in the tree.  Now find the descendant in the tree.
                    if (relationInfo.getRelatedOrgId().equals(descendantOrgId) ||
                            isDescendant(descendantOrgId, null, relationInfo.getRelatedOrgId(), visitedOrgIds, contextInfo)) {
                        return true;
                    }
                } else {
                    //Either the descendant is null and the next relation has orgId or we need to keep going down the tree.
                    //This makes the assumption that a null descendant indicates that we have already found the parent.
                    if ((descendantOrgId == null && relationInfo.getRelatedOrgId().equals(orgId)) ||
                            isDescendant(orgId, descendantOrgId, relationInfo.getRelatedOrgId(), visitedOrgIds, contextInfo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> getAllDescendants(String orgId, String orgHierarchyId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("getAllDescendants has not been implemented because it is deprecated");
    }

    @Override
    public List<String> getAllAncestors(String orgId, String orgHierarchyId, ContextInfo contextInfo)
            throws DoesNotExistException
            ,InvalidParameterException
            ,MissingParameterException
            ,OperationFailedException
            ,PermissionDeniedException
    {
        throw new OperationFailedException ("getAllAncestors has not been implemented because it is deprecated");
    }

    @Override
    public OrgTreeViewInfo getOrgTree(String rootOrgId, String orgHierarchyId, int maxLevels, ContextInfo contextInfo)
            throws DoesNotExistException
            , InvalidParameterException
            , MissingParameterException
            , OperationFailedException
            , PermissionDeniedException {

        OrgHierarchyInfo orgHierarchyInfo = null;
        try {
            orgHierarchyInfo = getOrgHierarchy(orgHierarchyId, contextInfo);
        } catch (DoesNotExistException e) {
            throw new InvalidParameterException("orgHierarchy with given orgHierarchyId does not exist.");
        }

        Map<String, OrgTreeViewInfo> visitedNodes = new HashMap<String, OrgTreeViewInfo>();
        OrgTreeViewInfo orgTreeViewInfo = null;
        for (String type : orgHierarchyInfo.getOrgOrgRelationTypes()) {
            for (OrgOrgRelationInfo info : orgOrgRelationMap.values()) {
                if (info.getTypeKey().equals(type)) {
                    OrgTreeViewInfo currTree = buildOrgTree(rootOrgId, info.getOrgId(), maxLevels, null, visitedNodes, contextInfo);
                    if (orgTreeViewInfo == null) {
                        orgTreeViewInfo = currTree;
                    }
                }
            }
        }

        return orgTreeViewInfo;
    }

    /*
     * First find rootOrg in the tree.  Then build the tree from that org down.
     * After that is complete, build the portion of tree above rootOrg.
     */
    private OrgTreeViewInfo buildOrgTree(String rootOrgId, String currentOrgId, int maxLevels, OrgTreeViewInfo parent, Map<String, OrgTreeViewInfo> visitedNodes, ContextInfo contextInfo)
            throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException, DoesNotExistException {
        OrgTreeViewInfo orgTree = visitedNodes.get(currentOrgId);
        if(orgTree == null) {
            orgTree = new OrgTreeViewInfo();
            orgTree.setOrg(getOrg(currentOrgId, contextInfo));
        }

        if (currentOrgId.equals(rootOrgId)) {
            //we found the rootOrgId.  Now build from the root, assuming that maxLevels is greater than zero.
            if (maxLevels >= 0) {
                buildOrgTreeFromRoot(orgTree, maxLevels, 1, visitedNodes, contextInfo);
            }
            if(maxLevels <= 0 && parent != null) {
                addToOrgTree(parent, orgTree);
            }

            return orgTree;
        } else {
            OrgTreeViewInfo foundChild = null;
            for (OrgOrgRelationInfo relationInfo : getOrgOrgRelationsByOrg(currentOrgId, contextInfo)) {
                visitedNodes.put(currentOrgId, orgTree);
                int depth = -1;
                OrgTreeViewInfo child = visitedNodes.get(relationInfo.getRelatedOrgId());
                if(child == null) {
                    child = buildOrgTree(rootOrgId, relationInfo.getRelatedOrgId(), maxLevels, orgTree, visitedNodes, contextInfo);
                    if(child != null) {
                        depth = getOrgDepth(child, rootOrgId, new HashSet<String>());
                    }
                } else {
                    //if we have already been to child and it contains the rootOrg then see if
                    //we need to add ourselves.
                    depth = getOrgDepth(child, rootOrgId, new HashSet<String>());
                    if(depth >= 0 && (maxLevels == 0 || (maxLevels < 0 && depth >= maxLevels))) {
                        addToOrgTree(orgTree, child);
                    }
                }

                if(depth >= 0) {
                    if(child.getOrg().getId().equals(rootOrgId)) {
                        foundChild = child;
                    }
                    if (parent != null && (maxLevels == 0 || (maxLevels < 0 && depth > maxLevels))) {
                        addToOrgTree(parent, orgTree);
                    }
                }
            }
            return foundChild;
        }
    }

    /*
     * Determine how far down the given orgTree we need to traverse before
     * finding the given orgId.
     */
    private int getOrgDepth(OrgTreeViewInfo orgTree, String orgId, Set<String> visitedNodes) {
        if(orgTree.getOrg().getId().equals(orgId)) {
            return 0;
        }

        if(visitedNodes.add(orgTree.getOrg().getId())) {
            for(OrgTreeViewInfo child : orgTree.getChildren()) {
                int depth = getOrgDepth(child, orgId, visitedNodes);
                if(depth >= 0) {
                    return depth + 1;
                }
            }
        }
        return -1;
    }

    /*
     * Using the given orgTreeRoot descend down the tree, while currentLevel is less than maxLevels, building the tree.
     */
    private void buildOrgTreeFromRoot(OrgTreeViewInfo orgTree, int maxLevels, int currentLevel, Map<String, OrgTreeViewInfo> visitedNodes, ContextInfo contextInfo)
            throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException, DoesNotExistException {
        if(maxLevels == 0 || currentLevel <= maxLevels) {
            visitedNodes.put(orgTree.getOrg().getId(), orgTree);
            for (OrgOrgRelationInfo relationInfo : getOrgOrgRelationsByOrg(orgTree.getOrg().getId(), contextInfo)) {
                OrgTreeViewInfo childTree = visitedNodes.get(relationInfo.getRelatedOrgId());
                if(childTree == null) {
                    childTree = new OrgTreeViewInfo();
                    childTree.setOrg(getOrg(relationInfo.getRelatedOrgId(), contextInfo));
                }
                addToOrgTree(orgTree, childTree);
                if(maxLevels == 0 || currentLevel < maxLevels) {
                    if(visitedNodes.get(relationInfo.getRelatedOrgId()) == null) {
                        buildOrgTreeFromRoot(childTree, maxLevels, currentLevel + 1, visitedNodes, contextInfo);
                    }
                }
            }
        }
    }

    private void addToOrgTree(OrgTreeViewInfo parent, OrgTreeViewInfo child) {
        addToOrgTree(parent.getChildren(), child);
        addToOrgTree(child.getParents(), parent);
    }

    private void addToOrgTree(List<OrgTreeViewInfo> orgTreeList, OrgTreeViewInfo orgTreeViewInfo) {
        for(OrgTreeViewInfo currentTree : orgTreeList) {
            if(currentTree.getOrg().getId().equals(orgTreeViewInfo.getOrg().getId())) {
                return;
            }
        }
        orgTreeList.add(orgTreeViewInfo);
    }


    private StatusInfo newStatus() {
        StatusInfo status = new StatusInfo();
        status.setSuccess(Boolean.TRUE);
        return status;
    }

    private MetaInfo newMeta(ContextInfo context) {
        MetaInfo meta = new MetaInfo();
        meta.setCreateId(context.getPrincipalId());
        meta.setCreateTime(new Date());
        meta.setUpdateId(context.getPrincipalId());
        meta.setUpdateTime(meta.getCreateTime());
        meta.setVersionInd("0");
        return meta;
    }

    private MetaInfo updateMeta(MetaInfo old, ContextInfo context) {
        MetaInfo meta = new MetaInfo(old);
        meta.setUpdateId(context.getPrincipalId());
        meta.setUpdateTime(new Date());
        meta.setVersionInd((Integer.parseInt(meta.getVersionInd()) + 1) + "");
        return meta;
    }

    @Override
    public List<TypeInfo> getSearchTypes(@WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException {
        throw new OperationFailedException("not implemented because search isn't conveniently mockable");
    }

    @Override
    public TypeInfo getSearchType(@WebParam(name = "searchTypeKey") String searchTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        throw new OperationFailedException("not implemented because search isn't conveniently mockable");
    }

    @Override
    public SearchResultInfo search(SearchRequestInfo searchRequestInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        throw new OperationFailedException("not implemented because search isn't conveniently mockable");
    }
}

