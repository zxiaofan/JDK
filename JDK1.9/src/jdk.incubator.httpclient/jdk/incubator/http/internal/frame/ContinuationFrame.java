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

public class ContinuationFrame extends HeaderFrame {

    public static final int TYPE = 0x9;

    public ContinuationFrame(int streamid, int flags, ByteBufferReference[] headerBlocks) {
        super(streamid, flags, headerBlocks);
    }

    public ContinuationFrame(int streamid, ByteBufferReference headersBlock) {
        this(streamid, 0, new ByteBufferReference[]{headersBlock});
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return headerLength;
    }

}
