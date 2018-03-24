/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.buffer;

public class XMLStreamBufferException extends Exception {

    public XMLStreamBufferException(String message) {
        super(message);
    }

    public XMLStreamBufferException(String message, Exception e) {
        super(message, e);
    }

    public XMLStreamBufferException(Exception e) {
        super(e);
    }
}
