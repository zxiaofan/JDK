/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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

public class BlockMap<T> {

    private final T[] data;

    @SuppressWarnings("unchecked")
    public BlockMap(AbstractControlFlowGraph<?> cfg) {
        data = (T[]) new Object[cfg.getBlocks().length];
    }

    public T get(AbstractBlockBase<?> block) {
        return data[block.getId()];
    }

    public void put(AbstractBlockBase<?> block, T value) {
        data[block.getId()] = value;
    }
}
