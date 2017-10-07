/*
 * Copyright (c) 1995, 2003, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
abstract public
class DivRemExpression extends BinaryArithmeticExpression {
    /**
     * constructor
     */
    public DivRemExpression(int op, long where, Expression left, Expression right) {
        super(op, where, left, right);
    }

    /**
     * Inline
     */
    public Expression inline(Environment env, Context ctx) {
        // Do not toss out integer divisions or remainders since they
        // can cause a division by zero.
        if (type.inMask(TM_INTEGER)) {
            right = right.inlineValue(env, ctx);
            if (right.isConstant() && !right.equals(0)) {
                // We know the division can be elided
                left = left.inline(env, ctx);
                return left;
            } else {
                left = left.inlineValue(env, ctx);
                try {
                    return eval().simplify();
                } catch (ArithmeticException e) {
                    env.error(where, "arithmetic.exception");
                    return this;
                }
            }
        } else {
            // float & double divisions don't cause arithmetic errors
            return super.inline(env, ctx);
        }
    }
}
