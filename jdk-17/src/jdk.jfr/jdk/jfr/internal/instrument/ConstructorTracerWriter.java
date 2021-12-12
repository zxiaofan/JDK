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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

final class ConstructorTracerWriter extends ClassVisitor {

    private ConstructorWriter useInputParameter, noUseInputParameter;

    static byte[] generateBytes(Class<?> clz, byte[] oldBytes) throws IOException {
        InputStream in = new ByteArrayInputStream(oldBytes);
        ClassReader cr = new ClassReader(in);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ConstructorTracerWriter ctw = new ConstructorTracerWriter(cw, clz);
        cr.accept(ctw, 0);
        return cw.toByteArray();
    }

    private ConstructorTracerWriter(ClassVisitor cv, Class<?> classToChange) {
        super(Opcodes.ASM7, cv);
        useInputParameter = new ConstructorWriter(classToChange, true);
        noUseInputParameter = new ConstructorWriter(classToChange, false);
    }

    private boolean isConstructor(String name) {
        return name.equals("<init>");
    }

    private boolean takesStringParameter(String desc) {
        Type[] types = Type.getArgumentTypes(desc);
        if (types.length > 0 && types[0].getClassName().equals(String.class.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);

        // Get a hold of the constructors that takes a String as a parameter
        if (isConstructor(name)) {
            if (takesStringParameter(desc)) {
                useInputParameter.setMethodVisitor(mv);
                return useInputParameter;
            }
            noUseInputParameter.setMethodVisitor(mv);
            return noUseInputParameter;
        }
        return mv;
    }
}
