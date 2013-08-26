package com.sigmasys.kuali.ksa.model;

/**
 * A transient class that encapsulates some additional information about account blocks.
 * <p/>
 *
 * @author Michael Ivanov
 */
public class AccountBlockDescriptor implements Identifiable {

    private Long accountBlockId;

    private boolean canBeOverridden;

    private String extendedInformation;

    public AccountBlockDescriptor() {
    }

    public AccountBlockDescriptor(Long accountBlockId, boolean canBeOverridden, String extendedInformation) {
        this.accountBlockId = accountBlockId;
        this.canBeOverridden = canBeOverridden;
        this.extendedInformation = extendedInformation;
    }

    @Override
    public Long getId() {
        return getAccountBlockId();
    }

    public Long getAccountBlockId() {
        return accountBlockId;
    }

    public void setAccountBlockId(Long accountBlockId) {
        this.accountBlockId = accountBlockId;
    }

    public boolean isCanBeOverridden() {
        return canBeOverridden;
    }

    public void setCanBeOverridden(boolean canBeOverridden) {
        this.canBeOverridden = canBeOverridden;
    }

    public String getExtendedInformation() {
        return extendedInformation;
    }

    public void setExtendedInformation(String extendedInformation) {
        this.extendedInformation = extendedInformation;
    }
}
