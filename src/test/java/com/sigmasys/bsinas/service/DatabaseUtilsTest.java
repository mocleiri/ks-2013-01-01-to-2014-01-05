package com.sigmasys.bsinas.service;


import com.sigmasys.bsinas.model.Constants;
import com.sigmasys.bsinas.util.DatabaseUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_CONTEXT})
public class DatabaseUtilsTest extends AbstractServiceTest {

    @PersistenceContext(unitName = Constants.PROSAM_PERSISTENCE_UNIT)
    protected EntityManager em;

    @Test
    public void createSchemaTest() throws Exception {

        String sql = DatabaseUtils.generateCreateTablesSql(em, "com.sigmasys.bsinas.model");

        Assert.notNull(sql);
        Assert.isTrue(sql.length() > 1);

        logger.info("Generated CreateSchema DDL:\n" + sql);

    }

    @Test
    public void dropSchemaTest() throws Exception {

        String sql = DatabaseUtils.generateDropTablesSql(em, "com.sigmasys.bsinas.model");

        Assert.notNull(sql);
        Assert.isTrue(sql.length() > 1);

        logger.info("Generated DropSchema DDL:\n" + sql);

    }

}
