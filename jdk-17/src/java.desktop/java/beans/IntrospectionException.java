/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.beans;

import java.io.Serial;

/**
 * Thrown when an exception happens during Introspection.
 * <p>
 * Typical causes include not being able to map a string class name
 * to a Class object, not being able to resolve a string method name,
 * or specifying a method name that has the wrong type signature for
 * its intended use.
 *
 * @since 1.1
 */

public
class IntrospectionException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.7 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -3728150539969542619L;

    /**
     * Constructs an {@code IntrospectionException} with a
     * detailed message.
     *
     * @param mess Descriptive message
     */
    public IntrospectionException(String mess) {
        super(mess);
    }
}
