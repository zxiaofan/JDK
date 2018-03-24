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

import com.sun.tools.classfile.ConstantPool.CONSTANT_Package_info;

/**
 * See JVMS, section 4.8.15.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ModulePackages_attribute extends Attribute {
    ModulePackages_attribute(ClassReader cr, int name_index, int length)
            throws IOException {
        super(name_index, length);
        packages_count = cr.readUnsignedShort();
        packages_index = new int[packages_count];
        for (int i = 0; i < packages_count; i++)
            packages_index[i] = cr.readUnsignedShort();
    }

    public ModulePackages_attribute(ConstantPool constant_pool,
                              int[] packages_index)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.ModulePackages),
             packages_index);
    }

    public ModulePackages_attribute(int name_index,
                              int[] packages_index) {
        super(name_index, 2 + packages_index.length * 2);
        this.packages_count = packages_index.length;
        this.packages_index = packages_index;
    }

    public String getPackage(int index, ConstantPool constant_pool) throws ConstantPoolException {
        int package_index = packages_index[index];
        CONSTANT_Package_info info = constant_pool.getPackageInfo(package_index);
        return info.getName();
    }

    @Override
    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitModulePackages(this, data);
    }

    public final int packages_count;
    public final int[] packages_index;
}
