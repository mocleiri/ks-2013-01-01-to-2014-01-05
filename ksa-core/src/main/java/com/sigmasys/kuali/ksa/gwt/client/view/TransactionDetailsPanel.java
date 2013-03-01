package com.sigmasys.kuali.ksa.gwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.*;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sigmasys.kuali.ksa.gwt.client.model.TransactionModel;
import com.sigmasys.kuali.ksa.gwt.client.service.GwtErrorHandler;
import com.sigmasys.kuali.ksa.gwt.client.service.ServiceFactory;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.OkCancelDialog;
import com.sigmasys.kuali.ksa.gwt.client.view.widget.WidgetFactory;

import java.util.Date;

/**
 * User: dmulderink
 * Date: 5/14/12
 * Time: 9:26 AM
 */
public class TransactionDetailsPanel extends AbstractDetailsPanel<TransactionModel> {

   // Common fields

   protected final Text accountId = WidgetFactory.createStyledText("", "text-link");

   // Charge - aka Debit type
   protected final Text isDeferred = WidgetFactory.createStyledText("", "text-link");

   // Payment - aka Credit type
   protected final Text isRefundable = WidgetFactory.createStyledText("", "text-link");
   protected final Text refundRule = WidgetFactory.createStyledText("", "text-link");
   protected final Text clearDate = WidgetFactory.createStyledText("", "text-link");

   // Deferment - aka a deferred debit
   protected final Text expireDate = WidgetFactory.createStyledText("", "text-link");

   protected final LayoutContainer commonPanel;
   protected final LayoutContainer debitPanel;
   protected final LayoutContainer creditPanel;
   protected final LayoutContainer specialPanel;

   public TransactionDetailsPanel() {

      final int CELL_PADDING = 10;
      final int CELL_SPACING = 0;

      setHeading("Transaction Details");

      setScrollMode(Style.Scroll.AUTO);

      setLayout(new FitLayout());

      VerticalPanel panel = new VerticalPanel();
      panel.setHorizontalAlign(Style.HorizontalAlignment.LEFT);
      panel.setStyleName("bg-white");

      // -----
      TableLayout layout = new TableLayout(1);
      layout.setCellPadding(CELL_PADDING);
      layout.setCellSpacing(CELL_SPACING);

      commonPanel = new LayoutContainer(layout);
      commonPanel.add(WidgetFactory.createText("Account ID"));
      commonPanel.add(accountId);

      // -----
      layout = new TableLayout(1);
      layout.setCellPadding(CELL_PADDING);
      layout.setCellSpacing(CELL_SPACING);

      debitPanel = new LayoutContainer(layout);
      debitPanel.add(WidgetFactory.createText("Deferred"));
      //debitPanel.add(addChargeButton);

      TableData td = new TableData();
      td.setColspan(1);
      debitPanel.add(isDeferred);

      // -----
      layout = new TableLayout(3);
      layout.setCellPadding(CELL_PADDING);
      layout.setCellSpacing(CELL_SPACING);

      creditPanel = new LayoutContainer(layout);
      creditPanel.add(WidgetFactory.createText("Refundable"));
      creditPanel.add(WidgetFactory.createText("Refund Rule"));
      creditPanel.add(WidgetFactory.createText("Clear Date"));
      //creditPanel.add(makePaymentButton);

      creditPanel.add(isRefundable);
      creditPanel.add(refundRule);

      td = new TableData();
      td.setColspan(2);
      creditPanel.add(clearDate);

      // -----
      // deferment and special information
      layout = new TableLayout(1);
      layout.setCellPadding(CELL_PADDING);
      layout.setCellSpacing(CELL_SPACING);

      specialPanel = new LayoutContainer(layout);
      specialPanel.add(WidgetFactory.createText("Expiration Date"));

      td = new TableData();
      td.setColspan(1);
      specialPanel.add(expireDate);

      panel.add(WidgetFactory.createTextBold("&nbsp;Extended Transaction Information"));
      panel.add(commonPanel);
      panel.add(WidgetFactory.createTextBold("&nbsp;Charges"));
      panel.add(debitPanel);
      panel.add(WidgetFactory.createTextBold("&nbsp;Payments"));
      panel.add(creditPanel);
      panel.add(WidgetFactory.createTextBold("&nbsp;Deferments"));
      panel.add(specialPanel);
      add(panel);
   }

   @Override
   public void updateView(TransactionModel model) {

      if (model == null) {
         GwtErrorHandler.error("TransactionModel is null");
         return;
      }

      accountId.setText(model.getId().toString());
      //isDeferred.setText(model.get);
      //isRefundable
      refundRule.setText(model.getRefundRule());
      //clearDate.setText(model.);
      //expireDate.setText(displayDate(model.get);

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

/*
   private Dialog createAddTransactionDlg(final String eventType, final AccountModel model, final Command command) {
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
            setHeading("Add Transaction (Account ID: " + model.getId() + ")");
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

         }

         @Override
         protected void onOkClicked() {
            if (eventType.compareTo("Charge") == 0) {
               addChargeButton.setData("type", transType.getRawValue());
               addChargeButton.setData("amount", Double.parseDouble(transAmount.getRawValue()));
               addChargeButton.setData("extnId", transExtnId.getRawValue());
            }
            else if (eventType.compareTo("Payment") == 0) {
               makePaymentButton.setData("type", transType.getRawValue());
               makePaymentButton.setData("amount", Double.parseDouble(transAmount.getRawValue()));
               makePaymentButton.setData("extnId", transExtnId.getRawValue());
            }

            hide();
            if (command != null) {
               command.execute();
            }
         }
      };
   }
*/

}
