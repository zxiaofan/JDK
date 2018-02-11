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

import static jdk.internal.org.objectweb.asm.Opcodes.AALOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.AASTORE;
import static jdk.internal.org.objectweb.asm.Opcodes.ALOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.ANEWARRAY;
import static jdk.internal.org.objectweb.asm.Opcodes.ARRAYLENGTH;

import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * This is an array type, i.e. OBJECT_ARRAY, NUMBER_ARRAY.
 */
public class ArrayType extends ObjectType implements BytecodeArrayOps {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     *
     * @param clazz the Java class representation of the array
     */
    protected ArrayType(final Class<?> clazz) {
        super(clazz);
    }

    /**
     * Get the element type of the array elements e.g. for OBJECT_ARRAY, this is OBJECT
     *
     * @return the element type
     */
    public Type getElementType() {
        return Type.typeFor(getTypeClass().getComponentType());
    }

    @Override
    public void astore(final MethodVisitor method) {
        method.visitInsn(AASTORE);
    }

    @Override
    public Type aload(final MethodVisitor method) {
        method.visitInsn(AALOAD);
        return getElementType();
    }

    @Override
    public Type arraylength(final MethodVisitor method) {
        method.visitInsn(ARRAYLENGTH);
        return INT;
    }

    @Override
    public Type newarray(final MethodVisitor method) {
        method.visitTypeInsn(ANEWARRAY, getElementType().getInternalName());
        return this;
    }

    @Override
    public Type newarray(final MethodVisitor method, final int dims) {
        method.visitMultiANewArrayInsn(getInternalName(), dims);
        return this;
    }

    @Override
    public Type load(final MethodVisitor method, final int slot) {
        assert slot != -1;
        method.visitVarInsn(ALOAD, slot);
        return this;
    }

    @Override
    public String toString() {
        return "array<elementType=" + getElementType().getTypeClass().getSimpleName() + '>';
    }

    @Override
    public Type convert(final MethodVisitor method, final Type to) {
        assert to.isObject();
        assert !to.isArray() || ((ArrayType)to).getElementType() == getElementType();
        return to;
    }

}
