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

/**
 *
 * @author WS Development Team
 */
@XmlElement("definitions")
public interface Definitions
    extends TypedXmlWriter, Documented
{


    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.Definitions name(String value);

    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.Definitions targetNamespace(String value);

    @XmlElement
    public Service service();

    @XmlElement
    public Binding binding();

    @XmlElement
    public PortType portType();

    @XmlElement
    public Message message();

    @XmlElement
    public Types types();

    @XmlElement("import")
    public Import _import();

}
