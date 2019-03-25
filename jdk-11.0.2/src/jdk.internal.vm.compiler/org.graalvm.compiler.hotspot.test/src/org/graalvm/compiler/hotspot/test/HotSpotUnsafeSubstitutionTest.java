/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.test;

import org.graalvm.compiler.hotspot.meta.HotSpotUnsafeSubstitutions;
import org.graalvm.compiler.replacements.test.MethodSubstitutionTest;
import org.junit.Test;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import sun.misc.Unsafe;

/**
 * Tests the VM independent intrinsification of {@link Unsafe} methods.
 */
public class HotSpotUnsafeSubstitutionTest extends MethodSubstitutionTest {

    public void testSubstitution(String testMethodName, Class<?> holder, String methodName, Class<?>[] parameterTypes, Object receiver, Object[] args1, Object[] args2) {
        ResolvedJavaMethod testMethod = getResolvedJavaMethod(testMethodName);
        ResolvedJavaMethod originalMethod = getResolvedJavaMethod(holder, methodName, parameterTypes);

        // Force compilation
        InstalledCode code = getCode(testMethod);
        assert code != null;

        // Verify that the original method and the substitution produce the same value
        Object expected = invokeSafe(originalMethod, receiver, args1);
        Object actual = invokeSafe(testMethod, null, args2);
        assertDeepEquals(expected, actual);

        // Verify that the generated code and the original produce the same value
        expected = invokeSafe(originalMethod, receiver, args1);
        actual = executeVarargsSafe(code, args2);
        assertDeepEquals(expected, actual);

    }

    @Test
    public void testUnsafeSubstitutions() throws Exception {
        testGraph("unsafeCopyMemory", HotSpotUnsafeSubstitutions.copyMemoryName);
    }

    public void unsafeCopyMemory(Object srcBase, long srcOffset, Object dstBase, long dstOffset, long bytes) {
        UNSAFE.copyMemory(srcBase, srcOffset, dstBase, dstOffset, bytes);
    }

    public byte[] testCopyMemorySnippet(long src, int bytes) {
        byte[] result = new byte[bytes];
        UNSAFE.copyMemory(null, src, result, Unsafe.ARRAY_BYTE_BASE_OFFSET, bytes);
        return result;
    }

    @Test
    public void testCopyMemory() {
        int size = 128;
        long src = UNSAFE.allocateMemory(size);
        for (int i = 0; i < size; i++) {
            UNSAFE.putByte(null, src + i, (byte) i);
        }
        test("testCopyMemorySnippet", src, size);
    }
}
