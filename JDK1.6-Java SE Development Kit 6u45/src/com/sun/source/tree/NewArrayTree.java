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
 * A tree node for an expression to create a new instance of an array.
 *
 * For example:
 * <pre>
 *   new <em>type</em> <em>dimensions</em> <em>initializers</em>
 *
 *   new <em>type</em> <em>dimensions</em> [ ] <em>initializers</em>
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 15.10"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface NewArrayTree extends ExpressionTree {
    Tree getType();
    List<? extends ExpressionTree> getDimensions();
    List<? extends ExpressionTree> getInitializers();
}
