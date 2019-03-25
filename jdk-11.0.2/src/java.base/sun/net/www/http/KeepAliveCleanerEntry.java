/*
 * Copyright (c) 1996, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.http;

import java.io.*;

class KeepAliveCleanerEntry
{
    KeepAliveStream kas;
    HttpClient hc;

    public KeepAliveCleanerEntry(KeepAliveStream kas, HttpClient hc) {
        this.kas = kas;
        this.hc = hc;
    }

    protected KeepAliveStream getKeepAliveStream() {
        return kas;
    }

    protected HttpClient getHttpClient() {
        return hc;
    }

    protected void setQueuedForCleanup() {
        kas.queuedForCleanup = true;
    }

    protected boolean getQueuedForCleanup() {
        return kas.queuedForCleanup;
    }

}
