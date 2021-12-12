/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.jfc;
import java.util.LinkedHashMap;
import java.util.Map;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

final class JFCParserHandler extends DefaultHandler {
    private static final String ELEMENT_CONFIGURATION = "configuration";
    private static final String ELEMENT_EVENT_TYPE = "event";
    private static final String ELEMENT_SETTING = "setting";
    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_LABEL = "label";
    private static final String ATTRIBUTE_DESCRIPTION = "description";
    private static final String ATTRIBUTE_PROVIDER = "provider";
    private static final String ATTRIBUTE_VERSION = "version";

    final Map<String, String> settings = new LinkedHashMap<String, String>();
    private final StringBuilder currentCharacters = new StringBuilder();
    private String currentEventName;
    private String currentSettingsName;
    String label;
    String provider;
    String description;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName.toLowerCase()) {
        case ELEMENT_CONFIGURATION:
            String version = attributes.getValue(ATTRIBUTE_VERSION);
            if (version == null || !version.startsWith("2.")) {
               throw new SAXException("This version of Flight Recorder can only read JFC file format version 2.x");
            }
            label = attributes.getValue(ATTRIBUTE_LABEL);
            description = getOptional(attributes, ATTRIBUTE_DESCRIPTION, "");
            provider = getOptional(attributes, ATTRIBUTE_PROVIDER, "");
            break;
        case ELEMENT_EVENT_TYPE:
            currentEventName = attributes.getValue(ATTRIBUTE_NAME);
            break;
        case ELEMENT_SETTING:
            currentSettingsName = attributes.getValue(ATTRIBUTE_NAME);
            break;
        }
        currentCharacters.setLength(0);
    }

    private String getOptional(Attributes attributes, String name, String defaultValue) {
        String value = attributes.getValue(name);
        return value == null ? defaultValue : value;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentSettingsName != null) {
            currentCharacters.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName.toLowerCase()) {
        case ELEMENT_CONFIGURATION:
            break;
        case ELEMENT_EVENT_TYPE:
            currentEventName = null;
            break;
        case ELEMENT_SETTING:
            String settingsValue = currentCharacters.toString();
            settings.put(currentEventName + "#" + currentSettingsName, settingsValue);
            currentSettingsName = null;
            break;
        }
    }
}
