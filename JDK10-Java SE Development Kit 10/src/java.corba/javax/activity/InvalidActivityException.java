/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.activity;

/**
 * This exception may be thrown on any method for which Activity context
 * is accessed and indicates that the attempted invocation or the Activity
 * context associated with the attempted invocation is incompatible with
 * the Activity's current state. It may also be thrown by a container if
 * Activity context is received on a method for which Activity context is
 * forbidden. This exception will be propagated across J2EE Activity Service
 * ORB boundaries via an org.omg.CORBA.INVALID_ACTIVITY system exception.
 * An application should handle this error by attempting to complete the
 * Activity.
 */
public class InvalidActivityException extends java.rmi.RemoteException
{
    /**
     * Constructs a new instance with null as its detail message.
     */
    public InvalidActivityException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidActivityException(String message) {
        super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type
     * <code>Throwable</code>.
     */
    public InvalidActivityException(Throwable cause) {
        this("", cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message.
     *
     * @param cause a chained exception of type
     * <code>Throwable</code>.
     */
    public InvalidActivityException(String message, Throwable cause) {
        super(message, cause);
    }
}
