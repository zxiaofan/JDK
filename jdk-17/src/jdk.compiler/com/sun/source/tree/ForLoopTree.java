/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

import java.util.List;

/**
 * A tree node for a basic {@code for} loop statement.
 *
 * For example:
 * <pre>
 *   for ( <em>initializer</em> ; <em>condition</em> ; <em>update</em> )
 *       <em>statement</em>
 * </pre>
 *
 * @jls 14.14.1 The basic for Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ForLoopTree extends StatementTree {
    /**
     * Returns any initializers of the {@code for} statement.
     * The result will be an empty list if there are
     * no initializers
     * @return the initializers
     */
    List<? extends StatementTree> getInitializer();

    /**
     * Returns the condition of the {@code for} statement.
     * May be {@code null} if there is no condition.
     * @return the condition
     */
    ExpressionTree getCondition();

    /**
     * Returns any update expressions of the {@code for} statement.
     * @return the update expressions
     */
    List<? extends ExpressionStatementTree> getUpdate();

    /**
     * Returns the body of the {@code for} statement.
     * @return the body
     */
    StatementTree getStatement();
}
