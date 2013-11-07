package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;
import com.sigmasys.kuali.ksa.util.EnumUtils;

import javax.persistence.*;

/**
 * Fee management session log model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FM_SESSION_LOG")
public class FeeManagementSessionLog implements Identifiable {

    private Long id;

    private FeeManagementSession session;

    private String text;

    private FeeManagementSessionLogLevel logLevel;

    private String logLevelCode;


    @PostLoad
    protected void populateTransientFields() {
        logLevel = (logLevelCode != null) ? EnumUtils.findById(FeeManagementSessionLogLevel.class, logLevelCode) : null;
    }


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FM_SESSION_LOG",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FM_SESSION_LOG_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FM_SESSION_LOG")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FM_SESSION_ID_FK")
    public FeeManagementSession getSession() {
        return session;
    }

    public void setSession(FeeManagementSession session) {
        this.session = session;
    }

    @Column(name = "TEXT", length = 2000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "LEVEL_CODE", length = 10)
    protected String getLogLevelCode() {
        return logLevelCode;
    }

    protected void setLogLevelCode(String logLevelCode) {
        this.logLevelCode = logLevelCode;
        logLevel = EnumUtils.findById(FeeManagementSessionLogLevel.class, logLevelCode);
    }

    @Transient
    public FeeManagementSessionLogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(FeeManagementSessionLogLevel logLevel) {
        this.logLevel = logLevel;
        logLevelCode = logLevel.getId();
    }


}