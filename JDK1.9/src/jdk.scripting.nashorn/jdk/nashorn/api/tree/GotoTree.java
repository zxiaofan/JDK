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
 * A tree node for a statement that jumps to a target. Note that
 * ECMAScript does not support a goto statement. But, this Tree
 * type serves as a super interface for {@link BreakTree} and
 * {@link ContinueTree}.
 *
 * @since 9
 */
public interface GotoTree extends StatementTree {
    /**
     * Label associated with this goto statement. This is null
     * if there is no label associated with this goto statement.
     *
     * @return label associated with this goto statement.
     */
    String getLabel();
}
