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

package com.sun.xml.internal.org.jvnet.fastinfoset.stax;

import javax.xml.stream.XMLStreamException;

/**
 * Fast Infoset Stream Reader.
 * <p>
 * This interface provides additional optimized methods to that of
 * {@link javax.xml.stream.XMLStreamReader}.
 */
public interface FastInfosetStreamReader {
    /**
     * Peek at the next event.
     *
     * @return the event, which will be the same as that returned from
     *         {@link #next}.
     */
    public int peekNext() throws XMLStreamException;

    // Faster access methods without checks

    public int accessNamespaceCount();

    public String accessLocalName();

    public String accessNamespaceURI();

    public String accessPrefix();

    /**
     * Returns a cloned char[] representation of the internal char[] buffer.
     * So be careful, when using this method due to possible performance and
     * memory inefficiency.
     *
     * @return a cloned char[] representation of the internal char[] buffer.
     */
    public char[] accessTextCharacters();

    public int accessTextStart();

    public int accessTextLength();
}
