/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * An {@link AutoCloseable} whose {@link #close()} does not throw a checked exception.
 */
public interface DebugCloseable extends AutoCloseable {

    DebugCloseable VOID_CLOSEABLE = new DebugCloseable() {

        @Override
        public void close() {
        }
    };

    /**
     * Gets the debug context associated with this object.
     */
    default DebugContext getDebug() {
        return null;
    }

    @Override
    void close();
}
