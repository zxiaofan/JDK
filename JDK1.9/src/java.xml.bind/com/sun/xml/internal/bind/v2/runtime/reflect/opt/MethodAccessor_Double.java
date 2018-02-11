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
 * Template {@link Accessor} for boolean getter/setter.
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 * <p>
 *     All the MethodAccessors are generated from <code>MethodAccessor_B y t e</code>
 * </p>
 * @author Kohsuke Kawaguchi
 */
public class MethodAccessor_Double extends Accessor {
    public MethodAccessor_Double() {
        super(Double.class);
    }

    public Object get(Object bean) {
        return ((Bean)bean).get_double();
    }

    public void set(Object bean, Object value) {
        ((Bean)bean).set_double( value==null ? Const.default_value_double : (Double)value );
    }
}
