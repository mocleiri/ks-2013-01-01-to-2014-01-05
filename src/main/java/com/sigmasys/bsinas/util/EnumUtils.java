package com.sigmasys.bsinas.util;

import com.sigmasys.bsinas.model.Identifiable;

import java.io.Serializable;
import java.util.EnumSet;

/**
 * EnumUtils
 *
 * @author Michael Ivanov
 */

public class EnumUtils {

    private EnumUtils() {
    }

    public static <T extends Enum<T>> T findById(Class<T> enumType, Serializable id) {
        if (id != null) {
            for (T item : EnumSet.allOf(enumType)) {
                if (item instanceof Identifiable) {
                    if (((Identifiable) item).getId().equals(id)) {
                        return item;
                    }
                }
            }
        }
        return null;
    }

}
