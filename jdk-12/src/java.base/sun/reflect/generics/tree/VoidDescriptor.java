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


/** AST that represents the pseudo-type void. */
public class VoidDescriptor implements ReturnType {
    private static final VoidDescriptor singleton = new VoidDescriptor();

    private VoidDescriptor(){}

    public static VoidDescriptor make() {return singleton;}



    public void accept(TypeTreeVisitor<?> v){v.visitVoidDescriptor(this);}
}
