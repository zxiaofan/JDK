/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc;

import com.sun.istack.internal.Nullable;

/**
 * Signals a bad command line argument.
 */
public class BadCommandLineException extends Exception {
    private Options options;

    public BadCommandLineException(String msg) {
        super(msg);
    }

    public BadCommandLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCommandLineException() {
        this(null);
    }

    public void initOptions(Options opt) {
        assert this.options==null;
        this.options = opt;
    }

    /**
     * Gets the partly parsed option object, if any.
     */
    public @Nullable Options getOptions() {
        return options;
    }
}
