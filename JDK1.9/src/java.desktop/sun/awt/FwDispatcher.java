/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.awt.*;

/**
 * An interface for the EventQueue delegate.
 * This class is added to support JavaFX/AWT interop single threaded mode
 * The delegate should be set in EventQueue by {@link EventQueue#setFwDispatcher(FwDispatcher)}
 * If the delegate is not null, than it handles supported methods instead of the
 * event queue. If it is null than the behaviour of an event queue does not change.
 *
 * @see EventQueue
 *
 * @author Petr Pchelko
 *
 * @since 1.8
 */
public interface FwDispatcher {
    /**
     * Delegates the {@link EventQueue#isDispatchThread()} method
     */
    boolean isDispatchThread();

    /**
     * Forwards a runnable to the delegate, which executes it on an appropriate thread.
     * @param r a runnable calling {@link EventQueue#dispatchEventImpl(java.awt.AWTEvent, Object)}
     */
    void scheduleDispatch(Runnable r);

    /**
     * Delegates the {@link java.awt.EventQueue#createSecondaryLoop()} method
     */
    SecondaryLoop createSecondaryLoop();
}
