/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class StackMap_attribute extends Attribute {
    StackMap_attribute(ClassReader cr, int name_index, int length)
            throws IOException, StackMapTable_attribute.InvalidStackMap {
        super(name_index, length);
        number_of_entries = cr.readUnsignedShort();
        entries = new stack_map_frame[number_of_entries];
        for (int i = 0; i < number_of_entries; i++)
            entries[i] = new stack_map_frame(cr);
    }

    public StackMap_attribute(ConstantPool constant_pool, stack_map_frame[] entries)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.StackMap), entries);
    }

    public StackMap_attribute(int name_index, stack_map_frame[] entries) {
        super(name_index, StackMapTable_attribute.length(entries));
        this.number_of_entries = entries.length;
        this.entries = entries;
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitStackMap(this, data);
    }

    public final int number_of_entries;
    public final stack_map_frame entries[];

    public static class stack_map_frame extends StackMapTable_attribute.full_frame {
        stack_map_frame(ClassReader cr)
                throws IOException, StackMapTable_attribute.InvalidStackMap {
            super(255, cr);
        }
    }
}
