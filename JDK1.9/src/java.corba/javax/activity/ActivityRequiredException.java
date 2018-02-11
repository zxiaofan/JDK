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
 * This exception is thrown by a container if Activity context is not received
 * on a method for which Activity context is mandatory. This exception
 * indicates a deployment or application configuration error. This exception
 * will be propagated across ORB boundaries via an
 * org.omg.CORBA.ACTIVITY_REQUIRED system exception.
 */
public class ActivityRequiredException extends java.rmi.RemoteException
{
    /**
     * Constructs a new instance with null as its detail message.
     */
    public ActivityRequiredException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public ActivityRequiredException(String message) {
        super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type
     * <code>Throwable</code>.
     */
    public ActivityRequiredException(Throwable cause) {
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
    public ActivityRequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
