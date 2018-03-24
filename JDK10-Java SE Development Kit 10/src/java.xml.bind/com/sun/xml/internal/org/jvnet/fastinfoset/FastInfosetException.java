/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.org.jvnet.fastinfoset;

public class FastInfosetException extends Exception {

    public FastInfosetException(String message) {
        super(message);
    }

    public FastInfosetException(String message, Exception e) {
        super(message, e);
    }

    public FastInfosetException(Exception e) {
        super(e);
    }

}
