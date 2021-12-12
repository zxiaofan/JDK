/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

import java.util.List;
import javax.lang.model.element.Name;

/**
 * A tree node for an attribute in an HTML element.
 *
 * @since 1.8
 */
public interface AttributeTree extends DocTree {
    /**
     * The kind of an attribute value.
     */
    enum ValueKind {
        /** The attribute value is empty. */
        EMPTY,
        /** The attribute value is not enclosed in quotes. */
        UNQUOTED,
        /** The attribute value is enclosed in single quotation marks. */
        SINGLE,
        /** The attribute value is enclosed in double quotation marks. */
        DOUBLE
    }

    /**
     * Returns the name of the attribute.
     * @return the name of the attribute
     */
    Name getName();

    /**
     * Returns the kind of the attribute value.
     * @return the kind of the attribute value
     */
    ValueKind getValueKind();

    /**
     * Returns the value of the attribute, or {@code null} if the
     * {@linkplain #getValueKind() kind of this attribute} is {@code EMPTY}.
     * @return the value of the attribute
     */
    List<? extends DocTree> getValue();
}
