/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.meta;

/**
 * Provides memory access operations for the target VM.
 */
public interface MemoryAccessProvider {

    /**
     * Reads a primitive value using a base address and a displacement.
     *
     * @param kind the {@link JavaKind} of the returned {@link JavaConstant} object
     * @param base the base address from which the value is read
     * @param displacement the displacement within the object in bytes
     * @param bits the number of bits to read from memory
     * @return the read value encapsulated in a {@link JavaConstant} object of {@link JavaKind} kind
     * @throws IllegalArgumentException if the read is out of bounds of the object or {@code kind}
     *             is {@link JavaKind#Void} or not {@linkplain JavaKind#isPrimitive() primitive}
     *             kind or {@code bits} is not 8, 16, 32 or 64
     */
    JavaConstant readPrimitiveConstant(JavaKind kind, Constant base, long displacement, int bits) throws IllegalArgumentException;

    /**
     * Reads a Java {@link Object} value using a base address and a displacement.
     *
     * @param base the base address from which the value is read
     * @param displacement the displacement within the object in bytes
     * @return the read value encapsulated in a {@link Constant} object
     * @throws IllegalArgumentException if the address computed from {@code base} and
     *             {@code displacement} does not denote a location holding an {@code Object} value
     */
    JavaConstant readObjectConstant(Constant base, long displacement);
}
