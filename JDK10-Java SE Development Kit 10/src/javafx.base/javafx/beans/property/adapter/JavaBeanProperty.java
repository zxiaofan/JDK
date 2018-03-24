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

package javafx.beans.property.adapter;

import javafx.beans.property.Property;

/**
 * {@code JavaBeanProperty} is the super interface of all adapters between
 * writable Java Bean properties and JavaFX properties.
 *
 * @param <T> The type of the wrapped property
 * @since JavaFX 2.1
 */
public interface JavaBeanProperty<T> extends ReadOnlyJavaBeanProperty<T>, Property<T> {
}
