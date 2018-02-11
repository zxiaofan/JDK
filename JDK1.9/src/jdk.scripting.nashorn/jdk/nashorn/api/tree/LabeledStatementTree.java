/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

/**
 * A tree node for a labeled statement.
 *
 * For example:
 * <pre>
 *   <em>label</em> : <em>statement</em>
 * </pre>
 *
 * @since 9
 */
public interface LabeledStatementTree extends StatementTree {
    /**
     * Returns the label associated with this statement.
     *
     * @return the label
     */
    String getLabel();

    /**
     * Returns the statement being labeled.
     *
     * @return the statement labeled
     */
    StatementTree getStatement();
}
