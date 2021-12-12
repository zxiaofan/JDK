/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.services;

/**
 * Marker interface for methods which are called from the JVM.
 */
@interface VMEntryPoint {
    /**
     * An optional comment describing the caller.
     */
    String value() default "";
}
