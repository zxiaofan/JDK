/*
 * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi.connect;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Thrown to indicate an invalid argument or
 * inconsistent passed to a {@link Connector}.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public class IllegalConnectorArgumentsException extends Exception {

    private static final long serialVersionUID = -3042212603611350941L;

    @SuppressWarnings("serial") // Conditionally serializable
    List<String> names;

    /**
     * Construct an <code>IllegalConnectorArgumentsException</code>
     * with the specified detail message and the name of the argument
     * which is invalid or inconsistent.
     * @param s the detailed message.
     * @param name the name of the invalid or inconsistent argument.
     */
    public IllegalConnectorArgumentsException(String s, String name) {
        super(s);
        names = new ArrayList<String>(1);
        names.add(name);
    }

    /**
     * Construct an <code>IllegalConnectorArgumentsException</code>
     * with the specified detail message and a <code>List</code> of
     * names of arguments which are invalid or inconsistent.
     * @param s the detailed message.
     * @param names a <code>List</code> containing the names of the
     * invalid or inconsistent argument.
     */
    public IllegalConnectorArgumentsException(String s, List<String> names) {
        super(s);
        this.names = new ArrayList<String>(names);
    }

    /**
     * Return a <code>List</code> containing the names of the
     * invalid or inconsistent arguments.
     * @return a <code>List</code> of argument names.
     */
    public List<String> argumentNames() {
        return Collections.unmodifiableList(names);
    }
}
