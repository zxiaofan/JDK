/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

/**
 * Information about property used in  opening {@code AudioSynthesizer}.
 *
 * @author Karl Helgason
 */
public final class AudioSynthesizerPropertyInfo {

    /**
     * Constructs an {@code AudioSynthesizerPropertyInfo} object with a given
     * name and value. The {@code description} and {@code choices}
     * are initialized by {@code null} values.
     *
     * @param name the name of the property
     * @param value the current value or class used for values.
     *
     */
    public AudioSynthesizerPropertyInfo(String name, Object value) {
        this.name = name;
        if (value instanceof Class)
            valueClass = (Class)value;
        else
        {
            this.value = value;
            if (value != null)
                valueClass = value.getClass();
        }
    }
    /**
     * The name of the property.
     */
    public String name;
    /**
     * A brief description of the property, which may be null.
     */
    public String description = null;
    /**
     * The {@code value} field specifies the current value of
     * the property.
     */
    public Object value = null;
    /**
     * The {@code valueClass} field specifies class
     * used in {@code value} field.
     */
    public Class<?> valueClass = null;
    /**
     * An array of possible values if the value for the field
     * {@code AudioSynthesizerPropertyInfo.value} may be selected
     * from a particular set of values; otherwise null.
     */
    public Object[] choices = null;

}
