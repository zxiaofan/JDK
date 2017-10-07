/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
import javafx.beans.value.ObservableIntegerValue;

/**
 * A simple IntegerExpression that represents a single constant value.
 */
public final class IntegerConstant implements ObservableIntegerValue {

    private final int value;

    private IntegerConstant(int value) {
        this.value = value;
    }

    public static IntegerConstant valueOf(int value) {
        return new IntegerConstant(value);
    }

    @Override
    public int get() {
        return value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void addListener(InvalidationListener observer) {
        // no-op
    }

    @Override
    public void addListener(ChangeListener<? super Number> listener) {
        // no-op
    }

    @Override
    public void removeListener(InvalidationListener observer) {
        // no-op
    }

    @Override
    public void removeListener(ChangeListener<? super Number> listener) {
        // no-op
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}
