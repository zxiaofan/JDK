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
 * A tree node for a member access expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> . <em>identifier</em>
 * </pre>
 *
 * @since 9
 */
public interface MemberSelectTree extends ExpressionTree {
    /**
     * The object expression whose member is being selected.
     *
     * @return the object whose member is selected
     */
    ExpressionTree getExpression();

    /**
     * Returns the name of the property.
     *
     * @return the name of the property
     */
    String getIdentifier();
}
