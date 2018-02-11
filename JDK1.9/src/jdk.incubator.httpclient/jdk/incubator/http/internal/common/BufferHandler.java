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

package jdk.incubator.http.internal.common;

import java.nio.ByteBuffer;

/**
 * Implemented by buffer pools.
 */
public interface BufferHandler {

    ByteBuffer getBuffer();

    void returnBuffer(ByteBuffer buffer);
}
