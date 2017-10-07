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

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class NullExpression extends ConstantExpression {
    /**
     * Constructor
     */
    public NullExpression(long where) {
        super(NULL, where, Type.tNull);
    }

    /**
     * Check if the expression is equal to a value
     */
    public boolean equals(int i) {
        return i == 0;
    }

    public boolean isNull() {
        return true;
    }

    /**
     * Code
     */
    public void codeValue(Environment env, Context ctx, Assembler asm) {
        asm.add(where, opc_aconst_null);
    }

    /**
     * Print
     */
    public void print(PrintStream out) {
        out.print("null");
    }
}
