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

package com.sun.xml.internal.org.jvnet.fastinfoset.sax;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public interface ExtendedContentHandler extends ContentHandler {

    /**
     * Receive notification of character data.
     *
     * @param ch the characters from the XML document
     * @param start the start position in the array
     * @param length the number of characters to read from the array
     * @param index true if the characters are indexed, otherwise false.
     * @throws org.xml.sax.SAXException any SAX exception, possibly
     *            wrapping another exception
     * @see ContentHandler#characters
     */
    public void characters(char[] ch, int start, int length, boolean index) throws SAXException;
}
