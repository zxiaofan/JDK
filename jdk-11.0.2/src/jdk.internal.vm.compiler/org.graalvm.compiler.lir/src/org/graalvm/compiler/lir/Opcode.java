/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Denotes an opcode name for an annotated {@link LIRInstruction}.
 * <p>
 * Note: Unlike the other LIR related annotations declared as inner classes of
 * {@link LIRInstruction}, this annotation is in a top level file to work around a
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=409824">bug</a> in Eclipse causing
 * spurious warnings about unused imports.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Opcode {

    String value() default "";
}
