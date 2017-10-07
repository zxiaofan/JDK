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
 * The Holder for {@code String}.  For more information on
 * Holder files, see <a href="doc-files/generatedfiles.html#holder">
 * "Generated Files: Holder Files"</a>.<P>
 * A Holder class for a {@code String}
 * that is used to store "out" and "inout" parameters in IDL operations.
 * If an IDL operation signature has an IDL {@code string} as an "out"
 * or "inout" parameter, the programmer must pass an instance of
 * {@code StringHolder} as the corresponding
 * parameter in the method invocation; for "inout" parameters, the programmer
 * must also fill the "in" value to be sent to the server.
 * Before the method invocation returns, the ORB will fill in the
 * value corresponding to the "out" value returned from the server.
 * <P>
 * If {@code myStringHolder} is an instance of {@code StringHolder},
 * the value stored in its {@code value} field can be accessed with
 * {@code myStringHolder.value}.
 *
 * @since       JDK1.2
 */
public final class StringHolder implements Streamable {

    /**
     * The {@code String} value held by this {@code StringHolder}
     * object.
     */
    public String value;

    /**
     * Constructs a new {@code StringHolder} object with its
     * {@code value} field initialized to {@code null}.
     */
    public StringHolder() {
    }

    /**
     * Constructs a new {@code StringHolder} object with its
     * {@code value} field initialized to the given
     * {@code String}.
     * @param initial the {@code String} with which to initialize
     *                the {@code value} field of the newly-created
     *                {@code StringHolder} object
     */
    public StringHolder(String initial) {
        value = initial;
    }

    /**
     * Reads the unmarshalled data from {@code input} and assigns it to
     * the {@code value} field of this {@code StringHolder} object.
     *
     * @param input the InputStream containing CDR formatted data from the wire.
     */
    public void _read(InputStream input) {
        value = input.read_string();
    }

    /**
     * Marshals the value held by this {@code StringHolder} object
     * to the output stream  {@code output}.
     *
     * @param output the OutputStream which will contain the CDR formatted data.
     */
    public void _write(OutputStream output) {
        output.write_string(value);
    }

    /**
     * Retrieves the {@code TypeCode} object that corresponds to
     * the value held in this {@code StringHolder} object.
     *
     * @return    the type code of the value held in this {@code StringHolder}
     *            object
     */
    public org.omg.CORBA.TypeCode _type() {
        return ORB.init().get_primitive_tc(TCKind.tk_string);
    }
}
