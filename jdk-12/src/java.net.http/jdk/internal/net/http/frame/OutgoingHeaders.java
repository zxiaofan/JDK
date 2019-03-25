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

import java.net.http.HttpHeaders;

/**
 * Contains all parameters for outgoing headers. Is converted to
 * HeadersFrame and ContinuationFrames by Http2Connection.
 */
public class OutgoingHeaders<T> extends Http2Frame {

    int streamDependency;
    int weight;
    boolean exclusive;
    T attachment;

    public static final int PRIORITY = 0x20;

    HttpHeaders user, system;

    public OutgoingHeaders(HttpHeaders hdrs1, HttpHeaders hdrs2, T attachment) {
        super(0, 0);
        this.user = hdrs2;
        this.system = hdrs1;
        this.attachment = attachment;
    }

    public void setPriority(int streamDependency, boolean exclusive, int weight) {
        this.streamDependency = streamDependency;
        this.exclusive = exclusive;
        this.weight = weight;
        this.flags |= PRIORITY;
    }

    public int getStreamDependency() {
        return streamDependency;
    }

    public int getWeight() {
        return weight;
    }

    public boolean getExclusive() {
        return exclusive;
    }

    public T getAttachment() {
        return attachment;
    }

    public HttpHeaders getUserHeaders() {
        return user;
    }

    public HttpHeaders getSystemHeaders() {
        return system;
    }

}
