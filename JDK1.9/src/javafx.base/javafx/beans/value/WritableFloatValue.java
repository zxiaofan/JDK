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
 * A writable float value.
 *
 * @see WritableValue
 * @see WritableNumberValue
 *
 *
 * @since JavaFX 2.0
 */
public interface WritableFloatValue extends WritableNumberValue {

    /**
     * Get the wrapped value.
     * Unlike {@link #getValue()},
     * this method returns primitive float.
     * Needs to be identical to {@link #getValue()}.
     *
     * @return The current value
     */
    float get();

    /**
     * Set the wrapped value.
     * Unlike {@link #setValue(java.lang.Number) },
     * this method uses primitive float.
     *
     * @param value
     *            The new value
     */
    void set(float value);

    /**
     * Set the wrapped value.
     * <p>
     * Note: this method should accept null without throwing an exception,
     * setting "0.0" instead.
     *
     * @param value
     *            The new value
     */
    @Override
    void setValue(Number value);
}
