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

package com.sun.xml.internal.ws.api.wsdl.parser;

import com.sun.xml.internal.ws.api.server.SDDocumentSource;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.net.URL;

/**
 * Resolves a reference to {@link XMLStreamReader}.
 *
 * This is kinda like {@link EntityResolver} but works
 * at the XML infoset level.
 *
 * @author Kohsuke Kawaguchi
 */
public interface XMLEntityResolver {
    /**
     * See {@link EntityResolver#resolveEntity(String, String)} for the contract.
     */
    Parser resolveEntity(String publicId,String systemId)
        throws SAXException, IOException, XMLStreamException;

    public static final class Parser {
        /**
         * System ID of the document being parsed.
         */
        public final URL systemId;
        /**
         * The parser instance parsing the infoset.
         */
        public final XMLStreamReader parser;

        public Parser(URL systemId, XMLStreamReader parser) {
            assert parser!=null;
            this.systemId = systemId;
            this.parser = parser;
        }

        /**
         * Creates a {@link Parser} that reads from {@link SDDocumentSource}.
         */
        public Parser(SDDocumentSource doc) throws IOException, XMLStreamException {
            this.systemId = doc.getSystemId();
            this.parser = doc.read();
        }

    }
}
