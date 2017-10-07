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
 * This class is intended to handle &lt;float&gt; element.
 * This element specifies {@code float} values.
 * The class {@link Float} is used as wrapper for these values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;float&gt;-1.23&lt;/float&gt;</pre>
 * is shortcut to<pre>
 * &lt;method name="valueOf" class="java.lang.Float"&gt;
 *     &lt;string&gt;-1.23&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * which is equivalent to {@code Float.valueOf("-1.23")} in Java code.
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
final class FloatElementHandler extends StringElementHandler {

    /**
     * Creates {@code float} value from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code float} value
     */
    @Override
    public Object getValue(String argument) {
        return Float.valueOf(argument);
    }
}
