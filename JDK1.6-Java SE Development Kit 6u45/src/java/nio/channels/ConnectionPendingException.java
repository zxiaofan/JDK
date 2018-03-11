/*
 * @(#)ConnectionPendingException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.channels;


/**
 * Unchecked exception thrown when an attempt is made to connect a {@link
 * SocketChannel} for which a non-blocking connection operation is already in
 * progress.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class ConnectionPendingException
    extends IllegalStateException
{

    /**
     * Constructs an instance of this class.
     */
    public ConnectionPendingException() { }

}
