/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.javafx.scene.control;

import java.util.LinkedList;
import java.util.List;

/**
 * A list that has a maximum size. Useful for recording historical data, but not
 * too much of it.
 *
 * <p>Items are added at the front of the list. That is, the item at index 0 is
 * more recent than that added at index 1. In this regard, this class resembles
 * a stack.</p>
 *
 * @param <E> The type of the items added into the list.
 */
public class SizeLimitedList<E> {
    private final int maxSize;
    private final List<E> backingList;

    public SizeLimitedList(int maxSize) {
        this.maxSize = maxSize;
        this.backingList = new LinkedList<>();
    }

    public E get(int index) {
        return backingList.get(index);
    }

    public void add(E item) {
        backingList.add(0, item);

        if (backingList.size() > maxSize) {
            backingList.remove(maxSize);
        }
    }

    public int size() {
        return backingList.size();
    }

    public boolean contains(E item) {
        return backingList.contains(item);
    }
}
