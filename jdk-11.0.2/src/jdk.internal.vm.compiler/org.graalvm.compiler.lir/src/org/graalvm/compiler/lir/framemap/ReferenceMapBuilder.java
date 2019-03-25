/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.framemap;

import org.graalvm.compiler.lir.LIRFrameState;

import jdk.vm.ci.code.ReferenceMap;
import jdk.vm.ci.meta.Value;

public abstract class ReferenceMapBuilder {

    public abstract void addLiveValue(Value value);

    public abstract ReferenceMap finish(LIRFrameState state);
}
