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
 * This class is intended to handle &lt;boolean&gt; element.
 * This element specifies {@code boolean} values.
 * The class {@link Boolean} is used as wrapper for these values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;boolean&gt;true&lt;/boolean&gt;</pre>
 * is shortcut to<pre>
 * &lt;method name="valueOf" class="java.lang.Boolean"&gt;
 *     &lt;string&gt;true&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * which is equivalent to {@code Boolean.valueOf("true")} in Java code.
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
final class BooleanElementHandler extends StringElementHandler {

    /**
     * Creates {@code boolean} value from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code boolean} value
     */
    @Override
    public Object getValue(String argument) {
        if (Boolean.TRUE.toString().equalsIgnoreCase(argument)) {
            return Boolean.TRUE;
        }
        if (Boolean.FALSE.toString().equalsIgnoreCase(argument)) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException("Unsupported boolean argument: " + argument);
    }
}
