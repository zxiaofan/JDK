/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.serviceprovider;

import java.util.List;

/* This class lives in the "base" project even if it is only useful for JDK9
 * because javac only links against classes from the "base".
 */

/**
 * Access to thread specific information made available via Java Management Extensions (JMX). Using
 * this abstraction enables avoiding a dependency to the {@code java.management} and
 * {@code jdk.management} modules on JDK 9 and later.
 */
public abstract class JMXService {
    protected abstract long getThreadAllocatedBytes(long id);

    protected abstract long getCurrentThreadCpuTime();

    protected abstract boolean isThreadAllocatedMemorySupported();

    protected abstract boolean isCurrentThreadCpuTimeSupported();

    protected abstract List<String> getInputArguments();

    // Placing this static field in JMXService (instead of GraalServices)
    // allows for lazy initialization.
    static final JMXService instance = GraalServices.loadSingle(JMXService.class, false);
}
