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
 * Provides access to a primitive <code>int</code> value in
 * the target VM.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface IntegerValue extends PrimitiveValue, Comparable<IntegerValue> {

    /**
     * Returns this IntegerValue as an int.
     *
     * @return the <code>int</code> mirrored by this object.
     */
    int value();

    /**
     * Compares the specified Object with this IntegerValue for equality.
     *
     * @return true if the Object is an IntegerValue and if applying "=="
     * to the two mirrored primitives would evaluate to true; false
     * otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this IntegerValue.
     *
     * @return the integer hash code
     */
    int hashCode();
}
