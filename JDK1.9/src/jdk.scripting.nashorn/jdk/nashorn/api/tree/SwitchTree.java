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
 * A tree node for a 'switch' statement.
 *
 * For example:
 * <pre>
 *   switch ( <em>expression</em> ) {
 *     <em>cases</em>
 *   }
 * </pre>
 *
 * @since 9
 */
public interface SwitchTree extends StatementTree {
    /**
     * Returns the expression on which this statement switches.
     *
     * @return the switch expression
     */
    ExpressionTree getExpression();


    /**
     * Returns the list of 'case' statements.
     *
     * @return the 'case' statements
     */
    List<? extends CaseTree> getCases();
}
