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
 * See JVMS, section 4.8.10.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class SourceFile_attribute extends Attribute {
    SourceFile_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
        sourcefile_index = cr.readUnsignedShort();
    }

    public SourceFile_attribute(ConstantPool constant_pool, int sourcefile_index)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.SourceFile), sourcefile_index);
    }

    public SourceFile_attribute(int name_index, int sourcefile_index) {
        super(name_index, 2);
        this.sourcefile_index = sourcefile_index;
    }

    public String getSourceFile(ConstantPool constant_pool) throws ConstantPoolException {
        return constant_pool.getUTF8Value(sourcefile_index);
    }

    public <R, P> R accept(Visitor<R, P> visitor, P p) {
        return visitor.visitSourceFile(this, p);
    }

    public final int sourcefile_index;
}
