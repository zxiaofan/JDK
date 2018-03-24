/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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
package javafx.scene.shape;

import javafx.collections.ObservableIntegerArray;

/**
 * {@code ObservableFaceArray} is an {@code int[]} array that allows listeners
 * to track changes when they occur. In order to track changes, the internal
 * array is encapsulated and there is no direct access available from the outside.
 * Bulk operations are supported but they always do a copy of the data range.
 * This class is used when defining the faces of a {@link TriangleMesh}.
 *
 * @see javafx.collections.ArrayChangeListener
 * @since JavaFX 8.0
 */
public interface ObservableFaceArray extends ObservableIntegerArray {

}
