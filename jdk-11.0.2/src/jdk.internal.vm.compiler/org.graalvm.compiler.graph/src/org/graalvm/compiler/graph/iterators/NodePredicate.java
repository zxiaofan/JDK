/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.graph.iterators;

import java.util.function.Predicate;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.iterators.NodePredicates.AndPredicate;

public interface NodePredicate extends Predicate<Node> {

    boolean apply(Node n);

    @Override
    default boolean test(Node n) {
        return apply(n);
    }

    default NodePredicate and(NodePredicate np) {
        return new AndPredicate(this, np);
    }
}
