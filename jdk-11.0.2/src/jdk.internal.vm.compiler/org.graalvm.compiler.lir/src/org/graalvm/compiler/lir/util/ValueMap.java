/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.lir.util;

import jdk.vm.ci.meta.Value;

/**
 * A map interface to map {@link Value}s to other objects.
 */
public abstract class ValueMap<K extends Value, T> {

    /**
     * Gets the object associated with {@code value} or {@code null} if there is no such mapping.
     */
    public abstract T get(K value);

    /**
     * Removes the object associated with {@code value} from the map.
     */
    public abstract void remove(K value);

    /**
     * Associates {@code object} with {@code value}.
     */
    public abstract void put(K value, T object);
}
