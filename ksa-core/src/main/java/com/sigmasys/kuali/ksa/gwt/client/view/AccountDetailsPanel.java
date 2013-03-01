package com.sigmasys.kuali.ksa.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.*;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.google.gwt.user.client.Command;
import com.sigmasys.kuali.ksa.gwt.client.model.AccountModel;
import com.sigmasys.kuali.ksa.gwt.client.service.GenericCallback;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtAccountServiceAsync;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtErrorHandler;
import com.sigmasys.kuali.ksa.gwt.client.service.ServiceFactory;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.OkCancelDialog;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.WidgetFactory;

public class AccountDetailsPanel extends AbstractDetailsPanel<AccountModel> {

    protected final Text pastDue = WidgetFactory.createStyledText("", "text-link");
    protected final Text balance = WidgetFactory.createStyledText("", "text-link");
    protected final Text future = WidgetFactory.createStyledText("", "text-link");
    protected final Text deferment = WidgetFactory.createStyledText("", "text-link");

    protected final Text userId = WidgetFactory.createStyledText("", "text-link");
    protected final Text userName = WidgetFactory.createStyledText("", "text-link");
    protected final Text address = WidgetFactory.createStyledText("", "text-link");
    protected final Text phone = WidgetFactory.createStyledText("", "text-link");

    protected final Text lastAgeDate = WidgetFactory.createStyledText("", "text-link");
    protected final Text lateAmount1 = WidgetFactory.createStyledText("", "text-link");
    protected final Text lateAmount2 = WidgetFactory.createStyledText("", "text-link");
    protected final Text lateAmount3 = WidgetFactory.createStyledText("", "text-link");

    protected final CheckBox ignoreDefermentCheckBox;

    protected final Button ageDebtButton;

    protected final LayoutContainer contactPanel;
    protected final LayoutContainer statusPanel;
    protected final LayoutContainer ageDebtPanel;
    //protected final LayoutContainer alertPanel;
    //protected final LayoutContainer flagPanel;
    //protected final LayoutContainer memoPanel;

    public AccountDetailsPanel() {

        final int CELL_PADDING = 10;
        final int CELL_SPACING = 0;

        setHeading("Account Details");

        setScrollMode(Style.Scroll.AUTO);

        setLayout(new FitLayout());

        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlign(Style.HorizontalAlignment.LEFT);
        panel.setStyleName("bg-white");

        ageDebtButton = new Button("Age Transactions");
        ageDebtButton.addListener(Events.OnClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                Command command = new Command() {
                    @Override
                    public void execute() {
                        ageDebt();
                    }
                };
                createYesNoDialog("Age Transactions", "Are you sure you want to age transactions?", command).show();
            }
        });

        TableLayout layout = new TableLayout(4);
        layout.setCellPadding(CELL_PADDING);
        layout.setCellSpacing(CELL_SPACING);

        contactPanel = new LayoutContainer(layout);
        contactPanel.add(WidgetFactory.createText("Account ID"));
        contactPanel.add(WidgetFactory.createText("User Name"));
        contactPanel.add(WidgetFactory.createText("Address"));
        contactPanel.add(WidgetFactory.createText("Phone #"));
        contactPanel.add(userId);
        contactPanel.add(userName);
        contactPanel.add(address);
        contactPanel.add(phone);

        layout = new TableLayout(4);
        layout.setCellPadding(CELL_PADDING);
        layout.setCellSpacing(CELL_SPACING);

        statusPanel = new LayoutContainer(layout);
        statusPanel.add(WidgetFactory.createText("Past Due"));
        statusPanel.add(WidgetFactory.createText("Balance"));
        statusPanel.add(WidgetFactory.createText("Future"));
        statusPanel.add(WidgetFactory.createText("Deferment"));

        statusPanel.add(pastDue);
        statusPanel.add(balance);
        statusPanel.add(future);

        TableData td = new TableData();
        td.setColspan(3);
        statusPanel.add(deferment);


        layout = new TableLayout(6);
        layout.setCellPadding(CELL_PADDING);
        layout.setCellSpacing(CELL_SPACING);

        ageDebtPanel = new LayoutContainer(layout);
        ageDebtPanel.add(WidgetFactory.createText("Last Age Date"));
        ageDebtPanel.add(WidgetFactory.createText("30"));
        ageDebtPanel.add(WidgetFactory.createText("60"));
        ageDebtPanel.add(WidgetFactory.createText("90"));

        ignoreDefermentCheckBox = new CheckBox();
        ignoreDefermentCheckBox.setValue(true);
        ignoreDefermentCheckBox.setBoxLabel("Ignore Deferment");

        ageDebtPanel.add(ignoreDefermentCheckBox);
        ageDebtPanel.add(ageDebtButton);

        ageDebtPanel.add(lastAgeDate);
        ageDebtPanel.add(lateAmount1);
        ageDebtPanel.add(lateAmount2);

        td = new TableData();
        td.setColspan(3);
        ageDebtPanel.add(lateAmount3, td);


        panel.add(WidgetFactory.createTextBold("&nbsp;Account Information"));
        panel.add(contactPanel);

        panel.add(WidgetFactory.createTextBold("&nbsp;Account Status"));
        panel.add(statusPanel);

        panel.add(WidgetFactory.createTextBold("&nbsp;Aged Transactions"));
        panel.add(ageDebtPanel);

        add(panel);

    }

    private void ageDebt() {
        final AccountModel model = ageDebtButton.getData("model");
        if (model != null && model.getId() != null) {
            try {
                AccountDetailsPanel.this.mask("Processing...");
                boolean ignoreDeferment = ignoreDefermentCheckBox.getValue() != null ?
                        ignoreDefermentCheckBox.getValue() : false;
                ServiceFactory.getAccountService().ageDebt(model.getId(), ignoreDeferment,
                        new GenericCallback<AccountModel>() {
                            @Override
                            public void onSuccess(AccountModel result) {
                                updateView(result);
                                Grid<AccountModel> grid = getListPanel().getGrid();
                                ListStore<AccountModel> listStore = grid.getStore();
                                int index = listStore.indexOf(model);
                                if (index >= 0) {
                                    listStore.remove(model);
                                    listStore.insert(result, index);
                                    getListPanel().refreshGridRows(listStore.getModels());
                                    GridSelectionModel<AccountModel> selectionModel = grid.getSelectionModel();
                                    selectionModel.select(result, false);
                                    grid.setSelectionModel(selectionModel);
                                    grid.getView().refresh(false);
                                }
                                AccountDetailsPanel.this.unmask();
                                Info.display("Success", "Aging completed");
                                if ( index >= 0) {
                                    grid.getView().focusRow(index);
                                }
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                AccountDetailsPanel.this.unmask();
                                super.onFailure(t);
                            }
                        });
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
                AccountDetailsPanel.this.unmask();
            }
        }
    }

    @Override
    public void updateView(AccountModel model) {

        if (model == null) {
            GwtErrorHandler.error("AccountModel is null");
            return;
        }

        ageDebtButton.setData("model", model);

        userId.setText(model.getId());

        userName.setText(
                ((model.getFirstName() != null) ? model.getFirstName() : "") + " " +
                        ((model.getMiddleName() != null) ? model.getMiddleName() : "") +
                        ((model.getLastName() != null) ? model.getLastName() : ""));

        address.setText(
                model.getStreetAddress() + ", " +
                        model.getCity() + ", " +
                        model.getState() + ", " +
                        model.getPostalCode() + ", " +
                        model.getCountry());

        phone.setText(model.getPhoneNumber());

        lateAmount1.setText(displayDouble2(model.getAmountLate1()));
        lateAmount2.setText(displayDouble2(model.getAmountLate2()));
        lateAmount3.setText(displayDouble2(model.getAmountLate3()));

        lastAgeDate.setText(displayDate(model.getLateLastUpdate()));

        GwtAccountServiceAsync accountService = ServiceFactory.getAccountService();

        accountService.getOutstandingBalance(model.getId(), true, new GenericCallback<Double>() {
            @Override
            public void onSuccess(Double result) {
                pastDue.setText(displayDouble2(result));
            }
        });

        accountService.getDueBalance(model.getId(), true, new GenericCallback<Double>() {
            @Override
            public void onSuccess(Double result) {
                balance.setText(displayDouble2(result));
            }
        });

        accountService.getUnallocatedBalance(model.getId(), new GenericCallback<Double>() {
            @Override
            public void onSuccess(Double result) {
                future.setText(displayDouble2(result));
            }
        });

        accountService.getDeferredAmount(model.getId(), new GenericCallback<Double>() {
            @Override
            public void onSuccess(Double result) {
                deferment.setText(displayDouble2(result));
            }
        });

        // TODO - populate the other fields

    }

    private Dialog createYesNoDialog(final String title, final String message, final Command command) {
        return new OkCancelDialog(title) {

            {
                okText = "Yes";
                cancelText = "No";
            }

            @Override
            protected void init() {
                setLayout(new BorderLayout());
                BorderLayoutData layoutData = new BorderLayoutData(Style.LayoutRegion.CENTER);
                layoutData.setMargins(new Margins(10, 10, 10, 10));
                add(WidgetFactory.createTextBold(message), layoutData);
            }

            @Override
            protected void onOkClicked() {
                hide();
                if (command != null) {
                    command.execute();
                }
            }
        };
    }
}
