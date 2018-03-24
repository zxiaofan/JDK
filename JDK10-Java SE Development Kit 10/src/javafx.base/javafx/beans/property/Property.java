/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;

/**
 * Generic interface that defines the methods common to all (writable)
 * properties independent of their type.
 *
 *
 * @param <T>
 *            the type of the wrapped value
 * @since JavaFX 2.0
 */
public interface Property<T> extends ReadOnlyProperty<T>, WritableValue<T> {

    /**
     * Create a unidirection binding for this {@code Property}.
     * <p>
     * Note that JavaFX has all the bind calls implemented through weak listeners. This means the bound property
     * can be garbage collected and stopped from being updated.
     *
     * @param observable
     *            The observable this {@code Property} should be bound to.
     * @throws NullPointerException
     *             if {@code observable} is {@code null}
     */
    void bind(ObservableValue<? extends T> observable);

    /**
     * Remove the unidirectional binding for this {@code Property}.
     *
     * If the {@code Property} is not bound, calling this method has no effect.
     * @see #bind(javafx.beans.value.ObservableValue)
     */
    void unbind();

    /**
     * Can be used to check, if a {@code Property} is bound.
     * @see #bind(javafx.beans.value.ObservableValue)
     *
     * @return {@code true} if the {@code Property} is bound, {@code false}
     *         otherwise
     */
    boolean isBound();

    /**
     * Create a bidirectional binding between this {@code Property} and another
     * one.
     * Bidirectional bindings exists independently of unidirectional bindings. So it is possible to
     * add unidirectional binding to a property with bidirectional binding and vice-versa. However, this practice is
     * discouraged.
     * <p>
     * It is possible to have multiple bidirectional bindings of one Property.
     * <p>
     * JavaFX bidirectional binding implementation use weak listeners. This means bidirectional binding does not prevent
     * properties from being garbage collected.
     *
     * @param other
     *            the other {@code Property}
     * @throws NullPointerException
     *             if {@code other} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code other} is {@code this}
     */
    void bindBidirectional(Property<T> other);

    /**
     * Remove a bidirectional binding between this {@code Property} and another
     * one.
     *
     * If no bidirectional binding between the properties exists, calling this
     * method has no effect.
     *
     * It is possible to unbind by a call on the second property. This code will work:
     *
     * <blockquote><pre>
     *     property1.bindBirectional(property2);
     *     property2.unbindBidirectional(property1);
     * </pre></blockquote>
     *
     * @param other
     *            the other {@code Property}
     * @throws NullPointerException
     *             if {@code other} is {@code null}
     * @throws IllegalArgumentException
     *             if {@code other} is {@code this}
     */
    void unbindBidirectional(Property<T> other);

}
