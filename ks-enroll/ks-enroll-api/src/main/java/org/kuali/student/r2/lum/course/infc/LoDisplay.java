package org.kuali.student.r2.lum.course.infc;

import org.kuali.student.lum.lo.dto.LoCategoryInfo;
import org.kuali.student.lum.lo.dto.LoInfo;
import org.kuali.student.r2.common.infc.IdEntity;
import org.kuali.student.r2.lum.lo.infc.Lo;
import org.kuali.student.r2.lum.lo.infc.LoCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class //TODO ...
 *
 * @author Kuali Student Team
 */
public interface LoDisplay extends IdEntity {

    /**
     * Detailed information about a learning objective
     */
    public Lo getLoInfo() ;


    /**
     * List of Lo Display information. (info and child relations
     */
    public List<? extends LoDisplay> getLoDisplayInfoList() ;


    /**
     * Unique identifier for the LO to LO relation type.
     */
    public String getParentRelType() ;


    /**
     * Unique identifier for a LO to LO relationship.
     */
    public String getParentLoRelationid();


    /**
     * List of learning objective category information.
     */
    public List<? extends LoCategory> getLoCategoryInfoList();


}
