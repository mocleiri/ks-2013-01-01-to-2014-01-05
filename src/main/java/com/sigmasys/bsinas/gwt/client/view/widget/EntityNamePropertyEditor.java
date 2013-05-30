package com.sigmasys.bsinas.gwt.client.view.widget;


import com.sigmasys.bsinas.gwt.client.view.widget.value.EntityRefName;

/**
 * Converts EntityRefName to String and back.
 *
 * @author Michael Ivanov
 */
public class EntityNamePropertyEditor extends AbstractStringPropertyEditor<EntityRefName> {

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.PropertyEditor#convertStringValue(java.lang.String)
      */
    public EntityRefName convertStringValue(String value) {
        return new EntityRefName(value);
    }

}
