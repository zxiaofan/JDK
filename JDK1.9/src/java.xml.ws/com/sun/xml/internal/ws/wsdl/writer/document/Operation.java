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
import com.sun.xml.internal.ws.wsdl.writer.document.Documented;

/**
 *
 * @author WS Development Team
 */
@XmlElement("operation")
public interface Operation
    extends TypedXmlWriter, Documented
{

/*
    @XmlElement("notification-operation")
    public NotificationOperation notificationOperation();

    @XmlElement("solicit-response-operation")
    public SolicitResponseOperation solicitResponseOperation();

    @XmlElement("request-response-operation")
    public RequestResponseOperation requestResponseOperation();

    @XmlElement("one-way-operation")
    public OneWayOperation oneWayOperation();
*/
    @XmlElement
    public ParamType input();

    @XmlElement
    public ParamType output();

    @XmlElement
    public FaultType fault();

    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.Operation name(String value);

    @XmlAttribute
    public com.sun.xml.internal.ws.wsdl.writer.document.Operation parameterOrder(String value);
}
