package com.sigmasys.bsinas.gwt.client.service;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.sigmasys.bsinas.gwt.client.model.ReferenceData;

import java.util.ArrayList;
import java.util.List;

/**
 * KSA ReferenceDataManager
 *
 * @author Michael Ivanov
 */
public class ReferenceDataProvider {

    private static final List<ReferenceDataCommand> beforeReferenceDataSet = new ArrayList<ReferenceDataCommand>();
    private static final List<ReferenceDataCommand> afterReferenceDataSet = new ArrayList<ReferenceDataCommand>();

    private static ReferenceData referenceData;
    private static MessageBox waitingBox;


    public static void init() {
        init(null);
    }

    public static void init(MessageBox waitingBox) {
        ReferenceDataProvider.waitingBox = (waitingBox != null) ?
                waitingBox :
                MessageBox.wait("", "Loading reference data...", "");
        try {
            ServiceFactory.getConfigService().getReferenceData(
                    new GenericCallback<ReferenceData>() {
                        public void onSuccess(ReferenceData result) {
                            try {
                                executeCommands(result, beforeReferenceDataSet);
                                referenceData = result;
                                executeCommands(referenceData, afterReferenceDataSet);
                                closeWaitingBox();
                            } catch (Throwable t) {
                                handleError(t);
                            }
                        }

                        public void onFailure(Throwable t) {
                            handleError(t);
                        }
                    }
            );
        } catch (Throwable t) {
            handleError(t);
        }
    }

    public static ReferenceData getReferenceData() {
        return referenceData;
    }

    public static void addBeforeSetCommand(ReferenceDataCommand command) {
        beforeReferenceDataSet.add(command);
    }

    public static void addAfterSetCommand(ReferenceDataCommand command) {
        afterReferenceDataSet.add(command);
    }

    public static void removeCommands() {
        beforeReferenceDataSet.clear();
        afterReferenceDataSet.clear();
    }

    private static void closeWaitingBox() {
        if (waitingBox != null && waitingBox.isVisible()) {
            waitingBox.close();
        }
    }

    private static void handleError(Throwable t) {
        closeWaitingBox();
        GwtErrorHandler.error("Cannot retrieve reference data. ", t);
    }

    private static void executeCommands(ReferenceData referenceData, List<ReferenceDataCommand> commands) {
        for (ReferenceDataCommand command : commands) {
            command.execute(referenceData);
        }
    }

}
