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

    private static final String DEFAULT_REQUEST_2012 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<needAnalysisInput CreatedDate=\"2012-10-23\" AwardYear=\"2012\" xmlns=\"http://INAS.collegeboard.org/2012/Input/\">\n" +
            "</needAnalysisInput>\n";

    private static final String DEFAULT_REQUEST_2013 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<needAnalysisInput CreatedDate=\"2013-05-23\" AwardYear=\"2013\" xmlns=\"http://INAS.collegeboard.org/2013/Input/\">\n" +
            "</needAnalysisInput>\n";

    @Autowired
    private BsinasService bsinasService;


    @Test
    public void runEngine() throws Exception {

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

    @Test
    public void runDispatchEngine() throws Exception {

        String response = bsinasService.runEngine(DEFAULT_REQUEST_2012);

        logger.info("Engine response:\n" + response);

    }


}
