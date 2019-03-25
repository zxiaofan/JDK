/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javadoc;

/**
 * Represents an @param documentation tag.
 * Stores the name and comment parts of the parameter tag.
 * An @param tag may represent either a method or constructor parameter,
 * or a type parameter.
 *
 * @author Robert Field
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public interface ParamTag extends Tag {

    /**
     * Return the name of the parameter or type parameter
     * associated with this {@code ParamTag}.
     * The angle brackets delimiting a type parameter are not part of
     * its name.
     *
     * @return the parameter name.
     */
    String parameterName();

    /**
     * Return the parameter comment
     * associated with this {@code ParamTag}.
     *
     * @return the parameter comment.
     */
    String parameterComment();

    /**
     * Return true if this {@code ParamTag} corresponds to a type
     * parameter.  Return false if it corresponds to an ordinary parameter
     * of a method or constructor.
     *
     * @return true if this {@code ParamTag} corresponds to a type
     * parameter.
     * @since 1.5
     */
    boolean isTypeParameter();
}
