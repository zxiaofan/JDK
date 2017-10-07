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
 * Case statement
 */
public final class JCase implements JStatement {

    /**
     * label part of the case statement
     */
    private JExpression label;

    /**
     * JBlock of statements which makes up body of this While statement
     */
    private JBlock body = null;

    /**
     * is this a regular case statement or a default case statement?
     */
    private boolean isDefaultCase = false;

    /**
     * Construct a case statement
     */
    JCase(JExpression label) {
        this(label, false);
    }

    /**
     * Construct a case statement.  If isDefaultCase is true, then
     * label should be null since default cases don't have a label.
     */
    JCase(JExpression label, boolean isDefaultCase) {
        this.label = label;
        this.isDefaultCase = isDefaultCase;
    }

    public JExpression label() {
        return label;
    }

    public JBlock body() {
        if (body == null) body=new JBlock( false, true );
        return body;
    }

    public void state(JFormatter f) {
        f.i();
        if( !isDefaultCase ) {
            f.p("case ").g(label).p(':').nl();
        } else {
            f.p("default:").nl();
        }
        if (body != null)
            f.s(body);
        f.o();
    }
}
