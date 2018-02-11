/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.builders;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.tools.doclets.internal.toolkit.*;
import com.sun.tools.doclets.internal.toolkit.util.*;

/**
 * Parse the XML that specified the order of operation for the builders.  This
 * Parser uses SAX parsing.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @since 1.5
 * @see SAXParser
 */
@Deprecated
public class LayoutParser extends DefaultHandler {

    /**
     * The map of XML elements that have been parsed.
     */
    private Map<String,XMLNode> xmlElementsMap;
    private XMLNode currentNode;
    private final Configuration configuration;
    private String currentRoot;
    private boolean isParsing;

    private LayoutParser(Configuration configuration) {
        xmlElementsMap = new HashMap<>();
        this.configuration = configuration;
    }

    /**
     * Return an instance of the BuilderXML.
     *
     * @param configuration the current configuration of the doclet.
     * @return an instance of the BuilderXML.
     */
    public static LayoutParser getInstance(Configuration configuration) {
        return new LayoutParser(configuration);
    }

    /**
     * Parse the XML specifying the layout of the documentation.
     *
     * @return the list of XML elements parsed.
     */
    public XMLNode parseXML(String root) {
        if (xmlElementsMap.containsKey(root)) {
            return xmlElementsMap.get(root);
        }
        try {
            currentRoot = root;
            isParsing = false;
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            InputStream in = configuration.getBuilderXML();
            saxParser.parse(in, this);
            return xmlElementsMap.get(root);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new DocletAbortException(t);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startElement(String namespaceURI, String sName, String qName,
        Attributes attrs)
    throws SAXException {
        if (isParsing || qName.equals(currentRoot)) {
            isParsing = true;
            currentNode = new XMLNode(currentNode, qName);
            for (int i = 0; i < attrs.getLength(); i++)
                currentNode.attrs.put(attrs.getLocalName(i), attrs.getValue(i));
            if (qName.equals(currentRoot))
                xmlElementsMap.put(qName, currentNode);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endElement(String namespaceURI, String sName, String qName)
    throws SAXException {
        if (! isParsing) {
            return;
        }
        currentNode = currentNode.parent;
        isParsing = ! qName.equals(currentRoot);
    }
}
