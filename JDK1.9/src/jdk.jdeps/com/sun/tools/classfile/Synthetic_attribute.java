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
 * See JVMS, section 4.8.8.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Synthetic_attribute extends Attribute {
    Synthetic_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
    }

    public Synthetic_attribute(ConstantPool constant_pool)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.Synthetic));
    }

    public Synthetic_attribute(int name_index) {
        super(name_index, 0);
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitSynthetic(this, data);
    }
}
