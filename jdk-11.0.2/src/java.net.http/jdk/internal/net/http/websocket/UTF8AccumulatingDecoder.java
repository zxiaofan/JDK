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

package jdk.internal.net.http.websocket;

import jdk.internal.net.http.common.Log;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

import static java.nio.charset.StandardCharsets.UTF_8;
import static jdk.internal.net.http.common.Utils.EMPTY_BYTEBUFFER;

final class UTF8AccumulatingDecoder {

    private final CharsetDecoder decoder = UTF_8.newDecoder();

    {
        decoder.onMalformedInput(CodingErrorAction.REPORT);
        decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    private ByteBuffer leftovers = EMPTY_BYTEBUFFER;

    CharBuffer decode(ByteBuffer in, boolean endOfInput)
            throws CharacterCodingException
    {
        ByteBuffer b;
        int rem = leftovers.remaining();
        if (rem != 0) {
            // We won't need this wasteful allocation & copying when JDK-8155222
            // has been resolved
            b = ByteBuffer.allocate(rem + in.remaining());
            b.put(leftovers).put(in).flip();
        } else {
            b = in;
        }
        CharBuffer out = CharBuffer.allocate(b.remaining());
        CoderResult r = decoder.decode(b, out, endOfInput);
        if (r.isError()) {
            r.throwException();
        }
        if (b.hasRemaining()) {
            leftovers = ByteBuffer.allocate(b.remaining()).put(b).flip();
        } else {
            leftovers = EMPTY_BYTEBUFFER;
        }
        // Since it's UTF-8, the assumption is leftovers.remaining() < 4
        // (i.e. small). Otherwise a shared buffer should be used
        if (!(leftovers.remaining() < 4)) {
            Log.logError("The size of decoding leftovers is greater than expected: {0}",
                         leftovers.remaining());
        }
        b.position(b.limit()); // As if we always read to the end
        // Decoder promises that in the case of endOfInput == true:
        // "...any remaining undecoded input will be treated as being
        // malformed"
        assert !(endOfInput && leftovers.hasRemaining()) : endOfInput + ", " + leftovers;
        if (endOfInput) {
            r = decoder.flush(out);
            decoder.reset();
            if (r.isOverflow()) {
                // FIXME: for now I know flush() does nothing. But the
                // implementation of UTF8 decoder might change. And if now
                // flush() is a no-op, it is not guaranteed to remain so in
                // the future
                throw new InternalError("Not yet implemented");
            }
        }
        return out.flip();
    }
}
