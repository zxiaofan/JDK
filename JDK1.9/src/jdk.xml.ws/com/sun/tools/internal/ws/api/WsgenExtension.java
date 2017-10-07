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

package com.sun.tools.internal.ws.api;

/**
 * Allows to customize wsgen behaviour using this extension.
 * The extension implementations are found using service
 * discovery mechanism i.e. JAX-WS tooltime locates
 * {@link WsgenExtension}s through the
 * {@code META-INF/services/com.sun.tools.internal.ws.api.WsgenExtension}
 * files.
 *
 * {@link WsgenProtocol} annotation can be specified on the
 * extensions to extend -wsdl[:protocol] behaviour.
 *
 * @author Jitendra Kotamraju
 * @since JAX-WS RI 2.1.6
 * @see WsgenProtocol
 */
public abstract class WsgenExtension {
}
