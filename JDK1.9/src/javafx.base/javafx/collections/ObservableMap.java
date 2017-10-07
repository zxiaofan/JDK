/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javafx.collections;

import java.util.Map;

import javafx.beans.Observable;

/**
 * A map that allows observers to track changes when they occur.
 *
 * @see MapChangeListener
 * @see MapChangeListener.Change
 * @since JavaFX 2.0
 */
public interface ObservableMap<K, V> extends Map<K, V>, Observable {
    /**
     * Add a listener to this observable map.
     * @param listener the listener for listening to the list changes
     */
    public void addListener(MapChangeListener<? super K, ? super V> listener);
    /**
     * Tries to removed a listener from this observable map. If the listener is not
     * attached to this map, nothing happens.
     * @param listener a listener to remove
     */
    public void removeListener(MapChangeListener<? super K, ? super V> listener);
}
