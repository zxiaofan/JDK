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

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
class ConstantExpression extends Expression {
    /**
     * Constructor
     */
    public ConstantExpression(int op, long where, Type type) {
        super(op, where, type);
    }

    /**
     * Return true if constant
     */
    public boolean isConstant() {
        return true;
    }
}
