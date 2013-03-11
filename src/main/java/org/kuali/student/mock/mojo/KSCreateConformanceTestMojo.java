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
 * Created by Mezba Mahtab (mezba.mahtab@utoronto.ca) on 3/8/13
 */
package org.kuali.student.mock.mojo;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.kuali.student.common.mojo.AbstractKSMojo;
import org.kuali.student.contract.model.ServiceContractModel;

/**
 * This class associates a mojo to create the conformance tests.
 *
 * @goal kscreateconftest
 * @phase site
 * @requiresProject true
 * @author Mezba Mahtab (mezba.mahtab@utoronto.ca)
 */
public class KSCreateConformanceTestMojo extends AbstractKSMojo {

    ///////////////////////////
    // Data Variables
    ///////////////////////////

    private String targetDir;

    ///////////////////////////
    // Getters and Setters
    ///////////////////////////

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    ///////////////////////////
    // Constructor
    ///////////////////////////

    public KSCreateConformanceTestMojo() {}

    ////////////////////////////
    // Functional Methods
    ////////////////////////////

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        ServiceContractModel model = getModel();
        validate(model);
        if (targetDir == null) {
            targetDir = "target/generated-conf-tests";
        }
        boolean isR1 = false;
        ConformanceTestWriter instance =
                new ConformanceTestWriter(model,
                        targetDir,
                        MockImplWriter.ROOT_PACKAGE,
                        null,
                        isR1);
        instance.write();
    }

}
