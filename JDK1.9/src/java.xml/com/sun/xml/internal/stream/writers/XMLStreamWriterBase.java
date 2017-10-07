/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.writers;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Base class for shared methods among XMLStreamWriter implementations.
 */
public interface XMLStreamWriterBase extends XMLStreamWriter {
    /**
     * Writes the XML declaration.
     *
     * @param encoding the specified encoding
     * @param version the specified version
     * @param standalone the flag indicating whether it is standalone
     * @param standaloneSet the flag indicating whether the standalone attribute is set
     * @throws XMLStreamException in case of an IOException
     */
    public void writeStartDocument(String encoding, String version,
            boolean standalone, boolean standaloneSet)
            throws XMLStreamException;
}
