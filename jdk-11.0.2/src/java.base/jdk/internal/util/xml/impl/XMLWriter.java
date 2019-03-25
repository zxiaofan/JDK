/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.util.xml.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import jdk.internal.util.xml.XMLStreamException;

/**
 *
 * @author huizwang
 */
public class XMLWriter {

    private Writer _writer;
    /**
     * In some cases, this charset encoder is used to determine if a char is
     * encodable by underlying writer. For example, an 8-bit char from the
     * extended ASCII set is not encodable by 7-bit ASCII encoder. Unencodable
     * chars are escaped using XML numeric entities.
     */
    private CharsetEncoder _encoder = null;

    public XMLWriter(OutputStream os, String encoding, Charset cs) throws XMLStreamException {
        _encoder = cs.newEncoder();
        try {
            _writer = getWriter(os, encoding, cs);
        } catch (UnsupportedEncodingException ex) {
            throw new XMLStreamException(ex);
        }

    }

    public boolean canEncode(char ch) {
        if (_encoder == null) {
            return false;
        }
        return (_encoder.canEncode(ch));
    }

    public void write(String s)
            throws XMLStreamException {
        try {
            _writer.write(s.toCharArray());
//            _writer.write(s.getBytes(Charset.forName(_encoding)));
        } catch (IOException e) {
            throw new XMLStreamException("I/O error", e);
        }
    }

    public void write(String str, int off, int len)
            throws XMLStreamException {
        try {
            _writer.write(str, off, len);
        } catch (IOException e) {
            throw new XMLStreamException("I/O error", e);
        }

    }

    public void write(char[] cbuf, int off, int len)
            throws XMLStreamException {
        try {
            _writer.write(cbuf, off, len);
        } catch (IOException e) {
            throw new XMLStreamException("I/O error", e);
        }

    }

    void write(int b)
            throws XMLStreamException {
        try {
            _writer.write(b);
        } catch (IOException e) {
            throw new XMLStreamException("I/O error", e);
        }
    }

    void flush() throws XMLStreamException {
        try {
            _writer.flush();
        } catch (IOException ex) {
            throw new XMLStreamException(ex);
        }
    }

    void close() throws XMLStreamException {
        try {
            _writer.close();
        } catch (IOException ex) {
            throw new XMLStreamException(ex);
        }
    }

    private void nl() throws XMLStreamException {
        String lineEnd = System.lineSeparator();
        try {
            _writer.write(lineEnd);
        } catch (IOException e) {
            throw new XMLStreamException("I/O error", e);
        }
    }

    /**
     * Returns a writer for the specified encoding based on an output stream.
     *
     * @param output The output stream
     * @param encoding The encoding
     * @return A suitable writer
     * @throws UnsupportedEncodingException There is no convertor to support
     * this encoding
     */
    private Writer getWriter(OutputStream output, String encoding, Charset cs)
        throws XMLStreamException, UnsupportedEncodingException
    {
        if (cs != null) {
            return (new OutputStreamWriter(new BufferedOutputStream(output), cs));
        }

        return new OutputStreamWriter(new BufferedOutputStream(output), encoding);
    }
}
