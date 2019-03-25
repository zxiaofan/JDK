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

import org.graalvm.compiler.graph.iterators.NodeIterable;

public class NodeIterableCount extends TypeSafeDiagnosingMatcher<NodeIterable<?>> {
    private int count;

    public NodeIterableCount(int count) {
        this.count = count;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is a NodeIterable containing ").appendValue(count).appendText(" elements");
    }

    public static NodeIterableCount hasCount(int count) {
        return new NodeIterableCount(count);
    }

    @Override
    protected boolean matchesSafely(NodeIterable<?> iterable, Description mismatchDescription) {
        mismatchDescription.appendText("is a NodeIterable containing ").appendValue(iterable.count()).appendText(" elements");
        return iterable.count() == count;
    }
}
