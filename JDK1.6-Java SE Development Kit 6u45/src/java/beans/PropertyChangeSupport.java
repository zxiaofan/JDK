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

import sun.awt.EventListenerAggregate;

/**
 * This is a utility class that can be used by beans that support bound
 * properties.  You can use an instance of this class as a member field
 * of your bean and delegate various work to it.
 *
 * This class is serializable.  When it is serialized it will save
 * (and restore) any listeners that are themselves serializable.  Any
 * non-serializable listeners will be skipped during serialization.
 *
 */
public class PropertyChangeSupport implements java.io.Serializable {

    // Manages the listener list.
    private transient EventListenerAggregate listeners;

    /**
     * Constructs a <code>PropertyChangeSupport</code> object.
     *
     * @param sourceBean  The bean to be given as the source for any events.
     */

    public PropertyChangeSupport(Object sourceBean) {
	if (sourceBean == null) {
	    throw new NullPointerException();
	}
	source = sourceBean;
    }

    /**
     * Add a PropertyChangeListener to the listener list.
     * The listener is registered for all properties.
     * The same listener object may be added more than once, and will be called
     * as many times as it is added.
     * If <code>listener</code> is null, no exception is thrown and no action
     * is taken.
     *
     * @param listener  The PropertyChangeListener to be added
     */
    public synchronized void addPropertyChangeListener(
				PropertyChangeListener listener) {
	if (listener == null) {
	    return;
	}

	if (listener instanceof PropertyChangeListenerProxy) {
	    PropertyChangeListenerProxy proxy =
                   (PropertyChangeListenerProxy)listener;
	    // Call two argument add method.
	    addPropertyChangeListener(proxy.getPropertyName(),
                    (PropertyChangeListener)proxy.getListener());
	} else {
	    if (listeners == null) {
		listeners = new EventListenerAggregate(PropertyChangeListener.class);
	    }
	    listeners.add(listener);
	}
    }

    /**
     * Remove a PropertyChangeListener from the listener list.
     * This removes a PropertyChangeListener that was registered
     * for all properties.
     * If <code>listener</code> was added more than once to the same event
     * source, it will be notified one less time after being removed.
     * If <code>listener</code> is null, or was never added, no exception is
     * thrown and no action is taken.
     *
     * @param listener  The PropertyChangeListener to be removed
     */
    public synchronized void removePropertyChangeListener(
				PropertyChangeListener listener) {
	if (listener == null) {
	    return;
	}

	if (listener instanceof PropertyChangeListenerProxy) {
	    PropertyChangeListenerProxy proxy =
                    (PropertyChangeListenerProxy)listener;
	    // Call two argument remove method.
	    removePropertyChangeListener(proxy.getPropertyName(),
                   (PropertyChangeListener)proxy.getListener());
	} else {
	    if (listeners == null) {
		return;
	    }
	    listeners.remove(listener);
	}
    }

    /**
     * Returns an array of all the listeners that were added to the
     * PropertyChangeSupport object with addPropertyChangeListener().
     * <p>
     * If some listeners have been added with a named property, then
     * the returned array will be a mixture of PropertyChangeListeners
     * and <code>PropertyChangeListenerProxy</code>s. If the calling
     * method is interested in distinguishing the listeners then it must
     * test each element to see if it's a
     * <code>PropertyChangeListenerProxy</code>, perform the cast, and examine
     * the parameter.
     * 
     * <pre>
     * PropertyChangeListener[] listeners = bean.getPropertyChangeListeners();
     * for (int i = 0; i < listeners.length; i++) {
     *	 if (listeners[i] instanceof PropertyChangeListenerProxy) {
     *     PropertyChangeListenerProxy proxy = 
     *                    (PropertyChangeListenerProxy)listeners[i];
     *     if (proxy.getPropertyName().equals("foo")) {
     *       // proxy is a PropertyChangeListener which was associated
     *       // with the property named "foo"
     *     }
     *   }
     * }
     *</pre>
     *
     * @see PropertyChangeListenerProxy
     * @return all of the <code>PropertyChangeListeners</code> added or an 
     *         empty array if no listeners have been added
     * @since 1.4
     */
    public synchronized PropertyChangeListener[] getPropertyChangeListeners() {
	List returnList = new ArrayList();
     
	// Add all the PropertyChangeListeners 
	if (listeners != null) {
	    returnList.addAll(Arrays.asList(listeners.getListenersInternal()));
	}
	 
	// Add all the PropertyChangeListenerProxys
	if (children != null) {
	    Iterator iterator = children.keySet().iterator();
	    while (iterator.hasNext()) {
		String key = (String)iterator.next();
		PropertyChangeSupport child =
                        (PropertyChangeSupport)children.get(key);
		PropertyChangeListener[] childListeners =
                        child.getPropertyChangeListeners();
		for (int index = childListeners.length - 1; index >= 0;
                        index--) {
		    returnList.add(new PropertyChangeListenerProxy(
                            key, childListeners[index]));
		}
	    }
	}
	return (PropertyChangeListener[])(returnList.toArray(
                new PropertyChangeListener[0]));
    }

    /**
     * Add a PropertyChangeListener for a specific property.  The listener
     * will be invoked only when a call on firePropertyChange names that
     * specific property.
     * The same listener object may be added more than once.  For each
     * property,  the listener will be invoked the number of times it was added
     * for that property.
     * If <code>propertyName</code> or <code>listener</code> is null, no
     * exception is thrown and no action is taken.
     *
     * @param propertyName  The name of the property to listen on.
     * @param listener  The PropertyChangeListener to be added
     */

    public synchronized void addPropertyChangeListener(
                String propertyName,
                PropertyChangeListener listener) {
        if (listener == null || propertyName == null) {
            return;
        }
        if (children == null) {
            children = new java.util.Hashtable();
        }
        PropertyChangeSupport child = (PropertyChangeSupport)children.get(propertyName);
        if (child == null) {
            child = new PropertyChangeSupport(source);
            children.put(propertyName, child);
        }
        child.addPropertyChangeListener(listener);
    }

    /**
     * Remove a PropertyChangeListener for a specific property.
     * If <code>listener</code> was added more than once to the same event
     * source for the specified property, it will be notified one less time
     * after being removed.
     * If <code>propertyName</code> is null,  no exception is thrown and no
     * action is taken.
     * If <code>listener</code> is null, or was never added for the specified
     * property, no exception is thrown and no action is taken.
     *
     * @param propertyName  The name of the property that was listened on.
     * @param listener  The PropertyChangeListener to be removed
     */

    public synchronized void removePropertyChangeListener(
                String propertyName,
                PropertyChangeListener listener) {
        if (listener == null || propertyName == null) {
            return;
        }
        if (children == null) {
            return;
        }
        PropertyChangeSupport child = (PropertyChangeSupport)children.get(propertyName);
        if (child == null) {
            return;
        }
        child.removePropertyChangeListener(listener);
    }

    /**
     * Returns an array of all the listeners which have been associated 
     * with the named property.
     *
     * @param propertyName  The name of the property being listened to
     * @return all of the <code>PropertyChangeListeners</code> associated with
     *         the named property.  If no such listeners have been added,
     *         or if <code>propertyName</code> is null, an empty array is
     *         returned.
     * @since 1.4
     */
    public synchronized PropertyChangeListener[] getPropertyChangeListeners(
            String propertyName) {
        ArrayList returnList = new ArrayList();

        if (children != null && propertyName != null) {
            PropertyChangeSupport support =
                    (PropertyChangeSupport)children.get(propertyName);
            if (support != null) {
                returnList.addAll(
                        Arrays.asList(support.getPropertyChangeListeners()));
            }
        }
        return (PropertyChangeListener[])(returnList.toArray(
                new PropertyChangeListener[0]));
    }

    /**
     * Report a bound property update to any registered listeners.
     * No event is fired if old and new are equal and non-null.
     *
     * <p>
     * This is merely a convenience wrapper around the more general
     * firePropertyChange method that takes {@code
     * PropertyChangeEvent} value.
     *
     * @param propertyName  The programmatic name of the property
     *		that was changed.
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     */
    public void firePropertyChange(String propertyName, 
					Object oldValue, Object newValue) {
	if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
	    return;
	}
	firePropertyChange(new PropertyChangeEvent(source, propertyName,
						   oldValue, newValue));
    }

    /**
     * Report an int bound property update to any registered listeners.
     * No event is fired if old and new are equal.
     * <p>
     * This is merely a convenience wrapper around the more general
     * firePropertyChange method that takes Object values.
     *
     * @param propertyName  The programmatic name of the property
     *		that was changed.
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     */
    public void firePropertyChange(String propertyName, 
					int oldValue, int newValue) {
	if (oldValue == newValue) {
	    return;
	}
	firePropertyChange(propertyName, new Integer(oldValue), new Integer(newValue));
    }


    /**
     * Report a boolean bound property update to any registered listeners.
     * No event is fired if old and new are equal.
     * <p>
     * This is merely a convenience wrapper around the more general
     * firePropertyChange method that takes Object values.
     *
     * @param propertyName  The programmatic name of the property
     *		that was changed.
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     */
    public void firePropertyChange(String propertyName, 
					boolean oldValue, boolean newValue) {
	if (oldValue == newValue) {
	    return;
	}
	firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }

    /**
     * Fire an existing PropertyChangeEvent to any registered listeners.
     * No event is fired if the given event's old and new values are
     * equal and non-null.
     * @param evt  The PropertyChangeEvent object.
     */
    public void firePropertyChange(PropertyChangeEvent evt) {
	Object oldValue = evt.getOldValue();
	Object newValue = evt.getNewValue();
        String propertyName = evt.getPropertyName();
	if (oldValue != null && newValue != null && oldValue.equals(newValue)) {
	    return;
	}

	if (listeners != null) {
	    Object[] list = listeners.getListenersInternal();
	    for (int i = 0; i < list.length; i++) {
		PropertyChangeListener target = (PropertyChangeListener)list[i];
		target.propertyChange(evt);
	    }
	}

	if (children != null && propertyName != null) {
	    PropertyChangeSupport child = null;
	    child = (PropertyChangeSupport)children.get(propertyName);
	    if (child != null) {
		child.firePropertyChange(evt);
	    }
	}
    }

    
    /**
     * Report a bound indexed property update to any registered
     * listeners. 
     * <p>
     * No event is fired if old and new values are equal
     * and non-null.
     *
     * <p>
     * This is merely a convenience wrapper around the more general
     * firePropertyChange method that takes {@code PropertyChangeEvent} value.
     *
     * @param propertyName The programmatic name of the property that
     *                     was changed.
     * @param index        index of the property element that was changed.
     * @param oldValue     The old value of the property.
     * @param newValue     The new value of the property.
     * @since 1.5
     */
    public void fireIndexedPropertyChange(String propertyName, int index,
					  Object oldValue, Object newValue) {
	firePropertyChange(new IndexedPropertyChangeEvent
	    (source, propertyName, oldValue, newValue, index));
    }

    /**
     * Report an <code>int</code> bound indexed property update to any registered 
     * listeners. 
     * <p>
     * No event is fired if old and new values are equal.
     * <p>
     * This is merely a convenience wrapper around the more general
     * fireIndexedPropertyChange method which takes Object values.
     *
     * @param propertyName The programmatic name of the property that
     *                     was changed.
     * @param index        index of the property element that was changed.
     * @param oldValue     The old value of the property.
     * @param newValue     The new value of the property.
     * @since 1.5
     */
    public void fireIndexedPropertyChange(String propertyName, int index,
					  int oldValue, int newValue) {
	if (oldValue == newValue) {
	    return;
	}
	fireIndexedPropertyChange(propertyName, index, 
				  new Integer(oldValue), 
				  new Integer(newValue));
    }

    /**
     * Report a <code>boolean</code> bound indexed property update to any 
     * registered listeners. 
     * <p>
     * No event is fired if old and new values are equal.
     * <p>
     * This is merely a convenience wrapper around the more general
     * fireIndexedPropertyChange method which takes Object values.
     *
     * @param propertyName The programmatic name of the property that
     *                     was changed.
     * @param index        index of the property element that was changed.
     * @param oldValue     The old value of the property.
     * @param newValue     The new value of the property.
     * @since 1.5
     */
    public void fireIndexedPropertyChange(String propertyName, int index,
					  boolean oldValue, boolean newValue) {
	if (oldValue == newValue) {
	    return;
	}
	fireIndexedPropertyChange(propertyName, index, Boolean.valueOf(oldValue), 
				  Boolean.valueOf(newValue));
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
	    PropertyChangeSupport child = (PropertyChangeSupport)children.get(propertyName);
	    if (child != null && child.listeners != null) {
		return !child.listeners.isEmpty();
	    }
	}
	return false;
    }

    /**
     * @serialData Null terminated list of <code>PropertyChangeListeners</code>.
     * <p>
     * At serialization time we skip non-serializable listeners and
     * only serialize the serializable listeners.
     *
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

	if (listeners != null) {
	    Object[] list = listeners.getListenersCopy();

	    for (int i = 0; i < list.length; i++) {
	        PropertyChangeListener l = (PropertyChangeListener)list[i];
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
        while (null != (listenerOrNull = s.readObject())) {
	    addPropertyChangeListener((PropertyChangeListener)listenerOrNull);
        }
    }

    /** 
     * Hashtable for managing listeners for specific properties.
     * Maps property names to PropertyChangeSupport objects.
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
     * @since
     */
    private int propertyChangeSupportSerializedDataVersion = 2;

    /**
     * Serialization version ID, so we're compatible with JDK 1.1
     */
    static final long serialVersionUID = 6401253773779951803L;
}
