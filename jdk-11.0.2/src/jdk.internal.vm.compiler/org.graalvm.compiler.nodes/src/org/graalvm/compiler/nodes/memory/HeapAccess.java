/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.memory;

/**
 * Encapsulates properties of a node describing how it accesses the heap.
 */
public interface HeapAccess {

    /**
     * The types of (write/read) barriers attached to stores.
     */
    enum BarrierType {
        /**
         * Primitive stores which do not necessitate barriers.
         */
        NONE,
        /**
         * Array object stores which necessitate precise barriers.
         */
        PRECISE,
        /**
         * Field object stores which necessitate imprecise barriers.
         */
        IMPRECISE
    }

    /**
     * Gets the write barrier type for that particular access.
     */
    BarrierType getBarrierType();
}
