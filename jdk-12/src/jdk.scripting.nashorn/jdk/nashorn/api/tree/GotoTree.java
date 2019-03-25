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
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface GotoTree extends StatementTree {
    /**
     * Label associated with this goto statement. This is null
     * if there is no label associated with this goto statement.
     *
     * @return label associated with this goto statement.
     */
    String getLabel();
}
