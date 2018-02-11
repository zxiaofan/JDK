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
import com.sun.xml.internal.ws.wsdl.writer.document.Fault;
import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.SOAPOperation;

/**
 *
 * @author WS Development Team
 */
public interface BindingOperationType
    extends TypedXmlWriter, StartWithExtensionsType
{


    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.BindingOperationType name(String value);

    @XmlElement(value="operation",ns="http://schemas.xmlsoap.org/wsdl/soap/")
    public SOAPOperation soapOperation();

    @XmlElement(value="operation",ns="http://schemas.xmlsoap.org/wsdl/soap12/")
    public com.sun.xml.internal.ws.wsdl.writer.document.soap12.SOAPOperation soap12Operation();

    @XmlElement
    public Fault fault();

    @XmlElement
    public StartWithExtensionsType output();

    @XmlElement
    public StartWithExtensionsType input();

}
