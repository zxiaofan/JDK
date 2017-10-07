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

package com.sun.xml.internal.stream.buffer;

import com.sun.xml.internal.stream.buffer.sax.SAXBufferProcessor;
import java.io.ByteArrayInputStream;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * A JAXP Source implementation that supports the parsing
 * of {@link XMLStreamBuffer} for use by applications that expect a Source.
 *
 * <p>
 * The derivation of XMLStreamBufferSource from SAXSource is an implementation
 * detail.
 *
 * <p>Applications shall obey the following restrictions:
 * <ul>
 * <li>The setXMLReader and setInputSource shall not be called.</li>
 * <li>The XMLReader object obtained by the getXMLReader method shall
 *     be used only for parsing the InputSource object returned by
 *     the getInputSource method.</li>
 * <li>The InputSource object obtained by the getInputSource method shall
 *     be used only for being parsed by the XMLReader object returned by
 *     the getXMLReader method.</li>
 * </ul>
 */
public class XMLStreamBufferSource extends SAXSource {
    protected XMLStreamBuffer _buffer;
    protected SAXBufferProcessor _bufferProcessor;

    /**
     * XMLStreamBufferSource constructor.
     *
     * @param buffer the {@link XMLStreamBuffer} to use.
     */
    public XMLStreamBufferSource(XMLStreamBuffer buffer) {
        super(new InputSource(
                new ByteArrayInputStream(new byte[0])));
        setXMLStreamBuffer(buffer);
    }

    /**
     * Get the {@link XMLStreamBuffer} that is used.
     *
     * @return the {@link XMLStreamBuffer}.
     */
    public XMLStreamBuffer getXMLStreamBuffer() {
        return _buffer;
    }

    /**
     * Set the {@link XMLStreamBuffer} to use.
     *
     * @param buffer the {@link XMLStreamBuffer}.
     */
    public void setXMLStreamBuffer(XMLStreamBuffer buffer) {
        if (buffer == null) {
            throw new NullPointerException("buffer cannot be null");
        }
        _buffer = buffer;

        if (_bufferProcessor != null) {
            _bufferProcessor.setBuffer(_buffer,false);
        }
    }

    public XMLReader getXMLReader() {
        if (_bufferProcessor == null) {
            _bufferProcessor = new SAXBufferProcessor(_buffer,false);
            setXMLReader(_bufferProcessor);
        } else if (super.getXMLReader() == null) {
            setXMLReader(_bufferProcessor);
        }

        return _bufferProcessor;
    }
}
