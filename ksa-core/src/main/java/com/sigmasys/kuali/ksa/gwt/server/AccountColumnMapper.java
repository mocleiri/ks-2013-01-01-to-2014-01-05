package com.sigmasys.kuali.ksa.gwt.server;


import com.sigmasys.kuali.ksa.gwt.client.model.AccountModel;

import java.util.HashMap;
import java.util.Map;

/**
 * AccountColumnMapper
 *
 * @author Michael Ivanov
 */
public class AccountColumnMapper extends AbstractColumnMapper {

   @Override
	protected Map<String, String> getFieldTranslationMapping() {
        return new HashMap<String, String>();
    }

   @Override
	protected Map<String, String> getFieldSortMapping() {
        Map<String, String> sortMap = new HashMap<String, String>();
        sortMap.put(AccountModel.COLUMN_ID, AccountModel.ID);
        sortMap.put(AccountModel.COLUMN_CREATION_DATE, AccountModel.CREATION_DATE);
        sortMap.put(AccountModel.COLUMN_FIRST_NAME, AccountModel.FIRST_NAME);
        sortMap.put(AccountModel.COLUMN_LAST_NAME, AccountModel.LAST_NAME);
        sortMap.put(AccountModel.COLUMN_EMAIL_ADDRESS, AccountModel.EMAIL_ADDRESS);
        sortMap.put(AccountModel.COLUMN_PHONE_NUMBER, AccountModel.PHONE_NUMBER);
        sortMap.put(AccountModel.COLUMN_CITY, AccountModel.CITY);
        sortMap.put(AccountModel.COLUMN_STATE, AccountModel.STATE);
        sortMap.put(AccountModel.COLUMN_POSTAL_CODE, AccountModel.POSTAL_CODE);
        sortMap.put(AccountModel.COLUMN_COUNTRY, AccountModel.COLUMN_COUNTRY);
        return sortMap;
    }

}
