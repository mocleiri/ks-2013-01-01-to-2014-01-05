package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.Account;

public class BatchRefundForm extends AbstractViewModel {


   private Account account;

   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }
}
