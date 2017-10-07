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

package javafx.beans.property;

import javafx.beans.value.ObservableValue;

/**
 * Generic interface that defines the methods common to all readable properties
 * independent of their type.
 *
 *
 * @param <T>
 *            the type of the wrapped value
 * @since JavaFX 2.0
 */
public interface ReadOnlyProperty<T> extends ObservableValue<T> {

    /**
     * Returns the {@code Object} that contains this property. If this property
     * is not contained in an {@code Object}, {@code null} is returned.
     *
     * @return the containing {@code Object} or {@code null}
     */
    Object getBean();

    /**
     * Returns the name of this property. If the property does not have a name,
     * this method returns an empty {@code String}.
     *
     * @return the name or an empty {@code String}
     */
    String getName();

}
