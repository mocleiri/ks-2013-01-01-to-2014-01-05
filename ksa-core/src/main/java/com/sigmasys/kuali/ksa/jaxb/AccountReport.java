//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.18 at 09:08:39 PM GMT-05:00 
//


package com.sigmasys.kuali.ksa.jaxb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="account-identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reporting-period">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="start-date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="end-date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="name">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element ref="{}person-name"/>
 *                   &lt;element name="company-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="balances">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="aged-balance" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="period-length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="period-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="prior-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="total-charges" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="total-payments" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="net-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="written-off" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="unallocated-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="future-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="transaction-detail" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
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
        "accountIdentifier",
        "reportingPeriod",
        "name",
        "balances",
        "transactionDetail"
})
@XmlRootElement(name = "account-report")
public class AccountReport {

    @XmlElement(name = "account-identifier", required = true)
    protected String accountIdentifier;

    @XmlElement(name = "reporting-period", required = true)
    protected ReportingPeriod reportingPeriod;

    @XmlElement(required = true)
    protected AccountReport.Name name;

    @XmlElement(required = true)
    protected AccountReport.Balances balances;

    @XmlElement(name = "transaction-detail")
    protected AccountReport.TransactionDetail transactionDetail;

    /**
     * Gets the value of the accountIdentifier property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Sets the value of the accountIdentifier property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountIdentifier(String value) {
        this.accountIdentifier = value;
    }

    /**
     * Gets the value of the reportingPeriod property.
     *
     * @return possible object is
     *         {@link ReportingPeriod }
     */
    public ReportingPeriod getReportingPeriod() {
        return reportingPeriod;
    }

    /**
     * Sets the value of the reportingPeriod property.
     *
     * @param value allowed object is
     *              {@link ReportingPeriod }
     */
    public void setReportingPeriod(ReportingPeriod value) {
        this.reportingPeriod = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link AccountReport.Name }
     */
    public AccountReport.Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link AccountReport.Name }
     */
    public void setName(AccountReport.Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the balances property.
     *
     * @return possible object is
     *         {@link AccountReport.Balances }
     */
    public AccountReport.Balances getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     *
     * @param value allowed object is
     *              {@link AccountReport.Balances }
     */
    public void setBalances(AccountReport.Balances value) {
        this.balances = value;
    }

    /**
     * Gets the value of the transactionDetail property.
     *
     * @return possible object is
     *         {@link AccountReport.TransactionDetail }
     */
    public AccountReport.TransactionDetail getTransactionDetail() {
        return transactionDetail;
    }

    /**
     * Sets the value of the transactionDetail property.
     *
     * @param value allowed object is
     *              {@link AccountReport.TransactionDetail }
     */
    public void setTransactionDetail(AccountReport.TransactionDetail value) {
        this.transactionDetail = value;
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
     *         &lt;element name="aged-balance" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="period-length" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="period-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="prior-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="total-charges" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="total-payments" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="net-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="written-off" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="unallocated-payments" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="unallocated-charges" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="future-balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "agedBalance",
            "priorBalance",
            "totalCharges",
            "totalPayments",
            "totalDeferments",
            "netBalance",
            "writtenOff",
            "unallocatedPayments",
            "unallocatedCharges",
            "futureBalance"
    })
    public static class Balances {

        @XmlElement(name = "aged-balance")
        protected AgedBalance agedBalance;

        @XmlElement(name = "prior-balance", required = true)
        protected BigDecimal priorBalance;

        @XmlElement(name = "total-charges", required = true)
        protected BigDecimal totalCharges;

        @XmlElement(name = "total-payments", required = true)
        protected BigDecimal totalPayments;

        @XmlElement(name = "total-deferments", required = true)
        protected BigDecimal totalDeferments;

        @XmlElement(name = "net-balance", required = true)
        protected BigDecimal netBalance;

        @XmlElement(name = "written-off", required = true)
        protected BigDecimal writtenOff;

        @XmlElement(name = "unallocated-payments", required = true)
        protected BigDecimal unallocatedPayments;

        @XmlElement(name = "unallocated-charges", required = true)
        protected BigDecimal unallocatedCharges;

        @XmlElement(name = "future-balance", required = true)
        protected BigDecimal futureBalance;

        /**
         * Gets the value of the agedBalance property.
         *
         * @return possible object is
         *         {@link AgedBalance }
         */
        public AgedBalance getAgedBalance() {
            return agedBalance;
        }

        /**
         * Sets the value of the agedBalance property.
         *
         * @param value allowed object is
         *              {@link AgedBalance }
         */
        public void setAgedBalance(AgedBalance value) {
            this.agedBalance = value;
        }

        /**
         * Gets the value of the priorBalance property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getPriorBalance() {
            return priorBalance;
        }

        /**
         * Sets the value of the priorBalance property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setPriorBalance(BigDecimal value) {
            this.priorBalance = value;
        }

        /**
         * Gets the value of the totalCharges property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getTotalCharges() {
            return totalCharges;
        }

        /**
         * Sets the value of the totalCharges property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setTotalCharges(BigDecimal value) {
            this.totalCharges = value;
        }

        /**
         * Gets the value of the totalPayments property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getTotalPayments() {
            return totalPayments;
        }

        /**
         * Sets the value of the totalPayments property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setTotalPayments(BigDecimal value) {
            this.totalPayments = value;
        }

        public BigDecimal getTotalDeferments() {
            return totalDeferments;
        }

        public void setTotalDeferments(BigDecimal totalDeferments) {
            this.totalDeferments = totalDeferments;
        }

        /**
         * Gets the value of the netBalance property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getNetBalance() {
            return netBalance;
        }

        /**
         * Sets the value of the netBalance property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setNetBalance(BigDecimal value) {
            this.netBalance = value;
        }

        /**
         * Gets the value of the writtenOff property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getWrittenOff() {
            return writtenOff;
        }

        /**
         * Sets the value of the writtenOff property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setWrittenOff(BigDecimal value) {
            this.writtenOff = value;
        }

        public BigDecimal getUnallocatedPayments() {
            return unallocatedPayments;
        }

        public void setUnallocatedPayments(BigDecimal unallocatedPayments) {
            this.unallocatedPayments = unallocatedPayments;
        }

        public BigDecimal getUnallocatedCharges() {
            return unallocatedCharges;
        }

        public void setUnallocatedCharges(BigDecimal unallocatedCharges) {
            this.unallocatedCharges = unallocatedCharges;
        }

        /**
         * Gets the value of the futureBalance property.
         *
         * @return possible object is
         *         {@link BigDecimal }
         */
        public BigDecimal getFutureBalance() {
            return futureBalance;
        }

        /**
         * Sets the value of the futureBalance property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setFutureBalance(BigDecimal value) {
            this.futureBalance = value;
        }

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
     *       &lt;choice>
     *         &lt;element ref="{}person-name"/>
     *         &lt;element name="company-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "personName",
            "companyName"
    })
    public static class Name {

        @XmlElement(name = "person-name")
        protected PersonName personName;

        @XmlElement(name = "company-name")
        protected String companyName;

        /**
         * Gets the value of the personName property.
         *
         * @return possible object is
         *         {@link PersonName }
         */
        public PersonName getPersonName() {
            return personName;
        }

        /**
         * Sets the value of the personName property.
         *
         * @param value allowed object is
         *              {@link PersonName }
         */
        public void setPersonName(PersonName value) {
            this.personName = value;
        }

        /**
         * Gets the value of the companyName property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getCompanyName() {
            return companyName;
        }

        /**
         * Sets the value of the companyName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCompanyName(String value) {
            this.companyName = value;
        }

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
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element ref="{}list-transaction"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "listTransaction"
    })
    public static class TransactionDetail {

        @XmlElement(name = "list-transaction", required = true)
        protected List<ListTransaction> listTransaction;

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

    }

}