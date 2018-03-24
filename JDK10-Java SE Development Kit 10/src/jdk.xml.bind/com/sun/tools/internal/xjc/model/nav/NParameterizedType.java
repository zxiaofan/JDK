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

import com.sun.codemodel.internal.JClass;
import com.sun.tools.internal.xjc.outline.Aspect;
import com.sun.tools.internal.xjc.outline.Outline;

/**
 * Parameterized type.
 *
 * @author Kohsuke Kawaguchi
 */
final class NParameterizedType implements NClass {

    final NClass rawType;
    final NType[] args;

    NParameterizedType(NClass rawType, NType[] args) {
        this.rawType = rawType;
        this.args = args;
        assert args.length>0;
    }

    public JClass toType(Outline o, Aspect aspect) {
        JClass r = rawType.toType(o,aspect);

        for( NType arg : args )
            r = r.narrow(arg.toType(o,aspect).boxify());

        return r;
    }

    public boolean isAbstract() {
        return rawType.isAbstract();
    }

    public boolean isBoxedType() {
        return false;
    }


    public String fullName() {
        StringBuilder buf = new StringBuilder();
        buf.append(rawType.fullName());
        buf.append('<');
        for( int i=0; i<args.length; i++ ) {
            if(i!=0)
                buf.append(',');
            buf.append(args[i].fullName());
        }
        buf.append('>');
        return buf.toString();
    }
}
