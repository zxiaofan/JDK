/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.test.GraalTest;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import jdk.vm.ci.meta.JavaKind;

public final class SubWordTestUtil implements Opcodes {

    private SubWordTestUtil() {
    }

    static void convertToKind(MethodVisitor snippet, JavaKind kind) {
        switch (kind) {
            case Boolean:
                snippet.visitInsn(ICONST_1);
                snippet.visitInsn(IAND);
                break;
            case Byte:
                snippet.visitInsn(I2B);
                break;
            case Short:
                snippet.visitInsn(I2S);
                break;
            case Char:
                snippet.visitInsn(I2C);
                break;
            default:
                throw GraalError.shouldNotReachHere();
        }
    }

    static void testEqual(MethodVisitor snippet) {
        Label label = new Label();
        snippet.visitJumpInsn(IF_ICMPNE, label);
        snippet.visitInsn(ICONST_1);
        snippet.visitInsn(IRETURN);
        snippet.visitLabel(label);
        snippet.visitInsn(ICONST_0);
        snippet.visitInsn(IRETURN);
    }

    static void getUnsafe(MethodVisitor snippet) {
        snippet.visitFieldInsn(GETSTATIC, GraalTest.class.getName().replace('.', '/'), "UNSAFE", "Lsun/misc/Unsafe;");
    }

    static String getUnsafePutMethodName(JavaKind kind) {
        String name = kind.getJavaName();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
