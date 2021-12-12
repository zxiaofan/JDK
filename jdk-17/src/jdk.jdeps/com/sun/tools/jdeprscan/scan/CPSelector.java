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

import com.sun.tools.classfile.ConstantPool;
import com.sun.tools.classfile.ConstantPool.CONSTANT_Dynamic_info;

/**
 * A visitor that selects constant pool entries by type and adds
 * them to the given CPEntries object.
 */
class CPSelector implements ConstantPool.Visitor<Void,CPEntries> {
    @Override
    public Void visitClass(ConstantPool.CONSTANT_Class_info info, CPEntries p) {
        p.classes.add(info);
        return null;
    }

    @Override
    public Void visitDouble(ConstantPool.CONSTANT_Double_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitFieldref(ConstantPool.CONSTANT_Fieldref_info info, CPEntries p) {
        p.fieldRefs.add(info);
        return null;
    }

    @Override
    public Void visitFloat(ConstantPool.CONSTANT_Float_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitInteger(ConstantPool.CONSTANT_Integer_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitInterfaceMethodref(ConstantPool.CONSTANT_InterfaceMethodref_info info, CPEntries p) {
        p.intfMethodRefs.add(info);
        return null;
    }

    @Override
    public Void visitInvokeDynamic(ConstantPool.CONSTANT_InvokeDynamic_info info, CPEntries p) {
        return null;
    }

    public Void visitDynamicConstant(CONSTANT_Dynamic_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitLong(ConstantPool.CONSTANT_Long_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitMethodref(ConstantPool.CONSTANT_Methodref_info info, CPEntries p) {
        p.methodRefs.add(info);
        return null;
    }

    @Override
    public Void visitMethodHandle(ConstantPool.CONSTANT_MethodHandle_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitMethodType(ConstantPool.CONSTANT_MethodType_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitModule(ConstantPool.CONSTANT_Module_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitNameAndType(ConstantPool.CONSTANT_NameAndType_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitPackage(ConstantPool.CONSTANT_Package_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitString(ConstantPool.CONSTANT_String_info info, CPEntries p) {
        return null;
    }

    @Override
    public Void visitUtf8(ConstantPool.CONSTANT_Utf8_info info, CPEntries p) {
        return null;
    }
}
