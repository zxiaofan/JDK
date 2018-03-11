/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.net;

import java.io.IOException;

/**
 * Thrown to indicate that there is an error in the underlying 
 * protocol, such as a TCP error. 
 *
 * @author  Jonathan Payne
 * @version %I%, %G%
 * @since   JDK1.0
 */
public 
class SocketException extends IOException {
    /**
     * Constructs a new <code>SocketException</code> with the 
     * specified detail message. 
     *
     * @param msg the detail message.
     */
    public SocketException(String msg) {
	super(msg);
    }

    /**
     * Constructs a new <code>SocketException</code> with no detail message.
     */
    public SocketException() {
    }
}
