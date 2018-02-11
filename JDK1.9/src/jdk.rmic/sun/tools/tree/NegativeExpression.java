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

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class NegativeExpression extends UnaryExpression {
    /**
     * Constructor
     */
    public NegativeExpression(long where, Expression right) {
        super(NEG, where, right.type, right);
    }

    /**
     * Select the type of the expression
     */
    void selectType(Environment env, Context ctx, int tm) {
        if ((tm & TM_DOUBLE) != 0) {
            type = Type.tDouble;
        } else if ((tm & TM_FLOAT) != 0) {
            type = Type.tFloat;
        } else if ((tm & TM_LONG) != 0) {
            type = Type.tLong;
        } else {
            type = Type.tInt;
        }
        right = convert(env, ctx, type, right);
    }

    /**
     * Evaluate
     */
    Expression eval(int a) {
        return new IntExpression(where, -a);
    }
    Expression eval(long a) {
        return new LongExpression(where, -a);
    }
    Expression eval(float a) {
        return new FloatExpression(where, -a);
    }
    Expression eval(double a) {
        return new DoubleExpression(where, -a);
    }

    /**
     * Simplify
     */
    Expression simplify() {
        if (right.op == NEG) {
            return ((NegativeExpression)right).right;
        }
        return this;
    }

    /**
     * Code
     */
    public void codeValue(Environment env, Context ctx, Assembler asm) {
        right.codeValue(env, ctx, asm);
        asm.add(where, opc_ineg + type.getTypeCodeOffset());
    }
}
