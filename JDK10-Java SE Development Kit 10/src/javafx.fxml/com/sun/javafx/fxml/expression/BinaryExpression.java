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
import java.util.function.BiFunction;

/**
 * Abstract base class for binary expressions.
 */
public final class BinaryExpression<U, T> extends Expression<T> {
    private final BiFunction<U, U, T> evaluator;
    private final Expression<U> left;
    private final Expression<U> right;

    public BinaryExpression(Expression<U> left, Expression<U> right, BiFunction<U, U, T> evaluator) {
        if (left == null) {
            throw new NullPointerException();
        }

        if (right == null) {
            throw new NullPointerException();
        }

        this.left = left;
        this.right = right;
        this.evaluator = evaluator;
    }

    @Override
    public T evaluate(Object namespace) {
        return evaluator.apply(left.evaluate(namespace), right.evaluate(namespace));
    }

    @Override
    public void update(Object namespace, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefined(Object namespace) {
        return left.isDefined(namespace) && right.isDefined(namespace);
    }

    @Override
    public boolean isLValue() {
        return false;
    }

    @Override
    protected void getArguments(List<KeyPath> arguments) {
        left.getArguments(arguments);
        right.getArguments(arguments);
    }

}
