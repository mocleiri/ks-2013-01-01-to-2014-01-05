package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * CollectionAccount entity.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_COLLECTION_ACNT")
public class CollectionAccount implements Identifiable {


    private Long id;

    private CollectionAgencyAccount agencyAccount;

    private Account accountInCollection;

    private Date authorizationDate;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_COLLECTION_ACNT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "COLLECTION_ACNT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_COLLECTION_ACNT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENCY_ACNT_ID_FK")
    public CollectionAgencyAccount getAgencyAccount() {
        return agencyAccount;
    }

    public void setAgencyAccount(CollectionAgencyAccount agencyAccount) {
        this.agencyAccount = agencyAccount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACNT_ID_FK")
    public Account getAccountInCollection() {
        return accountInCollection;
    }

    public void setAccountInCollection(Account accountInCollection) {
        this.accountInCollection = accountInCollection;
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
