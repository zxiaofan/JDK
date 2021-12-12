/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Interface to specify methods for accessing {@code ObjectInputStream}.
 */
@FunctionalInterface
public interface JavaObjectInputStreamReadString {
    String readString(ObjectInputStream ois) throws IOException;
}

