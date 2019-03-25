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


package org.graalvm.compiler.nodes.util;

/**
 * Performs special formatting of values involving {@link jdk.vm.ci.meta.JavaConstant JavaConstants}
 * when they are being dumped.
 */
public interface JavaConstantFormattable {
    String format(JavaConstantFormatter formatter);
}
