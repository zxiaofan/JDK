/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws.handler;

/**
 *  {@code HandlerResolver} is an interface implemented
 *  by an application to get control over the handler chain
 *  set on proxy/dispatch objects at the time of their creation.
 *  <p>
 *  A {@code HandlerResolver} may be set on a {@code Service}
 *  using the {@code setHandlerResolver} method.
 *  <p>
 *  When the runtime invokes a {@code HandlerResolver}, it will
 *  pass it a {@code PortInfo} object containing information
 *  about the port that the proxy/dispatch object will be accessing.
 *
 *  @see javax.xml.ws.Service#setHandlerResolver
 *
 *  @since 1.6, JAX-WS 2.0
**/
public interface HandlerResolver {

  /**
   *  Gets the handler chain for the specified port.
   *
   *  @param portInfo Contains information about the port being accessed.
   *  @return {@code java.util.List<Handler>} chain
  **/
  public java.util.List<Handler> getHandlerChain(PortInfo portInfo);
}
