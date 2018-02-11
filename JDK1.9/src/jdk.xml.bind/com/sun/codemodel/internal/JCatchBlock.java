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
 * Catch block for a try/catch/finally statement
 */

public class JCatchBlock implements JGenerable {

    JClass exception;
    private JVar var = null;
    private JBlock body = new JBlock();

    JCatchBlock(JClass exception) {
        this.exception = exception;
    }

    public JVar param(String name) {
        if (var != null) throw new IllegalStateException();
        var = new JVar(JMods.forVar(JMod.NONE), exception, name, null);
        return var;
    }

    public JBlock body() {
        return body;
    }

    public void generate(JFormatter f) {
        if (var == null)
            var = new JVar(JMods.forVar(JMod.NONE),
                    exception, "_x", null);
        f.p("catch (").b(var).p(')').g(body);
    }

}
