package org.kuali.student.common.dto;

public class DtoConstants {
 
    public final static String STATE_DRAFT = "Draft"; 
    public final static String STATE_SUBMITTED = "Submitted";
    public final static String STATE_WITHDRAWN = "Withdrawn";
    public final static String STATE_APPROVED = "Approved";
    public final static String STATE_NOT_APPROVED = "Not Approved";
    public final static String STATE_ACTIVE = "Active";
    public final static String STATE_INACTIVE = "Inactive";
    public final static String STATE_SUPERSEDED  = "Superseded";
    public final static String STATE_SUSPENDED  = "Suspended";
    public final static String STATE_RETIRED = "Retired";

	
	public static final String DTO_STATE = "DtoState";
	public static final String DTO_NEXT_STATE = "DtoNextState"; 

	//FIXME: Need to split out proposal states (ie. workflow states) versus dto states
	public enum DtoState {
		DRAFT, SUBMITTED, APPROVED, ACTIVE, INACTIVE, RETIRED, SUPERSEDED, SAVED, ENROUTE;

		public boolean equalsString(String state){
			if (state != null){
				return this.toString().equals(state.toUpperCase());
			}
			
			return false;
		}
		
		/**
	     * This is used to determine the next state.
	     * 
	     * TODO: Ideally this method should not be hardcoded here.  Also determining next state may
	     * be a more complicated and not just be a simple sequence.
	     * 
	     * @param state
	     * @return the next state
	     */
		public static DtoState getNextState(String state){
			// Element States
			if (DRAFT.equalsString(state)) {
	            return SUBMITTED;
	        } else if (SUBMITTED.equalsString(state)) {
	            return APPROVED;
	        } else if (APPROVED.equalsString(state)) {
	        	return ACTIVE;
	        } else if (ACTIVE.equalsString(state)) {
	        	return INACTIVE;
	        } else if (INACTIVE.equalsString(state)) {
	        	return RETIRED;
	        
	        // Proposal States
	        } else if (SAVED.equalsString(state)) {
	        	return ENROUTE;
	        } else if (ENROUTE.equalsString(state)) {
	        	return APPROVED;
	        }
					
			
			return null;
		}
		
		public static String getNextStateAsString(String state){
			DtoState dtoState = getNextState(state);
			if (dtoState == null){
				return null;
			} else {
				return dtoState.toString();
			}
		}
	}
}
