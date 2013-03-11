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
 * Created by Mezba Mahtab (mezba.mahtab@utoronto.ca) on 3/11/13
 */
package org.kuali.student.mock.mojo;

import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.ServiceMethod;

import java.util.List;

/**
 * This class writes the conformance test for one service.
 *
 * @author Mezba Mahtab (mezba.mahtab@utoronto.ca)
 */
public class ConformanceTestWriterForOneService extends MockImplWriterForOneService {

    /////////////////////////////
    // CONSTRUCTOR
    /////////////////////////////

    public ConformanceTestWriterForOneService
            (ServiceContractModel model,
             String directory,
             String rootPackage,
             String servKey,
             boolean isR1) {
        super (model, directory, rootPackage, servKey, isR1);
    }

    ////////////////////////
    // FUNCTIONAL
    ////////////////////////

    /**
     * Write out the entire file
     */
    public void write() {
        List<ServiceMethod> methods = finder.getServiceMethodsInService(servKey);
        if (methods.size() == 0) {
            System.out.println("No methods defined for servKey: " + servKey);
            return;
        }

        // the main servKey
        System.out.println("Generating Conformance Tests for " + servKey);
        new ConformanceTestServiceWriter(model, directory, rootPackage, servKey, methods, isR1).write();
    }
}
