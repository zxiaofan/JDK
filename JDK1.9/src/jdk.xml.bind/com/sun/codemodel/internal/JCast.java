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
 * A cast operation.
 */
final class JCast extends JExpressionImpl {
    /**
     * JType to which the expression is to be cast.
     */
    private final JType type;

    /**
     * JExpression to be cast.
     */
    private final JExpression object;

    /**
     * JCast constructor
     *
     * @param type
     *        JType to which the expression is cast
     *
     * @param object
     *        JExpression for the object upon which
     *        the cast is applied
     */
    JCast(JType type, JExpression object) {
        this.type = type;
        this.object = object;
    }

    public void generate(JFormatter f) {
        f.p("((").g(type).p(')').g(object).p(')');
    }
}
