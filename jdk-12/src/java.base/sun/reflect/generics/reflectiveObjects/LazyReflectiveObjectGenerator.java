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

package sun.reflect.generics.reflectiveObjects;

import java.lang.reflect.Type;
import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.FieldTypeSignature;
import sun.reflect.generics.visitor.Reifier;


/**
 * Common infrastructure for things that lazily generate reflective generics
 * objects.
 * <p> In all these cases, one needs produce a visitor that will, on demand,
 * traverse the stored AST(s) and reify them into reflective objects.
 * The visitor needs to be initialized with a factory, which will be
 * provided when the instance is initialized.
 * The factory should be cached.
 *
*/
public abstract class LazyReflectiveObjectGenerator {
    private final GenericsFactory factory; // cached factory

    protected LazyReflectiveObjectGenerator(GenericsFactory f) {
        factory = f;
    }

    // accessor for factory
    private GenericsFactory getFactory() {
        return factory;
    }

    // produce a reifying visitor (could this be typed as a TypeTreeVisitor?
    protected Reifier getReifier(){return Reifier.make(getFactory());}

    Type[] reifyBounds(FieldTypeSignature[] boundASTs) {
        final int length = boundASTs.length;
        final Type[] bounds = new Type[length];
        // iterate over bound trees, reifying each in turn
        for (int i = 0; i < length; i++) {
            Reifier r = getReifier();
            boundASTs[i].accept(r);
            bounds[i] = r.getResult();
        }
        return bounds;
    }

}
