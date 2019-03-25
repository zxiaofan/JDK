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

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.annotations.Immutable;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;
import jdk.nashorn.internal.parser.TokenType;

/**
 * TernaryNode represent the ternary operator {@code ?:}. Note that for control-flow calculation reasons its branch
 * expressions (but not its test expression) are always wrapped in instances of {@link JoinPredecessorExpression}.
 */
@Immutable
public final class TernaryNode extends Expression {
    private static final long serialVersionUID = 1L;

    private final Expression test;
    private final JoinPredecessorExpression trueExpr;
    private final JoinPredecessorExpression falseExpr;

    /**
     * Constructor
     *
     * @param token     token
     * @param test      test expression
     * @param trueExpr  expression evaluated when test evaluates to true
     * @param falseExpr expression evaluated when test evaluates to true
     */
    public TernaryNode(final long token, final Expression test, final JoinPredecessorExpression trueExpr, final JoinPredecessorExpression falseExpr) {
        super(token, falseExpr.getFinish());
        this.test = test;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
    }

    private TernaryNode(final TernaryNode ternaryNode, final Expression test, final JoinPredecessorExpression trueExpr,
            final JoinPredecessorExpression falseExpr) {
        super(ternaryNode);
        this.test = test;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterTernaryNode(this)) {
            final Expression newTest = (Expression)getTest().accept(visitor);
            final JoinPredecessorExpression newTrueExpr = (JoinPredecessorExpression)trueExpr.accept(visitor);
            final JoinPredecessorExpression newFalseExpr = (JoinPredecessorExpression)falseExpr.accept(visitor);
            return visitor.leaveTernaryNode(setTest(newTest).setTrueExpression(newTrueExpr).setFalseExpression(newFalseExpr));
        }

        return this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        final TokenType tokenType  = tokenType();
        final boolean   testParen  = tokenType.needsParens(getTest().tokenType(), true);
        final boolean   trueParen  = tokenType.needsParens(getTrueExpression().tokenType(), false);
        final boolean   falseParen = tokenType.needsParens(getFalseExpression().tokenType(), false);

        if (testParen) {
            sb.append('(');
        }
        getTest().toString(sb, printType);
        if (testParen) {
            sb.append(')');
        }

        sb.append(" ? ");

        if (trueParen) {
            sb.append('(');
        }
        getTrueExpression().toString(sb, printType);
        if (trueParen) {
            sb.append(')');
        }

        sb.append(" : ");

        if (falseParen) {
            sb.append('(');
        }
        getFalseExpression().toString(sb, printType);
        if (falseParen) {
            sb.append(')');
        }
    }

    @Override
    public boolean isLocal() {
        return getTest().isLocal()
                && getTrueExpression().isLocal()
                && getFalseExpression().isLocal();
    }

    @Override
    public Type getType() {
        return Type.widestReturnType(getTrueExpression().getType(), getFalseExpression().getType());
    }


    /**
     * Get the test expression for this ternary expression, i.e. "x" in x ? y : z
     * @return the test expression
     */
    public Expression getTest() {
        return test;
    }

    /**
     * Get the true expression for this ternary expression, i.e. "y" in x ? y : z
     * @return the true expression
     */
    public JoinPredecessorExpression getTrueExpression() {
        return trueExpr;
    }

    /**
     * Get the false expression for this ternary expression, i.e. "z" in x ? y : z
     * @return the false expression
     */
    public JoinPredecessorExpression getFalseExpression() {
        return falseExpr;
    }

    /**
     * Set the test expression for this node
     * @param test new test expression
     * @return a node equivalent to this one except for the requested change.
     */
    public TernaryNode setTest(final Expression test) {
        if (this.test == test) {
            return this;
        }
        return new TernaryNode(this, test, trueExpr, falseExpr);
    }

    /**
     * Set the true expression for this node
     * @param trueExpr new true expression
     * @return a node equivalent to this one except for the requested change.
     */
    public TernaryNode setTrueExpression(final JoinPredecessorExpression trueExpr) {
        if (this.trueExpr == trueExpr) {
            return this;
        }
        return new TernaryNode(this, test, trueExpr, falseExpr);
    }

    /**
     * Set the false expression for this node
     * @param falseExpr new false expression
     * @return a node equivalent to this one except for the requested change.
     */
    public TernaryNode setFalseExpression(final JoinPredecessorExpression falseExpr) {
        if (this.falseExpr == falseExpr) {
            return this;
        }
        return new TernaryNode(this, test, trueExpr, falseExpr);
    }
}
