package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Fee management signup model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FM_SIGNUP")
public class FeeManagementSignup implements Identifiable {

    private Long id;

    private FeeManagementSession session;

    private String registrationId;

    private String offeringId;

    private String atpId;

    private Integer unit;

    private Boolean isComplete;

    private Date creationDate;

    private Date effectiveDate;

    private Set<KeyPair> keyPairs;

    private FeeManagementSignupOperation operation;

    private String operationCode;


    @PostLoad
    protected void populateTransientFields() {
        operation = (operationCode != null) ? EnumUtils.findById(FeeManagementSignupOperation.class, operationCode) : null;
    }


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FM_SIGNUP",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FM_SIGNUP_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FM_SIGNUP")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FM_SESSION_ID_FK")
    public FeeManagementSession getSession() {
        return session;
    }

    public void setSession(FeeManagementSession session) {
        this.session = session;
    }

    @Column(name = "REG_ID", length = 45)
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Column(name = "OFFERING_ID", length = 45)
    public String getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(String offeringId) {
        this.offeringId = offeringId;
    }

    @Column(name = "ATP_ID", length = 45)
    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    @Column(name = "UNIT")
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_REVIEW_COMPLETE")
    public Boolean isComplete() {
        return isComplete != null ? isComplete : false;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EFFECTIVE_DATE")
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_FM_SIGNUP_KEY_PAIR",
            joinColumns = {
                    @JoinColumn(name = "FM_SIGNUP_ID_FK")
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

    @Column(name = "OPERATION", length = 2)
    protected String getOperationCode() {
        return operationCode;
    }

    protected void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
        operation = EnumUtils.findById(FeeManagementSignupOperation.class, operationCode);
    }

    @Transient
    public FeeManagementSignupOperation getOperation() {
        return operation;
    }

    public void setOperation(FeeManagementSignupOperation operation) {
        this.operation = operation;
        operationCode = operation.getId();
    }


}
