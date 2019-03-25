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
 * IR representation for a labeled statement. It implements JoinPredecessor to hold conversions that need to be effected
 * when the block exits normally, but is also targeted by a break statement that might bring different local variable
 * types to the join at the break point.
 */
@Immutable
public final class LabelNode extends LexicalContextStatement implements JoinPredecessor {
    private static final long serialVersionUID = 1L;

    /** Label ident. */
    private final String labelName;

    /** Statements. */
    private final Block body;

    private final LocalVariableConversion localVariableConversion;

    /**
     * Constructor
     *
     * @param lineNumber line number
     * @param token      token
     * @param finish     finish
     * @param labelName  label name
     * @param body       body of label node
     */
    public LabelNode(final int lineNumber, final long token, final int finish, final String labelName, final Block body) {
        super(lineNumber, token, finish);

        this.labelName = labelName;
        this.body  = body;
        this.localVariableConversion = null;
    }

    private LabelNode(final LabelNode labelNode, final String labelName, final Block body, final LocalVariableConversion localVariableConversion) {
        super(labelNode);
        this.labelName = labelName;
        this.body = body;
        this.localVariableConversion = localVariableConversion;
    }

    @Override
    public boolean isTerminal() {
        return body.isTerminal();
    }

    @Override
    public Node accept(final LexicalContext lc, final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterLabelNode(this)) {
            return visitor.leaveLabelNode(setBody(lc, (Block)body.accept(visitor)));
        }

        return this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append(labelName).append(':');
    }

    /**
     * Get the body of the node
     * @return the body
     */
    public Block getBody() {
        return body;
    }

    /**
     * Reset the body of the node
     * @param lc lexical context
     * @param body new body
     * @return new for node if changed or existing if not
     */
    public LabelNode setBody(final LexicalContext lc, final Block body) {
        if (this.body == body) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new LabelNode(this, labelName, body, localVariableConversion));
    }

    /**
     * Get the label name
     * @return the label
     */
    public String getLabelName() {
        return labelName;
    }

    @Override
    public LocalVariableConversion getLocalVariableConversion() {
        return localVariableConversion;
    }

    @Override
    public LabelNode setLocalVariableConversion(final LexicalContext lc, final LocalVariableConversion localVariableConversion) {
        if(this.localVariableConversion == localVariableConversion) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new LabelNode(this, labelName, body, localVariableConversion));
    }
}
