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

package com.sun.tools.internal.ws.wsdl.document.soap;

import com.sun.tools.internal.ws.wsdl.framework.ExtensionImpl;
import com.sun.tools.internal.ws.wsdl.framework.ValidationException;
import org.xml.sax.Locator;

import javax.xml.namespace.QName;

/**
 * A SOAP body extension.
 *
 * @author WS Development Team
 */
public class SOAPBody extends ExtensionImpl {

    public SOAPBody(Locator locator) {
        super(locator);
    }

    public QName getElementName() {
        return SOAPConstants.QNAME_BODY;
    }

    public String getNamespace() {
        return _namespace;
    }

    public void setNamespace(String s) {
        _namespace = s;
    }

    public SOAPUse getUse() {
        return _use;
    }

    public void setUse(SOAPUse u) {
        _use = u;
    }

    public boolean isEncoded() {
        return _use == SOAPUse.ENCODED;
    }

    public boolean isLiteral() {
        return _use == SOAPUse.LITERAL;
    }

    public String getEncodingStyle() {
        return _encodingStyle;
    }

    public void setEncodingStyle(String s) {
        _encodingStyle = s;
    }

    public String getParts() {
        return _parts;
    }

    public void setParts(String s) {
        _parts = s;
    }

    public void validateThis() {
        if(_use == SOAPUse.ENCODED) {
            throw new ValidationException("validation.unsupportedUse.encoded", getLocator().getLineNumber(),getLocator().getSystemId());
        }
    }

    private String _encodingStyle;
    private String _namespace;
    private String _parts;
    private SOAPUse _use=SOAPUse.LITERAL;
}
