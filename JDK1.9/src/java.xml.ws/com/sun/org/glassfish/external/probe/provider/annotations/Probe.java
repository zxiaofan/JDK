/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */



package com.sun.org.glassfish.external.probe.provider.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 *
 * @author Prashanth Abbagani
 *         Date: April 16, 2009
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Probe {

    public String name() default "";
    public boolean hidden() default false;
    public boolean self() default false;
    public String providerName() default "";
    public String moduleName() default "";
    public boolean stateful() default false;
    public String profileNames() default "";
    public boolean statefulReturn() default false;
    public boolean statefulException() default false;
}
