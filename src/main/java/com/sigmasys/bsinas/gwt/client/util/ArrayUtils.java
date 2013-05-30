package com.sigmasys.bsinas.gwt.client.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayUtils.
 * It is supposed to be used on the GWT client side.
 *
 * @author Michael Ivanov
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    public static <T> boolean contains(T[] array, T item) {
        for (T elem : array) {
            if (elem.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T[] addAll(T[] array1, T[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("ArrayUtils::addAll: None of the arguments can be null");
        }
        List<T> result = new ArrayList<T>(array1.length + array2.length);
        result.addAll(Arrays.asList(array1));
        result.addAll(Arrays.asList(array2));
        return result.toArray(array1);
    }
}
