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
 * This class is intended to handle &lt;int&gt; element.
 * This element specifies {@code int} values.
 * The class {@link Integer} is used as wrapper for these values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;int&gt;-1&lt;/int&gt;</pre>
 * is shortcut to<pre>
 * &lt;method name="decode" class="java.lang.Integer"&gt;
 *     &lt;string&gt;-1&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * which is equivalent to {@code Integer.decode("-1")} in Java code.
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
final class IntElementHandler extends StringElementHandler {

    /**
     * Creates {@code int} value from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code int} value
     */
    @Override
    public Object getValue(String argument) {
        return Integer.decode(argument);
    }
}
