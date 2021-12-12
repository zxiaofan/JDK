/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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

package sun.reflect.generics.scope;

import java.lang.reflect.Constructor;


/**
 * This class represents the scope containing the type variables of
 * a constructor.
 */
public class ConstructorScope extends AbstractScope<Constructor<?>> {

    // constructor is private to enforce use of factory method
    private ConstructorScope(Constructor<?> c){
        super(c);
    }

    // utility method; computes enclosing class, from which we can
    // derive enclosing scope.
    private Class<?> getEnclosingClass(){
        return getRecvr().getDeclaringClass();
    }

    /**
     * Overrides the abstract method in the superclass.
     * @return the enclosing scope
     */
    protected Scope computeEnclosingScope() {
        // the enclosing scope of a (generic) constructor is the scope of the
        // class in which it was declared.
        return ClassScope.make(getEnclosingClass());
    }

    /**
     * Factory method. Takes a {@code Constructor} object and creates a
     * scope for it.
     * @param c - A Constructor whose scope we want to obtain
     * @return The type-variable scope for the constructor m
     */
    public static ConstructorScope make(Constructor<?> c) {
        return new ConstructorScope(c);
    }
}
