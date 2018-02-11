/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.org.omg.CORBA;

public final class RepositoryHelper
{
    private static String  _id = "IDL:com.sun.omg.org/CORBA/Repository:3.0";

    public RepositoryHelper()
    {
    }

    public static void insert (org.omg.CORBA.Any a, Repository that)
    {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
        a.type (type ());
        write (out, that);
        a.read_value (out.create_input_stream (), type ());
    }

    public static Repository extract (org.omg.CORBA.Any a)
    {
        return read (a.create_input_stream ());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;
    synchronized public static org.omg.CORBA.TypeCode type ()
    {
        if (__typeCode == null)
            {
                __typeCode = org.omg.CORBA.ORB.init ().create_string_tc (0);
                __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (com.sun.org.omg.CORBA.RepositoryHelper.id (), "Repository", __typeCode);
            }
        return __typeCode;
    }

    public static String id ()
    {
        return _id;
    }

    public static Repository read (org.omg.CORBA.portable.InputStream istream)
    {
        String value = null;
        value = istream.read_string ();
        return null;
    }

    public static void write (org.omg.CORBA.portable.OutputStream ostream, Repository value)
    {
        ostream.write_string (null);
    }

}
