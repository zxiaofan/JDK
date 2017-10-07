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
class PostIncExpression extends IncDecExpression {
    /**
     * Constructor
     */
    public PostIncExpression(long where, Expression right) {
        super(POSTINC, where, right);
    }

    /**
     * Code
     */
    public void codeValue(Environment env, Context ctx, Assembler asm) {
        codeIncDec(env, ctx, asm, true, false, true);
    }
    public void code(Environment env, Context ctx, Assembler asm) {
        codeIncDec(env, ctx, asm, true, false, false);
    }
}
