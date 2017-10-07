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

import java.util.List;

/**
 * A tree node for a 'case' in a 'switch' statement.
 *
 * For example:
 * <pre>
 *   case <em>expression</em> :
 *       <em>statements</em>
 *
 *   default :
 *       <em>statements</em>
 * </pre>
 *
 * @since 9
 */
public interface CaseTree extends Tree {
    /**
     * Case expression of this 'case' statement.
     *
     * @return null if and only if this Case is {@code default:}
     */
    ExpressionTree getExpression();

    /**
     * Return the list of statements for this 'case'.
     *
     * @return list of statements for this 'case'
     */
    List<? extends StatementTree> getStatements();
}
