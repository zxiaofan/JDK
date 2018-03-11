/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.beans;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This is a utility class that can be used by beans that support constrained
 * properties.  You can use an instance of this class as a member field
 * of your bean and delegate various work to it.
 *
 * This class is serializable.  When it is serialized it will save
 * (and restore) any listeners that are themselves serializable.  Any
 * non-serializable listeners will be skipped during serialization.
 */

public class VetoableChangeSupport implements java.io.Serializable {

    /**
     * Constructs a <code>VetoableChangeSupport</code> object.
     *
     * @param sourceBean  The bean to be given as the source for any events.
     */

    public VetoableChangeSupport(Object sourceBean) {
	if (sourceBean == null) {
	    throw new NullPointerException();
	}
	source = sourceBean;
    }

    /**
     * Add a VetoableListener to the listener list.
     * The listener is registered for all properties.
     * The same listener object may be added more than once, and will be called
     * as many times as it is added.
     * If <code>listener</code> is null, no exception is thrown and no action
     * is taken.
     *
     * @param listener  The VetoableChangeListener to be added
     */

    public synchronized void addVetoableChangeListener(
					VetoableChangeListener listener) {
        if (listener == null) {
            return;
        }
        if (listener instanceof VetoableChangeListenerProxy) {
            VetoableChangeListenerProxy proxy =
                    (VetoableChangeListenerProxy)listener;
            // Call two argument add method.
            addVetoableChangeListener(proxy.getPropertyName(),
                    (VetoableChangeListener)proxy.getListener());
        } else {
            if (listeners == null) {
                listeners = new java.util.Vector();
            }
        }
        listeners.addElement(listener);
    }

    /**
     * Remove a VetoableChangeListener from the listener list.
     * This removes a VetoableChangeListener that was registered
     * for all properties.
     * If <code>listener</code> was added more than once to the same event
     * source, it will be notified one less time after being removed.
     * If <code>listener</code> is null, or was never added, no exception is
     * thrown and no action is taken.
     *
     * @param listener  The VetoableChangeListener to be removed
     */
    public synchronized void removeVetoableChangeListener(
					VetoableChangeListener listener) {
        if (listener == null) {
            return;
        }
        if (listener instanceof VetoableChangeListenerProxy) {
            VetoableChangeListenerProxy proxy =
                    (VetoableChangeListenerProxy)listener;
            // Call two argument remove method.
            removeVetoableChangeListener(proxy.getPropertyName(),
                    (VetoableChangeListener)proxy.getListener());
        } else {
            if (listeners == null) {
                return;
            }
            listeners.removeElement(listener);
        }
    }

    /**
     * Returns the list of VetoableChangeListeners. If named vetoable change listeners
     * were added, then VetoableChangeListenerProxy wrappers will returned
     * <p>
     * @return List of VetoableChangeListeners and VetoableChangeListenerProxys
     *         if named property change listeners were added.
     * @since 1.4
     */
    public synchronized VetoableChangeListener[] getVetoableChangeListeners(){
        List returnList = new ArrayList();

        // Add all the VetoableChangeListeners
        if (listeners != null) {
            returnList.addAll(listeners);
        }

        // Add all the VetoableChangeListenerProxys
        if (children != null) {
            Iterator iterator = children.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String)iterator.next();
                VetoableChangeSupport child =
                        (VetoableChangeSupport)children.get(key);
                VetoableChangeListener[] childListeners =
                    child.getVetoableChangeListeners();
                for (int index = childListeners.length - 1; index >= 0;
                        index--) {
                    returnList.add(new VetoableChangeListenerProxy(
                            key, childListeners[index]));
                }
            }
        }
	return (VetoableChangeListener[])(returnList.toArray(
                new VetoableChangeListener[0]));
    }

    /**
     * Add a VetoableChangeListener for a specific property.  The listener
     * will be invoked only when a call on fireVetoableChange names that
     * specific property.
     * The same listener object may be added more than once.  For each
     * property,  the listener will be invoked the number of times it was added
     * for that property.
     * If <code>propertyName</code> or <code>listener</code> is null, no
     * exception is thrown and no action is taken.
     *
     * @param propertyName  The name of the property to listen on.
     * @param listener  The VetoableChangeListener to be added
     */

    public synchronized void addVetoableChangeListener(
				String propertyName,
                VetoableChangeListener listener) {
        if (listener == null || propertyName == null) {
            return;
        }
        if (children == null) {
            children = new java.util.Hashtable();
        }
        VetoableChangeSupport child = (VetoableChangeSupport)children.get(propertyName);
        if (child == null) {
            child = new VetoableChangeSupport(source);
            children.put(propertyName, child);
        }
        child.addVetoableChangeListener(listener);
    }

    /**
     * Remove a VetoableChangeListener for a specific property.
     * If <code>listener</code> was added more than once to the same event
     * source for the specified property, it will be notified one less time
     * after being removed.
     * If <code>propertyName</code> is null, no exception is thrown and no
     * action is taken.
     * If <code>listener</code> is null, or was never added for the specified
     * property, no exception is thrown and no action is taken.
     *
     * @param propertyName  The name of the property that was listened on.
     * @param listener  The VetoableChangeListener to be removed
     */

    public synchronized void removeVetoableChangeListener(
				String propertyName,
                VetoableChangeListener listener) {
        if (listener == null || propertyName == null) {
            return;
        }
        if (children == null) {
            return;
        }
        VetoableChangeSupport child = (VetoableChangeSupport)children.get(propertyName);
        if (child == null) {
            return;
        }
        child.removeVetoableChangeListener(listener);
    }

    /**
     * Returns an array of all the listeners which have been associated 
     * with the named property.
     *
     * @param propertyName  The name of the property being listened to
     * @return all the <code>VetoableChangeListeners</code> associated with
     *         the named property.  If no such listeners have been added,
     *         or if <code>propertyName</code> is null, an empty array is
     *         returned.
     * @since 1.4
     */
    public synchronized VetoableChangeListener[] getVetoableChangeListeners(
            String propertyName) {
        List returnList = new ArrayList();

        if (children != null && propertyName != null) {
            VetoableChangeSupport support =
                    (VetoableChangeSupport)children.get(propertyName);
            if (support != null) {
                returnList.addAll(
                        Arrays.asList(support.getVetoableChangeListeners()));
            }
        }
        return (VetoableChangeListener[])(returnList.toArray(new
                VetoableChangeListener[0]));
    }

    /**
     * Report a vetoable property update to any registered listeners.  If
     * anyone vetos the change, then fire a new event reverting everyone to 
     * the old value and then rethrow the PropertyVetoException.
     * <p>
     * No event is fired if old and new are equal and non-null.
     *
     * @param propertyName  The programmatic name of the property
     *		that is about to change..
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     * @exception PropertyVetoException if the recipient wishes the property
     *              change to be rolled back.
     */
    public void fireVetoableChange(String propertyName, 
					Object oldValue, Object newValue)
					throws PropertyVetoException {
	if (listeners == null && children == null) {
	    return;
	}

       	PropertyChangeEvent evt = new PropertyChangeEvent(source, propertyName,
							    oldValue, newValue);
	fireVetoableChange(evt);
    }

    /**
     * Report a int vetoable property update to any registered listeners.
     * No event is fired if old and new are equal.
     * <p>
     * This is merely a convenience wrapper around the more general
     * fireVetoableChange method that takes Object values.
     *
     * @param propertyName  The programmatic name of the property
     *		that is about to change.
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     */
    public void fireVetoableChange(String propertyName, 
					int oldValue, int newValue)
					throws PropertyVetoException {
	if (oldValue == newValue) {
	    return;
	}
	fireVetoableChange(propertyName, new Integer(oldValue), new Integer(newValue));
    }

    /**
     * Report a boolean vetoable property update to any registered listeners.
     * No event is fired if old and new are equal.
     * <p>
     * This is merely a convenience wrapper around the more general
     * fireVetoableChange method that takes Object values.
     *
     * @param propertyName  The programmatic name of the property
     *		that is about to change.
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     */
    public void fireVetoableChange(String propertyName, 
					boolean oldValue, boolean newValue) 
					throws PropertyVetoException {
	if (oldValue == newValue) {
	    return;
	}
	fireVetoableChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }


    /**
     * Fire a vetoable property update to any registered listeners.  If
     * anyone vetos the change, then fire a new event reverting everyone to 
     * the old value and then rethrow the PropertyVetoException.
     * <p>
     * No event is fired if old and new are equal and non-null.
     *
     * @param evt  The PropertyChangeEvent to be fired.
     * @exception PropertyVetoException if the recipient wishes the property
     *              change to be rolled back.
     */
    public void fireVetoableChange(PropertyChangeEvent evt)
					throws PropertyVetoException {

	Object oldValue = evt.getOldValue();
	Object newValue = evt.getNewValue();
	String propertyName = evt.getPropertyName();
	if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
	    return;
	}

	java.util.Vector targets = null;
	VetoableChangeSupport child = null;
	synchronized (this) {
	    if (listeners != null) {
	        targets = (java.util.Vector) listeners.clone();
	    }
	    if (children != null && propertyName != null) {
		child = (VetoableChangeSupport)children.get(propertyName);
	    }
	}

	if (listeners != null) {
	    try {
	        for (int i = 0; i < targets.size(); i++) {
	            VetoableChangeListener target = 
				(VetoableChangeListener)targets.elementAt(i);
	            target.vetoableChange(evt);
	        }
	    } catch (PropertyVetoException veto) {
	        // Create an event to revert everyone to the old value.
       	        evt = new PropertyChangeEvent(source, propertyName, newValue, oldValue);
	        for (int i = 0; i < targets.size(); i++) {
		    try {
	                VetoableChangeListener target =
				(VetoableChangeListener)targets.elementAt(i);
	                target.vetoableChange(evt);
		    } catch (PropertyVetoException ex) {
		         // We just ignore exceptions that occur during reversions.
		    }
	        }
	        // And now rethrow the PropertyVetoException.
	        throw veto;
	    }
	}

	if (child != null) {
	    child.fireVetoableChange(evt);
	}
    }


    /**
     * Check if there are any listeners for a specific property, including
     * those registered on all properties.  If <code>propertyName</code>
     * is null, only check for listeners registered on all properties.
     *
     * @param propertyName  the property name.
     * @return true if there are one or more listeners for the given property
     */
    public synchronized boolean hasListeners(String propertyName) {
	if (listeners != null && !listeners.isEmpty()) {
	    // there is a generic listener
	    return true;
	}
	if (children != null && propertyName != null) {
	    VetoableChangeSupport child = (VetoableChangeSupport)children.get(propertyName);
	    if (child != null && child.listeners != null) {
		return !child.listeners.isEmpty();
	    }
	}
	return false;
    }

    /**
     * @serialData Null terminated list of <code>VetoableChangeListeners</code>.
     * <p>
     * At serialization time we skip non-serializable listeners and
     * only serialize the serializable listeners.
     *
     */

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

	java.util.Vector v = null;
	synchronized (this) {
	    if (listeners != null) {
	        v = (java.util.Vector) listeners.clone();
            }
	}

	if (v != null) {
	    for(int i = 0; i < v.size(); i++) {
	        VetoableChangeListener l = (VetoableChangeListener)v.elementAt(i);
	        if (l instanceof Serializable) {
	            s.writeObject(l);
	        }
            }
        }
        s.writeObject(null);
    }


    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
        s.defaultReadObject();
      
        Object listenerOrNull;
        while(null != (listenerOrNull = s.readObject())) {
	    addVetoableChangeListener((VetoableChangeListener)listenerOrNull);
        }
    }

    /**
     * "listeners" lists all the generic listeners.
     *
     *  This is transient - its state is written in the writeObject method.
     */
    transient private java.util.Vector listeners;

    /** 
     * Hashtable for managing listeners for specific properties.
     * Maps property names to VetoableChangeSupport objects.
     * @serial 
     * @since 1.2
     */
    private java.util.Hashtable children;

    /** 
     * The object to be provided as the "source" for any generated events.
     * @serial
     */
    private Object source;

    /**
     * Internal version number
     * @serial
     */
    private int vetoableChangeSupportSerializedDataVersion = 2;

    /**
     * Serialization version ID, so we're compatible with JDK 1.1
     */
    static final long serialVersionUID = -5090210921595982017L;
}
