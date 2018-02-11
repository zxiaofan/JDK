/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.tools;

import com.sun.xml.internal.fastinfoset.Decoder;
import com.sun.xml.internal.fastinfoset.sax.SAXDocumentParser;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class FI_SAX_Or_XML_SAX_SAXEvent extends TransformInputOutput {

    public FI_SAX_Or_XML_SAX_SAXEvent() {
    }

    public void parse(InputStream document, OutputStream events, String workingDirectory) throws Exception {
        if (!document.markSupported()) {
            document = new BufferedInputStream(document);
        }

        document.mark(4);
        boolean isFastInfosetDocument = Decoder.isFastInfosetDocument(document);
        document.reset();

        if (isFastInfosetDocument) {
            SAXDocumentParser parser = new SAXDocumentParser();
            SAXEventSerializer ses = new SAXEventSerializer(events);
            parser.setContentHandler(ses);
            parser.setProperty(Properties.LEXICAL_HANDLER_PROPERTY, ses);
            parser.parse(document);
        } else {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser parser = parserFactory.newSAXParser();
            SAXEventSerializer ses = new SAXEventSerializer(events);

            XMLReader reader = parser.getXMLReader();
            reader.setProperty("http://xml.org/sax/properties/lexical-handler", ses);
            reader.setContentHandler(ses);
            if (workingDirectory != null) {
                reader.setEntityResolver(createRelativePathResolver(workingDirectory));
            }
            reader.parse(new InputSource(document));
        }
    }

    public void parse(InputStream document, OutputStream events) throws Exception {
        parse(document, events, null);
    }

    public static void main(String[] args) throws Exception {
        FI_SAX_Or_XML_SAX_SAXEvent p = new FI_SAX_Or_XML_SAX_SAXEvent();
        p.parse(args);
    }
}
