/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.reflect.Method;


/**
 * This class represents the scope containing the type variables of
 * a method.
 */
public class MethodScope extends AbstractScope<Method> {

    // constructor is private to enforce use of factory method
    private MethodScope(Method m){
        super(m);
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
        // the enclosing scope of a (generic) method is the scope of the
        // class in which it was declared.
        return ClassScope.make(getEnclosingClass());
    }

    /**
     * Factory method. Takes a {@code Method} object and creates a
     * scope for it.
     * @param m - A Method whose scope we want to obtain
     * @return The type-variable scope for the method m
     */
    public static MethodScope make(Method m) {
        return new MethodScope(m);
    }
}
