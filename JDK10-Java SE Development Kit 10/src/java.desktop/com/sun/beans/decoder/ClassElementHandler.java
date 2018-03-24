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
 * This class is intended to handle &lt;class&gt; element.
 * This element specifies {@link Class} values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;class&gt;java.lang.Class&lt;/class&gt;</pre>
 * is shortcut to<pre>
 * &lt;method name="forName" class="java.lang.Class"&gt;
 *     &lt;string&gt;java.lang.Class&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * which is equivalent to {@code Class.forName("java.lang.Class")} in Java code.
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
final class ClassElementHandler extends StringElementHandler {

    /**
     * Creates class by the name from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code Class} value
     */
    @Override
    public Object getValue(String argument) {
        return getOwner().findClass(argument);
    }
}
