package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;

import javax.persistence.*;

/**
 * Rate Catalog ATP model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_CATALOG_ATP")
public class RateCatalogAtp implements Identifiable {


    private Long id;

    private String atpId;

    private RateCatalog rateCatalog;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_RATE_CATALOG_ATP",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "RATE_CATALOG_ATP_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_RATE_CATALOG_ATP")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ATP_ID", length = 45)
    public String getAtpId() {
        return atpId;
    }

    public void setAtpId(String atpId) {
        this.atpId = atpId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RATE_CATALOG_ID_FK")
    public RateCatalog getRateCatalog() {
        return rateCatalog;
    }

    public void setRateCatalog(RateCatalog rateCatalog) {
        this.rateCatalog = rateCatalog;
    }
}
