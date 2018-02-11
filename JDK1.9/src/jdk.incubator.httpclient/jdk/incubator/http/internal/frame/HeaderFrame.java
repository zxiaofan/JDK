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

import java.nio.ByteBuffer;

/**
 * Either a HeadersFrame or a ContinuationFrame
 */
public abstract class HeaderFrame extends Http2Frame {

    final int headerLength;
    final ByteBufferReference[] headerBlocks;

    public static final int END_STREAM = 0x1;
    public static final int END_HEADERS = 0x4;

    public HeaderFrame(int streamid, int flags, ByteBufferReference headerBlock) {
        this(streamid, flags, new ByteBufferReference[]{headerBlock});
    }

    public HeaderFrame(int streamid, int flags, ByteBufferReference[] headerBlocks) {
        super(streamid, flags);
        this.headerBlocks = headerBlocks;
        this.headerLength = Utils.remaining(headerBlocks);
    }

    @Override
    public String flagAsString(int flag) {
        switch (flag) {
            case END_HEADERS:
                return "END_HEADERS";
            case END_STREAM:
                return "END_STREAM";
        }
        return super.flagAsString(flag);
    }


    public ByteBufferReference[] getHeaderBlock() {
        return headerBlocks;
    }

    int getHeaderLength() {
        return headerLength;
    }

    /**
     * Returns true if this block is the final block of headers.
     */
    public boolean endHeaders() {
        return getFlag(END_HEADERS);
    }
}
