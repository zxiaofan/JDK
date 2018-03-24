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

import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

import com.sun.xml.internal.xsom.parser.XMLParser;

/**
 * {@link XMLParser} implementation that
 * parses XML from a DOM forest instead of parsing it from
 * its original location.
 *
 * @author Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 * @author Vivek Pandey
 */
public class DOMForestParser implements XMLParser {

    /**
     * DOM forest to be "parsed".
     */
    private final DOMForest forest;

    /**
     * Scanner object will do the actual SAX events generation.
     */
    private final DOMForestScanner scanner;

    private final XMLParser fallbackParser;

    /**
     * @param fallbackParser This parser will be used when DOMForestParser needs to parse
     *                       documents that are not in the forest.
     */
    public DOMForestParser(DOMForest forest, XMLParser fallbackParser) {
        this.forest = forest;
        this.scanner = new DOMForestScanner(forest);
        this.fallbackParser = fallbackParser;
    }


    public void parse(InputSource source, ContentHandler handler,  EntityResolver entityResolver, ErrorHandler errHandler) throws SAXException, IOException {

    }

    public void parse(InputSource source, ContentHandler handler, ErrorHandler errorHandler, EntityResolver entityResolver)

            throws SAXException, IOException {
        String systemId = source.getSystemId();
        Document dom = forest.get(systemId);

        if (dom == null) {
            // if no DOM tree is built for it,
            // let the fall back parser parse the original document.
            //
            // for example, XSOM parses datatypes.xsd (XML Schema part 2)
            // but this will never be built into the forest.
            fallbackParser.parse(source, handler, errorHandler, entityResolver);
            return;
        }

        scanner.scan(dom, handler);

    }
}
