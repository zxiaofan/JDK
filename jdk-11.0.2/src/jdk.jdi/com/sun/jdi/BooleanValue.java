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
 * Provides access to a primitive <code>boolean</code> value in
 * the target VM.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface BooleanValue extends PrimitiveValue {

    /**
     * Returns this BooleanValue as a boolean.
     *
     * @return the <code>boolean</code> mirrored by this object.
     */
    boolean value();

    /**
     * Compares the specified Object with this BooleanValue for equality.
     *
     * @return true if the Object is a BooleanValue and if applying "=="
     * to the two mirrored primitives would evaluate to true; false
     * otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this BooleanValue.
     *
     * @return the integer hash code
     */
    int hashCode();
}
