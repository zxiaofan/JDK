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

final class LiteralWithIndexingWriter extends IndexNameValueWriter {

    private boolean tableUpdated;

    private CharSequence name;
    private CharSequence value;
    private int index;

    LiteralWithIndexingWriter() {
        super(0b0100_0000, 6);
    }

    @Override
    LiteralWithIndexingWriter index(int index) {
        super.index(index);
        this.index = index;
        return this;
    }

    @Override
    LiteralWithIndexingWriter name(CharSequence name, boolean useHuffman) {
        super.name(name, useHuffman);
        this.name = name;
        return this;
    }

    @Override
    LiteralWithIndexingWriter value(CharSequence value, boolean useHuffman) {
        super.value(value, useHuffman);
        this.value = value;
        return this;
    }

    @Override
    public boolean write(HeaderTable table, ByteBuffer destination) {
        if (!tableUpdated) {
            CharSequence n;
            if (indexedRepresentation) {
                n = table.get(index).name;
            } else {
                n = name;
            }
            table.put(n, value);
            tableUpdated = true;
        }
        return super.write(table, destination);
    }

    @Override
    public IndexNameValueWriter reset() {
        tableUpdated = false;
        name = null;
        value = null;
        index = -1;
        return super.reset();
    }
}
