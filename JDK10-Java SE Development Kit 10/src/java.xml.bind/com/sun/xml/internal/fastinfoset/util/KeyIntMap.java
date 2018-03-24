/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.util;
import com.sun.xml.internal.fastinfoset.CommonResourceBundle;

public abstract class KeyIntMap {
    public static final int NOT_PRESENT = -1;

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 20;

    /**
     * The load factor used when none specified in constructor.
     **/
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    int _readOnlyMapSize;

    /**
     * The number of key-value mappings contained in this identity hash map.
     */
    int _size;

    int _capacity;

    /**
     * The next size value at which to resize (capacity * load factor).
     */
    int _threshold;

    /**
     * The load factor for the hash table.
     */
    final float _loadFactor;

    static class BaseEntry {
        final int _hash;
        final int _value;

        public BaseEntry(int hash, int value) {
            _hash = hash;
            _value = value;
        }
    }

    public KeyIntMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().
                    getString("message.illegalInitialCapacity", new Object[]{Integer.valueOf(initialCapacity)}));
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().
                    getString("message.illegalLoadFactor", new Object[]{Float.valueOf(loadFactor)}));

        // Find a power of 2 >= initialCapacity
        if (initialCapacity != DEFAULT_INITIAL_CAPACITY) {
            _capacity = 1;
            while (_capacity < initialCapacity)
                _capacity <<= 1;

            _loadFactor = loadFactor;
            _threshold = (int)(_capacity * _loadFactor);
        } else {
            _capacity = DEFAULT_INITIAL_CAPACITY;
            _loadFactor = DEFAULT_LOAD_FACTOR;
            _threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }
    }

    public KeyIntMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public KeyIntMap() {
        _capacity = DEFAULT_INITIAL_CAPACITY;
        _loadFactor = DEFAULT_LOAD_FACTOR;
        _threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    public final int size() {
        return _size + _readOnlyMapSize;
    }

    public abstract void clear();

    public abstract void setReadOnlyMap(KeyIntMap readOnlyMap, boolean clear);


    public static final int hashHash(int h) {
        h += ~(h << 9);
        h ^=  (h >>> 14);
        h +=  (h << 4);
        h ^=  (h >>> 10);
        return h;
    }

    public static final int indexFor(int h, int length) {
        return h & (length-1);
    }

}
