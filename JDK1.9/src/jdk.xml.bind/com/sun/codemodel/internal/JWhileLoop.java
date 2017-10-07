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
 * While statement
 */

public class JWhileLoop implements JStatement {

    /**
     * Test part of While statement for determining exit state
     */
    private JExpression test;

    /**
     * JBlock of statements which makes up body of this While statement
     */
    private JBlock body = null;

    /**
     * Construct a While statment
     */
    JWhileLoop(JExpression test) {
        this.test = test;
    }

    public JExpression test() {
        return test;
    }

    public JBlock body() {
        if (body == null) body = new JBlock();
        return body;
    }

    public void state(JFormatter f) {
        if (JOp.hasTopOp(test)) {
            f.p("while ").g(test);
        } else {
            f.p("while (").g(test).p(')');
        }
        if (body != null)
            f.s(body);
        else
            f.p(';').nl();
    }

}
