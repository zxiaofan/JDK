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

public class SimpleClassTypeSignature implements FieldTypeSignature {
    private final boolean dollar;
    private final String name;
    private final TypeArgument[] typeArgs;

    private SimpleClassTypeSignature(String n, boolean dollar, TypeArgument[] tas) {
        name = n;
        this.dollar = dollar;
        typeArgs = tas;
    }

    public static SimpleClassTypeSignature make(String n,
                                                boolean dollar,
                                                TypeArgument[] tas){
        return new SimpleClassTypeSignature(n, dollar, tas);
    }

    /*
     * Should a '$' be used instead of '.' to separate this component
     * of the name from the previous one when composing a string to
     * pass to Class.forName; in other words, is this a transition to
     * a nested class.
     */
    public boolean getDollar(){return dollar;}
    public String getName(){return name;}
    public TypeArgument[] getTypeArguments(){return typeArgs;}

    public void accept(TypeTreeVisitor<?> v){
        v.visitSimpleClassTypeSignature(this);
    }
}
