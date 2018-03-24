/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.istack.internal.SAXParseException2;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.XMLFilterImpl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * XMLFilter that finds references to other schema files from
 * SAX events.
 * <p>
 * This implementation is a base implementation for typical case
 * where we just need to look for a particular attribute which
 * contains an URL to another schema file.
 *
 * @author Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public abstract class AbstractReferenceFinderImpl extends XMLFilterImpl {

    protected final DOMForest parent;

    protected AbstractReferenceFinderImpl(DOMForest _parent) {
        this.parent = _parent;
    }

    /**
     * IF the given element contains a reference to an external resource,
     * return its URL.
     *
     * @param nsURI     Namespace URI of the current element
     * @param localName Local name of the current element
     * @return It's OK to return a relative URL.
     */
    protected abstract String findExternalResource(String nsURI, String localName, Attributes atts);

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
            throws SAXException {
        super.startElement(namespaceURI, localName, qName, atts);

        String relativeRef = findExternalResource(namespaceURI, localName, atts);
        if (relativeRef == null) {
            return; // not found
        }
        try {
            // absolutize URL.
            String lsi = locator.getSystemId();
            String ref;
            URI relRefURI = new URI(relativeRef);
            if (relRefURI.isAbsolute())
                ref = relativeRef;
            else {
                if (lsi.startsWith("jar:")) {
                    int bangIdx = lsi.indexOf('!');
                    if (bangIdx > 0) {
                        ref = lsi.substring(0, bangIdx + 1)
                                + new URI(lsi.substring(bangIdx + 1)).resolve(new URI(relativeRef)).toString();
                    } else {
                        ref = relativeRef;
                    }
                } else {
                    ref = new URI(lsi).resolve(new URI(relativeRef)).toString();
                }
            }

            // then parse this schema as well,
            // but don't mark this document as a root.
            if (parent != null) { // this is there to allow easier testing
                parent.parse(ref, false);
            }
        } catch (URISyntaxException e) {
            String msg = e.getMessage();
            if (new File(relativeRef).exists()) {
                msg = Messages.format(Messages.ERR_FILENAME_IS_NOT_URI) + ' ' + msg;
            }

            SAXParseException spe = new SAXParseException2(
                    Messages.format(Messages.ERR_UNABLE_TO_PARSE, relativeRef, msg),
                    locator, e);

            fatalError(spe);
            throw spe;
        } catch (IOException e) {
            SAXParseException spe = new SAXParseException2(
                    Messages.format(Messages.ERR_UNABLE_TO_PARSE, relativeRef, e.getMessage()),
                    locator, e);

            fatalError(spe);
            throw spe;
        }
    }

    private Locator locator;

    @Override
    public void setDocumentLocator(Locator locator) {
        super.setDocumentLocator(locator);
        this.locator = locator;
    }
}
