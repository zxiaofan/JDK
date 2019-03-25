/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph.test.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.iterators.NodeIterable;

public class NodeIterableContains<T extends Node> extends TypeSafeDiagnosingMatcher<NodeIterable<T>> {
    private T node;

    public NodeIterableContains(T node) {
        this.node = node;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is a NodeIterable containing ").appendValue(node);
    }

    public static <T extends Node> NodeIterableContains<T> contains(T node) {
        return new NodeIterableContains<>(node);
    }

    @Override
    protected boolean matchesSafely(NodeIterable<T> iterable, Description mismatchDescription) {
        mismatchDescription.appendText("is a NodeIterable that does not contain ").appendValue(node);
        return iterable.contains(node);
    }
}
