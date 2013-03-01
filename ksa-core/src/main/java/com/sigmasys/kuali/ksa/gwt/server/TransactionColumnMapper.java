package com.sigmasys.kuali.ksa.gwt.server;

import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;

import java.util.HashMap;
import java.util.Map;

/**
 * TransactionColumnMapper
 *
 * @author dmulderink, mivanov
 *         Date: 5/14/12
 *         Time: 8:11 AM
 */
public class TransactionColumnMapper extends AbstractColumnMapper {

    @Override
    protected Map<String, String> getFieldTranslationMapping() {
        return new HashMap<String, String>();
    }

    @Override
    protected Map<String, String> getFieldSortMapping() {
        Map<String, String> sortMap = new HashMap<String, String>();
        sortMap.put(TransactionModel.COLUMN_ID, TransactionModel.ID);
        sortMap.put(TransactionModel.COLUMN_ORIGINATION_DATE, TransactionModel.ORIGINATION_DATE);
        sortMap.put(TransactionModel.COLUMN_EFFECTIVE_DATE, TransactionModel.EFFECTIVE_DATE);
        sortMap.put(TransactionModel.COLUMN_ACCOUNT_ID, TransactionModel.ACCOUNT_ID);
        sortMap.put(TransactionModel.COLUMN_AMOUNT, TransactionModel.AMOUNT);
        sortMap.put(TransactionModel.COLUMN_CURRENCY_CODE, TransactionModel.CURRENCY_CODE);
        sortMap.put(TransactionModel.COLUMN_TYPE_ID, TransactionModel.TYPE_ID);
        sortMap.put(TransactionModel.COLUMN_TYPE_SUB_CODE, TransactionModel.TYPE_SUB_CODE);
        sortMap.put(TransactionModel.COLUMN_STATEMENT_TEXT, TransactionModel.STATEMENT_TEXT);
        return sortMap;
    }

}
