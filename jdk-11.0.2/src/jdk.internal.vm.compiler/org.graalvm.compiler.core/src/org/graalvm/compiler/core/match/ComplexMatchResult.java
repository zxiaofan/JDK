/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.match;

import jdk.vm.ci.meta.Value;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;

/**
 * A closure that can be evaluated to produce the LIR for some complex match. Using a closure allows
 * normal evaluation in NodeLIRBuilder for all the simple nodes with the complex nodes evaluated at
 * the proper time.
 */
public interface ComplexMatchResult {
    Value evaluate(NodeLIRBuilder gen);
}
