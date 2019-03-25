/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.io.IOException;
import java.nio.channels.SelectableChannel;

/**
 * Event handling interface from HttpClientImpl's selector.
 *
 * If REPEATING is set then the event is not cancelled after being posted.
 */
abstract class AsyncEvent {

    public static final int REPEATING = 0x2; // one off event if not set

    protected final int flags;

    AsyncEvent() {
        this(0);
    }

    AsyncEvent(int flags) {
        this.flags = flags;
    }

    /** Returns the channel */
    public abstract SelectableChannel channel();

    /** Returns the selector interest op flags OR'd */
    public abstract int interestOps();

    /** Called when event occurs */
    public abstract void handle();

    /**
     * Called when an error occurs during registration, or when the selector has
     * been shut down. Aborts all exchanges.
     *
     * @param ioe  the IOException, or null
     */
    public abstract void abort(IOException ioe);

    public boolean repeating() {
        return (flags & REPEATING) != 0;
    }
}
