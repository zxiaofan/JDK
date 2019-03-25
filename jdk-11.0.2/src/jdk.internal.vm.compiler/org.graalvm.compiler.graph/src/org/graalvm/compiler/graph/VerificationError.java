/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.graph;

/**
 * This error represents a failed verification of a node . It must only be used for conditions that
 * should never occur during normal operation.
 */
public class VerificationError extends GraalGraphError {

    private static final long serialVersionUID = 8459607567446819822L;

    /**
     * This constructor creates a {@link VerificationError} with a message assembled via
     * {@link String#format(String, Object...)}. It always uses the ENGLISH locale in order to
     * always generate the same output.
     *
     * @param msg the message that will be associated with the error, in String.format syntax
     * @param args parameters to String.format - parameters that implement {@link Iterable} will be
     *            expanded into a [x, x, ...] representation.
     */
    public VerificationError(String msg, Object... args) {
        super(msg, args);
    }
}
