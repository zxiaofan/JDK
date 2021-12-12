/*
 * Copyright (c) 1998, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.misc;

/**
 * This is the signal handler interface expected in <code>Signal.handle</code>.
 *
 * @author   Sheng Liang
 * @author   Bill Shannon
 * @see      sun.misc.Signal
 * @since    1.2
 */

public interface SignalHandler {

    /**
     * The default signal handler
     */
    public static final SignalHandler SIG_DFL =
            new Signal.SunMiscHandler(null, jdk.internal.misc.Signal.Handler.SIG_DFL);
    /**
     * Ignore the signal
     */
    public static final SignalHandler SIG_IGN =
            new Signal.SunMiscHandler(null, jdk.internal.misc.Signal.Handler.SIG_IGN);

    /**
     * Handle the given signal
     *
     * @param sig a signal object
     */
    public void handle(Signal sig);
}
