package com.sigmasys.bsinas.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ProxyEntity {

    boolean value() default true;

}
