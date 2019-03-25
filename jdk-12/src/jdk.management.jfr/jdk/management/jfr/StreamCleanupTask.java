/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.management.jfr;

import java.util.TimerTask;

final class StreamCleanupTask extends TimerTask {

    private final Stream stream;
    private final StreamManager manager;

    StreamCleanupTask(StreamManager streamManager, Stream stream) {
        this.stream = stream;
        this.manager = streamManager;
    }

    @Override
    public void run() {
        long lastTouched = stream.getLastTouched();
        long now = System.currentTimeMillis();
        if (now - lastTouched >= StreamManager.TIME_OUT) {
            manager.destroy(stream);
        } else {
            manager.scheduleAbort(stream, lastTouched + StreamManager.TIME_OUT);
        }
    }
}
