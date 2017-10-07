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

package com.sun.xml.internal.bind.v2.schemagen.xmlschema;

import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.txw2.annotation.XmlElement;

/**
 * Used to write a content model.
 *
 * This mixes the particle and model group as the child of complex type.
 *
 * @author Kohsuke Kawaguchi
 */
public interface ContentModelContainer extends TypedXmlWriter {
    @XmlElement
    LocalElement element();

    @XmlElement
    Any any();

    @XmlElement
    ExplicitGroup all();

    @XmlElement
    ExplicitGroup sequence();

    @XmlElement
    ExplicitGroup choice();
}
