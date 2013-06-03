package com.sigmasys.bsinas.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_CONTEXT})
public class BsinasClientTest extends AbstractServiceTest {


    private static final String DEFAULT_REQUEST_2013 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<needAnalysisInput CreatedDate=\"2013-05-23\" AwardYear=\"2013\" xmlns=\"http://INAS.collegeboard.org/2013/Input/\">\n" +
            "</needAnalysisInput>\n";


    @Test
    public void runEngine() throws Exception {

        URL url = new URL("http://localhost:8080/bsinas/needanalysis.service");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("content-type", "text/xml; charset=\"utf-8\"");
        connection.setDoOutput(true);
        connection.setUseCaches(false);

        PrintWriter writer = new PrintWriter(connection.getOutputStream());
        writer.print(DEFAULT_REQUEST_2013);
        writer.flush();
        writer.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }

        reader.close();

        logger.info("Output:\n" + builder.toString());

    }

}
