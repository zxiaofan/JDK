/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.activation.registries;

/**
 *      A class to encapsulate Mailcap parsing related exceptions
 */
public class MailcapParseException extends Exception {

    public MailcapParseException() {
        super();
    }

    public MailcapParseException(String inInfo) {
        super(inInfo);
    }
}
