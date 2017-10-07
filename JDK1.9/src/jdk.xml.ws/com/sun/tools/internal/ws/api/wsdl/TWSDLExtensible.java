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

package com.sun.tools.internal.ws.api.wsdl;


import javax.xml.namespace.QName;

/**
 * A WSDL element or attribute that can be extended.
 *
 * @author Vivek Pandey
 * @deprecated This interface is deprecated, will be removed in JAX-WS 2.2 RI.
 *
 */
public interface TWSDLExtensible {
    /**
     * Gives the wsdl extensiblity element's name attribute value. It can be null as @name on some of the wsdl
     * extensibility elements are optinal such as wsdl:input
     */
    String getNameValue();

    /**
     * Gives namespace URI of a wsdl extensibility element.
     */
    String getNamespaceURI();

    /**
     * Gives the WSDL element or WSDL extensibility element name
     */
    QName getWSDLElementName();

    /**
     * An {@link TWSDLExtensionHandler} will call this method to add an {@link TWSDLExtension} object
     *
     * @param e non-null extension object
     */
    void addExtension(TWSDLExtension e);

    /**
     * Gives iterator over {@link TWSDLExtension}s
     */
    Iterable<? extends TWSDLExtension> extensions();

    /**
     * Gives the parent of a wsdl extensibility element.
     * <pre>
     * For example,
     *
     *     <wsdl:portType>
     *         <wsdl:operation>
     *     ...
     * Here, the {@link TWSDLExtensible}representing wsdl:operation's parent would be wsdl:portType
     *
     * @return null if the {@link TWSDLExtensible} has no parent, root of wsdl document - wsdl:definition.
     */
    TWSDLExtensible getParent();
}
