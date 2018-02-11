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
 * This class is intended to handle &lt;double&gt; element.
 * This element specifies {@code double} values.
 * The class {@link Double} is used as wrapper for these values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;double&gt;1.23e45&lt;/double&gt;</pre>
 * is shortcut to<pre>
 * &lt;method name="valueOf" class="java.lang.Double"&gt;
 *     &lt;string&gt;1.23e45&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * which is equivalent to {@code Double.valueOf("1.23e45")} in Java code.
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
final class DoubleElementHandler extends StringElementHandler {

    /**
     * Creates {@code double} value from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code double} value
     */
    @Override
    public Object getValue(String argument) {
        return Double.valueOf(argument);
    }
}
