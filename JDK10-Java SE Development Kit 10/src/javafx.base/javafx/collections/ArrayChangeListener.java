/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package javafx.collections;

/**
 * Interface that receives notifications of changes to an ObservableArray.
 * @since JavaFX 8.0
 */
public interface ArrayChangeListener<T extends ObservableArray<T>> {

    /**
     * Called after a change has been made to an ObservableArray.
     *
     * @param observableArray the array that changed
     * @param sizeChanged indicates size of array changed
     * @param from A beginning (inclusive) of an interval related to the change
     * @param to An end (exclusive) of an interval related to the change.
     */
    public void onChanged(T observableArray, boolean sizeChanged, int from, int to);
}
