package org.kuali.student.myplan.sampleplan.dataobject;

/**
 * Created with IntelliJ IDEA.
 * User: hemanthg
 * Date: 11/7/13
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SamplePlanItem {
    private String code;
    private String credit;
    private String note;
    private String planItemId;
    private String alternateCode;
    private String alternateCredit;
    private String alternatePlanItemId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAlternateCode() {
        return alternateCode;
    }

    public void setAlternateCode(String alternateCode) {
        this.alternateCode = alternateCode;
    }

    public String getAlternateCredit() {
        return alternateCredit;
    }

    public void setAlternateCredit(String alternateCredit) {
        this.alternateCredit = alternateCredit;
    }

    public String getPlanItemId() {
        return planItemId;
    }

    public void setPlanItemId(String planItemId) {
        this.planItemId = planItemId;
    }

    public String getAlternatePlanItemId() {
        return alternatePlanItemId;
    }

    public void setAlternatePlanItemId(String alternatePlanItemId) {
        this.alternatePlanItemId = alternatePlanItemId;
    }
}