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

import javafx.beans.binding.StringExpression;

/**
 * Superclass for all readonly properties wrapping an {@code String}.
 *
 * @see javafx.beans.value.ObservableStringValue
 * @see javafx.beans.binding.StringExpression
 * @see ReadOnlyProperty
 *
 * @since JavaFX 2.0
 */
public abstract class ReadOnlyStringProperty extends StringExpression implements
        ReadOnlyProperty<String> {

    /**
     * The constructor of {@code ReadOnlyStringProperty}.
     */
    public ReadOnlyStringProperty() {
    }

    /**
     * Returns a string representation of this {@code ReadOnlyStringProperty} object.
     * @return a string representation of this {@code ReadOnlyStringProperty} object.
     */
    @Override
    public String toString() {
        final Object bean = getBean();
        final String name = getName();
        final StringBuilder result = new StringBuilder(
                "ReadOnlyStringProperty [");
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
