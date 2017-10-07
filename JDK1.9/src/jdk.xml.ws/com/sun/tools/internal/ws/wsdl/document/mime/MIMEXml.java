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

package com.sun.tools.internal.ws.wsdl.document.mime;

import com.sun.tools.internal.ws.wsdl.framework.ExtensionImpl;
import org.xml.sax.Locator;

import javax.xml.namespace.QName;

/**
 * A MIME mimeXml extension.
 *
 * @author WS Development Team
 */
public class MIMEXml extends ExtensionImpl {

    public MIMEXml(Locator locator) {
        super(locator);
    }

    public QName getElementName() {
        return MIMEConstants.QNAME_MIME_XML;
    }

    public String getPart() {
        return _part;
    }

    public void setPart(String s) {
        _part = s;
    }

    public void validateThis() {
    }

    private String _part;
}
