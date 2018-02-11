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
 * Provides access to a primitive <code>void</code> value in
 * the target VM.
 *
 * @author Robert Field
 * @since  1.3
 */
public interface VoidValue extends Value {

    /**
     * Compares the specified Object with this VoidValue for equality.
     *
     * @return true if the Object is a VoidValue; false
     * otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this VoidValue.
     *
     * @return the hash code
     */
    int hashCode();
}
