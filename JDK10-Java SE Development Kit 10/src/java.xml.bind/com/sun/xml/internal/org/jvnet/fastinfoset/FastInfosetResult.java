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

import java.io.OutputStream;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;
import javax.xml.transform.sax.SAXResult;
import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializer;

/**
 *  A JAXP Result implementation that supports the serialization to fast
 *  infoset documents for use by applications that expect a Result.
 *
 *  <P>The derivation of FIResult from SAXResult is an implementation
 *  detail.<P>
 *
 *  <P>This implementation is designed for interoperation with JAXP and is not
 *  not designed with performance in mind. It is recommended that for performant
 *  interoperation alternative serializer specific solutions be used.<P>
 *
 *  <P>General applications shall not call the following methods:
 *   <UL>
 *     <LI>setHandler</LI>
 *     <LI>setLexicalHandler</LI>
 *     <LI>setSystemId</LI>
 *   </UL>
 *  </P>
 */
public class FastInfosetResult extends SAXResult {

    OutputStream _outputStream;

    public FastInfosetResult(OutputStream outputStream) {
        _outputStream = outputStream;
    }

    public ContentHandler getHandler() {
        ContentHandler handler = super.getHandler();
        if (handler == null) {
            handler = new SAXDocumentSerializer();
            setHandler(handler);
        }
        ((SAXDocumentSerializer) handler).setOutputStream(_outputStream);
        return handler;
    }

    public LexicalHandler getLexicalHandler() {
        return (LexicalHandler) getHandler();
    }

    public OutputStream getOutputStream() {
        return _outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        _outputStream = outputStream;
    }
}
