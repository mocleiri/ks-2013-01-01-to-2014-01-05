package com.sigmasys.bsinas.service;


import org.collegeboard.inas._2012.input.NeedAnalysisInput;
import org.collegeboard.inas._2012.output.NeedAnalysisOutput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_CONTEXT})
@Transactional
public class BsinasEngineTest extends AbstractServiceTest {

    @Autowired
    private BsinasService bsinasService;


    @Test
    public void runEngine1() throws Exception {

        // TODO -> add tests

        /*NeedAnalysisInput input = new NeedAnalysisInput();
        input.setAwardYear(2012);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        input.setCreatedDate(xcal);

        logger.info("Request XML: \n" + bsinasService.toXml(input));

        NeedAnalysisOutput output = bsinasService.runEngine(input);

        Assert.notNull(output);

        logger.info("Response XML: \n" + bsinasService.toXml(output));*/

    }

}
