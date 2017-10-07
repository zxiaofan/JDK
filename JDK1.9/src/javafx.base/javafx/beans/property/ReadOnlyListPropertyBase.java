/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.binding.ListExpressionHelper;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Base class for all readonly properties wrapping an
 * {@link javafx.collections.ObservableList}.
 * This class provides a default implementation to attach listener.
 *
 * @see ReadOnlyListProperty
 * @since JavaFX 2.1
 */
public abstract class ReadOnlyListPropertyBase<E> extends ReadOnlyListProperty<E> {

    private ListExpressionHelper<E> helper;

    @Override
    public void addListener(InvalidationListener listener) {
        helper = ListExpressionHelper.addListener(helper, this, listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        helper = ListExpressionHelper.removeListener(helper, listener);
    }

    @Override
    public void addListener(ChangeListener<? super ObservableList<E>> listener) {
        helper = ListExpressionHelper.addListener(helper, this, listener);
    }

    @Override
    public void removeListener(ChangeListener<? super ObservableList<E>> listener) {
        helper = ListExpressionHelper.removeListener(helper, listener);
    }

    @Override
    public void addListener(ListChangeListener<? super E> listener) {
        helper = ListExpressionHelper.addListener(helper, this, listener);
    }

    @Override
    public void removeListener(ListChangeListener<? super E> listener) {
        helper = ListExpressionHelper.removeListener(helper, listener);
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
        ListExpressionHelper.fireValueChangedEvent(helper);
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
    protected void fireValueChangedEvent(ListChangeListener.Change<? extends E> change) {
        ListExpressionHelper.fireValueChangedEvent(helper, change);
    }



}
