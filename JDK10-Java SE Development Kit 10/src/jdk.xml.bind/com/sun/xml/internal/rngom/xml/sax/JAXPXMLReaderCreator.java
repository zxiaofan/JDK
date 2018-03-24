/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Copyright (C) 2004-2012
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.xml.sax;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/**
 * {@link XMLReaderCreator} that uses JAXP to create
 * {@link XMLReader}s.
 *
 * @author
 *      Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class JAXPXMLReaderCreator implements XMLReaderCreator {

    private final SAXParserFactory spf;

    public JAXPXMLReaderCreator( SAXParserFactory spf ) {
        this.spf = spf;
    }

    /**
     * Creates a {@link JAXPXMLReaderCreator} by using
     * {@link SAXParserFactory#newInstance()}.
     */
    public JAXPXMLReaderCreator() {
        spf = SAXParserFactory.newInstance();
        try {
            spf.setNamespaceAware(true);
            spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(JAXPXMLReaderCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXNotRecognizedException ex) {
            Logger.getLogger(JAXPXMLReaderCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXNotSupportedException ex) {
            Logger.getLogger(JAXPXMLReaderCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @see com.sun.xml.internal.rngom.xml.sax.XMLReaderCreator#createXMLReader()
     */
    public XMLReader createXMLReader() throws SAXException {
        try {
            return spf.newSAXParser().getXMLReader();
        } catch (ParserConfigurationException e) {
            throw new SAXException(e);
        }
    }

}
