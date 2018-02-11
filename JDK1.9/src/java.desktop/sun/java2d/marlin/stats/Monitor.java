/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.marlin.stats;

/**
 * Generic monitor ie gathers time statistics as nanos.
 */
public final class Monitor extends StatLong {

    private static final long INVALID = -1L;

    private long start = INVALID;

    public Monitor(final String name) {
        super(name);
    }

    public void start() {
        start = System.nanoTime();
    }

    public void stop() {
        final long elapsed = System.nanoTime() - start;
        if (start != INVALID && elapsed > 0l) {
            add(elapsed);
        }
        start = INVALID;
    }
}

