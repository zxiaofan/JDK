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

import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Array operations, not supported by all ops
 */
interface BytecodeArrayOps {

    /**
     * Load an array element given that the array and its index are already on
     * the stack
     *
     * @param method method visitor
     * @return the array element type
     *
     */
    Type aload(MethodVisitor method);

    /**
     * Store an array element given that the array and its index and the element
     * are on the stack
     *
     * @param method method visitor
     */
    void astore(MethodVisitor method);

    /**
     * Generate an array length operation
     *
     * @param method method method visitor
     * @return length of the array
     */
    Type arraylength(MethodVisitor method);

    /**
     * Create a new array of this array type and length on stack
     *
     * @param method method visitor
     * @return the type of the array
     */
    Type newarray(MethodVisitor method);

    /**
     * Create a new multi array of this array type and allocate the number of
     * dimensions given
     *
     * @param method method visitor
     * @param dims   number of dimensions
     * @return the type of the new array
     */
    Type newarray(MethodVisitor method, int dims);
}
