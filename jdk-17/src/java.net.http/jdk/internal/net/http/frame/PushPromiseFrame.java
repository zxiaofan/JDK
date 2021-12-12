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

package jdk.internal.net.http.frame;

import java.nio.ByteBuffer;
import java.util.List;

public class PushPromiseFrame extends HeaderFrame {

    private int padLength;
    private final int promisedStream;

    public static final int TYPE = 0x5;

    // Flags
    public static final int END_HEADERS = 0x4;
    public static final int PADDED = 0x8;

    public PushPromiseFrame(int streamid, int flags, int promisedStream, List<ByteBuffer> buffers, int padLength) {
        super(streamid, flags, buffers);
        this.promisedStream = promisedStream;
        if(padLength > 0 ) {
            setPadLength(padLength);
        }
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return headerLength + ((flags & PADDED) != 0 ? 5 : 4);
    }

    @Override
    public String toString() {
        return super.toString() + " promisedStreamid: " + promisedStream
                + " headerLength: " + headerLength;
    }

    @Override
    public String flagAsString(int flag) {
        return switch (flag) {
            case PADDED      -> "PADDED";
            case END_HEADERS -> "END_HEADERS";

            default -> super.flagAsString(flag);
        };
    }

    public void setPadLength(int padLength) {
        this.padLength = padLength;
        flags |= PADDED;
    }

    public int getPadLength() {
        return padLength;
    }

    public int getPromisedStream() {
        return promisedStream;
    }

    @Override
    public boolean endHeaders() {
        return getFlag(END_HEADERS);
    }

}
