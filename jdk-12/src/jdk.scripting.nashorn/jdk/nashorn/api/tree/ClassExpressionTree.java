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
 * A tree node that represents a <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-class-definitions">class expression</a>.
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface ClassExpressionTree extends ExpressionTree {
    /**
     * Class identifier. Optional.
     *
     * @return the class identifier
     */
    IdentifierTree getName();

    /**
     * The expression of the {@code extends} clause. Optional.
     *
     * @return the class heritage
     */
    ExpressionTree getClassHeritage();

    /**
     * Get the constructor method definition.
     *
     * @return the constructor
     */
    PropertyTree getConstructor();

    /**
     * Get other property definitions except for the constructor.
     *
     * @return the class elements
     */
    List<? extends PropertyTree> getClassElements();
}
