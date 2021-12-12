/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.event;

import java.util.EventListener;

/**
 * The listener interface for receiving internal frame events.
 * This class is functionally equivalent to the WindowListener class
 * in the AWT.
 * <p>
 * See <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/internalframelistener.html">How to Write an Internal Frame Listener</a>
 * in <em>The Java Tutorial</em> for further documentation.
 *
 * @see java.awt.event.WindowListener
 *
 * @author Thomas Ball
 */
public interface InternalFrameListener extends EventListener {
    /**
     * Invoked when a internal frame has been opened.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#show
     */
    public void internalFrameOpened(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is in the process of being closed.
     * The close operation can be overridden at this point.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#setDefaultCloseOperation
     */
    public void internalFrameClosing(InternalFrameEvent e);

    /**
     * Invoked when an internal frame has been closed.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#setClosed
     */
    public void internalFrameClosed(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is iconified.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#setIcon
     */
    public void internalFrameIconified(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is de-iconified.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#setIcon
     */
    public void internalFrameDeiconified(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is activated.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#setSelected
     */
    public void internalFrameActivated(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is de-activated.
     *
     * @param e an {@code InternalFrameEvent} with information about the
     *          {@code JInteralFrame} that originated the event
     * @see javax.swing.JInternalFrame#setSelected
     */
    public void internalFrameDeactivated(InternalFrameEvent e);
}
