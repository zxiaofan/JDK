/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.server;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;

/**
 * Provides a way to filter {@link SDDocument} infoset while writing it. These
 * filter objects can be added to {@link ServiceDefinition} using
 * {@link ServiceDefinition#addFilter(SDDocumentFilter)}
 *
 * @author Kohsuke Kawaguchi
 * @author Jitendra Kotamraju
 */
public interface SDDocumentFilter {
    /**
     * Returns a wrapped XMLStreamWriter on top of passed-in XMLStreamWriter.
     * It works like any filtering API for e.g. {@link java.io.FilterOutputStream}.
     * The method returns a XMLStreamWriter that calls the same methods on original
     * XMLStreamWriter with some modified events. The end result is some infoset
     * is filtered before it reaches the original writer and the infoset writer
     * doesn't have to change any code to incorporate this filter.
     *
     * @param doc gives context for the filter. This should only be used to query
     *  read-only information. Calling doc.writeTo() may result in infinite loop.
     * @param w Original XMLStreamWriter
     * @return Filtering {@link XMLStreamWriter}
     */
    XMLStreamWriter filter(SDDocument doc, XMLStreamWriter w) throws XMLStreamException, IOException;
}
