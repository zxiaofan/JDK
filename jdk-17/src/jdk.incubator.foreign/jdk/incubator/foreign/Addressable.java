/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package jdk.incubator.foreign;

/**
 * Represents a type which is <em>addressable</em>. An addressable type is one which can be projected down to
 * a memory address instance (see {@link #address()}). Examples of addressable types are {@link MemorySegment},
 * {@link MemoryAddress} and {@link CLinker.VaList}.
 *
 * @implSpec
 * Implementations of this interface are <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>.
 */
public interface Addressable {
    /**
     * Map this object into a {@link MemoryAddress} instance.
     * @return the {@link MemoryAddress} instance associated with this object.
     */
    MemoryAddress address();
}
