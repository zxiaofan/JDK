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

package javax.xml.ws.handler;

import javax.xml.ws.LogicalMessage;

/** The {@code LogicalMessageContext} interface extends
 *  {@code MessageContext} to
 *  provide access to a the contained message as a protocol neutral
 *  LogicalMessage
 *
 *  @since 1.6, JAX-WS 2.0
**/
public interface LogicalMessageContext
                    extends MessageContext {

  /** Gets the message from this message context
   *
   *  @return The contained message; returns {@code null} if no
   *          message is present in this message context
  **/
  public LogicalMessage getMessage();
}
