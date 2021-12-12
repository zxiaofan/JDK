/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.reflect.TypeVariable;
import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.FormalTypeParameter;
import sun.reflect.generics.tree.Signature;
import sun.reflect.generics.visitor.Reifier;



/**
 * This class represents the generic type information for a generic
 * declaration.
 * The code is not dependent on a particular reflective implementation.
 * It is designed to be used unchanged by at least core reflection and JDI.
 */
public abstract class GenericDeclRepository<S extends Signature>
    extends AbstractRepository<S> {

    /** The formal type parameters.  Lazily initialized. */
    private volatile TypeVariable<?>[] typeParameters;

    protected GenericDeclRepository(String rawSig, GenericsFactory f) {
        super(rawSig, f);
    }

    /*
     * When queried for a particular piece of type information, the
     * general pattern is to consult the corresponding cached value.
     * If the corresponding field is non-null, it is returned.
     * If not, it is created lazily. This is done by selecting the appropriate
     * part of the tree and transforming it into a reflective object
     * using a visitor, which is created by feeding it the factory
     * with which the repository was created.
     */

    /**
     * Returns the formal type parameters of this generic declaration.
     * @return the formal type parameters of this generic declaration
     */
    public TypeVariable<?>[] getTypeParameters() {
        TypeVariable<?>[] value = typeParameters;
        if (value == null) {
            value = computeTypeParameters();
            typeParameters = value;
        }
        return value.clone();
    }

    private TypeVariable<?>[] computeTypeParameters() {
        // first, extract type parameter subtree(s) from AST
        FormalTypeParameter[] ftps = getTree().getFormalTypeParameters();
        // create array to store reified subtree(s)
        int length = ftps.length;
        TypeVariable<?>[] typeParameters = new TypeVariable<?>[length];
        // reify all subtrees
        for (int i = 0; i < length; i++) {
            Reifier r = getReifier(); // obtain visitor
            ftps[i].accept(r); // reify subtree
            // extract result from visitor and store it
            typeParameters[i] = (TypeVariable<?>) r.getResult();
        }
        return typeParameters;
    }
}
