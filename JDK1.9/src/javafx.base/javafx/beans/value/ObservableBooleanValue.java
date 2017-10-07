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
 * An observable boolean value.
 *
 * @see ObservableValue
 *
 *
 * @since JavaFX 2.0
 */
public interface ObservableBooleanValue extends ObservableValue<Boolean> {

    /**
     * Returns the current value of this {@code ObservableBooleanValue}.
     *
     * @return The current value
     */
    boolean get();
}
