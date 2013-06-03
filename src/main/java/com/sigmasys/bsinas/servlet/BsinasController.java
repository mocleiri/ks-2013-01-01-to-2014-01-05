package com.sigmasys.bsinas.servlet;

import com.sigmasys.bsinas.service.BsinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * This controller is responsible to taking the incoming XML,
 * calling the BSINAS engine and sending the XML response back to the client.
 *
 * @author Michael Ivanov
 */
@Controller
@RequestMapping("needanalysis.service")
public class BsinasController {

    @Autowired
    private BsinasService bsinasService;

    @RequestMapping(method = RequestMethod.POST, headers = "content-type=text/xml,application/xml")
    public void runEnginePost(@RequestBody String inputXml, HttpServletResponse response) throws Exception {
        String outputXml = bsinasService.runEngine(inputXml);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        PrintWriter writer = response.getWriter();
        writer.print(outputXml);
        writer.flush();
        writer.close();
    }

}
