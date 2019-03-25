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


package org.graalvm.compiler.core;

import java.util.concurrent.ThreadFactory;

/**
 * Facility for creating {@linkplain CompilerThread compiler threads}.
 */
public class CompilerThreadFactory implements ThreadFactory {

    protected final String threadNamePrefix;

    public CompilerThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new CompilerThread(r, threadNamePrefix);
    }
}
