package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.jaxb.KsaBatchTransactionResponse;
import com.sigmasys.kuali.ksa.krad.form.FileUploadForm;
import com.sigmasys.kuali.ksa.model.BatchReceiptStatus;
import com.sigmasys.kuali.ksa.model.Transaction;
import com.sigmasys.kuali.ksa.service.TransactionImportService;
import com.sigmasys.kuali.ksa.util.ErrorUtils;
import com.sigmasys.kuali.ksa.util.JaxbUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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


    @Autowired
    private TransactionImportService transactionImportService;


    /**
     * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected FileUploadForm createInitialForm(HttpServletRequest request) {
        FileUploadForm form = new FileUploadForm();
        form.setMessage("");
        form.setUploadProcessState("");
        return form;
    }


    @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
    public ModelAndView get(@ModelAttribute("KualiForm") FileUploadForm form) {
        return getUIFModelAndView(form);
    }


    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submit")
    @Transactional(readOnly = false)
    public ModelAndView submit(@ModelAttribute("KualiForm") FileUploadForm form) {

        // do submit stuff...
        // org.springframework.web.multipart.MaxUploadSizeExceededException:
        // Maximum upload size of 500000 bytes exceeded; nested exception is
        // org.apache.commons.fileupload.FileUploadBase$SizeLimitExceededException:
        // the request was rejected because its size (992410) exceeds the configured maximum (500000)

        try {

            MultipartFile xmlFile = form.getUploadFile();
            String contentType = xmlFile.getContentType();

            if (StringUtils.isBlank(contentType)) {
                return handleError(form, "Please select an XML file to upload");
            }

            if (contentType.endsWith("xml")) {

                String xmlContent = new String(xmlFile.getBytes(), "UTF-8");

                int index = xmlContent.indexOf("<");
                if (index > 0) {
                    xmlContent = xmlContent.substring(index + 1);
                } else if (index < 0) {
                    return handleError(form, "XML declaration is invalid");
                }

                String processResponse = transactionImportService.processTransactions(xmlContent);

                KsaBatchTransactionResponse responseObject =
                        JaxbUtils.fromXml(processResponse, KsaBatchTransactionResponse.class);

                logger.info("Response: \n" + processResponse);

                String batchStatus = responseObject.getBatchStatus();

                if (BatchReceiptStatus.FAILED_NAME.equals(batchStatus)) {
                    String errMsg = "";
                    KsaBatchTransactionResponse.Failed failed = responseObject.getFailed();
                    if (failed != null) {
                        List<Object> reasons = failed.getKsaTransactionAndReason();
                        if (CollectionUtils.isNotEmpty(reasons)) {
                            for (Object item : reasons) {
                                if ((item != null) && (item instanceof String)) {
                                    String reason = (String) item;
                                    if (StringUtils.isNotBlank(reason)) {
                                        errMsg += reason.trim() + ". ";
                                    }
                                }
                            }
                        }
                    }
                    return handleError(form, "Transaction(s) Processing Failed. " + errMsg);
                } else {
                    setMessage(form, "Transaction(s) Processing status: " + batchStatus);
                }

            } else {
                return handleError(form, "Only XML files are allowed. Please try again.");
            }

        } catch (Exception e) {
            String errMsg = "Transaction(s) Processing Failed. " + ErrorUtils.getMessage(e);
            logger.error(errMsg, e);
            return handleError(form, errMsg);
        }

        return getUIFModelAndView(form);
    }

    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=ageDebts")
    public ModelAndView ageDebts(@ModelAttribute("KualiForm") FileUploadForm form) {

        try {
            accountService.ageDebt(true);
            setMessage(form, "Debts were successfully aged");
        } catch (Exception e) {
            return handleError(form, e);
        }

        return getUIFModelAndView(form);
    }


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
            return handleError(form, e);
        }

        return getUIFModelAndView(form);
    }
}
