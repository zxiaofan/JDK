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

package com.sun.xml.internal.ws.util.xml;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.sax.SAXResult;

/**
 * A JAXP {@link javax.xml.transform.Result} implementation that produces
 * a result on the specified {@link javax.xml.stream.XMLStreamWriter} or
 * {@link javax.xml.stream.XMLEventWriter}.
 *
 * <p>
 * Please note that you may need to call flush() on the underlying
 * XMLStreamWriter or XMLEventWriter after the transform is complete.
 * <p>
 *
 * The fact that JAXBResult derives from SAXResult is an implementation
 * detail. Thus in general applications are strongly discouraged from
 * accessing methods defined on SAXResult.
 *
 * <p>
 * In particular it shall never attempt to call the following methods:
 *
 * <ul>
 *    <li>setHandler</li>
 *    <li>setLexicalHandler</li>
 *    <li>setSystemId</li>
 * </ul>
 *
 * <p>
 * Example:
 *
 * <pre>
    // create a DOMSource
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(...);
    Source domSource = new DOMSource(doc);

    // create a StAXResult
    XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
    Result staxResult = new StAXResult(writer);

    // run the transform
    TransformerFactory.newInstance().newTransformer().transform(domSource, staxResult);
 * </pre>
 *
 * @author Ryan.Shoemaker@Sun.COM
 * @version 1.0
 */
public class StAXResult extends SAXResult {

    /**
     * Create a new {@link javax.xml.transform.Result} that produces
     * a result on the specified {@link javax.xml.stream.XMLStreamWriter}
     *
     * @param writer the XMLStreamWriter
     * @throws IllegalArgumentException iff the writer is null
     */
    public StAXResult(XMLStreamWriter writer) {
        if( writer == null ) {
            throw new IllegalArgumentException();
        }

        super.setHandler(new ContentHandlerToXMLStreamWriter( writer ));
    }
}
