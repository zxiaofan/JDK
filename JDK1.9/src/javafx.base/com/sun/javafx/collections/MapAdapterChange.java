/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.collections;

import javafx.collections.MapChangeListener;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.ObservableMap;

public class MapAdapterChange<K, V> extends MapChangeListener.Change<K, V> {
    private final Change<? extends K, ? extends V> change;

    public MapAdapterChange(ObservableMap<K, V> map, Change<? extends K, ? extends V> change) {
        super(map);
        this.change = change;
    }

    @Override
    public boolean wasAdded() {
        return change.wasAdded();
    }

    @Override
    public boolean wasRemoved() {
        return change.wasRemoved();
    }

    @Override
    public K getKey() {
        return change.getKey();
    }

    @Override
    public V getValueAdded() {
        return change.getValueAdded();
    }

    @Override
    public V getValueRemoved() {
        return change.getValueRemoved();
    }

    @Override
    public String toString() {
        return change.toString();
    }

}
