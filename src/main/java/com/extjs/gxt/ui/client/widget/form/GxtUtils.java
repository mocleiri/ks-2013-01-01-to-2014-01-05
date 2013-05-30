package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.core.El;

/**
 * GxtUtils allows access to some GXT-specific package scoped fields/methods
 *
 * @author Michael Ivanov
 */
public class GxtUtils {
    public static El getInputEl(Field<?> field) {
        return field.getInputEl();
    }
}
