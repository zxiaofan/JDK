/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the Java API for XML Processing (JAXP), the Streaming API for XML (StAX),
 * the Simple API for XML (SAX), and the W3C Document Object Model (DOM) API.
 *
 * @uses javax.xml.datatype.DatatypeFactory
 * @uses javax.xml.parsers.DocumentBuilderFactory
 * @uses javax.xml.parsers.SAXParserFactory
 * @uses javax.xml.stream.XMLEventFactory
 * @uses javax.xml.stream.XMLInputFactory
 * @uses javax.xml.stream.XMLOutputFactory
 * @uses javax.xml.transform.TransformerFactory
 * @uses javax.xml.validation.SchemaFactory
 * @uses javax.xml.xpath.XPathFactory
 * @uses org.xml.sax.XMLReader
 *
 * @moduleGraph
 * @since 9
 */
module java.xml {
    exports javax.xml;
    exports javax.xml.catalog;
    exports javax.xml.datatype;
    exports javax.xml.namespace;
    exports javax.xml.parsers;
    exports javax.xml.stream;
    exports javax.xml.stream.events;
    exports javax.xml.stream.util;
    exports javax.xml.transform;
    exports javax.xml.transform.dom;
    exports javax.xml.transform.sax;
    exports javax.xml.transform.stax;
    exports javax.xml.transform.stream;
    exports javax.xml.validation;
    exports javax.xml.xpath;
    exports org.w3c.dom;
    exports org.w3c.dom.bootstrap;
    exports org.w3c.dom.events;
    exports org.w3c.dom.ls;
    exports org.w3c.dom.ranges;
    exports org.w3c.dom.traversal;
    exports org.w3c.dom.views;
    exports org.xml.sax;
    exports org.xml.sax.ext;
    exports org.xml.sax.helpers;

    exports com.sun.org.apache.xml.internal.dtm to
        java.xml.crypto;
    exports com.sun.org.apache.xml.internal.utils to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.compiler to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.functions to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.objects to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.res to
        java.xml.crypto;

    uses javax.xml.datatype.DatatypeFactory;
    uses javax.xml.parsers.DocumentBuilderFactory;
    uses javax.xml.parsers.SAXParserFactory;
    uses javax.xml.stream.XMLEventFactory;
    uses javax.xml.stream.XMLInputFactory;
    uses javax.xml.stream.XMLOutputFactory;
    uses javax.xml.transform.TransformerFactory;
    uses javax.xml.validation.SchemaFactory;
    uses javax.xml.xpath.XPathFactory;
    uses org.xml.sax.XMLReader;
}
