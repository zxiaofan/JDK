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

import com.sun.xml.internal.stream.buffer.sax.SAXBufferCreator;
import javax.xml.transform.sax.SAXResult;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/**
 * A JAXP Result implementation that supports the serialization to an
 * {@link MutableXMLStreamBuffer} for use by applications that expect a Result.
 *
 * <p>
 * Reuse of a XMLStreamBufferResult more than once will require that the
 * MutableXMLStreamBuffer is reset by called
 * {@link #.getXMLStreamBuffer()}.reset(), or by calling
 * {@link #.setXMLStreamBuffer()} with a new instance of
 * {@link MutableXMLStreamBuffer}.
 *
 * <p>
 * The derivation of XMLStreamBufferResult from SAXResult is an implementation
 * detail.
 *
 * <p>General applications shall not call the following methods:
 * <ul>
 * <li>setHandler</li>
 * <li>setLexicalHandler</li>
 * <li>setSystemId</li>
 * </ul>
 */
public class XMLStreamBufferResult extends SAXResult {
    protected MutableXMLStreamBuffer _buffer;
    protected SAXBufferCreator _bufferCreator;

    /**
     * The default XMLStreamBufferResult constructor.
     *
     * <p>
     * A {@link MutableXMLStreamBuffer} is instantiated and used.
     */
    public XMLStreamBufferResult() {
        setXMLStreamBuffer(new MutableXMLStreamBuffer());
    }

    /**
     * XMLStreamBufferResult constructor.
     *
     * @param buffer the {@link MutableXMLStreamBuffer} to use.
     */
    public XMLStreamBufferResult(MutableXMLStreamBuffer buffer) {
        setXMLStreamBuffer(buffer);
    }

    /**
     * Get the {@link MutableXMLStreamBuffer} that is used.
     *
     * @return the {@link MutableXMLStreamBuffer}.
     */
    public MutableXMLStreamBuffer getXMLStreamBuffer() {
        return _buffer;
    }

    /**
     * Set the {@link MutableXMLStreamBuffer} to use.
     *
     * @param buffer the {@link MutableXMLStreamBuffer}.
     */
    public void setXMLStreamBuffer(MutableXMLStreamBuffer buffer) {
        if (buffer == null) {
            throw new NullPointerException("buffer cannot be null");
        }
        _buffer = buffer;
        setSystemId(_buffer.getSystemId());

        if (_bufferCreator != null) {
            _bufferCreator.setXMLStreamBuffer(_buffer);
        }
    }

    public ContentHandler getHandler() {
        if (_bufferCreator == null) {
            _bufferCreator = new SAXBufferCreator(_buffer);
            setHandler(_bufferCreator);
        } else if (super.getHandler() == null) {
            setHandler(_bufferCreator);
        }

        return _bufferCreator;
    }

    public LexicalHandler getLexicalHandler() {
        return (LexicalHandler) getHandler();
    }
}
