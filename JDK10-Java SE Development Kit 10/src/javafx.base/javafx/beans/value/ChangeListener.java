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

package javafx.beans.value;

/**
 * A {@code ChangeListener} is notified whenever the value of an
 * {@link ObservableValue} changes. It can be registered and unregistered with
 * {@link ObservableValue#addListener(ChangeListener)} respectively
 * {@link ObservableValue#removeListener(ChangeListener)}
 * <p>
 * For an in-depth explanation of change events and how they differ from
 * invalidation events, see the documentation of {@code ObservableValue}.
 * <p>
 * The same instance of {@code ChangeListener} can be registered to listen to
 * multiple {@code ObservableValues}.
 *
 * @see ObservableValue
 *
 *
 * @since JavaFX 2.0
 */
@FunctionalInterface
public interface ChangeListener<T> {

    /**
     * This method needs to be provided by an implementation of
     * {@code ChangeListener}. It is called if the value of an
     * {@link ObservableValue} changes.
     * <p>
     * In general is is considered bad practice to modify the observed value in
     * this method.
     *
     * @param observable
     *            The {@code ObservableValue} which value changed
     * @param oldValue
     *            The old value
     * @param newValue
     *            The new value
     */
    void changed(ObservableValue<? extends T> observable, T oldValue, T newValue);
}
