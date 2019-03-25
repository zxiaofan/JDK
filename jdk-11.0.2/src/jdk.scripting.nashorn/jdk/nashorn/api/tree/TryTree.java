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

import java.util.List;

/**
 * A tree node for a 'try' statement.
 *
 * For example:
 * <pre>
 *   try
 *       <em>block</em>
 *   <em>catches</em>
 *   finally
 *       <em>finallyBlock</em>
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface TryTree extends StatementTree {
    /**
     * Returns the 'try' block of this 'try' statement.
     *
     * @return the 'try' block
     */
    BlockTree getBlock();

    /**
     * Returns the list of 'catch' statements associated with this 'try'.
     *
     * @return the list of 'catch' statements associated with this 'try'.
     */
    List<? extends CatchTree> getCatches();

    /**
     * Returns the 'finally' block associated with this 'try'. This is
     * null if there is no 'finally' block associated with this 'try'.
     *
     * @return the 'finally' block associated with this 'try'.
     */
    BlockTree getFinallyBlock();
}
