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
 * Do loops
 */

public class JDoLoop implements JStatement {

    /**
     * Test part of Do statement for determining exit state
     */
    private JExpression test;

    /**
     * JBlock of statements which makes up body of this Do statement
     */
    private JBlock body = null;

    /**
     * Construct a Do statment
     */
    JDoLoop(JExpression test) {
        this.test = test;
    }

    public JBlock body() {
        if (body == null) body = new JBlock();
        return body;
    }

    public void state(JFormatter f) {
        f.p("do");
        if (body != null)
            f.g(body);
        else
            f.p("{ }");

        if (JOp.hasTopOp(test)) {
            f.p("while ").g(test);
        } else {
            f.p("while (").g(test).p(')');
        }
        f.p(';').nl();
    }

}
