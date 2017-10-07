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

import javafx.collections.ObservableList;

/**
 * A writable reference to an {@link javafx.collections.ObservableList}.
 *
 * @see javafx.collections.ObservableList
 * @see javafx.beans.value.WritableObjectValue
 * @see javafx.beans.value.WritableListValue
 *
 * @param <E> the type of the {@code List} elements
 * @since JavaFX 2.1
 */
public interface WritableListValue<E> extends WritableObjectValue<ObservableList<E>>, ObservableList<E> {
}
