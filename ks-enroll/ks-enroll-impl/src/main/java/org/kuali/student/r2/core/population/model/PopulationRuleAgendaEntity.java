/**
 * Copyright 2012 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * Created by Mezba Mahtab on 7/12/12
 */
package org.kuali.student.r2.core.population.model;

import org.kuali.student.r2.common.entity.MetaEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class maps the relationship between population rule and agegnda (KRMS)
 *
 * @author Kuali Student Team
 */
@Entity
@Table(name = "KSEN_POPULATION_RULE_AGENDA")
public class PopulationRuleAgendaEntity extends MetaEntity {

    ////////////////////
    // DATA FIELDS
    ////////////////////

    @Column(name = "POPULATION_RULE_ID", nullable = false)
    private String populationRuleId;

    @Column(name = "AGENDA_ID", nullable = false)
    private String agendaId;

    ////////////////////
    // CONSTRUCTOR
    ////////////////////

    public PopulationRuleAgendaEntity () {}

    //////////////////////////
    // GETTERS AND SETTERS
    //////////////////////////

    public String getPopulationRuleId() {
        return populationRuleId;
    }

    public void setPopulationRuleId(String populationRuleId) {
        this.populationRuleId = populationRuleId;
    }

    public String getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(String agendaId) {
        this.agendaId = agendaId;
    }
}
