/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.util.stream.IntStream;

import com.sun.tools.classfile.ConstantPool.CONSTANT_Class_info;

public class PermittedSubclasses_attribute extends Attribute {

    public int[] subtypes;

    PermittedSubclasses_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
        int number_of_classes = cr.readUnsignedShort();
        subtypes = new int[number_of_classes];
        for (int i = 0; i < number_of_classes; i++)
            subtypes[i] = cr.readUnsignedShort();
    }

    public PermittedSubclasses_attribute(int name_index, int[] subtypes) {
        super(name_index, 2);
        this.subtypes = subtypes;
    }

    public CONSTANT_Class_info[] getSubtypes(ConstantPool constant_pool) throws ConstantPoolException {
        return IntStream.of(subtypes)
                .mapToObj(i -> {
                    try {
                        return constant_pool.getClassInfo(i);
                    } catch (ConstantPoolException ex) {
                        throw new AssertionError(ex);
                    }
                }).toArray(CONSTANT_Class_info[]::new);
    }

    @Override
    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitPermittedSubclasses(this, data);
    }
}
