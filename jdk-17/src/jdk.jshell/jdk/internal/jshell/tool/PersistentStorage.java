/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.jshell.tool;

/**
 * The required functionality jshell uses for persistent storage.  Implementable
 * by both Preferences API and Map.
 */
interface PersistentStorage {

    /**
     * Removes all of the preferences (key-value associations) in
     * preferences.
     *
     * @throws IllegalStateException if this operation cannot be completed
     * because of the state of the system.
     */
    void clear();

    /**
     * Returns all of the keys that have an associated value in
     * preferences.
     *
     * @return an array of the keys that have an associated value in this
     * preference node.
     * @throws IllegalStateException if this operation cannot be completed
     * because of the state of the system.
     */
    String[] keys();

    /**
     * Returns the value associated with the specified key in preferences.
     *
     * @param key key whose associated value is to be returned.
     * @return the value associated with {@code key}, or {@code null} if no
     * value is associated with {@code key}.
     * @throws IllegalStateException if this operation cannot be completed
     * because of the state of the system.
     * @throws NullPointerException if {@code key} is {@code null}.
     */
    String get(String key);

    /**
     * Associates the specified value with the specified key in this
     * preference node.
     *
     * @param key key with which the specified value is to be associated.
     * @param value value to be associated with the specified key.
     * @throws NullPointerException if key or value is {@code null}.
     * @throws IllegalArgumentException if key or value are too long.
     * @throws IllegalStateException if this operation cannot be completed
     * because of the state of the system.
     */
    void put(String key, String value);

    /**
     * Removes the value associated with the specified key in preferences,
     * if any.
     *
     * @param key key whose mapping is to be removed from the preference
     * node.
     * @throws NullPointerException if {@code key} is {@code null}.
     * @throws IllegalStateException if this operation cannot be completed
     * because of the state of the system.
     */
    void remove(String key);

    /**
     * Forces any changes in the contents of this preferences to be stored.
     * Once this method returns successfully, it is safe to assume that all
     * changes have become as permanent as they are going to be.
     * <p>
     * Implementations are free to flush changes into the persistent store
     * at any time. They do not need to wait for this method to be called.
     *
     * @throws IllegalStateException if this operation cannot be completed
     * because of the state of the system.
     */
    void flush();

}
