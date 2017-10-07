/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.model.nav;

import java.lang.reflect.Type;

import com.sun.codemodel.internal.JType;
import com.sun.tools.internal.xjc.outline.Aspect;
import com.sun.tools.internal.xjc.outline.Outline;

/**
 * @author Kohsuke Kawaguchi
 */
class EagerNType implements NType {
    /*package*/ final Type t;

    public EagerNType(Type type) {
        this.t = type;
        assert t!=null;
    }

    public JType toType(Outline o, Aspect aspect) {
        try {
            return o.getCodeModel().parseType(t.toString());
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EagerNType)) return false;

        final EagerNType eagerNType = (EagerNType) o;

        return t.equals(eagerNType.t);
    }

    public boolean isBoxedType() {
        return false;
    }

    public int hashCode() {
        return t.hashCode();
    }

    public String fullName() {
        return Utils.REFLECTION_NAVIGATOR.getTypeName(t);
    }
}
