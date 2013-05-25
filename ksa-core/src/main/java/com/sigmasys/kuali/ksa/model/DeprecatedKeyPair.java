package com.sigmasys.kuali.ksa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang.StringUtils;

/**
 * This entity represents a "key-value" pair used to perform tuition Fee Assessment.
 *
 * @author Sergey
 */
@Deprecated
@Entity
@Table(name = "KSSA_DEPRECATED_KYPR")
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue(KeyPairType.KEY_PAIR_CODE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DeprecatedKeyPair implements Identifiable {


    /**
     * The unique identifier.
     */
    private Long id;

    /**
     * The name of the key in a pair.
     */
    private String name;

    /**
     * The value of the given key.
     */
    private String value;

    /**
     * If the key had a value before reassignment, the previous value.
     */
    private String previousValue;


    public DeprecatedKeyPair() {
    }

    public DeprecatedKeyPair(String name, String value) {
        this.name = name;
        this.value = value;
    }


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_KEYPAIR",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "KEYPAIR_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_KEYPAIR")
    @Override
    public Long getId() {
        return id;
    }

    @Column(name = "NAME", length = 45)
    public String getName() {
        return name;
    }

    @Column(name = "VALUE", length = 256)
    public String getValue() {
        return value;
    }

    @Column(name = "PREV_VALUE", length = 256)
    public String getPreviousValue() {
        return previousValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        // Store the old value into the "previousValue" property if different:
        if (!StringUtils.equals(value, this.value)) {
            setPreviousValue(this.value);

            // Reassign the "value" property to the new value:
            this.value = value;
        }
    }

    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DeprecatedKeyPair keyPair = (DeprecatedKeyPair) o;

        return !(name != null ? !name.equals(keyPair.name) : keyPair.name != null) && !(value != null ?
                !value.equals(keyPair.value) : keyPair.value != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
