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
 * This class is intended to handle &lt;var&gt; element.
 * This element retrieves the value of specified variable.
 * For example:<pre>
 * &lt;var id="id1" idref="id2"/&gt;</pre>
 * is equivalent to {@code id1 = id2} in Java code.
 * <p>The following attributes are supported:
 * <dl>
 * <dt>idref
 * <dd>the identifier to refer to the variable
 * <dt>id
 * <dd>the identifier of the variable that is intended to store the result
 * </dl>
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
final class VarElementHandler extends ElementHandler {
    private ValueObject value;

    /**
     * Parses attributes of the element.
     * The following attributes are supported:
     * <dl>
     * <dt>idref
     * <dd>the identifier to refer to the variable
     * <dt>id
     * <dd>the identifier of the variable that is intended to store the result
     * </dl>
     *
     * @param name   the attribute name
     * @param value  the attribute value
     */
    @Override
    public void addAttribute(String name, String value) {
        if (name.equals("idref")) { // NON-NLS: the attribute name
            this.value = ValueObjectImpl.create(getVariable(value));
        } else {
            super.addAttribute(name, value);
        }
    }

    /**
     * Returns the value of this element.
     *
     * @return the value of this element
     */
    @Override
    protected ValueObject getValueObject() {
        if (this.value == null) {
            throw new IllegalArgumentException("Variable name is not set");
        }
        return this.value;
    }
}
