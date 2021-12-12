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

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;


/**
 * Abstract superclass for lazy scope objects, used when building
 * factories for generic information repositories.
 * The type parameter {@code D} represents the type of reflective
 * object whose scope this class is representing.
 * <p> To subclass this, all one needs to do is implement
 * {@code computeEnclosingScope} and the subclass' constructor.
 */
public abstract class AbstractScope<D extends GenericDeclaration>
    implements Scope {

    private final D recvr; // the declaration whose scope this instance represents

    /** The enclosing scope of this scope.  Lazily initialized. */
    private volatile Scope enclosingScope;

    /**
     * Constructor. Takes a reflective object whose scope the newly
     * constructed instance will represent.
     * @param decl - A generic declaration whose scope the newly
     * constructed instance will represent
     */
    protected AbstractScope(D decl){ recvr = decl;}

    /**
     * Accessor for the receiver - the object whose scope this {@code Scope}
     * object represents.
     * @return The object whose scope this {@code Scope} object represents
     */
    protected D getRecvr() {return recvr;}

    /** This method must be implemented by any concrete subclass.
     * It must return the enclosing scope of this scope. If this scope
     * is a top-level scope, an instance of DummyScope must be returned.
     * @return The enclosing scope of this scope
     */
    protected abstract Scope computeEnclosingScope();

    /**
     * Accessor for the enclosing scope, which is computed lazily and cached.
     * @return the enclosing scope
     */
    protected Scope getEnclosingScope() {
        Scope value = enclosingScope;
        if (value == null) {
            value = computeEnclosingScope();
            enclosingScope = value;
        }
        return value;
    }

    /**
     * Lookup a type variable in the scope, using its name. Returns null if
     * no type variable with this name is declared in this scope or any of its
     * surrounding scopes.
     * @param name - the name of the type variable being looked up
     * @return the requested type variable, if found
     */
    public TypeVariable<?> lookup(String name) {
        TypeVariable<?>[] tas = getRecvr().getTypeParameters();
        for (TypeVariable<?> tv : tas) {
            if (tv.getName().equals(name)) {return tv;}
        }
        return getEnclosingScope().lookup(name);
    }
}
