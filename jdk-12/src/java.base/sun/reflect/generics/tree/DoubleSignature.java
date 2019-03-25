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

package sun.reflect.generics.tree;

import sun.reflect.generics.visitor.TypeTreeVisitor;

/** AST that represents the type double. */
public class DoubleSignature implements BaseType {
    private static final DoubleSignature singleton = new DoubleSignature();

    private DoubleSignature(){}

    public static DoubleSignature make() {return singleton;}

    public void accept(TypeTreeVisitor<?> v){v.visitDoubleSignature(this);}
}
