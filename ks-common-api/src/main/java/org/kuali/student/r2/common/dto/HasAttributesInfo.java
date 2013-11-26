/*
 * Copyright 2010 The Kuali Foundation 
 *
 * Licensed under the Educational Community License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kuali.student.r2.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.kuali.student.r2.common.infc.Attribute;
import org.kuali.student.r2.common.infc.HasAttributes;

/**
 * Information about a entities with attributes.
 *
 * @author tom
 */

@SuppressWarnings("serial")
@XmlTransient
public abstract class HasAttributesInfo 
    implements HasAttributes, Serializable {

    @XmlElement
    private List<AttributeInfo> attributes;


    /**
     * Constructs a new HasAttributesInfo.
     */
    public HasAttributesInfo() {
    }
    
    /**
     * Constructs a new HasAttributesInfo from another HasAttributes.
     *
     * @param hasAttrs the HasAttributes to copy
     */
    public HasAttributesInfo(HasAttributes hasAttrs) {
        if (null != hasAttrs) {
            if (null != hasAttrs.getAttributes()) {
                attributes = new ArrayList<AttributeInfo>();
                for (Attribute attr : hasAttrs.getAttributes()) {
                    attributes.add(new AttributeInfo(attr));
                }
            }
        }
    }
    
    @Override
    public List<AttributeInfo> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<AttributeInfo>();
        }
        return attributes;
    }
    
    public void setAttributes(List<AttributeInfo> attributes) {
        this.attributes = attributes;
    }


    public String getAttributeValue(String key) {
        if(attributes != null){
            for (AttributeInfo attr: attributes) {
                if(attr.getKey().equals(key)) {
                    return attr.getValue();
                }
            }
        }
        return null;
    }

    public List<String> getAttributeValueList(String key) {
        List<String> results = new ArrayList<String>();
        if(attributes != null){
            for (AttributeInfo attr: attributes) {
                if(attr.getKey().equals(key)) {
                    results.add(attr.getValue());
                }
            }
        }
        return results;
    }

    /**
     * This replaces all existing attributes with the matching key
     * with a single new attribute.
     * It will reuse the element if it exists.
     * @param key
     * @param value
     */
    public void setAttributeValue(String key, String value) {
        AttributeInfo attributeInfo = null;

        //Clear the list of old attributes with that key
        for(Iterator<AttributeInfo> iter = getAttributes().iterator();iter.hasNext();){
            AttributeInfo attr = iter.next();
            if(attr.getKey().equals(key)) {
                attributeInfo = attr;
                iter.remove();
            }
        }

        //If the attribute key existed, just update the value so we can reuse ids
        if(attributeInfo == null){
            attributeInfo = new AttributeInfo(key,value);
        }else{
            attributeInfo.setValue(value);
        }

        //Add the new value back to the list
        attributes.add(attributeInfo);
    }

    /**
     * This replaces all existing attributes with the matching key
     * with the new list of attribute values
     * It reuses ids and elements as much as it can.
     * @param key
     * @param values
     */
    public void setAttributeValueList(String key, List<String> values) {

        List<AttributeInfo> existingAttributes = new ArrayList<AttributeInfo>();

        //Clear the list of old attributes with given key
        for(Iterator<AttributeInfo> iter = getAttributes().iterator();iter.hasNext();){
            AttributeInfo attributeInfo = iter.next();
            if(attributeInfo.getKey().equals(key)) {
                existingAttributes.add(attributeInfo);
                iter.remove();
            }
        }

        //Add the new values reusing what objects we can
        Iterator<AttributeInfo> iter = existingAttributes.iterator();
        AttributeInfo attributeInfo;

        for(String value:values){
            if(iter.hasNext()){
                attributeInfo = iter.next();
                attributeInfo.setValue(value);
            }else{
                attributeInfo = new AttributeInfo(key,value);
            }
            attributes.add(attributeInfo);
        }
    }

}
