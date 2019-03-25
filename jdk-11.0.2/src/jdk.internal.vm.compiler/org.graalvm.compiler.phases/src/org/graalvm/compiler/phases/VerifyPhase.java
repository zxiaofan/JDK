/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases;

import org.graalvm.compiler.nodes.StructuredGraph;

/***
 * This phase serves as a verification, in order to check the graph for certain properties. The
 * {@link #verify(StructuredGraph, Object)} method will be used as an assertion, and implements the
 * actual check. Instead of returning false, it is also valid to throw an {@link VerificationError}
 * in the implemented {@link #verify(StructuredGraph, Object)} method.
 */
public abstract class VerifyPhase<C> extends BasePhase<C> {

    /**
     * Thrown when verification performed by a {@link VerifyPhase} fails.
     */
    @SuppressWarnings("serial")
    public static class VerificationError extends AssertionError {

        public VerificationError(String message) {
            super(message);
        }

        public VerificationError(String format, Object... args) {
            super(String.format(format, args));
        }

        public VerificationError(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @Override
    protected final void run(StructuredGraph graph, C context) {
        assert verify(graph, context);
    }

    /**
     * Performs the actual verification.
     *
     * @throws VerificationError if the verification fails
     */
    protected abstract boolean verify(StructuredGraph graph, C context);
}
