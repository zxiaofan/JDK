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
 * ForEach Statement
 * This will generate the code for statement based on the new
 * j2se 1.5 j.l.s.
 *
 * @author Bhakti
 */
public final class JForEach implements JStatement {

        private final JType type;
        private final String var;
        private JBlock body = null; // lazily created
        private final JExpression collection;
    private final JVar loopVar;

        public JForEach(JType vartype, String variable, JExpression collection) {

                this.type = vartype;
                this.var = variable;
                this.collection = collection;
        loopVar = new JVar(JMods.forVar(JMod.NONE), type, var, collection);
    }


    /**
     * Returns a reference to the loop variable.
     */
        public JVar var() {
                return loopVar;
        }

        public JBlock body() {
                if (body == null)
                        body = new JBlock();
                return body;
        }

        public void state(JFormatter f) {
                f.p("for (");
                f.g(type).id(var).p(": ").g(collection);
                f.p(')');
                if (body != null)
                        f.g(body).nl();
                else
                        f.p(';').nl();
        }

}
