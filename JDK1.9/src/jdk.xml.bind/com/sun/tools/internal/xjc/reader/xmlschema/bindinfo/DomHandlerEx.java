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

package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;

import com.sun.xml.internal.bind.marshaller.SAX2DOMEx;

import com.sun.xml.internal.bind.v2.util.XmlFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * {@link DomHandler} that produces a W3C DOM but with a location information.
 *
 * @author Kohsuke Kawaguchi
 */
final class DomHandlerEx implements DomHandler<DomHandlerEx.DomAndLocation,DomHandlerEx.ResultImpl> {

    public static final class DomAndLocation {
        public final Element element;
        public final Locator loc;

        public DomAndLocation(Element element, Locator loc) {
            this.element = element;
            this.loc = loc;
        }
    }

    public ResultImpl createUnmarshaller(ValidationEventHandler errorHandler) {
        return new ResultImpl();
    }

    public DomAndLocation getElement(ResultImpl r) {
        return new DomAndLocation( ((Document)r.s2d.getDOM()).getDocumentElement(), r.location );
    }

    public Source marshal(DomAndLocation domAndLocation, ValidationEventHandler errorHandler) {
        return new DOMSource(domAndLocation.element);
    }

    public static final class ResultImpl extends SAXResult {
        final SAX2DOMEx s2d;

        Locator location = null;

        ResultImpl() {
            try {
                DocumentBuilderFactory factory = XmlFactory.createDocumentBuilderFactory(false); // safe - only used for BI
                s2d = new SAX2DOMEx(factory);
            } catch (ParserConfigurationException e) {
                throw new AssertionError(e);    // impossible
            }

            XMLFilterImpl f = new XMLFilterImpl() {
                @Override
                public void setDocumentLocator(Locator locator) {
                    super.setDocumentLocator(locator);
                    location = new LocatorImpl(locator);
                }
            };
            f.setContentHandler(s2d);

            setHandler(f);
        }

    }
}
