/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.nio.channels.SelectableChannel;

/**
 * Event handling interface from HttpClientImpl's selector.
 *
 * If BLOCKING is set, then the channel will be put in blocking
 * mode prior to handle() being called. If false, then it remains non-blocking.
 *
 * If REPEATING is set then the event is not cancelled after being posted.
 */
abstract class AsyncEvent {

    public static final int BLOCKING = 0x1; // non blocking if not set
    public static final int REPEATING = 0x2; // one off event if not set

    protected final int flags;

    AsyncEvent(int flags) {
        this.flags = flags;
    }

    /** Returns the channel */
    public abstract SelectableChannel channel();

    /** Returns the selector interest op flags OR'd */
    public abstract int interestOps();

    /** Called when event occurs */
    public abstract void handle();

    /** Called when selector is shutting down. Abort all exchanges. */
    public abstract void abort();

    public boolean blocking() {
        return (flags & BLOCKING) != 0;
    }

    public boolean repeating() {
        return (flags & REPEATING) != 0;
    }
}
