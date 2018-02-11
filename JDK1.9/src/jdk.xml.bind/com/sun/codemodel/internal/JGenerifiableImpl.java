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

package com.sun.codemodel.internal;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link JGenerifiable}.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
abstract class JGenerifiableImpl implements JGenerifiable, JDeclaration {

    /** Lazily created list of {@link JTypeVar}s. */
    private List<JTypeVar> typeVariables = null;

    protected abstract JCodeModel owner();

    public void declare( JFormatter f ) {
        if(typeVariables!=null) {
            f.p('<');
            for (int i = 0; i < typeVariables.size(); i++) {
                if(i!=0)    f.p(',');
                f.d(typeVariables.get(i));
            }
            f.p('>');
        }
    }


    public JTypeVar generify(String name) {
        JTypeVar v = new JTypeVar(owner(),name);
        if(typeVariables==null)
            typeVariables = new ArrayList<JTypeVar>(3);
        typeVariables.add(v);
        return v;
    }

    public JTypeVar generify(String name, Class<?> bound) {
        return generify(name,owner().ref(bound));
    }

    public JTypeVar generify(String name, JClass bound) {
        return generify(name).bound(bound);
    }

    public JTypeVar[] typeParams() {
        if(typeVariables==null)
            return JTypeVar.EMPTY_ARRAY;
        else
            return typeVariables.toArray(new JTypeVar[typeVariables.size()]);
    }

}
