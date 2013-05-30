package com.sigmasys.bsinas.service;


import com.sigmasys.bsinas.config.ConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_CONTEXT})
@Transactional
public class ConfigServiceTest extends AbstractServiceTest {

    @Autowired
    private ConfigService configService;


    @Test
    public void getInitialParameters() throws Exception {

        Map<String, String> params = configService.getInitialParameters();

        Assert.notNull(params);
        Assert.notEmpty(params);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            Assert.notNull(name);
            Assert.notNull(value);
            logger.info("Initial parameter: name = " + name + ", value = " + value);
        }

    }

}
