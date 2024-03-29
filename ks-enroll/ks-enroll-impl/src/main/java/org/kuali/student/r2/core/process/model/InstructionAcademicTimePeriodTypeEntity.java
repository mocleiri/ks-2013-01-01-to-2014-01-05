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
 * Created by Mezba Mahtab on 6/7/12
 */
package org.kuali.student.r2.core.process.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class represents the table KSEN_PROCESS_INSTRN_AAT
 *
 * @author Mezba Mahtab
 */

@Entity
@Table (name = "KSEN_PROCESS_INSTRN_AAT")
public class InstructionAcademicTimePeriodTypeEntity {

    ////////////////////
    // DATA FIELDS
    ////////////////////

    @Column(name = "PROCESS_INSTRN_ID", nullable = false)
    private String instructionId;

    @Column(name = "APPLD_ATP_TYPE", nullable = false)
    private String appliedAtpType;

    //////////////////////////
    // CONSTRUCTORS ETC.
    //////////////////////////

    public InstructionAcademicTimePeriodTypeEntity () {}

    ///////////////////////////
    // GETTERS AND SETTERS
    ///////////////////////////

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getAppliedAtpType() {
        return appliedAtpType;
    }

    public void setAppliedAtpType(String appliedAtpType) {
        this.appliedAtpType = appliedAtpType;
    }
}
