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
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsNot;

import org.graalvm.compiler.graph.iterators.NodeIterable;

public class NodeIterableIsEmpty extends TypeSafeDiagnosingMatcher<NodeIterable<?>> {

    private static final NodeIterableIsEmpty INSTANCE = new NodeIterableIsEmpty();

    @Override
    public boolean matchesSafely(NodeIterable<?> iterable, Description mismatchDescription) {
        mismatchDescription.appendText("is a non-empty NodeIterable");
        return iterable.isEmpty();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is an empty NodeIterable");
    }

    public static Matcher<NodeIterable<?>> isEmpty() {
        return INSTANCE;
    }

    public static Matcher<NodeIterable<?>> isNotEmpty() {
        return IsNot.not(INSTANCE);
    }
}
