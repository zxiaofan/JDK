/*
 * Copyright (c) 1995, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * The Holder for {@code Short}. For more information on
 * Holder files, see <a href="doc-files/generatedfiles.html#holder">
 * "Generated Files: Holder Files"</a>.
 * <P>A Holder class for a {@code short}
 * that is used to store "out" and "inout" parameters in IDL operations.
 * If an IDL operation signature has an IDL {@code short} as an "out"
 * or "inout" parameter, the programmer must pass an instance of
 * {@code ShortHolder} as the corresponding
 * parameter in the method invocation; for "inout" parameters, the programmer
 * must also fill the "in" value to be sent to the server.
 * Before the method invocation returns, the ORB will fill in the
 * value corresponding to the "out" value returned from the server.
 * <P>
 * If {@code myShortHolder} is an instance of {@code ShortHolder},
 * the value stored in its {@code value} field can be accessed with
 * {@code myShortHolder.value}.
 *
 * @since       JDK1.2
 */
public final class ShortHolder implements Streamable {

    /**
     * The {@code short} value held by this {@code ShortHolder}
     * object.
     */
    public short value;

    /**
     * Constructs a new {@code ShortHolder} object with its
     * {@code value} field initialized to {@code 0}.
     */
    public ShortHolder() {
    }

    /**
     * Constructs a new {@code ShortHolder} object with its
     * {@code value} field initialized to the given
     * {@code short}.
     * @param initial the {@code short} with which to initialize
     *                the {@code value} field of the newly-created
     *                {@code ShortHolder} object
     */
    public ShortHolder(short initial) {
        value = initial;
    }

    /**
     * Reads from {@code input} and initalizes the value in
     * this {@code ShortHolder} object
     * with the unmarshalled data.
     *
     * @param input the InputStream containing CDR formatted data from the wire.
     */
    public void _read(InputStream input) {
        value = input.read_short();
    }

    /**
     * Marshals to {@code output} the value in
     * this {@code ShortHolder} object.
     *
     * @param output the OutputStream which will contain the CDR formatted data.
     */
    public void _write(OutputStream output) {
        output.write_short(value);
    }

    /**
     * Returns the TypeCode corresponding to the value held in
     * this {@code ShortHolder} object.
     *
     * @return    the TypeCode of the value held in
     *            this {@code ShortHolder} object
     */
    public org.omg.CORBA.TypeCode _type() {
        return ORB.init().get_primitive_tc(TCKind.tk_short);
    }
}
