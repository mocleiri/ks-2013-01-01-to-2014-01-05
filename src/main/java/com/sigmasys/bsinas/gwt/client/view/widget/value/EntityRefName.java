package com.sigmasys.bsinas.gwt.client.view.widget.value;

/**
 * Passing EntityRefName as a parameter in SearchCriteria will result in hql like this one:
 * <code> upper(exception0_.ACNT_ID) like upper('a%')
 * or upper(exception0_.ACNT_ID) like upper(' %b')</code>
 * All '*' are replaced with '%' in hql predicate.
 *
 * @author Michael Ivanov
 */
public class EntityRefName extends StringValue {

    public EntityRefName() {
        super();
    }

    public EntityRefName(String value) {
        super(value);
    }
}
