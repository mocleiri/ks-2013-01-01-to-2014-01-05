package org.kuali.student.ap.test.mock;

import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.StatusInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
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
import org.kuali.student.r2.core.organization.dto.OrgTreeInfo;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.dto.SearchResultInfo;

import javax.jws.WebParam;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: johglove
 * Date: 11/19/13
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrganizationServiceMockTest implements OrganizationService {
    /**
     * Retrieves a single OrgHierarchy by OrgHierarchy Id.
     *
     * @param orgHierarchyId the identifier for the OrgHierarchy to be
     *                       retrieved
     * @param contextInfo    information containing the principalId and
     *                       locale information about the caller of service operation
     * @return the OrgHierarchy requested
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgHierarchyId not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgHierarchyId or contextInfo
     *          is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public OrgHierarchyInfo getOrgHierarchy(@WebParam(name = "orgHierarchyId") String orgHierarchyId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgHierarchies from a list of OrgHierarchy
     * Ids. The returned list may be in any order and if duplicate Ids
     * are supplied, a unique set may or may not be returned.
     *
     * @param orgHierarchyIds a list of OrgHierarchy Ids
     * @param contextInfo     information containing the principalId and
     *                        locale information about the caller of service operation
     * @return a list of OrgHierarchies
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          an orgHierarchyId in the list not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgHierarchyIds, an id in
     *          orgHierarchyIds, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgHierarchyInfo> getOrgHierarchiesByIds(@WebParam(name = "orgHierarchyIds") List<String> orgHierarchyIds, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgHierarchy Ids by OrgHierarchy Type.
     *
     * @param orgHierarchyTypeKey an identifier for the OrgHierarchy
     *                            type
     * @param contextInfo         information containing the principalId and
     *                            locale information about the caller of service operation
     * @return a list of OrgHierarchy Ids matching orgHierarchyTypeKey
     *         or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is invalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgHierarchyTypeKey or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getOrgHierarchyIdsByType(@WebParam(name = "orgHierarchyTypeKey") String orgHierarchyTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the list of all organization hierarchies known by
     * this service.
     *
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of organization hierarchies
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgHierarchyInfo> getOrgHierarchies(@WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for Org Hierarchy Ids that meet the given search criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of Org identifiers matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> searchForOrgHierarchyIds(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for Org Hierarchies that meet the given search criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of Orgs matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgHierarchyInfo> searchForOrgHierarchies(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the list of types of organizations known by this service.
     *
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of organization types
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<TypeInfo> getOrgTypes(@WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a a single Org by Org Id.
     *
     * @param orgId       the identifier for the Org to be retrieved
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return the Org requested
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public OrgInfo getOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of Orgs from a list of Org Ids. The returned
     * list may be in any order and if duplicate Ids are supplied, a
     * unique set may or may not be returned.  identifiers.
     *
     * @param orgIds      a list of Org Ids
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of Orgs
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          an orgId in the list not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgIds, an orgId in orgIds,
     *          or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgInfo> getOrgsByIds(@WebParam(name = "orgIds") List<String> orgIds, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of Org Ids by Org Type.
     *
     * @param orgTypeKey  an identifier for the Org type
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of Org Ids matching orgTypeKey or an empty list
     *         if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is invalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgTypeKey or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getOrgIdsByType(@WebParam(name = "orgTypeKey") String orgTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for Org Ids that meet the given search criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of Org identifiers matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> searchForOrgIds(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for Orgs that meet the given search criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of Orgs matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgInfo> searchForOrgs(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Validates an Organization. Depending on the value of
     * validationType, this validation could be limited to tests on
     * just the current object and its directly contained sub-objects
     * or expanded to perform all tests related to this Org. If an
     * identifier is present for the Org (and/or one of its contained
     * sub-objects) and a record is found for that identifier, the
     * validation checks if the Org can be shifted to the new
     * values. If a an identifier is not present or a record does not
     * exist, the validation checks if the Org with the given data can
     * be created.
     *
     * @param validationTypeKey the identifier for the validation Type
     * @param orgTypeKey        the identifier for the Org Type to be validated
     * @param orgInfo           the identifier for the Org to be validated
     * @param contextInfo       information containing the principalId and
     *                          locale information about the caller of service operation
     * @return a list of validation results or an empty list if validation
     *         succeeded
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          validationTypeKey or orgTypeKey
     *          is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgInfo or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          validationTypeKey, orgTypeKey
     *          orgInfo, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<ValidationResultInfo> validateOrg(@WebParam(name = "validationTypeKey") String validationTypeKey, @WebParam(name = "orgTypeKey") String orgTypeKey, @WebParam(name = "orgInfo") OrgInfo orgInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Creates a new Org. The Org Id, Type and Meta information may
     * not be set in the supplied data object.
     *
     * @param orgTypeKey  a unique identifier for the Type of the new
     *                    Org
     * @param orgInfo     the data with which to create the Org
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return the new Org
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgTypeKey does not exist or is
     *          not supported
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgInfo or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgTypeKey, orgInfo, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read only
     */
    @Override
    public OrgInfo createOrg(@WebParam(name = "orgTypeKey") String orgTypeKey, @WebParam(name = "orgInfo") OrgInfo orgInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Updates an existing Org. The Org id, Type, and
     * Meta information may not be changed.
     *
     * @param orgId       the identifier for the Org to be updated
     * @param orgInfo     the new data for the Org
     * @param contextInfo information containing the principalId and locale
     *                    information about the caller of service operation
     * @return the updated Org
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgInfo or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, orgInfo, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read only
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     *          an optimistic locking failure
     *          or the action was attempted on an out of date version
     */
    @Override
    public OrgInfo updateOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "orgInfo") OrgInfo orgInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Deletes an existing Org.
     *
     * @param orgId       the identifier for the Org to be deleted
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return the status of the operation. This must always be true.
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public StatusInfo deleteOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the list of all types of relationships between
     * organizations known to the service.
     *
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of organization to organization relationship types
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<TypeInfo> getOrgOrgRelationTypes(@WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the Types of relationships between organizations that
     * are allowed for a particular type of organization.
     *
     * @param orgTypeKey  an identifier for an Org Type
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of relationship types between organizations for
     *         the specified organization type or an empty list if
     *         none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgTypeKey or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<TypeInfo> getOrgOrgRelationTypesForOrgType(@WebParam(name = "orgTypeKey") String orgTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the Types of relationships between organizations that
     * are allowed for a particular type of organization.
     *
     * @param orgTypeKey  an identifier for an Org Type
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of relationship types between organizations for
     *         the specified organization type or an empty list if
     *         none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgTypeKey or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public TypeInfo getOrgOrgRelationTypeForOrgType(@WebParam(name = "orgTypeKey") String orgTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the Types of relationships between organizations that
     * are allowed for a particular organization hierarchy.
     *
     * @param orgHierarchyId an identifier for an OrgHierarchy
     * @param contextInfo    information containing the principalId and
     *                       locale information about the caller of service operation
     * @return a list of relationship types between organizations
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgHierarchyId is is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgHierarchyId or contextInfo
     *          is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<TypeInfo> getOrgOrgRelationTypesForOrgHierarchy(@WebParam(name = "orgHierarchyId") String orgHierarchyId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Tests if a org has a current relationship with a specified organization.
     *
     * @param orgId                 identifier of the organization
     * @param comparisonOrgId       identifier of the organization to be compared to
     * @param orgOrgRelationTypeKey type of relationship between the organizations
     * @param contextInfo           information containing the principalId and
     *                              locale information about the caller of service operation
     * @return true if a relationship between the two Ids exists, false
     *         if no relation exists or is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, comparisonOrgId,
     *          orgOrgRelationType, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public Boolean hasOrgOrgRelation(@WebParam(name = "orgId") String orgId, @WebParam(name = "comparisonOrgId") String comparisonOrgId, @WebParam(name = "orgOrgRelationTypeKey") String orgOrgRelationTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a single OrgOrgRelation by OrgOrgRelation Id.
     *
     * @param orgOrgRelationId the identifier for OrgOrgRelation to be
     *                         retrieved
     * @param contextInfo      information containing the principalId and
     *                         locale information about the caller of service operation
     * @return the OrgOrgRelation requested
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgOrgRelationId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgOrgRelationId or contextInfo
     *          is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public OrgOrgRelationInfo getOrgOrgRelation(@WebParam(name = "orgOrgRelationId") String orgOrgRelationId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgOrgRelations from a list of
     * OrgOrgRelation Ids.  The returned list may be in any order and
     * if duplicate Ids are supplied, a unique set may or may not be
     * returned.
     *
     * @param orgOrgRelationIds a list of OrgOrgRelation identifiers
     * @param contextInfo       information containing the principalId and
     *                          locale information about the caller of service operation
     * @return a list of OrgOrgRelations
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          an orgOrgRelationId in the list not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgOrgRelationIds, an
     *          orgOrgRelationId in the orgOrgRelationIds, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByIds(@WebParam(name = "orgOrgRelationIds") List<String> orgOrgRelationIds, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgOrgRelation Ids by OrgOrgRelation Type.
     *
     * @param orgOrgRelationTypeKey an identifier for an OrgOrgRelation Type
     * @param contextInfo           information containing the principalId and
     *                              locale information about the caller of service operation
     * @return a list of OrgOrgRelation identifiers matching
     *         orgOrgRelationTypeKey or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgOrgRelationTypeKey or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getOrgOrgRelationIdsByType(@WebParam(name = "orgOrgRelationTypeKey") String orgOrgRelationTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves all OrgOrgRelations to the given Org independent of
     * which side of the relationship the Org resides.
     *
     * @param orgId       the identifier for the Org
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of OrgOrgrelations to the given Org or an empty list if
     *         none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves all OrgOrgRelations between the given Orgs.
     *
     * @param orgId       the identifier for the Org
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of OrgOrgrelations between the given Orgs or an empty list
     *         if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, orgPeerId, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByOrgs(@WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgOrgRelations of the specified
     * OrgOrgRelationType for an Org. (these parameters are
     * backwards).
     *
     * @param orgId                 the identifier for an Org
     * @param orgOrgRelationTypeKey the identifier for an
     *                              OrgOrgRelation Type
     * @param contextInfo           information containing the principalId and locale
     *                              information about the caller of service operation
     * @return a list of OrgOrgRelations of the specified OrgOrgRelationType for
     *         the given Org or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is notvalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgOrgRelationTypeKey, orgId, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByTypeAndOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "orgOrgRelationTypeKey") String orgOrgRelationTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for OrgOrgRelations that meet the given search criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and locale
     *                    information about the caller of service operation
     * @return a list of OrgOrgRelation identifiers matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> searchForOrgOrgRelationIds(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for OrgOrgRelations that meet the given search
     * criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and locale
     *                    information about the caller of service operation
     * @return a list of OrgOrgRelations matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is invalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgOrgRelationInfo> searchForOrgOrgRelations(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Validates an OrgOrgRelation. Depending on the value of
     * validationType, this validation could be limited to tests on
     * just the current OrgOrgRelation and its directly contained
     * sub-objects or expanded to perform all tests related to this
     * OrgOrgRelation. If an identifier is present for the
     * OrgOrgRelation (and/or one of its contained sub-objects) and a
     * record is found for that identifier, the validation checks if
     * the OrgOrgRelation can be shifted to the new values. If an
     * identifier is not present or a record cannot be found for the
     * identifier, the validation checks if the object with the given
     * data can be created.
     *
     * @param validationTypeKey     the identifier for the validation Type
     * @param orgId                 the identifier for an Org
     * @param orgPeerId             a the identifier for the Org peer
     * @param orgOrgRelationTypeKey the identifier for the OrgOrgRelation Type
     * @param orgOrgRelationInfo    the OrgOrgRelation to be validated
     * @param contextInfo           information containing the principalId and locale
     *                              information about the caller of service operation
     * @return a list of validation results or an empty list if validation
     *         succeeded
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          validationTypeKey, orgId,
     *          orgPeerId, or orgOrgRelationTypeKey is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgOrgRelationInfo or
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          validationTypeKey, orgId,
     *          orgPeerId, orgOrgRelationTypeKey, orgOrgRelationInfo,
     *          or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          authorization failure
     */
    @Override
    public List<ValidationResultInfo> validateOrgOrgRelation(@WebParam(name = "validationTypeKey") String validationTypeKey, @WebParam(name = "orgId") String orgId, @WebParam(name = "orgPeerId") String orgPeerId, @WebParam(name = "orgOrgrelationTypeKey") String orgOrgRelationTypeKey, @WebParam(name = "orgOrgRelationInfo") OrgOrgRelationInfo orgOrgRelationInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Creates a new OrgOrgRelation. The OrgOrgRelation Id, Type, Org
     * Ids, and Meta information may not be set in the supplied data.
     *
     * @param orgId                 a peer of the relationship
     * @param orgPeerId             a peer of the relationship
     * @param orgOrgRelationTypeKey the identifier for the Type of OrgOrgRelation
     * @param orgOrgRelationInfo    the relationship to be created
     * @param contextInfo           information containing the principalId and locale
     *                              information about the caller of service operation
     * @return the new OrgOrgRelation
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgId, orgPeerId, or
     *          orgOrgRelationTypeKey is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgOrgRelationInfo or contextInfo is
     *          not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, orgPeerId,
     *          orgOrgRelationTypeKey, orgOrgRelationInfo, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read only
     */
    @Override
    public OrgOrgRelationInfo createOrgOrgRelation(@WebParam(name = "orgId") String orgId, @WebParam(name = "orgPeerId") String orgPeerId, @WebParam(name = "orgOrgRelationTypeKey") String orgOrgRelationTypeKey, @WebParam(name = "orgOrgRelationInfo") OrgOrgRelationInfo orgOrgRelationInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Updates an Org Milestone Relationship. The OrgOrgRelation Id,
     * Type, Org Ids, and Meta information may not be changed.
     *
     * @param orgOrgRelationId   the identifier for the OrgOrgRelation updated
     * @param orgOrgRelationInfo the new data for the OrgOrgRelation
     * @param contextInfo        information containing the principalId and locale
     *                           information about the caller of service operation
     * @return the updated OrgOrgRelation
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgOrgRelationId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgOrgRelationInfo or
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgOrgRelationId,
     *          orgOrgRelationInfo, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read-only
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     *          optimistic locking failure or the action
     *          was attempted on an out of date version
     */
    @Override
    public OrgOrgRelationInfo updateOrgOrgRelation(@WebParam(name = "orgOrgRelationId") String orgOrgRelationId, @WebParam(name = "orgOrgRelationInfo") OrgOrgRelationInfo orgOrgRelationInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Deletes an existing OrgOrgRelation.
     *
     * @param orgOrgRelationId the identifier for the OrgOrgRelation
     *                         to be deleted
     * @param contextInfo      information containing the principalId and
     *                         locale information about the caller of service operation
     * @return status of the delete operation. This must always be true.
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgOrgrelationId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgOrgRelationId or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public StatusInfo deleteOrgOrgRelation(@WebParam(name = "orgOrgRelationId") String orgOrgRelationId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves all Types of OrgPersonRelations between an
     * organization and a person known by this service.
     *
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of all OrgPersonRelation Types
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<TypeInfo> getOrgPersonRelationTypes(@WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the OrgPersonRelationship Types between an
     * organization and a person that are allowed for a particular Org
     * Type.
     *
     * @param orgTypeKey  an identifier for an Org Type
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of organization person relationship types that
     *         are valid for the supplied organization type or an
     *         empty list of none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgTypeKey or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<TypeInfo> getOrgPersonRelationTypesForOrgType(@WebParam(name = "orgTypeKey") String orgTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Tests if a person has a current relationship with a specified
     * organization
     *
     * @param orgId                    identifier of the organization
     * @param personId                 identifier of the person
     * @param orgPersonRelationTypeKey type of relationship between the
     *                                 person and organization
     * @param contextInfo              information containing the principalId and
     *                                 locale information about the caller of service operation
     * @return true if a relationship between the two Ids exists, false if
     *         no relation exists or is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, personId,
     *          orgPersonRelationTypeKey, or contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public Boolean hasOrgPersonRelation(@WebParam(name = "orgId") String orgId, @WebParam(name = "personId") String personId, @WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a single OrgPersonRelation by OrgPersonRelation Id.
     *
     * @param orgPersonRelationId the identifier for the OrgPersonRelation
     *                            to be retrieved
     * @param contextInfo         information containing the principalId and
     *                            locale information about the caller of service operation
     * @return the OrgPersonRelation requested
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPersonRelationId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationId or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public OrgPersonRelationInfo getOrgPersonRelation(@WebParam(name = "orgPersonRelationId") String orgPersonRelationId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPersonRelations from a list of
     * OrgPersonRelation Ids.  The returned list may be in any order and
     * if duplicate Ids are supplied, a unique set may or may not be
     * returned.
     *
     * @param orgPersonRelationIds a list of OrgPersonRelation identifiers
     * @param contextInfo          information containing the principalId and
     *                             locale information about the caller of service operation
     * @return a list of OrgPersonRelations
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          an orgPersonRelationId in the list not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationIds, an
     *          orgPersonRelationId in the orgPersonRelationIds, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByIds(@WebParam(name = "orgPersonRelationIds") List<String> orgPersonRelationIds, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPersonRelation Ids by OrgPersonRelation Type.
     *
     * @param orgPersonRelationTypeKey an identifier for an OrgPersonRelation Type
     * @param contextInfo              information containing the principalId and
     *                                 locale information about the caller of service operation
     * @return a list of OrgPersonRelation identifiers matching
     *         orgPersonRelationTypeKey or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationTypeKey or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getOrgPersonRelationIdsByType(@WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves all OrgPersonRelations to the given Org.
     *
     * @param orgId       the identifier for the Org
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of OrgPersonRelations to the given Org or an
     *         empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPersonRelations of the specified
     * OrgPersonRelationType for an Org.
     *
     * @param orgPersonRelationTypeKey the identifier for an
     *                                 OrgPersonRelationType
     * @param orgId                    the identifier for an Org
     * @param contextInfo              information containing the principalId and locale
     *                                 information about the caller of service operation
     * @return a list of OrgPersonRelations of the specified OrgPersonRelationType for
     *         the given Org or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationTypeKey,
     *          orgId, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndOrg(@WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPersonRelations of the specified
     * OrgPersonRelationType for an Org.
     *
     * @param orgPersonRelationTypeKey the identifier for an
     *                                 OrgPersonRelationType
     * @param orgId                    the identifier for an Org
     * @param contextInfo              information containing the principalId and locale
     *                                 information about the caller of service operation
     * @return a list of OrgPersonRelations of the specified OrgPersonRelationType for
     *         the given Org or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationTypeKey,
     *          orgId, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public OrgPersonRelationInfo getOrgPersonRelationByTypeAndOrg(@WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves all OrgPersonRelations to the given Person.
     *
     * @param personId    the identifier for the Person
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of OrgPersonRelations to the given Person or an
     *         empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          personId or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByPerson(@WebParam(name = "personId") String personId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPersonRelations of the specified
     * OrgPersonRelationType for a Person.
     *
     * @param orgPersonRelationTypeKey the identifier for an
     *                                 OrgPersonRelationType
     * @param personId                 the identifier for a Person
     * @param contextInfo              information containing the principalId and locale
     *                                 information about the caller of service operation
     * @return a list of OrgPersonRelations of the specified OrgPersonRelationType for
     *         the given Person or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is notvalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationTypeKey,
     *          personId, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndPerson(@WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "personId") String personId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves all OrgPersonRelations between the given Orn and
     * Person.
     *
     * @param orgId       the identifier for the Org
     * @param personId    the identifier for the Person
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of OrgPersonRelations to the given Org and
     *         Person or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, personId or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByOrgAndPerson(@WebParam(name = "orgId") String orgId, @WebParam(name = "personId") String personId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPersonRelations of the specified
     * OrgPersonRelationType between an Org and a Person.
     *
     * @param orgPersonRelationTypeKey the identifier for an
     *                                 OrgPersonRelationType
     * @param orgId                    the identifier for the Org
     * @param personId                 the identifier for a Person
     * @param contextInfo              information containing the principalId and locale
     *                                 information about the caller of service operation
     * @return a list of OrgPersonRelations of the specified
     *         OrgPersonRelationType for the given Org and Person or
     *         an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationTypeKey,
     *          orgId, personId, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndOrgAndPerson(@WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgId") String orgId, @WebParam(name = "personId") String personId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for OrgPersonRelation Ids that meet the given search
     * criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and locale
     *                    information about the caller of service operation
     * @return a list of OrgPersonRelation identifiers matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> searchForOrgPersonRelationIds(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for OrgPersonRelations that meet the given search
     * criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and locale
     *                    information about the caller of service operation
     * @return a list of OrgPersonRelations matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is invalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is missing or
     *          null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPersonRelationInfo> searchForOrgPersonRelations(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Validates an OrgPersonRelation. Depending on the value of
     * validationType, this validation could be limited to tests on
     * just the current OrgPersonRelation and its directly contained
     * sub-objects or expanded to perform all tests related to this
     * OrgPersonRelation. If an identifier is present for the
     * OrgPersonRelation (and/or one of its contained sub-objects) and
     * a record is found for that identifier, the validation checks if
     * the OrgPersonRelation can be shifted to the new values. If an
     * identifier is not present or a record cannot be found for the
     * identifier, the validation checks if the object with the given
     * data can be created.
     *
     * @param validationTypeKey        the identifier for the validation Type
     * @param orgId                    the identifier for an Org
     * @param personId                 a the identifier for the Org peer
     * @param orgPersonRelationTypeKey the identifier for the OrgPersonRelation Type
     * @param orgPersonRelationInfo    the OrgPersonRelation to be validated
     * @param contextInfo              information containing the principalId and locale
     *                                 information about the caller of service operation
     * @return a list of validation results or an empty list if validation
     *         succeeded
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          validationTypeKey, orgId,
     *          personId, or orgPersonRelationTypeKey is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgPersonRelationInfo or
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          validationTypeKey, orgId,
     *          personId, orgPersonRelationTypeKey, orgPersonRelationInfo,
     *          or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          authorization failure
     */
    @Override
    public List<ValidationResultInfo> validateOrgPersonRelation(@WebParam(name = "validationTypeKey") String validationTypeKey, @WebParam(name = "orgId") String orgId, @WebParam(name = "personId") String personId, @WebParam(name = "orgPersonrelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgPersonRelationInfo") OrgPersonRelationInfo orgPersonRelationInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Creates a new OrgPersonRelation. The OrgPersonRelation Id, Type, Org
     * Ids, and Meta information may not be set in the supplied data.
     *
     * @param orgId                    a peer of the relationship
     * @param personId                 a peer of the relationship
     * @param orgPersonRelationTypeKey the identifier for the Type of
     *                                 OrgPersonRelation
     * @param orgPersonRelationInfo    the relationship to be created
     * @param contextInfo              information containing the principalId and locale
     *                                 information about the caller of service operation
     * @return the new OrgPersonRelation
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgId, personId, or
     *          orgPersonRelationTypeKey is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgPersonRelationInfo or contextInfo is
     *          not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, personId,
     *          orgPersonRelationTypeKey, orgPersonRelationInfo, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read only
     */
    @Override
    public OrgPersonRelationInfo createOrgPersonRelation(@WebParam(name = "orgId") String orgId, @WebParam(name = "personId") String personId, @WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgPersonRelationInfo") OrgPersonRelationInfo orgPersonRelationInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Updates an Org Milestone Relationship. The OrgPersonRelation Id,
     * Type, Org Ids, and Meta information may not be changed.
     *
     * @param orgPersonRelationId   the identifier for the
     *                              OrgPersonRelation updated
     * @param orgPersonRelationInfo the new data for the OrgPersonRelation
     * @param contextInfo           information containing the principalId and
     *                              locale information about the caller of service operation
     * @return the updated OrgPersonRelation
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPersonRelationId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgPersonRelationInfo or
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationId,
     *          orgPersonRelationInfo, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read-only
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     *          optimistic locking failure or
     *          the action was attempted on an out of date version
     */
    @Override
    public OrgPersonRelationInfo updateOrgPersonRelation(@WebParam(name = "orgPersonRelationId") String orgPersonRelationId, @WebParam(name = "orgPersonRelationInfo") OrgPersonRelationInfo orgPersonRelationInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Deletes an existing OrgPersonRelation.
     *
     * @param orgPersonRelationId the identifier for the
     *                            OrgPersonRelation to be deleted
     * @param contextInfo         information containing the principalId and
     *                            locale information about the caller of service operation
     * @return status of the delete operation. This must always be true.
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPersonrelationId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationId or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public StatusInfo deleteOrgPersonRelation(@WebParam(name = "orgPersonRelationId") String orgPersonRelationId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a single OrgPositionRestriction by
     * OrgPositionRestriction id.
     *
     * @param orgPositionRestrictionId the identifier of the
     *                                 OrgPositionRestriction to be retrieved
     * @param contextInfo              information containing the principalId and
     *                                 locale information about the caller of service operation
     * @return the OrgPositionRestriction requested
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPositionRestrictionId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPositionRestrictionId or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public OrgPositionRestrictionInfo getOrgPositionRestriction(@WebParam(name = "orgPositionRestrictionId") String orgPositionRestrictionId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPositionRestrictions from a list of
     * OrgPositionRestriction Ids. The returned list may be in any
     * order and if duplicate Ids are supplied, a unique set may or
     * may not be returned.
     *
     * @param orgPositionRestrictionIds a list of OrgPositionRestriction Ids
     * @param contextInfo               information containing the principalId and
     *                                  locale information about the caller of service operation
     * @return a list of OrgPositionRestrictions
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          an orgPositionRestrictionId in
     *          the list not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPositionRestrictionIds, an
     *          id in orgPositionRestrictionIds, or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPositionRestrictionInfo> getOrgPositionRestrictionsByIds(@WebParam(name = "orgPositionRestrictionIds") List<String> orgPositionRestrictionIds, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPositionRestrictions by
     * OrgPositionRestriction Type.
     *
     * @param orgPersonRelationTypeKey an identifier for the OrgPositionRestriction
     *                                 type
     * @param contextInfo              information containing the principalId and
     *                                 locale information about the caller of service operation
     * @return a list of OrgPositionRestriction Ids matching
     *         orgPersonRelationTypeKey or an empty list if none found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is invalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPersonRelationTypeKey or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getOrgPositionRestrictionIdsByType(@WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves a list of OrgPositionRestrictions by Org.
     *
     * @param orgId       an identifier for the Org
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return a list of OrgPositionRestrictions for the Org
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is invalid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgIdy or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getOrgPositionRestrictionIdsByOrg(@WebParam(name = "orgId") String orgId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for OrgPositionRestriction Ids that meet the given
     * search criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of OrgPositionRestriction identifiers matching the
     *         criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> searchForOrgPositionRestrictionIds(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Searches for OrgPositionRestrictions that meet the given search
     * criteria.
     *
     * @param criteria    the search criteria
     * @param contextInfo information containing the principalId and
     *                    locale information about the caller of service operation
     * @return list of OrgPositionRestrictions matching the criteria
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          criteria or contextInfo is
     *          not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          criteria or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgPositionRestrictionInfo> searchForOrgPositionRestrictions(@WebParam(name = "criteria") QueryByCriteria criteria, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Validates an OrgPositionRestriction. Depending on the value of
     * validationType, this validation could be limited to tests on
     * just the current object and its directly contained sub-objects
     * or expanded to perform all tests related to this
     * OrgPositionRestriction. If an identifier is present for the
     * OrgPositionRestriction (and/or one of its contained
     * sub-objects) and a record is found for that identifier, the
     * validation checks if the OrgPositionRestriction can be shifted
     * to the new values. If a an identifier is not present or a
     * record does not exist, the validation checks if the
     * OrgPositionRestriction with the given data can be created.
     *
     * @param validationTypeKey          the identifier for the validation Type
     * @param orgId                      the identifier for the Org
     * @param orgPersonRelationTypeKey   the identifier for the
     *                                   OrgPositionRestriction Type to be validated
     * @param orgPositionRestrictionInfo the identifier for the
     *                                   OrgPositionRestriction to be validated
     * @param contextInfo                information containing the principalId and
     *                                   locale information about the caller of service operation
     * @return a list of validation results or an empty list if
     *         validation succeeded
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          validationTypeKey, orgId, or
     *          orgPersonRelationTypeKey is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgPositionRestrictionInfo or
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          validationTypeKey, orgId,
     *          orgPersonRelationTypeKey
     *          orgPositionRestrictionInfo, or contextInfo is missing
     *          or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<ValidationResultInfo> validateOrgPositionRestriction(@WebParam(name = "validationTypeKey") String validationTypeKey, @WebParam(name = "orgId") String orgId, @WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgPositionRestrictionInfo") OrgPositionRestrictionInfo orgPositionRestrictionInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Creates a new OrgPositionRestriction. The
     * OrgPositionRestriction Type and Meta information may not be set
     * in the supplied data object.
     *
     * @param orgPersonRelationTypeKey   a unique identifier for
     *                                   the Type of the new OrgPositionRestriction
     * @param orgPositionRestrictionInfo the data with which to create
     *                                   the OrgPositionRestriction
     * @param contextInfo                information containing the principalId and
     *                                   locale information about the caller of service operation
     * @return the new OrgPositionRestriction
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPersonRelationTypeKey does not exist or is
     *          not supported
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgPositionRestrictionInfo or contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId,
     *          orgPersonRelationTypeKey,
     *          orgPositionRestrictionInfo, or contextInfo is missing
     *          or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read only
     */
    @Override
    public OrgPositionRestrictionInfo createOrgPositionRestriction(@WebParam(name = "orgId") String orgId, @WebParam(name = "orgPersonRelationTypeKey") String orgPersonRelationTypeKey, @WebParam(name = "orgPositionRestrictionInfo") OrgPositionRestrictionInfo orgPositionRestrictionInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Updates an existing OrgPositionRestriction. The
     * OrgPositionRestriction id, Type, and Meta information may not
     * be changed.
     *
     * @param orgPositionRestrictionId   the identifier for the
     *                                   OrgPositionRestriction to be updated
     * @param orgPositionRestrictionInfo the new data for the OrgPositionRestriction
     * @param contextInfo                information containing the principalId and
     *                                   locale information about the caller of service operation
     * @return the updated OrgPositionRestriction
     * @throws org.kuali.student.r2.common.exceptions.DataValidationErrorException
     *          supplied data is invalid
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPositionRestrictionId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          orgPositionRestrictionInfo or
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPositionRestrictionId,
     *          orgPositionRestrictionInfo, or contextInfo is missing
     *          or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     * @throws org.kuali.student.r2.common.exceptions.ReadOnlyException
     *          an attempt at supplying information
     *          designated as read only
     * @throws org.kuali.student.r2.common.exceptions.VersionMismatchException
     *          an optimistic locking failure
     *          or the action was attempted on an out of date version
     */
    @Override
    public OrgPositionRestrictionInfo updateOrgPositionRestriction(@WebParam(name = "orgPositionRestrictionId") String orgPositionRestrictionId, @WebParam(name = "orgPositionRestrictionInfo") OrgPositionRestrictionInfo orgPositionRestrictionInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Deletes an existing OrgPositionRestriction.
     *
     * @param orgPositionRestrictionId the identifier for the
     *                                 OrgPositionRestriction to be deleted
     * @param contextInfo              information containing the principalId and
     *                                 locale information about the caller of service operation
     * @return the status of the operation. This must always be true.
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          orgPositionRestrictionId is not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgPositionRestrictionId or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public StatusInfo deleteOrgPositionRestriction(@WebParam(name = "orgPositionRestrictionId") String orgPositionRestrictionId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Tests if a specified organization is a descendant of the other
     * specified organization in the given organization hierarchy.
     *
     * @param orgId           identifier of the "ancestor" organization
     * @param descendantOrgId identifier of the organization to be
     *                        checked if it is a descendant
     * @param orgHierarchyId  the identifier of the organization
     *                        hierarchy to be checked against
     * @param contextInfo     information containing the principalId and
     *                        locale information about the caller of service operation
     * @return true if the organization is a descendant of the other
     *         organization in that hierarchy, false if not a descendant
     *         or does not exist
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, descendantOrgId,
     *          orgHierarchyId, or contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public Boolean isDescendant(@WebParam(name = "orgId") String orgId, @WebParam(name = "descendantOrgId") String descendantOrgId, @WebParam(name = "orgHierarchyId") String orgHierarchyId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the list of identifiers for all "descendant"
     * organizations of the specified organization in the given
     * organization hierarchy, regardless of the distance from the
     * specified organization.  Information about the distance from
     * the original organization is not returned by this call, so this
     * can be seen as a flattened and de-duplicated representation.
     *
     * @param orgId          identifier of the "ancestor" organization
     * @param orgHierarchyId identifier of the organization hierarchy
     *                       to be checked against
     * @param contextInfo    information containing the principalId and
     *                       locale information about the caller of service operation
     * @return a list of identifiers for the "descendant" organizations
     *         for the specified organization
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          rootOrgId or orgHierarchyId is
     *          not found, or orgId not part of orgHierarchyId
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, orgHierarchyId, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getAllDescendants(@WebParam(name = "orgId") String orgId, @WebParam(name = "orgHierarchyId") String orgHierarchyId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the list of identifiers for all "ancestor"
     * organizations of the the specified organization in the given
     * organization hierarchy, regardless of the distance from the
     * specified organization.  Information about the distance from
     * the original organization is not returned by this call, so this
     * can be seen as a flattened and de-duplicated representation.
     *
     * @param orgId          identifier of the "descendant" organization
     * @param orgHierarchyId identifier of the organization hierarchy to
     *                       be checked against
     * @param contextInfo    information containing the principalId and
     *                       locale information about the caller of service operation
     * @return a list of identifiers for the "ancestor" organizations
     *         of the specified organization
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          rootOrgId or orgHierarchyId is
     *          not found, or orgId not part of orgHierarchyId
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          orgId, orgHierarchyId, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<String> getAllAncestors(@WebParam(name = "orgId") String orgId, @WebParam(name = "orgHierarchyId") String orgHierarchyId, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Finds a list of all orgs in the org hierarchy starting at the
     * root org and going down maxLevels of the tree
     *
     * @param rootOrgId
     * @param orgHierarchyId
     * @param maxLevels      the max number of levels in the tree to
     *                       return. If set to 0 returns all nodes in the tree
     * @param contextInfo    information containing the principalId and
     *                       locale information about the caller of service operation
     * @return List of OrgTreeInfo in
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          rootOrgId or orgHierarchyId is
     *          not found, or rootOrgId is not part or orgHierarchyId
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          rootOrgId, orgHierarchyId, or
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public List<OrgTreeInfo> getOrgTree(@WebParam(name = "rootOrgId") String rootOrgId, @WebParam(name = "orgHierarchyId") String orgHierarchyId, @WebParam(name = "maxLevels") int maxLevels, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves the list of search types known by this service.
     *
     * @param contextInfo information containing the principalId and locale
     *                    information about the caller of service operation
     * @return list of search type information
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          contextInfo is missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     */
    @Override
    public List<TypeInfo> getSearchTypes(@WebParam(name = "contextInfo") ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException, OperationFailedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Retrieves information about a particular search type.
     *
     * @param searchTypeKey identifier of the search type
     * @param contextInfo   information containing the principalId and locale
     *                      information about the caller of service operation
     * @return information on the search type
     * @throws org.kuali.student.r2.common.exceptions.DoesNotExistException
     *          specified searchTypeKey not found
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          searchTypeKey or contextInfo is missing
     *          or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     */
    @Override
    public TypeInfo getSearchType(@WebParam(name = "searchTypeKey") String searchTypeKey, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Performs a search.
     *
     * @param searchRequestInfo the search request
     * @param contextInfo       information containing the principalId and locale
     *                          information about the caller of service operation
     * @return the results of the search
     * @throws org.kuali.student.r2.common.exceptions.InvalidParameterException
     *          contextInfo is not valid
     * @throws org.kuali.student.r2.common.exceptions.MissingParameterException
     *          searchRequestInfo or contextInfo is
     *          missing or null
     * @throws org.kuali.student.r2.common.exceptions.OperationFailedException
     *          unable to complete request
     * @throws org.kuali.student.r2.common.exceptions.PermissionDeniedException
     *          an authorization failure occurred
     */
    @Override
    public SearchResultInfo search(SearchRequestInfo searchRequestInfo, @WebParam(name = "contextInfo") ContextInfo contextInfo) throws MissingParameterException, InvalidParameterException, OperationFailedException, PermissionDeniedException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
