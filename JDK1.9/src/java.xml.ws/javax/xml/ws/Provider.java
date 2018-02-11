/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws;

/**
 *  <p>Service endpoints may implement the {@code Provider}
 *  interface as a dynamic alternative to an SEI.
 *
 *  <p>Implementations are required to support {@code Provider<Source>},
 *  {@code Provider<SOAPMessage>} and
 *  {@code Provider<DataSource>}, depending on the binding
 *  in use and the service mode.
 *
 *  <p>The {@code ServiceMode} annotation can be used to control whether
 *  the {@code Provider} instance will receive entire protocol messages
 *  or just message payloads.
 *
 * @param <T> The type of the request
 *  @since 1.6, JAX-WS 2.0
 *
 *  @see javax.xml.transform.Source
 *  @see javax.xml.soap.SOAPMessage
 *  @see javax.xml.ws.ServiceMode
**/
public interface Provider<T> {

  /** Invokes an operation according to the contents of the request
   *  message.
   *
   *  @param  request The request message or message payload.
   *  @return The response message or message payload. May be {@code null} if
              there is no response.
   *  @throws WebServiceException If there is an error processing request.
   *          The cause of the {@code WebServiceException} may be set to a subclass
   *          of {@code ProtocolException} to control the protocol level
   *          representation of the exception.
   *  @see javax.xml.ws.handler.MessageContext
   *  @see javax.xml.ws.ProtocolException
  **/
  public T invoke(T request);
}
