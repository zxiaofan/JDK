/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;

/**
 * Sometimes it's possible to emit a smaller read from a larger memory location instead reading the
 * whole thing and truncating it. Make sure it returns the right value.
 */
public class NarrowingReadTest extends GraalCompilerTest {

    public byte testNarrowReadSnippetByte(Long l) {
        return (byte) l.longValue();
    }

    @Test
    public void testNarrowReadByte() {
        test("testNarrowReadSnippetByte", Long.valueOf(Byte.MAX_VALUE));
    }

    public short testNarrowReadSnippetShort(Long l) {
        return (short) l.longValue();
    }

    @Test
    public void testNarrowReadShort() {
        test("testNarrowReadSnippetShort", Long.valueOf(Short.MAX_VALUE));
    }

    public int testNarrowReadSnippetInt(Long l) {
        return (int) l.longValue();
    }

    @Test
    public void testNarrowReadInt() {
        test("testNarrowReadSnippetInt", Long.valueOf(Integer.MAX_VALUE));
    }

    public long testNarrowReadSnippetIntToLong(Long l) {
        return (int) l.longValue();
    }

    @Test
    public void testNarrowReadIntToLong() {
        test("testNarrowReadSnippetIntToLong", Long.valueOf(Integer.MAX_VALUE));
    }
}
