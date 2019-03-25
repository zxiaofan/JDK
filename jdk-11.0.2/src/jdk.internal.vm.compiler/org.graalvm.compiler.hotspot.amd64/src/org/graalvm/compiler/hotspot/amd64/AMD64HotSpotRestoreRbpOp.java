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


package org.graalvm.compiler.hotspot.amd64;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.Variable;

import jdk.vm.ci.amd64.AMD64Kind;
import jdk.vm.ci.meta.AllocatableValue;

public interface AMD64HotSpotRestoreRbpOp {

    /**
     * The type of location (i.e., stack or register) in which RBP is saved is not known until
     * initial LIR generation is finished. Until then, we use a placeholder variable so that LIR
     * verification is successful.
     */
    Variable PLACEHOLDER = new Variable(LIRKind.value(AMD64Kind.QWORD), Integer.MAX_VALUE);

    void setSavedRbp(AllocatableValue value);
}
