/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.beans;

/**
 * A class which extends the <code>EventListenerProxy</code> specifically 
 * for adding a named <code>PropertyChangeListener</code>. Instances of
 * this class can be added as <code>PropertyChangeListener</code> to
 * an object. 
 * <p>
 * If the object has a <code>getPropertyChangeListeners()</code>
 * method then the array returned could be a mixture of 
 * <code>PropertyChangeListener</code> and
 * <code>PropertyChangeListenerProxy</code> objects.
 * 
 * @see java.util.EventListenerProxy
 * @since 1.4
 */
public class PropertyChangeListenerProxy extends java.util.EventListenerProxy
        implements PropertyChangeListener {

    private String propertyName;

    /**
     * Constructor which binds the PropertyChangeListener to a specific
     * property.
     * 
     * @param listener The listener object
     * @param propertyName The name of the property to listen on.
     */ 
    public PropertyChangeListenerProxy(String propertyName, 
            PropertyChangeListener listener) {
        // XXX - msd NOTE: I changed the order of the arguments so that it's
        // similar to PropertyChangeSupport.addPropertyChangeListener(String,
        // PropertyChangeListener);
        super(listener);
        this.propertyName = propertyName;
    }

    /**
     * Forwards the property change event to the listener delegate.
     *
     * @param evt the property change event
     */
    public void propertyChange(PropertyChangeEvent evt) {
        ((PropertyChangeListener)getListener()).propertyChange(evt);
    }

    /**
     * Returns the name of the named property associated with the
     * listener.
     */
    public String getPropertyName() {
        return propertyName;
    }
}
