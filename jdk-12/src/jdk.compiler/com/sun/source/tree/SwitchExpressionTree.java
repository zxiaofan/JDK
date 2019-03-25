/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for a {@code switch} expression.
 *
 * For example:
 * <pre>
 *   switch ( <em>expression</em> ) {
 *     <em>cases</em>
 *   }
 * </pre>
 *
 * @jls section 15.29
 *
 * @since 12
 *
 * @deprecated This method is modeling switch expressions,
 * which are part of a preview feature and may be removed
 * if the preview feature is removed.
 */
@Deprecated(forRemoval=true, since="12")
public interface SwitchExpressionTree extends ExpressionTree {
    /**
     * Returns the expression for the {@code switch} expression.
     * @return the expression
     */
    ExpressionTree getExpression();

    /**
     * Returns the cases for the {@code switch} expression.
     * @return the cases
     */
    List<? extends CaseTree> getCases();
}
