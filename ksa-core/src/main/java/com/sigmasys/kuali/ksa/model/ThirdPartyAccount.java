package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;

/**
 * A third party account model.
 *
 * @author Michael Ivanov
 */
@Entity
@DiscriminatorValue(AccountTypeValue.THIRD_PARTY_CODE)
public class ThirdPartyAccount extends ChargeableAccount {


}

