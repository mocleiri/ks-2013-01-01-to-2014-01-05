package com.sigmasys.kuali.ksa.util;

/**
 * Collection of helpful methods to work with numbers.
 * User: Sergey
 * Date: 12/5/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberUtils {

    /**
     * Performs null-safe comparison of two Longs.
     *
     * @param l1 First Long to compare.
     * @param l2 Second Long to compare.
     * @return 0, 1 or -1.
     */
    public static int nullSafeCompare(Long l1, Long l2) {

        if ((l1 != null) && (l2 != null)) {
            return l1.compareTo(l2);
        } else if (l1 != null) {
            return 1;
        } else if (l2 != null) {
            return -1;
        } else { // both are null
            return 0;
        }
    }
}
