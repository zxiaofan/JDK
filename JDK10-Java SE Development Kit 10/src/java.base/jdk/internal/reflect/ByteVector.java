/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.reflect;

/** A growable array of bytes. */

interface ByteVector {
    public int  getLength();
    public byte get(int index);
    public void put(int index, byte value);
    public void add(byte value);
    public void trim();
    public byte[] getData();
}
