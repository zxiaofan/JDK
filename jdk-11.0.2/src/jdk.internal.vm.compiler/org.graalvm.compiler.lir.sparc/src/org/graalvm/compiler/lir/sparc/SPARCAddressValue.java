/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.sparc;

import org.graalvm.compiler.asm.sparc.SPARCAddress;
import org.graalvm.compiler.lir.CompositeValue;

import jdk.vm.ci.meta.Value;
import jdk.vm.ci.meta.ValueKind;

public abstract class SPARCAddressValue extends CompositeValue {

    public SPARCAddressValue(ValueKind<?> kind) {
        super(kind);
    }

    public abstract SPARCAddress toAddress();

    public abstract boolean isValidImplicitNullCheckFor(Value value, int implicitNullCheckLimit);
}
