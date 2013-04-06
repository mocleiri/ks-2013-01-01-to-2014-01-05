package com.sigmasys.kuali.ksa.model;


import javax.persistence.*;


// TODO:

/**
 * Cash limit event model.
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_CASH_LIMIT_EVENT")
public class CashLimitEvent extends AccountIdAware implements Identifiable {

    /**
     * The unique identifier
     */
    private Long id;


    /**
     * Entity ID
     */
    private String entityId;


    /**
     * Reference to XML document
     */
    private XmlDocument xml;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_CASH_LIMIT_EVENT",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "CASH_LIMIT_EVENT_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_CASH_LIMIT_EVENT")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public XmlDocument getXml() {
        return xml;
    }

    public void setXml(XmlDocument xml) {
        this.xml = xml;
    }

}
	


