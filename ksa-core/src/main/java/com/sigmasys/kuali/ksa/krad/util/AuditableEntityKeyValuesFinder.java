package com.sigmasys.kuali.ksa.krad.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import com.sigmasys.kuali.ksa.model.AuditableEntity;
import com.sigmasys.kuali.ksa.service.AuditableEntityService;
import com.sigmasys.kuali.ksa.util.ContextUtils;

@SuppressWarnings("all")
public class AuditableEntityKeyValuesFinder<T extends AuditableEntity> extends GenericKeyValuesFinder {
	
	private Class<T> type;
	
	
	public AuditableEntityKeyValuesFinder(Class<T> type) {
		this.type = type;
        this.setBlankOption(true);
	}

	@Override
	protected List<KeyValue> buildKeyValues() {
		// Get all entities of the generic type:
		AuditableEntityService auditableEntityService = ContextUtils.getBean(AuditableEntityService.class);
		List<T> entities = auditableEntityService.getAuditableEntities(type);
		List<KeyValue> result = new ArrayList<KeyValue>();
		
		// Iterate through entities and add Key Value pairs:
		for (T entity : entities) {
			String key = entity.getId().toString();
			String value = StringUtils.isNotBlank(entity.getName()) ? entity.getName() : "UNDEFINED";
			ConcreteKeyValue keyValue = new ConcreteKeyValue(key, value);
			
			result.add(keyValue);
		}
		
		return result;
	}

}
