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

package com.sun.xml.internal.ws.wsdl.writer.document.xsd;

import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;
import com.sun.xml.internal.ws.wsdl.writer.document.*;

/**
 *
 * @author WS Development Team
 */
@XmlElement("schema")
public interface Schema
    extends TypedXmlWriter, Documented
{


    @XmlElement("import")
    public Import _import();

    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.xsd.Schema targetNamespace(String value);
}
