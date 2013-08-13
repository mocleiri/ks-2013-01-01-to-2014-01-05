package com.sigmasys.kuali.ksa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sigmasys.kuali.ksa.service.fm.FeeManagementService;

/**
 * FeeManagementService unit tests.
 * 
 * @author Sergey Godunov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class FeeManagementServiceTest extends AbstractServiceTest {

	@Autowired
	private FeeManagementService fmService;
	
	
	@Test
	public void testReconcileSession() throws Exception {
		// Preposition the data:
		
		// Call the service method:
		
		// Validate the results:
	}
	
	@Test
	public void testChargeSession() throws Exception {
		// Preposition the data:
		
		// Call the service method:
		
		// Validate the results:
	}
}
