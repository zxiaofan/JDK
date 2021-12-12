/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.code.CompilationRequest;
import jdk.vm.ci.code.CompilationRequestResult;

/**
 * HotSpot specific information about the result of a {@link CompilationRequest}.
 */
public final class HotSpotCompilationRequestResult implements CompilationRequestResult {

    /**
     * A user readable description of the failure.
     *
     * This field is read by the VM.
     */
    private final String failureMessage;

    /**
     * Whether this is a transient failure where retrying would help.
     *
     * This field is read by the VM.
     */
    private final boolean retry;

    /**
     * Number of bytecodes inlined into the compilation, exclusive of the bytecodes in the root
     * method.
     *
     * This field is read by the VM.
     */
    private final int inlinedBytecodes;

    private HotSpotCompilationRequestResult(String failureMessage, boolean retry, int inlinedBytecodes) {
        this.failureMessage = failureMessage;
        this.retry = retry;
        this.inlinedBytecodes = inlinedBytecodes;
    }

    @Override
    public Object getFailure() {
        return failureMessage;
    }

    /**
     * Creates a result representing a successful compilation.
     *
     * @param inlinedBytecodes number of bytecodes inlined into the compilation, exclusive of the
     *            bytecodes in the root method
     */
    public static HotSpotCompilationRequestResult success(int inlinedBytecodes) {
        return new HotSpotCompilationRequestResult(null, true, inlinedBytecodes);
    }

    /**
     * Creates a result representing a failed compilation.
     *
     * @param failureMessage a description of the failure
     * @param retry whether this is a transient failure where retrying may succeed
     */
    public static HotSpotCompilationRequestResult failure(String failureMessage, boolean retry) {
        return new HotSpotCompilationRequestResult(failureMessage, retry, 0);
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public boolean getRetry() {
        return retry;
    }

    public int getInlinedBytecodes() {
        return inlinedBytecodes;
    }
}
