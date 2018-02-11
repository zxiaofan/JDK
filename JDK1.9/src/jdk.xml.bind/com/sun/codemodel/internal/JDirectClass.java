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

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

/**
 * A special {@link JClass} that represents an unknown class (except its name.)
 *
 * @author Kohsuke Kawaguchi
 * @see JCodeModel#directClass(String)
 */
final class JDirectClass extends JClass {

    private final String fullName;

    public JDirectClass(JCodeModel _owner,String fullName) {
        super(_owner);
        this.fullName = fullName;
    }

    public String name() {
        int i = fullName.lastIndexOf('.');
        if(i>=0)    return fullName.substring(i+1);
        return fullName;
    }

    public String fullName() {
        return fullName;
    }

    public JPackage _package() {
        int i = fullName.lastIndexOf('.');
        if(i>=0)    return owner()._package(fullName.substring(0,i));
        else        return owner().rootPackage();
    }

    public JClass _extends() {
        return owner().ref(Object.class);
    }

    public Iterator<JClass> _implements() {
        return Collections.<JClass>emptyList().iterator();
    }

    public boolean isInterface() {
        return false;
    }

    public boolean isAbstract() {
        return false;
    }

    protected JClass substituteParams(JTypeVar[] variables, List<JClass> bindings) {
        return this;
    }
}
