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
 * JAtoms: Simple code components that merely generate themselves.
 */
final class JAtom extends JExpressionImpl {

    private final String what;

    JAtom(String what) {
        this.what = what;
    }

    public void generate(JFormatter f) {
        f.p(what);
    }
}
