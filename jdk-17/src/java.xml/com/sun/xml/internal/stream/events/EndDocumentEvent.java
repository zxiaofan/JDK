/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.events ;

import javax.xml.stream.events.EndDocument;
import java.io.Writer;
import javax.xml.stream.XMLStreamConstants;

/**
 * This class contains information about EndDocument event.
 *
 * @author Neeraj Bajaj, Sun Microsystems.
 */


public class EndDocumentEvent extends DummyEvent
implements EndDocument {

    public EndDocumentEvent() {
        init();
    }

    protected void init() {
        setEventType(XMLStreamConstants.END_DOCUMENT);
    }

    public String toString() {
        return "ENDDOCUMENT";
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        //end document
    }


}
