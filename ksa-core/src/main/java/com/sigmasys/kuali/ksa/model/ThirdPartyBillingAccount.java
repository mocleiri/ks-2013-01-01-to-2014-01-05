package com.sigmasys.kuali.ksa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * A third party billing account
 *
 * @author Michael Ivanov
 */
@Entity
@DiscriminatorValue(AccountTypeValue.THIRD_PARTY_BILLING_CODE)
public class ThirdPartyBillingAccount extends ChargeableAccount {


}

