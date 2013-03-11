/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kuali.student.contract.model.impl;

import org.kuali.student.contract.model.MessageStructure;
import org.kuali.student.contract.model.Service;
import org.kuali.student.contract.model.ServiceContractModel;
import org.kuali.student.contract.model.ServiceMethod;
import org.kuali.student.contract.model.ServiceMethodParameter;
import org.kuali.student.contract.model.XmlType;
import org.kuali.student.contract.model.util.MessageStructureDumper;
import org.kuali.student.contract.model.validation.ServiceContractModelValidator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nwright
 */
public class ServiceContractModelPescXsdLoaderTest {

    public ServiceContractModelPescXsdLoaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    private static final String RESOURCES_DIRECTORY =
            //                             "C:/svn/student/ks-core/ks-core-api/src/main/java";
            "src/main/resources";
    private static final String PESC_DIRECTORY =
            RESOURCES_DIRECTORY + "/pesc";
    private static final String PESC_CORE_MAIN = PESC_DIRECTORY + "/CoreMain.xsd";
    private static final String PESC_ACAD_REC = PESC_DIRECTORY + "/AcademicRecord_v1.5.0.xsd";
    private static final String PESC_COLL_TRANS = PESC_DIRECTORY + "/CollegeTranscript_v1.2.0.xsd";

    private ServiceContractModel getModel() {
        List<String> xsdFileNames = new ArrayList();
//        xsdFileNames.add(PESC_CORE_MAIN);
//        xsdFileNames.add(PESC_ACAD_REC);
        xsdFileNames.add(PESC_COLL_TRANS);
        ServiceContractModel instance = new ServiceContractModelPescXsdLoader(xsdFileNames);
        instance = new ServiceContractModelCache(instance);
        validate(instance);
        return instance;
    }

    private String dump(ServiceMethod method) {
        StringBuilder bldr = new StringBuilder();
        bldr.append(method.getName());
        String comma = "";
        bldr.append("(");
        for (ServiceMethodParameter param : method.getParameters()) {
            bldr.append(comma);
            comma = ", ";
            bldr.append(param.getType());
            bldr.append(" ");
            bldr.append(param.getName());
        }
        bldr.append(")");
        return bldr.toString();
    }

    private void validate(ServiceContractModel model) {
        Collection<String> errors =
                new ServiceContractModelValidator(model).validate();
        if (errors.size() > 0) {
            StringBuilder buf = new StringBuilder();
            buf.append(errors.size()).append(" errors found while validating the data.");
            int cnt = 0;
            for (String msg : errors) {
                cnt++;
                buf.append("\n");
                buf.append("*error*").append(cnt).append(":").append(msg);
            }

            fail(buf.toString());
        }
    }

    /**
     * Test of getServiceMethods method, of class ServiceContractModelQDoxLoader.
     */
    @Test
    public void testGetServiceMethods() {
        System.out.println("getServiceMethods");
        ServiceContractModel model = getModel();
        List<ServiceMethod> result = model.getServiceMethods();
        System.out.println("Number of methods=" + result.size());
        for (ServiceMethod method : result) {
            System.out.println(dump(method));
        }
        if (result.size() < 1) {
            fail("too few: " + result.size());
        }
    }

    /**
     * Test of getSourceNames method, of class ServiceContractModelQDoxLoader.
     */
    @Test
    public void testGetSourceNames() {
        System.out.println("getSourceNames");
        ServiceContractModel model = getModel();
        List<String> expResult = new ArrayList();
        expResult.add(PESC_COLL_TRANS);
        List result = model.getSourceNames();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServices method, of class ServiceContractModelQDoxLoader.
     */
    @Test
    public void testGetServices() {
        System.out.println("getServices");
        ServiceContractModel model = getModel();
        List<Service> result = model.getServices();
        assertEquals(1, result.size());
        for (Service service : result) {
            System.out.println(service.getKey() + " " + service.getName() + " "
                    + service.getVersion() + " " + service.getStatus()
                    + " " + service.getComments()
                    + " " + service.getUrl());
        }
    }

    /**
     * Test of getXmlTypes method, of class ServiceContractModelQDoxLoader.
     */
    @Test
    public void testGetXmlTypes() {
        System.out.println("getXmlTypes");
        ServiceContractModel model = getModel();
        List<XmlType> result = model.getXmlTypes();
        if (result.size() < 10) {
            fail("too few: " + result.size());
        }
    }

    /**
     * Test of getMessageStructures method, of class ServiceContractModelQDoxLoader.
     */
    @Test
    public void testGetMessageStructures() {
        System.out.println("getMessageStructures");
        ServiceContractModel model = getModel();
        List<MessageStructure> result = model.getMessageStructures();
        if (result.size() < 10) {
            fail("too few: " + result.size());
        }
        for (MessageStructure ms : result) {
            new MessageStructureDumper(ms, System.out).dump();
        }
    }
}
