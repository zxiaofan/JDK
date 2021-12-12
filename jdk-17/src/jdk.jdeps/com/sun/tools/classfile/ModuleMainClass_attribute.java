/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 * See JVMS, section 4.8.15.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ModuleMainClass_attribute extends Attribute {
    ModuleMainClass_attribute(ClassReader cr, int name_index, int length) throws IOException {
        super(name_index, length);
        main_class_index = cr.readUnsignedShort();
    }

    public ModuleMainClass_attribute(ConstantPool constant_pool, int mainClass_index)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.ModuleMainClass), mainClass_index);
    }

    public ModuleMainClass_attribute(int name_index, int mainClass_index) {
        super(name_index, 2);
        this.main_class_index = mainClass_index;
    }

    public String getMainClassName(ConstantPool constant_pool) throws ConstantPoolException {
        return constant_pool.getClassInfo(main_class_index).getName();
    }

    @Override
    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitModuleMainClass(this, data);
    }

    public final int main_class_index;
}
