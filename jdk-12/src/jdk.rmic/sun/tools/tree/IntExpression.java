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
class IntExpression extends IntegerExpression {
    /**
     * Constructor
     */
    public IntExpression(long where, int value) {
        super(INTVAL, where, Type.tInt, value);
    }

    /**
     * Equality, this is needed so that switch statements
     * can put IntExpressions in a hashtable
     */
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof IntExpression)) {
            return value == ((IntExpression)obj).value;
        }
        return false;
    }

    /**
     * Hashcode, this is needed so that switch statements
     * can put IntExpressions in a hashtable
     */
    public int hashCode() {
        return value;
    }

    /**
     * Print
     */
    public void print(PrintStream out) {
        out.print(value);
    }
}
