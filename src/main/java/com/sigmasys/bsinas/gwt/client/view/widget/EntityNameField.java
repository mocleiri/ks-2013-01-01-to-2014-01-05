package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.sigmasys.bsinas.gwt.client.view.widget.value.EntityRefName;

/**
 *
 * @author Michael Ivanov
 */
public class EntityNameField extends TextField<EntityRefName> {

    public EntityNameField() {
        super();
        propertyEditor = new EntityNamePropertyEditor();
    }

    /* (non-Javadoc)
      * @see com.extjs.gxt.ui.client.widget.form.Field#getPropertyEditor()
      */
    public EntityNamePropertyEditor getPropertyEditor() {
        return (EntityNamePropertyEditor) propertyEditor;
    }

}
