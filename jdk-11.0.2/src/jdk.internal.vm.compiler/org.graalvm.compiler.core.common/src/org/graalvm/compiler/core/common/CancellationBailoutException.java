/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common;

/**
 * A {@linkplain RetryableBailoutException} that will be thrown if an on-going compilation in the
 * compiler was cancelled.
 */
public final class CancellationBailoutException extends RetryableBailoutException {

    private static final long serialVersionUID = 6551793589275293360L;

    public CancellationBailoutException() {
        super("Compilation cancelled.");
    }

    public static void cancelCompilation() {
        throw new CancellationBailoutException();
    }

}
