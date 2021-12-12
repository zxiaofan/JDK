/*
 * Copyright (c) 1995, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

/**
 * Thrown when an application tries to load in a class through its
 * string name using:
 * <ul>
 * <li>The {@code forName} method in class {@code Class}.
 * <li>The {@code findSystemClass} method in class
 *     {@code ClassLoader} .
 * <li>The {@code loadClass} method in class {@code ClassLoader}.
 * </ul>
 * <p>
 * but no definition for the class with the specified name could be found.
 *
 * @see     java.lang.Class#forName(java.lang.String)
 * @see     java.lang.ClassLoader#findSystemClass(java.lang.String)
 * @see     java.lang.ClassLoader#loadClass(java.lang.String, boolean)
 * @since   1.0
 */
public class ClassNotFoundException extends ReflectiveOperationException {
    /**
     * use serialVersionUID from JDK 1.1.X for interoperability
     */
     @java.io.Serial
     private static final long serialVersionUID = 9176873029745254542L;

    /**
     * Constructs a {@code ClassNotFoundException} with no detail message.
     */
    public ClassNotFoundException() {
        super((Throwable)null);  // Disallow initCause
    }

    /**
     * Constructs a {@code ClassNotFoundException} with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public ClassNotFoundException(String s) {
        super(s, null);  //  Disallow initCause
    }

    /**
     * Constructs a {@code ClassNotFoundException} with the
     * specified detail message and optional exception that was
     * raised while loading the class.
     *
     * @param s the detail message
     * @param ex the exception that was raised while loading the class
     * @since 1.2
     */
    public ClassNotFoundException(String s, Throwable ex) {
        super(s, ex);  //  Disallow initCause
    }

    /**
     * Returns the exception that was raised if an error occurred while
     * attempting to load the class. Otherwise, returns {@code null}.
     *
     * @apiNote
     * This method predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @return the {@code Exception} that was raised while loading a class
     * @since 1.2
     */
    public Throwable getException() {
        return super.getCause();
    }

    /**
     * Serializable fields for ClassNotFoundException.
     *
     * @serialField ex Throwable  the {@code Throwable}
     */
    @java.io.Serial
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("ex", Throwable.class)
    };

    /**
     * Reconstitutes the ClassNotFoundException instance from a stream
     * and initialize the cause properly when deserializing from an older
     * version.
     *
     * The getException and getCause method returns the private "ex" field
     * in the older implementation and ClassNotFoundException::cause
     * was set to null.
     *
     * @param  s the {@code ObjectInputStream} from which data is read
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if a serialized class cannot be loaded
     */
    @java.io.Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        Throwable exception = (Throwable) fields.get("ex", null);
        if (exception != null) {
            setCause(exception);
        }
    }

    /**
     * To maintain compatibility with older implementation, write a serial
     * "ex" field with the cause as the value.
     *
     * @param  out the {@code ObjectOutputStream} to which data is written
     * @throws IOException if an I/O error occurs
     */
    @java.io.Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("ex", super.getCause());
        out.writeFields();
    }
}
