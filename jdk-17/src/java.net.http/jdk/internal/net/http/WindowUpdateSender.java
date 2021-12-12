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

import jdk.internal.net.http.common.FlowTube;
import jdk.internal.net.http.common.Logger;
import jdk.internal.net.http.frame.SettingsFrame;
import jdk.internal.net.http.frame.WindowUpdateFrame;
import jdk.internal.net.http.common.Utils;
import java.util.concurrent.atomic.AtomicInteger;

abstract class WindowUpdateSender {

    final Logger debug =
            Utils.getDebugLogger(this::dbgString, Utils.DEBUG);

    final int limit;
    final Http2Connection connection;
    final AtomicInteger received = new AtomicInteger();

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
        if (debug.on())
            debug.log("maxFrameSize=%d, initWindowSize=%d, limit=%d",
                      maxFrameSize, initWindowSize, limit);
    }

    abstract int getStreamId();

    void update(int delta) {
        int rcv = received.addAndGet(delta);
        if (debug.on()) debug.log("update: %d, received: %d, limit: %d", delta, rcv, limit);
        if (rcv > limit) {
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
        if (debug.on()) debug.log("sending window update: %d", delta);
        connection.sendUnorderedFrame(new WindowUpdateFrame(getStreamId(), delta));
    }

    volatile String dbgString;
    String dbgString() {
        String dbg = dbgString;
        if (dbg != null) return dbg;
        FlowTube tube = connection.connection.getConnectionFlow();
        if (tube == null) {
            return "WindowUpdateSender(stream: " + getStreamId() + ")";
        } else {
            int streamId = getStreamId();
            dbg = connection.dbgString() + ":WindowUpdateSender(stream: " + streamId + ")";
            return streamId == 0 ? dbg : (dbgString = dbg);
        }
    }

}
