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

public class PingFrame extends Http2Frame {


    private final byte[] data;

    public static final int TYPE = 0x6;

    // Flags
    public static final int ACK = 0x1;

    public PingFrame(int flags, byte[] data) {
        super(0, flags);
        assert data.length == 8;
        this.data = data.clone();
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return 8;
    }

    @Override
    public String flagAsString(int flag) {
        return switch (flag) {
            case ACK -> "ACK";
            default -> super.flagAsString(flag);
        };
    }

    public byte[] getData() {
        return data.clone();
    }

}
