package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.model.Memo;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tbornholtz
 * Date: 9/10/13
 */
public class MemoModel extends InformationModel {

    private List<MemoModel> memoModels;

    public MemoModel() {

    }

    public MemoModel(Memo memo) {
        this.setParentEntity(memo);
    }

    public List<MemoModel> getMemoModels() {
        if(memoModels == null) {
            memoModels = new ArrayList<MemoModel>();
        }
        return memoModels;
    }

    public void setMemoModels(List<MemoModel> memoModels) {
        this.memoModels = memoModels;
    }
}
