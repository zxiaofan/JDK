/*
 * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.util.jar;

/**
 * Thrown if the URLClassLoader finds the INDEX.LIST file of
 * a jar file contains incorrect information.
 *
 * @since 9
 */

public class InvalidJarIndexError extends Error {

    @java.io.Serial
    static final long serialVersionUID = 0L;

    /**
     * Constructs an {@code InvalidJarIndexError} with no detail message.
     */
    public InvalidJarIndexError() {
        super();
    }

    /**
     * Constructs an {@code InvalidJarIndexError} with the specified detail message.
     *
     * @param   s   the detail message.
     */
    public InvalidJarIndexError(String s) {
        super(s);
    }
}
