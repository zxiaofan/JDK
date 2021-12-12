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
 * A tree node for a statement block.
 *
 * For example:
 * <pre>
 *   { }
 *
 *   { <em>statements</em> }
 *
 *   static { <em>statements</em> }
 * </pre>
 *
 * @jls 14.2 Blocks
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface BlockTree extends StatementTree {
    /**
     * Returns true if and only if this is a static initializer block.
     * @return true if this is a static initializer block
     */
    boolean isStatic();

    /**
     * Returns the statements comprising this block.
     * @return the statements
     */
    List<? extends StatementTree> getStatements();
}
