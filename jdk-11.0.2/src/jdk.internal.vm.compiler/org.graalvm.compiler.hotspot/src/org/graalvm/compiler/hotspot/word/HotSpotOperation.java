/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.word;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HotSpotOperation {

    enum HotspotOpcode {
        FROM_POINTER,
        TO_KLASS_POINTER,
        TO_METHOD_POINTER,
        POINTER_EQ,
        POINTER_NE,
        IS_NULL,
        READ_KLASS_POINTER
    }

    HotspotOpcode opcode();
}
