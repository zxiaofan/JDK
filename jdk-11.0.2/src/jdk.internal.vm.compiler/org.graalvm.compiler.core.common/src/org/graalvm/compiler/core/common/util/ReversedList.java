/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.util;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/**
 * A {@code ReversedList} is a view on an other list with the elements in reverse order.
 *
 * This implementation is made for {@link RandomAccess} lists.
 */
public class ReversedList<T> extends AbstractList<T> implements RandomAccess {
    private final List<T> original;

    public ReversedList(List<T> original) {
        assert original instanceof RandomAccess;
        this.original = original;
    }

    @Override
    public T get(int index) {
        return original.get(original.size() - index - 1);
    }

    @Override
    public int size() {
        return original.size();
    }

    /**
     * Creates a list that is a view on {@code list} in reverse order.
     */
    public static <T> ReversedList<T> reversed(List<T> list) {
        return new ReversedList<>(list);
    }
}
