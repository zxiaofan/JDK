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
 * @author  Chris Warth
 * @version %I%, %G%
 * @since   JDK1.0
 */
public 
class ProtocolException extends IOException { 
    /**
     * Constructs a new <code>ProtocolException</code> with the 
     * specified detail message. 
     *
     * @param   host   the detail message.
     */
    public ProtocolException(String host) {
	super(host);
    }
    
    /**
     * Constructs a new <code>ProtocolException</code> with no detail message.
     */
    public ProtocolException() {
    }
}
