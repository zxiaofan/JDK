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

package jdk.nashorn.internal.runtime.linker;

import jdk.nashorn.internal.runtime.ECMAErrors;
import jdk.nashorn.internal.runtime.ECMAException;

/**
 * A result of generating an adapter for a class. A tuple of an outcome and - in case of an error outcome - a list of
 * classes that caused the error.
 */
final class AdaptationResult {
    /**
     * Contains various outcomes for attempting to generate an adapter class. These are stored in AdapterInfo instances.
     * We have a successful outcome (adapter class was generated) and four possible error outcomes: superclass is final,
     * superclass is not public, superclass has no public or protected constructor, more than one superclass was
     * specified. We don't throw exceptions when we try to generate the adapter, but rather just record these error
     * conditions as they are still useful as partial outcomes, as Nashorn's linker can still successfully check whether
     * the class can be autoconverted from a script function even when it is not possible to generate an adapter for it.
     */
    enum Outcome {
        SUCCESS,
        ERROR_FINAL_CLASS,
        ERROR_NON_PUBLIC_CLASS,
        ERROR_NO_ACCESSIBLE_CONSTRUCTOR,
        ERROR_MULTIPLE_SUPERCLASSES,
        ERROR_NO_COMMON_LOADER,
        ERROR_FINAL_FINALIZER,
        ERROR_OTHER
    }

    static final AdaptationResult SUCCESSFUL_RESULT = new AdaptationResult(Outcome.SUCCESS, "");

    private final Outcome outcome;
    private final RuntimeException cause;
    private final String[] messageArgs;

    AdaptationResult(final Outcome outcome, final RuntimeException cause, final String... messageArgs) {
        this.outcome = outcome;
        this.cause = cause;
        this.messageArgs = messageArgs;
    }

    AdaptationResult(final Outcome outcome, final String... messageArgs) {
        this(outcome, null, messageArgs);
    }

    Outcome getOutcome() {
        return outcome;
    }

    ECMAException typeError() {
        return ECMAErrors.typeError(cause, "extend." + outcome, messageArgs);
    }
}
