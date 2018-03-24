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

package com.sun.xml.internal.ws.api.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.namespace.QName;
import java.util.Set;


/**
 * The <code>MessageHandler</code> class extends <code>Handler</code>
 * to provide typesafety for the message context parameter and add a method
 * to obtain access to the headers that may be processed by the handler.
 * Its provides similar functionality as a SOAPHandler but provides RI's
 * Message in the MessageContext.
 *
 * @author Rama Pulavarthi
 * @since JAX-WS 2.1.3
 */
public interface MessageHandler<C extends MessageHandlerContext> extends Handler<C> {


   /** Gets the header blocks that can be processed by this Handler
   *  instance.
   *
   *  @return Set of <code>QNames</code> of header blocks processed by this
   *           handler instance. <code>QName</code> is the qualified
   *           name of the outermost element of the Header block.
  **/
  Set<QName> getHeaders();

}
