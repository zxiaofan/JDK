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
import org.graalvm.compiler.debug.CausableByCompilerAssert;

@SuppressWarnings("serial")
public class GraalBailoutException extends BailoutException implements CausableByCompilerAssert {

    public GraalBailoutException(String format, Object... args) {
        super(format, args);
    }

    public GraalBailoutException(Throwable cause, String format, Object... args) {
        super(cause, format, args);
    }

    public GraalBailoutException(boolean permanent, String format, Object... args) {
        super(permanent, format, args);
    }

    @Override
    public boolean isCausedByCompilerAssert() {
        return false;
    }
}
