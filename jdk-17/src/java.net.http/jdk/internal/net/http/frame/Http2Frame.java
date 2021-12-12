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

/**
 * When sending a frame, the length field must be set in sub-class
 * by calling computeLength()
 */
public abstract class Http2Frame {

    public static final int FRAME_HEADER_SIZE = 9;

    protected int streamid;
    protected int flags;

    public Http2Frame(int streamid, int flags) {
        this.streamid = streamid;
        this.flags = flags;
    }

    public int streamid() {
        return streamid;
    }

    public void setFlag(int flag) {
        flags |= flag;
    }

    public int getFlags() {
        return flags;
    }

    public boolean getFlag(int flag) {
        return (flags & flag) != 0;
    }

//    public void clearFlag(int flag) {
//        flags &= 0xffffffff ^ flag;
//    }

    public void streamid(int streamid) {
        this.streamid = streamid;
    }


    private String typeAsString() {
        return asString(type());
    }

    public int type() {
        return -1; // Unknown type
    }

    int length() {
        return -1; // Unknown length
    }


    public static String asString(int type) {
        return switch (type) {
            case DataFrame.TYPE         -> "DATA";
            case HeadersFrame.TYPE      -> "HEADERS";
            case ContinuationFrame.TYPE -> "CONTINUATION";
            case ResetFrame.TYPE        -> "RESET";
            case PriorityFrame.TYPE     -> "PRIORITY";
            case SettingsFrame.TYPE     -> "SETTINGS";
            case GoAwayFrame.TYPE       -> "GOAWAY";
            case PingFrame.TYPE         -> "PING";
            case PushPromiseFrame.TYPE  -> "PUSH_PROMISE";
            case WindowUpdateFrame.TYPE -> "WINDOW_UPDATE";

            default -> "UNKNOWN";
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(typeAsString())
                .append(": length=")
                .append(Integer.toString(length()))
                .append(", streamid=")
                .append(streamid)
                .append(", flags=");

        int f = flags;
        int i = 0;
        if (f == 0) {
            sb.append("0 ");
        } else {
            while (f != 0) {
                if ((f & 1) == 1) {
                    sb.append(flagAsString(1 << i))
                      .append(' ');
                }
                f = f >> 1;
                i++;
            }
        }
        return sb.toString();
    }

    // Override
    public String flagAsString(int f) {
        return "unknown";
    }

}
