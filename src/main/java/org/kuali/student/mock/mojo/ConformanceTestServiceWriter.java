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

import org.kuali.student.contract.model.Service;
import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.ServiceMethod;
import org.kuali.student.contract.model.util.ServicesFilter;
import org.kuali.student.contract.writer.service.GetterSetterNameCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will generate Conformance Tests for services.
 *
 * @author Mezba Mahtab (mezba.mahtab@utoronto.ca)
 */
public class ConformanceTestServiceWriter extends MockImplServiceWriter {

    /////////////////////////
    // CONSTANTS
    /////////////////////////

    public static final String ROOT_PACKAGE = "org.kuali.student";

    ////////////////////////////
    // Data Variables
    ////////////////////////////

    private ServicesFilter filter;

    ////////////////////////////
    // CONSTRUCTOR
    ////////////////////////////

    public ConformanceTestServiceWriter(ServiceContractModel model,
                                        String directory,
                                        String rootPackage,
                                        String servKey,
                                        List<ServiceMethod> methods,
                                        boolean isR1) {
        super(model, directory, rootPackage, servKey, methods, isR1, calcPackage(servKey, rootPackage), calcClassName(servKey));
    }

    //////////////////////////
    // FUNCTIONALS
    //////////////////////////

    public static String calcPackage(String servKey, String rootPackage) {
        String pack = rootPackage + ".";
        pack = pack + "service.test";
        return pack;
    }

    /**
     * Given the service key (name), returns a calculated class name for the conformance tester.
     */
    public static String calcClassName(String servKey) {
        return "Test" + GetterSetterNameCalculator.calcInitUpper(fixServKey(servKey) + "ServiceImplConformance");
    }

    public static List<Service> filterServices(ServiceContractModel model, ServicesFilter filter) {
        if (filter == null) {
            return model.getServices();
        }
        return filter.filter(model.getServices());
    }


    /**
     * Write out the entire file
     */
    public void write() {
        indentPrint("public class " + calcClassName(servKey));
        println(" implements " + calcServiceInterfaceClassName(servKey));
        Service serv = finder.findService(servKey);
        importsAdd(serv.getImplProject() + "." + serv.getName());
        openBrace();

        // get a list of all the DTOs managed by this class
        List<String> dtoObjectNames = new ArrayList<String>();
        for (ServiceMethod method: methods) {
            // I am assuming all the DTOs will have a createXXX method.
            if (MethodType.CREATE.equals (calcMethodType(method))) {
                String objectName = calcObjectName(method);
                dtoObjectNames.add(objectName);
                System.out.println("Object Name = " + objectName);
            }
        }

        // for each DTO, write the testCRUD
        for (String dtoObjectName : dtoObjectNames) {
            writeTestCrud(dtoObjectName);
            indentPrintln("");
        }

        closeBrace ();
        println ("");

        this.writeJavaClassAndImportsOutToFile();
        this.getOut().close();
    }

    /**
     * Write the CRUD test methods
     */
    public void writeTestCrud (String dtoObjectName) {
        // start method open signature
        indentPrintln("public void testCrud" + dtoObjectName);
        incrementIndent();
        indentPrintln("throws DataValidationErrorException,");
        incrementIndent();
        indentPrintln("DoesNotExistException,");
        indentPrintln("InvalidParameterException,");
        indentPrintln("MissingParameterException,");
        indentPrintln("OperationFailedException,");
        indentPrintln("PermissionDeniedException,");
        indentPrintln("ReadOnlyException,");
        indentPrintln("VersionMismatchException,");
        indentPrintln("DependentObjectsExistException");
        decrementIndent();
        decrementIndent();
        openBrace();
        // end method open signature

        writeTestCreate(dtoObjectName);

        // end method
        closeBrace();
    }

    /**
     * Write the 'test create' portion.
     */
    public void writeTestCreate (String dtoObjectName) {
        incrementIndent();
        indentPrintDecoratedComment("test create");
        indentPrintln(dtoObjectName + " expected = new " + dtoObjectName + " ()");
        indentPrintln("expected.setName(\"Name01\");");
        indentPrintln("expected.setDescr(new RichTextHelper().fromPlain(\"Description01\"));");
        indentPrintln("");
        indentPrintln("// INSERT CODE TO SET MORE DTO FIELDS HERE");
        indentPrintln("");

        indentPrintln("if (expected implements TypeStateEntityInfo)");
        openBrace();
        incrementIndent();
        indentPrintln("expectedTS = (TypeStateEntityInfo) expected;");
        indentPrintln("expectedTS.setTypeKey(\"Type01\");");
        indentPrintln("expectedTS.setStateKey(\"State01\");");
        decrementIndent();
        closeBrace();
        indentPrintln("new AttributeTester().add2ForCreate(expected.getAttributes());");

        indentPrintln("");
        indentPrintln("DTOInfo actual = // INSERT CODE TO CREATE actual HERE");
        indentPrintln("");

        indentPrintln("assertNotNull(actual.getId());");
        indentPrintln("new IdEntityTester().check(expected, actual);");

        indentPrintln("");
        indentPrintln("// INSERT CODE FOR TESTING MORE DTO FIELDS HERE");
        indentPrintln("");

        indentPrintln("new AttributeTester().check(expected.getAttributes(), actual.getAttributes());");
        indentPrintln("new MetaTester().checkAfterCreate(actual.getMeta());");

        decrementIndent();
    }


    /**
     * Writes out a decorated comment.
     */
    public void indentPrintDecoratedComment (String label) {
        indentPrintln("// ----------------------");
        indentPrintln("// " + label);
        indentPrintln("// ----------------------");
    }

}
