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
import java.io.PrintStream;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class CharExpression extends IntegerExpression {
    /**
     * Constructor
     */
    public CharExpression(long where, char value) {
        super(CHARVAL, where, Type.tChar, value);
    }

    /**
     * Print
     */
    public void print(PrintStream out) {
        out.print(value + "c");
    }
}
