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
 * This class is intended to handle &lt;void&gt; element.
 * This element looks like &lt;object&gt; element,
 * but its value is not used as an argument for element
 * that contains this one.
 * <p>The following attributes are supported:
 * <dl>
 * <dt>class
 * <dd>the type is used for static methods and fields
 * <dt>method
 * <dd>the method name
 * <dt>property
 * <dd>the property name
 * <dt>index
 * <dd>the property index
 * <dt>field
 * <dd>the field name
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
final class VoidElementHandler extends ObjectElementHandler {

    /**
     * Tests whether the value of this element can be used
     * as an argument of the element that contained in this one.
     *
     * @return {@code true} if the value of this element should be used
     *         as an argument of the element that contained in this one,
     *         {@code false} otherwise
     */
    @Override
    protected boolean isArgument() {
        return false; // hack for compatibility
    }
}
