/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.element;

import java.util.List;

/**
 * Represents a package program element.  Provides access to information
 * about the package and its members.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see javax.lang.model.util.Elements#getPackageOf
 * @since 1.6
 */
public interface PackageElement extends Element, QualifiedNameable {

    /**
     * Returns the fully qualified name of this package.
     * This is also known as the package's <i>canonical</i> name.
     * For an {@linkplain #isUnnamed() unnamed package}, an empty name is returned.
     *
     * @apiNote The fully qualified name of a named package that is
     * not a subpackage of a named package is its simple name. The
     * fully qualified name of a named package that is a subpackage of
     * another named package consists of the fully qualified name of
     * the containing package, followed by "{@code .}", followed by the simple
     * (member) name of the subpackage.
     *
     * @return the fully qualified name of this package, or an
     * empty name if this is an unnamed package
     * @jls 6.7 Fully Qualified Names and Canonical Names
     */
    Name getQualifiedName();

    /**
     * Returns the simple name of this package.  For an {@linkplain
     * #isUnnamed() unnamed package}, an empty name is returned.
     *
     * @return the simple name of this package or an empty name if
     * this is an unnamed package
     */
    @Override
    Name getSimpleName();

    /**
     * Returns the {@linkplain NestingKind#TOP_LEVEL top-level}
     * classes and interfaces within this package.  Note that
     * subpackages are <em>not</em> considered to be enclosed by a
     * package.
     *
     * @return the top-level classes and interfaces within this
     * package
     */
    @Override
    List<? extends Element> getEnclosedElements();

    /**
     * Returns {@code true} if this is an unnamed package and {@code
     * false} otherwise.
     *
     * @return {@code true} if this is an unnamed package and {@code
     * false} otherwise
     * @jls 7.4.2 Unnamed Packages
     */
    boolean isUnnamed();

    /**
     * Returns the enclosing module if such a module exists; otherwise
     * returns {@code null}.
     *
     * One situation where a module does not exist for a package is if
     * the environment does not include modules, such as an annotation
     * processing environment configured for a {@linkplain
     * javax.annotation.processing.ProcessingEnvironment#getSourceVersion
     * source version} without modules.
     *
     * @return the enclosing module or {@code null} if no such module exists
     *
     * @revised 9
     * @spec JPMS
     */
    @Override
    Element getEnclosingElement();
}
