package com.sigmasys.kuali.ksa.model.tp;

import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Third party plan detail.
 * Stores the information relating to a TP plan that has been executed against a student account
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_TP_TRANSFER_DETAIL")
public class ThirdPartyTransferDetail implements Identifiable {

    /**
     * Identifier
     */
    private Long id;

    /**
     * The account from which the charges will be transferred. (The beneficiary account).
     */
    private DirectChargeAccount directChargeAccount;

    /**
     * The plan under which the transfer was made.
     */
    private ThirdPartyPlan plan;

    /**
     * Transfer Group ID
     */
    private String transferGroupId;

    /**
     * The amount that was transferred to the TP account.
     */
    private BigDecimal transferAmount;

    /**
     * Third-party charge status
     */
    protected ThirdPartyChargeStatus chargeStatus;

    /**
     * Third-party charge status code
     */
    protected String chargeStatusCode;


    @PostLoad
    protected void populateTransientFields() {
        chargeStatus = (chargeStatusCode != null) ? EnumUtils.findById(ThirdPartyChargeStatus.class, chargeStatusCode) : null;
    }


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_TP_TRANSFER",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "TP_TRANSFER_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_TP_TRANSFER")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACNT_ID_FK")
    public DirectChargeAccount getDirectChargeAccount() {
        return directChargeAccount;
    }

    public void setDirectChargeAccount(DirectChargeAccount directChargeAccount) {
        this.directChargeAccount = directChargeAccount;
    }

    @Column(name = "TRANSFER_GROUP_ID", length = 100)
    public String getTransferGroupId() {
        return transferGroupId;
    }

    public void setTransferGroupId(String transferGroupId) {
        this.transferGroupId = transferGroupId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TP_PLAN_ID_FK")
    public ThirdPartyPlan getPlan() {
        return plan;
    }

    public void setPlan(ThirdPartyPlan plan) {
        this.plan = plan;
    }

    @Column(name = "TRANSFER_AMOUNT")
    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    @Column(name = "STATUS", length = 1)
    protected String getChargeStatusCode() {
        return chargeStatusCode;
    }

    protected void setChargeStatusCode(String chargeStatusCode) {
        this.chargeStatusCode = chargeStatusCode;
        chargeStatus = EnumUtils.findById(ThirdPartyChargeStatus.class, chargeStatusCode);
    }

    @Transient
    public ThirdPartyChargeStatus getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(ThirdPartyChargeStatus chargeStatus) {
        this.chargeStatus = chargeStatus;
        chargeStatusCode = chargeStatus.getId();
    }

}
