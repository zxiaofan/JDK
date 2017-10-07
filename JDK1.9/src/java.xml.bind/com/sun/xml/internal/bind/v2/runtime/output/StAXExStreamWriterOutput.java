/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.output;

import javax.xml.stream.XMLStreamException;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data;

import com.sun.xml.internal.org.jvnet.staxex.XMLStreamWriterEx;

/**
 * {@link XmlOutput} for {@link XMLStreamWriterEx}.
 *
 * @author Paul Sandoz.
 */
public final class StAXExStreamWriterOutput extends XMLStreamWriterOutput {
    private final XMLStreamWriterEx out;

    public StAXExStreamWriterOutput(XMLStreamWriterEx out) {
        super(out, NoEscapeHandler.theInstance);
        this.out = out;
    }

    public void text(Pcdata value, boolean needsSeparatingWhitespace) throws XMLStreamException {
        if(needsSeparatingWhitespace) {
            out.writeCharacters(" ");
        }

        if (!(value instanceof Base64Data)) {
            out.writeCharacters(value.toString());
        } else {
            Base64Data v = (Base64Data)value;
            out.writeBinary(v.getDataHandler());
        }
    }
}
