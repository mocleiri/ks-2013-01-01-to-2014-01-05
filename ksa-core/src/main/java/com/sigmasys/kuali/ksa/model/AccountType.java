package com.sigmasys.kuali.ksa.model;

import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;

/**
 * Activity type.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_ACNT_TYPE")
@AttributeOverride(name = "code", column = @Column(name = "CODE", length = 3, nullable = false))
public class AccountType extends AuditableEntity<Long> {

    private AccountTypeValue accountTypeValue;


    @PostLoad
    protected void populateTransientFields() {
        accountTypeValue = (code != null) ? EnumUtils.findById(AccountTypeValue.class, code) : null;
    }

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_ACNT_TYPE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "ACNT_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_ACNT_TYPE")
    @Override
    public Long getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
        accountTypeValue = EnumUtils.findById(AccountTypeValue.class, code);
    }

    @Transient
    public AccountTypeValue getAccountTypeValue() {
        return accountTypeValue;
    }

    public void setAccountTypeValue(AccountTypeValue accountTypeValue) {
        this.accountTypeValue = accountTypeValue;
        code = accountTypeValue.getId();
    }
}
