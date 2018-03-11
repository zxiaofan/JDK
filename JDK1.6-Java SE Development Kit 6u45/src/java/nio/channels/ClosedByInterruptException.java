/*
 * @(#)ClosedByInterruptException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.channels;


/**
 * Checked exception received by a thread when another thread interrupts it
 * while it is blocked in an I/O operation upon a channel.  Before this
 * exception is thrown the channel will have been closed and the interrupt
 * status of the previously-blocked thread will have been set.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class ClosedByInterruptException
    extends AsynchronousCloseException
{

    /**
     * Constructs an instance of this class.
     */
    public ClosedByInterruptException() { }

}
