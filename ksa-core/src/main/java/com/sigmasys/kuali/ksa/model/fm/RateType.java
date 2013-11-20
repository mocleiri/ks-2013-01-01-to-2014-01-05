package com.sigmasys.kuali.ksa.model.fm;

import com.sigmasys.kuali.ksa.model.AuditableEntity;
import com.sigmasys.kuali.ksa.model.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Rate type.
 * <p/>
 *
 * @author Michael Ivanov
 */
@Entity
@Table(name = "KSSA_RATE_TYPE")
@AttributeOverride(name = "code", column = @Column(name = "CODE", length = 100, nullable = false, unique = true))
public class RateType extends AuditableEntity<Long> {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GenericGenerator(name = Constants.ID_GENERATOR_NAME, strategy = Constants.ID_GENERATOR_CLASS)
    @GeneratedValue(generator = Constants.ID_GENERATOR_NAME)
    @Override
    public Long getId() {
        return id;
    }

}
