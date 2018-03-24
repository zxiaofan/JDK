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
package org.graalvm.compiler.core.common;

import jdk.vm.ci.code.BailoutException;

public class PermanentBailoutException extends BailoutException {

    private static final long serialVersionUID = -2683649650135362549L;

    public PermanentBailoutException(String format, Object... args) {
        super(true, format, args);
    }

    public PermanentBailoutException(String reason) {
        super(true, reason);
    }

    public PermanentBailoutException(Throwable cause, String format, Object... args) {
        super(cause, format, args);
    }
}
