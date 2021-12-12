/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.io.InvalidClassException;
import java.io.ObjectInputStream;

/**
 * Interface to specify methods for accessing {@code ObjectInputStream}.
 */
@FunctionalInterface
public interface JavaObjectInputStreamAccess {
    void checkArray(ObjectInputStream ois, Class<?> arrayType, int arrayLength)
        throws InvalidClassException;
}
