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
 * A tree node for a basic 'for' loop statement.
 *
 * For example:
 * <pre>
 *   for ( <em>initializer</em> ; <em>condition</em> ; <em>update</em> )
 *       <em>statement</em>
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 14.14.1"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ForLoopTree extends StatementTree {
    List<? extends StatementTree> getInitializer();
    ExpressionTree getCondition();
    List<? extends ExpressionStatementTree> getUpdate();
    StatementTree getStatement();
}
