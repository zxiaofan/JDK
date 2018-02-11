/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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
 * Represents an annotation type.
 *
 * @author Scott Seligman
 * @since 1.5
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated
public interface AnnotationTypeDoc extends ClassDoc {

    /**
     * Returns the elements of this annotation type.
     * Returns an empty array if there are none.
     *
     * @return the elements of this annotation type.
     */
    AnnotationTypeElementDoc[] elements();
}
