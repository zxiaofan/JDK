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
import sun.tools.asm.Label;
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class OrExpression extends BinaryLogicalExpression {
    /**
     * constructor
     */
    public OrExpression(long where, Expression left, Expression right) {
        super(OR, where, left, right);
    }

    /*
     * Check an "or" expression.
     *
     * cvars is modified so that
     *    cvar.vsTrue indicates variables with a known value if
     *        either the left and right hand side isn true
     *    cvars.vsFalse indicates variables with a known value if
     *        both the left or right hand side are false
     */
    public void checkCondition(Environment env, Context ctx, Vset vset,
                               Hashtable<Object, Object> exp, ConditionVars cvars) {
        // Find out when the left side is true/false
        left.checkCondition(env, ctx, vset, exp, cvars);
        left = convert(env, ctx, Type.tBoolean, left);
        Vset vsTrue = cvars.vsTrue.copy();
        Vset vsFalse = cvars.vsFalse.copy();

        // Only look at the right side if the left side is false
        right.checkCondition(env, ctx, vsFalse, exp, cvars);
        right = convert(env, ctx, Type.tBoolean, right);

        // cvars.vsFalse actually reports that both returned false
        // cvars.vsTrue must be set back to either left side or the right
        //     side returning false;
        cvars.vsTrue = cvars.vsTrue.join(vsTrue);
    }

    /**
     * Evaluate
     */
    Expression eval(boolean a, boolean b) {
        return new BooleanExpression(where, a || b);
    }

    /**
     * Simplify
     */
    Expression simplify() {
        if (right.equals(false)) {
            return left;
        }
        if (left.equals(true)) {
            return left;
        }
        if (left.equals(false)) {
            return right;
        }
        if (right.equals(true)) {
            // Preserve effects of left argument.
            return new CommaExpression(where, left, right).simplify();
        }
        return this;
    }

    /**
     * Code
     */
    void codeBranch(Environment env, Context ctx, Assembler asm, Label lbl, boolean whenTrue) {
        if (whenTrue) {
            left.codeBranch(env, ctx, asm, lbl, true);
            right.codeBranch(env, ctx, asm, lbl, true);
        } else {
            Label lbl2 = new Label();
            left.codeBranch(env, ctx, asm, lbl2, true);
            right.codeBranch(env, ctx, asm, lbl, false);
            asm.add(lbl2);
        }
    }
}
