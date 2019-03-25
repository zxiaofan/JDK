/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import org.graalvm.compiler.core.common.CancellationBailoutException;

/**
 * An interface for supporting co-operative cancellation of tasks. An external entity gives a
 * Cancellable to a task and the task polls the Cancellable at regular intervals. If
 * {@link #isCancelled} returns true, then the task will promptly terminate by means of throwing a
 * {@link CancellationBailoutException}.
 */
public interface Cancellable {
    boolean isCancelled();
}
