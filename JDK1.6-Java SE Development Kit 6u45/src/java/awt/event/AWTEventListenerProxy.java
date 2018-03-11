/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.event;

import java.util.EventListenerProxy;
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;

/**
 * A class which extends the <code>EventListenerProxy</code>, specifically 
 * for adding an <code>AWTEventListener</code> for a specific event mask.
 * Instances of this class can be added as <code>AWTEventListener</code>s to
 * a Toolkit object. 
 * <p>
 * The <code>getAWTEventListeners</code> method of Toolkit can 
 * return a mixture of <code>AWTEventListener</code> and
 * <code>AWTEventListenerProxy</code> objects.
 * 
 * @see java.awt.Toolkit
 * @see java.util.EventListenerProxy
 * @since 1.4
 */
public class AWTEventListenerProxy extends java.util.EventListenerProxy
        implements AWTEventListener {

    private long eventMask;

    /**
     * Constructor which binds the AWTEventListener to a specific
     * event mask.
     * 
     * @param listener The listener object
     * @param eventMask The bitmap of event types to receive
     */ 
    public AWTEventListenerProxy (long eventMask, 
            AWTEventListener listener) {
        super(listener);
        this.eventMask = eventMask;
    }

    /**
     * Forwards the property change event to the listener delegate.
     *
     * @param evt the property change event
     */
    public void eventDispatched(AWTEvent evt) {
        ((AWTEventListener)getListener()).eventDispatched(evt);
    }

    /**
     * Returns the event mask associated with the
     * listener.
     */
    public long getEventMask() {
        return eventMask;
    }
}
