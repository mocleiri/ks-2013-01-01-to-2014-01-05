package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.krad.model.MemoModel;
import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Memo;
import com.sigmasys.kuali.ksa.model.Transaction;

import java.util.*;

public class MemoForm extends AbstractViewModel {


    private Account account;

    private Date fromDate;

    private Date toDate;

    private List<MemoModel> memoModels;

    private Memo memoModel;

    private MemoModel newMemoModel;

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

    public void setMemos(List<Memo> memos) {
        this.memoModels = new ArrayList<MemoModel>();
        Map<Long, MemoModel> idList = new HashMap<Long, MemoModel>();

        // List for holding the child memos that came in before the parent
        List<Memo> childMemos = new ArrayList<Memo>();

        for(Memo memo : memos) {
            Memo previousMemo = memo.getPreviousMemo();

            // Make sure the rest of the data is retrieved
            memo.getAccount().getCompositeDefaultPersonName();
            Transaction t = memo.getTransaction();
            if(t != null) {
                t.getTransactionType().getDescription();
            }

            MemoModel model = new MemoModel(memo);

            if(previousMemo == null) {
                memoModels.add(model);
                idList.put(memo.getId(), model);
            } else if(!idList.keySet().contains(previousMemo.getId())){
                childMemos.add(memo);
            } else {
                MemoModel parent = idList.get(previousMemo.getId());
                List<MemoModel> parentModels = parent.getMemoModels();
                parentModels.add(model);
            }

        }

        for(Memo child : childMemos) {
            MemoModel parent = idList.get(child.getPreviousMemo().getId());
            if(parent != null) {
                List<MemoModel> parentModels = parent.getMemoModels();
                MemoModel model = new MemoModel(child);
                parentModels.add(model);
            }
        }
    }

    public List<MemoModel> getMemoModels() {
        return memoModels;
    }

    public void setMemoModels(List<MemoModel> memoModels) {
        this.memoModels = memoModels;
    }

    public Memo getMemoModel() {
        return memoModel;
    }

    public void setMemoModel(Memo memoModel) {
        this.memoModel = memoModel;
    }

    public String getAefInstructionalText() {
        return aefInstructionalText;
    }

    public void setAefInstructionalText(String aefInstructionalText) {
        this.aefInstructionalText = aefInstructionalText;
    }

    public MemoModel getNewMemoModel() {
        if(newMemoModel == null) {
            newMemoModel = new MemoModel();
            Memo memo = new Memo();
            memo.setEffectiveDate(new Date());
            newMemoModel.setParentEntity(memo);
        }
        return newMemoModel;
    }

    public void setNewMemoModel(MemoModel newMemoModel) {
        this.newMemoModel = newMemoModel;
    }
}
