/*
 * Copyright (c) 1994, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.tree;

import sun.tools.java.*;
import java.io.PrintStream;
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class CaseStatement extends Statement {
    Expression expr;

    /**
     * Constructor
     */
    public CaseStatement(long where, Expression expr) {
        super(CASE, where);
        this.expr = expr;
    }

    /**
     * Check statement
     */
    Vset check(Environment env, Context ctx, Vset vset, Hashtable<Object, Object> exp) {
        if (expr != null) {
            expr.checkValue(env, ctx, vset, exp);
            expr = convert(env, ctx, Type.tInt, expr);
            expr = expr.inlineValue(env, ctx);
        }
        return vset.clearDeadEnd();
    }

    /**
     * The cost of inlining this statement
     */
    public int costInline(int thresh, Environment env, Context ctx) {
        return 6;
    }

    /**
     * Print
     */
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        if (expr == null) {
            out.print("default");
        } else {
            out.print("case ");
            expr.print(out);
        }
        out.print(":");
    }
}
