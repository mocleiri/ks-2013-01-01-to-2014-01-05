//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.07 at 05:50:44 PM MDT 
//


package com.sigmasys.kuali.ksa.jaxb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batch-identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}ksa-transaction" maxOccurs="unbounded"/>
 *         &lt;element name="batch-control" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="number-of-transactions" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="total-value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "batchIdentifier",
    "ksaTransaction",
    "batchControl"
})
@XmlRootElement(name = "ksa-batch-transaction")
public class KsaBatchTransaction {

    @XmlElement(name = "batch-identifier", required = true)
    protected String batchIdentifier;
    @XmlElement(name = "ksa-transaction", required = true)
    protected List<KsaTransaction> ksaTransaction;
    @XmlElement(name = "batch-control")
    protected KsaBatchTransaction.BatchControl batchControl;

    /**
     * Gets the value of the batchIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchIdentifier() {
        return batchIdentifier;
    }

    /**
     * Sets the value of the batchIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchIdentifier(String value) {
        this.batchIdentifier = value;
    }

    /**
     * Gets the value of the ksaTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ksaTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKsaTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KsaTransaction }
     * 
     * 
     */
    public List<KsaTransaction> getKsaTransaction() {
        if (ksaTransaction == null) {
            ksaTransaction = new ArrayList<KsaTransaction>();
        }
        return this.ksaTransaction;
    }

    /**
     * Gets the value of the batchControl property.
     * 
     * @return
     *     possible object is
     *     {@link KsaBatchTransaction.BatchControl }
     *     
     */
    public KsaBatchTransaction.BatchControl getBatchControl() {
        return batchControl;
    }

    /**
     * Sets the value of the batchControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link KsaBatchTransaction.BatchControl }
     *     
     */
    public void setBatchControl(KsaBatchTransaction.BatchControl value) {
        this.batchControl = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="number-of-transactions" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="total-value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numberOfTransactions",
        "totalValue"
    })
    public static class BatchControl {

        @XmlElement(name = "number-of-transactions")
        protected int numberOfTransactions;
        @XmlElement(name = "total-value", required = true)
        protected BigDecimal totalValue;

        /**
         * Gets the value of the numberOfTransactions property.
         * 
         */
        public int getNumberOfTransactions() {
            return numberOfTransactions;
        }

        /**
         * Sets the value of the numberOfTransactions property.
         * 
         */
        public void setNumberOfTransactions(int value) {
            this.numberOfTransactions = value;
        }

        /**
         * Gets the value of the totalValue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalValue() {
            return totalValue;
        }

        /**
         * Sets the value of the totalValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalValue(BigDecimal value) {
            this.totalValue = value;
        }

    }

}