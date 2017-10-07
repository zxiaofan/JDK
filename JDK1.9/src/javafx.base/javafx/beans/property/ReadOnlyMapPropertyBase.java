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

package javafx.beans.property;

import com.sun.javafx.binding.MapExpressionHelper;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

/**
 * Base class for all readonly properties wrapping an {@link javafx.collections.ObservableMap}.
 * This class provides a default implementation to attach listener.
 *
 * @see ReadOnlyMapProperty
 * @since JavaFX 2.1
 */
public abstract class ReadOnlyMapPropertyBase<K, V> extends ReadOnlyMapProperty<K, V> {

    private MapExpressionHelper<K, V> helper;

    @Override
    public void addListener(InvalidationListener listener) {
        helper = MapExpressionHelper.addListener(helper, this, listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        helper = MapExpressionHelper.removeListener(helper, listener);
    }

    @Override
    public void addListener(ChangeListener<? super ObservableMap<K, V>> listener) {
        helper = MapExpressionHelper.addListener(helper, this, listener);
    }

    @Override
    public void removeListener(ChangeListener<? super ObservableMap<K, V>> listener) {
        helper = MapExpressionHelper.removeListener(helper, listener);
    }

    @Override
    public void addListener(MapChangeListener<? super K, ? super V> listener) {
        helper = MapExpressionHelper.addListener(helper, this, listener);
    }

    @Override
    public void removeListener(MapChangeListener<? super K, ? super V> listener) {
        helper = MapExpressionHelper.removeListener(helper, listener);
    }

    /**
     * This method needs to be called if the reference to the
     * {@link javafx.collections.ObservableList} changes.
     *
     * It sends notifications to all attached
     * {@link javafx.beans.InvalidationListener InvalidationListeners},
     * {@link javafx.beans.value.ChangeListener ChangeListeners}, and
     * {@link javafx.collections.ListChangeListener}.
     *
     * This method needs to be called, if the value of this property changes.
     */
    protected void fireValueChangedEvent() {
        MapExpressionHelper.fireValueChangedEvent(helper);
    }

    /**
     * This method needs to be called if the content of the referenced
     * {@link javafx.collections.ObservableList} changes.
     *
     * Sends notifications to all attached
     * {@link javafx.beans.InvalidationListener InvalidationListeners},
     * {@link javafx.beans.value.ChangeListener ChangeListeners}, and
     * {@link javafx.collections.ListChangeListener}.
     *
     * This method is called when the content of the list changes.
     *
     * @param change the change that needs to be propagated
     */
    protected void fireValueChangedEvent(MapChangeListener.Change<? extends K, ? extends V> change) {
        MapExpressionHelper.fireValueChangedEvent(helper, change);
    }



}
