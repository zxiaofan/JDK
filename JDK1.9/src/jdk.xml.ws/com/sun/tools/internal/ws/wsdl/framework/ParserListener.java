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

package com.sun.tools.internal.ws.wsdl.framework;

import javax.xml.namespace.QName;

/**
 * A listener for parsing-related events.
 *
 * @author WS Development Team
 */
public interface ParserListener {
    public void ignoringExtension(Entity entity, QName name, QName parent);
    public void doneParsingEntity(QName element, Entity entity);
}
