package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Memo;
import org.kuali.rice.core.api.util.tree.Node;
import org.kuali.rice.core.api.util.tree.Tree;

import java.util.ArrayList;
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

    private Tree<Memo, String> memoTree = new Tree<Memo, String>();

    private Memo memoModel;

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

    public String getAefInstructionalText() {
        return aefInstructionalText;
    }

    public void setAefInstructionalText(String aefInstructionalText) {
        this.aefInstructionalText = aefInstructionalText;
    }

    public Tree<Memo, String> getMemoTree(){

        Node<Memo, String> rootNode = new Node<Memo, String>(new Memo(), "Root");
        memoTree.setRootElement(rootNode);

        if(this.memoModels == null){ return memoTree; }

        List<Long> storedIds = new ArrayList<Long>(memoModels.size());
        // Need to put the memos in order
        for(Memo memo : memoModels){
            addNode(rootNode, new Node<Memo, String>(memo, memo.getText()), storedIds);
        }

        return memoTree;
    }


    private void addNode(Node<Memo, String> root, Node<Memo, String> newNode, List<Long> storedIds){
        // Is this really the root?
        Memo rootMemo = root.getData();
        Long id = rootMemo.getId();

        Memo newMemo = newNode.getData();
        Long newId = newMemo.getId();

        if(storedIds.contains(newId)){
            // Already in the tree somewhere, return.
            return;
        }

        root.addChild(newNode);
        storedIds.add(newId);

        if(newMemo.getNextMemo() != null){
            Memo next = newMemo.getNextMemo();
            addNode(newNode, new Node<Memo, String>(next, next.getText()), storedIds);
        }


    }
}
