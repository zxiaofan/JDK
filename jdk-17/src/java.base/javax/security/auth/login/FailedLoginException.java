/*
 * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.security.auth.login;

/**
 * Signals that user authentication failed.
 *
 * <p> This exception is thrown by LoginModules if authentication failed.
 * For example, a {@code LoginModule} throws this exception if
 * the user entered an incorrect password.
 *
 * @since 1.4
 */
public class FailedLoginException extends LoginException {

    @java.io.Serial
    private static final long serialVersionUID = 802556922354616286L;

    /**
     * Constructs a FailedLoginException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public FailedLoginException() {
        super();
    }

    /**
     * Constructs a FailedLoginException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * @param msg the detail message.
     */
    public FailedLoginException(String msg) {
        super(msg);
    }
}
