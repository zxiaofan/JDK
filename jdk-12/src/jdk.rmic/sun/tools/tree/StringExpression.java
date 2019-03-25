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
class StringExpression extends ConstantExpression {
    String value;

    /**
     * Constructor
     */
    public StringExpression(long where, String value) {
        super(STRINGVAL, where, Type.tString);
        this.value = value;
    }

    public boolean equals(String s) {
        return value.equals(s);
    }
    public boolean isNonNull() {
        return true;            // string literal is never null
    }

    /**
     * Code
     */
    public void codeValue(Environment env, Context ctx, Assembler asm) {
        asm.add(where, opc_ldc, this);
    }

    /**
     * Get the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Hashcode
     */
    public int hashCode() {
        return value.hashCode() ^ 3213;
    }

    /**
     * Equality
     */
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof StringExpression)) {
            return value.equals(((StringExpression)obj).value);
        }
        return false;
    }

    /**
     * Print
     */
    public void print(PrintStream out) {
        out.print("\"" + value + "\"");
    }
}
