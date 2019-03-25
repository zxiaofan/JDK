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
 * This class is intended to handle &lt;long&gt; element.
 * This element specifies {@code long} values.
 * The class {@link Long} is used as wrapper for these values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;long&gt;0xFFFF&lt;/long&gt;</pre>
 * is shortcut to<pre>
 * &lt;method name="decode" class="java.lang.Long"&gt;
 *     &lt;string&gt;0xFFFF&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * which is equivalent to {@code Long.decode("0xFFFF")} in Java code.
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
final class LongElementHandler extends StringElementHandler {

    /**
     * Creates {@code long} value from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code long} value
     */
    @Override
    public Object getValue(String argument) {
        return Long.decode(argument);
    }
}
