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
 * An observable long value.
 *
 * @see ObservableValue
 * @see ObservableNumberValue
 *
 *
 * @since JavaFX 2.0
 */
public interface ObservableLongValue extends ObservableNumberValue {

    /**
     * Returns the current value of this {@code ObservableLongValue}.
     *
     * @return The current value
     */
    long get();
}
