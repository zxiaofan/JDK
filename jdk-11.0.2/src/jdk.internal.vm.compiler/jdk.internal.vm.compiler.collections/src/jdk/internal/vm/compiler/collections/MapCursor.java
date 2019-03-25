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
 * Cursor to iterate over a mutable map.
 *
 * @since 1.0
 */
public interface MapCursor<K, V> extends UnmodifiableMapCursor<K, V> {
    /**
     * Remove the current entry from the map. May only be called once. After calling
     * {@link #remove()}, it is no longer valid to call {@link #getKey()} or {@link #getValue()} on
     * the current entry.
     *
     * @since 1.0
     */
    void remove();
}
