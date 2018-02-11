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

public class DataFrame extends Http2Frame {

    public static final int TYPE = 0x0;

    // Flags
    public static final int END_STREAM = 0x1;
    public static final int PADDED = 0x8;

    private int padLength;
    private final ByteBufferReference[] data;
    private final int dataLength;

    public DataFrame(int streamid, int flags, ByteBufferReference data) {
        this(streamid, flags, new ByteBufferReference[]{data});
    }

    public DataFrame(int streamid, int flags, ByteBufferReference[] data) {
        super(streamid, flags);
        this.data = data;
        this.dataLength = Utils.remaining(data);
    }

    public DataFrame(int streamid, int flags, ByteBufferReference[] data, int padLength) {
        this(streamid, flags, data);
        if (padLength > 0) {
            setPadLength(padLength);
        }
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return dataLength + (((flags & PADDED) != 0) ? (padLength + 1) : 0);
    }

    @Override
    public String flagAsString(int flag) {
        switch (flag) {
        case END_STREAM:
            return "END_STREAM";
        case PADDED:
            return "PADDED";
        }
        return super.flagAsString(flag);
    }

    public ByteBufferReference[] getData() {
        return data;
    }

    public int getDataLength() {
        return dataLength;
    }

    int getPadLength() {
        return padLength;
    }

    public void setPadLength(int padLength) {
        this.padLength = padLength;
        flags |= PADDED;
    }

    public int payloadLength() {
        // RFC 7540 6.1:
        // The entire DATA frame payload is included in flow control,
        // including the Pad Length and Padding fields if present
        if ((flags & PADDED) != 0) {
            return dataLength + (1 + padLength);
        } else {
            return dataLength;
        }
    }


}
