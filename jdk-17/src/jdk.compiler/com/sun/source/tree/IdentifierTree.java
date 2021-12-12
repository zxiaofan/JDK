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

import javax.lang.model.element.Name;

/**
 * A tree node for an identifier expression.
 *
 * For example:
 * <pre>
 *   <em>name</em>
 * </pre>
 *
 * @jls 6.5.6.1 Simple Expression Names
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface IdentifierTree extends ExpressionTree {
    /**
     * Returns the name of the identifier.
     * @return the name
     */
    Name getName();
}
