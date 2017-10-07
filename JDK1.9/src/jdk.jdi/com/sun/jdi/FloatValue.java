/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Provides access to a primitive <code>float</code> value in
 * the target VM.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface FloatValue extends PrimitiveValue, Comparable<FloatValue> {

    /**
     * Returns this FloatValue as a float.
     *
     * @return the <code>float</code> mirrored by this object.
     */
    float value();

    /**
     * Compares the specified Object with this FloatValue for equality.
     *
     * @return true if the Object is a FloatValue and if applying "=="
     * to the two mirrored primitives would evaluate to true; false
     * otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this FloatValue.
     *
     * @return the integer hash code
     */
    int hashCode();
}
