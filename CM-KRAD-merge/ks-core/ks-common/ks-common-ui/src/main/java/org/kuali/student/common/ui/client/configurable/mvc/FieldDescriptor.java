/**
 * Copyright 2010 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.common.ui.client.configurable.mvc;


import org.kuali.student.common.ui.client.application.Application;
import org.kuali.student.common.ui.client.configurable.mvc.binding.ModelWidgetBinding;
import org.kuali.student.common.ui.client.configurable.mvc.binding.MultiplicityCompositeBinding;
import org.kuali.student.common.ui.client.configurable.mvc.multiplicity.MultiplicityComposite;
import org.kuali.student.common.ui.client.mvc.Callback;
import org.kuali.student.common.ui.client.mvc.HasCrossConstraints;
import org.kuali.student.common.ui.client.mvc.HasDataValue;
import org.kuali.student.common.ui.client.widgets.KSCheckBox;
import org.kuali.student.common.ui.client.widgets.KSTextBox;
import org.kuali.student.common.ui.client.widgets.RichTextEditor;
import org.kuali.student.common.ui.client.widgets.field.layout.element.FieldElement;
import org.kuali.student.common.ui.client.widgets.field.layout.element.MessageKeyInfo;
import org.kuali.student.common.ui.client.widgets.list.KSSelectItemWidgetAbstract;
import org.kuali.student.r1.common.assembly.data.Metadata;
import org.kuali.student.r1.common.assembly.data.MetadataInterrogator;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a field descriptor that defines ui fields.
 * A field descriptor is defined by its fieldKey and its metadata, the field key is the key that is used
 * to identify it during validation and save processing and maps directly to a field which exists in the
 * model definition for the model it relates to.  The fieldKey must match something within the model to
 * be a valid field.  <br>The metadata is its piece of information in the model definition which is used to
 * generate the field's widget and determine what the validation on this field is (also if this field
 * is backed by a search it will use the lookup metadata defined in its metadata to generate the appropriate
 * search widget).  It also determines if a requiredness indicator appears (constraint minOccurs > 1).
 * <br><br>
 * A field descriptor can be fully customized to any need, the widget can be chosen to be
 * defined directly instead of using one that is auto generated by the metadata - if this is done make sure
 * the data type it is using works with what is in the metadata and that it implements one of these standard 
 * interfaces:<br>
 * HasText<br>
 * KSSelectItemWidgetAbstract<br>
 * HasDataValue<br>
 * HasValue<br>
 * or, you MUST override the ModelWidgetBinding by calling setModelWidgetBinding
 * <br>
 * Setting the ModelWidgetBinding allows you to manipulate the widget's data and model data as you see fit
 * before a save when model data is loaded into the widget.
 * <br>
 * <br>
 * General layout of a field generated by FieldDescriptor, all elements are conditional based on the field's
 * configuration: <br>
 * <b>[label][requiredness indicator][help]<br>
 * [input widget]<br>
 * [constraint text]<br></b>
 * <br>
 * The messageKeyInfo passed in is used to generate the messages needed for a field these include:<br>
 * Field Label<br>
 * Help text<br>
 * Instructions<br>
 * Example text<br>
 * Constraint text<br>
 * Watermark text - only if the widget one that accepts text input<br><br>
 * These are generated by a single key, the additional text is determined by special suffixes on keys within
 * the messages data - example - you pass in "sampleField" for the message key - it is automatically determined
 * that if there is a message in the message data named "sampleField-instruct", instructions will be added to the field
 * in the appropriate location.<br>
 * List of the appended keys for use in messages data:<br>
 * "-help" for help text<br>
 * "-instruct" for instructions<br>
 * "-examples" for examples<br>
 * "-constraints" for constraint text<br>
 * "-watermark" for watermark text<br>
 * 
 * @author Kuali Student Team
 * @see FieldElement
 * @see Section
 * @see BaseSection
 * @see Configurer
 */
public class FieldDescriptor {
    protected String fieldKey;
	protected Metadata metadata;
    @SuppressWarnings("unchecked")
	private ModelWidgetBinding modelWidgetBinding;
    private Callback<Boolean> validationRequestCallback;
    private boolean dirty = false;
    private boolean hasHadFocus = false;
    private final FieldElement fieldElement;
    private String modelId;
    private MessageKeyInfo messageKey;
    private boolean optional = false;
    private boolean ignoreShowRequired = false; 

    /**
     * @param fieldKey - key for this field which matches a field in the overall model definition that this
     * field will be used for
     * @param messageKey - key object used for determing field labels
     * @param metadata - metadata used to determine requiredness, validation, and autogenerated widget
     */
    public FieldDescriptor(String fieldKey, MessageKeyInfo messageKey, Metadata metadata) {
    	this.fieldKey = fieldKey;
    	this.metadata = metadata;
    	if(messageKey == null){
    		messageKey = new MessageKeyInfo("");
    	}
    	setMessageKey(messageKey);
    	fieldElement = new FieldElement(fieldKey, messageKey, createFieldWidget(), metadata);
    	setupField();
    	
    	//Add mapping from path to field definition
    	if((getFieldWidget() instanceof HasDataValue || getFieldWidget() instanceof KSTextBox || getFieldWidget() instanceof HasValue)&&!(this instanceof FieldDescriptorReadOnly)){
    		Application.getApplicationContext().putPathToFieldMapping(null, Application.getApplicationContext().getParentPath()+fieldKey, this);
		}

    	//Add cross constraints
    	if(fieldElement.getFieldWidget() instanceof HasCrossConstraints){
    		HasCrossConstraints crossConstraintWidget = (HasCrossConstraints) fieldElement.getFieldWidget();
    		if(crossConstraintWidget!=null&&crossConstraintWidget.getCrossConstraints()!=null){
    			for(String path:crossConstraintWidget.getCrossConstraints()){
    		    	Application.getApplicationContext().putCrossConstraint(null, path, crossConstraintWidget);
    			}
    		}
    	}
    }

    /**
     * @param fieldKey - key for this field which matches a field in the overall model definition that this
     * field will be used for
     * @param messageKey - key object used for determing field labels
     * @param metadata - metadata used to determine requiredness and validation
     * @param fieldWidget - widget to use instead of an automatically determined one
     */
    public FieldDescriptor(String fieldKey, MessageKeyInfo messageKey, Metadata metadata, Widget fieldWidget){
    	this.fieldKey = fieldKey;
    	this.metadata = metadata;
    	if(messageKey == null){
    		messageKey = new MessageKeyInfo("");
    	}
        setMessageKey(messageKey);
    	addStyleToWidget(fieldWidget);
    	fieldElement = new FieldElement(fieldKey, messageKey, fieldWidget, metadata);
        setupField();
    	
    	//Add mapping from path to field definition if the definition has a data value
    	if((fieldWidget instanceof HasDataValue || fieldWidget instanceof KSTextBox) &&!(this instanceof FieldDescriptorReadOnly)){
    		Application.getApplicationContext().putPathToFieldMapping(null, Application.getApplicationContext().getParentPath()+fieldKey, this);
		}
    	
    	//Add cross constraints
    	if(fieldElement.getFieldWidget() instanceof HasCrossConstraints){
    		HasCrossConstraints crossConstraintWidget = (HasCrossConstraints) fieldElement.getFieldWidget();
    		if(crossConstraintWidget!=null&&crossConstraintWidget.getCrossConstraints()!=null){
    			for(String path:crossConstraintWidget.getCrossConstraints()){
    		    	Application.getApplicationContext().putCrossConstraint(null, path, crossConstraintWidget);
    			}
    		}
    	}
    	
    }

    protected void addStyleToWidget(Widget w){
    	if(fieldKey != null && !fieldKey.isEmpty() && w != null){
    		String style = this.fieldKey.replaceAll("/", "-");
    		w.addStyleName(style);
    	}
    }

    protected void setupField() {
    	if(metadata != null){
    		if(MetadataInterrogator.isRequired(metadata)){
    			fieldElement.setRequiredString("requiredMarker", "ks-form-module-elements-required");
    		}
    		else if(MetadataInterrogator.isRequiredForNextState(metadata)){
    			String nextState = MetadataInterrogator.getNextState(metadata);
    			if(nextState != null){
    				if(nextState.equalsIgnoreCase("SUBMITTED")){
    					fieldElement.setRequiredString("requiredOnSubmit", "ks-form-required-for-submit");
    				}
    				else if(nextState.equalsIgnoreCase("APPROVED")){
    					fieldElement.setRequiredString("reqApproval", "ks-form-required-for-submit");
    				}
					else if(nextState.equalsIgnoreCase("ACTIVE")){
						fieldElement.setRequiredString("reqActivate", "ks-form-required-for-submit");
    				}
					else if(nextState.equalsIgnoreCase("SUSPENDED")){
						fieldElement.setRequiredString("reqDeactivate", "ks-form-required-for-submit");
					}
					else if(nextState.equalsIgnoreCase("RETIRED")){
                        fieldElement.setRequiredString("requiredOnSubmit", "ks-form-required-for-submit");
                    }
					else {
						fieldElement.setRequiredString("requiredOnSubmit", "ks-form-required-for-submit");
					}

    			}
    		} else{
                fieldElement.clearRequiredText();
            }
    	}
    }

    /**
     * @see FieldElement#hideLabel()
     */
    public void hideLabel(){
    	fieldElement.hideLabel();
    }

    public boolean isLabelShown(){
    	return fieldElement.isLabelShown();
    }

    public FieldElement getFieldElement(){
    	return fieldElement;
    }

	public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

    public String getFieldLabel() {
        return fieldElement.getFieldName();
    }

    public Widget getFieldWidget(){
        if (fieldElement.getFieldWidget() == null){
            Widget w = createFieldWidget();
            fieldElement.setWidget(w);
        }
        return fieldElement.getFieldWidget();
    }

    protected Widget createFieldWidget() {
    	if (metadata == null) {
    		// backwards compatibility for old ModelDTO code
	    	// for now, default to textbox if not specified
	    	Widget result = new KSTextBox();
	    	addStyleToWidget(result);
	    	return result;
    	} else {
    		Widget result = DefaultWidgetFactory.getInstance().getWidget(this);
    		addStyleToWidget(result);
    		return result;
    	}
    }

    public ModelWidgetBinding<?> getModelWidgetBinding() {
        if(modelWidgetBinding == null){
            if(fieldElement.getFieldWidget() instanceof RichTextEditor){
            	modelWidgetBinding = org.kuali.student.common.ui.client.configurable.mvc.binding.RichTextBinding.INSTANCE;
            } else if (fieldElement.getFieldWidget() instanceof KSCheckBox){
            	modelWidgetBinding = org.kuali.student.common.ui.client.configurable.mvc.binding.HasValueBinding.INSTANCE;
            } else if(fieldElement.getFieldWidget() instanceof MultiplicityComposite){
        		modelWidgetBinding = MultiplicityCompositeBinding.INSTANCE;
        	} else if (fieldElement.getFieldWidget()instanceof HasText) {
        	    modelWidgetBinding = org.kuali.student.common.ui.client.configurable.mvc.binding.HasTextBinding.INSTANCE;
            } else if (fieldElement.getFieldWidget() instanceof KSSelectItemWidgetAbstract){
                modelWidgetBinding = org.kuali.student.common.ui.client.configurable.mvc.binding.SelectItemWidgetBinding.INSTANCE;
            } else if (fieldElement.getFieldWidget() instanceof HasDataValue){
            	modelWidgetBinding = org.kuali.student.common.ui.client.configurable.mvc.binding.HasDataValueBinding.INSTANCE;
            } else if (fieldElement.getFieldWidget() instanceof HasValue){
            	modelWidgetBinding = org.kuali.student.common.ui.client.configurable.mvc.binding.HasValueBinding.INSTANCE;
            }
        }
        return modelWidgetBinding;
    }

    /**
     * Allows additional processing to happen when a validation check is being processed when the input
     * widget loses focus defined in the callback
     * @param callback
     */
    public void setValidationCallBack(Callback<Boolean> callback){
        validationRequestCallback = callback;
    }

    public Callback<Boolean> getValidationRequestCallback(){
        return validationRequestCallback;
    }

	/**
	 * Returns true if this field is marked as dirty.  In KS, dirty is when the field has been changed
	 * in some way - however not completely accurate
	 * @return
	 */
	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	/**
	 * Return true if the field has been touched by the user in some fashion, this is set by the field's section
	 * @return
	 */
	public boolean hasHadFocus() {
		return hasHadFocus;
	}

	public void setHasHadFocus(boolean hasHadFocus) {
		this.hasHadFocus = hasHadFocus;
	}

    public Metadata getMetadata() {
		return metadata;
	}

    public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
        setupField();
	}

    public void setFieldWidget(Widget fieldWidget) {
		this.fieldElement.setWidget(fieldWidget);
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

    /**
     * Sets the ModelWidgetBinding for this field.  Changing this changes the way data from the server and
     * passed to the server is processed with the widget.  Set this when some special processing or handling
     * has to happen with the data in either phase.
     * @param widgetBinding
     */
    public void setWidgetBinding(ModelWidgetBinding widgetBinding) {
        this.modelWidgetBinding = widgetBinding;
    }

    public MessageKeyInfo getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(MessageKeyInfo messageKey) {
        this.messageKey = messageKey;
    }

	/**
	 * Sets the optional flag
	 * Fields that are optional should not be displayed if there is no data in some cases,
	 * it is up to the section implementation whether or not to honor this flag
	 * @param optional
	 */
	public void setOptional(boolean optional){
		this.optional = optional;
	}

	/**
	 * Fields that are optional should not be displayed if there is no data in some cases,
	 * it is up to the section implementation whether or not to honor this flag
	 */
	public boolean isOptional(){
		return optional;
	}

	/**
	 * @return true if this field is visible to the user
	 */
	public boolean isVisible() {
		if (metadata != null){
			return metadata.isCanView();
		} else {
			return true;
		}
	}

	/**
	 * Reset the requiredness of the field descriptor. Note doing this will also dynamically change
	 * the underlying metadata so ui validation for requiredness works as well.
	 * 
	 */
	public void setRequired(Boolean isRequired){ 
		fieldElement.setRequiredString("requiredMarker", "ks-form-module-elements-required");
		fieldElement.setRequired(isRequired);
		
		//FIXME: This could be problematic if minOccurs should be something other than 1
		if (isRequired){
			getMetadata().getConstraints().get(0).setMinOccurs(1);
		} else {
			getMetadata().getConstraints().get(0).setMinOccurs(0);
		}
	}

    public boolean isIgnoreShowRequired() {
        return ignoreShowRequired;
    }

    public void setIgnoreShowRequired(boolean ignoreShowRequired) {
        this.ignoreShowRequired = ignoreShowRequired;
    }
	
}
