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
 * A tree node to declare a new instance of a class.
 *
 * For example:
 * <pre>
 *   new <em>identifier</em> ( )
 *
 *   new <em>identifier</em> ( <em>arguments</em> )
 *
 *   new <em>typeArguments</em> <em>identifier</em> ( <em>arguments</em> )
 *       <em>classBody</em>
 *
 *   <em>enclosingExpression</em>.new <em>identifier</em> ( <em>arguments</em> )
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 15.9"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface NewClassTree extends ExpressionTree {
    ExpressionTree getEnclosingExpression();
    List<? extends Tree> getTypeArguments();
    ExpressionTree getIdentifier();
    List<? extends ExpressionTree> getArguments();
    ClassTree getClassBody();
}
