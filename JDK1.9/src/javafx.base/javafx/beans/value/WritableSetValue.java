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

import javafx.collections.ObservableSet;

/**
 * A writable reference to an {@link javafx.collections.ObservableSet}.
 *
 * @see javafx.collections.ObservableSet
 * @see javafx.beans.value.WritableObjectValue
 * @see javafx.beans.value.WritableSetValue
 *
 * @param <E> the type of the {@code Set} elements
 * @since JavaFX 2.1
 */
public interface WritableSetValue<E> extends WritableObjectValue<ObservableSet<E>>, ObservableSet<E> {
}
