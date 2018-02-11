/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.dtdparser;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

final class ExternalEntity extends EntityDecl {
    String systemId;    // resolved URI (not relative)
    String publicId;    // "-//xyz//....//en"
    String notation;

    public ExternalEntity(InputEntity in) {
    }

    public InputSource getInputSource(EntityResolver r)
            throws IOException, SAXException {

        InputSource retval;

        retval = r.resolveEntity(publicId, systemId);
        // SAX sez if null is returned, use the URI directly
        if (retval == null)
            retval = Resolver.createInputSource(new URL(systemId), false);
        return retval;
    }
}
