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
 * IR representation for a WHILE statement. This is the superclass of all
 * loop nodes
 */
@Immutable
public final class WhileNode extends LoopNode {
    private static final long serialVersionUID = 1L;


    /** is this a do while node ? */
    private final boolean isDoWhile;

    /**
     * Constructor
     *
     * @param lineNumber line number
     * @param token      token
     * @param finish     finish
     * @param isDoWhile  is this a do while loop?
     * @param test       test expression
     * @param body       body of the while loop
     */
    public WhileNode(final int lineNumber, final long token, final int finish, final boolean isDoWhile, final JoinPredecessorExpression test, final Block body) {
        super(lineNumber, token, finish, body, test, false);
        this.isDoWhile = isDoWhile;
    }

    /**
     * Internal copy constructor
     *
     * @param whileNode while node
     * @param test      Test expression
     * @param body      body of the while loop
     * @param controlFlowEscapes control flow escapes?
     * @param conversion local variable conversion info
     */
    private WhileNode(final WhileNode whileNode, final JoinPredecessorExpression test, final Block body, final boolean controlFlowEscapes, final LocalVariableConversion conversion) {
        super(whileNode, test, body, controlFlowEscapes, conversion);
        this.isDoWhile = whileNode.isDoWhile;
    }

    @Override
    public Node ensureUniqueLabels(final LexicalContext lc) {
        return Node.replaceInLexicalContext(lc, this, new WhileNode(this, test, body, controlFlowEscapes, conversion));
    }

    @Override
    public boolean hasGoto() {
        return test == null;
    }

    @Override
    public Node accept(final LexicalContext lc, final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterWhileNode(this)) {
            if (isDoWhile()) {
                return visitor.leaveWhileNode(
                        setBody(lc, (Block)body.accept(visitor)).
                        setTest(lc, (JoinPredecessorExpression)test.accept(visitor)));
            }
            return visitor.leaveWhileNode(
                    setTest(lc, (JoinPredecessorExpression)test.accept(visitor)).
                    setBody(lc, (Block)body.accept(visitor)));
        }
        return this;
    }

    @Override
    public WhileNode setTest(final LexicalContext lc, final JoinPredecessorExpression test) {
        if (this.test == test) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new WhileNode(this, test, body, controlFlowEscapes, conversion));
    }

    @Override
    public Block getBody() {
        return body;
    }

    @Override
    public WhileNode setBody(final LexicalContext lc, final Block body) {
        if (this.body == body) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new WhileNode(this, test, body, controlFlowEscapes, conversion));
    }

    @Override
    public WhileNode setControlFlowEscapes(final LexicalContext lc, final boolean controlFlowEscapes) {
        if (this.controlFlowEscapes == controlFlowEscapes) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new WhileNode(this, test, body, controlFlowEscapes, conversion));
    }

    @Override
    JoinPredecessor setLocalVariableConversionChanged(final LexicalContext lc, final LocalVariableConversion conversion) {
        return Node.replaceInLexicalContext(lc, this, new WhileNode(this, test, body, controlFlowEscapes, conversion));
    }

    /**
     * Check if this is a do while loop or a normal while loop
     * @return true if do while
     */
    public boolean isDoWhile() {
        return isDoWhile;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append("while (");
        test.toString(sb, printType);
        sb.append(')');
    }

    @Override
    public boolean mustEnter() {
        if (isDoWhile()) {
            return true;
        }
        return test == null;
    }

    @Override
    public boolean hasPerIterationScope() {
        return false;
    }
}
