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

import com.sun.xml.internal.fastinfoset.stax.StAXDocumentSerializer;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class XML_SAX_StAX_FI extends TransformInputOutput {

    public XML_SAX_StAX_FI() {
    }

    public void parse(InputStream xml, OutputStream finf, String workingDirectory) throws Exception {
        StAXDocumentSerializer documentSerializer = new StAXDocumentSerializer();
        documentSerializer.setOutputStream(finf);

        SAX2StAXWriter saxTostax = new SAX2StAXWriter(documentSerializer);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        SAXParser saxParser = saxParserFactory.newSAXParser();

        XMLReader reader = saxParser.getXMLReader();
        reader.setProperty("http://xml.org/sax/properties/lexical-handler", saxTostax);
        reader.setContentHandler(saxTostax);

        if (workingDirectory != null) {
            reader.setEntityResolver(createRelativePathResolver(workingDirectory));
        }
        reader.parse(new InputSource(xml));

        xml.close();
        finf.close();
    }

    public void parse(InputStream xml, OutputStream finf) throws Exception {
        parse(xml, finf, null);
    }

    public static void main(String[] args) throws Exception {
        XML_SAX_StAX_FI s = new XML_SAX_StAX_FI();
        s.parse(args);
    }

}
