package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.Identifiable;

import javax.persistence.*;

/**
 * Fee management signup rate model.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_FM_SIGNUP_RATE")
public class FeeManagementSignupRate implements Identifiable {

    private Long id;

    private FeeManagementSignup signup;

    private String rateCode;


    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @TableGenerator(name = "TABLE_GEN_FM_SIGNUP_RATE",
            table = "KSSA_SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "FM_SIGNUP_RATE_SEQ")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_FM_SIGNUP_RATE")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FM_SIGNUP_ID_FK")
    public FeeManagementSignup getSignup() {
        return signup;
    }

    public void setSignup(FeeManagementSignup signup) {
        this.signup = signup;
    }

    @Column(name = "RATE_CODE", length = 45, nullable = false)
    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }
}
