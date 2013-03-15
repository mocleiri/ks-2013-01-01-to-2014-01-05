package com.sigmasys.kuali.ksa.krad.form;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.CreditType;
import com.sigmasys.kuali.ksa.model.Payment;

import java.math.BigDecimal;

/**
 * Created by: dmulderink on 9/30/12 at 11:27 AM
 */
public class PaymentForm extends AbstractViewModel {

   private Account account;

   private Payment payment;

   private String paymentTransactionTypeId;
    private CreditType transactionType = new CreditType();

   private String printReceipt;

   private String emailReceipt;

   private BigDecimal estimatedCurrentBalance;

   private BigDecimal estimatedPendingBalance;

   private String statusMessage;

   /*
     Get / Set methods
   */


   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account) {
      this.account = account;
   }

   public Payment getPayment() {
      return payment;
   }

   public void setPayment(Payment payment) {
      this.payment = payment;
   }

   public String getPaymentTransactionTypeId() {
      return paymentTransactionTypeId;
   }

   public void setPaymentTransactionTypeId(String paymentTransactionTypeId) {
      this.paymentTransactionTypeId = paymentTransactionTypeId;
   }

   public String getPrintReceipt() {
      return printReceipt;
   }

   public void setPrintReceipt(String printReceipt) {
      this.printReceipt = printReceipt;
   }

   public String getEmailReceipt() {
      return emailReceipt;
   }

   public void setEmailReceipt(String emailReceipt) {
      this.emailReceipt = emailReceipt;
   }

   public BigDecimal getEstimatedCurrentBalance() {
      return estimatedCurrentBalance;
   }

   public void setEstimatedCurrentBalance(BigDecimal estimatedCurrentBalance) {
      this.estimatedCurrentBalance = estimatedCurrentBalance;
   }

   public BigDecimal getEstimatedPendingBalance() {
      return estimatedPendingBalance;
   }

   public void setEstimatedPendingBalance(BigDecimal estimatedPendingBalance) {
      this.estimatedPendingBalance = estimatedPendingBalance;
   }

   public String getStatusMessage() {
      return statusMessage;
   }

   public void setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
   }

    public CreditType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(CreditType transactionType) {
        this.transactionType = transactionType;
    }
}
