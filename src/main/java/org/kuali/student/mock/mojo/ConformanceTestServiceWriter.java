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

import org.kuali.student.contract.model.MessageStructure;
import org.kuali.student.contract.model.Service;
import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.ServiceMethod;
import org.kuali.student.contract.model.ServiceMethodParameter;
import org.kuali.student.contract.model.util.ServicesFilter;
import org.kuali.student.contract.writer.service.GetterSetterNameCalculator;

import javax.management.OperationsException;
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
        return "Test" + GetterSetterNameCalculator.calcInitUpper(fixServKey(servKey) + "ServiceImplBaseConformance");
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
        indentPrintln("@RunWith(SpringJUnit4ClassRunner.class)");
        indentPrint("public class " + calcClassName(servKey));
        println(" implements " + calcServiceInterfaceClassName(servKey));
        Service serv = finder.findService(servKey);
        importsAdd(serv.getImplProject() + "." + serv.getName());
        importsAdd("org.kuali.student.r2.common.dto.IdEntityInfo");
        importsAdd("org.kuali.student.r2.common.dto.TypeStateEntityInfo");
        openBrace();

        // context info setup
        indentPrintln("public ContextInfo contextInfo = null;");
        indentPrintln("public static String principalId = \"123\";");
        indentPrintln("");
        indentPrintln("@Before");
        indentPrintln("public void setUp()");
        openBrace();
        indentPrintln("principalId = \"123\";");
        indentPrintln("contextInfo = new ContextInfo();");
        indentPrintln("contextInfo.setPrincipalId(principalId);");
        closeBrace();
        indentPrintln("");

        // get a list of all the DTOs managed by this class
        List<String> dtoObjectNames = new ArrayList<String>();
        for (ServiceMethod method: methods) {
            // I am assuming all the DTOs will have a createXXX method.
            if (MethodType.CREATE.equals (calcMethodType(method))) {
                String objectName = calcObjectName(method);
                dtoObjectNames.add(objectName);
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

        // get the message structures of the dto
        List<MessageStructure> messageStructures = null;
        try {
            messageStructures = finder.findMessageStructures(dtoObjectName + "Info");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // start method open signature
        indentPrintln("// ****************************************************");
        indentPrintln("//           " + dtoObjectName + "Info");
        indentPrintln("// ****************************************************");
        indentPrintln("@Test");
        indentPrintln("public void testCrud" + dtoObjectName + "() ");
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

        // write the test portions
        incrementIndent();
        writeTestCreate(dtoObjectName, messageStructures);
        writeTestUpdate(dtoObjectName, messageStructures);
        writeTestReadAfterUpdate(dtoObjectName, messageStructures);
        writeTestDelete(dtoObjectName, messageStructures);
        decrementIndent();

        // end method
        closeBrace();
        indentPrintln("");

        // methods that will be overwritten
        writetestCrudXXX_setDTOFieldsForTestCreate(dtoObjectName, messageStructures);
        writetestCrudXXX_testDTOFieldsForTestCreateUpdate(dtoObjectName, messageStructures);
        writetestCrudXXX_setDTOFieldsForTestUpdate(dtoObjectName, messageStructures);
        writetestCrudXXX_testDTOFieldsForTestReadAfterUpdate(dtoObjectName, messageStructures);
        writetestCrudXXX_setDTOFieldsForTestReadAfterUpdate(dtoObjectName, messageStructures);
    }

    /**
     * Write the 'test create' portion.
     */
    public void writeTestCreate (String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintDecoratedComment("test create");
        indentPrintln(dtoObjectName + "Info expected = new " + dtoObjectName + "Info ();");
        // indentPrintln("expected.setName(\"Name01\");");
        indentPrintln("expected.setDescr(new RichTextHelper().fromPlain(\"Description01\"));");
        indentPrintln("");
        indentPrintln("// METHOD TO SET DTO FIELDS HERE FOR TEST CREATE");
        indentPrintln("testCrud" + dtoObjectName + "_setDTOFieldsForTestCreate (expected);");
        indentPrintln("");

        indentPrintln("if (expected instanceof TypeStateEntityInfo)");
        openBrace();
        incrementIndent();
        indentPrintln("expectedTS = (TypeStateEntityInfo) expected;");
        indentPrintln("expectedTS.setTypeKey(\"typeKey01\");");
        indentPrintln("expectedTS.setStateKey(\"stateKey01\");");
        decrementIndent();
        closeBrace();

        indentPrintln("new AttributeTester().add2ForCreate(expected.getAttributes());");

        indentPrintln("");
        indentPrintln("// code to create actual");
        indentPrintln(dtoObjectName + "Info actual = " + getMethodCallAsString ("create" + dtoObjectName, "// INSERT CODE TO CREATE actual HERE", MethodType.CREATE, dtoObjectName, "expected"));
        indentPrintln("");

        indentPrintln("if (actual instanceof IdEntityInfo)");
        openBrace();
        incrementIndent();
        indentPrintln("assertNotNull(actual.getId());");
        indentPrintln("new IdEntityTester().check(expected, actual);");
        decrementIndent();
        closeBrace();

        indentPrintln("");
        indentPrintln("// METHOD TO TEST DTO FIELDS HERE FOR TEST CREATE");
        indentPrintln("testCrud" + dtoObjectName + "_testDTOFieldsForTestCreateUpdate (expected, actual);");
        indentPrintln("");

        indentPrintln("new AttributeTester().check(expected.getAttributes(), actual.getAttributes());");
        indentPrintln("new MetaTester().checkAfterCreate(actual.getMeta());");
        indentPrintln("");

        indentPrintDecoratedComment("test read");
        indentPrintln("expected = actual;");
        indentPrintln("actual = " + getMethodCallAsString ("get" + dtoObjectName, "// INSERT CODE TO GET actual HERE BY CALLING SERVICE OP", MethodType.GET_BY_ID, dtoObjectName, "actual"));
        indentPrintln("assertEquals(expected.getId(), actual.getId());");
        indentPrintln("new IdEntityTester().check(expected, actual);");
        indentPrintln("");

        indentPrintln("// INSERT CODE FOR TESTING MORE DTO FIELDS HERE");
        indentPrintln("testCrud" + dtoObjectName + "_testDTOFieldsForTestCreateUpdate (expected, actual);");
        indentPrintln("");

        indentPrintln("new AttributeTester().check(expected.getAttributes(), actual.getAttributes());");
        indentPrintln("new MetaTester().checkAfterGet(expected.getMeta(), actual.getMeta());");
        indentPrintln("");
    }

    /**
     * Write the 'test update' portion.
     */
    public void writeTestUpdate (String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintDecoratedComment("test update");
        indentPrintln("expected = actual;");
        // indentPrintln("expected.setName(expected.getName() + \" updated\");");
        indentPrintln("expected.setDescr(new RichTextHelper().fromPlain(expected.getDescr().getPlain() + \"_Updated\"));");
        indentPrintln("");
        indentPrintln("if (expected implements TypeStateEntityInfo)");
        openBrace();
        incrementIndent();
        indentPrintln("expectedTS = (TypeStateEntityInfo) expected;");
        indentPrintln("expectedTS.setStateKey(expected.getState() + \"_Updated\");");
        decrementIndent();
        closeBrace();
        indentPrintln("");
        indentPrintln("// METHOD TO INSERT CODE TO UPDATE DTO FIELDS HERE");
        indentPrintln("testCrud" + dtoObjectName + "_setDTOFieldsForTestUpdate (expected);");
        indentPrintln("");
        indentPrintln("new AttributeTester().delete1Update1Add1ForUpdate(expected.getAttributes());");

        indentPrintln("// code to update");
        indentPrintln("actual = " + getMethodCallAsString ("update" + dtoObjectName, "// INSERT CODE TO CALL UPDATE SERVICE OP HERE", MethodType.UPDATE, dtoObjectName, "expected"));
        indentPrintln("");

        indentPrintln("assertEquals(expected.getId(), actual.getId());");
        indentPrintln("new IdEntityTester().check(expected, actual);");
        indentPrintln("");
        indentPrintln("// METHOD TO INSERT CODE FOR TESTING DTO FIELDS HERE");
        indentPrintln("testCrud" + dtoObjectName + "_testDTOFieldsForTestCreateUpdate (expected, actual);");
        indentPrintln("");
        indentPrintln("new AttributeTester().check(expected.getAttributes(), actual.getAttributes());");
        indentPrintln("new MetaTester().checkAfterUpdate(expected.getMeta(), actual.getMeta());");
        indentPrintln("");
    }

    /**
     * Write the 'read after update' portion.
     */
    public void writeTestReadAfterUpdate (String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintDecoratedComment("test read after update");
        indentPrintln("");
        indentPrintln("expected = actual;");

        indentPrintln("// code to get actual");
        indentPrintln("actual = " + getMethodCallAsString ("get" + dtoObjectName, "// INSERT CODE TO GET actual HERE BY CALLING SERVICE OP", MethodType.GET_BY_ID, dtoObjectName, "actual"));
        indentPrintln("");

        indentPrintln("assertEquals(expected.getId(), actual.getId());");
        indentPrintln("new IdEntityTester().check(expected, actual);");
        indentPrintln("");
        indentPrintln("// INSERT METHOD CODE FOR TESTING DTO FIELDS HERE");
        indentPrintln("testCrud" + dtoObjectName + "_testDTOFieldsForTestReadAfterUpdate (expected, actual);");
        indentPrintln("");
        indentPrintln("new AttributeTester().check(expected.getAttributes(), actual.getAttributes());");
        indentPrintln("new MetaTester().checkAfterGet(expected.getMeta(), actual.getMeta());");
        indentPrintln("");
        indentPrintln(dtoObjectName + "Info alphaDTO = actual;");
        indentPrintln("");
        indentPrintln("// create a 2nd DTO");
        indentPrintln(dtoObjectName + "Info betaDTO = new " + dtoObjectName + "Info ();");
        // indentPrintln("betaDTO.setName(\"Beta entity name\");");
        indentPrintln("betaDTO.setDescr(new RichTextHelper().fromPlain(\"Beta entity description\"));");
        indentPrintln("");
        indentPrintln("// METHOD TO INSERT CODE TO SET MORE DTO FIELDS HERE");
        indentPrintln("testCrud" + dtoObjectName + "_setDTOFieldsForTestReadAfterUpdate (betaDTO, actual);");
        indentPrintln("");
        indentPrintln("if (betaDTO implements TypeStateEntityInfo)");
        openBrace();
        incrementIndent();
        indentPrintln("betaDTOTS = (TypeStateEntityInfo) betaDTO;");
        indentPrintln("betaDTOTS.setTypeKey(\"typeKeyBeta\");");
        indentPrintln("betaDTOTS.setStateKey(\"stateKeyBeta\");");
        decrementIndent();
        closeBrace();
        indentPrintln("betaDTO = " + getMethodCallAsString("create" + dtoObjectName, "// INSERT CODE TO CREATE betaDTO", MethodType.CREATE, dtoObjectName, "betaDTO"));

        indentPrintln("");
        indentPrintDecoratedComment("test bulk get with no ids supplied");
        indentPrintln("");
        indentPrintln("List<String> " + initLower(dtoObjectName) + "Ids = new ArrayList<String>();");

        indentPrintln("// code to get DTO by Ids");
        indentPrintln("List<" + dtoObjectName + "> records = " + getMethodCallAsString ("get" + dtoObjectName + "sByIds", "// INSERT CODE TO GET DTO BY IDS", MethodType.GET_BY_IDS));
        indentPrintln("");

        indentPrintln("assertEquals(" + initLower(dtoObjectName) + "Ids.size(), records.size());");
        indentPrintln("assertEquals(0, " + initLower(dtoObjectName) + "Ids.size());");
        indentPrintln("");
        indentPrintDecoratedComment("test bulk get");
        indentPrintln(initLower(dtoObjectName) + "Ids = new ArrayList<String>();");
        indentPrintln(initLower(dtoObjectName) + "Ids.add(alphaDTO.getId());");
        indentPrintln(initLower(dtoObjectName) + "Ids.add(betaDTO.getId());");

        indentPrintln("// code to get DTO by Ids");
        indentPrintln("records = " + getMethodCallAsString ("get" + dtoObjectName + "sByIds", "// INSERT CODE TO GET DTO BY IDS", MethodType.GET_BY_IDS));
        indentPrintln("");

        indentPrintln("assertEquals(" + initLower(dtoObjectName) + "Ids.size(), records.size());");
        indentPrintln("for (" + dtoObjectName + " record : records)");
        openBrace();
        incrementIndent();
        indentPrintln("if (!" + initLower(dtoObjectName) + "Ids.remove(record.getId()))");
        openBrace();
        incrementIndent();
        indentPrintln("fail(record.getId());");
        decrementIndent();
        closeBrace();
        decrementIndent();
        closeBrace();
        indentPrintln("assertEquals(0, " + initLower(dtoObjectName) + "Ids.size());");
        indentPrintln("");
        indentPrintDecoratedComment("test get by type");

        indentPrintln("// code to get by specific type \"typeKey01\" ");
        indentPrintln(initLower(dtoObjectName) + "Ids = get" + dtoObjectName + "IdsByType (\"typeKey01\", contextInfo);");
        // indentPrintln(initLower(dtoObjectName) + "Ids = " + getMethodCallAsString ("get" + dtoObjectName + "IdsByType", "// INSERT CODE TO GET BY SPECIFIC TYPE \"typeKey01\" HERE", MethodType.GET_IDS_BY_TYPE));
        indentPrintln("");

        indentPrintln("assertEquals(1, " + initLower(dtoObjectName) + "Ids.size());");
        indentPrintln("assertEquals(alphaDTO.getId(), " + initLower(dtoObjectName) + "Ids.get(0));");
        indentPrintln("");
        indentPrintln("// test get by other type");

        indentPrintln("// code to get by specific type \"typeKeyBeta\" ");
        indentPrintln(initLower(dtoObjectName) + "Ids = get" + dtoObjectName + "IdsByType (\"typeKeyBeta\", contextInfo);");
        // indentPrintln(initLower(dtoObjectName) + "Ids = " + getMethodCallAsString ("get" + dtoObjectName + "IdsByType", "// INSERT CODE TO GET BY SPECIFIC TYPE \"typeKeyBeta\" HERE", MethodType.GET_IDS_BY_TYPE));
        indentPrintln("");

        indentPrintln("assertEquals(1, " + initLower(dtoObjectName) + "Ids.size());");
        indentPrintln("assertEquals(betaDTO.getId(), " + initLower(dtoObjectName) + "Ids.get(0));");
        indentPrintln("");
    }

    /**
     * Write the 'delete' portion.
     */
    public void writeTestDelete (String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintDecoratedComment("test delete");
        indentPrintln("");

        indentPrintln("StatusInfo status = " + getMethodCallAsString ("delete" + dtoObjectName, "// INSERT CODE TO DELETE RECORD", MethodType.DELETE, dtoObjectName, "actual"));
        indentPrintln("");

        indentPrintln("assertNotNull(status);");
        indentPrintln("assertTrue(status.getIsSuccess());");
        indentPrintln("try");
        openBrace();
        incrementIndent();
        indentPrintln("record = " + getMethodCallAsString ("get" + dtoObjectName, "// INSERT CODE TO RETRIEVE RECENTLY DELETED RECORD", MethodType.GET_BY_ID, dtoObjectName, "actual"));
        indentPrintln("fail(\"Did not receive DoesNotExistException when attempting to get already-deleted entity\");");
        decrementIndent();
        closeBrace();
        indentPrintln("catch (DoesNotExistException dnee)");
        openBrace();
        incrementIndent();
        indentPrintln("// expected");
        decrementIndent();
        closeBrace();
        indentPrintln("");
    }

    /**
     * Writes out a decorated comment.
     */
    public void indentPrintDecoratedComment (String label) {
        indentPrintln("// -------------------------------------");
        indentPrintln("// " + label);
        indentPrintln("// -------------------------------------");
    }

    /**
     * Gets the method with the name.
     */
    private ServiceMethod getServiceMethod (String methodName) throws OperationsException {
        for (ServiceMethod method : methods) {
            if (method.getName().equals(methodName)) return method;
        }
        throw new OperationsException("Method " + methodName + " not found!");
    }

    /**
     * Gets the string to print to call a method with the given name.
     */
    private String getMethodCallAsString (String builtUpMethodName, String errorCode, MethodType methodType) {
        return getMethodCallAsString (builtUpMethodName, errorCode, methodType, null, null);
    }

    /**
     * Gets the string to print to call a method with the given name.
     */
    private String getMethodCallAsString (String builtUpMethodName, String errorCode, MethodType methodType, String dtoName, String dtoNameReplacement) {
        try {
            ServiceMethod method = getServiceMethod(builtUpMethodName);
            String methodCallStr = "";
            methodCallStr += method.getName() + " (";
            String comma = " ";
            for (ServiceMethodParameter param : method.getParameters()) {
                methodCallStr += comma;
                if (dtoName!=null && dtoNameReplacement!=null) {
                    if ((dtoName + "Info").toLowerCase().equals(param.getName().toLowerCase())) {
                        methodCallStr += dtoNameReplacement;
                    }
                    else if (param.getName().endsWith("TypeKey")) {
                        methodCallStr += dtoNameReplacement + ".getTypeKey()";
                    }
                    else if (param.getName().endsWith("Id")) {
                        methodCallStr += dtoNameReplacement + ".getId()";
                    }
                    else {
                        methodCallStr += param.getName();
                    }
                } else {
                    methodCallStr += param.getName();
                }
                comma = ", ";
            }
            methodCallStr += ");";
            return methodCallStr;
        } catch (Exception e) {
            System.out.println("methodName = " + builtUpMethodName + ", errorCode = " + errorCode);
            return errorCode;
        }

    }

    /**
     * Writes the section to set fields specific to this dto for testCreate section.
     */
    public void writetestCrudXXX_setDTOFieldsForTestCreate(String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintln("public void testCrud" + dtoObjectName + "_setDTOFieldsForTestCreate(" + dtoObjectName + "Info expected) ");
        openBrace();
        for (MessageStructure ms: messageStructures) {
            if (ms.getShortName().equals("id")) continue;
            if (ms.getShortName().equals("meta")) continue;
            if (ms.getShortName().equals("descr")) continue;
            if (ms.getShortName().equals("attributes")) continue;
            if (ms.getType().equals("String")) {
                indentPrintln("expected." + new GetterSetterNameCalculator (ms, this, model).calcSetter() + "(\"" + ms.getShortName()+ "01\")");
            } else {
                indentPrintln("//TODO *TYPE = " + ms.getType() + "* expected." + new GetterSetterNameCalculator (ms, this, model).calcSetter() + "(\"" + ms.getShortName()+ "01\")");
            }
        }
        closeBrace();
        indentPrintln("");
    }

    /**
     * Writes the section to test fields specific to this dto for testCreate and testUpdate sections.
     */
    public void writetestCrudXXX_testDTOFieldsForTestCreateUpdate(String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintln("public void testCrud" + dtoObjectName + "_testDTOFieldsForTestCreateUpdate(" + dtoObjectName + "Info expected, " + dtoObjectName + "Info actual) ");
        openBrace();
        for (MessageStructure ms: messageStructures) {
            if (ms.getShortName().equals("id")) continue;
            if (ms.getShortName().equals("meta")) continue;
            //if (ms.getShortName().equals("descr")) continue;
            if (ms.getShortName().equals("attributes")) continue;
            if (ms.getType().equals("String")) {
                indentPrintln("assertEquals (expected." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "(), actual." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "());");
            } else {
                indentPrintln("//TODO *TYPE = " + ms.getType() + "* assertEquals (expected." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "(), actual." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "());");
            }
        }
        closeBrace();
        indentPrintln("");
    }


    /**
     * Writes the section to set fields specific to this dto for testUpdate sections.
     */
    public void writetestCrudXXX_setDTOFieldsForTestUpdate(String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintln("public void testCrud" + dtoObjectName + "_setDTOFieldsForTestUpdate(" + dtoObjectName + "Info expected) ");
        openBrace();
        for (MessageStructure ms: messageStructures) {
            if (ms.getShortName().equals("id")) continue;
            if (ms.getShortName().equals("meta")) continue;
            if (ms.getShortName().equals("descr")) continue;
            if (ms.getShortName().equals("attributes")) continue;
            if (ms.getType().equals("String")) {
                indentPrintln("expected." + new GetterSetterNameCalculator (ms, this, model).calcSetter() + "(\"" + ms.getShortName()+ "_Updated\")");
            } else {
                indentPrintln("//TODO *TYPE = " + ms.getType() + "* expected." + new GetterSetterNameCalculator (ms, this, model).calcSetter() + "(\"" + ms.getShortName()+ "_Updated\")");
            }
        }
        closeBrace();
        indentPrintln("");
    }

    /**
     * Writes the section to test fields specific to this dto for testReadAfterUpdate sections.
     */
    public void writetestCrudXXX_testDTOFieldsForTestReadAfterUpdate(String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintln("public void testCrud" + dtoObjectName + "_testDTOFieldsForTestReadAfterUpdate(" + dtoObjectName + "Info expected, " + dtoObjectName + "Info actual) ");
        openBrace();
        for (MessageStructure ms: messageStructures) {
            if (ms.getShortName().equals("meta")) continue;
            // if (ms.getShortName().equals("descr")) continue;
            if (ms.getShortName().equals("attributes")) continue;
            if (ms.getType().equals("String")) {
                indentPrintln("assertEquals (expected." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "(), actual." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "());");
            } else {
                indentPrintln("//TODO *TYPE = " + ms.getType() + "* assertEquals (expected." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "(), actual." + new GetterSetterNameCalculator (ms, this, model).calcGetter() + "());");
            }
        }
        closeBrace();
        indentPrintln("");
    }

    /**
     * Writes the section to set fields specific to this dto for testReadAfterUpdate sections.
     */
    public void writetestCrudXXX_setDTOFieldsForTestReadAfterUpdate(String dtoObjectName, List<MessageStructure> messageStructures) {
        indentPrintln("public void testCrud" + dtoObjectName + "_setDTOFieldsForTestReadAfterUpdate(" + dtoObjectName + "Info expected) ");
        openBrace();
        for (MessageStructure ms: messageStructures) {
            if (ms.getShortName().equals("id")) continue;
            if (ms.getShortName().equals("typeKey")) continue;
            if (ms.getShortName().equals("stateKey")) continue;
            if (ms.getShortName().equals("meta")) continue;
            if (ms.getShortName().equals("descr")) continue;
            if (ms.getShortName().equals("attributes")) continue;
            if (ms.getType().equals("String")) {
                indentPrintln("expected." + new GetterSetterNameCalculator (ms, this, model).calcSetter() + "(\"" + ms.getShortName()+ "_Updated\")");
            } else {
                indentPrintln("//TODO *TYPE = " + ms.getType() + "* expected." + new GetterSetterNameCalculator (ms, this, model).calcSetter() + "(\"" + ms.getShortName()+ "_Updated\")");
            }
        }
        closeBrace();
        indentPrintln("");
    }

}
