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

/** AST that represents the type char. */
public class CharSignature implements BaseType {
    private static final CharSignature singleton = new CharSignature();

    private CharSignature(){}

    public static CharSignature make() {return singleton;}

    public void accept(TypeTreeVisitor<?> v){
        v.visitCharSignature(this);
    }
}
