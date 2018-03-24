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

import javafx.beans.binding.ObjectExpression;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

/**
 * Superclass for all readonly properties wrapping an arbitrary {@code Object}.
 *
 * For specialized implementations for {@link ObservableList}, {@link ObservableSet} and
 * {@link ObservableMap} that also report changes inside the collections, see
 * {@link ReadOnlyListProperty}, {@link ReadOnlySetProperty} and {@link ReadOnlyMapProperty}, respectively.
 *
 * @see javafx.beans.value.ObservableObjectValue
 * @see javafx.beans.binding.ObjectExpression
 * @see ReadOnlyProperty
 *
 *
 * @param <T>
 *            the type of the wrapped {@code Object}
 * @since JavaFX 2.0
 */
public abstract class ReadOnlyObjectProperty<T> extends ObjectExpression<T>
        implements ReadOnlyProperty<T> {

    /**
     * The constructor of {@code ReadOnlyObjectProperty}.
     */
    public ReadOnlyObjectProperty() {
    }

    /**
     * Returns a string representation of this {@code ReadOnlyObjectProperty} object.
     * @return a string representation of this {@code ReadOnlyObjectProperty} object.
     */
    @Override
    public String toString() {
        final Object bean = getBean();
        final String name = getName();
        final StringBuilder result = new StringBuilder(
                "ReadOnlyObjectProperty [");
        if (bean != null) {
            result.append("bean: ").append(bean).append(", ");
        }
        if ((name != null) && !name.equals("")) {
            result.append("name: ").append(name).append(", ");
        }
        result.append("value: ").append(get()).append("]");
        return result.toString();
    }

}
