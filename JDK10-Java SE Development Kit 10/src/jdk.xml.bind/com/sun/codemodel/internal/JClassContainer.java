/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.codemodel.internal;

import java.util.Iterator;

/**
 * The common aspect of a package and a class.
 */
public interface JClassContainer {

    /**
     * Returns true if the container is a class.
     */
    boolean isClass();
    /**
     * Returns true if the container is a package.
     */
    boolean isPackage();

    /**
     * Add a new class to this package/class.
     *
     * @param mods
     *        Modifiers for this class declaration
     *
     * @param name
     *        Name of class to be added to this package
     *
     * @return Newly generated class
     *
     * @exception JClassAlreadyExistsException
     *      When the specified class/interface was already created.
     */
    JDefinedClass _class(int mods, String name) throws JClassAlreadyExistsException;

    /**
     * Add a new public class to this class/package.
     *
     * @exception JClassAlreadyExistsException
     *      When the specified class/interface was already created.
     */
    public JDefinedClass _class(String name) throws JClassAlreadyExistsException;

    /**
     * Add an interface to this class/package.
     *
     * @param mods
     *        Modifiers for this interface declaration
     *
     * @param name
     *        Name of interface to be added to this package
     *
     * @return Newly generated interface
     *
     * @exception JClassAlreadyExistsException
     *      When the specified class/interface was already created.
     */
    public JDefinedClass _interface(int mods, String name) throws JClassAlreadyExistsException;

    /**
     * Adds a public interface to this package.
     *
     * @exception JClassAlreadyExistsException
     *      When the specified class/interface was already created.
     */
    public JDefinedClass _interface(String name) throws JClassAlreadyExistsException;

    /**
     * Create a new class or a new interface.
     *
     * @deprecated
     *      use {@link #_class(int, String, ClassType)}
     */
    public JDefinedClass _class(int mods, String name, boolean isInterface )
        throws JClassAlreadyExistsException;

    /**
     * Creates a new class/enum/interface/annotation.
     */
    public JDefinedClass _class(int mods, String name, ClassType kind )
        throws JClassAlreadyExistsException;


    /**
     * Returns an iterator that walks the nested classes defined in this
     * class.
     */
    public Iterator<JDefinedClass> classes();

    /**
     * Parent JClassContainer.
     *
     * If this is a package, this method returns a parent package,
     * or null if this package is the root package.
     *
     * If this is an outer-most class, this method returns a package
     * to which it belongs.
     *
     * If this is an inner class, this method returns the outer
     * class.
     */
    public JClassContainer parentContainer();

    /**
     * Gets the nearest package parent.
     *
     * <p>
     * If {@code this.isPackage()}, then return {@code this}.
     */
    public JPackage getPackage();

    /**
     * Get the root code model object.
     */
    public JCodeModel owner();

    /**
     * Add an annotationType Declaration to this package
     * @param name
     *      Name of the annotation Type declaration to be added to this package
     * @return
     *      newly created Annotation Type Declaration
     * @exception JClassAlreadyExistsException
     *      When the specified class/interface was already created.

     */
    public JDefinedClass _annotationTypeDeclaration(String name) throws JClassAlreadyExistsException;

    /**
     * Add a public enum to this package
     * @param name
     *      Name of the enum to be added to this package
     * @return
     *      newly created Enum
     * @exception JClassAlreadyExistsException
     *      When the specified class/interface was already created.

     */
    public JDefinedClass _enum (String name) throws JClassAlreadyExistsException;

}
