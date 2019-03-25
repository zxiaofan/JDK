/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.alloc.trace.lsra;

import jdk.vm.ci.meta.AllocatableValue;

/**
 * An interval that is a hint for an {@code TraceInterval interval}.
 */
abstract class IntervalHint {

    public abstract AllocatableValue location();

    public abstract int from();

    public abstract String logString();
}
