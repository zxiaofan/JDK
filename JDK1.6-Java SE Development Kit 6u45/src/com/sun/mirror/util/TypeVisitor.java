/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.util;


import com.sun.mirror.type.*;


/**
 * A visitor for types, in the style of the standard visitor design pattern.
 * This is used to operate on a type when the kind
 * of type is unknown at compile time.
 * When a visitor is passed to a type's
 * {@link TypeMirror#accept accept} method,
 * the most specific <tt>visit<i>Xxx</i></tt> method applicable to
 * that type is invoked.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface TypeVisitor {

    /**
     * Visits a type mirror.
     *
     * @param t the type to visit
     */
    public void visitTypeMirror(TypeMirror t);

    /**
     * Visits a primitive type.

     * @param t the type to visit
     */
    public void visitPrimitiveType(PrimitiveType t);

    /**
     * Visits a void type.
     *
     * @param t the type to visit
     */
    public void visitVoidType(VoidType t);

    /**
     * Visits a reference type.
     *
     * @param t the type to visit
     */
    public void visitReferenceType(ReferenceType t);

    /**
     * Visits a declared type.
     *
     * @param t the type to visit
     */
    public void visitDeclaredType(DeclaredType t);

    /**
     * Visits a class type.
     * 
     * @param t the type to visit
     */
    public void visitClassType(ClassType t);

    /**
     * Visits an enum type.
     * 
     * @param t the type to visit
     */
    public void visitEnumType(EnumType t);

    /**
     * Visits an interface type.
     * 
     * @param t the type to visit
     */
    public void visitInterfaceType(InterfaceType t);

    /**
     * Visits an annotation type.
     * 
     * @param t the type to visit
     */
    public void visitAnnotationType(AnnotationType t);

    /**
     * Visits an array type.
     * 
     * @param t the type to visit
     */
    public void visitArrayType(ArrayType t);

    /**
     * Visits a type variable.
     * 
     * @param t the type to visit
     */
    public void visitTypeVariable(TypeVariable t);

    /**
     * Visits a wildcard.
     * 
     * @param t the type to visit
     */
    public void visitWildcardType(WildcardType t);
}
