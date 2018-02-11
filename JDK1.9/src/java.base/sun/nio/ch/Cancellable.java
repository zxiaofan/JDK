/*
 * Copyright (c) 2008, 2009, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package sun.nio.ch;

/**
 * Implemented by asynchronous channels that require notification when an I/O
 * operation is cancelled.
 */

interface Cancellable {
    /**
     * Invoked to notify channel that cancel has been invoked while holding
     * the Future's lock.
     */
    void onCancel(PendingFuture<?,?> task);
}
