/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.type;

import java.util.List;

/**
 * Represents an intersection type.
 *
 * <p>An intersection type can be either implicitly or explicitly
 * declared in a program. For example, the bound of the type parameter
 * {@code <T extends Number & Runnable>} is an (implicit) intersection
 * type.  This is represented by an {@code IntersectionType} with
 * {@code Number} and {@code Runnable} as its bounds.
 *
 * @implNote In the reference implementation an {@code
 * IntersectionType} is used to model the explicit target type of a
 * cast expression.
 *
 * @since 1.8
 */
public interface IntersectionType extends TypeMirror {

    /**
     * {@return the bounds comprising this intersection type}
     */
    List<? extends TypeMirror> getBounds();
}
