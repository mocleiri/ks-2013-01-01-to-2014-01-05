package com.sigmasys.kuali.ksa.gwt.client.service;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionType;
import com.sigmasys.kuali.ksa.model.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents common transaction table list attributes
 * so Charge, Payment and Deferment use shared fields of a Transaction
 *
 * @author dmulderink, mivanov
 *         Date: 5/14/12
 *         Time: 9:51 AM
 */
public class TransactionColumnModelFactory extends AbstractColumnModelFactory<TransactionModel> {

    public static final String LABEL_ID = "Transaction ID";
    public static final String LABEL_TYPE = "Transaction Type";
    public static final String LABEL_ORIGINATION_DATE = "Origination Date";
    public static final String LABEL_EFFECTIVE_DATE = "Effective Date";
    public static final String LABEL_ACCOUNT_ID = "Account ID";
    public static final String LABEL_AMOUNT = "Amount";
    public static final String LABEL_CURRENCY = "Currency";
    public static final String LABEL_TYPE_ID = "Type ID";
    public static final String LABEL_TYPE_SUB_CODE = "Type Subcode";
    public static final String LABEL_STATEMENT = "Statement";

    public List<ColumnConfig> getColumnConfigs() {

        final DateTimeFormat dateFormat = DateTimeFormat.getFormat(Constants.DATE_FORMAT_US);

        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

        ColumnConfig column = new ColumnConfig(TransactionModel.COLUMN_ID, LABEL_ID, 95);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_ACCOUNT_ID, LABEL_ACCOUNT_ID, 80);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.TYPE, LABEL_TYPE, 95);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        column.setRenderer(new GridCellRenderer<TransactionModel>() {
            @Override
            public Object render(TransactionModel model, String s, ColumnData column, int i, int j, ListStore store, Grid grid) {
                if (model != null) {
                    TransactionType transactionType = model.getType();
                    if (transactionType != null) {
                        return transactionType.toString();
                    }
                }
                return null;
            }
        });
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_TYPE_ID, LABEL_TYPE_ID, 70);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_TYPE_SUB_CODE, LABEL_TYPE_SUB_CODE, 95);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_ORIGINATION_DATE, LABEL_ORIGINATION_DATE, 100);
        column.setDateTimeFormat(dateFormat);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_EFFECTIVE_DATE, LABEL_EFFECTIVE_DATE, 100);
        column.setDateTimeFormat(dateFormat);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_AMOUNT, LABEL_AMOUNT, 80);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_CURRENCY_CODE, LABEL_CURRENCY, 70);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(TransactionModel.COLUMN_STATEMENT_TEXT, LABEL_STATEMENT, 120);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        columns.add(column);

        return columns;
    }
}
