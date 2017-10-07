/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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
import java.lang.reflect.Method;


/**
 * This class represents the scope containing the type variables of
 * a class.
 */
public class ClassScope extends AbstractScope<Class<?>> implements Scope {

    // constructor is private to enforce use of factory method
    private ClassScope(Class<?> c){
        super(c);
    }

    /**
     * Overrides the abstract method in the superclass.
     * @return the enclosing scope
     */
    protected Scope computeEnclosingScope() {
        Class<?> receiver = getRecvr();

        Method m = receiver.getEnclosingMethod();
        if (m != null)
            // Receiver is a local or anonymous class enclosed in a
            // method.
            return MethodScope.make(m);

        Constructor<?> cnstr = receiver.getEnclosingConstructor();
        if (cnstr != null)
            // Receiver is a local or anonymous class enclosed in a
            // constructor.
            return ConstructorScope.make(cnstr);

        Class<?> c = receiver.getEnclosingClass();
        // if there is a declaring class, recvr is a member class
        // and its enclosing scope is that of the declaring class
        if (c != null)
            // Receiver is a local class, an anonymous class, or a
            // member class (static or not).
            return ClassScope.make(c);

        // otherwise, recvr is a top level class, and it has no real
        // enclosing scope.
        return DummyScope.make();
    }

    /**
     * Factory method. Takes a {@code Class} object and creates a
     * scope for it.
     * @param c - a Class whose scope we want to obtain
     * @return The type-variable scope for the class c
     */
    public static ClassScope make(Class<?> c) { return new ClassScope(c);}

}
