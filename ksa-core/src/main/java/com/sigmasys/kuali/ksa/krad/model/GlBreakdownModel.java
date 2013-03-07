package com.sigmasys.kuali.ksa.krad.model;

import com.sigmasys.kuali.ksa.krad.util.HighPrecisionPercentageFormatter;
import com.sigmasys.kuali.ksa.model.GlBreakdown;

import java.math.BigDecimal;


public class GlBreakdownModel {

    private GlBreakdown parentBreakdown;

    // Theoretically it is possible to get KRAD to validate the breakdown without
    // converting it to a string here and to use this formatter directly in the XML view
    // This current implementation is more complicated than it needs to be but the hope is
    // that this whole class can go away and use the facilities of KRAD directly.
    private HighPrecisionPercentageFormatter formatter = new HighPrecisionPercentageFormatter();

    public GlBreakdown getParentBreakdown() {
        return parentBreakdown;
    }

    public void setParentBreakdown(GlBreakdown parentBreakdown) {
        this.parentBreakdown = parentBreakdown;
    }

    public String getBreakdownString(){
        if(parentBreakdown == null){
            return null;
        }
        return (String)formatter.format(parentBreakdown.getBreakdown());
    }

    public void setBreakdownString(String str){
        if(parentBreakdown == null){
            //Ack!
        } else {
            BigDecimal dec = (BigDecimal)formatter.convertToObject(str);
            parentBreakdown.setBreakdown(dec);
        }
    }
}
