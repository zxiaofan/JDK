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


import com.sun.mirror.type.TypeMirror;


/**
 * Represents a field of a type declaration.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is included in {@link
 * javax.lang.model.element.VariableElement}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface FieldDeclaration extends MemberDeclaration {

    /**
     * Returns the type of this field.
     *
     * @return the type of this field
     */
    TypeMirror getType();

    /**
     * Returns the value of this field if this field is a compile-time
     * constant.  Returns <tt>null</tt> otherwise.
     * The value will be of a primitive type or <tt>String</tt>.
     * If the value is of a primitive type, it is wrapped in the
     * appropriate wrapper class (such as {@link Integer}).
     *
     * @return the value of this field if this field is a compile-time
     * constant, or <tt>null</tt> otherwise
     */
    Object getConstantValue();

    /**
     * Returns the text of a <i>constant expression</i> representing the
     * value of this field if this field is a compile-time constant.
     * Returns <tt>null</tt> otherwise.
     * The value will be of a primitive type or <tt>String</tt>.
     * The text returned is in a form suitable for representing the value
     * in source code.
     *
     * @return the text of a constant expression if this field is a
     *          compile-time constant, or <tt>null</tt> otherwise
     */
    String getConstantExpression();
}
