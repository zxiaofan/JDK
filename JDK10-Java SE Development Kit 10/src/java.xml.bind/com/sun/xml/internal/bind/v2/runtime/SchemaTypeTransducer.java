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

import java.io.IOException;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import com.sun.xml.internal.bind.api.AccessorException;

import org.xml.sax.SAXException;

/**
 * {@link Transducer} that signals the runtime that this datatype
 * is marshalled to a different XML Schema type.
 *
 * <p>
 * This transducer is used to implement the semantics of {@link XmlSchemaType} annotation.
 *
 *
 * @see XMLSerializer#schemaType
 * @author Kohsuke Kawaguchi
 */
public class SchemaTypeTransducer<V> extends FilterTransducer<V> {
    private final QName schemaType;

    public SchemaTypeTransducer(Transducer<V> core, QName schemaType) {
        super(core);
        this.schemaType = schemaType;
    }

    @Override
    public CharSequence print(V o) throws AccessorException {
        XMLSerializer w = XMLSerializer.getInstance();
        QName old = w.setSchemaType(schemaType);
        try {
            return core.print(o);
        } finally {
            w.setSchemaType(old);
        }
    }

    @Override
    public void writeText(XMLSerializer w, V o, String fieldName) throws IOException, SAXException, XMLStreamException, AccessorException {
        QName old = w.setSchemaType(schemaType);
        try {
            core.writeText(w,o,fieldName);
        } finally {
            w.setSchemaType(old);
        }
    }

    @Override
    public void writeLeafElement(XMLSerializer w, Name tagName, V o, String fieldName) throws IOException, SAXException, XMLStreamException, AccessorException {
        QName old = w.setSchemaType(schemaType);
        try {
            core.writeLeafElement(w, tagName, o, fieldName);
        } finally {
            w.setSchemaType(old);
        }
    }
}
