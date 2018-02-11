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
 * The Holder for {@code Long}. For more information on
 * Holder files, see <a href="doc-files/generatedfiles.html#holder">
 * "Generated Files: Holder Files"</a>.<P>
 * A Holder class for a {@code long}
 * that is used to store "out" and "inout" parameters in IDL methods.
 * If an IDL method signature has an IDL {@code long long} as an "out"
 * or "inout" parameter, the programmer must pass an instance of
 * {@code LongHolder} as the corresponding
 * parameter in the method invocation; for "inout" parameters, the programmer
 * must also fill the "in" value to be sent to the server.
 * Before the method invocation returns, the ORB will fill in the
 * value corresponding to the "out" value returned from the server.
 * <P>
 * If {@code myLongHolder} is an instance of {@code LongHolder},
 * the value stored in its {@code value} field can be accessed with
 * {@code myLongHolder.value}.
 *
 * @since       JDK1.2
 */
public final class LongHolder implements Streamable {

    /**
     * The {@code long} value held by this {@code LongHolder}
     * object.
     */
    public long value;

    /**
     * Constructs a new {@code LongHolder} object with its
     * {@code value} field initialized to {@code 0}.
     */
    public LongHolder() {
    }

    /**
     * Constructs a new {@code LongHolder} object with its
     * {@code value} field initialized to the given
     * {@code long}.
     * @param initial the {@code long} with which to initialize
     *                the {@code value} field of the newly-created
     *                {@code LongHolder} object
     */
    public LongHolder(long initial) {
        value = initial;
    }

    /**
     * Reads from {@code input} and initalizes the value in the Holder
     * with the unmarshalled data.
     *
     * @param input the InputStream containing CDR formatted data from the wire
     */
    public void _read(InputStream input) {
        value = input.read_longlong();
    }

    /**
     * Marshals to {@code output} the value in the Holder.
     *
     * @param output the OutputStream which will contain the CDR formatted data
     */
    public void _write(OutputStream output) {
        output.write_longlong(value);
    }

    /**
     * Returns the {@code TypeCode} object
     * corresponding to the value held in the Holder.
     *
     * @return    the TypeCode of the value held in the holder
     */
    public org.omg.CORBA.TypeCode _type() {
        return ORB.init().get_primitive_tc(TCKind.tk_longlong);
    }

}
