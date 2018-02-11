/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

import static jdk.nashorn.internal.parser.TokenType.RETURN;
import static jdk.nashorn.internal.parser.TokenType.YIELD;

import jdk.nashorn.internal.ir.annotations.Immutable;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * IR representation for RETURN or YIELD statements.
 */
@Immutable
public class ReturnNode extends Statement {
    private static final long serialVersionUID = 1L;

    /** Optional expression. */
    private final Expression expression;

    /**
     * Constructor
     *
     * @param lineNumber line number
     * @param token      token
     * @param finish     finish
     * @param expression expression to return
     */
    public ReturnNode(final int lineNumber, final long token, final int finish, final Expression expression) {
        super(lineNumber, token, finish);
        this.expression = expression;
    }

    private ReturnNode(final ReturnNode returnNode, final Expression expression) {
        super(returnNode);
        this.expression = expression;
    }

    @Override
    public boolean isTerminal() {
        return true;
    }

    /**
     * Return true if is a RETURN node.
     * @return true if is RETURN node.
     */
    public boolean isReturn() {
        return isTokenType(RETURN);
    }

    /**
     * Check if this return node has an expression
     * @return true if not a void return
     */
    public boolean hasExpression() {
        return expression != null;
    }

    /**
     * Return true if is a YIELD node.
     * @return TRUE if is YIELD node.
     */
    public boolean isYield() {
        return isTokenType(YIELD);
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterReturnNode(this)) {
            if (expression != null) {
                return visitor.leaveReturnNode(setExpression((Expression)expression.accept(visitor)));
            }
            return visitor.leaveReturnNode(this);
        }

        return this;
    }


    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append(isYield() ? "yield" : "return");
        if (expression != null) {
            sb.append(' ');
            expression.toString(sb, printType);
        }
    }

    /**
     * Get the expression this node returns
     * @return return expression, or null if void return
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Reset the expression this node returns
     * @param expression new expression, or null if void return
     * @return new or same return node
     */
    public ReturnNode setExpression(final Expression expression) {
        if (this.expression == expression) {
            return this;
        }
        return new ReturnNode(this, expression);
    }

}
