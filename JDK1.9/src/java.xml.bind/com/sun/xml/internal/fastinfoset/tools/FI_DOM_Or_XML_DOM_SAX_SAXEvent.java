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
import com.sun.xml.internal.fastinfoset.dom.DOMDocumentParser;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import org.w3c.dom.Document;

public class FI_DOM_Or_XML_DOM_SAX_SAXEvent extends TransformInputOutput {

    public void parse(InputStream document, OutputStream events, String workingDirectory) throws Exception {
        if (!document.markSupported()) {
            document = new BufferedInputStream(document);
        }

        document.mark(4);
        boolean isFastInfosetDocument = Decoder.isFastInfosetDocument(document);
        document.reset();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document d;
        if (isFastInfosetDocument) {
            d = db.newDocument();
            DOMDocumentParser ddp = new DOMDocumentParser();
            ddp.parse(d, document);
        } else {
            if (workingDirectory != null) {
                db.setEntityResolver(createRelativePathResolver(workingDirectory));
            }
            d = db.parse(document);
        }

        SAXEventSerializer ses = new SAXEventSerializer(events);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(new DOMSource(d), new SAXResult(ses));
    }

    public void parse(InputStream document, OutputStream events) throws Exception {
        parse(document, events, null);
    }

    public static void main(String[] args) throws Exception {
        FI_DOM_Or_XML_DOM_SAX_SAXEvent p = new FI_DOM_Or_XML_DOM_SAX_SAXEvent();
        p.parse(args);
    }

}
