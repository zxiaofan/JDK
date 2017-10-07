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

package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.TypeTreeVisitor;

public class Wildcard implements TypeArgument {
    private final FieldTypeSignature[] upperBounds;
    private final FieldTypeSignature[] lowerBounds;

    private Wildcard(FieldTypeSignature[] ubs, FieldTypeSignature[] lbs) {
        upperBounds = ubs;
        lowerBounds = lbs;
    }

    private static final FieldTypeSignature[] emptyBounds = new FieldTypeSignature[0];

    public static Wildcard make(FieldTypeSignature[] ubs,
                                FieldTypeSignature[] lbs) {
        return new Wildcard(ubs, lbs);
    }

    public FieldTypeSignature[] getUpperBounds() {
        return upperBounds;
    }

    public FieldTypeSignature[] getLowerBounds() {
        if (lowerBounds.length == 1 &&
            lowerBounds[0] == BottomSignature.make())
            return emptyBounds;
        else
            return lowerBounds;
    }

    public void accept(TypeTreeVisitor<?> v){v.visitWildcard(this);}
}
