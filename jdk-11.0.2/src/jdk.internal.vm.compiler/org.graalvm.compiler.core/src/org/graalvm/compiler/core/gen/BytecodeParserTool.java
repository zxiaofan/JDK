/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.gen;

import jdk.vm.ci.meta.Value;

/**
 * visible interface of bytecode parsers.
 */
public interface BytecodeParserTool {

    void storeLocal(int i, Value x);

}
