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

import java.util.Map;
import com.sun.mirror.type.AnnotationType;
import com.sun.mirror.util.SourcePosition;


/**
 * Represents an annotation.  An annotation associates a value with
 * each element of an annotation type.
 *
 * <p> Annotations should not be compared using reference-equality
 * ("<tt>==</tt>").  There is no guarantee that any particular
 * annotation will always be represented by the same object.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.element.AnnotationMirror}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface AnnotationMirror {

    /**
     * Returns the annotation type of this annotation.
     *
     * @return the annotation type of this annotation
     */
    AnnotationType getAnnotationType();

    /**
     * Returns the source position of the beginning of this annotation.
     * Returns null if the position is unknown or not applicable.
     *
     * <p>This source position is intended for use in providing diagnostics,
     * and indicates only approximately where an annotation begins.
     *
     * @return  the source position of the beginning of this annotation or
     * null if the position is unknown or not applicable
     */
    SourcePosition getPosition();

    /**
     * Returns this annotation's elements and their values.
     * This is returned in the form of a map that associates elements
     * with their corresponding values.
     * Only those elements and values explicitly present in the
     * annotation are included, not those that are implicitly assuming
     * their default values.
     * The order of the map matches the order in which the
     * elements appear in the annotation's source.
     *
     * @return this annotation's elements and their values,
     * or an empty map if there are none
     */
    Map<AnnotationTypeElementDeclaration, AnnotationValue> getElementValues();
}
