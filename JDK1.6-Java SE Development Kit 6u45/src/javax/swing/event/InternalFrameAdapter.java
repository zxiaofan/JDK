/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.event;

/**
 * An abstract adapter class for receiving internal frame events.
 * The methods in this class are empty. This class exists as
 * convenience for creating listener objects, and is functionally 
 * equivalent to the WindowAdapter class in the AWT.
 * <p>
 * See <a href="http://java.sun.com/docs/books/tutorial/uiswing/events/internalframelistener.html">How to Write an Internal Frame Listener</a>
 * in <em>The Java Tutorial</em> and
 * <a href="http://www.awl.com/cp/javaseries/jcl1_2.html">The Java Class Libraries (update)</a>
 *
 * @see InternalFrameEvent
 * @see InternalFrameListener
 * @see java.awt.event.WindowListener
 *
 * @version %I% %G%
 * @author Thomas Ball
 */
public abstract class InternalFrameAdapter implements InternalFrameListener {
    /**
     * Invoked when an internal frame has been opened.
     */
    public void internalFrameOpened(InternalFrameEvent e) {}

    /**
     * Invoked when an internal frame is in the process of being closed.
     * The close operation can be overridden at this point.
     */
    public void internalFrameClosing(InternalFrameEvent e) {}

    /**
     * Invoked when an internal frame has been closed.
     */
    public void internalFrameClosed(InternalFrameEvent e) {}

    /**
     * Invoked when an internal frame is iconified.
     */
    public void internalFrameIconified(InternalFrameEvent e) {}

    /**
     * Invoked when an internal frame is de-iconified.
     */
    public void internalFrameDeiconified(InternalFrameEvent e) {}

    /**
     * Invoked when an internal frame is activated.
     */
    public void internalFrameActivated(InternalFrameEvent e) {}

    /**
     * Invoked when an internal frame is de-activated.
     */
    public void internalFrameDeactivated(InternalFrameEvent e) {}
}
