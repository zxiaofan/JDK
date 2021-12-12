/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.util;


/**
 * Error thrown when something goes wrong while locating, loading, or
 * instantiating a service provider.
 *
 * @author Mark Reinhold
 * @since 1.6
 * @see ServiceLoader
 */

public class ServiceConfigurationError
    extends Error
{

    @java.io.Serial
    private static final long serialVersionUID = 74132770414881L;

    /**
     * Constructs a new instance with the specified message.
     *
     * @param  msg  The message, or {@code null} if there is no message
     *
     */
    public ServiceConfigurationError(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance with the specified message and cause.
     *
     * @param  msg  The message, or {@code null} if there is no message
     *
     * @param  cause  The cause, or {@code null} if the cause is nonexistent
     *                or unknown
     */
    public ServiceConfigurationError(String msg, Throwable cause) {
        super(msg, cause);
    }

}
