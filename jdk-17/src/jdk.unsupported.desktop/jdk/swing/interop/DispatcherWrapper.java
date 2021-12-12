/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.swing.interop;

import java.awt.SecondaryLoop;
import java.awt.EventQueue;
import sun.awt.FwDispatcher;
import sun.awt.AWTAccessor;

/**
 * This class provides a wrapper over inner class DispatcherProxy
 * which implements jdk internal sun.awt.FwDispatcher interface
 * and provides APIs to be used by FX swing interop to access and use
 * FwDispatcher APIs.
 *
 * @since 11
 */
public abstract class DispatcherWrapper {
    private DispatcherProxy fwd;

    public DispatcherWrapper() {
        fwd = new DispatcherProxy();
    }

    public abstract boolean isDispatchThread();

    public abstract void scheduleDispatch(Runnable r);

    public abstract SecondaryLoop createSecondaryLoop();

    public static void setFwDispatcher(EventQueue eventQueue, DispatcherWrapper dispatcher) {
        AWTAccessor.getEventQueueAccessor().setFwDispatcher(eventQueue, dispatcher.fwd);
    }

    private class DispatcherProxy implements FwDispatcher {

        @Override
        public boolean isDispatchThread() {
            return DispatcherWrapper.this.isDispatchThread();
        }

        @Override
        public void scheduleDispatch(Runnable r) {
            DispatcherWrapper.this.scheduleDispatch(r);
        }

        @Override
        public SecondaryLoop createSecondaryLoop() {
            return DispatcherWrapper.this.createSecondaryLoop();
        }
    }
}
