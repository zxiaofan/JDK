/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.model.wsdl;

/**
 * Enumeration that tells a wsdl:part that can be defined either using a type
 * attribute or an element attribute.
 *
 * @author Vivek Pandey
 */
public enum WSDLDescriptorKind {
    /**
     * wsdl:part is defined using element attribute.
     *
     * <pre>
     * for exmaple,
     * &lt;wsdl:part name="foo" element="ns1:FooElement">
     * </pre>
     */
    ELEMENT(0),

    /**
     * wsdl:part is defined using type attribute.
     *
     * <pre>
     * for exmaple,
     * &lt;wsdl:part name="foo" element="ns1:FooType">
     * </pre>
     */
    TYPE(1);

    WSDLDescriptorKind(int value) {
        this.value = value;
    }

    private final int value;
}
