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


package org.graalvm.graphio;

import java.util.Collection;
import java.util.Collections;

final class DefaultGraphBlocks implements GraphBlocks<Object, Object, Object> {
    private static final DefaultGraphBlocks DEFAULT = new DefaultGraphBlocks();

    private DefaultGraphBlocks() {
    }

    @SuppressWarnings("unchecked")
    public static <G, B, N> GraphBlocks<G, B, N> empty() {
        return (GraphBlocks<G, B, N>) DEFAULT;
    }

    @Override
    public Collection<? extends Void> blocks(Object graph) {
        return Collections.emptyList();
    }

    @Override
    public int blockId(Object block) {
        return -1;
    }

    @Override
    public Collection<? extends Object> blockNodes(Object info, Object block) {
        return Collections.emptyList();
    }

    @Override
    public Collection<? extends Object> blockSuccessors(Object block) {
        return Collections.emptyList();
    }
}
