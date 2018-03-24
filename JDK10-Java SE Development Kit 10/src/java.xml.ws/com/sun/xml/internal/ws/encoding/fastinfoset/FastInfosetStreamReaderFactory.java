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

package com.sun.xml.internal.ws.encoding.fastinfoset;

import com.sun.xml.internal.fastinfoset.stax.StAXDocumentParser;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Alexey Stashok
 */
public final class FastInfosetStreamReaderFactory extends XMLStreamReaderFactory {
    private static final FastInfosetStreamReaderFactory factory = new FastInfosetStreamReaderFactory();

    private ThreadLocal<StAXDocumentParser> pool = new ThreadLocal<StAXDocumentParser>();

    public static FastInfosetStreamReaderFactory getInstance() {
        return factory;
    }

    public XMLStreamReader doCreate(String systemId, InputStream in, boolean rejectDTDs) {
        StAXDocumentParser parser = fetch();
        if (parser == null) {
            return FastInfosetCodec.createNewStreamReaderRecyclable(in, false);
        }

        parser.setInputStream(in);
        return parser;
    }

    public XMLStreamReader doCreate(String systemId, Reader reader, boolean rejectDTDs) {
        throw new UnsupportedOperationException();
    }

    private StAXDocumentParser fetch() {
        StAXDocumentParser parser = pool.get();
        pool.set(null);
        return parser;
    }

    public void doRecycle(XMLStreamReader r) {
        if (r instanceof StAXDocumentParser) {
            pool.set((StAXDocumentParser) r);
        }
    }
}
