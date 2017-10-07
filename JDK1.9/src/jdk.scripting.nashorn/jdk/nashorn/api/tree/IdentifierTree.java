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
 * A tree node for an identifier expression.
 *
 * For example:
 * <pre>
 *   <em>name</em>
 * </pre>
 *
 * @since 9
 */
public interface IdentifierTree extends ExpressionTree {
    /**
     * Returns the name of this identifier.
     *
     * @return the name of this identifier
     */
    String getName();

    /**
     * Is this a rest parameter for a function or rest elements of an array?
     *
     * @return true if this is a rest parameter
     */
    boolean isRestParameter();

    /**
     * Is this super identifier?
     *
     * @return true if this is super identifier
     */
    boolean isSuper();

    /**
     * Is this 'this' identifier?
     *
     * @return true if this is 'this' identifier
     */
    boolean isThis();

    /**
     * Is this "*" used in module export entry?
     *
     * @return true if this "*" used in module export entry?
     */
    boolean isStar();

    /**
     * Is this "default" used in module export entry?
     *
     * @return true if this 'default' used in module export entry?
     */
    boolean isDefault();

    /**
     * Is this "*default*" used in module export entry?
     *
     * @return true if this '*default*' used in module export entry?
     */
    boolean isStarDefaultStar();
}
