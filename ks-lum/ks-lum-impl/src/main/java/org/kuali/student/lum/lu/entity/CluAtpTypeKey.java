/**
 * Copyright 2010 The Kuali Foundation Licensed under the
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
 */

package org.kuali.student.lum.lu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.kuali.student.common.entity.BaseEntity;

/**
 * This is a description of what this class does - Rich don't forget to fill this in. 
 * 
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 *
 */
@Entity
@Table(name = "KSLU_CLU_ATP_TYPE_KEY")
public class CluAtpTypeKey extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "CLU_ID")
    private Clu clu;
    
    @Column(name = "ATP_TYPE_KEY")
    private String atpTypeKey;
    
    public String getAtpTypeKey() {
        return atpTypeKey;
    }

    public void setAtpTypeKey(String atpTypeKey) {
        this.atpTypeKey = atpTypeKey;
    }
    
	public Clu getClu() {
		return clu;
	}

	public void setClu(Clu clu) {
		this.clu = clu;
	}
}
