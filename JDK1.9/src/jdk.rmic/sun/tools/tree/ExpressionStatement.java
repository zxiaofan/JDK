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
import sun.tools.asm.Assembler;
import java.io.PrintStream;
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class ExpressionStatement extends Statement {
    Expression expr;

    /**
     * Constructor
     */
    public ExpressionStatement(long where, Expression expr) {
        super(EXPRESSION, where);
        this.expr = expr;
    }

    /**
     * Check statement
     */
    Vset check(Environment env, Context ctx, Vset vset, Hashtable<Object, Object> exp) {
        checkLabel(env, ctx);
        return expr.check(env, ctx, reach(env, vset), exp);
    }

    /**
     * Inline
     */
    public Statement inline(Environment env, Context ctx) {
        if (expr != null) {
            expr = expr.inline(env, ctx);
            return (expr == null) ? null : this;
        }
        return null;
    }

    /**
     * Create a copy of the statement for method inlining
     */
    public Statement copyInline(Context ctx, boolean valNeeded) {
        ExpressionStatement s = (ExpressionStatement)clone();
        s.expr = expr.copyInline(ctx);
        return s;
    }

    /**
     * The cost of inlining this statement
     */
    public int costInline(int thresh, Environment env, Context ctx) {
        return expr.costInline(thresh, env, ctx);
    }

    /**
     * Code
     */
    public void code(Environment env, Context ctx, Assembler asm) {
        expr.code(env, ctx, asm);
    }

    /**
     * Check if the first thing is a constructor invocation
     */
    public Expression firstConstructor() {
        return expr.firstConstructor();
    }

    /**
     * Print
     */
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        if (expr != null) {
            expr.print(out);
        } else {
            out.print("<empty>");
        }
        out.print(";");
    }
}
