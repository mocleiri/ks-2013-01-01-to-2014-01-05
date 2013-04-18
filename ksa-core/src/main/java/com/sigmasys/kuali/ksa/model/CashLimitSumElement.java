package com.sigmasys.kuali.ksa.model;


import javax.persistence.*;
import java.math.BigDecimal;


/**
 * Cash limit summary element.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_CASH_LIMIT_SUM_ELEMENT")
public class CashLimitSumElement implements Identifiable {

    /**
     * The unique identifier
     */
    private Long id;

    /**
     * Friendly element name
     */
    private String name;

    /**
     * XML element name
     */
    private String xmlElement;

    /**
     * Summary amount
     */
    private BigDecimal amount;

    /**
     * Native amount
     */
    private BigDecimal nativeAmount;

    /**
     * Cash Limit Event
     */
    private CashLimitEvent cashLimitEvent;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_CASH_LIMIT_SUM_ELEMENT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "CASH_LIMIT_SUM_ELEMENT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_CASH_LIMIT_SUM_ELEMENT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "XML_ELEMENT", length = 45)
    public String getXmlElement() {
        return xmlElement;
    }

    public void setXmlElement(String xmlElement) {
        this.xmlElement = xmlElement;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "NATIVE_AMOUNT")
    public BigDecimal getNativeAmount() {
        return nativeAmount;
    }

    public void setNativeAmount(BigDecimal nativeAmount) {
        this.nativeAmount = nativeAmount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CASH_LIMIT_EVENT_ID_FK")
    public CashLimitEvent getCashLimitEvent() {
        return cashLimitEvent;
    }

    public void setCashLimitEvent(CashLimitEvent cashLimitEvent) {
        this.cashLimitEvent = cashLimitEvent;
    }

}
	


