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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import jdk.vm.ci.meta.DeoptimizationReason;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

@RunWith(Parameterized.class)
public class SubWordInputTest2 extends CustomizedBytecodePatternTest {

    @Parameterized.Parameters(name = "{0}, {1}")
    public static List<Object[]> data() {
        ArrayList<Object[]> ret = new ArrayList<>();
        for (int i : new int[]{0xFFFF0000, 0xFFFF0001, 0x0000FFFF}) {
            ret.add(new Object[]{JavaKind.Byte, i});
            ret.add(new Object[]{JavaKind.Short, i});
            ret.add(new Object[]{JavaKind.Char, i});
        }
        return ret;
    }

    private static final String GET = "get";
    private static final String WRAPPER = "wrapper";

    private final JavaKind kind;
    private final int value;

    public SubWordInputTest2(JavaKind kind, int value) {
        this.kind = kind;
        this.value = value;
    }

    @Test
    public void testSubWordInput() throws ClassNotFoundException {
        Class<?> testClass = getClass(SubWordInputTest2.class.getName() + "$" + kind.toString() + "Getter");
        ResolvedJavaMethod wrapper = getResolvedJavaMethod(testClass, WRAPPER);
        Result expected = executeExpected(wrapper, null, value);
        // test standalone callee
        getCode(getResolvedJavaMethod(testClass, GET), null, false, true, getInitialOptions());
        assertEquals(executeExpected(wrapper, null, value), expected);
        // test with inlining
        testAgainstExpected(wrapper, expected, Collections.<DeoptimizationReason> emptySet(), null, value);
    }

    @Override
    protected byte[] generateClass(String internalClassName) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(52, ACC_SUPER | ACC_PUBLIC, internalClassName, null, "java/lang/Object", null);

        final char typeChar = kind.getTypeChar();
        String getDescriptor = "(" + typeChar + ")" + "Z";
        MethodVisitor get = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, GET, getDescriptor, null, null);
        get.visitCode();
        get.visitVarInsn(ILOAD, 0);
        Label label = new Label();
        get.visitJumpInsn(IFGE, label);
        get.visitInsn(ICONST_0);
        get.visitInsn(IRETURN);
        get.visitLabel(label);
        get.visitInsn(ICONST_1);
        get.visitInsn(IRETURN);
        get.visitMaxs(1, 1);
        get.visitEnd();

        MethodVisitor snippet = cw.visitMethod(ACC_PUBLIC | ACC_STATIC, WRAPPER, "(I)Z", null, null);
        snippet.visitCode();
        snippet.visitVarInsn(ILOAD, 0);
        snippet.visitMethodInsn(INVOKESTATIC, internalClassName, GET, getDescriptor, false);
        snippet.visitInsn(IRETURN);
        snippet.visitMaxs(1, 1);
        snippet.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }
}
