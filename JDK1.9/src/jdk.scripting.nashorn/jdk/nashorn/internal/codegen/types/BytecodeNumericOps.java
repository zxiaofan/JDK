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
 * Numeric operations, not supported by all types
 */
interface BytecodeNumericOps {

    /**
     * Pop and negate the value on top of the stack and push the result
     *
     * @param method method visitor
     * @param programPoint program point id
     * @return result type
     */
    Type neg(MethodVisitor method, int programPoint);

    /**
     * Pop two values on top of the stack and subtract the first from the
     * second, pushing the result on the stack
     *
     * @param method method visitor
     * @param programPoint program point id
     * @return result type
     */
    Type sub(MethodVisitor method, int programPoint);

    /**
     * Pop and multiply the two values on top of the stack and push the result
     * on the stack
     *
     * @param method method visitor
     * @param programPoint program point id
     * @return result type
     */
    Type mul(MethodVisitor method, int programPoint);

    /**
     * Pop two values on top of the stack and divide the first with the second,
     * pushing the result on the stack
     *
     * @param method method visitor
     * @param programPoint program point id
     * @return result type
     */
    Type div(MethodVisitor method, int programPoint);

    /**
     * Pop two values on top of the stack and compute the modulo of the first
     * with the second, pushing the result on the stack
     *
     * Note that the rem method never takes a program point, because it
     * can never be more optimistic than its widest operand - an int/int
     * rem operation or a long/long rem operation can never return a
     * winder remainder than the int or the long
     *
     * @param method method visitor
     * @param programPoint program point id
     * @return result type
     */
    Type rem(MethodVisitor method, int programPoint);

    /**
     * Comparison with int return value, e.g. LCMP, DCMP.
     *
     * @param method the method visitor
     * @param isCmpG is this a double style cmpg
     *
     * @return int return value
     */
    Type cmp(MethodVisitor method, boolean isCmpG);
}
