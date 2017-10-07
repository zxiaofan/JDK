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

package com.sun.xml.internal.ws.wsdl.writer.document;

import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;
import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;

/**
 *
 * @author WS Development Team
 */
@XmlElement("fault")
public interface Fault
    extends TypedXmlWriter, StartWithExtensionsType
{


    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.Fault name(String value);

}
