/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

/**
 * Describes attributes of a specific property of a script object.
 */
public interface PropertyDescriptor {

    /** Type: generic property descriptor - TODO this should be an enum */
    public static final int GENERIC  = 0;

    /** Type: data property descriptor - TODO this should be an enum */
    public static final int DATA     = 1;

    /** Type: accessor property descriptor - TODO this should be an enum */
    public static final int ACCESSOR = 2;

    /** descriptor for configurable property */
    public static final String CONFIGURABLE = "configurable";

    /** descriptor for enumerable property */
    public static final String ENUMERABLE = "enumerable";

    /** descriptor for writable property */
    public static final String WRITABLE = "writable";

    /** descriptor for value */
    public static final String VALUE = "value";

    /** descriptor for getter */
    public static final String GET = "get";

    /** descriptor for setter */
    public static final String SET = "set";

    /**
     * Check if this {@code PropertyDescriptor} describes a configurable property
     * @return true if configurable
     */
    public boolean isConfigurable();

    /**
     * Check if this {@code PropertyDescriptor} describes an enumerable property
     * @return true if enumerable
     */
    public boolean isEnumerable();

    /**
     * Check if this {@code PropertyDescriptor} describes a wriable property
     * @return true if writable
     */
    public boolean isWritable();

    /**
     * Get the property value as given by this {@code PropertyDescriptor}
     * @return property value
     */
    public Object getValue();

    /**
     * Get the {@link UserAccessorProperty} getter as given by this {@code PropertyDescriptor}
     * @return getter, or null if not available
     */
    public ScriptFunction getGetter();

    /**
     * Get the {@link UserAccessorProperty} setter as given by this {@code PropertyDescriptor}
     * @return setter, or null if not available
     */
    public ScriptFunction getSetter();

    /**
     * Set whether this {@code PropertyDescriptor} describes a configurable property
     * @param flag true if configurable, false otherwise
     */
    public void setConfigurable(boolean flag);

    /**
     * Set whether this {@code PropertyDescriptor} describes an enumerable property
     * @param flag true if enumerable, false otherwise
     */
    public void setEnumerable(boolean flag);

    /**
     * Set whether this {@code PropertyDescriptor} describes a writable property
     * @param flag true if writable, false otherwise
     */
    public void setWritable(boolean flag);

    /**
     * Set the property value for this {@code PropertyDescriptor}
     * @param value property value
     */
    public void setValue(Object value);

    /**
     * Assign a {@link UserAccessorProperty} getter as given to this {@code PropertyDescriptor}
     * @param getter getter, or null if not available
     */
    public void setGetter(Object getter);

    /**
     * Assign a {@link UserAccessorProperty} setter as given to this {@code PropertyDescriptor}
     * @param setter setter, or null if not available
     */
    public void setSetter(Object setter);

    /**
     * Fill in this {@code PropertyDescriptor} from the properties of a given {@link ScriptObject}
     *
     * @param obj the script object
     * @return filled in {@code PropertyDescriptor}
     *
     */
    public PropertyDescriptor fillFrom(ScriptObject obj);

    /**
     * Get the type of this property descriptor.
     * @return property descriptor type, one of {@link PropertyDescriptor#GENERIC}, {@link PropertyDescriptor#DATA} and {@link PropertyDescriptor#ACCESSOR}
     */
    public int type();

    /**
     * Wrapper for {@link ScriptObject#has(Object)}
     *
     * @param key property key
     * @return true if property exists in implementor
     */
    public boolean has(Object key);

    /**
     * Check existence and compare attributes of descriptors.
     * @param otherDesc other descriptor to compare to
     * @return true if every field of this descriptor exists in otherDesc and has the same value.
     */
    public boolean hasAndEquals(PropertyDescriptor otherDesc);
}

