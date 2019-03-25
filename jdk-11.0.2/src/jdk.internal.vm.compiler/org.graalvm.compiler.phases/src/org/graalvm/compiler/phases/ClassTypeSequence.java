/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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
 */



package org.graalvm.compiler.phases;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.ResolvedJavaType;

final class ClassTypeSequence implements JavaType, CharSequence {
    private final Class<?> clazz;

    ClassTypeSequence(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getName() {
        return "L" + clazz.getName().replace('.', '/') + ";";
    }

    @Override
    public String toJavaName() {
        return toJavaName(true);
    }

    @Override
    public String toJavaName(boolean qualified) {
        if (qualified) {
            return clazz.getName();
        } else {
            int lastDot = clazz.getName().lastIndexOf('.');
            return clazz.getName().substring(lastDot + 1);
        }
    }

    @Override
    public JavaType getComponentType() {
        return null;
    }

    @Override
    public JavaType getArrayClass() {
        return null;
    }

    @Override
    public JavaKind getJavaKind() {
        return JavaKind.Object;
    }

    @Override
    public ResolvedJavaType resolve(ResolvedJavaType accessingClass) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int length() {
        return clazz.getName().length();
    }

    @Override
    public char charAt(int index) {
        return clazz.getName().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return clazz.getName().subSequence(start, end);
    }

    @Override
    public String toString() {
        return clazz.getName();
    }
}
