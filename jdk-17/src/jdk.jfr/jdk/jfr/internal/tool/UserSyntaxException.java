/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.tool;

/**
 * Exception that is thrown if options don't follow the syntax of the command.
 */
final class UserSyntaxException extends Exception {
    private static final long serialVersionUID = 3437009454344160933L;

    /**
     * The error message.
     *
     * The first letter should not be capitalized, so a context can be printed prior
     * to the error message.
     *
     * @param errorMessage
     */
    public UserSyntaxException(String errorMessage) {
        super(errorMessage);
    }
}
