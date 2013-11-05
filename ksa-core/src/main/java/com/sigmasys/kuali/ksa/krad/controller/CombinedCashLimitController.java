package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.CashLimitForm;
import com.sigmasys.kuali.ksa.krad.form.TransactionFilterForm;
import com.sigmasys.kuali.ksa.krad.util.DateRangeFilterKeyValuesFinder;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.CashLimitEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This controller serves requests from the "Batch - Combined Cash Limit" page.
 *
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 11/5/13
 * Time: 2:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/batchCashLimitView")
public class CombinedCashLimitController extends TransactionFilterController {


    /**
     * Called by the framework to create the initial form object.
     *
     * @param request HTTP request.
     * @return The initial form object.
     */
    @Override
    protected CashLimitForm createInitialForm(HttpServletRequest request) {

        // Create a new form:
        CashLimitForm form = new CashLimitForm();

        initializeForm(form);

        // Set defaults:
        form.setCashLimitEvents(new ArrayList<CashLimitEvent>());

        return form;
    }

    /**
     * Invoked to download a Complete CashLimitEvent XML.
     * Returns null to stay on the same page after download starts.
     *
     * @param form              Form object.
     * @return null to stay on the same page after download starts.
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=downloadGeneratedArchiveXml")
    public ModelAndView downloadGeneratedArchiveXml(@ModelAttribute("KualiForm") TransactionFilterForm form) throws Exception {

        return null;
    }

    /**
     * Invoked to download a Complete CashLimitEvent XML.
     * Returns null to stay on the same page after download starts.
     *
     * @param form              Form object.
     * @param cashLimitEventId  ID of a Cash Limit Event.
     * @return null to stay on the same page after download starts.
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, params = "methodToCall=downloadCashEventXml")
    public ModelAndView downloadCashEventXml(@ModelAttribute("KualiForm") TransactionFilterForm form,
                                                 @RequestParam("cashLimitEventId") Long cashLimitEventId) throws Exception {

        return null;
    }

    /**
     * Invoked when the "Submit" button is pressed.
     *
     * @param form      The form object.
     * @return          ModelAndView
     * @throws Exception If an error occurs.
     */
    @RequestMapping(method = RequestMethod.POST, params = "methodToCall=submitCashAccounts")
    public ModelAndView submitCashAccounts(@ModelAttribute("KualiForm") TransactionFilterForm form) throws Exception {

        return getUIFModelAndView(form);
    }

    /**
     * Refreshes the underlying data model. This action happens after a filter
     * is changes and a refresh is required to apply the changed filter.
     *
     * @param form  The form object.
     */
    @Override
    protected void refreshModel(TransactionFilterForm form) {
        // TODO: Implement loading of Cash Limit Accounts.
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
