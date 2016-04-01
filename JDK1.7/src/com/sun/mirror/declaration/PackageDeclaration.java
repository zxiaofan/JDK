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

package com.sun.mirror.declaration;


import java.util.Collection;


/**
 * Represents the declaration of a package.  Provides access to information
 * about the package and its members.
 *
 * <p> {@link com.sun.mirror.util.DeclarationFilter}
 * provides a simple way to select just the items of interest
 * when a method returns a collection of declarations.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.element.PackageElement}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface PackageDeclaration extends Declaration {

    /**
     * Returns the fully qualified name of this package.
     * This is also known as the package's <i>canonical</i> name.
     *
     * @return the fully qualified name of this package, or the
     * empty string if this is the unnamed package
     */
    String getQualifiedName();

    /**
     * Returns the declarations of the top-level classes in this package.
     * Interfaces are not included, but enum types are.
     *
     * @return the declarations of the top-level classes in this package
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<ClassDeclaration> getClasses();

    /**
     * Returns the declarations of the top-level enum types in this package.
     *
     * @return the declarations of the top-level enum types in this package
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<EnumDeclaration> getEnums();

    /**
     * Returns the declarations of the top-level interfaces in this package.
     * Annotation types are included.
     *
     * @return the declarations of the top-level interfaces in this package
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<InterfaceDeclaration> getInterfaces();

    /**
     * Returns the declarations of the top-level annotation types in this
     * package.
     *
     * @return the declarations of the top-level annotation types in this
     * package
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<AnnotationTypeDeclaration> getAnnotationTypes();
}
