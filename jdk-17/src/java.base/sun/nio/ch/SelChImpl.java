/*
 * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.channels.Channel;
import java.io.FileDescriptor;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * An interface that allows translation (and more!).
 *
 * @since 1.4
 */

public interface SelChImpl extends Channel {

    FileDescriptor getFD();

    int getFDVal();

    /**
     * Adds the specified ops if present in interestOps. The specified
     * ops are turned on without affecting the other ops.
     *
     * @return  true iff the new value of sk.readyOps() set by this method
     *          contains at least one bit that the previous value did not
     *          contain
     */
    boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl ski);

    /**
     * Sets the specified ops if present in interestOps. The specified
     * ops are turned on, and all other ops are turned off.
     *
     * @return  true iff the new value of sk.readyOps() set by this method
     *          contains at least one bit that the previous value did not
     *          contain
     */
    boolean translateAndSetReadyOps(int ops, SelectionKeyImpl ski);

    /**
     * Translates an interest operation set into a native event set
     */
    int translateInterestOps(int ops);

    void kill() throws IOException;

    /**
     * Disables the current thread for scheduling purposes until this
     * channel is ready for I/O, or asynchronously closed, for up to the
     * specified waiting time.
     *
     * <p> This method does <em>not</em> report which of these caused the
     * method to return. Callers should re-check the conditions which caused
     * the thread to park.
     *
     * @param event the event to poll
     * @param nanos the timeout to wait; {@code <= 0} to wait indefinitely
     */
    default void park(int event, long nanos) throws IOException {
        long millis;
        if (nanos <= 0) {
            millis = -1;
        } else {
            millis = NANOSECONDS.toMillis(nanos);
        }
        Net.poll(getFD(), event, millis);
    }

    /**
     * Disables the current thread for scheduling purposes until this
     * channel is ready for I/O, or asynchronously closed.
     *
     * <p> This method does <em>not</em> report which of these caused the
     * method to return. Callers should re-check the conditions which caused
     * the thread to park.
     *
     * @param event the event to poll
     */
    default void park(int event) throws IOException {
        park(event, 0L);
    }

}
