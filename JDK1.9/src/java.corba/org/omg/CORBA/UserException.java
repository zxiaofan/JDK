/*
 * Copyright (c) 1995, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * The root class for CORBA IDL-defined user exceptions.
 * All CORBA user exceptions are checked exceptions, which
 * means that they need to
 * be declared in method signatures.
 *
 * <p>See also {@extLink jidlexception documentation on Java&nbsp;IDL exceptions}.
 * </p>
 */
public abstract class UserException extends java.lang.Exception implements org.omg.CORBA.portable.IDLEntity {

    /**
     * Constructs a <code>UserException</code> object.
     * This method is called only by subclasses.
     */
    protected UserException() {
        super();
    }

    /**
     * Constructs a <code>UserException</code> object with a
     * detail message. This method is called only by subclasses.
     *
     * @param reason a <code>String</code> object giving the reason for this
     *         exception
     */
    protected UserException(String reason) {
        super(reason);
    }
}
