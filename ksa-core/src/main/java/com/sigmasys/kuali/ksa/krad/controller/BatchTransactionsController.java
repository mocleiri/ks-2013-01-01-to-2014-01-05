package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.FileUploadForm;
import com.sigmasys.kuali.ksa.model.Transaction;
import com.sigmasys.kuali.ksa.service.TransactionImportService;
import com.sigmasys.kuali.ksa.util.CommonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by: dmulderink on 9/26/12 at 9:11 AM
 */
@Controller
@RequestMapping(value = "/batchTransactionsView")
@Transactional(timeout = 300, propagation = Propagation.REQUIRES_NEW)
public class BatchTransactionsController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(BatchTransactionsController.class);


    @Autowired
    private TransactionImportService transactionImportService;


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
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submit")
    public ModelAndView submit(@ModelAttribute("KualiForm") FileUploadForm form) {

        // org.springframework.web.multipart.MaxUploadSizeExceededException:
        // Maximum upload size of 500000 bytes exceeded; nested exception is
        // org.apache.commons.fileupload.FileUploadBase$SizeLimitExceededException:
        // the request was rejected because its size (992410) exceeds the configured maximum (500000)
        String processMsg = "";
        try {
            MultipartFile uploadFile = form.getUploadFile();
            String contentType = uploadFile.getContentType();
            if (contentType.endsWith("xml")) {

                try {

                    String xmlContent = CommonUtils.getStreamAsString(uploadFile.getInputStream());

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

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=save")
    public ModelAndView save(@ModelAttribute("KualiForm") FileUploadForm form) {
        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=ageAccounts")
    public ModelAndView ageAccounts(@ModelAttribute("KualiForm") FileUploadForm form) {

        try {
            accountService.ageDebt(true);
            form.setUploadProcessState("Debts successfully aged.");
        } catch (Exception e) {
            form.setUploadProcessState(e.getLocalizedMessage());
        }

        return getUIFModelAndView(form);
    }

    /**
     * @param form
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=makeEffective")
    public ModelAndView makeEffective(@ModelAttribute("KualiForm") FileUploadForm form) {

        try {

            List<Transaction> transactions = transactionService.getTransactions();

            Date today = new Date();
            for (Transaction t : transactions) {
                if (!t.isGlEntryGenerated() && t.getEffectiveDate().before(today)) {
                    logger.info("Calling 'makeEffective' for ID: " + t.getId());
                    transactionService.makeEffective(t.getId(), false);
                }
            }

        } catch (Exception e) {
            form.setUploadProcessState(e.getLocalizedMessage());
        }

        return getUIFModelAndView(form);
    }
}
