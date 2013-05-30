/**
 *
 */
package com.sigmasys.bsinas.gwt.client.service.validator;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern. Holds multiple validators.
 *
 * @author Michael Ivanov
 */
public class FormatValidators implements Validator {

    private List<Validator> validators = new ArrayList<Validator>();

    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    public void removeValidator(Validator validator) {
        validators.remove(validator);
    }

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.Validator#validate(com.extjs.gxt.ui.client.widget.form.Field, java.lang.String)
      */
    public String validate(Field<?> field, String value) {
        for (Validator validator : validators) {
            String result = validator.validate(field, value);
            if (result != null) {
                return result; // return error message
            }
        }
        return null;
    }

}