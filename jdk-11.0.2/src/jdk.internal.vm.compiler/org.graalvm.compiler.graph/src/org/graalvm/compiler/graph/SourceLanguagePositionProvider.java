/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph;

import jdk.vm.ci.meta.JavaConstant;

/**
 * Provider of {@link SourceLanguagePosition} for a constant if it represents an AST node.
 */
public interface SourceLanguagePositionProvider {
    SourceLanguagePosition getPosition(JavaConstant node);
}
