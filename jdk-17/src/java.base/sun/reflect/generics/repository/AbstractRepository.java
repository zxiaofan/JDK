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

package sun.reflect.generics.repository;

import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.Tree;
import sun.reflect.generics.visitor.Reifier;


/**
 * Abstract superclass for representing the generic type information for
 * a reflective entity.
 * The code is not dependent on a particular reflective implementation.
 * It is designed to be used unchanged by at least core reflection and JDI.
 */
public abstract class AbstractRepository<T extends Tree> {

    // A factory used to produce reflective objects. Provided when the
    //repository is created. Will vary across implementations.
    private final GenericsFactory factory;

    private final T tree; // the AST for the generic type info

    //accessors
    private GenericsFactory getFactory() { return factory;}

    /**
     * Accessor for {@code tree}.
     * @return the cached AST this repository holds
     */
    protected T getTree(){ return tree;}

    /**
     * Returns a {@code Reifier} used to convert parts of the
     * AST into reflective objects.
     * @return a {@code Reifier} used to convert parts of the
     * AST into reflective objects
     */
    protected Reifier getReifier(){return Reifier.make(getFactory());}

    /**
     * Constructor. Should only be used by subclasses. Concrete subclasses
     * should make their constructors private and provide public factory
     * methods.
     * @param rawSig - the generic signature of the reflective object
     * that this repository is servicing
     * @param f - a factory that will provide instances of reflective
     * objects when this repository converts its AST
     */
    protected AbstractRepository(String rawSig, GenericsFactory f) {
        tree = parse(rawSig);
        factory = f;
    }

    /**
     * Returns the AST for the generic type info of this entity.
     * @param s - a string representing the generic signature of this
     * entity
     * @return the AST for the generic type info of this entity.
     */
    protected abstract T parse(String s);
}
