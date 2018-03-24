/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.xmlschema.parser;

import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;
import org.xml.sax.InputSource;

/**
 * LSInput implementation that wraps a SAX InputSource
 *
 * @author Ryan.Shoemaker@Sun.COM
 */
public class LSInputSAXWrapper implements LSInput {
    private InputSource core;

    public LSInputSAXWrapper(InputSource inputSource) {
        assert inputSource!=null;
        core = inputSource;
    }

    public Reader getCharacterStream() {
        return core.getCharacterStream();
    }

    public void setCharacterStream(Reader characterStream) {
        core.setCharacterStream(characterStream);
    }

    public InputStream getByteStream() {
        return core.getByteStream();
    }

    public void setByteStream(InputStream byteStream) {
        core.setByteStream(byteStream);
    }

    public String getStringData() {
        return null;
    }

    public void setStringData(String stringData) {
        // no-op
    }

    public String getSystemId() {
        return core.getSystemId();
    }

    public void setSystemId(String systemId) {
        core.setSystemId(systemId);
    }

    public String getPublicId() {
        return core.getPublicId();
    }

    public void setPublicId(String publicId) {
        core.setPublicId(publicId);
    }

    public String getBaseURI() {
        return null;
    }

    public void setBaseURI(String baseURI) {
        // no-op
    }

    public String getEncoding() {
        return core.getEncoding();
    }

    public void setEncoding(String encoding) {
        core.setEncoding(encoding);
    }

    public boolean getCertifiedText() {
        return true;
    }

    public void setCertifiedText(boolean certifiedText) {
        // no-op
    }
}
