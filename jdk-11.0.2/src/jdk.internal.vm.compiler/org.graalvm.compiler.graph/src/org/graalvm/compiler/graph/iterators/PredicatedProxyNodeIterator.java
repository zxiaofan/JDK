/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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

public class PredicatedProxyNodeIterator<T extends Node> extends NodeIterator<T> {

    private final Iterator<T> iterator;
    private final NodePredicate predicate;

    public PredicatedProxyNodeIterator(Iterator<T> iterator, NodePredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    protected void forward() {
        while ((current == null || !current.isAlive() || !predicate.apply(current)) && iterator.hasNext()) {
            current = iterator.next();
        }
        if (current != null && (!current.isAlive() || !predicate.apply(current))) {
            current = null;
        }
    }
}
