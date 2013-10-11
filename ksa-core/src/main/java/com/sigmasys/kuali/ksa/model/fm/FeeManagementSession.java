package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Account;
import com.sigmasys.kuali.ksa.model.Identifiable;
import com.sigmasys.kuali.ksa.model.KeyPair;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Fee management session model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FM_SESSION")
public class FeeManagementSession implements Identifiable {

    private Long id;

    private Account account;

    private FeeManagementSession prevSession;

    private FeeManagementSession nextSession;

    private String atpId;

    private Boolean isReviewRequired;

    private Boolean isReviewComplete;

    private String reviewerId;

    private Date creationDate;

    private Date reviewDate;

    private Set<KeyPair> keyPairs;

    private FeeManagementSessionStatus status;

    private String statusCode;

    private Boolean isQueued;


    @PostLoad
    protected void populateTransientFields() {
        status = (statusCode != null) ? EnumUtils.findById(FeeManagementSessionStatus.class, statusCode) : null;
    }


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FM_SESSION",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FM_SESSION_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FM_SESSION")
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
    @JoinColumn(name = "PREV_SESSION_ID_FK")
    public FeeManagementSession getPrevSession() {
        return prevSession;
    }

    public void setPrevSession(FeeManagementSession prevSession) {
        this.prevSession = prevSession;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NEXT_SESSION_ID_FK")
    public FeeManagementSession getNextSession() {
        return nextSession;
    }

    public void setNextSession(FeeManagementSession nextSession) {
        this.nextSession = nextSession;
    }

    @Column(name = "ATP_ID", length = 45)
    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_REVIEW_REQUIRED")
    public Boolean isReviewRequired() {
        return isReviewRequired != null ? isReviewRequired : false;
    }

    public void setReviewRequired(Boolean reviewRequired) {
        isReviewRequired = reviewRequired;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_REVIEW_COMPLETE")
    public Boolean isReviewComplete() {
        return isReviewComplete != null ? isReviewComplete : false;
    }

    public void setReviewComplete(Boolean reviewComplete) {
        isReviewComplete = reviewComplete;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_QUEUED")
    public Boolean isQueued() {
        return (isQueued != null) ? isQueued : false;
    }

    public void setQueued(Boolean queued) {
        isQueued = queued;
    }

    @Column(name = "REVIEWER_ID", length = 45)
    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "REVIEW_DATE")
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_FM_SESSION_KEY_PAIR",
            joinColumns = {
                    @JoinColumn(name = "FM_SESSION_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "KEY_PAIR_ID_FK")
            }
    )
    public Set<KeyPair> getKeyPairs() {
        return keyPairs;
    }

    public void setKeyPairs(Set<KeyPair> keyPairs) {
        this.keyPairs = keyPairs;
    }

    @Column(name = "STATUS", length = 2)
    protected String getStatusCode() {
        return statusCode;
    }

    protected void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        status = EnumUtils.findById(FeeManagementSessionStatus.class, statusCode);
    }

    @Transient
    public FeeManagementSessionStatus getStatus() {
        return status;
    }

    public void setChargeStatus(FeeManagementSessionStatus status) {
        this.status = status;
        statusCode = status.getId();
    }


}
