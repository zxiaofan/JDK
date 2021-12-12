/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.jfc.model;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.InputSource;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import jdk.internal.util.xml.SAXParser;
import jdk.internal.util.xml.impl.SAXParserImpl;

final class Parser {

    static XmlConfiguration parse(Path path) throws ParseException, IOException {
        try (FileReader r = new FileReader(path.toFile(), Charset.forName("UTF-8"))) {
            SAXParser saxParser = new SAXParserImpl();
            ConfigurationHandler handler = new ConfigurationHandler();
            saxParser.parse(new InputSource(r), handler);
            return handler.configuration;
        } catch (SAXException sp) {
            ParseException pe = new ParseException(sp.getMessage(), -1);
            pe.initCause(sp);
            throw pe;
        }
    }

    private static final class ConfigurationHandler extends DefaultHandler {
        private final Deque<XmlElement> stack = new ArrayDeque<>();
        private final StringBuilder buffer = new StringBuilder();
        private XmlConfiguration configuration;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (configuration == null) {
                if (!qName.equalsIgnoreCase("configuration")) {
                    throw new SAXException("Expected root element to be named 'configuration'");
                }
                configuration = new XmlConfiguration();
                addAttributes(configuration, attributes);
                stack.push(configuration);
                return;
            }
            XmlElement current = stack.peek();
            XmlElement child = current.createChild(qName);
            addAttributes(child, attributes);
            stack.push(child);
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {
            buffer.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            String content = buffer.toString().strip();
            if (!content.isEmpty()) {
                stack.peek().setContent(content);
                buffer.setLength(0);
            }

            XmlElement current = stack.peek();
            if (current.getElementName().equalsIgnoreCase(qName)) {
                stack.pop();
            } else {
                throw new IllegalStateException("Unexpected <" + qName + "/>");
            }
        }

        private void addAttributes(XmlElement element, Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                element.setAttribute(attributes.getQName(i), attributes.getValue(i));
            }
        }
    }
}
