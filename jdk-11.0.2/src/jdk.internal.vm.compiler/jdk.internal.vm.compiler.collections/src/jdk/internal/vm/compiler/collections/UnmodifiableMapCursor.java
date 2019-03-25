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


package jdk.internal.vm.compiler.collections;

/**
 * Cursor to iterate over a map without changing its contents.
 *
 * @since 1.0
 */
public interface UnmodifiableMapCursor<K, V> {
    /**
     * Advances to the next entry.
     *
     * @return {@code true} if a next entry exists, {@code false} if there is no next entry.
     * @since 1.0
     */
    boolean advance();

    /**
     * The key of the current entry.
     *
     * @since 1.0
     */
    K getKey();

    /**
     * The value of the current entry.
     *
     * @since 1.0
     */
    V getValue();
}
