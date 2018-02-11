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
 * Template {@link Accessor} for int fields.
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 * <p>
 *     All the FieldAccessors are generated from <code>FieldAccessor_B y t e</code>
 * </p>
 * @author Kohsuke Kawaguchi
 */
public class FieldAccessor_Integer extends Accessor {
    public FieldAccessor_Integer() {
        super(Integer.class);
    }

    public Object get(Object bean) {
        return ((Bean)bean).f_int;
    }

    public void set(Object bean, Object value) {
        ((Bean)bean).f_int = value==null ? Const.default_value_int : (Integer)value;
    }
}
