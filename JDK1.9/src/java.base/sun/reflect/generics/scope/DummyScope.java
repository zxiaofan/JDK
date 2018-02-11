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

import java.lang.reflect.TypeVariable;

/**
 * This class is used to provide enclosing scopes for top level classes.
 * We cannot use {@code null} to represent such a scope, since the
 * enclosing scope is computed lazily, and so the field storing it is
 * null until it has been computed. Therefore, {@code null} is reserved
 * to represent an as-yet-uncomputed scope, and cannot be used for any
 * other kind of scope.
 */
public class DummyScope implements Scope {
    // Caches the unique instance of this class; instances contain no data
    // so we can use the singleton pattern
    private static final DummyScope singleton = new DummyScope();

    // constructor is private to enforce use of factory method
    private DummyScope(){}

    /**
     * Factory method. Enforces the singleton pattern - only one
     * instance of this class ever exists.
     */
    public static DummyScope make() {
        return singleton;
    }

    /**
     * Lookup a type variable in the scope, using its name. Always returns
     * {@code null}.
     * @param name - the name of the type variable being looked up
     * @return  null
     */
    public TypeVariable<?> lookup(String name) {return null;}
}
