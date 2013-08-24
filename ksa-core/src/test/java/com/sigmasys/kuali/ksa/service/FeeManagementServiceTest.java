package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.model.fm.FeeManagementSessionStatus;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sigmasys.kuali.ksa.model.fm.FeeManagementSession;
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
	
	@Autowired
	private PersistenceService persistenceService;
	
	
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
	
	@Test
	public void testChargeSessionNoSessionIdFound() throws Exception {
		// Call the method with a fake FM Session ID:
		boolean exceptionCaught = false;

		try {
			fmService.chargeSession(0L);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Cannot find an FM session with the ID 0", e.getMessage());
            exceptionCaught = true;
		} catch (Throwable t) {
			// We should never catch any other type of a Throwable:
			Assert.assertTrue("Must never catch anything by IllegalArgumentException", false);
		}
		
		// Assert Exception was caught
		Assert.assertTrue("Never caught an IllegalArgumentException", exceptionCaught);
	}
	
	@Test
	public void testChargeSessionNullStatus() throws Exception {
		// Create an FM session:
		FeeManagementSession fmSession = new FeeManagementSession();
		
		persistenceService.persistEntity(fmSession);
		
		// Call the method:
		boolean exceptionCaught = false;
		
		try {
			fmService.chargeSession(fmSession.getId());
		} catch (IllegalStateException ise) {
			// We should catch this exception here
			exceptionCaught = true;
		} catch (Throwable e) {
			// We should never catch any other type of a Throwable:
			Assert.assertTrue("Must never catch anything by IllegalStateException", false);
		}
		
		// Assert Exception was caught
		Assert.assertTrue("Never caught an IllegalStateException", exceptionCaught);
	}

    @Test
    public void testChargeSessionWrongStatus() throws Exception {
        // Create an FM session:
        FeeManagementSession fmSession = new FeeManagementSession();

        fmSession.setChargeStatus(FeeManagementSessionStatus.CURRENT);
        persistenceService.persistEntity(fmSession);

        // Call the method:
        boolean exceptionCaught = false;

        try {
            fmService.chargeSession(fmSession.getId());
        } catch (IllegalStateException ise) {
            // We should catch this exception here
            exceptionCaught = true;
        } catch (Throwable e) {
            // We should never catch any other type of a Throwable:
            Assert.assertTrue("Must never catch anything by IllegalStateException", false);
        }

        // Assert Exception was caught
        Assert.assertTrue("Never caught an IllegalStateException", exceptionCaught);
    }

    @Test
    public void testChargeSessionNoManifestsFound() throws Exception {
        // Create an FM session:
        FeeManagementSession fmSession = new FeeManagementSession();

        fmSession.setChargeStatus(FeeManagementSessionStatus.RECONCILED);
        persistenceService.persistEntity(fmSession);

        // Call the method:
        fmService.chargeSession(fmSession.getId());

        // Verify session's status changed to CHARGED:
        Assert.assertEquals("FM Session status has never changed to CHARGED", FeeManagementSessionStatus.CHARGED, fmSession.getStatus());
    }
}
