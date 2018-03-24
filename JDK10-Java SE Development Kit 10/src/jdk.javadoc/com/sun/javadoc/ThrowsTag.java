/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a @throws or @exception documentation tag.
 * Parses and holds the exception name and exception comment.
 * Note: @exception is a backwards compatible synonymy for @throws.
 *
 * @author Robert Field
 * @author Atul M Dambalkar
 * @see ExecutableMemberDoc#throwsTags()
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated
public interface ThrowsTag extends Tag {

    /**
     * Return the name of the exception
     * associated with this {@code ThrowsTag}.
     *
     * @return name of the exception.
     */
    String exceptionName();

    /**
     * Return the exception comment
     * associated with this {@code ThrowsTag}.
     *
     * @return exception comment.
     */
    String exceptionComment();

    /**
     * Return a {@code ClassDoc} that represents the exception.
     * If the type of the exception is a type variable, return the
     * {@code ClassDoc} of its erasure.
     *
     * <p> <i>This method cannot accommodate certain generic type
     * constructs.  The {@code exceptionType} method
     * should be used instead.</i>
     *
     * @return {@code ClassDoc} that represents the exception.
     * @see #exceptionType
     */
    ClassDoc exception();

    /**
     * Return the type of the exception
     * associated with this {@code ThrowsTag}.
     * This may be a {@code ClassDoc} or a {@code TypeVariable}.
     *
     * @return the type of the exception.
     * @since 1.5
     */
    Type exceptionType();
}
