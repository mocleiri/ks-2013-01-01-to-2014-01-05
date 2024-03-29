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

package org.kuali.student.common.ui.client.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.kuali.student.common.messages.dto.Message;
import org.kuali.student.common.ui.client.configurable.mvc.FieldDescriptor;
import org.kuali.student.common.ui.client.mvc.HasCrossConstraints;
import org.kuali.student.common.ui.client.security.SecurityContext;
import org.kuali.student.common.ui.client.service.ServerPropertiesRpcService;
import org.kuali.student.common.ui.client.service.ServerPropertiesRpcServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The application contains information about who is currently logged in, the security context, and access
 * to messages loaded from the message service in the app.  It provides and a static way to obtain this
 * information across the entire app.
 * 
 * @author Kuali Student
 *
 */
public class ApplicationContext {
	private ServerPropertiesRpcServiceAsync serverPropertiesRpcService = GWT.create(ServerPropertiesRpcService.class);
	
	private boolean loggedIn = true;
	private String userId = "testuser";
	private String version = "KS";
	private List<String> roles = new ArrayList<String>();
	
	private Map<String, Map<String, String>> messages = new HashMap<String, Map<String,String>>();
	private Map<String, String> flatMessages = new HashMap<String, String>();
	private List<Message> messagesList = new ArrayList<Message>();
	
	private SecurityContext securityContext;
	private String applicationContextUrl;
	
	//These maps are used to store query paths to their corresponding fieldDefinitions, and also whcih fields have cross constraints
	private String parentPath = "";
	private HashMap<String,HashMap<String,FieldDescriptor>> pathToFieldMapping = new HashMap<String,HashMap<String,FieldDescriptor>>();
	private HashMap<String,HashMap<String,HashSet<HasCrossConstraints>>> crossConstraints = new HashMap<String,HashMap<String,HashSet<HasCrossConstraints>>>();
//	private HashMap<String,HashMap<FieldDescriptor, String>> defaultValueMapping = new HashMap<String,HashMap<FieldDescriptor, String>>();
	/**
	 * This constructor should only be visible to the common application package. If ApplicationContext is 
	 * required outside this package do Application.getApplicationContext();
	 */
	protected ApplicationContext() {
		roles.add("role1");
		roles.add("role2");
		
		serverPropertiesRpcService.getContextPath(new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				throw new RuntimeException("Fatal - Unable to initialze application context");
			}

			@Override
			public void onSuccess(String result) {
				applicationContextUrl = result;
			}			
		});
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getUserId() {
		return userId;
	}

	public List<String> getRoles() {
		return roles;
	}

    /**
     * Adds the messages in the list of messages to the map of the messages
     * @param messages
     */
    public void addMessages(List<Message> messages) {
		messagesList.addAll(messages);
	    for (Message m : messages) {
	        String groupName = m.getGroupName();
	        Map<String, String> group = this.messages.get(groupName);
	        if (group == null) {
	            group = new HashMap<String, String>();
	            this.messages.put(groupName, group);
	        }
	        group.put(m.getId(), m.getValue());
	        flatMessages.put(m.getId(), m.getValue());
	    }
	}
	
	/**
	 * Get a message by a unique id
	 */
	public String getMessage(String messageId) {
	    return flatMessages.get(messageId);
    }
    
	/**
	 * Returns all the messages in the ApplicationContext
	 */
	public List<Message> getMessages() {
	    return messagesList;
    }
    
	
	/**
	 * Get message by the group it is in and its unique id within that group
	 */
	public String getMessage(String groupName, String messageId) {
			
	    String result = null;
	    
	    Map<String, String> group = this.messages.get(groupName);
	    if (group != null) {
	        result = group.get(messageId);
	    }
	    
	    return result;
	}
	
    /**
     * 
     * This method looks up a UI Label in the messages cache.  
     * First looks for a label specific to the type and state of the field.
     * If none found try for a generalized label.
     * Otherwise return the supplied fieldId
     * Groups provide namespace for same label ids within different LUs
     * 
     * @param groupName - for example 'course' or 'program'
     * @param type
     * @param state
     * @param fieldId
     * @return
     */
	 public String getUILabel(String groupName, String type, String state, String fieldId) {

        String label = getMessage(groupName, type + ":" + state + ":" + fieldId);
        
        if (label == null)
            label = getMessage(groupName, fieldId);
        
        if (label == null)
            label =  fieldId;
        
        return label;
        
    }
	 
	/**
	 * Same as getUILabel(String groupName, String type, String state, String fieldId) with no
	 * type and state needed
	 */
	public String getUILabel(String groupName, String fieldId) {

	        String label = getMessage(groupName, fieldId);
	        
	        if (label == null)
	            label =  fieldId;
	        
	        return label;
	        
	}

    /**
     * Get the security context for the app
     * @return SecurityContext
     */
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }
	
	/**
	 * Application URL based on the serverPropertiesRPC service result
	 */
	public String getApplicationContextUrl() {
		return applicationContextUrl;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}
	
	/**
	 * Adds a mapping from path to a list of field descriptors for a given namespace
	 * namespace defaults to _default if null
	 * @param path
	 * @param fd
	 */
	public void putCrossConstraint(String namespace, String path, HasCrossConstraints fd){
		if(namespace==null){
			namespace="_default";
		}
		
		HashMap<String,HashSet<HasCrossConstraints>> crossConstraintMap = crossConstraints.get(namespace);
		if(crossConstraintMap==null){
			crossConstraintMap = new HashMap<String,HashSet<HasCrossConstraints>>();
			crossConstraints.put(namespace, crossConstraintMap);
		}
		HashSet<HasCrossConstraints> fieldDescriptors = crossConstraintMap.get(path);
		if(fieldDescriptors == null){
			fieldDescriptors = new HashSet<HasCrossConstraints>();
			crossConstraintMap.put(path, fieldDescriptors);
		}
		fieldDescriptors.add(fd);
	}

	
	
	public HashSet<HasCrossConstraints> getCrossConstraint(String namespace, String path){
		if(namespace==null){
			namespace="_default";
		}
		HashMap<String,HashSet<HasCrossConstraints>> crossConstraintMap = crossConstraints.get(namespace);
		if(crossConstraintMap!=null){
			return crossConstraintMap.get(path);
		}
		return null;
	}
	public void clearCrossConstraintMap(String namespace){
		if(namespace==null){
			namespace="_default";
		}
		crossConstraints.remove(namespace);
	}
	public void putPathToFieldMapping(String namespace, String path, FieldDescriptor fd){
		if(namespace==null){
			namespace="_default";
		}
		
		HashMap<String,FieldDescriptor> pathToField = pathToFieldMapping.get(namespace);
		if(pathToField==null){
			pathToField = new HashMap<String,FieldDescriptor>();
			pathToFieldMapping.put(namespace, pathToField);
		}
		pathToField.put(path, fd);
	}

	public FieldDescriptor getPathToFieldMapping(String namespace, String path){
		if(namespace==null){
			namespace="_default";
		}
		
		HashMap<String,FieldDescriptor> pathToField = pathToFieldMapping.get(namespace);
		if(pathToField!=null){
			return pathToField.get(path);
		}
		return null;
	}
	public void clearPathToFieldMapping(String namespace){
		if(namespace==null){
			namespace="_default";
		}
		pathToFieldMapping.remove(namespace);
	}

	/**
	 * Removes the bidirectional mapping for all paths that start with the path prefix
	 * This means if Field A had a dependency on Field B, and you cleared A, first all mappings with
	 * dependencies to A would be removed, then all mappings with dependencies to A would be removed. 
	 * @param namespace
	 * @param pathPrefix
	 */
	public void clearCrossConstraintsWithStartingPath(String namespace, String pathPrefix){
		if(namespace==null){
			namespace="_default";
		}
		//First delete any cross constraint mappings based on this field
		HashMap<String,HashSet<HasCrossConstraints>> crossConstraintMap = crossConstraints.get(namespace);
		if(crossConstraintMap!=null){
			Iterator<Map.Entry<String,HashSet<HasCrossConstraints>>> constraintMapIter = crossConstraintMap.entrySet().iterator();
			while(constraintMapIter.hasNext()){
				Map.Entry<String,HashSet<HasCrossConstraints>> entry = constraintMapIter.next();
				if(entry.getKey().startsWith(pathPrefix)){
					constraintMapIter.remove();
				}
			}

			//Find all the fieldDescriptors that start with the prefix and remove the cross constraint mapping to them 
			HashMap<String,FieldDescriptor> pathToField = pathToFieldMapping.get(namespace);
			if(pathToField!=null){
				Iterator<Entry<String, FieldDescriptor>> pathMapIter = pathToField.entrySet().iterator();
				while(pathMapIter.hasNext()){
					Entry<String, FieldDescriptor> entry = pathMapIter.next();
					if(entry.getKey().startsWith(pathPrefix)){
						FieldDescriptor fd = entry.getValue();
						if(fd.getFieldWidget()!=null && fd.getFieldWidget() instanceof HasCrossConstraints && ((HasCrossConstraints)fd.getFieldWidget()).getCrossConstraints()!=null){
							//Loop through the constraint paths and remove any mapping to the existing field descriptor
							for(String path:((HasCrossConstraints)fd.getFieldWidget()).getCrossConstraints()){
								HashSet<HasCrossConstraints> set = crossConstraintMap.get(path);
								if(set!=null){
									set.remove(fd.getFieldWidget());
								}
							}
						}
					}
				}
			}
		}
	}

	
	public HashSet<HasCrossConstraints> getCrossConstraints(String namespace) {
		if(namespace==null){
			namespace="_default";
		}
		HashSet<HasCrossConstraints> results = new HashSet<HasCrossConstraints>();
		HashMap<String,HashSet<HasCrossConstraints>> crossConstraintMap = crossConstraints.get(namespace);
		if(crossConstraintMap!=null){
			for(HashSet<HasCrossConstraints> fds: crossConstraintMap.values()){
				results.addAll(fds);
			}
		}
		return results;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

//	public void putDefaultValueMapping(String namespace,
//			FieldDescriptor fieldDescriptor, String defaultValuePath) {
//		if(namespace==null){
//			namespace="_default";
//		}
//		HashMap<FieldDescriptor, String> defaultValueMap = defaultValueMapping.get(namespace);
//		if(defaultValueMap==null){
//			defaultValueMap = new HashMap<FieldDescriptor, String>();
//			defaultValueMapping.put(namespace, defaultValueMap);
//		}
//		defaultValueMap.put(fieldDescriptor, defaultValuePath);
//	}
//
//	public HashMap<FieldDescriptor, String> getDefaultValueMapping(String namespace) {
//		if(namespace==null){
//			namespace="_default";
//		}
//		HashMap<FieldDescriptor, String> result = defaultValueMapping.get(namespace);
//		if(result==null){
//			result = new HashMap<FieldDescriptor, String>();
//		}
//		return result;
//	}
//	public void clearDefaultValueMapping(String namespace){
//		if(namespace==null){
//			namespace="_default";
//		}
//		defaultValueMapping.remove(namespace);
//	}

}
