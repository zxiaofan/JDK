/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.dom;

import com.sun.webkit.Disposer;
import com.sun.webkit.DisposerRecord;
import org.w3c.dom.css.Counter;

public class CounterImpl implements Counter {
    private static class SelfDisposer implements DisposerRecord {
        private final long peer;
        SelfDisposer(final long peer) {
            this.peer = peer;
        }
        public void dispose() {
            CounterImpl.dispose(peer);
        }
    }

    CounterImpl(long peer) {
        this.peer = peer;
        Disposer.addRecord(this, new SelfDisposer(peer));
    }

    static Counter create(long peer) {
        if (peer == 0L) return null;
        return new CounterImpl(peer);
    }

    private final long peer;

    long getPeer() {
        return peer;
    }

    @Override public boolean equals(Object that) {
        return (that instanceof CounterImpl) && (peer == ((CounterImpl)that).peer);
    }

    @Override public int hashCode() {
        long p = peer;
        return (int) (p ^ (p >> 17));
    }

    static long getPeer(Counter arg) {
        return (arg == null) ? 0L : ((CounterImpl)arg).getPeer();
    }

    native private static void dispose(long peer);

    static Counter getImpl(long peer) {
        return (Counter)create(peer);
    }


// Attributes
    public String getIdentifier() {
        return getIdentifierImpl(getPeer());
    }
    native static String getIdentifierImpl(long peer);

    public String getListStyle() {
        return getListStyleImpl(getPeer());
    }
    native static String getListStyleImpl(long peer);

    public String getSeparator() {
        return getSeparatorImpl(getPeer());
    }
    native static String getSeparatorImpl(long peer);

}

