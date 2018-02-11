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
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
abstract public
class BinaryLogicalExpression extends BinaryExpression {
    /**
     * constructor
     */
    public BinaryLogicalExpression(int op, long where, Expression left, Expression right) {
        super(op, where, Type.tBoolean, left, right);
    }

    /**
     * Check a binary expression
     */
    public Vset checkValue(Environment env, Context ctx,
                           Vset vset, Hashtable<Object, Object> exp) {
        ConditionVars cvars = new ConditionVars();
        // evaluate the logical expression, determining which variables are
        // set if the resulting value is true or false
        checkCondition(env, ctx, vset, exp, cvars);
        // return the intersection.
        return cvars.vsTrue.join(cvars.vsFalse);
    }

    /*
     * Every subclass of this class must define a genuine implementation
     * of this method.  It cannot inherit the method of Expression.
     */
    abstract
    public void checkCondition(Environment env, Context ctx, Vset vset,
                               Hashtable<Object, Object> exp, ConditionVars cvars);


    /**
     * Inline
     */
    public Expression inline(Environment env, Context ctx) {
        left = left.inlineValue(env, ctx);
        right = right.inlineValue(env, ctx);
        return this;
    }
}
