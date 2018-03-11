/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.net;

import java.io.IOException;

/**
 * Thrown to indicate that an unknown service exception has 
 * occurred. Either the MIME type returned by a URL connection does 
 * not make sense, or the application is attempting to write to a 
 * read-only URL connection. 
 *
 * @author  unascribed
 * @version %I%, %G%
 * @since   JDK1.0
 */
public class UnknownServiceException extends IOException {
    /**
     * Constructs a new <code>UnknownServiceException</code> with no 
     * detail message. 
     */
    public UnknownServiceException() {
    }

    /**
     * Constructs a new <code>UnknownServiceException</code> with the 
     * specified detail message. 
     *
     * @param   msg   the detail message.
     */
    public UnknownServiceException(String msg) {
	super(msg);
    }
}
