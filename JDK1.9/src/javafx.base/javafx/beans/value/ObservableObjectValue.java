/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * An observable typed {@code Object} value.
 *
 * @see ObservableValue
 *
 *
 * @since JavaFX 2.0
 */
public interface ObservableObjectValue<T> extends ObservableValue<T> {

    /**
     * Returns the current value of this {@code ObservableObjectValue<T>}.
     *
     * @return The current value
     */
    T get();
}
