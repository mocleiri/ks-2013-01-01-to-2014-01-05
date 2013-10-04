//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.03 at 04:56:14 PM EDT 
//


package com.sigmasys.kuali.ksa.jaxb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}list-transaction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rollup" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="rollup-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="charge-or-payment">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="charge"/>
 *                         &lt;enumeration value="payment"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element ref="{}list-transaction"/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "listTransaction",
        "rollup"
})
@XmlRootElement(name = "transaction-list")
public class TransactionList {

    @XmlElement(name = "list-transaction")
    protected List<ListTransaction> listTransaction;
    protected List<TransactionList.Rollup> rollup;

    /**
     * Gets the value of the listTransaction property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listTransaction property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListTransaction().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ListTransaction }
     */
    public List<ListTransaction> getListTransaction() {
        if (listTransaction == null) {
            listTransaction = new ArrayList<ListTransaction>();
        }
        return this.listTransaction;
    }

    /**
     * Gets the value of the rollup property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rollup property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRollup().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionList.Rollup }
     */
    public List<TransactionList.Rollup> getRollup() {
        if (rollup == null) {
            rollup = new ArrayList<TransactionList.Rollup>();
        }
        return this.rollup;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="rollup-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="charge-or-payment">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="charge"/>
     *               &lt;enumeration value="payment"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{}list-transaction"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "date",
            "rollupName",
            "amount",
            "chargeOrPayment",
            "listTransaction"
    })
    public static class Rollup {

        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar date;
        @XmlElement(name = "rollup-name", required = true)
        protected String rollupName;
        @XmlElement(required = true)
        protected BigDecimal amount;
        @XmlElement(name = "charge-or-payment", required = true)
        protected String chargeOrPayment;
        @XmlElement(name = "list-transaction", required = true)
        protected ListTransaction listTransaction;

        /**
         * Gets the value of the date property.
         *
         * @return possible object is
         *         {@link XMLGregorianCalendar }
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         *
         * @param value allowed object is
         *              {@link XMLGregorianCalendar }
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Gets the value of the rollupName property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getRollupName() {
            return rollupName;
        }

        /**
         * Sets the value of the rollupName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setRollupName(String value) {
            this.rollupName = value;
        }

        /**
         * Gets the value of the amount property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the chargeOrPayment property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getChargeOrPayment() {
            return chargeOrPayment;
        }

        /**
         * Sets the value of the chargeOrPayment property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setChargeOrPayment(String value) {
            this.chargeOrPayment = value;
        }

        /**
         * Gets the value of the listTransaction property.
         *
         * @return possible object is
         *         {@link ListTransaction }
         */
        public ListTransaction getListTransaction() {
            return listTransaction;
        }

        /**
         * Sets the value of the listTransaction property.
         *
         * @param value allowed object is
         *              {@link ListTransaction }
         */
        public void setListTransaction(ListTransaction value) {
            this.listTransaction = value;
        }

    }

}
