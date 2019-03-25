/*
 * Copyright (c) 2011, 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.java;

import org.graalvm.compiler.core.common.PermanentBailoutException;

public class JsrNotSupportedBailout extends PermanentBailoutException {

    private static final long serialVersionUID = -7476925652727154272L;

    public JsrNotSupportedBailout(String reason) {
        super(reason);
    }
}
