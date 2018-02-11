/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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



enum Operator {
    NEGATE(6),
    NOT(6),
    MULTIPLY(5),
    DIVIDE(5),
    MODULO(5),
    ADD(4),
    SUBTRACT(4),
    GREATER_THAN(3),
    GREATER_THAN_OR_EQUAL_TO(3),
    LESS_THAN(3),
    LESS_THAN_OR_EQUAL_TO(3),
    EQUAL_TO(2),
    NOT_EQUAL_TO(2),
    AND(1),
    OR(0);
    private final int priority;

    public static final int MAX_PRIORITY = 6;

    Operator(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

}
