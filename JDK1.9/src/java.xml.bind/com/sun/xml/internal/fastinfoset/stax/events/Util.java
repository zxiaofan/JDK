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

package com.sun.xml.internal.fastinfoset.stax.events;

import javax.xml.stream.XMLStreamConstants;

/** A Utility class for the StAX Events implementation.
 */
public class Util {

    /**
     * A string is empty if it's null or contains nothing
     *
     * @param s The string to check.
     */
    public static boolean isEmptyString(String s) {
        if (s != null && !s.equals(""))
            return false;
        else
            return true;
    }

    public final static String getEventTypeString(int eventType) {
        switch (eventType){
            case XMLStreamConstants.START_ELEMENT:
                return "START_ELEMENT";
            case XMLStreamConstants.END_ELEMENT:
                return "END_ELEMENT";
            case XMLStreamConstants.PROCESSING_INSTRUCTION:
                return "PROCESSING_INSTRUCTION";
            case XMLStreamConstants.CHARACTERS:
                return "CHARACTERS";
            case XMLStreamConstants.COMMENT:
                return "COMMENT";
            case XMLStreamConstants.START_DOCUMENT:
                return "START_DOCUMENT";
            case XMLStreamConstants.END_DOCUMENT:
                return "END_DOCUMENT";
            case XMLStreamConstants.ENTITY_REFERENCE:
                return "ENTITY_REFERENCE";
            case XMLStreamConstants.ATTRIBUTE:
                return "ATTRIBUTE";
            case XMLStreamConstants.DTD:
                return "DTD";
            case XMLStreamConstants.CDATA:
                return "CDATA";
        }
        return "UNKNOWN_EVENT_TYPE";
    }

}
