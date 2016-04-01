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

/**
 * Utilities to create specialized <tt>DeclarationVisitor</tt> instances.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  There is no direct
 * replacement for the functionality of this class in the standardized
 * API due to that API's different visitor structure.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public class DeclarationVisitors {
    private DeclarationVisitors(){} // do not instantiate.

    /**
     * A visitor that has no side effects and keeps no state.
     */
    public static final DeclarationVisitor NO_OP = new SimpleDeclarationVisitor();

    /**
     * Return a <tt>DeclarationVisitor</tt> that will scan the
     * declaration structure, visiting declarations contained in
     * another declaration.  For example, when visiting a class, the
     * fields, methods, constructors, etc. of the class are also
     * visited.  The order in which the contained declarations are scanned is
     * not specified.
     *
     * <p>The <tt>pre</tt> and <tt>post</tt>
     * <tt>DeclarationVisitor</tt> parameters specify,
     * respectively, the processing the scanner will do before or
     * after visiting the contained declarations.  If only one of pre
     * and post processing is needed, use {@link
     * DeclarationVisitors#NO_OP DeclarationVisitors.NO_OP} for the
     * other parameter.
     *
     * @param pre visitor representing processing to do before
     * visiting contained declarations.
     *
     * @param post visitor representing processing to do after
     * visiting contained declarations.
     */
    public static DeclarationVisitor getDeclarationScanner(DeclarationVisitor pre,
                                                           DeclarationVisitor post) {
        return new DeclarationScanner(pre, post);
    }

    /**
     * Return a <tt>DeclarationVisitor</tt> that will scan the
     * declaration structure, visiting declarations contained in
     * another declaration in source code order.  For example, when
     * visiting a class, the fields, methods, constructors, etc. of
     * the class are also visited.  The order in which the contained
     * declarations are visited is as close to source code order as
     * possible; declaration mirrors created from class files instead
     * of source code will not have source position information.
     *
     * <p>The <tt>pre</tt> and <tt>post</tt>
     * <tt>DeclarationVisitor</tt> parameters specify,
     * respectively, the processing the scanner will do before or
     * after visiting the contained declarations.  If only one of pre
     * and post processing is needed, use {@link
     * DeclarationVisitors#NO_OP DeclarationVisitors.NO_OP} for the other parameter.
     *
     * @param pre visitor representing processing to do before
     * visiting contained declarations.
     *
     * @param post visitor representing processing to do after
     * visiting contained declarations.
     */
    public static DeclarationVisitor getSourceOrderDeclarationScanner(DeclarationVisitor pre,
                                                                      DeclarationVisitor post) {
        return new SourceOrderDeclScanner(pre, post);
    }
}
