package com.sigmasys.kuali.ksa.gwt.client.service;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.sigmasys.kuali.ksa.gwt.client.model.AccountModel;
import com.sigmasys.kuali.ksa.model.Constants;

import java.util.ArrayList;
import java.util.List;

public class AccountColumnModelFactory extends AbstractColumnModelFactory<AccountModel> {

    public static final String LABEL_ID = "Account ID";
    public static final String LABEL_CREATION_DATE = "Creation Date";
    public static final String LABEL_FIRST_NAME = "First Name";
    public static final String LABEL_LAST_NAME = "Last Name";
    public static final String LABEL_EMAIL_ADDRESS = "Email Address";
    public static final String LABEL_PHONE_NUMBER = "Phone #";
    public static final String LABEL_STREET_ADDRESS = "Street Address";
    public static final String LABEL_CITY = "City";
    public static final String LABEL_STATE = "State";
    public static final String LABEL_POSTAL_CODE = "Postal Code";
    public static final String LABEL_COUNTRY = "Country";


    public List<ColumnConfig> getColumnConfigs() {

        final DateTimeFormat dateFormat = DateTimeFormat.getFormat(Constants.DATE_FORMAT_US);
        //final DateTimeFormat timeFormat = DateTimeFormat.getFormat(Constants.TIME_FORMAT);

        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

        ColumnConfig column = new ColumnConfig(AccountModel.COLUMN_ID, LABEL_ID, 70);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_CREATION_DATE, LABEL_CREATION_DATE, 90);
        column.setDateTimeFormat(dateFormat);
        column.setAlignment(HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_FIRST_NAME, LABEL_FIRST_NAME, 80);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_LAST_NAME, LABEL_LAST_NAME, 80);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_EMAIL_ADDRESS, LABEL_EMAIL_ADDRESS, 80);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_PHONE_NUMBER, LABEL_PHONE_NUMBER, 80);
        column.setAlignment(HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_STREET_ADDRESS, LABEL_STREET_ADDRESS, 120);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_CITY, LABEL_CITY, 80);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_STATE, LABEL_STATE, 60);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_POSTAL_CODE, LABEL_POSTAL_CODE, 80);
        column.setAlignment(HorizontalAlignment.RIGHT);
        columns.add(column);

        column = new ColumnConfig(AccountModel.COLUMN_COUNTRY, LABEL_COUNTRY, 90);
        column.setAlignment(HorizontalAlignment.LEFT);
        columns.add(column);

        return columns;
    }
}
