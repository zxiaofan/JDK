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

public class PriorityFrame extends Http2Frame {

    private final int streamDependency;
    private final int weight;
    private final boolean exclusive;

    public static final int TYPE = 0x2;

    public PriorityFrame(int streamId, int streamDependency, boolean exclusive, int weight) {
        super(streamId, 0);
        this.streamDependency = streamDependency;
        this.exclusive = exclusive;
        this.weight = weight;
    }

    @Override
    public int type() {
        return TYPE;
    }

    @Override
    int length() {
        return 5;
    }

    public int streamDependency() {
        return streamDependency;
    }

    public int weight() {
        return weight;
    }

    public boolean exclusive() {
        return exclusive;
    }

}
