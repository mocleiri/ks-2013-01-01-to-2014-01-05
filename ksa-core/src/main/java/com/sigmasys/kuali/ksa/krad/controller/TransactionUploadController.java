package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.FileUploadForm;
import com.sigmasys.kuali.ksa.service.TransactionImportService;
import com.sigmasys.kuali.ksa.util.CommonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: dmulderink
 * Date: 4/24/12
 * Time: 11:17 AM
 */
@Controller
@RequestMapping(value = "/transactionUploadView")
@Transactional(timeout = 300, propagation = Propagation.REQUIRES_NEW)
public class TransactionUploadController extends GenericSearchController {


    @Autowired
    private TransactionImportService transactionImportService;


    private static final Log logger = LogFactory.getLog(TransactionUploadController.class);

    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected FileUploadForm createInitialForm(HttpServletRequest request) {
        FileUploadForm form = new FileUploadForm();
        form.setUploadProcessState("");
        return form;
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") FileUploadForm form) {
        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @param result
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submit")
    @Transactional(readOnly = false)
    public ModelAndView submit(@ModelAttribute("KualiForm") FileUploadForm form, BindingResult result,
                               HttpServletRequest request, HttpServletResponse response) {
        // do submit stuff...
        // org.springframework.web.multipart.MaxUploadSizeExceededException:
        // Maximum upload size of 500000 bytes exceeded; nested exception is
        // org.apache.commons.fileupload.FileUploadBase$SizeLimitExceededException:
        // the request was rejected because its size (992410) exceeds the configured maximum (500000)
        String processMsg = "";
        try {
            MultipartFile xmlFile = form.getUploadFile();
            String contentType = xmlFile.getContentType();
            if (contentType.endsWith("xml")) {

                try {

                    String xmlContent = CommonUtils.getStreamAsString(xmlFile.getInputStream());

                    processMsg = "Processing Transaction(s)";
                    form.setUploadProcessState(processMsg);
                    String processResponse = transactionImportService.processTransactions(xmlContent);

                    logger.info("Response: \n" + processResponse);
                    String begValue = "<batch-status>";
                    String endValue = "</batch-status>";
                    int begIndex = processResponse.indexOf(begValue) + begValue.length();
                    int endIndex = processResponse.indexOf(endValue);
                    String batchStatus = processResponse.substring(begIndex, endIndex);
                    processMsg = "Transaction(s) Processing " + batchStatus;
                    form.setUploadProcessState(processMsg);
                } catch (Exception exp) {
                    String expMsg = exp.getMessage();
                    logger.error(expMsg);
                    processMsg = "Transaction(s) Processing Failed";
                    form.setUploadProcessState(processMsg);
                }
            } else {
                processMsg = "Only XML files are allowed. Please try again.";
                form.setUploadProcessState(processMsg);
                logger.error(processMsg);
            }
        } catch (Exception exp) {
            String expMsg = exp.getMessage();
            logger.error(expMsg);
            form.setUploadProcessState(expMsg);
        }

        return getUIFModelAndView(form);
    }

}
