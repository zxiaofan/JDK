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
 * JBreak statement
 */
final class JBreak implements JStatement {

    private final JLabel label;

    /**
     * JBreak constructor
     *
     * @param   _label
     *      break label or null.
     */
    JBreak( JLabel _label ) {
        this.label = _label;
    }

    public void state(JFormatter f) {
        if( label==null )
            f.p("break;").nl();
        else
            f.p("break").p(label.label).p(';').nl();
    }
}
