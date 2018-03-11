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

import com.sun.mirror.util.SourcePosition;

/**
 * Represents a value of an annotation type element.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.element.AnnotationValue}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface AnnotationValue {

    /**
     * Returns the value.
     * The result has one of the following types:
     * <ul><li> a wrapper class (such as {@link Integer}) for a primitive type
     *     <li> {@code String}
     *     <li> {@code TypeMirror}
     *     <li> {@code EnumConstantDeclaration}
     *     <li> {@code AnnotationMirror}
     *     <li> {@code Collection<AnnotationValue>}
     *          (representing the elements, in order, if the value is an array)
     * </ul>
     *
     * @return the value
     */
    Object getValue();

    /**
     * Returns the source position of the beginning of this annotation value.
     * Returns null if the position is unknown or not applicable.
     *
     * <p>This source position is intended for use in providing diagnostics,
     * and indicates only approximately where an annotation value begins.
     *
     * @return  the source position of the beginning of this annotation value or
     * null if the position is unknown or not applicable
     */
    SourcePosition getPosition();

    /**
     * Returns a string representation of this value.
     * This is returned in a form suitable for representing this value
     * in the source code of an annotation.
     *
     * @return a string representation of this value
     */
    String toString();
}
