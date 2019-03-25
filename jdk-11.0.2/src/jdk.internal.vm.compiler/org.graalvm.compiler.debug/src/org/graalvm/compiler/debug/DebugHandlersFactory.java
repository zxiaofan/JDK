/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Iterator;
import java.util.List;

import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.serviceprovider.GraalServices;

/**
 * Factory for creating {@link DebugHandler}s.
 */
public interface DebugHandlersFactory {

    /**
     * Creates {@link DebugHandler}s based on {@code options}.
     *
     * @param options options to control type and name of the channel
     * @return list of debug handers that have been created
     */
    List<DebugHandler> createHandlers(OptionValues options);

    /**
     * Loads {@link DebugHandlersFactory}s on demand via {@link GraalServices#load(Class)}.
     */
    Iterable<DebugHandlersFactory> LOADER = new Iterable<DebugHandlersFactory>() {
        @Override
        public Iterator<DebugHandlersFactory> iterator() {
            return GraalServices.load(DebugHandlersFactory.class).iterator();
        }
    };
}
