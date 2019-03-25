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
 * Represents a field in a java class.
 *
 * @see MemberDoc
 *
 * @since 1.2
 * @author Robert Field
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public interface FieldDoc extends MemberDoc {

    /**
     * Get type of this field.
     *
     * @return the type of this field.
     */
    Type type();

    /**
     * Return true if this field is transient
     *
     * @return true if this field is transient
     */
    boolean isTransient();

    /**
     * Return true if this field is volatile
     *
     * @return true if this field is volatile
     */
    boolean isVolatile();

    /**
     * Return the serialField tags in this FieldDoc item.
     *
     * @return an array of {@code SerialFieldTag} objects containing
     *         all {@code @serialField} tags.
     */
    SerialFieldTag[] serialFieldTags();

    /**
     * Get the value of a constant field.
     *
     * @return the value of a constant field. The value is
     * automatically wrapped in an object if it has a primitive type.
     * If the field is not constant, returns null.
     */
    Object constantValue();

    /**
     * Get the value of a constant field.
     *
     * @return the text of a Java language expression whose value
     * is the value of the constant. The expression uses no identifiers
     * other than primitive literals. If the field is
     * not constant, returns null.
     */
    String constantValueExpression();
}
