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
 * Cursor to iterate over a map without changing its contents.
 */
public interface UnmodifiableMapCursor<K, V> {
    /**
     * Advances to the next entry.
     *
     * @return {@code true} if a next entry exists, {@code false} if there is no next entry.
     */
    boolean advance();

    /**
     * The key of the current entry.
     */
    K getKey();

    /**
     * The value of the current entry.
     */
    V getValue();
}
