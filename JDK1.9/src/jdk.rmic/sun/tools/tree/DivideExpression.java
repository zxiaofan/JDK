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
import java.util.Hashtable;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class DivideExpression extends DivRemExpression {
    /**
     * constructor
     */
    public DivideExpression(long where, Expression left, Expression right) {
        super(DIV, where, left, right);
    }

    /**
     * Evaluate
     */
    Expression eval(int a, int b) {
        return new IntExpression(where, a / b);
    }
    Expression eval(long a, long b) {
        return new LongExpression(where, a / b);
    }
    Expression eval(float a, float b) {
        return new FloatExpression(where, a / b);
    }
    Expression eval(double a, double b) {
        return new DoubleExpression(where, a / b);
    }

    /**
     * Simplify
     */
    Expression simplify() {
        // This code here was wrong.  What if the expression is a float?
        // In any case, if the expression throws an exception, we
        // should just throw the exception at run-time.  Throwing
        // it at compile-time is not correct.
        // (Fix for 4019300)
        //
        // if (right.equals(0)) {
        //      throw new ArithmeticException("/ by zero");
        // }
        if (right.equals(1)) {
            return left;
        }
        return this;
    }

    /**
     * Code
     */
    void codeOperation(Environment env, Context ctx, Assembler asm) {
        asm.add(where, opc_idiv + type.getTypeCodeOffset());
    }
}
