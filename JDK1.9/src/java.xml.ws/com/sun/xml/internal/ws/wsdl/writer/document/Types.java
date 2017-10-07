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
import com.sun.xml.internal.txw2.annotation.XmlElement;
import com.sun.xml.internal.ws.wsdl.writer.document.Documented;
import com.sun.xml.internal.ws.wsdl.writer.document.xsd.Schema;

/**
 *
 * @author WS Development Team
 */
@XmlElement("types")
public interface Types
    extends TypedXmlWriter, Documented
{
    @XmlElement(value="schema",ns="http://www.w3.org/2001/XMLSchema")
    public Schema schema();
}
