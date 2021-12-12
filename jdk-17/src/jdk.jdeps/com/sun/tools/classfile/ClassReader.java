/*
 * Copyright (c) 2007, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.classfile;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ClassReader {
    ClassReader(ClassFile classFile, InputStream in, Attribute.Factory attributeFactory) throws IOException {
        this.classFile = Objects.requireNonNull(classFile);
        this.attributeFactory = Objects.requireNonNull(attributeFactory);
        this.in = new DataInputStream(new BufferedInputStream(in));
    }

    ClassFile getClassFile() {
        return classFile;
    }

    ConstantPool getConstantPool() {
        return classFile.constant_pool;
    }

    public Attribute readAttribute() throws IOException {
        int name_index = readUnsignedShort();
        int length = readInt();
        if (length < 0) { // we have an overflow as max_value(u4) > max_value(int)
            String attrName;
            try {
                attrName = getConstantPool().getUTF8Value(name_index);
            } catch (ConstantPool.InvalidIndex | ConstantPool.UnexpectedEntry e) {
                attrName = "";
            }
            throw new FatalError(String.format("attribute %s too big to handle", attrName));
        }
        byte[] data = new byte[length];
        readFully(data);

        DataInputStream prev = in;
        in = new DataInputStream(new ByteArrayInputStream(data));
        try {
            return attributeFactory.createAttribute(this, name_index, data);
        } finally {
            in = prev;
        }
    }

    public void readFully(byte[] b) throws IOException {
        in.readFully(b);
    }

    public int readUnsignedByte() throws IOException {
        return in.readUnsignedByte();
    }

    public int readUnsignedShort() throws IOException {
        return in.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return in.readInt();
    }

    public long readLong() throws IOException {
        return in.readLong();
    }

    public float readFloat() throws IOException {
        return in.readFloat();
    }

    public double readDouble() throws IOException {
        return in.readDouble();
    }

    public String readUTF() throws IOException {
        return in.readUTF();
    }

    private DataInputStream in;
    private ClassFile classFile;
    private Attribute.Factory attributeFactory;
}
