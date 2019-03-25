/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

/**
 * Performs some kind of verification on an object.
 */
public interface DebugVerifyHandler extends DebugHandler {

    /**
     * Verifies that a given object satisfies some invariants.
     *
     * @param object object to verify
     * @param debug the debug context requesting the dump
     * @param format a format string specifying a title that describes the context of the
     *            verification (e.g., the compiler phase in which request is made)
     * @param arguments arguments referenced by the format specifiers in {@code format}
     */
    void verify(DebugContext debug, Object object, String format, Object... arguments);
}
