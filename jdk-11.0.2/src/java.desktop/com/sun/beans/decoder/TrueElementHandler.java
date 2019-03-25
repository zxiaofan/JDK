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
 * This class is intended to handle &lt;true&gt; element.
 * This element specifies {@code true} value.
 * It should not contain body or inner elements.
 * For example:<pre>
 * &lt;true/&gt;</pre>
 * is equivalent to {@code true} in Java code.
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
final class TrueElementHandler extends NullElementHandler {

    /**
     * Returns {@code Boolean.TRUE}
     * as a value of &lt;true&gt; element.
     *
     * @return {@code Boolean.TRUE} by default
     */
    @Override
    public Object getValue() {
        return Boolean.TRUE;
    }
}
