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

package javafx.beans;

/**
 * {@code WeakListener} is the super interface of all weak listener implementations
 * in the JavaFX API. Usually it should not be used directly, but instead one of the
 * sub-interfaces will be used.
 *
 * @see WeakInvalidationListener
 * @see javafx.beans.value.WeakChangeListener
 *
 *
 * @since JavaFX 2.1
 */
public interface WeakListener {
    /**
     * Returns {@code true} if the linked listener was garbage-collected.
     * In this case, the listener can be removed from the observable.
     *
     * @return {@code true} if the linked listener was garbage-collected.
     */
    boolean wasGarbageCollected();
}
