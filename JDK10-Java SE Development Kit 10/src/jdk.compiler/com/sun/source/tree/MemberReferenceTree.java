/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.Name;

/**
 * A tree node for a member reference expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> # <em>[ identifier | new ]</em>
 * </pre>
 *
 * @since 1.8
 */
public interface MemberReferenceTree extends ExpressionTree {

    /**
     * There are two kinds of member references: (i) method references and
     * (ii) constructor references
     */
    public enum ReferenceMode {
        /** enum constant for method references. */
        INVOKE,
        /** enum constant for constructor references. */
        NEW
    }

    /**
     * Returns the mode of the reference.
     * @return the mode
     */
    ReferenceMode getMode();

    /**
     * Returns the qualifier expression for the reference.
     * @return the qualifier expression
     */
    ExpressionTree getQualifierExpression();

    /**
     * Returns the name of the reference.
     * @return the name
     */
    Name getName();

    /**
     * Returns the type arguments for the reference.
     * @return the type arguments
     */
    List<? extends ExpressionTree> getTypeArguments();
}
