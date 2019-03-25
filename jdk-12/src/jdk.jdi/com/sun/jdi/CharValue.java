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
 * Provides access to a primitive <code>char</code> value in
 * the target VM.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface CharValue extends PrimitiveValue, Comparable<CharValue> {

    /**
     * Returns this CharValue as a <code>char</code>.
     *
     * @return the <code>char</code> mirrored by this object.
     */
    char value();

    /**
     * Compares the specified Object with this CharValue for equality.
     *
     * @return true if the Object is a CharValue and if applying "=="
     * to the two mirrored primitives would evaluate to true; false
     * otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this CharValue.
     *
     * @return the integer hash code
     */
    int hashCode();
}
