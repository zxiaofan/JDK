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

import java.io.Closeable;

/**
 * Interface implemented by classes that provide an external visualization of selected object types
 * such as compiler graphs and nodes. The format and client required to consume the visualizations
 * is determined by the implementation. For example, a dumper may convert a compiler node to a human
 * readable string and print it to the console. A more sophisticated dumper may serialize a compiler
 * graph and send it over the network to a tool (e.g., https://github.com/graalvm/visualizer) that
 * can display graphs.
 */
public interface DebugDumpHandler extends Closeable, DebugHandler {

    /**
     * If the type of {@code object} is supported by this dumper, then a representation of
     * {@code object} is sent to some consumer in a format determined by this object.
     *
     * @param debug the debug context requesting the dump
     * @param object the object to be dumped
     * @param format a format string specifying a title that describes the context of the dump
     *            (e.g., the compiler phase in which request is made)
     * @param arguments arguments referenced by the format specifiers in {@code format}
     */
    void dump(DebugContext debug, Object object, String format, Object... arguments);

    /**
     * Flushes and releases resources managed by this dump handler. A subsequent call to
     * {@link #dump} will create and open new resources. That is, this method can be used to reset
     * the handler.
     */
    @Override
    default void close() {
    }
}
