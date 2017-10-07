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

package jdk.incubator.http.internal.frame;

import jdk.incubator.http.internal.common.ByteBufferReference;
import jdk.incubator.http.internal.common.Utils;

public class PushPromiseFrame extends HeaderFrame {

    private int padLength;
    private final int promisedStream;

    public static final int TYPE = 0x5;

    // Flags
    public static final int END_HEADERS = 0x4;
    public static final int PADDED = 0x8;

    public PushPromiseFrame(int streamid, int flags, int promisedStream, ByteBufferReference[] buffers, int padLength) {
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
        switch (flag) {
            case PADDED:
                return "PADDED";
            case END_HEADERS:
                return "END_HEADERS";
        }
        return super.flagAsString(flag);
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
