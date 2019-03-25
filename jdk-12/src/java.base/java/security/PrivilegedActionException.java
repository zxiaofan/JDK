/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import jdk.internal.access.SharedSecrets;

/**
 * This exception is thrown by
 * {@code doPrivileged(PrivilegedExceptionAction)} and
 * {@code doPrivileged(PrivilegedExceptionAction,
 * AccessControlContext context)} to indicate
 * that the action being performed threw a checked exception.  The exception
 * thrown by the action can be obtained by calling the
 * {@code getException} method.  In effect, an
 * {@code PrivilegedActionException} is a "wrapper"
 * for an exception thrown by a privileged action.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The "exception thrown
 * by the privileged computation" that is provided at construction time and
 * accessed via the {@link #getException()} method is now known as the
 * <i>cause</i>, and may be accessed via the {@link Throwable#getCause()}
 * method, as well as the aforementioned "legacy method."
 *
 * @since 1.2
 * @see PrivilegedExceptionAction
 * @see AccessController#doPrivileged(PrivilegedExceptionAction)
 * @see AccessController#doPrivileged(PrivilegedExceptionAction,AccessControlContext)
 */
public class PrivilegedActionException extends Exception {
    // use serialVersionUID from JDK 1.2.2 for interoperability
    private static final long serialVersionUID = 4724086851538908602L;

    /**
     * Constructs a new PrivilegedActionException &quot;wrapping&quot;
     * the specific Exception.
     *
     * @param exception The exception thrown
     */
    public PrivilegedActionException(Exception exception) {
        super(null, exception);  // Disallow initCause
    }

    /**
     * Returns the exception thrown by the privileged computation that
     * resulted in this {@code PrivilegedActionException}.
     *
     * <p>This method predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @return the exception thrown by the privileged computation that
     *         resulted in this {@code PrivilegedActionException}.
     * @see PrivilegedExceptionAction
     * @see AccessController#doPrivileged(PrivilegedExceptionAction)
     * @see AccessController#doPrivileged(PrivilegedExceptionAction,
     *                                            AccessControlContext)
     */
    public Exception getException() {
        return (Exception)super.getCause();
    }

    public String toString() {
        String s = getClass().getName();
        Throwable cause = super.getCause();
        return (cause != null) ? (s + ": " + cause.toString()) : s;
    }


    /**
     * Serializable fields for UndeclaredThrowableException.
     *
     * @serialField undeclaredThrowable Throwable
     */
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("exception", Exception.class)
    };

    /*
     * Reconstitutes the PrivilegedActionException instance from a stream
     * and initialize the cause properly when deserializing from an older
     * version.
     *
     * The getException and getCause method returns the private "exception"
     * field in the older implementation and PrivilegedActionException::cause
     * was set to null.
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        Exception exception = (Exception) fields.get("exception", null);
        if (exception != null) {
            SharedSecrets.getJavaLangAccess().setCause(this, exception);
        }
    }

    /*
     * To maintain compatibility with older implementation, write a serial
     * "exception" field with the cause as the value.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("exception", super.getCause());
        out.writeFields();
    }
}
