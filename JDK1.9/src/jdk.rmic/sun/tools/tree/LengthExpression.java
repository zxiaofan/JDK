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
class LengthExpression extends UnaryExpression {
    /**
     * Constructor
     */
    public LengthExpression(long where, Expression right) {
        super(LENGTH, where, Type.tInt, right);
    }

    /**
     * Select the type of the expression
     */
    public Vset checkValue(Environment env, Context ctx, Vset vset, Hashtable<Object, Object> exp) {
        vset = right.checkValue(env, ctx, vset, exp);
        if (!right.type.isType(TC_ARRAY)) {
            env.error(where, "invalid.length", right.type);
        }
        return vset;
    }

    /**
     * Code
     */
    public void codeValue(Environment env, Context ctx, Assembler asm) {
        right.codeValue(env, ctx, asm);
        asm.add(where, opc_arraylength);
    }
}
