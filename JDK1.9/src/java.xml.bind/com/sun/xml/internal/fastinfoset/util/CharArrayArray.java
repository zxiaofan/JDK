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

public class CharArrayArray extends ValueArray {

    private CharArray[] _array;

    private CharArrayArray _readOnlyArray;

    public CharArrayArray(int initialCapacity, int maximumCapacity) {
        _array = new CharArray[initialCapacity];
        _maximumCapacity = maximumCapacity;
    }

    public CharArrayArray() {
        this(DEFAULT_CAPACITY, MAXIMUM_CAPACITY);
    }

    public final void clear() {
        for (int i = 0; i < _size; i++) {
            _array[i] = null;
        }
        _size = 0;
    }

    /**
     * Returns cloned version of internal CharArray[].
     * @return cloned version of internal CharArray[].
     */
    public final CharArray[] getArray() {
        if (_array == null) return null;

        final CharArray[] clonedArray = new CharArray[_array.length];
        System.arraycopy(_array, 0, clonedArray, 0, _array.length);
        return clonedArray;
    }

    public final void setReadOnlyArray(ValueArray readOnlyArray, boolean clear) {
        if (!(readOnlyArray instanceof CharArrayArray)) {
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().getString("message.illegalClass", new Object[]{readOnlyArray}));
        }

        setReadOnlyArray((CharArrayArray)readOnlyArray, clear);
    }

    public final void setReadOnlyArray(CharArrayArray readOnlyArray, boolean clear) {
        if (readOnlyArray != null) {
            _readOnlyArray = readOnlyArray;
            _readOnlyArraySize = readOnlyArray.getSize();

            if (clear) {
                clear();
            }
        }
    }

    public final CharArray get(int i) {
        if (_readOnlyArray == null) {
            return _array[i];
        } else {
            if (i < _readOnlyArraySize) {
               return _readOnlyArray.get(i);
            } else {
                return _array[i - _readOnlyArraySize];
            }
        }
   }

    public final void add(CharArray s) {
        if (_size == _array.length) {
            resize();
        }

       _array[_size++] = s;
    }

    protected final void resize() {
        if (_size == _maximumCapacity) {
            throw new ValueArrayResourceException(CommonResourceBundle.getInstance().getString("message.arrayMaxCapacity"));
        }

        int newSize = _size * 3 / 2 + 1;
        if (newSize > _maximumCapacity) {
            newSize = _maximumCapacity;
        }

        final CharArray[] newArray = new CharArray[newSize];
        System.arraycopy(_array, 0, newArray, 0, _size);
        _array = newArray;
    }
}
