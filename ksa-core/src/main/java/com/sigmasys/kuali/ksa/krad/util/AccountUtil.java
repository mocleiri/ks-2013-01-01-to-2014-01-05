package com.sigmasys.kuali.ksa.krad.util;

import com.sigmasys.kuali.ksa.krad.model.InformationModel;
import com.sigmasys.kuali.ksa.model.Information;
import com.sigmasys.kuali.ksa.service.hold.HoldService;
import com.sigmasys.kuali.ksa.util.ContextUtils;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.core.hold.dto.AppliedHoldInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 9/25/13
 */
public class AccountUtil {

    @Autowired
    private static HoldService holdService;


    public static List<InformationModel> getHolds(String userId) throws RuntimeException{

        ContextInfo context = new ContextInfo();
        String effectiveUser = GlobalVariables.getUserSession().getActualPerson().getPrincipalId();
        context.setAuthenticatedPrincipalId(effectiveUser);

        List<InformationModel> models = new ArrayList<InformationModel>();

        try {
            if (holdService == null) {
                holdService = ContextUtils.getBean(HoldService.class);
            }

            List<AppliedHoldInfo> holds = holdService.getActiveAppliedHoldsByPerson(userId, context);

            for (AppliedHoldInfo hold : holds) {
                Information info = new Information();

                info.setEffectiveDate(hold.getEffectiveDate());
                info.setText(hold.getDescr().getPlain());
                InformationModel model = new InformationModel(info);
                models.add(model);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        return models;
    }

}
