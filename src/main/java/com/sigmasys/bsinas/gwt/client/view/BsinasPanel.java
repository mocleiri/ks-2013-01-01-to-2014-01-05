package com.sigmasys.bsinas.gwt.client.view;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.*;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboValue;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.sigmasys.bsinas.gwt.client.service.GenericCallback;
import com.sigmasys.bsinas.gwt.client.service.GwtErrorHandler;
import com.sigmasys.bsinas.gwt.client.service.ServiceFactory;
import com.sigmasys.bsinas.gwt.client.util.StringUtils;
import com.sigmasys.bsinas.gwt.client.view.widget.WidgetFactory;


/**
 * BSINAS Root Panel
 *
 * @author Michael Ivanov
 */
public class BsinasPanel extends LayoutContainer {

    private static final String DEFAULT_REQUEST_2012 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<needAnalysisInput CreatedDate=\"2012-10-23\" AwardYear=\"2012\" xmlns=\"http://INAS.collegeboard.org/2012/Input/\">\n" +
            "</needAnalysisInput>\n";

    private static final String DEFAULT_REQUEST_2013 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<needAnalysisInput CreatedDate=\"2013-05-23\" AwardYear=\"2013\" xmlns=\"http://INAS.collegeboard.org/2013/Input/\">\n" +
            "</needAnalysisInput>\n";

    private TextArea requestTextArea;
    private TextArea responseTextArea;
    private SimpleComboBox<Integer> yearComboBox;


    public BsinasPanel() {

        setLayout(new FitLayout());

        final LayoutContainer panel = new LayoutContainer(new TableLayout(3));

        requestTextArea = new TextArea();
        requestTextArea.setWidth(750);
        requestTextArea.setHeight(600);
        requestTextArea.setValue(DEFAULT_REQUEST_2013);

        responseTextArea = new TextArea();
        responseTextArea.setWidth(750);
        responseTextArea.setHeight(600);

        LayoutContainer yearPanel = new LayoutContainer(new TableLayout(1));

        yearComboBox = new SimpleComboBox<Integer>();

        yearComboBox.add(2012);
        yearComboBox.add(2013);

        yearComboBox.setSimpleValue(2013);
        yearComboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
        yearComboBox.setAllowBlank(false);
        yearComboBox.setEditable(false);
        yearComboBox.setForceSelection(true);
        yearComboBox.addSelectionChangedListener(new SelectionChangedListener<SimpleComboValue<Integer>>() {
            @Override
            public void selectionChanged(SelectionChangedEvent<SimpleComboValue<Integer>> event) {
                Integer selectedValue = event.getSelectedItem().getValue();
                if (selectedValue != null) {
                    switch (selectedValue) {
                        case 2012:
                            requestTextArea.setValue(DEFAULT_REQUEST_2012);
                            responseTextArea.setValue("");
                            break;
                        case 2013:
                            requestTextArea.setValue(DEFAULT_REQUEST_2013);
                            responseTextArea.setValue("");
                            break;
                    }
                }
            }
        });


        LayoutContainer buttonPanel = new LayoutContainer(new TableLayout(1));

        Button submitButton = new Button("Submit");
        submitButton.setWidth(80);
        submitButton.setIconStyle("icon-check");
        submitButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent event) {
                try {
                    String requestXml = requestTextArea.getValue();
                    if (!StringUtils.isEmpty(requestXml)) {
                        responseTextArea.mask("Processing request...");
                        int year = yearComboBox.getSimpleValue();
                        ServiceFactory.getBsinasService().runEngine(requestXml, year, new GenericCallback<String>() {
                            @Override
                            public void onSuccess(String responseXml) {
                                responseTextArea.setValue(responseXml);
                                responseTextArea.unmask();
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                responseTextArea.unmask();
                                responseTextArea.setValue("");
                                super.onFailure(t);
                            }
                        });
                    } else {
                        GwtErrorHandler.error("XML Request cannot be empty");
                    }
                } catch (Exception e) {
                    responseTextArea.unmask();
                    responseTextArea.setValue("");
                    GwtErrorHandler.error(e);
                }
            }
        });

        Button resetButton = new Button("Reset");
        resetButton.setWidth(80);
        resetButton.setIconStyle("icon-undo");
        resetButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent event) {
                responseTextArea.unmask();
                requestTextArea.setValue(DEFAULT_REQUEST_2013);
                responseTextArea.setValue("");
                yearComboBox.setSimpleValue(2013);
            }
        });


        TableData td = new TableData(Style.HorizontalAlignment.CENTER, Style.VerticalAlignment.TOP);
        td.setMargin(10);
        td.setPadding(10);

        TableData btd = new TableData(Style.HorizontalAlignment.CENTER, Style.VerticalAlignment.MIDDLE);
        btd.setMargin(5);
        btd.setPadding(5);

        yearPanel.add(WidgetFactory.createText("Award Year:"), td);
        yearPanel.add(yearComboBox, td);

        buttonPanel.add(submitButton, btd);
        buttonPanel.add(resetButton, btd);

        panel.add(WidgetFactory.createText("XML Request:"), td);
        //panel.add(yearPanel);
        panel.add(WidgetFactory.createText(""));
        panel.add(WidgetFactory.createText("XML Response:"), td);

        panel.add(requestTextArea, td);
        panel.add(buttonPanel, td);
        panel.add(responseTextArea, td);

        add(panel);
    }

}
