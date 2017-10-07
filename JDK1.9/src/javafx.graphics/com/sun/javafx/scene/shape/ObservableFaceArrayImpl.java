/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.javafx.scene.shape;

import com.sun.javafx.collections.ObservableIntegerArrayImpl;
import javafx.scene.shape.ObservableFaceArray;

public class ObservableFaceArrayImpl extends ObservableIntegerArrayImpl implements ObservableFaceArray {

    /**
     * Creates empty observable Face array
     */
    public ObservableFaceArrayImpl() {
    }

    /**
     * Creates observable Face array with copy of given initial values
     * @param elements initial values to copy to observable integer array
     */
    public ObservableFaceArrayImpl(int... elements) {
        super(elements);
    }

    /**
     * Creates observable Face array with copy of given observable Face array
     * @param src observable integer array to copy
     */
    public ObservableFaceArrayImpl(ObservableFaceArray src) {
        super(src);
    }

}

