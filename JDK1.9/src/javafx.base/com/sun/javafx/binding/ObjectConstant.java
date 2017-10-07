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

package com.sun.javafx.binding;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableObjectValue;

public class ObjectConstant<T> implements ObservableObjectValue<T> {

    private final T value;

    private ObjectConstant(T value) {
        this.value = value;
    }

    public static <T> ObjectConstant<T> valueOf(T value) {
        return new ObjectConstant<T>(value);
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void addListener(InvalidationListener observer) {
        // no-op
    }

    @Override
    public void addListener(ChangeListener<? super T> observer) {
        // no-op
    }

    @Override
    public void removeListener(InvalidationListener observer) {
        // no-op
    }

    @Override
    public void removeListener(ChangeListener<? super T> observer) {
        // no-op
    }
}
