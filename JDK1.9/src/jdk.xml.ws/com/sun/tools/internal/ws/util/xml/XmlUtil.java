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

package com.sun.tools.internal.ws.util.xml;

import com.sun.tools.internal.ws.util.WSDLParseException;
import org.w3c.dom.Element;

/**
 * @author WS Development Team
 */
public class XmlUtil extends com.sun.xml.internal.ws.util.xml.XmlUtil {

    public static boolean matchesTagNS(Element e, String tag, String nsURI) {
        try {
            return e.getLocalName().equals(tag)
                && e.getNamespaceURI().equals(nsURI);
        } catch (NullPointerException npe) {

            // localname not null since parsing would fail before here
            throw new WSDLParseException(
                "null.namespace.found",
                e.getLocalName());
        }
    }

    public static boolean matchesTagNS(
        Element e,
        javax.xml.namespace.QName name) {
        try {
            return e.getLocalName().equals(name.getLocalPart())
                && e.getNamespaceURI().equals(name.getNamespaceURI());
        } catch (NullPointerException npe) {

            // localname not null since parsing would fail before here
            throw new WSDLParseException(
                "null.namespace.found",
                e.getLocalName());
        }
    }
}
