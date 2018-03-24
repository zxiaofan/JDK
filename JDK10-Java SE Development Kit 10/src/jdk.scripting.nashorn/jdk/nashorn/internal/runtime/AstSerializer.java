/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.internal.runtime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import jdk.nashorn.internal.ir.FunctionNode;
import jdk.nashorn.internal.runtime.options.Options;

/**
 * This static utility class performs serialization of FunctionNode ASTs to a byte array.
 * The format is a standard Java serialization stream, deflated.
 */
final class AstSerializer {
    // Experimentally, we concluded that compression level 4 gives a good tradeoff between serialization speed
    // and size.
    private static final int COMPRESSION_LEVEL = Options.getIntProperty("nashorn.serialize.compression", 4);
    static byte[] serialize(final FunctionNode fn) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final Deflater deflater = new Deflater(COMPRESSION_LEVEL);
        try (final ObjectOutputStream oout = new ObjectOutputStream(new DeflaterOutputStream(out, deflater))) {
            oout.writeObject(fn);
        } catch (final IOException e) {
            throw new AssertionError("Unexpected exception serializing function", e);
        } finally {
            deflater.end();
        }
        return out.toByteArray();
    }
}
