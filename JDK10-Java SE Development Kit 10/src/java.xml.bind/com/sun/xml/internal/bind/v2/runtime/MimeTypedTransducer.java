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

package com.sun.xml.internal.bind.v2.runtime;

import java.awt.*;
import java.io.IOException;

import javax.activation.MimeType;
import javax.xml.stream.XMLStreamException;

import com.sun.xml.internal.bind.api.AccessorException;

import org.xml.sax.SAXException;

/**
 * {@link Transducer} decorator that wraps another {@link Transducer}
 * and sets the expected MIME type to the context.
 *
 * <p>
 * Combined with {@link Transducer} implementations (such as one for {@link Image}),
 * this is used to control the marshalling of the BLOB types.
 *
 * @author Kohsuke Kawaguchi
 */
public final class MimeTypedTransducer<V> extends FilterTransducer<V> {
    private final MimeType expectedMimeType;

    public MimeTypedTransducer(Transducer<V> core,MimeType expectedMimeType) {
        super(core);
        this.expectedMimeType = expectedMimeType;
    }

    @Override
    public CharSequence print(V o) throws AccessorException {
        XMLSerializer w = XMLSerializer.getInstance();
        MimeType old = w.setExpectedMimeType(expectedMimeType);
        try {
            return core.print(o);
        } finally {
            w.setExpectedMimeType(old);
        }
    }

    @Override
    public void writeText(XMLSerializer w, V o, String fieldName) throws IOException, SAXException, XMLStreamException, AccessorException {
        MimeType old = w.setExpectedMimeType(expectedMimeType);
        try {
            core.writeText(w, o, fieldName);
        } finally {
            w.setExpectedMimeType(old);
        }
    }

    @Override
    public void writeLeafElement(XMLSerializer w, Name tagName, V o, String fieldName) throws IOException, SAXException, XMLStreamException, AccessorException {
        MimeType old = w.setExpectedMimeType(expectedMimeType);
        try {
            core.writeLeafElement(w, tagName, o, fieldName);
        } finally {
            w.setExpectedMimeType(old);
        }
    }
}
