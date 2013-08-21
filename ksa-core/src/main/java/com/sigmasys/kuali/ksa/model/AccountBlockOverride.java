package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Account block override model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ACNT_BLOCK_OVERRIDE")
public class AccountBlockOverride implements Identifiable {

    private Long id;

    private Account account;

    private AccountBlock accountBlock;

    private String reason;

    private Boolean isAdminOverride;

    private Boolean isSingleUse;

    private Boolean isComplete;

    private String creatorId;

    private Date creationDate;

    private Date expirationDate;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ACNT_BLOCK_OVERRIDE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ACNT_BLOCK_OVERRIDE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ACNT_BLOCK_OVERRIDE")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACNT_ID_FK")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACNT_BLOCK_ID_FK")
    public AccountBlock getAccountBlock() {
        return accountBlock;
    }

    public void setAccountBlock(AccountBlock accountBlock) {
        this.accountBlock = accountBlock;
    }

    @Column(name = "REASON", length = 2000)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_ADMIN_OVERRIDE")
    public Boolean isAdminOverride() {
        return isAdminOverride != null ? isAdminOverride : false;
    }

    public void setAdminOverride(Boolean adminOverride) {
        isAdminOverride = adminOverride;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_SINGLE_USE")
    public Boolean isSingleUse() {
        return isSingleUse != null ? isSingleUse : false;
    }

    public void setSingleUse(Boolean singleUse) {
        isSingleUse = singleUse;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_COMPLETE")
    public Boolean isComplete() {
        return isComplete != null ? isComplete : false;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Column(name = "CREATOR_ID", length = 45)
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRATION_DATE")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
