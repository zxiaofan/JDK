/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Message resources
 */
enum Messages {
    ILLEGAL_PARAMETER, // 2 args
    UNABLE_TO_FIND_CONVERSION_METHOD, // 3 args
    MISSING_ID, // 1 arg
    NOT_IMPLEMENTED_IN_2_0,
    UNRECOGNIZED_ELEMENT_NAME,
    TYPE_MISMATCH, // 3 args
    MISSING_OBJECT, // 1 arg
    NOT_IDENTIFIABLE, // 0 args
    DANGLING_IDREF, // 1 arg
    NULL_OUTPUT_RESOLVER, // 0 args
    UNABLE_TO_MARSHAL_NON_ELEMENT, // 1 arg
    UNABLE_TO_MARSHAL_UNBOUND_CLASS, // 1 arg
    UNSUPPORTED_PROPERTY, // 1 arg
    NULL_PROPERTY_NAME, // 0 args
    MUST_BE_X, // 3 args
    NOT_MARSHALLABLE, // 0 args
    UNSUPPORTED_RESULT, // 0 args
    UNSUPPORTED_ENCODING, // 1 arg
    SUBSTITUTED_BY_ANONYMOUS_TYPE, // 3 arg
    CYCLE_IN_MARSHALLER, // 1 arg
    UNABLE_TO_DISCOVER_EVENTHANDLER, // 1 arg
    ELEMENT_NEEDED_BUT_FOUND_DOCUMENT, // 1 arg
    UNKNOWN_CLASS, // 1 arg
    FAILED_TO_GENERATE_SCHEMA, // 0 args
    ERROR_PROCESSING_SCHEMA, // 0 args
    ILLEGAL_CONTENT, // 2 args
    ;

    private static final ResourceBundle rb = ResourceBundle.getBundle(Messages.class.getName());

    @Override
    public String toString() {
        return format();
    }

    public String format( Object... args ) {
        return MessageFormat.format( rb.getString(name()), args );
    }
}
