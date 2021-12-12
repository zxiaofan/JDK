/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.net.http.hpack;

import java.nio.ByteBuffer;

final class IndexedWriter implements BinaryRepresentationWriter {

    private final IntegerWriter intWriter = new IntegerWriter();

    IndexedWriter() { }

    IndexedWriter index(int index) {
        intWriter.configure(index, 7, 0b1000_0000);
        return this;
    }

    @Override
    public boolean write(HeaderTable table, ByteBuffer destination) {
        return intWriter.write(destination);
    }

    @Override
    public BinaryRepresentationWriter reset() {
        intWriter.reset();
        return this;
    }
}
