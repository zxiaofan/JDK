/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeprscan.scan;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import com.sun.tools.classfile.ClassFile;
import com.sun.tools.classfile.ConstantPool;

import static com.sun.tools.classfile.ConstantPool.CPInfo;

/**
 * A container for selected constant pool entries. There are currently
 * lists that contain the following types of CP entries:
 *
 *  - CONSTANT_Class_info
 *  - CONSTANT_Fieldref_info
 *  - CONSTANT_Methodref_info
 *  - CONSTANT_InterfaceMethodref_info
 */
class CPEntries {
    final List<ConstantPool.CONSTANT_Class_info> classes = new ArrayList<>();
    final List<ConstantPool.CONSTANT_Fieldref_info> fieldRefs = new ArrayList<>();
    final List<ConstantPool.CONSTANT_Methodref_info> methodRefs = new ArrayList<>();
    final List<ConstantPool.CONSTANT_InterfaceMethodref_info> intfMethodRefs = new ArrayList<>();

    public static CPEntries loadFrom(ClassFile cf) {
        CPEntries entries = new CPEntries();
        for (CPInfo cpi : cf.constant_pool.entries()) {
            cpi.accept(new CPSelector(), entries);
        }
        return entries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb, Locale.getDefault());
        f.format("Classes:%n");
        f.format("%s%n", classes);
        f.format("FieldRefs:%n");
        f.format("%s%n", fieldRefs);
        f.format("MethodRefs:%n");
        f.format("%s%n", methodRefs);
        f.format("InterfaceMethodRefs:%n");
        f.format("%s%n", intfMethodRefs);
        f.flush();
        return sb.toString();
    }
}
