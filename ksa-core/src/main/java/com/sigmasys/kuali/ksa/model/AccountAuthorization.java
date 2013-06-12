package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * AccountAuthorization entity.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ACNT_AUTHZ")
public class AccountAuthorization implements Identifiable {


    private Long id;

    private Account authorizedAccount;

    private Account dependentAccount;

    private Date authorizationDate;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ACNT_AUTHZ",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ACNT_AUTHZ_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ACNT_AUTHZ")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHZ_ACNT_ID_FK")
    public Account getAuthorizedAccount() {
        return authorizedAccount;
    }

    public void setAuthorizedAccount(Account authorizedAccount) {
        this.authorizedAccount = authorizedAccount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPENDENT_ACNT_ID_FK")
    public Account getDependentAccount() {
        return dependentAccount;
    }

    public void setDependentAccount(Account dependentAccount) {
        this.dependentAccount = dependentAccount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "AUTHZ_DATE")
    public Date getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(Date authorizationDate) {
        this.authorizationDate = authorizationDate;
    }
}
