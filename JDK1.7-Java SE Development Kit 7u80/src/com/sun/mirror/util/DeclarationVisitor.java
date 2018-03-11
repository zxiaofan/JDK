/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.mirror.util;

import com.sun.mirror.declaration.*;


/**
 * A visitor for declarations, in the style of the standard visitor
 * design pattern.  Classes implementing this interface are used to
 * operate on a declaration when the kind of declaration is unknown at
 * compile time.  When a visitor is passed to a declaration's {@link
 * Declaration#accept accept} method, the most specific
 * <tt>visit<i>Xxx</i></tt> method applicable to that declaration is
 * invoked.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.element.ElementVisitor}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface DeclarationVisitor {

    /**
     * Visits a declaration.
     * @param d the declaration to visit
     */
    public void visitDeclaration(Declaration d);

    /**
     * Visits a package declaration.
     * @param d the declaration to visit
     */
    public void visitPackageDeclaration(PackageDeclaration d);

    /**
     * Visits a member or constructor declaration.
     * @param d the declaration to visit
     */
    public void visitMemberDeclaration(MemberDeclaration d);

    /**
     * Visits a type declaration.
     * @param d the declaration to visit
     */
    public void visitTypeDeclaration(TypeDeclaration d);

    /**
     * Visits a class declaration.
     * @param d the declaration to visit
     */
    public void visitClassDeclaration(ClassDeclaration d);

    /**
     * Visits an enum declaration.
     * @param d the declaration to visit
     */
    public void visitEnumDeclaration(EnumDeclaration d);

    /**
     * Visits an interface declaration.
     * @param d the declaration to visit
     */
    public void visitInterfaceDeclaration(InterfaceDeclaration d);

    /**
     * Visits an annotation type declaration.
     * @param d the declaration to visit
     */
    public void visitAnnotationTypeDeclaration(AnnotationTypeDeclaration d);

    /**
     * Visits a field declaration.
     * @param d the declaration to visit
     */
    public void visitFieldDeclaration(FieldDeclaration d);

    /**
     * Visits an enum constant declaration.
     * @param d the declaration to visit
     */
    public void visitEnumConstantDeclaration(EnumConstantDeclaration d);

    /**
     * Visits a method or constructor declaration.
     * @param d the declaration to visit
     */
    public void visitExecutableDeclaration(ExecutableDeclaration d);

    /**
     * Visits a constructor declaration.
     * @param d the declaration to visit
     */
    public void visitConstructorDeclaration(ConstructorDeclaration d);

    /**
     * Visits a method declaration.
     * @param d the declaration to visit
     */
    public void visitMethodDeclaration(MethodDeclaration d);

    /**
     * Visits an annotation type element declaration.
     * @param d the declaration to visit
     */
    public void visitAnnotationTypeElementDeclaration(
                                     AnnotationTypeElementDeclaration d);

    /**
     * Visits a parameter declaration.
     * @param d the declaration to visit
     */
    public void visitParameterDeclaration(ParameterDeclaration d);

    /**
     * Visits a type parameter declaration.
     * @param d the declaration to visit
     */
    public void visitTypeParameterDeclaration(TypeParameterDeclaration d);
}
