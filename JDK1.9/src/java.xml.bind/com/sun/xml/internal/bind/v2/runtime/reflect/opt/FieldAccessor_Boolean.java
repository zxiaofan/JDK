/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.reflect.opt;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 * Template {@link Accessor} for boolean fields.
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 * <p>
 *     All the FieldAccessors are generated from <code>FieldAccessor_B y t e</code>
 * </p>
 * @author Kohsuke Kawaguchi
 */
public class FieldAccessor_Boolean extends Accessor {
    public FieldAccessor_Boolean() {
        super(Boolean.class);
    }

    public Object get(Object bean) {
        return ((Bean)bean).f_boolean;
    }

    public void set(Object bean, Object value) {
        ((Bean)bean).f_boolean = value==null ? Const.default_value_boolean : (Boolean)value;
    }
}
