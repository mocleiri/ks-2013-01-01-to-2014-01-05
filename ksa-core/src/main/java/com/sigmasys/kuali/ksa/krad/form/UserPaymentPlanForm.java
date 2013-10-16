package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;

import java.util.ArrayList;
import java.util.List;

//import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;

/**
 * User: tbornholtz
 * Date: 8/16/13
 */
public class UserPaymentPlanForm extends AbstractViewModel {

    private String addThirdPartyPlanName;
    private List<ThirdPartyMemberModel> thirdPartyMembers;

    public String getAddThirdPartyPlanName() {
        return addThirdPartyPlanName;
    }

    public void setAddThirdPartyPlanName(String addThirdPartyPlanName) {
        this.addThirdPartyPlanName = addThirdPartyPlanName;
    }

    public List<ThirdPartyMemberModel> getThirdPartyMembers() {
        if(thirdPartyMembers == null) {
            thirdPartyMembers = new ArrayList<ThirdPartyMemberModel>();
        }
        return thirdPartyMembers;
    }

    public void setThirdPartyMembers(List<ThirdPartyMemberModel> thirdPartyMembers) {
        this.thirdPartyMembers = thirdPartyMembers;
    }
}
