/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.server;

import com.sun.tools.javac.main.Main.Result;
import com.sun.tools.sjavac.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * An sjavac implementation that keeps track of idleness and shuts down the
 * given Terminable upon idleness timeout.
 *
 * An idleness timeout kicks in {@code idleTimeout} milliseconds after the last
 * request is completed.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class IdleResetSjavac implements Sjavac {

    private final Sjavac delegate;
    private final Terminable toShutdown;
    private final Timer idlenessTimer = new Timer();
    private final long idleTimeout;
    private int outstandingCalls = 0;

    // Class invariant: idlenessTimerTask != null <-> idlenessTimerTask is scheduled
    private TimerTask idlenessTimerTask;

    public IdleResetSjavac(Sjavac delegate,
                           Terminable toShutdown,
                           long idleTimeout) {
        this.delegate = delegate;
        this.toShutdown = toShutdown;
        this.idleTimeout = idleTimeout;
        scheduleTimeout();
    }

    @Override
    public Result compile(String[] args) {
        startCall();
        try {
            return delegate.compile(args);
        } finally {
            endCall();
        }
    }

    private synchronized void startCall() {
        // Was there no outstanding calls before this call?
        if (++outstandingCalls == 1) {
            // Then the timer task must have been scheduled
            if (idlenessTimerTask == null)
                throw new IllegalStateException("Idle timeout already cancelled");
            // Cancel timeout task
            idlenessTimerTask.cancel();
            idlenessTimerTask = null;
        }
    }

    private synchronized void endCall() {
        if (--outstandingCalls == 0) {
            // No more outstanding calls. Schedule timeout.
            scheduleTimeout();
        }
    }

    private void scheduleTimeout() {
        if (idlenessTimerTask != null)
            throw new IllegalStateException("Idle timeout already scheduled");
        idlenessTimerTask = new TimerTask() {
            public void run() {
                Log.setLogForCurrentThread(ServerMain.getErrorLog());
                toShutdown.shutdown("Server has been idle for " + (idleTimeout / 1000) + " seconds.");
            }
        };
        idlenessTimer.schedule(idlenessTimerTask, idleTimeout);
    }

    @Override
    public void shutdown() {
        idlenessTimer.cancel();
        delegate.shutdown();
    }

}
