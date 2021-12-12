/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.tool;

import static jdk.javadoc.internal.tool.Main.Result.CMDERR;

/**
 * Provides a mechanism for the javadoc tool to indicate an option
 * decoding issue, arising from a command-line error.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */

class IllegalOptionValue extends OptionException {

    private static final long serialVersionUID = 0;

    /**
     * Constructs an object containing a runnable and a message.
     * @param method a method to display suitable usage text
     * @param message the detailed message
     */
    IllegalOptionValue(Runnable method, String message) {
        super(CMDERR, method, message);
    }
}
