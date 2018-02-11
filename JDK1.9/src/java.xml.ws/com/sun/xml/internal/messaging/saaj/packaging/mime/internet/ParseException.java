/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * @(#)ParseException.java    1.3 02/03/27
 */



package com.sun.xml.internal.messaging.saaj.packaging.mime.internet;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

/**
 * The exception thrown due to an error in parsing RFC822
 * or MIME headers
 *
 * @author John Mani
 */

public class ParseException extends MessagingException {

    /**
     * Constructs a ParseException with no detail message.
     */
    public ParseException() {
        super();
    }

    /**
     * Constructs a ParseException with the specified detail message.
     * @param s         the detail message
     */
    public ParseException(String s) {
        super(s);
    }
}
