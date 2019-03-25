/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.asm;

import org.graalvm.compiler.code.DataSection.Data;

import jdk.vm.ci.meta.Constant;

public abstract class DataBuilder {

    /**
     * When the method returns true, then Graal must produce detailed information that allows code
     * patching without decoding instructions, i.e., Graal must produce annotations for the machine
     * code that describe the exact locations of operands within instructions.
     */
    public abstract boolean needDetailedPatchingInformation();

    public abstract Data createDataItem(Constant c);
}
