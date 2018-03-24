/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.decoder;

/**
 * This class is intended to handle &lt;null&gt; element.
 * This element specifies {@code null} value.
 * It should not contain body or inner elements.
 * For example:<pre>
 * &lt;null/&gt;</pre>
 * is equivalent to {@code null} in Java code.
 * <p>The following attribute is supported:
 * <dl>
 * <dt>id
 * <dd>the identifier of the variable that is intended to store the result
 * </dl>
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
class NullElementHandler extends ElementHandler implements ValueObject {

    /**
     * Returns the value of this element.
     *
     * @return the value of this element
     */
    @Override
    protected final ValueObject getValueObject() {
        return this;
    }

    /**
     * Returns {@code null}
     * as a value of &lt;null&gt; element.
     * This method should be overridden in those handlers
     * that extend behavior of this element.
     *
     * @return {@code null} by default
     */
    public Object getValue() {
        return null;
    }

    /**
     * Returns {@code void} state of this value object.
     *
     * @return {@code false} always
     */
    public final boolean isVoid() {
        return false;
    }
}
