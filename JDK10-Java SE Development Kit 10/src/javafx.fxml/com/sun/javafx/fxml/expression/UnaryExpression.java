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
import java.util.function.Function;

/**
 * Abstract base class for unary expressions.
 */
public final class UnaryExpression<U, T> extends Expression<T> {
    private final Expression<U> operand;
    private final Function<U, T> evaluator;

    public UnaryExpression(Expression<U> operand, Function<U, T> evaluator) {
        if (operand == null) {
            throw new NullPointerException();
        }

        this.operand = operand;
        this.evaluator = evaluator;
    }

    @Override
    public T evaluate(Object namespace) {
        return evaluator.apply(operand.evaluate(namespace));
    }

    @Override
    public void update(Object namespace, T value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefined(Object namespace) {
        return operand.isDefined(namespace);
    }

    @Override
    public boolean isLValue() {
        return false;
    }

    @Override
    protected void getArguments(List<KeyPath> arguments) {
        operand.getArguments(arguments);
    }

}
