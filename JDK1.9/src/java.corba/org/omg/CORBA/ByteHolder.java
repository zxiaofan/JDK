/*
 * Copyright (c) 1997, 2001, Oracle and/or its affiliates. All rights reserved.
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
 * The Holder for {@code Byte}. For more information on
 * Holder files, see <a href="doc-files/generatedfiles.html#holder">
 * "Generated Files: Holder Files"</a>.<P>
 * A Holder class for a {@code byte}
 * that is used to store "out" and "inout" parameters in IDL methods.
 * If an IDL method signature has an IDL {@code octet} as an "out"
 * or "inout" parameter, the programmer must pass an instance of
 * {@code ByteHolder} as the corresponding
 * parameter in the method invocation; for "inout" parameters, the programmer
 * must also fill the "in" value to be sent to the server.
 * Before the method invocation returns, the ORB will fill in the
 * value corresponding to the "out" value returned from the server.
 * <P>
 * If {@code myByteHolder} is an instance of {@code ByteHolder},
 * the value stored in its {@code value} field can be accessed with
 * {@code myByteHolder.value}.
 *
 * @since       JDK1.2
 */
public final class ByteHolder implements Streamable {
    /**
     * The {@code byte} value held by this {@code ByteHolder}
     * object.
     */

    public byte value;

    /**
     * Constructs a new {@code ByteHolder} object with its
     * {@code value} field initialized to 0.
     */
    public ByteHolder() {
    }

    /**
     * Constructs a new {@code ByteHolder} object for the given
     * {@code byte}.
     * @param initial the {@code byte} with which to initialize
     *                the {@code value} field of the new
     *                {@code ByteHolder} object
     */
    public ByteHolder(byte initial) {
        value = initial;
    }

    /**
     * Reads from {@code input} and initalizes the value in
     * this {@code ByteHolder} object
     * with the unmarshalled data.
     *
     * @param input the InputStream containing CDR formatted data from the wire.
     */
    public void _read(InputStream input) {
        value = input.read_octet();
    }

    /**
     * Marshals to {@code output} the value in
     * this {@code ByteHolder} object.
     *
     * @param output the OutputStream which will contain the CDR formatted data.
     */
    public void _write(OutputStream output) {
        output.write_octet(value);
    }

    /**
     * Returns the TypeCode corresponding to the value held in
     * this {@code ByteHolder} object.
     *
     * @return  the TypeCode of the value held in
     *          this {@code ByteHolder} object
     */
    public org.omg.CORBA.TypeCode _type() {
        return ORB.init().get_primitive_tc(TCKind.tk_octet);
    }
}
