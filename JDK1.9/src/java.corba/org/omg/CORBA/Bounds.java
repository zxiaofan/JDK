/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;

/**
 * A user exception thrown when a parameter is not within
 * the legal bounds for the object that a method is trying
 * to access.
 *
 * <p>See also {@extLink jidlexception documentation on Java&nbsp;IDL exceptions}.
 * </p>
 */

public final class Bounds extends org.omg.CORBA.UserException {

    /**
     * Constructs an <code>Bounds</code> with no specified detail message.
     */
    public Bounds() {
        super();
    }

    /**
     * Constructs an <code>Bounds</code> with the specified detail message.
     *
     * @param   reason   the detail message.
     */
    public Bounds(String reason) {
        super(reason);
    }
}
