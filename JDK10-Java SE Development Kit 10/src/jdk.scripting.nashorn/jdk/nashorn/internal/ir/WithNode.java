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

import jdk.nashorn.internal.ir.annotations.Immutable;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * IR representation for {@code with} statements.
 */
@Immutable
public final class WithNode extends LexicalContextStatement {
    private static final long serialVersionUID = 1L;

   /** This expression. */
    private final Expression expression;

    /** Statements. */
    private final Block body;

    /**
     * Constructor
     *
     * @param lineNumber Line number of the header
     * @param token      First token
     * @param finish     Character index of the last token
     * @param expression With expression
     * @param body       Body of with node
     */
    public WithNode(final int lineNumber, final long token, final int finish, final Expression expression, final Block body) {
        super(lineNumber, token, finish);
        this.expression = expression;
        this.body       = body;
    }

    private WithNode(final WithNode node, final Expression expression, final Block body) {
        super(node);
        this.expression = expression;
        this.body       = body;
    }

    /**
     * Assist in IR navigation.
     *
     * @param visitor IR navigating visitor.
     */
    @Override
    public Node accept(final LexicalContext lc, final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterWithNode(this)) {
             return visitor.leaveWithNode(
                setExpression(lc, (Expression)expression.accept(visitor)).
                setBody(lc, (Block)body.accept(visitor)));
        }
        return this;
    }

    @Override
    public boolean isTerminal() {
        return body.isTerminal();
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append("with (");
        expression.toString(sb, printType);
        sb.append(')');
    }

    /**
     * Get the body of this WithNode
     * @return the body
     */
    public Block getBody() {
        return body;
    }

    /**
     * Reset the body of this with node
     * @param lc lexical context
     * @param body new body
     * @return new or same withnode
     */
    public WithNode setBody(final LexicalContext lc, final Block body) {
        if (this.body == body) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new WithNode(this, expression, body));
    }

    /**
     * Get the expression of this WithNode
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Reset the expression of this with node
     * @param lc lexical context
     * @param expression new expression
     * @return new or same withnode
     */
    public WithNode setExpression(final LexicalContext lc, final Expression expression) {
        if (this.expression == expression) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new WithNode(this, expression, body));
    }
}

