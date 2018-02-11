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

public class GoAwayFrame extends ErrorFrame {

    private final int lastStream;
    private final byte[] debugData;

    public static final int TYPE = 0x7;


    public GoAwayFrame(int lastStream, int errorCode) {
        this(lastStream, errorCode, new byte[0]);
    }

    public GoAwayFrame(int lastStream, int errorCode, byte[] debugData) {
        super(0, 0, errorCode);
        this.lastStream = lastStream;
        this.debugData = debugData;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return 8 + debugData.length;
    }

    @Override
    public String toString() {
        return super.toString() + " Debugdata: " + new String(debugData);
    }

    public int getLastStream() {
        return this.lastStream;
    }

    public byte[] getDebugData() {
        return debugData;
    }

}
