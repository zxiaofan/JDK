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

import javafx.beans.NamedArg;
import javafx.beans.WeakListener;

import java.lang.ref.WeakReference;

/**
 * A {@code WeakChangeListener} can be used, if an {@link ObservableValue}
 * should only maintain a weak reference to the listener. This helps to avoid
 * memory leaks, that can occur if observers are not unregistered from observed
 * objects after use.
 * <p>
 * {@code WeakChangeListener} are created by passing in the original
 * {@link ChangeListener}. The {@code WeakChangeListener} should then be
 * registered to listen for changes of the observed object.
 * <p>
 * Note: You have to keep a reference to the {@code ChangeListener}, that
 * was passed in as long as it is in use, otherwise it will be garbage collected
 * to soon.
 *
 * @see ChangeListener
 * @see ObservableValue
 *
 * @param <T>
 *            The type of the observed value
 *
 *
 * @since JavaFX 2.0
 */
public final class WeakChangeListener<T> implements ChangeListener<T>, WeakListener {

    private final WeakReference<ChangeListener<T>> ref;

    /**
     * The constructor of {@code WeakChangeListener}.
     *
     * @param listener
     *            The original listener that should be notified
     */
    public WeakChangeListener(@NamedArg("listener") ChangeListener<T> listener) {
        if (listener == null) {
            throw new NullPointerException("Listener must be specified.");
        }
        this.ref = new WeakReference<ChangeListener<T>>(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean wasGarbageCollected() {
        return (ref.get() == null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changed(ObservableValue<? extends T> observable, T oldValue,
            T newValue) {
        ChangeListener<T> listener = ref.get();
        if (listener != null) {
            listener.changed(observable, oldValue, newValue);
        } else {
            // The weakly reference listener has been garbage collected,
            // so this WeakListener will now unhook itself from the
            // source bean
            observable.removeListener(this);
        }
    }

}
