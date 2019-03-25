/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.cfg;

import java.util.function.BiConsumer;

/**
 * Represents a control-flow graph where each node can be annotated with arbitrary property pairs of
 * the form ({@linkplain String name}, {@linkplain String value}).
 */
public interface PrintableCFG {

    AbstractBlockBase<?>[] getBlocks();

    /**
     * Applies {@code action} to all extra property pairs (name, value) of {@code block}.
     *
     * @param block a block from {@link #getBlocks()}.
     * @param action a {@link BiConsumer consumer}.
     */
    default void forEachPropertyPair(AbstractBlockBase<?> block, BiConsumer<String, String> action) {
        // no extra properties per default
    }
}
