/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-template-literals">template literal strings</a>.
 *
 * For example:
 * <pre>
 * `This is a String with ${computed} values in it`
 * </pre>
 *
 * @since 9
 *
 */
public interface TemplateLiteralTree extends ExpressionTree {
    /**
     * Returns the list of expressions in this template string
     *
     * @return the list of expressions in this template string
     */
    List<? extends ExpressionTree> getExpressions();
}
