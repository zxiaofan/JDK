/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Hashtable;

/**
 * Parenthesized expressions.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */

public
class ExprExpression extends UnaryExpression {
    /**
     * Constructor
     */
    public ExprExpression(long where, Expression right) {
        super(EXPR, where, right.type, right);
    }

    /**
     * Check a condition.  We must pass it on to our unparenthesised form.
     */
    public void checkCondition(Environment env, Context ctx, Vset vset,
                               Hashtable<Object, Object> exp, ConditionVars cvars) {
        right.checkCondition(env, ctx, vset, exp, cvars);
        type = right.type;
    }

    /**
     * Check the expression if it appears as an lvalue.
     * We just pass it on to our unparenthesized subexpression.
     * (Part of fix for 4090372)
     */
    public Vset checkAssignOp(Environment env, Context ctx,
                              Vset vset, Hashtable<Object, Object> exp, Expression outside) {
        vset = right.checkAssignOp(env, ctx, vset, exp, outside);
        type = right.type;
        return vset;
    }

    /**
     * Delegate to our subexpression.
     * (Part of fix for 4090372)
     */
    public FieldUpdater getUpdater(Environment env, Context ctx) {
        return right.getUpdater(env, ctx);
    }

    // Allow (x) = 9;
    //
    // I will hold off on this until I'm sure about it.  Nobody's
    // going to clammer for this one.
    //
    // public Vset checkLHS(Environment env, Context ctx,
    //     Vset vset, Hashtable<Object, Object> exp) {
    //     vset = right.check(env, ctx, vset, exp);
    //     type = right.type;
    //     return vset;
    // }

    public boolean isNull() {
        return right.isNull();
    }

    public boolean isNonNull() {
        return right.isNonNull();
    }

    // Probably not necessary
    public Object getValue() {
        return right.getValue();
    }

    /**
     * Delegate to our subexpression.
     * See the comment in AddExpression#inlineValueSB() for
     * information about this method.
     */
    protected StringBuffer inlineValueSB(Environment env,
                                         Context ctx,
                                         StringBuffer buffer) {
        return right.inlineValueSB(env, ctx, buffer);
    }

    /**
     * Select the type of the expression
     */
    void selectType(Environment env, Context ctx, int tm) {
        type = right.type;
    }

    /**
     * Simplify
     */
    Expression simplify() {
        return right;
    }
}
