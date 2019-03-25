/*
 * Copyright (c) 2004, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jstat;

/**
 * A class that represents a mathematical expression as a tree structure
 * containing operators as interior nodes and operands as leaves. The
 * operands can be literals or lazily bound variables.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class Expression {
    private static int nextOrdinal;
    private boolean debug = Boolean.getBoolean("Expression.debug");
    private Expression left;
    private Expression right;
    private Operator operator;
    private int ordinal = nextOrdinal++;
    private boolean required = false;

    Expression() {
        if (debug) {
            System.out.println("Expression " + ordinal + " created");
        }
    }

    void setLeft(Expression left) {
        if (debug) {
            System.out.println("Setting left on " + ordinal + " to " + left);
        }
        this.left = left;
        this.left.setRequired(required);
    }

    Expression getLeft() {
        return left;
    }

    void setRight(Expression right) {
        if (debug) {
            System.out.println("Setting right on " + ordinal + " to " + right);
        }
        this.right = right;
        this.right.setRequired(required);
    }

    Expression getRight() {
        return right;
    }

    void setOperator(Operator o) {
        if (debug) {
            System.out.println("Setting operator on " + ordinal + " to " + o);
        }
        this.operator = o;
    }

    Operator getOperator() {
        return operator;
    }

    void setRequired(boolean r) {
        this.required = r;
        if (left != null) {
            left.setRequired(required);
        }
        if (right != null) {
            right.setRequired(required);
        }
    }

    boolean isRequired() {
        return required;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append('(');
        if (left != null) {
            b.append(left.toString());
        }
        if (operator != null) {
            b.append(operator.toString());
            if (right != null) {
                b.append(right.toString());
            }
        }
        b.append(')');
        return b.toString();
    }
}
