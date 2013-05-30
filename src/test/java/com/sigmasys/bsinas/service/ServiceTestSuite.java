package com.sigmasys.bsinas.service;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * ServiceTestSuite is a test suite that runs all the declared service tests
 * <p/>
 *
 * @author Michael Ivanov
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        DatabaseUtilsTest.class,
        ConfigServiceTest.class})
public class ServiceTestSuite extends AbstractServiceTest {

    public static final String TEST_CONTEXT = "/META-INF/test-context.xml";

    public static Test suite() {
        return new JUnit4TestAdapter(ServiceTestSuite.class);
    }

}