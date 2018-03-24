/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.nio.ByteBuffer;

/**
 * @author Kohsuke Kawaguchi
 */
final class Chunk {
    volatile Chunk next;
    volatile Data data;

    public Chunk(Data data) {
        this.data = data;
    }

    /**
     * Creates a new chunk and adds to linked list.
     *
     * @param dataHead of the linked list
     * @param buf MIME part partial data
     * @return created chunk
     */
    public Chunk createNext(DataHead dataHead, ByteBuffer buf) {
        return next = new Chunk(data.createNext(dataHead, buf));
    }
}
