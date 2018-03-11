/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.net;

import java.io.IOException;

/**
 * Thrown to indicate that the IP address of a host could not be determined.
 *
 * @author  Jonathan Payne 
 * @version %I%, %G%
 * @since   JDK1.0
 */
public 
class UnknownHostException extends IOException {
    /**
     * Constructs a new <code>UnknownHostException</code> with the 
     * specified detail message. 
     *
     * @param   host   the detail message.
     */
    public UnknownHostException(String host) {
	super(host);
    }

    /**
     * Constructs a new <code>UnknownHostException</code> with no detail 
     * message. 
     */
    public UnknownHostException() {
    }
}
