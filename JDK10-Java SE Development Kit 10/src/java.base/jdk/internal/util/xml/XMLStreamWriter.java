/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.util.xml;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Basic XMLStreamWriter for writing simple XML files such as those
 * defined in java.util.Properties
 *
 * This is a subset of javax.xml.stream.XMLStreamWriter
 *
 * @author Joe Wang
 */
public  interface XMLStreamWriter {

    //Defaults the XML version to 1.0, and the encoding to utf-8
    public static final String DEFAULT_XML_VERSION = "1.0";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    /**
     * Writes a start tag to the output.  All writeStartElement methods
     * open a new scope in the internal namespace context.  Writing the
     * corresponding EndElement causes the scope to be closed.
     * @param localName local name of the tag, may not be null
     * @throws XMLStreamException
     */
    public void writeStartElement(String localName) throws XMLStreamException;

    /**
     * Writes an empty element tag to the output
     * @param localName local name of the tag, may not be null
     * @throws XMLStreamException
     */
    public void writeEmptyElement(String localName) throws XMLStreamException;

    /**
     * Writes an end tag to the output relying on the internal
     * state of the writer to determine the prefix and local name
     * of the event.
     * @throws XMLStreamException
     */
    public void writeEndElement() throws XMLStreamException;

    /**
     * Closes any start tags and writes corresponding end tags.
     * @throws XMLStreamException
     */
    public void writeEndDocument() throws XMLStreamException;

    /**
     * Close this writer and free any resources associated with the
     * writer.  This must not close the underlying output stream.
     * @throws XMLStreamException
     */
    public void close() throws XMLStreamException;

    /**
     * Write any cached data to the underlying output mechanism.
     * @throws XMLStreamException
     */
    public void flush() throws XMLStreamException;

    /**
     * Writes an attribute to the output stream without
     * a prefix.
     * @param localName the local name of the attribute
     * @param value the value of the attribute
     * @throws IllegalStateException if the current state does not allow Attribute writing
     * @throws XMLStreamException
     */
    public void writeAttribute(String localName, String value)
            throws XMLStreamException;

    /**
     * Writes a CData section
     * @param data the data contained in the CData Section, may not be null
     * @throws XMLStreamException
     */
    public void writeCData(String data) throws XMLStreamException;

    /**
     * Write a DTD section.  This string represents the entire doctypedecl production
     * from the XML 1.0 specification.
     *
     * @param dtd the DTD to be written
     * @throws XMLStreamException
     */
    public void writeDTD(String dtd) throws XMLStreamException;

    /**
     * Write the XML Declaration. Defaults the XML version to 1.0, and the encoding to utf-8
     * @throws XMLStreamException
     */
    public void writeStartDocument() throws XMLStreamException;

    /**
     * Write the XML Declaration. Defaults the encoding to utf-8
     * @param version version of the xml document
     * @throws XMLStreamException
     */
    public void writeStartDocument(String version) throws XMLStreamException;

    /**
     * Write the XML Declaration.  Note that the encoding parameter does
     * not set the actual encoding of the underlying output.  That must
     * be set when the instance of the XMLStreamWriter is created using the
     * XMLOutputFactory
     * @param encoding encoding of the xml declaration
     * @param version version of the xml document
     * @throws XMLStreamException If given encoding does not match encoding
     * of the underlying stream
     */
    public void writeStartDocument(String encoding, String version)
        throws XMLStreamException;

    /**
     * Write text to the output
     * @param text the value to write
     * @throws XMLStreamException
     */
    public void writeCharacters(String text) throws XMLStreamException;

    /**
     * Write text to the output
     * @param text the value to write
     * @param start the starting position in the array
     * @param len the number of characters to write
     * @throws XMLStreamException
     */
    public void writeCharacters(char[] text, int start, int len)
        throws XMLStreamException;
}
