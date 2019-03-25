/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements;

/**
 * Used to indicate that an otherwise strange looking code pattern is required to work around a bug
 * in javac.
 */
public @interface JavacBug {

    /**
     * A description of the bug. Only really useful if there is no existing entry for the bug in the
     * <a href="http://bugs.sun.com/bugdatabase/">Bug Database</a>.
     */
    String value() default "";

    /**
     * An identifier in the <a href="http://bugs.sun.com/bugdatabase/">Bug Database</a>.
     */
    int id() default 0;
}
