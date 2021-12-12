/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.event;

import java.util.EventListener;

/**
 * The listener interface for receiving {@code WindowEvents}, including
 * {@code WINDOW_GAINED_FOCUS} and {@code WINDOW_LOST_FOCUS} events.
 * The class that is interested in processing a {@code WindowEvent}
 * either implements this interface (and
 * all the methods it contains) or extends the abstract
 * {@code WindowAdapter} class (overriding only the methods of interest).
 * The listener object created from that class is then registered with a
 * {@code Window}
 * using the {@code Window}'s {@code addWindowFocusListener} method.
 * When the {@code Window}'s
 * status changes by virtue of it being opened, closed, activated, deactivated,
 * iconified, or deiconified, or by focus being transferred into or out of the
 * {@code Window}, the relevant method in the listener object is invoked,
 * and the {@code WindowEvent} is passed to it.
 *
 * @author David Mendenhall
 *
 * @see WindowAdapter
 * @see WindowEvent
 * @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/windowlistener.html">Tutorial: Writing a Window Listener</a>
 *
 * @since 1.4
 */
public interface WindowFocusListener extends EventListener {

    /**
     * Invoked when the Window is set to be the focused Window, which means
     * that the Window, or one of its subcomponents, will receive keyboard
     * events.
     * @param e the event to be processed
     */
    public void windowGainedFocus(WindowEvent e);

    /**
     * Invoked when the Window is no longer the focused Window, which means
     * that keyboard events will no longer be delivered to the Window or any of
     * its subcomponents.
     * @param e the event to be processed
     */
    public void windowLostFocus(WindowEvent e);
}
