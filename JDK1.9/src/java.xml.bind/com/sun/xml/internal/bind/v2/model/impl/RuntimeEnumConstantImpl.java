/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author Kohsuke Kawaguchi
 */
final class RuntimeEnumConstantImpl extends EnumConstantImpl<Type,Class,Field,Method> {
    public RuntimeEnumConstantImpl(
        RuntimeEnumLeafInfoImpl owner, String name, String lexical,
        EnumConstantImpl<Type,Class,Field,Method> next) {
        super(owner, name, lexical, next);
    }
}
