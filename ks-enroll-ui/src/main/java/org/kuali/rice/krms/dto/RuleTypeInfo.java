package org.kuali.rice.krms.dto;

/**
 * Created with IntelliJ IDEA.
 * User: danie
 * Date: 3/12/13
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class RuleTypeInfo {

    private String id;
    private String name;
    private String description;
    private String type;
    private String instruction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
