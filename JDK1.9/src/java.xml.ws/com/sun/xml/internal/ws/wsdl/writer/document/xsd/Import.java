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
import com.sun.xml.internal.ws.wsdl.writer.document.Documented;
import com.sun.xml.internal.ws.wsdl.writer.document.*;

/**
 *
 * @author WS Development Team
 */
@XmlElement("import")
public interface Import
    extends TypedXmlWriter, Documented
{


    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.xsd.Import schemaLocation(String value);

    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.xsd.Import namespace(String value);

}
