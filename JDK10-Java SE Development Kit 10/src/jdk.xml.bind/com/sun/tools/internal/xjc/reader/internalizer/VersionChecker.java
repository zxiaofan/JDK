/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.internalizer;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import com.sun.tools.internal.xjc.reader.Const;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * Checks the jaxb:version attribute on a XML Schema document.
 *
 * jaxb:version is optional if no binding customization is used,
 * but if present, its value must be "1.0".
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class VersionChecker extends XMLFilterImpl {

    /**
     * We store the value of the version attribute in this variable
     * when we hit the root element.
     */
    private String version = null ;

    /** Will be set to true once we hit the root element. */
    private boolean seenRoot = false;

    /** Will be set to true once we hit a binding declaration. */
    private boolean seenBindings = false;

    private Locator locator;

    /**
     * Stores the location of the start tag of the root tag.
     */
    private Locator rootTagStart;

    public VersionChecker( XMLReader parent ) {
        setParent(parent);
    }

    public VersionChecker( ContentHandler handler,ErrorHandler eh,EntityResolver er ) {
        setContentHandler(handler);
        if(eh!=null)    setErrorHandler(eh);
        if(er!=null)    setEntityResolver(er);
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
        throws SAXException {

        super.startElement(namespaceURI, localName, qName, atts);

        if(!seenRoot) {
            // if this is the root element
            seenRoot = true;
            rootTagStart = new LocatorImpl(locator);

            version = atts.getValue(Const.JAXB_NSURI,"version");
            if( namespaceURI.equals(Const.JAXB_NSURI) ) {
                String version2 = atts.getValue("","version");
                if( version!=null && version2!=null ) {
                    // we have both @version and @jaxb:version. error.
                    SAXParseException e = new SAXParseException(
                        Messages.format( Messages.TWO_VERSION_ATTRIBUTES ), locator );
                    getErrorHandler().error(e);
                }
                if( version==null )
                    version = version2;
            }

        }

        if( Const.JAXB_NSURI.equals(namespaceURI) )
            seenBindings = true;
    }

    public void endDocument() throws SAXException {
        super.endDocument();

        if( seenBindings && version==null ) {
            // if we see a binding declaration but not version attribute
            SAXParseException e = new SAXParseException(
                Messages.format(Messages.ERR_VERSION_NOT_FOUND),rootTagStart);
            getErrorHandler().error(e);
        }

        // if present, the value must be either 1.0 or 2.0
        if( version!=null && !VERSIONS.contains(version) ) {
            SAXParseException e = new SAXParseException(
                Messages.format(Messages.ERR_INCORRECT_VERSION),rootTagStart);
            getErrorHandler().error(e);
        }
    }

    public void setDocumentLocator(Locator locator) {
        super.setDocumentLocator(locator);
        this.locator = locator;
    }

    private static final Set<String> VERSIONS = new HashSet<String>(Arrays.asList("1.0","2.0","2.1"));

}
