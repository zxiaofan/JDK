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

package com.sun.xml.internal.bind.v2.runtime.reflect.opt;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 * Template {@link Accessor} for reference type fields.
 *
 * @author Kohsuke Kawaguchi
 */
public class FieldAccessor_Ref extends Accessor {
    public FieldAccessor_Ref() {
        super(Ref.class);
    }

    public Object get(Object bean) {
        return ((Bean)bean).f_ref;
    }

    public void set(Object bean, Object value) {
        ((Bean)bean).f_ref = (Ref)value;
    }
}
