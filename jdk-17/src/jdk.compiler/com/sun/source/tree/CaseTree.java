/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.javac.PreviewFeature;

/**
 * A tree node for a {@code case} in a {@code switch} statement or expression.
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
 * @jls 14.11 The switch Statement
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface CaseTree extends Tree {
    /**
     * Returns the expression for the case, or
     * {@code null} if this is the default case.
     * If this case has multiple labels, returns the first label.
     * @return the expression for the case, or null
     * @deprecated Please use {@link #getExpressions()}.
     */
    @Deprecated
    ExpressionTree getExpression();

    /**
     * Returns the labels for this case.
     * For default case, returns an empty list.
     *
     * @return labels for this case
     * @since 12
     */
    List<? extends ExpressionTree> getExpressions();

    /**
     * Returns the labels for this case.
     * For {@code default} case return a list with a single element, {@link DefaultCaseLabelTree}.
     *
     * @return labels for this case
     * @since 17
     */
    @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
    List<? extends CaseLabelTree> getLabels();

    /**
     * For case with kind {@linkplain CaseKind#STATEMENT},
     * returns the statements labeled by the case.
     * Returns {@code null} for case with kind
     * {@linkplain CaseKind#RULE}.
     * @return the statements labeled by the case or null
     */
    List<? extends StatementTree> getStatements();

    /**
     * For case with kind {@linkplain CaseKind#RULE},
     * returns the statement or expression after the arrow.
     * Returns {@code null} for case with kind
     * {@linkplain CaseKind#STATEMENT}.
     *
     * @return case value or null
     * @since 12
     */
    public default Tree getBody() {
        return null;
    }

    /**
     * Returns the kind of this case.
     *
     * @return the kind of this case
     * @since 12
     */
    public default CaseKind getCaseKind() {
        return CaseKind.STATEMENT;
    }

    /**
     * The syntactic form of this case:
     * <ul>
     *     <li>STATEMENT: {@code case <expression>: <statements>}</li>
     *     <li>RULE: {@code case <expression> -> <expression>/<statement>}</li>
     * </ul>
     *
     * @since 12
     */
    public enum CaseKind {
        /**
         * Case is in the form: {@code case <expression>: <statements>}.
         */
        STATEMENT,
        /**
         * Case is in the form: {@code case <expression> -> <expression>}.
         */
        RULE;
    }
}
