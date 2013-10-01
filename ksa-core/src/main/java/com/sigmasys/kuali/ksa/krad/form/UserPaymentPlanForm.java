package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.InformationModel;
import com.sigmasys.kuali.ksa.krad.model.ThirdPartyMemberModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Alert;
import com.sigmasys.kuali.ksa.model.Flag;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 8/16/13
 */
public class UserPaymentPlanForm extends AbstractViewModel {

    private Account account;
    private List<InformationModel> alerts;
    private List<InformationModel> flags;
    private List<InformationModel> holds;


    private String addThirdPartyPlanName;
    private List<ThirdPartyMemberModel> thirdPartyMembers;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<InformationModel> getAlerts() {
        if (alerts == null) {
            alerts = new ArrayList<InformationModel>();
        }
        return alerts;
    }

    public String getAlertTooltip() {
        return TransactionForm.getInformationTooltip("Alerts", alerts);
    }

    public void setAlertObjects(List<Alert> alerts) {
        List<InformationModel> models = new ArrayList<InformationModel>(alerts.size());
        for (Alert alert : alerts) {
            models.add(new InformationModel(alert));
        }
        setAlerts(models);
    }

    public void setAlerts(List<InformationModel> alerts) {
        this.alerts = alerts;
    }

    public List<InformationModel> getFlags() {
        if (flags == null) {
            flags = new ArrayList<InformationModel>();
        }
        return flags;
    }

    public String getFlagTooltip() {
        return TransactionForm.getInformationTooltip("Flags", flags);
    }

    public void setFlagObjects(List<Flag> flags) {
        List<InformationModel> models = new ArrayList<InformationModel>(flags.size());
        for (Flag flag : flags) {
            models.add(new InformationModel(flag));
        }
        setFlags(models);
    }

    public void setFlags(List<InformationModel> flags) {
        this.flags = flags;
    }

    public List<InformationModel> getHolds() {
        if (holds == null) {
            holds = new ArrayList<InformationModel>();
        }
        return holds;
    }

    public void setHolds(List<InformationModel> holds) {
        this.holds = holds;
    }

    public String getHoldTooltip() {
        return TransactionForm.getInformationTooltip("Holds", holds);
    }


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
