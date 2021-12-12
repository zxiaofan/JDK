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

import java.util.List;

/**
 * A tree node for a 'provides' directive in a module declaration.
 *
 * For example:
 * <pre>
 *    provides <em>service-name</em> with <em>implementation-name</em>;
 * </pre>

 * @since 9
 */
public interface ProvidesTree extends DirectiveTree {
    /**
     * Returns the name of the service type being provided.
     * @return the name of the service type being provided
     */
    ExpressionTree getServiceName();

    /**
     * Returns the names of the implementation types being provided.
     * @return the names of the implementation types being provided
     */
    List<? extends ExpressionTree> getImplementationNames();
}
