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
 * A tree node for a {@code switch} statement.
 *
 * For example:
 * <pre>
 *   switch ( <em>expression</em> ) {
 *     <em>cases</em>
 *   }
 * </pre>
 *
 * @jls 14.11 The switch Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface SwitchTree extends StatementTree {
    /**
     * Returns the expression for the {@code switch} statement.
     * @return the expression
     */
    ExpressionTree getExpression();

    /**
     * Returns the cases for the {@code switch} statement.
     * @return the cases
     */
    List<? extends CaseTree> getCases();
}
