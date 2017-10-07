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

package com.sun.xml.internal.org.jvnet.fastinfoset;

import java.io.InputStream;

import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.sun.xml.internal.fastinfoset.sax.SAXDocumentParser;

/**
 *  A JAXP Source implementation that supports the parsing fast
 *  infoset document for use by applications that expect a Source.
 *
 *  <P>The derivation of FISource from SAXSource is an implementation
 *  detail.<P>
 *
 *  <P>This implementation is designed for interoperation with JAXP and is not
 *  not designed with performance in mind. It is recommended that for performant
 *  interoperation alternative parser specific solutions be used.<P>
 *
 *  <P>Applications shall obey the following restrictions:
 *   <UL>
 *     <LI>The setXMLReader and setInputSource shall not be called.</LI>
 *     <LI>The XMLReader object obtained by the getXMLReader method shall
 *        be used only for parsing the InputSource object returned by
 *        the getInputSource method.</LI>
 *     <LI>The InputSource object obtained by the getInputSource method shall
 *        be used only for being parsed by the XMLReader object returned by
 *        the getXMLReader method.</LI>
 *   </UL>
 *  </P>
 */
public class FastInfosetSource extends SAXSource {

    public FastInfosetSource(InputStream inputStream) {
        super(new InputSource(inputStream));
    }

    public XMLReader getXMLReader() {
        XMLReader reader = super.getXMLReader();
        if (reader == null) {
            reader = new SAXDocumentParser();
            setXMLReader(reader);
        }
        ((SAXDocumentParser) reader).setInputStream(getInputStream());
        return reader;
    }

    public InputStream getInputStream() {
        return getInputSource().getByteStream();
    }

    public void setInputStream(InputStream inputStream) {
        setInputSource(new InputSource(inputStream));
    }
}
