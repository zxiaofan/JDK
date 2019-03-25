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


package org.graalvm.compiler.replacements.arraycopy;

import org.graalvm.compiler.core.common.spi.ForeignCallDescriptor;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.JavaKind;

public interface ArrayCopyForeignCalls extends ForeignCallsProvider {

    ForeignCallDescriptor UNSAFE_ARRAYCOPY = new ForeignCallDescriptor("unsafe_arraycopy", void.class, Word.class, Word.class, Word.class);
    ForeignCallDescriptor GENERIC_ARRAYCOPY = new ForeignCallDescriptor("generic_arraycopy", int.class, Word.class, int.class, Word.class, int.class, int.class);

    ForeignCallDescriptor lookupCheckcastArraycopyDescriptor(boolean uninit);

    ForeignCallDescriptor lookupArraycopyDescriptor(JavaKind kind, boolean aligned, boolean disjoint, boolean uninit, boolean killAny);
}
