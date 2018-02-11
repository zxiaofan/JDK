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

package com.sun.javafx.fxml.expression;

import java.util.List;

/**
 * Expression representing a literal value.
 */
public class LiteralExpression<T> extends Expression<T> {
    private T value;

    public LiteralExpression(T value) {
        this.value = value;
    }

    @Override
    public T evaluate(Object namespace) {
        return value;
    }

    @Override
    public void update(Object namespace, T value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefined(Object namespace) {
        return true;
    }

    @Override
    public boolean isLValue() {
        return false;
    }

    @Override
    protected void getArguments(List<KeyPath> arguments) {
        // No-op
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
