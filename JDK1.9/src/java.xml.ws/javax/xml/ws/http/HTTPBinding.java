/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws.http;


import javax.xml.ws.Binding;

/** The {@code HTTPBinding} interface is an
 *  abstraction for the XML/HTTP binding.
 *
 *  @since 1.6, JAX-WS 2.0
**/
public interface HTTPBinding extends Binding {

  /**
   * A constant representing the identity of the XML/HTTP binding.
   */
  public static final String HTTP_BINDING = "http://www.w3.org/2004/08/wsdl/http";
}
