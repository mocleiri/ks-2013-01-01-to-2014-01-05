/**
 * Copyright 2010 The Kuali Foundation Licensed under the Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.osedu.org/licenses/ECL-2.0 Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing permissions and limitations under the License.
 */

package org.kuali.student.common.ui.client.service;

import java.util.ArrayList;

import org.kuali.student.common.assembly.data.Data;
import org.kuali.student.common.ui.client.util.ExportElement;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpcservices/GwtExportRpcService")
public interface GwtExportRpcService extends RemoteService {

    public String reportExport(ArrayList<ExportElement> exportElements, Data root, String templateName, String exportFormat, String reportTitle);
}
