/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Use and Distribution is subject to the Java Research License available
 * at <http://wwws.sun.com/software/communitysource/jrl.html>.
 */

package com.sun.source.tree;

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
 * @see "The Java Language Specification, 3rd ed, section 14.20"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface TryTree extends StatementTree {
    BlockTree getBlock();
    List<? extends CatchTree> getCatches();
    BlockTree getFinallyBlock();
}
