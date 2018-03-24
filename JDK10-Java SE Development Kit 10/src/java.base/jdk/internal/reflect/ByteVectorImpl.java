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

class ByteVectorImpl implements ByteVector {
    private byte[] data;
    private int pos;

    public ByteVectorImpl() {
        this(100);
    }

    public ByteVectorImpl(int sz) {
        data = new byte[sz];
        pos = -1;
    }

    public int getLength() {
        return pos + 1;
    }

    public byte get(int index) {
        if (index >= data.length) {
            resize(index);
            pos = index;
        }
        return data[index];
    }

    public void put(int index, byte value) {
        if (index >= data.length) {
            resize(index);
            pos = index;
        }
        data[index] = value;
    }

    public void add(byte value) {
        if (++pos >= data.length) {
            resize(pos);
        }
        data[pos] = value;
    }

    public void trim() {
        if (pos != data.length - 1) {
            byte[] newData = new byte[pos + 1];
            System.arraycopy(data, 0, newData, 0, pos + 1);
            data = newData;
        }
    }

    public byte[] getData() {
        return data;
    }

    private void resize(int minSize) {
        if (minSize <= 2 * data.length) {
            minSize = 2 * data.length;
        }
        byte[] newData = new byte[minSize];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
