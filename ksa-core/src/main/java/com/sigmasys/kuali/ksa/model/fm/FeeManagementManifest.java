package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;
import com.sigmasys.kuali.ksa.model.Rollup;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Fee management manifest model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FM_MANIFEST")
public class FeeManagementManifest implements Identifiable {

    private Long id;

    private FeeManagementSession session;

    private FeeManagementManifest linkedManifest;

    private Rollup rollup;

    private String registrationId;

    private String offeringId;

    private String internalChargeId;

    private String transactionTypeId;

    private String rateCode;

    private Date effectiveDate;

    private Date recognitionDate;

    private Boolean isSessionCurrent;

    private FeeManagementManifestStatus status;

    private String statusCode;

    private FeeManagementManifestType type;

    private String typeCode;


    @PostLoad
    protected void populateTransientFields() {
        status = (statusCode != null) ? EnumUtils.findById(FeeManagementManifestStatus.class, statusCode) : null;
        type = (typeCode != null) ? EnumUtils.findById(FeeManagementManifestType.class, typeCode) : null;
    }

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FM_MANIFEST",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FM_MANIFEST_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FM_MANIFEST")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LINKED_MANIFEST_ID_FK")
    public FeeManagementManifest getLinkedManifest() {
        return linkedManifest;
    }

    public void setLinkedManifest(FeeManagementManifest linkedManifest) {
        this.linkedManifest = linkedManifest;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLLUP_ID_FK")
    public Rollup getRollup() {
        return rollup;
    }

    public void setRollup(Rollup rollup) {
        this.rollup = rollup;
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

    @Column(name = "INTERNAL_CHARGE_ID", length = 45)
    public String getInternalChargeId() {
        return internalChargeId;
    }

    public void setInternalChargeId(String internalChargeId) {
        this.internalChargeId = internalChargeId;
    }

    @Column(name = "TRANSACTION_TYPE_ID", length = 20)
    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Column(name = "RATE_CODE", length = 45)
    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_SESSION_CURRENT")
    public Boolean isSessionCurrent() {
        return isSessionCurrent != null ? isSessionCurrent : false;
    }

    public void setSessionCurrent(Boolean isSessionCurrent) {
        this.isSessionCurrent = isSessionCurrent;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EFFECTIVE_DATE")
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RECOG_DATE")
    public Date getRecognitionDate() {
        return recognitionDate;
    }

    public void setRecognitionDate(Date recognitionDate) {
        this.recognitionDate = recognitionDate;
    }

    @Column(name = "STATUS", length = 1)
    protected String getStatusCode() {
        return statusCode;
    }

    protected void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        status = EnumUtils.findById(FeeManagementManifestStatus.class, statusCode);
    }

    @Column(name = "TYPE", length = 2)
    protected String getTypeCode() {
        return typeCode;
    }

    protected void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
        type = EnumUtils.findById(FeeManagementManifestType.class, typeCode);
    }

    @Transient
    public FeeManagementManifestStatus getStatus() {
        return status;
    }

    public void setStatus(FeeManagementManifestStatus status) {
        this.status = status;
        statusCode = status.getId();
    }

    @Transient
    public FeeManagementManifestType getType() {
        return type;
    }

    public void setType(FeeManagementManifestType type) {
        this.type = type;
        typeCode = type.getId();
    }


}
