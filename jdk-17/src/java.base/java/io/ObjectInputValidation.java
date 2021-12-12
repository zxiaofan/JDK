/*
 * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.io;

/**
 * Callback interface to allow validation of objects within a graph.
 * Allows an object to be called when a complete graph of objects has
 * been deserialized.
 *
 * @see     ObjectInputStream
 * @see     ObjectInputStream#registerValidation(java.io.ObjectInputValidation, int)
 * @since   1.1
 */
public interface ObjectInputValidation {
    /**
     * Validates the object.
     *
     * @throws    InvalidObjectException If the object cannot validate itself.
     */
    public void validateObject() throws InvalidObjectException;
}
