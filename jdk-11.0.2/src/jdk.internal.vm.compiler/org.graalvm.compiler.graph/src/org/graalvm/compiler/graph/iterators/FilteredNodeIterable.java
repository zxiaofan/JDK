/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Iterator;

import org.graalvm.compiler.graph.Node;

public class FilteredNodeIterable<T extends Node> implements NodeIterable<T> {

    protected final NodeIterable<T> nodeIterable;
    protected NodePredicate predicate = NodePredicates.alwaysTrue();

    public FilteredNodeIterable(NodeIterable<T> nodeIterable) {
        this.nodeIterable = nodeIterable;
    }

    public FilteredNodeIterable<T> and(NodePredicate nodePredicate) {
        this.predicate = this.predicate.and(nodePredicate);
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new PredicatedProxyNodeIterator<>(nodeIterable.iterator(), predicate);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <F extends T> FilteredNodeIterable<F> filter(Class<F> clazz) {
        return (FilteredNodeIterable<F>) this.and(NodePredicates.isA(clazz));
    }

    @Override
    public FilteredNodeIterable<T> filter(NodePredicate p) {
        return this.and(p);
    }

}
