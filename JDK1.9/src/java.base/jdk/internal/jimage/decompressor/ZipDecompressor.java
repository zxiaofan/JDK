/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.jimage.decompressor;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

/**
 *
 * ZIP Decompressor
 *
 * @implNote This class needs to maintain JDK 8 source compatibility.
 *
 * It is used internally in the JDK to implement jimage/jrtfs access,
 * but also compiled and delivered as part of the jrtfs.jar to support access
 * to the jimage file provided by the shipped JDK by tools running on JDK 8.
 */
final class ZipDecompressor implements ResourceDecompressor {

    @Override
    public String getName() {
        return ZipDecompressorFactory.NAME;
    }

    static byte[] decompress(byte[] bytesIn, int offset) throws Exception {
        Inflater inflater = new Inflater();
        inflater.setInput(bytesIn, offset, bytesIn.length - offset);
        ByteArrayOutputStream stream = new ByteArrayOutputStream(bytesIn.length - offset);
        byte[] buffer = new byte[1024];

        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            stream.write(buffer, 0, count);
        }

        stream.close();

        byte[] bytesOut = stream.toByteArray();
        inflater.end();

        return bytesOut;
    }

    @Override
    public byte[] decompress(StringsProvider reader, byte[] content, int offset,
            long originalSize) throws Exception {
        byte[] decompressed = decompress(content, offset);
        return decompressed;
    }
}
