/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.tools.classfile.ConstantPool.CONSTANT_Class_info;

import java.io.IOException;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class NestHost_attribute extends Attribute {
    NestHost_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
        top_index = cr.readUnsignedShort();
    }

    public NestHost_attribute(ConstantPool constant_pool, int signature_index)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.Signature), signature_index);
    }

    public NestHost_attribute(int name_index, int top_index) {
        super(name_index, 2);
        this.top_index = top_index;
    }

    public CONSTANT_Class_info getNestTop(ConstantPool constant_pool) throws ConstantPoolException {
        return constant_pool.getClassInfo(top_index);
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitNestHost(this, data);
    }

    public final int top_index;
}
