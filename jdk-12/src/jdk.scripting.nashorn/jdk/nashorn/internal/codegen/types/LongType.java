/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.internal.org.objectweb.asm.Opcodes.L2D;
import static jdk.internal.org.objectweb.asm.Opcodes.L2I;
import static jdk.internal.org.objectweb.asm.Opcodes.LCONST_0;
import static jdk.internal.org.objectweb.asm.Opcodes.LCONST_1;
import static jdk.internal.org.objectweb.asm.Opcodes.LLOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.LRETURN;
import static jdk.internal.org.objectweb.asm.Opcodes.LSTORE;
import static jdk.nashorn.internal.codegen.CompilerConstants.staticCallNoLookup;
import static jdk.nashorn.internal.runtime.JSType.UNDEFINED_LONG;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.nashorn.internal.codegen.CompilerConstants;
import jdk.nashorn.internal.runtime.JSType;

/**
 * Type class: LONG
 */
class LongType extends Type {
    private static final long serialVersionUID = 1L;

    private static final CompilerConstants.Call VALUE_OF = staticCallNoLookup(Long.class, "valueOf", Long.class, long.class);

    protected LongType(final String name) {
        super(name, long.class, 3, 2);
    }

    protected LongType() {
        this("long");
    }

    @Override
    public Type nextWider() {
        return NUMBER;
    }

    @Override
    public Class<?> getBoxedType() {
        return Long.class;
    }

    @Override
    public char getBytecodeStackType() {
        return 'J';
    }

    @Override
    public Type load(final MethodVisitor method, final int slot) {
        assert slot != -1;
        method.visitVarInsn(LLOAD, slot);
        return LONG;
    }

    @Override
    public void store(final MethodVisitor method, final int slot) {
        assert slot != -1;
        method.visitVarInsn(LSTORE, slot);
    }

    @Override
    public Type ldc(final MethodVisitor method, final Object c) {
        assert c instanceof Long;

        final long value = (Long) c;

        if (value == 0L) {
            method.visitInsn(LCONST_0);
        } else if (value == 1L) {
            method.visitInsn(LCONST_1);
        } else {
            method.visitLdcInsn(c);
        }

        return Type.LONG;
    }

    @Override
    public Type convert(final MethodVisitor method, final Type to) {
        if (isEquivalentTo(to)) {
            return to;
        }

        if (to.isNumber()) {
            method.visitInsn(L2D);
        } else if (to.isInteger()) {
            invokestatic(method, JSType.TO_INT32_L);
        } else if (to.isBoolean()) {
            method.visitInsn(L2I);
        } else if (to.isObject()) {
            invokestatic(method, VALUE_OF);
        } else {
            assert false : "Illegal conversion " + this + " -> " + to;
        }

        return to;
    }

    @Override
    public Type add(final MethodVisitor method, final int programPoint) {
        throw new UnsupportedOperationException("add");
    }

    @Override
    public void _return(final MethodVisitor method) {
        method.visitInsn(LRETURN);
    }

    @Override
    public Type loadUndefined(final MethodVisitor method) {
        method.visitLdcInsn(UNDEFINED_LONG);
        return LONG;
    }

    @Override
    public Type loadForcedInitializer(final MethodVisitor method) {
        method.visitInsn(LCONST_0);
        return LONG;
    }
}
