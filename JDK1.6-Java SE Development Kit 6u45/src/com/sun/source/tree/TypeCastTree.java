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

/**
 * A tree node for a type cast expression.
 *
 * For example:
 * <pre>
 *   ( <em>type</em> ) <em>expression</em>
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 15.16"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface TypeCastTree extends ExpressionTree {
    Tree getType();
    ExpressionTree getExpression();
}
