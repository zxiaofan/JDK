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

import jdk.internal.net.http.common.Utils;

import java.nio.ByteBuffer;
import java.util.List;

public class DataFrame extends Http2Frame {

    public static final int TYPE = 0x0;

    // Flags
    public static final int END_STREAM = 0x1;
    public static final int PADDED = 0x8;

    private int padLength;
    private final List<ByteBuffer> data;
    private final int dataLength;

    public DataFrame(int streamid, int flags, ByteBuffer data) {
        this(streamid, flags, List.of(data));
    }

    public DataFrame(int streamid, int flags, List<ByteBuffer> data) {
        super(streamid, flags);
        this.data = data;
        this.dataLength = Utils.remaining(data, Integer.MAX_VALUE);
    }

    public DataFrame(int streamid, int flags, List<ByteBuffer> data, int padLength) {
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
        return switch (flag) {
            case END_STREAM ->  "END_STREAM";
            case PADDED     ->  "PADDED";

            default -> super.flagAsString(flag);
        };
    }

    public List<ByteBuffer> getData() {
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
