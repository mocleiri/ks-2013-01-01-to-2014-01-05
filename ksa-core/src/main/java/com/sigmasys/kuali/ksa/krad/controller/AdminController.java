package com.sigmasys.kuali.ksa.krad.controller;

import com.sigmasys.kuali.ksa.krad.form.AdminForm;
import com.sigmasys.kuali.ksa.model.GlTransaction;
import com.sigmasys.kuali.ksa.model.GlTransactionStatus;
import com.sigmasys.kuali.ksa.service.ActivityService;
import com.sigmasys.kuali.ksa.service.GeneralLedgerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by: dmulderink on 10/5/12 at 6:55 PM
 */
@Controller
@RequestMapping(value = "/adminView")
public class AdminController extends GenericSearchController {

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @Autowired
   private ActivityService activityService;

    @Autowired
    private GeneralLedgerService glService;

   /**
    * @see org.kuali.rice.krad.web.controller.UifControllerBase#createInitialForm(javax.servlet.http.HttpServletRequest)
    */
   @Override
   protected AdminForm createInitialForm(HttpServletRequest request) {
      return new AdminForm();
   }

   /**
    *
    * @param form
    * @param request
    * @return
    */
   @RequestMapping(method = RequestMethod.GET, params = "methodToCall=get")
   public ModelAndView get(@ModelAttribute("KualiForm") AdminForm form, HttpServletRequest request) {

      // do get stuff...

       String pageId = request.getParameter("pageId");
       logger.info("Admin Controller: Page '" + pageId + "'");

       if ("ActivityPage".equals(pageId)) {
         form.setActivities(activityService.getActivities());
         return getUIFModelAndView(form);
      } else if("TransactionsExport".equals(pageId)){
           List<GlTransaction> transactions = glService.getGlTransactionsByStatus(GlTransactionStatus.QUEUED);
           form.setGlTransactions(transactions);
       }


      /*throw new IllegalArgumentException("'pageId' request parameter must be specified");*/
       return getUIFModelAndView(form);

   }


   /**
    *
    * @param form
    * @param request
    * @return
    */
   @RequestMapping(method= RequestMethod.POST, params="methodToCall=refresh")
   public ModelAndView refresh(@ModelAttribute("KualiForm") AdminForm form, HttpServletRequest request) {

      String pageId = request.getParameter("actionParameters[pageId]");

      if (pageId != null && "ActivityPage".equals(pageId)) {
         form.setActivities(activityService.getActivities());
         return getUIFModelAndView(form);
      }

      /*throw new IllegalArgumentException("'pageId' request parameter must be specified");*/
       return getUIFModelAndView(form);

   }
}
