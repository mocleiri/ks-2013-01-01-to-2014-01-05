package com.sigmasys.kuali.ksa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sigmasys.kuali.ksa.annotation.Auditable;
import com.sigmasys.kuali.ksa.util.BeanUtils;

/**
 * KSA Account model
 * <p/>
 * <p/>
 *
 * @author Michael Ivanov
 */
@Auditable
@Entity
@Table(name = "KSSA_ACNT")
@DiscriminatorColumn(name = "TYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account implements Identifiable {

    /**
     * Account ID (User ID)
     */
    protected String id;

    /**
     * Entity ID
     */
    protected String entityId;

    /**
     * Creator ID
     */
    protected String creatorId;

    /**
     * Editor ID
     */
    protected String editorId;

    /**
     * Creation date
     */
    protected Date creationDate;

    /**
     * Update timestamp
     */
    protected Date lastUpdate;

    /**
     * Last KIM update date
     */
    protected Date lastKimUpdate;

    /**
     * Last KIM update date
     */
    protected Boolean isKimAccount;

    /**
     * True if the user can authenticate
     */
    protected Boolean ableToAuthenticate;

    /**
     * Credit limit
     */
    protected BigDecimal creditLimit;

    /**
     * Late period
     */
    protected LatePeriod latePeriod;

    /**
     * Organization name (For non-personal accounts only)
     */
    protected OrgName orgName;

    /**
     * Collection of associated person names
     */
    protected Set<PersonName> personNames;

    /**
     * Collection of associated electronic contacts
     */
    protected Set<ElectronicContact> electronicContacts;

    /**
     * Collection of associated postal addresses
     */
    protected Set<PostalAddress> postalAddresses;

    /**
     * Account Status Type
     */
    protected AccountStatusType statusType;


    @Id
    @Column(name = "ID", nullable = false, updatable = false, length = 45)
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "ENTITY_ID", length = 45)
    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Column(name = "CREATOR_ID", length = 45)
    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @Column(name = "EDITOR_ID", length = 45)
    public String getEditorId() {
        return editorId;
    }

    public void setEditorId(String editorId) {
        this.editorId = editorId;
    }

    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "LAST_KIM_UPDATE")
    public Date getLastKimUpdate() {
        return lastKimUpdate;
    }

    public void setLastKimUpdate(Date lastKimUpdate) {
        this.lastKimUpdate = lastKimUpdate;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "IS_KIM_ACNT")
    public Boolean isKimAccount() {
        return isKimAccount != null ? isKimAccount : false;
    }

    @Transient
    public Boolean getIsKimAccount() {
        return isKimAccount();
    }

    public void setKimAccount(Boolean kimAccount) {
        isKimAccount = kimAccount;
    }

    @org.hibernate.annotations.Type(type = "yes_no")
    @Column(name = "CAN_AUTHENTICATE")
    public Boolean isAbleToAuthenticate() {
        return ableToAuthenticate != null ? ableToAuthenticate : false;
    }

    @Transient
    public Boolean getAbleToAuthenticate() {
        return isAbleToAuthenticate();
    }

    public void setAbleToAuthenticate(Boolean ableToAuthenticate) {
        this.ableToAuthenticate = ableToAuthenticate;
    }

    @Column(name = "CREDIT_LIMIT")
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LATE_PERIOD_ID_FK")
    public LatePeriod getLatePeriod() {
        return latePeriod;
    }

    public void setLatePeriod(LatePeriod latePeriod) {
        this.latePeriod = latePeriod;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORG_NAME_ID_FK")
    public OrgName getOrgName() {
        return orgName;
    }

    public void setOrgName(OrgName orgName) {
        this.orgName = orgName;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_ACNT_PERSON_NAME",
            joinColumns = {
                    @JoinColumn(name = "ACNT_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PERSON_NAME_ID_FK")
            }
    )
    public Set<PersonName> getPersonNames() {
        return personNames;
    }

    public void setPersonNames(Set<PersonName> personNames) {
        this.personNames = personNames;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_ACNT_ELECTRONIC_CONTACT",
            joinColumns = {
                    @JoinColumn(name = "ACNT_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ELECTRONIC_CONTACT_ID_FK")
            }
    )
    public Set<ElectronicContact> getElectronicContacts() {
        return electronicContacts;
    }

    public void setElectronicContacts(Set<ElectronicContact> electronicContacts) {
        this.electronicContacts = electronicContacts;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "KSSA_ACNT_POSTAL_ADDRESS",
            joinColumns = {
                    @JoinColumn(name = "ACNT_ID_FK")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "POSTAL_ADDRESS_ID_FK")
            }
    )
    public Set<PostalAddress> getPostalAddresses() {
        return postalAddresses;
    }

    public void setPostalAddresses(Set<PostalAddress> postalAddresses) {
        this.postalAddresses = postalAddresses;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACNT_STATUS_TYPE_ID_FK")
    public AccountStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(AccountStatusType statusType) {
        this.statusType = statusType;
    }

    @Transient
    public PersonName getDefaultPersonName() {
        Set<PersonName> personNames = getPersonNames();
        if (personNames != null) {
            for (PersonName personName : personNames) {
                if (personName.isDefault()) {
                    return personName;
                }
            }
        }
        return null;
    }

    @Transient
    public PostalAddress getDefaultPostalAddress() {
        Set<PostalAddress> postalAddresses = getPostalAddresses();
        if (postalAddresses != null) {
            for (PostalAddress postalAddress : postalAddresses) {
                if (postalAddress.isDefault()) {
                    return postalAddress;
                }
            }
        }
        return null;
    }

    @Transient
    public ElectronicContact getDefaultElectronicContact() {
        Set<ElectronicContact> electronicContacts = getElectronicContacts();
        if (electronicContacts != null) {
            for (ElectronicContact electronicContact : electronicContacts) {
                if (electronicContact.isDefault()) {
                    return electronicContact;
                }
            }
        }
        return null;
    }

    /**
     * Get lastName, firstName of the default PersonName Set record
     */
    @Transient
    public String getCompositeDefaultPersonName() {
        PersonName personName = getDefaultPersonName();
        return (personName != null) ? personName.getDisplayValue() : "";
    }

    /**
     * Get Address line 1, state, postalCode, and country of the default PostalAddress Set record
     */
    @Transient
    public String getCompositeDefaultPostalAddress() {
        PostalAddress postalAddress = getDefaultPostalAddress();
        return (postalAddress != null) ? postalAddress.getDisplayValue() : "";
    }

    @Transient
    public Account getCopy() {
        return BeanUtils.getDeepCopy(this);
    }
}
