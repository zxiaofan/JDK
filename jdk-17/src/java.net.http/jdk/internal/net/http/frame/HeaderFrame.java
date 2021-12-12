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

/**
 * Either a HeadersFrame or a ContinuationFrame
 */
public abstract class HeaderFrame extends Http2Frame {

    final int headerLength;
    final List<ByteBuffer> headerBlocks;

    public static final int END_STREAM = 0x1;
    public static final int END_HEADERS = 0x4;

    public HeaderFrame(int streamid, int flags, List<ByteBuffer> headerBlocks) {
        super(streamid, flags);
        this.headerBlocks = headerBlocks;
        this.headerLength = Utils.remaining(headerBlocks, Integer.MAX_VALUE);
    }

    @Override
    public String flagAsString(int flag) {
        return switch (flag) {
            case END_HEADERS -> "END_HEADERS";
            case END_STREAM  -> "END_STREAM";

            default -> super.flagAsString(flag);
        };
    }


    public List<ByteBuffer> getHeaderBlock() {
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
