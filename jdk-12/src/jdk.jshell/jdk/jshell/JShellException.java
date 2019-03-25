/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jshell;

/**
 * The superclass of JShell generated exceptions
 *
 * @since 9
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
public class JShellException extends Exception {

    JShellException(String message) {
        super(message);
    }

    JShellException(String message, Throwable cause) {
        super(message, cause);
    }
}
