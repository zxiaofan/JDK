/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.beans;

/**
 * A "PropertyChange" event gets delivered whenever a bean changes a "bound"
 * or "constrained" property.  A PropertyChangeEvent object is sent as an
 * argument to the PropertyChangeListener and VetoableChangeListener methods.
 * <P>
 * Normally PropertyChangeEvents are accompanied by the name and the old
 * and new value of the changed property.  If the new value is a primitive
 * type (such as int or boolean) it must be wrapped as the 
 * corresponding java.lang.* Object type (such as Integer or Boolean).
 * <P>
 * Null values may be provided for the old and the new values if their
 * true values are not known.
 * <P>
 * An event source may send a null object as the name to indicate that an
 * arbitrary set of if its properties have changed.  In this case the
 * old and new values should also be null.
 */

public class PropertyChangeEvent extends java.util.EventObject {

    /**
     * Constructs a new <code>PropertyChangeEvent</code>.
     *
     * @param source  The bean that fired the event.
     * @param propertyName  The programmatic name of the property
     *		that was changed.
     * @param oldValue  The old value of the property.
     * @param newValue  The new value of the property.
     */
    public PropertyChangeEvent(Object source, String propertyName,
				     Object oldValue, Object newValue) {
	super(source);
	this.propertyName = propertyName;
	this.newValue = newValue;
	this.oldValue = oldValue;
    }

    /**
     * Gets the programmatic name of the property that was changed.
     *
     * @return  The programmatic name of the property that was changed.
     *		May be null if multiple properties have changed.
     */
    public String getPropertyName() {
	return propertyName;
    }
    
    /**
     * Gets the new value for the property, expressed as an Object.
     *
     * @return  The new value for the property, expressed as an Object.
     *		May be null if multiple properties have changed.
     */
    public Object getNewValue() {
	return newValue;
    }

    /**
     * Gets the old value for the property, expressed as an Object.
     *
     * @return  The old value for the property, expressed as an Object.
     *		May be null if multiple properties have changed.
     */
    public Object getOldValue() {
	return oldValue;
    }

    /**
     * Sets the propagationId object for the event.
     *
     * @param propagationId  The propagationId object for the event.
     */
    public void setPropagationId(Object propagationId) {
	this.propagationId = propagationId;
    }

    /**
     * The "propagationId" field is reserved for future use.  In Beans 1.0
     * the sole requirement is that if a listener catches a PropertyChangeEvent
     * and then fires a PropertyChangeEvent of its own, then it should
     * make sure that it propagates the propagationId field from its
     * incoming event to its outgoing event.
     *
     * @return the propagationId object associated with a bound/constrained
     *		property update.
     */
    public Object getPropagationId() {
	return propagationId;
    }

    /**
     * name of the property that changed.  May be null, if not known.
     * @serial
     */
    private String propertyName;

    /**
     * New value for property.  May be null if not known.
     * @serial
     */
    private Object newValue;

    /**
     * Previous value for property.  May be null if not known.
     * @serial
     */
    private Object oldValue;

    /**
     * Propagation ID.  May be null.
     * @serial
     * @see #getPropagationId.
     */
    private Object propagationId;
}
