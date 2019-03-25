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

import java.util.List;
import jdk.nashorn.internal.ir.Statement;

/**
 * Used for keeping state when needed in the parser.
 */
interface ParserContextNode {
    /**
     * @return The flags for this node
     */
    public int getFlags();

    /**
     * @param flag The flag to set
     * @return All current flags after update
     */
    public int setFlag(final int flag);

    /**
     * @return The list of statements that belongs to this node
     */
    public List<Statement> getStatements();

    /**
     * @param statements The statement list
     */
    public void setStatements(final List<Statement> statements);

    /**
     * Adds a statement at the end of the statement list
     * @param statement The statement to add
     */
    public void appendStatement(final Statement statement);

    /**
     * Adds a statement at the beginning of the statement list
     * @param statement The statement to add
     */
    public void prependStatement(final Statement statement);

}
