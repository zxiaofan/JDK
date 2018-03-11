/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.beans;

import java.util.EventListenerProxy;

/**
 * A class which extends the <code>EventListenerProxy</code> specifically 
 * for associating a <code>VetoableChangeListener</code> with a "constrained"
 * property. Instances of this class can be added as a 
 * <code>VetoableChangeListener</code> to a bean which supports firing
 * VetoableChange events.
 * <p>
 * If the object has a <code>getVetoableChangeListeners()</code>
 * method then the array returned could be a mixture of 
 * <code>VetoableChangeListener</code> and
 * <code>VetoableChangeListenerProxy</code> objects.
 * <p>
 * @see java.util.EventListenerProxy
 * @see VetoableChangeListener
 * @see VetoableChangeSupport#getVetoableChangeListeners
 * @since 1.4
 */
public class VetoableChangeListenerProxy extends EventListenerProxy
        implements VetoableChangeListener {
    
    private String propertyName;

    /**
    * @param propertyName The name of the property to listen on.
    * @param listener The listener object
    */ 
    public VetoableChangeListenerProxy(String propertyName,
            VetoableChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
    }

    /**
    * Forwards the property change event to the listener delegate.
    *
    * @param evt the property change event
    *
    * @exception PropertyVetoException if the recipient wishes the property
    *              change to be rolled back.
    */
    public void vetoableChange(PropertyChangeEvent evt) throws
            PropertyVetoException{
        ((VetoableChangeListener)getListener()).vetoableChange(evt);
    }

    /**
    * Returns the name of the named property associated with the
    * listener.
    */
    public String getPropertyName() {
        return propertyName;
    }
}
