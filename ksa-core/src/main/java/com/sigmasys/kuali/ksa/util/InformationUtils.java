package com.sigmasys.kuali.ksa.util;

import com.sigmasys.kuali.ksa.model.Information;
import com.sigmasys.kuali.ksa.model.Transaction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InformationUtils {

    public static List<Information> orderByEffectiveDate(List<Information> informations, boolean ascending) {
        return orderInformations(informations, new EffectiveDateComparator(), ascending);
    }

    private static List<Information> orderInformations(List<Information> informations,
                                                       Comparator<Information> comparator,
                                                       boolean ascending) {
        if (!ascending) {
            comparator = Collections.reverseOrder(comparator);
        }

        Collections.sort(informations, comparator);

        return informations;

    }




    // ------------- Private classes for internal usage -------------------------------------
    private static class EffectiveDateComparator implements Comparator<Information> {
        @Override
        public int compare(Information i1, Information i2) {
            return i1.getEffectiveDate().compareTo(i2.getEffectiveDate());
        }
    }


}
