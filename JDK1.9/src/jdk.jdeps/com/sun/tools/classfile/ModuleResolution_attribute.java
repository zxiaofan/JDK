/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
public class ModuleResolution_attribute extends Attribute {
    public static final int DO_NOT_RESOLVE_BY_DEFAULT   = 0x0001;
    public static final int WARN_DEPRECATED             = 0x0002;
    public static final int WARN_DEPRECATED_FOR_REMOVAL = 0x0004;
    public static final int WARN_INCUBATING             = 0x0008;

    ModuleResolution_attribute(ClassReader cr, int name_index, int length)
            throws IOException {
        super(name_index, length);
        resolution_flags = cr.readUnsignedShort();
    }

    public ModuleResolution_attribute(ConstantPool constant_pool,
                              int resolution_flags)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.ModuleResolution),
             resolution_flags);
    }

    public ModuleResolution_attribute(int name_index,
                              int resolution_flags) {
        super(name_index, 2);
        this.resolution_flags = resolution_flags;
    }

    @Override
    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitModuleResolution(this, data);
    }

    public final int resolution_flags;
}
