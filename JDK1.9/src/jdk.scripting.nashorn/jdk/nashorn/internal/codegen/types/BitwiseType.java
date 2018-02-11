/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.codegen.types;

/**
 * This class represents a numeric type that can be used for bit operations.
 */
public abstract class BitwiseType extends NumericType implements BytecodeBitwiseOps {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     *
     * @param name   name of type
     * @param clazz  Java class used to represent type
     * @param weight weight of type
     * @param slots  number of bytecode slots this type takes up
     */
    protected BitwiseType(final String name, final Class<?> clazz, final int weight, final int slots) {
        super(name, clazz, weight, slots);
    }
}
