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
 * An action operating on an entity reference composed of a kind and a QName.
 *
 * @author WS Development Team
 */
public interface EntityReferenceAction {
    public void perform(Kind kind, QName name);
}
