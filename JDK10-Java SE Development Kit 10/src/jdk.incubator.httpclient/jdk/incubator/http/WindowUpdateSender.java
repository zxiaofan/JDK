/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.System.Logger.Level;
import jdk.incubator.http.internal.frame.SettingsFrame;
import jdk.incubator.http.internal.frame.WindowUpdateFrame;
import jdk.incubator.http.internal.common.Utils;

import java.util.concurrent.atomic.AtomicInteger;

abstract class WindowUpdateSender {

    final static boolean DEBUG = Utils.DEBUG;
    final System.Logger debug =
            Utils.getDebugLogger(this::dbgString, DEBUG);

    final int limit;
    final Http2Connection connection;
    final AtomicInteger received = new AtomicInteger(0);

    WindowUpdateSender(Http2Connection connection) {
        this(connection, connection.clientSettings.getParameter(SettingsFrame.INITIAL_WINDOW_SIZE));
    }

    WindowUpdateSender(Http2Connection connection, int initWindowSize) {
        this(connection, connection.getMaxReceiveFrameSize(), initWindowSize);
    }

    WindowUpdateSender(Http2Connection connection, int maxFrameSize, int initWindowSize) {
        this.connection = connection;
        int v0 = Math.max(0, initWindowSize - maxFrameSize);
        int v1 = (initWindowSize + (maxFrameSize - 1)) / maxFrameSize;
        v1 = v1 * maxFrameSize / 2;
        // send WindowUpdate heuristic:
        // - we got data near half of window size
        //   or
        // - remaining window size reached max frame size.
        limit = Math.min(v0, v1);
        debug.log(Level.DEBUG, "maxFrameSize=%d, initWindowSize=%d, limit=%d",
                maxFrameSize, initWindowSize, limit);
    }

    abstract int getStreamId();

    void update(int delta) {
        debug.log(Level.DEBUG, "update: %d", delta);
        if (received.addAndGet(delta) > limit) {
            synchronized (this) {
                int tosend = received.get();
                if( tosend > limit) {
                    received.getAndAdd(-tosend);
                    sendWindowUpdate(tosend);
                }
            }
        }
    }

    void sendWindowUpdate(int delta) {
        debug.log(Level.DEBUG, "sending window update: %d", delta);
        connection.sendUnorderedFrame(new WindowUpdateFrame(getStreamId(), delta));
    }

    String dbgString() {
        return "WindowUpdateSender(stream: " + getStreamId() + ")";
    }

}
