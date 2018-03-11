/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security.cert;

import java.security.GeneralSecurityException;

/**
 * An exception indicating one of a variety of problems encountered when
 * building a certification path with a <code>CertPathBuilder</code>.
 * <p>
 * A <code>CertPathBuilderException</code> provides support for wrapping 
 * exceptions. The {@link #getCause getCause} method returns the throwable, 
 * if any, that caused this exception to be thrown. 
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see CertPathBuilder
 *
 * @version 	%I% %G%
 * @since	1.4
 * @author 	Sean Mullan
 */
public class CertPathBuilderException extends GeneralSecurityException {

    private static final long serialVersionUID = 5316471420178794402L;

    /**
     * Creates a <code>CertPathBuilderException</code> with <code>null</code>
     * as its detail message.
     */
    public CertPathBuilderException() {
	super();
    }

    /**
     * Creates a <code>CertPathBuilderException</code> with the given
     * detail message. The detail message is a <code>String</code> that 
     * describes this particular exception in more detail.
     *
     * @param msg the detail message
     */
    public CertPathBuilderException(String msg) {
	super(msg);
    }

    /**
     * Creates a <code>CertPathBuilderException</code> that wraps the specified
     * throwable. This allows any exception to be converted into a 
     * <code>CertPathBuilderException</code>, while retaining information 
     * about the wrapped exception, which may be useful for debugging. The 
     * detail message is set to (<code>cause==null ? null : cause.toString()
     * </code>) (which typically contains the class and detail message of 
     * cause).
     *
     * @param cause the cause (which is saved for later retrieval by the 
     * {@link #getCause getCause()} method). (A <code>null</code> value is 
     * permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public CertPathBuilderException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a <code>CertPathBuilderException</code> with the specified
     * detail message and cause.
     *
     * @param msg the detail message
     * @param  cause the cause (which is saved for later retrieval by the 
     * {@link #getCause getCause()} method). (A <code>null</code> value is 
     * permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public CertPathBuilderException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
