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
 * This exception may be thrown on any method for which Activity context is
 * accessed and indicates that ongoing work within the Activity is not
 * possible. This may be because the Activity has been instructed to complete
 * with CompletionStatusFailOnly or has ended as a result of a timeout. This
 * exception will be propagated across ORB boundaries via an
 * org.omg.CORBA.ACTIVITY_COMPLETED system exception. An application should
 * handle this error by attempting to complete the Activity.
 */
public class ActivityCompletedException extends java.rmi.RemoteException
{
    /**
     * Constructs a new instance with null as its detail message.
     */
    public ActivityCompletedException() { super(); }

    /**
     * Constructs a new instance with the specified detail message.
     *
     * @param message the detail message.
     */
    public ActivityCompletedException(String message) {
        super(message);
    }

    /**
     * Constructs a new throwable with the specified cause.
     *
     * @param cause a chained exception of type
     * <code>Throwable</code>.
     */
    public ActivityCompletedException(Throwable cause) {
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
    public ActivityCompletedException(String message, Throwable cause) {
        super(message, cause);
    }
}
