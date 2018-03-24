/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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
import java.io.ByteArrayOutputStream;

/**
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
class Node implements Constants, Cloneable {
    int op;
    long where;

    /**
     * Constructor
     */
    Node(int op, long where) {
        this.op = op;
        this.where = where;
    }

    /**
     * Get the operator
     */
    public int getOp() {
        return op;
    }

    /**
     * Get where
     */
    public long getWhere() {
        return where;
    }

    /**
     * Implicit conversions
     */
    public Expression convert(Environment env, Context ctx, Type t, Expression e) {
        if (e.type.isType(TC_ERROR) || t.isType(TC_ERROR)) {
            // An error was already reported
            return e;
        }

        if (e.type.equals(t)) {
            // The types are already the same
            return e;
        }

        try {
            if (e.fitsType(env, ctx, t)) {
                return new ConvertExpression(where, t, e);
            }

            if (env.explicitCast(e.type, t)) {
                env.error(where, "explicit.cast.needed", opNames[op], e.type, t);
                return new ConvertExpression(where, t, e);
            }
        } catch (ClassNotFound ee) {
            env.error(where, "class.not.found", ee.name, opNames[op]);
        }

        // The cast is not allowed
        env.error(where, "incompatible.type", opNames[op], e.type, t);
        return new ConvertExpression(where, Type.tError, e);
    }

    /**
     * Print
     */
    public void print(PrintStream out) {
        throw new CompilerError("print");
    }

    /**
     * Clone this object.
     */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw (InternalError) new InternalError().initCause(e);
        }
    }

    /*
     * Useful for simple debugging
     */
    public String toString() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        print(new PrintStream(bos));
        return bos.toString();
    }

}
