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
import java.util.Collections;
import java.util.List;

/**
 * Array class.
 *
 * @author
 *      Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
final class JArrayClass extends JClass {

    // array component type
    private final JType componentType;


    JArrayClass( JCodeModel owner, JType component ) {
        super(owner);
        this.componentType = component;
    }


    public String name() {
        return componentType.name()+"[]";
    }

    public String fullName() {
        return componentType.fullName()+"[]";
    }

    public String binaryName() {
        return componentType.binaryName()+"[]";
    }

    public void generate(JFormatter f) {
        f.g(componentType).p("[]");
    }

    public JPackage _package() {
        return owner().rootPackage();
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

    public JType elementType() {
        return componentType;
    }

    public boolean isArray() {
        return true;
    }


    //
    // Equality is based on value
    //

    public boolean equals(Object obj) {
        if(!(obj instanceof JArrayClass))   return false;

        if( componentType.equals( ((JArrayClass)obj).componentType ) )
            return true;

        return false;
    }

    public int hashCode() {
        return componentType.hashCode();
    }

    protected JClass substituteParams(JTypeVar[] variables, List<JClass> bindings) {
        if( componentType.isPrimitive() )
            return this;

        JClass c = ((JClass)componentType).substituteParams(variables,bindings);
        if(c==componentType)
            return this;

        return new JArrayClass(owner(),c);
    }

}
