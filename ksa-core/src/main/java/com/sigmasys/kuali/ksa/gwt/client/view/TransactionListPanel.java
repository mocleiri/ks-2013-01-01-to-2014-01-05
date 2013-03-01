package com.sigmasys.kuali.ksa.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sigmasys.kuali.ksa.gwt.client.model.NavigationContext;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;
import com.sigmasys.kuali.ksa.gwt.client.service.ServiceFactory;
import com.sigmasys.kuali.ksa.gwt.client.service.TransactionColumnModelFactory;
import com.sigmasys.kuali.ksa.gwt.client.service.ColumnModelFactory;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.EntityNameField;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.OkCancelDialog;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.WidgetFactory;

import java.util.Collection;
import java.util.Date;

/**
 * TransactionListPanel
 *
 * @author dmulderink, mivanov
 *         Date: 5/14/12
 *         Time: 9:24 AM
 */
public class TransactionListPanel extends AbstractListPanel<TransactionModel> {

    private static final TransactionColumnModelFactory COLUMN_FACTORY = new TransactionColumnModelFactory();

    private Button addChargeButton;
    private Button addPaymentButton;
    private Button deferTransactionButton;

    public TransactionListPanel(NavigationContext navigationContext) {
        super(navigationContext);
    }

    @Override
    protected ToolBar createTopComponent() {

        addChargeButton = new Button("Add Charge");
        addChargeButton.setToolTip("Add a new charge");
        addChargeButton.addListener(Events.OnClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                TransactionModel model = getSelectedItem();
                if (model != null) {
                    addChargeButton.setData("model", model);
                    Command command = new Command() {
                        @Override
                        public void execute() {
                            addCharge();
                        }
                    };
                    Info.display("Add Charge", "Add Charge");
                    createAddTransactionDlg("Charge", model, command).show();

                }
            }
        });

        addPaymentButton = new Button("Add Payment");
        addPaymentButton.setToolTip("Add a new payment");
        addPaymentButton.addListener(Events.OnClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                TransactionModel model = getSelectedItem();
                if (model != null) {
                    addPaymentButton.setData("model", model);
                    Command command = new Command() {
                        @Override
                        public void execute() {
                            addPayment();
                        }
                    };

                    Info.display("Add Payment", "Add Payment");
                    createAddTransactionDlg("Payment", model, command).show();
                }
            }
        });

        deferTransactionButton = new Button("Defer Transaction");
        deferTransactionButton.setToolTip("Defer a transaction");
        deferTransactionButton.addListener(Events.OnClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                TransactionModel model = getSelectedItem();
                if (model != null) {

                    Info.display("Defer Transaction", "Defer Transaction");
                    deferTransactionButton.setData("model", model);
                }
            }
        });


        ToolBar toolBar = new ToolBar();

        toolBar.add(addChargeButton);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(addPaymentButton);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(deferTransactionButton);


        enableButtons(false);

        return toolBar;
    }

    private void addCharge() {
        final TransactionModel model = addChargeButton.getData("model");
        final String transType = addChargeButton.getData("type");
        final Double amount = addChargeButton.getData("amount");
        final String extnId = addChargeButton.getData("extnId");
        if (model != null && model.getId() != null && transType != null && amount != null && extnId != null) {
            createTransactionModel("Charge", transType, extnId, model, amount);
        }
    }

    private void addPayment() {
        final TransactionModel model = addPaymentButton.getData("model");
        final String transType = addPaymentButton.getData("type");
        final Double amount = addPaymentButton.getData("amount");
        final String extnId = addPaymentButton.getData("extnId");
        if (model != null && model.getId() != null && transType != null && amount != null && extnId != null) {
            createTransactionModel("Payment", transType, extnId, model, amount);
        }
    }

    private void createTransactionModel(final String eventType, String transType,
                                        String extnId, final TransactionModel model, Double amount) {
        final AbstractDetailsPanel<TransactionModel> tdp = getDetailsPanel();

        try {
            tdp.mask("Processing...");
            ServiceFactory.getTransactionService().createTransaction(
                    transType, extnId, model.getAccountId(), new Date(), amount,
                    new AsyncCallback<TransactionModel>() {
                        @Override
                        public void onSuccess(TransactionModel result) {
                            // TODO Update the detail when adding a charge or payment making
                            // the new transaction visible in the detail panel
                            //updateView(result);
                            Grid<TransactionModel> grid = getGrid();
                            ListStore<TransactionModel> listStore = grid.getStore();
                            int indexCount = listStore.getCount();
                            if (indexCount < 0) {
                                indexCount = 0;
                            }

                            listStore.insert(result, indexCount);
                            refreshGridRows(listStore.getModels());
                            GridSelectionModel<TransactionModel> selectionModel = grid.getSelectionModel();
                            selectionModel.select(result, false);
                            grid.setSelectionModel(selectionModel);
                            grid.getView().refresh(false);

                            tdp.unmask();
                            String displayValue = "Add " + eventType + " completed";
                            Info.display("Success", displayValue);
                            if (indexCount >= 0) {
                                grid.getView().focusRow(indexCount);
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            tdp.unmask();
                            //super.onFailure(t);
                        }
                    });
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
            tdp.unmask();
        }
    }

    @Override
    protected ColumnModelFactory<TransactionModel> getColumnModelFactory() {
        return COLUMN_FACTORY;
    }

    @Override
    protected void loadData(PagingLoadConfig loadConfig,
                            AsyncCallback<PagingLoadResult<TransactionModel>> callback) {
        enableButtons(false);
        SortInfo sortInfo = loadConfig.getSortInfo();

        ServiceFactory.getTransactionService().findTransactions(
                getSearchCriteria(),
                sortInfo.getSortDir().name(),
                sortInfo.getSortField(),
                loadConfig.getOffset(),
                loadConfig.getLimit(), callback);
    }

    @Override
    protected String getAutoExpandColumn() {
        return TransactionModel.COLUMN_STATEMENT_TEXT;
    }


    protected void enableButtons(boolean enabled) {
        addChargeButton.setEnabled(enabled);
        addPaymentButton.setEnabled(enabled);
        deferTransactionButton.setEnabled(enabled);
    }

    @Override
    protected void onSingleRowSelection(TransactionModel item) {
        enableButtons(item != null);
        super.onSingleRowSelection(item);
    }

    @Override
    protected void onEmptyRowSelection() {
        enableButtons(false);
        super.onEmptyRowSelection();
    }

    @Override
    protected void onMultipleRowSelection(Collection<TransactionModel> items) {
        enableButtons(false);
        super.onMultipleRowSelection(items);
    }

    private Dialog createAddTransactionDlg(final String eventType, final TransactionModel model, final Command command) {
        final int ELEMENT_TYPE_WIDTH = 50;
        final int ELEMENT_AMOUNT_WIDTH = 80;
        final int ELEMENT_EXTN_ID_WIDTH = 100;

        final EntityNameField transType = new EntityNameField();
        final EntityNameField transAmount = new EntityNameField();
        final EntityNameField transExtnId = new EntityNameField();

        final String transTitle = "Add " + eventType;

        return new OkCancelDialog(transTitle) {

            @Override
            protected void init() {
                setModal(false);
                setHeading("Add Transaction (Account ID: " + model.getAccountId() + ")");
                setResizable(true);
                setClosable(true);
                setSize(700, 400);

                TableLayout layout = new TableLayout(2);
                layout.setCellSpacing(2);
                layout.setCellPadding(3);

                setLayout(layout);

                transType.setWidth(ELEMENT_TYPE_WIDTH);
                Text transTypeLabel = WidgetFactory.createText("Transaction Type:");
                add(transTypeLabel);
                add(transType);

                transAmount.setWidth(ELEMENT_AMOUNT_WIDTH);
                Text transAmountLabel = WidgetFactory.createText("Amount:");
                add(transAmountLabel);
                add(transAmount);

                transExtnId.setWidth(ELEMENT_EXTN_ID_WIDTH);
                Text transExtnIdLabel = eventType.compareTo("Charge") == 0 ?
                        WidgetFactory.createText("External ID:") : WidgetFactory.createText("Authorization Code:");
                add(transExtnIdLabel);
                add(transExtnId);

                transType.focus();
            }

            @Override
            protected void onOkClicked() {
                if (eventType.compareTo("Charge") == 0) {
                    addChargeButton.setData("type", transType.getRawValue());
                    addChargeButton.setData("amount", Double.parseDouble(transAmount.getRawValue()));
                    addChargeButton.setData("extnId", transExtnId.getRawValue());
                } else if (eventType.compareTo("Payment") == 0) {
                    addPaymentButton.setData("type", transType.getRawValue());
                    addPaymentButton.setData("amount", Double.parseDouble(transAmount.getRawValue()));
                    addPaymentButton.setData("extnId", transExtnId.getRawValue());
                }

                hide();
                if (command != null) {
                    command.execute();
                }
            }
        };
    }
}
