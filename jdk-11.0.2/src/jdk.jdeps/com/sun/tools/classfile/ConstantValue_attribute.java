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
 * See JVMS, section 4.8.2.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ConstantValue_attribute extends Attribute {
    ConstantValue_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
        constantvalue_index = cr.readUnsignedShort();
    }

    public ConstantValue_attribute(ConstantPool constant_pool, int constantvalue_index)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.ConstantValue), constantvalue_index);
    }

    public ConstantValue_attribute(int name_index, int constantvalue_index) {
        super(name_index, 2);
        this.constantvalue_index = constantvalue_index;
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitConstantValue(this, data);
    }

    public final int constantvalue_index;
}
