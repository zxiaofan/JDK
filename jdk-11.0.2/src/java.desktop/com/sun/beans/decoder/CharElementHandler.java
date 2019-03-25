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
 * This class is intended to handle &lt;char&gt; element.
 * This element specifies {@code char} values.
 * The class {@link Character} is used as wrapper for these values.
 * The result value is created from text of the body of this element.
 * The body parsing is described in the class {@link StringElementHandler}.
 * For example:<pre>
 * &lt;char&gt;X&lt;/char&gt;</pre>
 * which is equivalent to {@code Character.valueOf('X')} in Java code.
 * <p>The following attributes are supported:
 * <dl>
 * <dt>code
 * <dd>this attribute specifies character code
 * <dt>id
 * <dd>the identifier of the variable that is intended to store the result
 * </dl>
 * The {@code code} attribute can be used for characters
 * that are illegal in XML document, for example:<pre>
 * &lt;char code="0"/&gt;</pre>
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
final class CharElementHandler extends StringElementHandler {

    /**
     * Parses attributes of the element.
     * The following attributes are supported:
     * <dl>
     * <dt>code
     * <dd>this attribute specifies character code
     * <dt>id
     * <dd>the identifier of the variable that is intended to store the result
     * </dl>
     *
     * @param name   the attribute name
     * @param value  the attribute value
     */
    @Override
    public void addAttribute(String name, String value) {
        if (name.equals("code")) { // NON-NLS: the attribute name
            int code = Integer.decode(value);
            for (char ch : Character.toChars(code)) {
                addCharacter(ch);
            }
        } else {
            super.addAttribute(name, value);
        }
    }

    /**
     * Creates {@code char} value from
     * the text of the body of this element.
     *
     * @param argument  the text of the body
     * @return evaluated {@code char} value
     */
    @Override
    public Object getValue(String argument) {
        if (argument.length() != 1) {
            throw new IllegalArgumentException("Wrong characters count");
        }
        return Character.valueOf(argument.charAt(0));
    }
}
