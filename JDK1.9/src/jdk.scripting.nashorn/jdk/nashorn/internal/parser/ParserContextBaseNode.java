/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.internal.parser;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.Statement;

/**
 * Base class for parser context nodes
 */
abstract class ParserContextBaseNode implements ParserContextNode {
    /**
     * Flags for this node
     */
    protected int flags;

    private List<Statement> statements;

    /**
     * Constructor
     */
    public ParserContextBaseNode() {
        this.statements = new ArrayList<>();
    }

    /**
     * @return The flags for this node
     */
    @Override
    public int getFlags() {
        return flags;
    }

    /**
     * Returns a single flag
     * @param flag flag
     * @return A single flag
     */
    protected int getFlag(final int flag) {
        return (flags & flag);
    }

    /**
     * @param flag flag
     * @return the new flags
     */
    @Override
    public int setFlag(final int flag) {
        flags |= flag;
        return flags;
    }

    /**
     * @return The list of statements that belongs to this node
     */
    @Override
    public List<Statement> getStatements() {
        return statements;
    }

    /**
     * @param statements statements
     */
    @Override
    public void setStatements(final List<Statement> statements) {
        this.statements = statements;
    }

    /**
     * Adds a statement at the end of the statement list
     * @param statement The statement to add
     */
    @Override
    public void appendStatement(final Statement statement) {
        this.statements.add(statement);
    }

    /**
     * Adds a statement at the beginning of the statement list
     * @param statement The statement to add
     */
    @Override
    public void prependStatement(final Statement statement) {
        this.statements.add(0, statement);
    }
}
