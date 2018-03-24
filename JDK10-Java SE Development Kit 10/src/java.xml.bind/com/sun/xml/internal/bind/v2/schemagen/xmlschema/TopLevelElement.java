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

package com.sun.xml.internal.bind.v2.schemagen.xmlschema;

import javax.xml.namespace.QName;
import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;

/**
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 */
@XmlElement("element")
public interface TopLevelElement
    extends Element, TypedXmlWriter
{


    @XmlAttribute("final")
    public TopLevelElement _final(String[] value);

    @XmlAttribute("final")
    public TopLevelElement _final(String value);

    @XmlAttribute("abstract")
    public TopLevelElement _abstract(boolean value);

    @XmlAttribute
    public TopLevelElement substitutionGroup(QName value);

    @XmlAttribute
    public TopLevelElement name(String value);

}
