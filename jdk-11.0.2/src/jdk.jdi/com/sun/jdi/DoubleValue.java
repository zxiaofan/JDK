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
 * Provides access to a primitive <code>double</code> value in
 * the target VM.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface DoubleValue extends PrimitiveValue, Comparable<DoubleValue> {

    /**
     * Returns this DoubleValue as a <code>double</code>.
     *
     * @return the <code>double</code> mirrored by this object.
     */
    double value();

    /**
     * Compares the specified Object with this DoubleValue for equality.
     *
     * @return true if the Object is a DoubleValue and if applying "=="
     * to the two mirrored primitives would evaluate to true; false
     * otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this DoubleValue.
     *
     * @return the integer hash code
     */
    int hashCode();
}
