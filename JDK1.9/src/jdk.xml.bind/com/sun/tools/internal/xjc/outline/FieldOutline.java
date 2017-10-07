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

package com.sun.tools.internal.xjc.outline;

import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JType;
import com.sun.tools.internal.xjc.model.CPropertyInfo;

/**
 * Representation of a field of {@link ClassOutline}.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface FieldOutline {

    /**
     * Gets the enclosing {@link ClassOutline}.
     */
    ClassOutline parent();

    /** Gets the corresponding model object. */
    CPropertyInfo getPropertyInfo();

    /**
     * Gets the type of the "raw value".
     *
     * <p>
     * This type can represent the entire value of this field.
     * For fields that can carry multiple values, this is an array.
     *
     * <p>
     * This type allows the client of the outline to generate code
     * to set/get values from a property.
     */
    JType getRawType();

    /**
     * Creates a new {@link FieldAccessor} of this field
     * for the specified object.
     *
     * @param targetObject
     *      Evaluates to an object, and the field on this object
     *      will be accessed.
     */
    FieldAccessor create( JExpression targetObject );
}
