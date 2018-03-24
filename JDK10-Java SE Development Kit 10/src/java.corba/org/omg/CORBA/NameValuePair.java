/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Associates  a name with a value that is an
 * attribute of an IDL struct, and is used in the {@code DynStruct} APIs.
 */

public final class NameValuePair implements org.omg.CORBA.portable.IDLEntity {

    /**
     * The name to be associated with a value by this {@code NameValuePair} object.
     */
    public String id;

    /**
     * The value to be associated with a name by this {@code NameValuePair} object.
     */
    public org.omg.CORBA.Any value;

    /**
     * Constructs an empty {@code NameValuePair} object.
     * To associate a name with a value after using this constructor, the fields
     * of this object have to be accessed individually.
     */
    public NameValuePair() { }

    /**
     * Constructs a {@code NameValuePair} object that associates
     * the given name with the given {@code org.omg.CORBA.Any} object.
     * @param __id the name to be associated with the given {@code Any} object
     * @param __value the {@code Any} object to be associated with the given name
     */
    public NameValuePair(String __id, org.omg.CORBA.Any __value) {
        id = __id;
        value = __value;
    }
}
