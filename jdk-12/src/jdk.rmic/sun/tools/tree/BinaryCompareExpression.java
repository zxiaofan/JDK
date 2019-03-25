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
public
class BinaryCompareExpression extends BinaryExpression {
    /**
     * constructor
     */
    public BinaryCompareExpression(int op, long where, Expression left, Expression right) {
        super(op, where, Type.tBoolean, left, right);
    }

    /**
     * Select the type
     */
    void selectType(Environment env, Context ctx, int tm) {
        Type t = Type.tInt;
        if ((tm & TM_DOUBLE) != 0) {
            t = Type.tDouble;
        } else if ((tm & TM_FLOAT) != 0) {
            t = Type.tFloat;
        } else if ((tm & TM_LONG) != 0) {
            t = Type.tLong;
        }
        left = convert(env, ctx, t, left);
        right = convert(env, ctx, t, right);
    }
}
