/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Objects;
import java.util.function.Consumer;

/**
 * An asynchronous event which is triggered only once from the selector manager
 * thread as soon as event registration are handled.
 */
final class AsyncTriggerEvent extends AsyncEvent{

    private final Runnable trigger;
    private final Consumer<? super IOException> errorHandler;
    AsyncTriggerEvent(Consumer<? super IOException> errorHandler,
                      Runnable trigger) {
        super(0);
        this.trigger = Objects.requireNonNull(trigger);
        this.errorHandler = Objects.requireNonNull(errorHandler);
    }
    /** Returns null */
    @Override
    public SelectableChannel channel() { return null; }
    /** Returns 0 */
    @Override
    public int interestOps() { return 0; }
    @Override
    public void handle() { trigger.run(); }
    @Override
    public void abort(IOException ioe) { errorHandler.accept(ioe); }
    @Override
    public boolean repeating() { return false; }
}
