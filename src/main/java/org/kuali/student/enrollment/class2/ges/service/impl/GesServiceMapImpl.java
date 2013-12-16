/*
 * Copyright 2013 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Lic+ense is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.enrollment.class2.ges.service.impl;


import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.student.common.mock.MockService;
import org.kuali.student.common.UUIDHelper;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.MetaInfo;
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
import org.kuali.student.r2.core.ges.dto.ParameterInfo;
import org.kuali.student.r2.core.ges.dto.ValueInfo;
import org.kuali.student.r2.core.ges.service.GesService;
import org.kuali.student.r2.core.population.service.PopulationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class GesServiceMapImpl implements MockService, GesService
{

	private PopulationService populationService;

	// cache variable
	// The LinkedHashMap is just so the values come back in a predictable order
	private Map<String, ParameterInfo> parameterMap = new LinkedHashMap<String, ParameterInfo>();
	private Map<String, ValueInfo> valueMap = new LinkedHashMap<String, ValueInfo>();


    public PopulationService getPopulationService() {
        return populationService;
    }

    public void setPopulationService(PopulationService populationService) {
        this.populationService = populationService;
    }

    @Override
	public void clear()
	{
		this.parameterMap.clear ();
		this.valueMap.clear ();
	}

	
	@Override
	public ParameterInfo getParameter(String parameterId, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_BY_ID
		if (!this.parameterMap.containsKey(parameterId)) {
		   throw new DoesNotExistException(parameterId);
		}
		return new ParameterInfo(this.parameterMap.get (parameterId));
	}
	
	@Override
	public List<ParameterInfo> getParametersByIds(List<String> parameterIds, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_BY_IDS
		List<ParameterInfo> list = new ArrayList<ParameterInfo> ();
		for (String id: parameterIds) {
		    list.add (this.getParameter(id, contextInfo));
		}
		return list;
	}
	
	@Override
	public List<String> getParameterIdsByType(String parameterTypeKey, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_IDS_BY_TYPE
		List<String> list = new ArrayList<String> ();
		for (ParameterInfo info: parameterMap.values ()) {
			if (parameterTypeKey.equals(info.getTypeKey())) {
			    list.add (info.getId ());
			}
		}
		return list;
	}
	
	@Override
	public List<String> searchForParameterIds(QueryByCriteria criteria, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// UNKNOWN
		throw new OperationFailedException("searchForParameterIds has not been implemented");
	}
	
	@Override
	public List<ParameterInfo> searchForParameters(QueryByCriteria criteria, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// UNKNOWN
		throw new OperationFailedException("searchForParameters has not been implemented");
	}
	
	@Override
    public List<ValidationResultInfo> validateParameter(String validationTypeKey, String valueTypeKey, String parameterTypeKey, String parameterKey, ParameterInfo parameterInfo, ContextInfo contextInfo)
        throws DoesNotExistException
        ,InvalidParameterException
        ,MissingParameterException
        ,OperationFailedException
        ,PermissionDeniedException
{
    // VALIDATE
    return new ArrayList<ValidationResultInfo> ();
}
	
	@Override
	public ParameterInfo createParameter(String valueTypeKey, String parameterTypeKey, String parameterKey, ParameterInfo parameterInfo, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,DataValidationErrorException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
		      ,ReadOnlyException
	{
		// CREATE
		if (!valueTypeKey.equals (parameterInfo.getValueTypeKey())) {
		    throw new InvalidParameterException("The valueTypeKey parameter does not match the valueTypeKey on the info object");
		}

        if(!parameterTypeKey.equals((parameterInfo.getTypeKey()))) {
            throw new InvalidParameterException("The typeKey parameter does not match the typeKey on the info object");
        }

        if(!parameterKey.equals((parameterInfo.getKey()))) {
            throw new InvalidParameterException("The key parameter does not match the key on the info object");
        }

		ParameterInfo copy = new ParameterInfo(parameterInfo);
		if (copy.getId() == null) {
		   copy.setId(UUIDHelper.genStringUUID());
		}
		copy.setMeta(newMeta(contextInfo));
		parameterMap.put(copy.getId(), copy);
		return new ParameterInfo(copy);
	}
	
	@Override
	public ParameterInfo updateParameter(String parameterId, ParameterInfo parameterInfo, ContextInfo contextInfo)
		throws DataValidationErrorException
		      ,DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
		      ,ReadOnlyException
		      ,VersionMismatchException
	{
		// UPDATE
		if (!parameterId.equals (parameterInfo.getId())) {
		    throw new InvalidParameterException("The id parameter does not match the id on the info object");
		}
		ParameterInfo old = this.getParameter(parameterInfo.getId(), contextInfo);

        // CREATE
        if (!old.getValueTypeKey().equals(parameterInfo.getValueTypeKey())) {
            throw new ReadOnlyException("The new valueTypeKey does not match the old valueTypeKey on the info object");
        }

        if(!old.getTypeKey().equals(parameterInfo.getTypeKey())) {
            throw new ReadOnlyException("The new typeKey does not match the old typeKey on the info object");
        }

        if(!old.getKey().equals(parameterInfo.getKey())) {
            throw new ReadOnlyException("The new key does not match the old key on the info object");
        }

        ParameterInfo copy = new ParameterInfo(parameterInfo);
		if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
		    throw new VersionMismatchException(old.getMeta().getVersionInd());
		}
		copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
		this.parameterMap .put(parameterInfo.getId(), copy);
		return new ParameterInfo(copy);
	}
	
	@Override
	public StatusInfo deleteParameter(String parameterId, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// DELETE
		if (this.parameterMap.remove(parameterId) == null) {
		   throw new DoesNotExistException(parameterId);
		}
		return new StatusInfo();
	}
	
	@Override
	public ValueInfo getValue(String valueId, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_BY_ID
		if (!this.valueMap.containsKey(valueId)) {
		   throw new DoesNotExistException(valueId);
		}
		return new ValueInfo(this.valueMap.get (valueId));
	}
	
	@Override
	public List<ValueInfo> getValuesByIds(List<String> valueIds, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_BY_IDS
		List<ValueInfo> list = new ArrayList<ValueInfo> ();
		for (String id: valueIds) {
		    list.add (this.getValue(id, contextInfo));
		}
		return list;
	}
	
	@Override
	public List<String> getValueIdsByType(String valueTypeKey, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_IDS_BY_TYPE
		List<String> list = new ArrayList<String> ();
		for (ValueInfo info: valueMap.values ()) {
			if (valueTypeKey.equals(info.getTypeKey())) {
			    list.add (info.getId ());
			}
		}
		return list;
	}
	
	@Override
	public List<String> searchForValueIds(QueryByCriteria criteria, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// UNKNOWN
		throw new OperationFailedException("searchForValueIds has not been implemented");
	}
	
	@Override
	public List<ValueInfo> searchForValues(QueryByCriteria criteria, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// UNKNOWN
		throw new OperationFailedException("searchForValues has not been implemented");
	}
	
	@Override
    public List<ValidationResultInfo> validateValue(String validationTypeKey, String valueTypeKey, String parameterId, ValueInfo valueInfo, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// VALIDATE
		return new ArrayList<ValidationResultInfo> ();
	}
	
	@Override
	public ValueInfo createValue(String valueTypeKey, String parameterId, ValueInfo valueInfo, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,DataValidationErrorException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
		      ,ReadOnlyException
	{
		// CREATE
		if (!valueTypeKey.equals (valueInfo.getTypeKey())) {
		    throw new InvalidParameterException("The type parameter does not match the type on the info object");
		}
        if (!parameterId.equals (valueInfo.getParameterId())) {
            throw new InvalidParameterException("The parameter id parameter does not match the parameter id on the info object");
        }

		ValueInfo copy = new ValueInfo(valueInfo);
		if (copy.getId() == null) {
		   copy.setId(UUIDHelper.genStringUUID());
		}
		copy.setMeta(newMeta(contextInfo));
		valueMap.put(copy.getId(), copy);
		return new ValueInfo(copy);
	}
	
	@Override
	public ValueInfo updateValue(String valueId, ValueInfo valueInfo, ContextInfo contextInfo)
		throws DataValidationErrorException
		      ,DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
		      ,ReadOnlyException
		      ,VersionMismatchException
	{
		// UPDATE
		if (!valueId.equals (valueInfo.getId())) {
		    throw new InvalidParameterException("The id parameter does not match the id on the info object");
		}
        ValueInfo old = this.getValue(valueInfo.getId(), contextInfo);

        if (!old.getParameterId().equals(valueInfo.getParameterId())) {
            throw new InvalidParameterException("The new parameter id does not match the old parameter id on the info object");
        }

		ValueInfo copy = new ValueInfo(valueInfo);
		if (!old.getMeta().getVersionInd().equals(copy.getMeta().getVersionInd())) {
		    throw new VersionMismatchException(old.getMeta().getVersionInd());
		}
		copy.setMeta(updateMeta(copy.getMeta(), contextInfo));
		this.valueMap .put(valueInfo.getId(), copy);
		return new ValueInfo(copy);
	}
	
	@Override
	public StatusInfo deleteValue(String valueId, ContextInfo contextInfo)
		throws DoesNotExistException
		      ,InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// DELETE
		if (this.valueMap.remove(valueId) == null) {
		   throw new OperationFailedException(valueId);
		}
		return new StatusInfo();
	}
	
	@Override
	public List<ValueInfo> getValuesByParameter(String parameterId, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// GET_INFOS_BY_OTHER
		List<ValueInfo> list = new ArrayList<ValueInfo> ();
		for (ValueInfo info: valueMap.values ()) {
			if (parameterId.equals(info.getParameterId())) {
			    list.add (new ValueInfo(info));
			}
		}
		return list;
	}
	
	@Override
	public List<ValueInfo> evaluateValuesByParameterAndPerson(String parameterId, String personId, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException {
		List<ValueInfo> values = getValuesByParameter(parameterId, contextInfo);
        List<ValueInfo> resultValues = new ArrayList<ValueInfo>();
        Date now = new Date();
        for(ValueInfo value : values) {
            try {
                if(isActive(value, now) && isInPopulation(value.getPopulationId(), personId, now, contextInfo)) {
                    if(StringUtils.isEmpty(value.getRuleId())) {
                        if(StringUtils.isEmpty(value.getAtpTypeKey())) {
                            resultValues.add(value);
                        }
                    }
                }
            } catch (DoesNotExistException e) {
                throw new OperationFailedException("Unable to evaluate values for parameter " + parameterId, e);
            }
        }

        return resultValues;
	}
	
	@Override
	public List<ValueInfo> evaluateValuesByParameterAndPersonAndAtpAndOnDate(String parameterId, String personId, String atpId, Date onDate, ContextInfo contextInfo)
		throws InvalidParameterException
		      ,MissingParameterException
		      ,OperationFailedException
		      ,PermissionDeniedException
	{
		// UNKNOWN
		throw new OperationFailedException("evaluateValuesByParameterAndPersonAndAtpAndOnDate has not been implemented");
	}

    private boolean isActive(ValueInfo value, Date date) {
        return (value.getEffectiveDate() == null || !date.before(value.getEffectiveDate()) &&
                (value.getExpirationDate() == null || !date.after(value.getExpirationDate())));
    }

    private boolean isInPopulation(String popId, String personId, Date date, ContextInfo contextInfo)
            throws PermissionDeniedException, MissingParameterException, InvalidParameterException, OperationFailedException, DoesNotExistException {
        return StringUtils.isEmpty(popId) || populationService.isMemberAsOfDate(personId, popId, date, contextInfo);
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
	
}

