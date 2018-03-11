/*
 * @(#)NoConnectionPendingException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.channels;


/**
 * Unchecked exception thrown when the {@link SocketChannel#finishConnect
 * finishConnect} method of a {@link SocketChannel} is invoked without first
 * successfully invoking its {@link SocketChannel#connect connect} method.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class NoConnectionPendingException
    extends IllegalStateException
{

    /**
     * Constructs an instance of this class.
     */
    public NoConnectionPendingException() { }

}
