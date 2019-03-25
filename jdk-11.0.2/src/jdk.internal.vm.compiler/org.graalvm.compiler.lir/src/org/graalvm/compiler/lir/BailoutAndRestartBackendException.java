/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir;

import org.graalvm.compiler.core.common.PermanentBailoutException;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionType;

/**
 * Restarts the {@link LIR low-level} compilation with a modified configuration.
 * {@link BailoutAndRestartBackendException.Options#LIRUnlockBackendRestart LIRUnlockBackendRestart}
 * needs to be enabled. Use only for debugging purposes only.
 */
public abstract class BailoutAndRestartBackendException extends PermanentBailoutException {

    public static class Options {
        // @formatter:off
        @Option(help = "Unlock backend restart feature.", type = OptionType.Debug)
        public static final OptionKey<Boolean> LIRUnlockBackendRestart = new OptionKey<>(false);
        // @formatter:on
    }

    private static final long serialVersionUID = 792969002851591180L;

    public BailoutAndRestartBackendException(String msg) {
        super(msg);
    }

    public BailoutAndRestartBackendException(Throwable cause, String msg) {
        super(cause, msg);
    }
}
