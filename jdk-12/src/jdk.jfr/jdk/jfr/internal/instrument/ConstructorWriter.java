/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.internal.org.objectweb.asm.Opcodes.ACONST_NULL;
import static jdk.internal.org.objectweb.asm.Opcodes.ALOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESTATIC;
import static jdk.internal.org.objectweb.asm.Opcodes.RETURN;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

final class ConstructorWriter extends MethodVisitor {

    private boolean useInputParameter;
    private String shortClassName;
    private String fullClassName;

    ConstructorWriter(Class<?> classToChange, boolean useInputParameter) {
        super(Opcodes.ASM7);
        this.useInputParameter = useInputParameter;
        shortClassName = classToChange.getSimpleName();
        fullClassName = classToChange.getName().replace('.', '/');
    }

    @Override
    public void visitInsn(int opcode)
    {
        if (opcode == RETURN) {
            if (useInputParameter) {
                useInput();
            } else {
                noInput();
            }
        }
        mv.visitInsn(opcode);
    }
    @SuppressWarnings("deprecation")
    private void useInput()
    {
        //Load 'this' from local variable 0
        //Load first input parameter
        //Invoke ThrowableTracer.traceCLASS(this, parameter) for current class
        mv.visitVarInsn(ALOAD, 0);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKESTATIC, "jdk/jfr/internal/instrument/ThrowableTracer",
                "trace" + shortClassName, "(L" + fullClassName +
                ";Ljava/lang/String;)V");
    }

    @SuppressWarnings("deprecation")
    private void noInput()
    {
        //Load 'this' from local variable 0
        //Load ""
        //Invoke ThrowableTracer.traceCLASS(this, "") for current class
        mv.visitVarInsn(ALOAD, 0);
        mv.visitInsn(ACONST_NULL);
        mv.visitMethodInsn(INVOKESTATIC, "jdk/jfr/internal/instrument/ThrowableTracer",
                "trace" + shortClassName, "(L" + fullClassName +
                ";Ljava/lang/String;)V");
    }

    public void setMethodVisitor(MethodVisitor mv) {
        this.mv = mv;
    }
}
