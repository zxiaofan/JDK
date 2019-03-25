/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.xr;

/**
 * UInt32 "emulation", mimics the behaviour of xcb's request counter.
 * In order to be compatible with xcb we have to wrap exactly when xcb would do.
 * @author Clemens Eisserer
 */

public class XcbRequestCounter {
    private static final long MAX_UINT = 4294967295L;

    long value;

    public XcbRequestCounter(long value) {
        this.value = value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void add(long v) {
        value += v;

        /*Handle 32-bit unsigned int overflow*/
        if (value > MAX_UINT) {
            value = 0; //-= MAX_UINT; //Shouldn't that be zero?!?!
        }
    }
}
