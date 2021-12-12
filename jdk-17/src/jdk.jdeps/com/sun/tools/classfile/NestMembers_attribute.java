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
import java.util.stream.IntStream;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class NestMembers_attribute extends Attribute {
    NestMembers_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
        int len = cr.readUnsignedShort();
        members_indexes = new int[len];
        for (int i = 0 ; i < len ; i++) {
            members_indexes[i] = cr.readUnsignedShort();
        }
    }

    public NestMembers_attribute(int name_index, int[] members_indexes) {
        super(name_index, 2);
        this.members_indexes = members_indexes;
    }

    public CONSTANT_Class_info[] getChildren(ConstantPool constant_pool) throws ConstantPoolException {
        return IntStream.of(members_indexes)
                .mapToObj(i -> {
                    try {
                        return constant_pool.getClassInfo(i);
                    } catch (ConstantPoolException ex) {
                        throw new AssertionError(ex);
                    }
                }).toArray(CONSTANT_Class_info[]::new);
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitNestMembers(this, data);
    }

    public final int[] members_indexes;
}
