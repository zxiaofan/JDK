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

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.graalvm.compiler.graph.Node;

public abstract class NodeIterator<T extends Node> implements Iterator<T> {

    protected T current;

    protected abstract void forward();

    @Override
    public boolean hasNext() {
        forward();
        return current != null;
    }

    @Override
    public T next() {
        forward();
        T ret = current;
        if (current == null) {
            throw new NoSuchElementException();
        }
        current = null;
        return ret;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
