/**
 * Copyright 2013 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * Created by David Yin on 1/31/13
 */
package org.kuali.student.common.uif.view;

import org.kuali.rice.krad.uif.view.FormView;

/**
 * This class extends FormView and can be used to hold any properties that can be
 * shared among all the forms that extend it.
 *
 * @author Kuali Student Team
 */
public class KSUifFormView extends FormView {

    protected String viewSourceFile;

    public String getViewSourceFile() {
        return viewSourceFile;
    }

    public void setViewSourceFile(String viewSourceFile) {
        this.viewSourceFile = viewSourceFile;
    }

    /**
     * @see org.kuali.rice.krad.uif.component.ComponentBase#copy()
     */
    @Override
    protected <T> void copyProperties(T component) {
        super.copyProperties(component);

        KSUifFormView ksUifFormViewCopy = (KSUifFormView) component;

        ksUifFormViewCopy.setViewSourceFile(this.viewSourceFile);
    }
}
