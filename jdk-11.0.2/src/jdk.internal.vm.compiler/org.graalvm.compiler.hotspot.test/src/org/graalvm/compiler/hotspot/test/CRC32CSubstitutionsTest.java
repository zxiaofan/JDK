/*
 * Copyright (c) 2007, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.util.zip.Checksum;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.graalvm.compiler.test.GraalTest;
import org.graalvm.compiler.core.test.GraalCompilerTest;

import org.junit.Test;

import static org.junit.Assume.assumeFalse;

/**
 * Tests compiled calls to {@link java.util.zip.CRC32C}.
 */
@SuppressWarnings("javadoc")
public class CRC32CSubstitutionsTest extends GraalCompilerTest {

    public static long updateBytes(byte[] input, int offset, int end) throws Throwable {
        Class<?> crcClass = Class.forName("java.util.zip.CRC32C");
        MethodHandle newMH = MethodHandles.publicLookup().findConstructor(crcClass, MethodType.methodType(void.class));
        Checksum crc = (Checksum) newMH.invoke();
        crc.update(input, offset, end);
        return crc.getValue();
    }

    @Test
    public void test1() throws Throwable {
        assumeFalse(GraalTest.Java8OrEarlier);
        String classfileName = CRC32CSubstitutionsTest.class.getSimpleName().replace('.', '/') + ".class";
        InputStream s = CRC32CSubstitutionsTest.class.getResourceAsStream(classfileName);
        byte[] buf = new byte[s.available()];
        new DataInputStream(s).readFully(buf);
        int end = buf.length;
        for (int offset = 0; offset < buf.length; offset++) {
            test("updateBytes", buf, offset, end);
        }
    }

    public static long updateByteBuffer(ByteBuffer buffer) throws Throwable {
        Class<?> crcClass = Class.forName("java.util.zip.CRC32C");
        MethodHandle newMH = MethodHandles.publicLookup().findConstructor(crcClass, MethodType.methodType(void.class));
        MethodHandle updateMH = MethodHandles.publicLookup().findVirtual(crcClass, "update", MethodType.methodType(void.class, ByteBuffer.class));
        Checksum crc = (Checksum) newMH.invoke();
        buffer.rewind();
        updateMH.invokeExact(crc, buffer); // Checksum.update(ByteBuffer) is also available since 9
        return crc.getValue();
    }

    @Test
    public void test2() throws Throwable {
        assumeFalse(GraalTest.Java8OrEarlier);
        String classfileName = CRC32CSubstitutionsTest.class.getSimpleName().replace('.', '/') + ".class";
        InputStream s = CRC32CSubstitutionsTest.class.getResourceAsStream(classfileName);
        byte[] buf = new byte[s.available()];
        new DataInputStream(s).readFully(buf);

        ByteBuffer directBuf = ByteBuffer.allocateDirect(buf.length);
        directBuf.put(buf);
        ByteBuffer heapBuf = ByteBuffer.wrap(buf);

        test("updateByteBuffer", directBuf);
        test("updateByteBuffer", heapBuf);
    }

}
