/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64.test;

import static jdk.vm.ci.amd64.AMD64.rax;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import org.graalvm.compiler.asm.amd64.AMD64Assembler;
import org.graalvm.compiler.core.test.GraalCompilerTest;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterArray;
import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.hotspot.HotSpotCallingConventionType;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Ensures that frame omission works in cases where it is expected to.
 */
public class AMD64HotSpotFrameOmissionTest extends GraalCompilerTest {

    interface CodeGenerator {

        void generateCode(AMD64Assembler asm);
    }

    public static void test1snippet() {
        return;
    }

    @Ignore
    @Test
    public void test1() {
        testHelper("test1snippet", new CodeGenerator() {

            @Override
            public void generateCode(AMD64Assembler asm) {
                asm.nop(5); // padding for mt-safe patching
                asm.ret(0);
            }
        });
    }

    public static int test2snippet(int x) {
        return x + 5;
    }

    @Ignore
    @Test
    public void test2() {
        testHelper("test2snippet", new CodeGenerator() {

            @Override
            public void generateCode(AMD64Assembler asm) {
                Register arg = getArgumentRegister(0, JavaKind.Int);
                asm.nop(5); // padding for mt-safe patching
                asm.addl(arg, 5);
                asm.movl(rax, arg);
                asm.ret(0);
            }
        });
    }

    public static long test3snippet(long x) {
        return 1 + x;
    }

    @Ignore
    @Test
    public void test3() {
        testHelper("test3snippet", new CodeGenerator() {

            @Override
            public void generateCode(AMD64Assembler asm) {
                Register arg = getArgumentRegister(0, JavaKind.Long);
                asm.nop(5); // padding for mt-safe patching
                asm.addq(arg, 1);
                asm.movq(rax, arg);
                asm.ret(0);
            }
        });
    }

    private void testHelper(String name, CodeGenerator gen) {
        ResolvedJavaMethod javaMethod = getResolvedJavaMethod(name);
        InstalledCode installedCode = getCode(javaMethod);

        TargetDescription target = getCodeCache().getTarget();
        AMD64Assembler asm = new AMD64Assembler(target);

        gen.generateCode(asm);
        byte[] expectedCode = asm.close(true);

        // Only compare up to expectedCode.length bytes to ignore
        // padding instructions adding during code installation
        byte[] actualCode = Arrays.copyOf(installedCode.getCode(), expectedCode.length);

        Assert.assertArrayEquals(expectedCode, actualCode);
    }

    private Register getArgumentRegister(int index, JavaKind kind) {
        RegisterArray regs = getCodeCache().getRegisterConfig().getCallingConventionRegisters(HotSpotCallingConventionType.JavaCall, kind);
        return regs.get(index);
    }
}
