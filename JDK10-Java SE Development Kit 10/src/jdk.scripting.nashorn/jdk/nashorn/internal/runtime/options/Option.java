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

package jdk.nashorn.internal.runtime.options;

/**
 * This is an option class that at its most primitive level just wraps a
 * boolean or String. However, it is conceivable that the option, when set
 * should run some initializations (for example, the logger system) or carry
 * some other kind of payload, arrays, Collections, etc. In that case, this
 * should be subclassed
 *
 * @param <T> option value type, for example a boolean or something more complex
 */
public class Option<T> {
    /** the option value */
    protected T value;

    Option(final T value) {
       this.value = value;
    }

    /**
     * Return the value of an option
     * @return the option value
     */
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue() + " [" + getValue().getClass() + "]";
    }
}
