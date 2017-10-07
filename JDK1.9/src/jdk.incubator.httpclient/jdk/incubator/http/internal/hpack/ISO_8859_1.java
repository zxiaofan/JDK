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
package jdk.incubator.http.internal.hpack;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;

//
// Custom implementation of ISO/IEC 8859-1:1998
//
// The rationale behind this is not to deal with CharsetEncoder/CharsetDecoder,
// basically because it would require wrapping every single CharSequence into a
// CharBuffer and then copying it back.
//
// But why not to give a CharBuffer instead of Appendable? Because I can choose
// an Appendable (e.g. StringBuilder) that adjusts its length when needed and
// therefore not to deal with pre-sized CharBuffers or copying.
//
// The encoding is simple and well known: 1 byte <-> 1 char
//
final class ISO_8859_1 {

    private ISO_8859_1() { }

    public static final class Reader {

        public void read(ByteBuffer source, Appendable destination) {
            for (int i = 0, len = source.remaining(); i < len; i++) {
                char c = (char) (source.get() & 0xff);
                try {
                    destination.append(c);
                } catch (IOException e) {
                    throw new UncheckedIOException
                            ("Error appending to the destination", e);
                }
            }
        }

        public Reader reset() {
            return this;
        }
    }

    public static final class Writer {

        private CharSequence source;
        private int pos;
        private int end;

        public Writer configure(CharSequence source, int start, int end) {
            this.source = source;
            this.pos = start;
            this.end = end;
            return this;
        }

        public boolean write(ByteBuffer destination) {
            for (; pos < end; pos++) {
                char c = source.charAt(pos);
                if (c > '\u00FF') {
                    throw new IllegalArgumentException(
                            "Illegal ISO-8859-1 char: " + (int) c);
                }
                if (destination.hasRemaining()) {
                    destination.put((byte) c);
                } else {
                    return false;
                }
            }
            return true;
        }

        public Writer reset() {
            source = null;
            pos = -1;
            end = -1;
            return this;
        }
    }
}
