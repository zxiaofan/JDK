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
 */


package org.graalvm.compiler.phases.common;

import java.util.function.Supplier;

/**
 * A {@link Supplier} which always returns the same value, computed from an other supplier on the
 * first access.
 *
 * <p>
 * This implementation is not thread-safe and assumes the underlying supplier does not return null.
 * If the underlying supplier returns null it will be called on each access until it returns a
 * non-null value.
 * </p>
 */
public class LazyValue<T> implements Supplier<T> {
    private final Supplier<T> supplier;
    private T value;

    public LazyValue(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        if (value == null) {
            value = supplier.get();
        }
        return value;
    }
}
