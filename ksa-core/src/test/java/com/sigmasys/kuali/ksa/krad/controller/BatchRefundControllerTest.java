package com.sigmasys.kuali.ksa.krad.controller;


import com.sigmasys.kuali.ksa.krad.form.BatchRefundForm;
import com.sigmasys.kuali.ksa.krad.model.PotentialRefundModel;
import com.sigmasys.kuali.ksa.model.Credit;
import com.sigmasys.kuali.ksa.model.Currency;
import com.sigmasys.kuali.ksa.model.Rollup;
import com.sigmasys.kuali.ksa.service.AbstractServiceTest;
import com.sigmasys.kuali.ksa.service.ServiceTestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
@Transactional
public class BatchRefundControllerTest extends AbstractServiceTest {


    @Autowired
    private BatchRefundController batchRefundController;

    @Before
    public void setUpWithinTransaction() {

    }

    @Test
    public void getCurrencyList() throws Exception {
        // All potential refunds should be Credit transactions

        // Passing request parameters needed to perform get() method
        MockHttpServletRequest request = getRequest();

        BatchRefundForm form = batchRefundController.createInitialForm(request);

        form.setNewAccount("user1");
        ModelAndView modelAndView = batchRefundController.filterAccounts(form);

        List<PotentialRefundModel> potentialModels = form.getPotentialRefundModels();

        // Checking assertions
        Assert.notNull(modelAndView);
        Assert.notNull(form);

        Assert.notNull(potentialModels);
        Assert.isTrue(potentialModels.size() > 0);
        for(PotentialRefundModel model : potentialModels) {
            Assert.isTrue(model.getParentTransaction() instanceof Credit);
        }
    }


}
