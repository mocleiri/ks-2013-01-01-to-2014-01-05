//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.18 at 09:08:39 PM GMT-05:00 
//


package com.sigmasys.kuali.ksa.jaxb;

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
 *         &lt;element name="account-identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="student-information" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="citizenship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="residency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="year-of-study" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="level-of-study" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="campus" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="full-or-part-time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="program-of-study" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="second-major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="minor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="second-minor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{}key-pair" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="period-information" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element ref="{}key-pair" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="study" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{}learning-unit" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "accountIdentifier",
    "studentInformation",
    "periodInformation"
})
@XmlRootElement(name = "student-profile")
public class StudentProfile {

    @XmlElement(name = "account-identifier", required = true)
    protected String accountIdentifier;
    @XmlElement(name = "student-information")
    protected StudentProfile.StudentInformation studentInformation;
    @XmlElement(name = "period-information")
    protected StudentProfile.PeriodInformation periodInformation;

    /**
     * Gets the value of the accountIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Sets the value of the accountIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountIdentifier(String value) {
        this.accountIdentifier = value;
    }

    /**
     * Gets the value of the studentInformation property.
     * 
     * @return
     *     possible object is
     *     {@link StudentProfile.StudentInformation }
     *     
     */
    public StudentProfile.StudentInformation getStudentInformation() {
        return studentInformation;
    }

    /**
     * Sets the value of the studentInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentProfile.StudentInformation }
     *     
     */
    public void setStudentInformation(StudentProfile.StudentInformation value) {
        this.studentInformation = value;
    }

    /**
     * Gets the value of the periodInformation property.
     * 
     * @return
     *     possible object is
     *     {@link StudentProfile.PeriodInformation }
     *     
     */
    public StudentProfile.PeriodInformation getPeriodInformation() {
        return periodInformation;
    }

    /**
     * Sets the value of the periodInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentProfile.PeriodInformation }
     *     
     */
    public void setPeriodInformation(StudentProfile.PeriodInformation value) {
        this.periodInformation = value;
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
     *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element ref="{}key-pair" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="study" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{}learning-unit" maxOccurs="unbounded" minOccurs="0"/>
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
        "period",
        "keyPair",
        "study"
    })
    public static class PeriodInformation {

        protected Object period;
        @XmlElement(name = "key-pair")
        protected List<KeyPair> keyPair;
        protected StudentProfile.PeriodInformation.Study study;

        /**
         * Gets the value of the period property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getPeriod() {
            return period;
        }

        /**
         * Sets the value of the period property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setPeriod(Object value) {
            this.period = value;
        }

        /**
         * Gets the value of the keyPair property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyPair property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyPair().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeyPair }
         * 
         * 
         */
        public List<KeyPair> getKeyPair() {
            if (keyPair == null) {
                keyPair = new ArrayList<KeyPair>();
            }
            return this.keyPair;
        }

        /**
         * Gets the value of the study property.
         * 
         * @return
         *     possible object is
         *     {@link StudentProfile.PeriodInformation.Study }
         *     
         */
        public StudentProfile.PeriodInformation.Study getStudy() {
            return study;
        }

        /**
         * Sets the value of the study property.
         * 
         * @param value
         *     allowed object is
         *     {@link StudentProfile.PeriodInformation.Study }
         *     
         */
        public void setStudy(StudentProfile.PeriodInformation.Study value) {
            this.study = value;
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
         *         &lt;element ref="{}learning-unit" maxOccurs="unbounded" minOccurs="0"/>
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
            "learningUnit"
        })
        public static class Study {

            @XmlElement(name = "learning-unit")
            protected List<LearningUnit> learningUnit;

            /**
             * Gets the value of the learningUnit property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the learningUnit property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLearningUnit().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LearningUnit }
             * 
             * 
             */
            public List<LearningUnit> getLearningUnit() {
                if (learningUnit == null) {
                    learningUnit = new ArrayList<LearningUnit>();
                }
                return this.learningUnit;
            }

        }

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
     *         &lt;element name="citizenship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="residency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="year-of-study" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="level-of-study" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="campus" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="full-or-part-time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="program-of-study" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="second-major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="minor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="second-minor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{}key-pair" maxOccurs="unbounded" minOccurs="0"/>
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
        "citizenship",
        "residency",
        "yearOfStudy",
        "levelOfStudy",
        "campus",
        "fullOrPartTime",
        "programOfStudy",
        "keyPair"
    })
    public static class StudentInformation {

        protected String citizenship;
        protected String residency;
        @XmlElement(name = "year-of-study")
        protected String yearOfStudy;
        @XmlElement(name = "level-of-study")
        protected Object levelOfStudy;
        protected Object campus;
        @XmlElement(name = "full-or-part-time")
        protected String fullOrPartTime;
        @XmlElement(name = "program-of-study")
        protected StudentProfile.StudentInformation.ProgramOfStudy programOfStudy;
        @XmlElement(name = "key-pair")
        protected List<KeyPair> keyPair;

        /**
         * Gets the value of the citizenship property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCitizenship() {
            return citizenship;
        }

        /**
         * Sets the value of the citizenship property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCitizenship(String value) {
            this.citizenship = value;
        }

        /**
         * Gets the value of the residency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResidency() {
            return residency;
        }

        /**
         * Sets the value of the residency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResidency(String value) {
            this.residency = value;
        }

        /**
         * Gets the value of the yearOfStudy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getYearOfStudy() {
            return yearOfStudy;
        }

        /**
         * Sets the value of the yearOfStudy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setYearOfStudy(String value) {
            this.yearOfStudy = value;
        }

        /**
         * Gets the value of the levelOfStudy property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getLevelOfStudy() {
            return levelOfStudy;
        }

        /**
         * Sets the value of the levelOfStudy property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setLevelOfStudy(Object value) {
            this.levelOfStudy = value;
        }

        /**
         * Gets the value of the campus property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCampus() {
            return campus;
        }

        /**
         * Sets the value of the campus property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCampus(Object value) {
            this.campus = value;
        }

        /**
         * Gets the value of the fullOrPartTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFullOrPartTime() {
            return fullOrPartTime;
        }

        /**
         * Sets the value of the fullOrPartTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFullOrPartTime(String value) {
            this.fullOrPartTime = value;
        }

        /**
         * Gets the value of the programOfStudy property.
         * 
         * @return
         *     possible object is
         *     {@link StudentProfile.StudentInformation.ProgramOfStudy }
         *     
         */
        public StudentProfile.StudentInformation.ProgramOfStudy getProgramOfStudy() {
            return programOfStudy;
        }

        /**
         * Sets the value of the programOfStudy property.
         * 
         * @param value
         *     allowed object is
         *     {@link StudentProfile.StudentInformation.ProgramOfStudy }
         *     
         */
        public void setProgramOfStudy(StudentProfile.StudentInformation.ProgramOfStudy value) {
            this.programOfStudy = value;
        }

        /**
         * Gets the value of the keyPair property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyPair property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyPair().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeyPair }
         * 
         * 
         */
        public List<KeyPair> getKeyPair() {
            if (keyPair == null) {
                keyPair = new ArrayList<KeyPair>();
            }
            return this.keyPair;
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
         *         &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="second-major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="minor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="second-minor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "major",
            "secondMajor",
            "minor",
            "secondMinor"
        })
        public static class ProgramOfStudy {

            protected String major;
            @XmlElement(name = "second-major")
            protected String secondMajor;
            protected String minor;
            @XmlElement(name = "second-minor")
            protected String secondMinor;

            /**
             * Gets the value of the major property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMajor() {
                return major;
            }

            /**
             * Sets the value of the major property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMajor(String value) {
                this.major = value;
            }

            /**
             * Gets the value of the secondMajor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSecondMajor() {
                return secondMajor;
            }

            /**
             * Sets the value of the secondMajor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSecondMajor(String value) {
                this.secondMajor = value;
            }

            /**
             * Gets the value of the minor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMinor() {
                return minor;
            }

            /**
             * Sets the value of the minor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMinor(String value) {
                this.minor = value;
            }

            /**
             * Gets the value of the secondMinor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSecondMinor() {
                return secondMinor;
            }

            /**
             * Sets the value of the secondMinor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSecondMinor(String value) {
                this.secondMinor = value;
            }

        }

    }

}
