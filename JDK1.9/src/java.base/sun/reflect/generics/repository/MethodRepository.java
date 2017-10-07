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


import java.lang.reflect.Type;
import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.visitor.Reifier;



/**
 * This class represents the generic type information for a method.
 * The code is not dependent on a particular reflective implementation.
 * It is designed to be used unchanged by at least core reflection and JDI.
 */
public class MethodRepository extends ConstructorRepository {

    /** The generic return type info.  Lazily initialized. */
    private volatile Type returnType;

 // private, to enforce use of static factory
    private MethodRepository(String rawSig, GenericsFactory f) {
      super(rawSig, f);
    }

    /**
     * Static factory method.
     * @param rawSig - the generic signature of the reflective object
     * that this repository is servicing
     * @param f - a factory that will provide instances of reflective
     * objects when this repository converts its AST
     * @return a {@code MethodRepository} that manages the generic type
     * information represented in the signature {@code rawSig}
     */
    public static MethodRepository make(String rawSig, GenericsFactory f) {
        return new MethodRepository(rawSig, f);
    }

    public Type getReturnType() {
        Type value = returnType;
        if (value == null) {
            value = computeReturnType();
            returnType = value;
        }
        return value;
    }

    private Type computeReturnType() {
        Reifier r = getReifier(); // obtain visitor
        // Extract return type subtree from AST and reify
        getTree().getReturnType().accept(r);
        // extract result from visitor and cache it
        return r.getResult();
    }

}
