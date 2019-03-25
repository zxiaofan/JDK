/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TypedGraphNodeIterator<T extends IterableNodeType> implements Iterator<T> {

    private final Graph graph;
    private final int[] ids;
    private final Node[] current;

    private int currentIdIndex;
    private boolean needsForward;

    TypedGraphNodeIterator(NodeClass<?> clazz, Graph graph) {
        this.graph = graph;
        ids = clazz.iterableIds();
        currentIdIndex = 0;
        current = new Node[ids.length];
        needsForward = true;
    }

    private Node findNext() {
        if (needsForward) {
            forward();
        } else {
            Node c = current();
            Node afterDeleted = graph.getIterableNodeNext(c);
            if (afterDeleted == null) {
                needsForward = true;
            } else if (c != afterDeleted) {
                setCurrent(afterDeleted);
            }
        }
        if (needsForward) {
            return null;
        }
        return current();
    }

    private void forward() {
        needsForward = false;
        int startIdx = currentIdIndex;
        while (true) {
            Node next;
            if (current() == null) {
                next = graph.getIterableNodeStart(ids[currentIdIndex]);
            } else {
                next = graph.getIterableNodeNext(current().typeCacheNext);
            }
            if (next == null) {
                currentIdIndex++;
                if (currentIdIndex >= ids.length) {
                    currentIdIndex = 0;
                }
                if (currentIdIndex == startIdx) {
                    needsForward = true;
                    return;
                }
            } else {
                setCurrent(next);
                break;
            }
        }
    }

    private Node current() {
        return current[currentIdIndex];
    }

    private void setCurrent(Node n) {
        current[currentIdIndex] = n;
    }

    @Override
    public boolean hasNext() {
        return findNext() != null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
        Node result = findNext();
        if (result == null) {
            throw new NoSuchElementException();
        }
        needsForward = true;
        return (T) result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
