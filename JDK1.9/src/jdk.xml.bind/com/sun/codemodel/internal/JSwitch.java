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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Switch statement
 */
public final class JSwitch implements JStatement {

    /**
     * Test part of switch statement.
     */
    private JExpression test;

    /**
     * vector of JCases.
     */
    private List<JCase> cases = new ArrayList<JCase>();

    /**
     * a single default case
     */
    private JCase defaultCase = null;

    /**
     * Construct a While statment
     */
    JSwitch(JExpression test) {
        this.test = test;
    }

    public JExpression test() { return test; }

    public Iterator<JCase> cases() { return cases.iterator(); }

    public JCase _case( JExpression label ) {
        JCase c = new JCase( label );
        cases.add(c);
        return c;
    }

    public JCase _default() {
        // what if (default != null) ???

        // default cases statements don't have a label
        defaultCase = new JCase(null, true);
        return defaultCase;
    }

    public void state(JFormatter f) {
        if (JOp.hasTopOp(test)) {
            f.p("switch ").g(test).p(" {").nl();
        } else {
            f.p("switch (").g(test).p(')').p(" {").nl();
        }
        for( JCase c : cases )
            f.s(c);
        if( defaultCase != null )
            f.s( defaultCase );
        f.p('}').nl();
    }

}
