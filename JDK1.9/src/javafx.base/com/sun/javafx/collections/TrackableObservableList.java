/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.collections;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;

/**
 *
 */
public abstract class TrackableObservableList<T> extends ObservableListWrapper<T>{

    public TrackableObservableList(List<T> list) {
        super(list);
    }

    public TrackableObservableList() {
        super(new ArrayList<T>());
        addListener((Change<? extends T> c) -> {
            TrackableObservableList.this.onChanged((Change<T>)c);
        });
    }

    protected abstract void onChanged(Change<T> c);

}
