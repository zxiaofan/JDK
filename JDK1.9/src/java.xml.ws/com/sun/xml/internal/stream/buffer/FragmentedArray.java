/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.buffer;

final class FragmentedArray<T> {
    private T _item;
    private FragmentedArray<T> _next;
    private FragmentedArray<T> _previous;

    FragmentedArray(T item) {
        this(item, null);
    }

    FragmentedArray(T item, FragmentedArray<T> previous) {
        setArray(item);
        if (previous != null) {
            previous._next = this;
            _previous = previous;
        }
    }

    T getArray() {
        return _item;
    }

    void setArray(T item) {
        assert(item.getClass().isArray());

        _item = item;
    }

    FragmentedArray<T> getNext() {
        return _next;
    }

    void setNext(FragmentedArray<T> next) {
        _next = next;
        if (next != null) {
            next._previous = this;
        }
    }

    FragmentedArray<T> getPrevious() {
        return _previous;
    }

    void setPrevious(FragmentedArray<T> previous) {
        _previous = previous;
        if (previous != null) {
            previous._next = this;
        }
    }
}
