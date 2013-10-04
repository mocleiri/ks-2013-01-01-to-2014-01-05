package edu.uw.kuali.student.myplan.util;

import org.kuali.student.r2.core.atp.dto.AtpInfo;

import java.util.Comparator;

/**
 * Sorts the AtpTypesInfo in order of terms in a academic calendar
 * User: Kamal
 * Date: 12/16/11
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class TermInfoComparator implements Comparator<AtpInfo> {

    @Override
    public int compare(AtpInfo o1, AtpInfo o2) {
        String atpKey1 = o1.getId().replaceAll("\\.", "_").toUpperCase();
        String atpKey2 = o2.getId().replaceAll("\\.", "_").toUpperCase();
        return TermOrder.valueOf(atpKey1).compareTo(TermOrder.valueOf(atpKey2));
    }

    private enum TermOrder {
        KUALI_ATP_TYPE_FALL,
        KUALI_ATP_TYPE_WINTER,
        KUALI_ATP_TYPE_SPRING,
        KUALI_ATP_TYPE_SUMMER
    }
}
