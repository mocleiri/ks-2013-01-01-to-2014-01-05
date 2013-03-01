package com.sigmasys.kuali.ksa.krad.util;

import java.util.ArrayList;
import java.util.List;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;

/**
 * This key values finder supplies value for the Report Years list
 * to generate 1098T report for.
 * 
 * @author Sergey
 *
 */
@SuppressWarnings("serial")
public class Generate1098TReportYearKeyValuesFinder extends KeyValuesBase {

	@Override
	public List<KeyValue> getKeyValues() {
		// Create a new list of report years:
		// TODO: Eventually, figure out where these values come from:
		List<KeyValue> result = new ArrayList<KeyValue>();
		
		result.add(new ConcreteKeyValue("2009", "2009"));
		result.add(new ConcreteKeyValue("2010", "2010"));
		result.add(new ConcreteKeyValue("2011", "2011"));
		result.add(new ConcreteKeyValue("2012", "2012"));
		result.add(new ConcreteKeyValue("2013", "2013"));
		
		return result;
	}

}
