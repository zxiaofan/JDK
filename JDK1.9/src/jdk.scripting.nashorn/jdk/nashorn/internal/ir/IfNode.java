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
 * IR representation for an IF statement.
 */
@Immutable
public final class IfNode extends Statement implements JoinPredecessor {
    private static final long serialVersionUID = 1L;

    /** Test expression. */
    private final Expression test;

    /** Pass statements. */
    private final Block pass;

    /** Fail statements. */
    private final Block fail;

    /**
     * Local variable conversions that need to be performed after test if it evaluates to false, and there's no else
     * branch.
     */
    private final LocalVariableConversion conversion;

    /**
     * Constructor
     *
     * @param lineNumber line number
     * @param token      token
     * @param finish     finish
     * @param test       test
     * @param pass       block to execute when test passes
     * @param fail       block to execute when test fails or null
     */
    public IfNode(final int lineNumber, final long token, final int finish, final Expression test, final Block pass, final Block fail) {
        super(lineNumber, token, finish);
        this.test = test;
        this.pass = pass;
        this.fail = fail;
        this.conversion = null;
    }

    private IfNode(final IfNode ifNode, final Expression test, final Block pass, final Block fail, final LocalVariableConversion conversion) {
        super(ifNode);
        this.test = test;
        this.pass = pass;
        this.fail = fail;
        this.conversion = conversion;
    }

    @Override
    public boolean isTerminal() {
        return pass.isTerminal() && fail != null && fail.isTerminal();
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterIfNode(this)) {
            return visitor.leaveIfNode(
                setTest((Expression)test.accept(visitor)).
                setPass((Block)pass.accept(visitor)).
                setFail(fail == null ? null : (Block)fail.accept(visitor)));
        }

        return this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printTypes) {
        sb.append("if (");
        test.toString(sb, printTypes);
        sb.append(')');
    }

    /**
     * Get the else block of this IfNode
     * @return the else block, or null if none exists
     */
    public Block getFail() {
        return fail;
    }

    private IfNode setFail(final Block fail) {
        if (this.fail == fail) {
            return this;
        }
        return new IfNode(this, test, pass, fail, conversion);
    }

    /**
     * Get the then block for this IfNode
     * @return the then block
     */
    public Block getPass() {
        return pass;
    }

    private IfNode setPass(final Block pass) {
        if (this.pass == pass) {
            return this;
        }
        return new IfNode(this, test, pass, fail, conversion);
    }

    /**
     * Get the test expression for this IfNode
     * @return the test expression
     */
    public Expression getTest() {
        return test;
    }

    /**
     * Reset the test expression for this IfNode
     * @param test a new test expression
     * @return new or same IfNode
     */
    public IfNode setTest(final Expression test) {
        if (this.test == test) {
            return this;
        }
        return new IfNode(this, test, pass, fail, conversion);
    }

    @Override
    public IfNode setLocalVariableConversion(final LexicalContext lc, final LocalVariableConversion conversion) {
        if(this.conversion == conversion) {
            return this;
        }
        return new IfNode(this, test, pass, fail, conversion);
    }

    @Override
    public LocalVariableConversion getLocalVariableConversion() {
        return conversion;
    }
}
