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

package javafx.collections;

import javafx.beans.NamedArg;
import javafx.beans.WeakListener;

import java.lang.ref.WeakReference;

/**
 * A {@code WeakMapChangeListener} can be used, if an {@link javafx.collections.ObservableMap}
 * should only maintain a weak reference to the listener. This helps to avoid
 * memory leaks, that can occur if observers are not unregistered from observed
 * objects after use.
 * <p>
 * {@code WeakMapChangeListener} are created by passing in the original
 * {@link javafx.collections.MapChangeListener}. The {@code WeakMapChangeListener} should then be
 * registered to listen for changes of the observed object.
 * <p>
 * Note: You have to keep a reference to the {@code MapChangeListener}, that
 * was passed in as long as it is in use, otherwise it will be garbage collected
 * to soon.
 *
 * @see MapChangeListener
 * @see ObservableMap
 * @see javafx.beans.WeakListener
 *
 * @param <K> the key element type
 * @param <V> the value element type
 *
 * @since JavaFX 2.1
 */
public final class WeakMapChangeListener<K, V> implements MapChangeListener<K, V>, WeakListener {

    private final WeakReference<MapChangeListener<K, V>> ref;

    /**
     * The constructor of {@code WeakMapChangeListener}.
     *
     * @param listener
     *            The original listener that should be notified
     */
    public WeakMapChangeListener(@NamedArg("listener") MapChangeListener<K, V> listener) {
        if (listener == null) {
            throw new NullPointerException("Listener must be specified.");
        }
        this.ref = new WeakReference<MapChangeListener<K, V>>(listener);
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
    public void onChanged(Change<? extends K,? extends V> change) {
        final MapChangeListener<K, V> listener = ref.get();
        if (listener != null) {
            listener.onChanged(change);
        } else {
            // The weakly reference listener has been garbage collected,
            // so this WeakListener will now unhook itself from the
            // source bean
            change.getMap().removeListener(this);
        }
    }
}
