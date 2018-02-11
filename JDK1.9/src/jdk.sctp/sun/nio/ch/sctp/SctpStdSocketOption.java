/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.nio.ch.sctp;

import com.sun.nio.sctp.SctpSocketOption;
import java.lang.annotation.Native;

public class SctpStdSocketOption<T>
    implements SctpSocketOption<T>
{
    /* for native mapping of int options */
    @Native public static final int SCTP_DISABLE_FRAGMENTS = 1;
    @Native public static final int SCTP_EXPLICIT_COMPLETE = 2;
    @Native public static final int SCTP_FRAGMENT_INTERLEAVE = 3;
    @Native public static final int SCTP_NODELAY = 4;
    @Native public static final int SO_SNDBUF = 5;
    @Native public static final int SO_RCVBUF = 6;
    @Native public static final int SO_LINGER = 7;

    private final String name;
    private final Class<T> type;

    /* for native mapping of int options */
    private int constValue;

    public SctpStdSocketOption(String name, Class<T> type) {
        this.name = name;
        this.type = type;
    }

    public SctpStdSocketOption(String name, Class<T> type, int constValue) {
        this.name = name;
        this.type = type;
        this.constValue = constValue;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Class<T> type() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    int constValue() {
        return constValue;
    }
}
