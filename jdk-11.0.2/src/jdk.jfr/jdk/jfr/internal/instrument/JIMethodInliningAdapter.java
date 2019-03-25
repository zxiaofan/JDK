/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.instrument;

import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.commons.LocalVariablesSorter;
import jdk.internal.org.objectweb.asm.commons.Remapper;
import jdk.internal.org.objectweb.asm.commons.RemappingMethodAdapter;

@Deprecated
final class JIMethodInliningAdapter extends RemappingMethodAdapter {
    private final LocalVariablesSorter lvs;
    private final Label end;

    public JIMethodInliningAdapter(LocalVariablesSorter mv, Label end, int acc, String desc, Remapper remapper) {
        super(acc, desc, mv, remapper);
        this.lvs = mv;
        this.end = end;
        int offset = isStatic(acc) ? 0 : 1;
        Type[] args = Type.getArgumentTypes(desc);
        for (int i = args.length - 1; i >= 0; i--) {
            super.visitVarInsn(args[i].getOpcode(Opcodes.ISTORE), i + offset);
        }
        if (offset > 0) {
            super.visitVarInsn(Opcodes.ASTORE, 0);
        }
    }

    private boolean isStatic(int acc) {
        return (acc & Opcodes.ACC_STATIC) != 0;
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN || opcode == Opcodes.IRETURN
                || opcode == Opcodes.ARETURN || opcode == Opcodes.LRETURN) {
            super.visitJumpInsn(Opcodes.GOTO, end);
        } else {
            super.visitInsn(opcode);
        }
    }

    @Override
    public void visitMaxs(int stack, int locals) {
    }

    @Override
    protected int newLocalMapping(Type type) {
        return lvs.newLocal(type);
    }
}
