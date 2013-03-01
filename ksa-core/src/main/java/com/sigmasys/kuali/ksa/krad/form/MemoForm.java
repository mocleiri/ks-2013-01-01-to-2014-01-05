package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Memo;

import java.util.Date;
import java.util.List;

/**
 * Created by: dmulderink on 10/4/12 at 7:52 AM
 */
public class MemoForm extends AbstractViewModel {


    private Account account;

    private Date fromDate;

    private Date toDate;

    private List<Memo> memoModels;

    private Memo memoModel;

    private String statusMessage;

    // resuable add edit or followup instructional text
    private String aefInstructionalText;
    /*
      Get / Set methods
    */

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<Memo> getMemoModels() {
        return memoModels;
    }

    public void setMemoModels(List<Memo> memoModels) {
        this.memoModels = memoModels;
    }

    public Memo getMemoModel() {
        return memoModel;
    }

    public void setMemoModel(Memo memoModel) {
        this.memoModel = memoModel;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getAefInstructionalText() {
        return aefInstructionalText;
    }

    public void setAefInstructionalText(String aefInstructionalText) {
        this.aefInstructionalText = aefInstructionalText;
    }
}
