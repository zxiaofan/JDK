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


package org.graalvm.compiler.replacements.test;

import java.lang.reflect.Field;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.junit.Test;

public class UnsafeBooleanAccessTest extends GraalCompilerTest {

    private static short onHeapMemory;

    private static final Object onHeapMemoryBase;
    private static final long onHeapMemoryOffset;

    static {
        try {
            Field staticField = UnsafeBooleanAccessTest.class.getDeclaredField("onHeapMemory");
            onHeapMemoryBase = UNSAFE.staticFieldBase(staticField);
            onHeapMemoryOffset = UNSAFE.staticFieldOffset(staticField);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean testGetBooleanSnippet() {
        UNSAFE.putShort(onHeapMemoryBase, onHeapMemoryOffset, (short) 0x0204);
        return UNSAFE.getBoolean(onHeapMemoryBase, onHeapMemoryOffset);
    }

    @Test
    public void testGetBoolean() {
        test("testGetBooleanSnippet");
    }

    public static short testPutBooleanSnippet() {
        UNSAFE.putShort(onHeapMemoryBase, onHeapMemoryOffset, (short) 0x0204);
        boolean bool = UNSAFE.getBoolean(onHeapMemoryBase, onHeapMemoryOffset);
        UNSAFE.putBoolean(onHeapMemoryBase, onHeapMemoryOffset, bool);
        return onHeapMemory;
    }

    @Test
    public void testPutBoolean() {
        test("testPutBooleanSnippet");
    }

    public static boolean testAndBooleanSnippet() {
        UNSAFE.putShort(onHeapMemoryBase, onHeapMemoryOffset, (short) 0x0204);
        boolean bool0 = UNSAFE.getBoolean(onHeapMemoryBase, onHeapMemoryOffset);
        boolean bool1 = UNSAFE.getBoolean(onHeapMemoryBase, onHeapMemoryOffset + 1);
        return bool0 & bool1;
    }

    @Test
    public void testAndBoolean() {
        test("testAndBooleanSnippet");
    }

}
