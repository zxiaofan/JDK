/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.meta;

import java.nio.ByteBuffer;

/**
 * Represents a compile-time constant that can be converted to a byte array.
 */
public interface SerializableConstant extends Constant {

    /**
     * Return the size in bytes of the serialized representation of this constant.
     */
    int getSerializedSize();

    /**
     * Serialize the constant into the ByteBuffer. There must be at least
     * {@link #getSerializedSize()} bytes available capacity in the buffer.
     */
    void serialize(ByteBuffer buffer);
}
