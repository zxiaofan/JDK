/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;

import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;

/**
 * Tests compiled call to {@link CRC32#update(int, int)}.
 */
@SuppressWarnings("javadoc")
public class CRC32SubstitutionsTest extends GraalCompilerTest {

    public static long update(byte[] input) {
        CRC32 crc = new CRC32();
        for (byte b : input) {
            crc.update(b);
        }
        return crc.getValue();
    }

    @Test
    public void test1() {
        test("update", "some string".getBytes());
    }

    public static long updateBytes(byte[] input, int offset, int length) {
        CRC32 crc = new CRC32();
        crc.update(input, offset, length);
        return crc.getValue();
    }

    @Test
    public void test2() {
        byte[] buf = "some string".getBytes();
        int off = 0;
        int len = buf.length;
        test("updateBytes", buf, off, len);
    }

    @Test
    public void test3() throws Throwable {
        String classfileName = CRC32SubstitutionsTest.class.getSimpleName().replace('.', '/') + ".class";
        InputStream s = CRC32SubstitutionsTest.class.getResourceAsStream(classfileName);
        byte[] buf = new byte[s.available()];
        new DataInputStream(s).readFully(buf);
        test("updateBytes", buf, 0, buf.length);
        for (int offset = 1; offset < buf.length; offset++) {
            test("updateBytes", buf, offset, buf.length - offset);
        }
    }

    public static long updateByteBuffer(ByteBuffer buffer) {
        CRC32 crc = new CRC32();
        buffer.rewind();
        crc.update(buffer);
        return crc.getValue();
    }

    @Test
    public void test4() throws Throwable {
        String classfileName = CRC32SubstitutionsTest.class.getSimpleName().replace('.', '/') + ".class";
        InputStream s = CRC32SubstitutionsTest.class.getResourceAsStream(classfileName);
        byte[] buf = new byte[s.available()];
        new DataInputStream(s).readFully(buf);

        ByteBuffer directBuf = ByteBuffer.allocateDirect(buf.length);
        directBuf.put(buf);
        ByteBuffer heapBuf = ByteBuffer.wrap(buf);

        test("updateByteBuffer", directBuf);
        test("updateByteBuffer", heapBuf);
    }

}
