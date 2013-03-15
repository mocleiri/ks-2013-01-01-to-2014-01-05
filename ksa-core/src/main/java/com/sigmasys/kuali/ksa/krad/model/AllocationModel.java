package com.sigmasys.kuali.ksa.krad.model;


import com.sigmasys.kuali.ksa.model.Allocation;
import com.sigmasys.kuali.ksa.model.Transaction;

public class AllocationModel {

    private Allocation allocation;

    private Transaction parentTransaction;
    private Transaction allocatedTransaction;

    public AllocationModel(){

    }

    public AllocationModel(Transaction t, Allocation a){
        this.parentTransaction = t;
        this.allocation = a;

        this.setAllocatedTransaction();
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAlocation(Allocation allocation) {
        this.allocation = allocation;
        this.setAllocatedTransaction();
    }

    public Transaction getParentTransaction() {
        return parentTransaction;
    }

    public void setParentTransaction(Transaction parentTransaction) {
        this.parentTransaction = parentTransaction;
        this.setAllocatedTransaction();
    }

    public Transaction getAllocatedTransaction() {
        return allocatedTransaction;
    }

    public void setAllocatedTransaction(Transaction allocatedTransaction) {
        this.allocatedTransaction = allocatedTransaction;
    }

    private void setAllocatedTransaction(){
        if(this.allocation != null && this.parentTransaction != null){
            if(this.parentTransaction.equals(this.allocation.getFirstTransaction())){
                this.allocatedTransaction = this.allocation.getSecondTransaction();
            } else {
                this.allocatedTransaction = this.allocation.getFirstTransaction();
            }
        }
    }
}
