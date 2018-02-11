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

/**
 * An interface implemented by entities that define target namespaces.
 *
 * @author WS Development Team
 */
public interface Defining extends Elemental {
    public String getTargetNamespaceURI();
}
