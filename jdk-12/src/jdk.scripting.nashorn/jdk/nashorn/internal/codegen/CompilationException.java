/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.internal.codegen;

/**
 * Exception when something in the compiler breaks down. Can only
 * be instantiated by the codegen package
 */
@SuppressWarnings("serial")
public class CompilationException extends RuntimeException {

    CompilationException(final String description) {
        super(description);
    }

    CompilationException(final Exception cause) {
        super(cause);
    }
}
