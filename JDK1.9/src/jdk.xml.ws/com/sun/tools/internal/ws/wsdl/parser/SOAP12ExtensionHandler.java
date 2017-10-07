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

package com.sun.tools.internal.ws.wsdl.parser;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAP12Binding;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAP12Constants;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPBinding;
import org.xml.sax.Locator;

import javax.xml.namespace.QName;
import java.util.Map;


public class SOAP12ExtensionHandler extends SOAPExtensionHandler {
    public SOAP12ExtensionHandler(Map<String, AbstractExtensionHandler> extensionHandlerMap) {
        super(extensionHandlerMap);
    }

    /*
     * @see SOAPExtensionHandler#getNamespaceURI()
     */
    @Override
    public String getNamespaceURI() {
        return Constants.NS_WSDL_SOAP12;
    }

    /*
     * @see SOAPExtensionHandler#getAddressQName()
     */
    @Override
    protected QName getAddressQName() {
        return SOAP12Constants.QNAME_ADDRESS;
    }

    /*
     * @see SOAPExtensionHandler#getBindingQName()
     */
    @Override
    protected QName getBindingQName() {
        return SOAP12Constants.QNAME_BINDING;
    }

    @Override protected SOAPBinding getSOAPBinding(Locator location) {
        return new SOAP12Binding(location);
    }

    /*
     * @see SOAPExtensionHandler#getBodyQName()
     */
    @Override
    protected QName getBodyQName() {
        return SOAP12Constants.QNAME_BODY;
    }

    /*
     * @see SOAPExtensionHandler#getFaultQName()
     */
    @Override
    protected QName getFaultQName() {
        return SOAP12Constants.QNAME_FAULT;
    }

    /*
     * @see SOAPExtensionHandler#getHeaderfaultQName()
     */
    @Override
    protected QName getHeaderfaultQName() {
        return SOAP12Constants.QNAME_HEADERFAULT;
    }

    /*
     * @see SOAPExtensionHandler#getHeaderQName()
     */
    @Override
    protected QName getHeaderQName() {
        return SOAP12Constants.QNAME_HEADER;
    }

    /*
     * @see SOAPExtensionHandler#getOperationQName()
     */
    @Override
    protected QName getOperationQName() {
        return SOAP12Constants.QNAME_OPERATION;
    }
}
