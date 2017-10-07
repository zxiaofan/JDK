/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.server;

import javax.xml.namespace.QName;

/**
 * @author Jitendra Kotamraju
 */
public abstract class EndpointData {

    public abstract String getNamespace();

    public abstract String getServiceName();

    public abstract String getPortName();

    public abstract String getImplClass();

}
