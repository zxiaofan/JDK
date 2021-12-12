/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Provides information on the accessibility of a type or type component.
 * Mirrors for program elements which allow an
 * an access specifier (private, protected, public) provide information
 * on that part of the declaration through this interface.
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface Accessible {

    /**
     * Returns the Java programming language modifiers, encoded
     * in an integer.
     * <p>
     * The modifier encodings are defined in
     * <cite>The Java Virtual Machine Specification</cite>
     * in the <code>access_flag</code> tables for classes(section 4.1), fields(section 4.5), and methods(section 4.6).
     */
    public int modifiers();

    /**
     * Determines if this object mirrors a private item.
     * For {@link ArrayType}, the return value depends on the
     * array component type. For primitive arrays the return value
     * is always false. For object arrays, the return value is the
     * same as would be returned for the component type.
     * For primitive classes, such as {@link java.lang.Integer#TYPE},
     * the return value is always false.
     *
     * @return <code>true</code> for items with private access;
     * <code>false</code> otherwise.
     */
    boolean isPrivate();

    /**
     * Determines if this object mirrors a package private item.
     * A package private item is declared with no access specifier.
     * For {@link ArrayType}, the return value depends on the
     * array component type. For primitive arrays the return value
     * is always false. For object arrays, the return value is the
     * same as would be returned for the component type.
     * For primitive classes, such as {@link java.lang.Integer#TYPE},
     * the return value is always false.
     *
     * @return <code>true</code> for items with package private access;
     * <code>false</code> otherwise.
     */
    boolean isPackagePrivate();

    /**
     * Determines if this object mirrors a protected item.
     * For {@link ArrayType}, the return value depends on the
     * array component type. For primitive arrays the return value
     * is always false. For object arrays, the return value is the
     * same as would be returned for the component type.
     * For primitive classes, such as {@link java.lang.Integer#TYPE},
     * the return value is always false.
     *
     * @return <code>true</code> for items with private access;
     * <code>false</code> otherwise.
     */
    boolean isProtected();

    /**
     * Determines if this object mirrors a public item.
     * For {@link ArrayType}, the return value depends on the
     * array component type. For primitive arrays the return value
     * is always true. For object arrays, the return value is the
     * same as would be returned for the component type.
     * For primitive classes, such as {@link java.lang.Integer#TYPE},
     * the return value is always true.
     *
     * @return <code>true</code> for items with public access;
     * <code>false</code> otherwise.
     */
    boolean isPublic();
}
