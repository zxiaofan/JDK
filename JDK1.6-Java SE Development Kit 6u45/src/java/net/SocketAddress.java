/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.net;


/**
 *
 * This class represents a Socket Address with no protocol attachment.
 * As an abstract class, it is meant to be subclassed with a specific, 
 * protocol dependent, implementation.
 * <p>
 * It provides an immutable object used by sockets for binding, connecting, or
 * as returned values.
 *
 * @see	java.net.Socket
 * @see	java.net.ServerSocket
 * @since 1.4
 */
public abstract class SocketAddress implements java.io.Serializable {
}
