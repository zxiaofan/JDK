/*
 * Copyright (c) 1995, 2001, Oracle and/or its affiliates. All rights reserved.
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

import org.omg.CORBA.portable.Streamable;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;


/**
 * The Holder for {@code Boolean}. For more information on
 * Holder files, see <a href="doc-files/generatedfiles.html#holder">
 * "Generated Files: Holder Files"</a>.<P>
 * A Holder class for a {@code boolean}
 * that is used to store "out" and "inout" parameters in IDL methods.
 * If an IDL method signature has an IDL {@code boolean} as an "out"
 * or "inout" parameter, the programmer must pass an instance of
 * {@code BooleanHolder} as the corresponding
 * parameter in the method invocation; for "inout" parameters, the programmer
 * must also fill the "in" value to be sent to the server.
 * Before the method invocation returns, the ORB will fill in the
 * value corresponding to the "out" value returned from the server.
 * <P>
 * If {@code myBooleanHolder} is an instance of {@code BooleanHolder},
 * the value stored in its {@code value} field can be accessed with
 * {@code myBooleanHolder.value}.
 *
 * @since       JDK1.2
 */
public final class BooleanHolder implements Streamable {

    /**
     * The {@code boolean} value held by this {@code BooleanHolder}
     * object.
     */
    public boolean value;

    /**
     * Constructs a new {@code BooleanHolder} object with its
     * {@code value} field initialized to {@code false}.
     */
    public BooleanHolder() {
    }

    /**
     * Constructs a new {@code BooleanHolder} object with its
     * {@code value} field initialized with the given {@code boolean}.
     * @param initial the {@code boolean} with which to initialize
     *                the {@code value} field of the newly-created
     *                {@code BooleanHolder} object
     */
    public BooleanHolder(boolean initial) {
        value = initial;
    }

    /**
     * Reads unmarshalled data from {@code input} and assigns it to this
     * {@code BooleanHolder} object's {@code value} field.
     *
     * @param input the {@code InputStream} object containing
     *              CDR formatted data from the wire
     */
    public void _read(InputStream input) {
        value = input.read_boolean();
    }

    /**
     * Marshals the value in this {@code BooleanHolder} object's
     * {@code value} field to the output stream {@code output}.
     *
     * @param output the OutputStream which will contain the CDR formatted data
     */
    public void _write(OutputStream output) {
        output.write_boolean(value);
    }

    /**
     * Retrieves the {@code TypeCode} object that corresponds to the
     * value held in this {@code BooleanHolder} object.
     *
     * @return    the {@code TypeCode} for the value held
     *            in this {@code BooleanHolder} object
     */
    public TypeCode _type() {
        return ORB.init().get_primitive_tc(TCKind.tk_boolean);
    }
}
