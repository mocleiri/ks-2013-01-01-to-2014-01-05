package com.sigmasys.kuali.ksa.model;

/**
 * KSA Account type value enum.
 * It is used to distinguish different KSA account types in the KSA code and UI forms
 *
 * @author Michael Ivanov
 */
public enum AccountTypeValue implements Identifiable {

    DIRECT_CHARGE(AccountTypeValue.DIRECT_CHARGE_CODE),
    DELEGATE(AccountTypeValue.DELEGATE_CODE);

    public static final String DIRECT_CHARGE_CODE = "ACD";
    public static final String DELEGATE_CODE = "AND";

    private String id;

    private AccountTypeValue(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case DIRECT_CHARGE:
                return "Chargeable";
            case DELEGATE:
                return "Delegate";
        }
        throw new IllegalStateException("No account type found for " + name() + " value");
    }
}
