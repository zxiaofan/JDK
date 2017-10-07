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

package com.sun.xml.internal.ws.wsdl.parser;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import com.sun.xml.internal.ws.api.wsdl.parser.XMLEntityResolver;
import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Wraps {@link EntityResolver} into {@link com.sun.xml.internal.ws.api.wsdl.parser.XMLEntityResolver}.
 *
 * @author Kohsuke Kawaguchi
 */
final class EntityResolverWrapper implements XMLEntityResolver {
    private final EntityResolver core;
    private boolean useStreamFromEntityResolver = false;

    public EntityResolverWrapper(EntityResolver core) {
        this.core = core;
    }

    public EntityResolverWrapper(EntityResolver core, boolean useStreamFromEntityResolver) {
        this.core = core;
        this.useStreamFromEntityResolver =  useStreamFromEntityResolver;
    }

    public Parser resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        InputSource source = core.resolveEntity(publicId,systemId);
        if(source==null)
            return null;    // default

        // ideally entity resolvers should be giving us the system ID for the resource
        // (or otherwise we won't be able to resolve references within this imported WSDL correctly),
        // but if none is given, the system ID before the entity resolution is better than nothing.
        if(source.getSystemId()!=null)
            systemId = source.getSystemId();

        URL url = new URL(systemId);
        InputStream stream;
        if (useStreamFromEntityResolver) {
                stream = source.getByteStream();
        } else {
                stream = url.openStream();
        }
        return new Parser(url,
                new TidyXMLStreamReader(XMLStreamReaderFactory.create(url.toExternalForm(), stream, true), stream));
    }
}
