/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.Name;

/**
 * A tree node for a member access expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> . <em>identifier</em>
 * </pre>
 *
 * @jls 6.5 Determining the Meaning of a Name
 * @jls 15.11 Field Access Expressions
 * @jls 15.12 Method Invocation Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface MemberSelectTree extends ExpressionTree {
    /**
     * Returns the expression for which a member is to be selected.
     * @return the expression
     */
    ExpressionTree getExpression();

    /**
     * Returns the name of the member to be selected.
     * @return the member
     */
    Name getIdentifier();
}
