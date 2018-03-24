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
 * Expression representing a variable value.
 */
public class VariableExpression extends Expression<Object> {
    private KeyPath keyPath;

    public VariableExpression(KeyPath keyPath) {
        if (keyPath == null) {
            throw new NullPointerException();
        }

        this.keyPath = keyPath;
    }

    /**
     * Returns the path to the variable associated with this expression.
     */
    public KeyPath getKeyPath() {
        return keyPath;
    }

    @Override
    public Object evaluate(Object namespace) {
        return get(namespace, keyPath);
    }

    @Override
    public void update(Object namespace, Object value) {
        set(namespace, keyPath, value);
    }

    @Override
    public boolean isDefined(Object namespace) {
        return isDefined(namespace, keyPath);
    }

    @Override
    public boolean isLValue() {
        return true;
    }

    @Override
    protected void getArguments(List<KeyPath> arguments) {
        arguments.add(keyPath);
    }

    @Override
    public String toString() {
        return keyPath.toString();
    }
}
