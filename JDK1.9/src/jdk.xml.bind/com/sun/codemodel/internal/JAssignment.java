/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.codemodel.internal;


/**
 * Assignment statements, which are also expressions.
 */
public class JAssignment extends JExpressionImpl implements JStatement {

    JAssignmentTarget lhs;
    JExpression rhs;
    String op = "";

    JAssignment(JAssignmentTarget lhs, JExpression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    JAssignment(JAssignmentTarget lhs, JExpression rhs, String op) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }

    public void generate(JFormatter f) {
        f.g(lhs).p(op + '=').g(rhs);
    }

    public void state(JFormatter f) {
        f.g(this).p(';').nl();
    }

}
