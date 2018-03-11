/*
 * @(#)AsynchronousCloseException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.channels;


/**
 * Checked exception received by a thread when another thread closes the
 * channel or the part of the channel upon which it is blocked in an I/O
 * operation.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class AsynchronousCloseException
    extends ClosedChannelException
{

    /**
     * Constructs an instance of this class.
     */
    public AsynchronousCloseException() { }

}
