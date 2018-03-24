/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.util;

/**
 * Unmodifiable memory efficient set data structure.
 */
public interface UnmodifiableEconomicSet<E> extends Iterable<E> {

    boolean contains(E element);

    int size();

    boolean isEmpty();

    default E[] toArray(E[] target) {
        if (target.length != size()) {
            throw new UnsupportedOperationException("Length of target array must equal the size of the set.");
        }

        int index = 0;
        for (E element : this) {
            target[index++] = element;
        }

        return target;
    }
}
