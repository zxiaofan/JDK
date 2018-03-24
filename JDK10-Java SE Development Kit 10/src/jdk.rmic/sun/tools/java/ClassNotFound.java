/*
 * Copyright (c) 1994, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.java;

/**
 * This exception is thrown when a class definition is needed
 * and the class can't be found.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
@SuppressWarnings("serial") // JDK implementation class
public
class ClassNotFound extends Exception {
    /**
     * The class that was not found
     */
    public Identifier name;

    /**
     * Create a ClassNotFound exception
     */
    public ClassNotFound(Identifier nm) {
        super(nm.toString());
        name = nm;
    }
}
