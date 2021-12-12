
/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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

/**
 * A tree node for a 'uses' directive in a module declaration.
 *
 * For example:
 * <pre>
 *    uses <em>service-name</em>;
 * </pre>
 *
 * @since 9
 */
public interface UsesTree extends DirectiveTree {
    /**
     * Returns the name of the service type.
     * @return  the name of the service type
     */
    ExpressionTree getServiceName();
}
