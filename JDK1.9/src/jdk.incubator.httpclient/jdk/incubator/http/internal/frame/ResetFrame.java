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

public class ResetFrame extends ErrorFrame {

    public static final int TYPE = 0x3;

    // See ErrorFrame for error values

    public ResetFrame(int streamid, int errorCode) {
        super(streamid, 0, errorCode);
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return 4;
    }

}
