/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a value of an annotation type element.
 *
 * @author Scott Seligman
 * @since 1.5
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public interface AnnotationValue {

    /**
     * Returns the value.
     * The type of the returned object is one of the following:
     * <ul><li> a wrapper class for a primitive type
     *     <li> {@code String}
     *     <li> {@code Type} (representing a class literal)
     *     <li> {@code FieldDoc} (representing an enum constant)
     *     <li> {@code AnnotationDesc}
     *     <li> {@code AnnotationValue[]}
     * </ul>
     *
     * @return the value.
     */
    Object value();

    /**
     * Returns a string representation of the value.
     *
     * @return the text of a Java language annotation value expression
     *          whose value is the value of this element.
     */
    String toString();
}
