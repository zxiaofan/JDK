/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.aarch64;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.spi.LIRKindTool;
import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.aarch64.AArch64Kind;

public class AArch64LIRKindTool implements LIRKindTool {

    @Override
    public LIRKind getIntegerKind(int bits) {
        if (bits <= 8) {
            return LIRKind.value(AArch64Kind.BYTE);
        } else if (bits <= 16) {
            return LIRKind.value(AArch64Kind.WORD);
        } else if (bits <= 32) {
            return LIRKind.value(AArch64Kind.DWORD);
        } else {
            assert bits <= 64;
            return LIRKind.value(AArch64Kind.QWORD);
        }
    }

    @Override
    public LIRKind getFloatingKind(int bits) {
        switch (bits) {
            case 32:
                return LIRKind.value(AArch64Kind.SINGLE);
            case 64:
                return LIRKind.value(AArch64Kind.DOUBLE);
            default:
                throw GraalError.shouldNotReachHere();
        }
    }

    @Override
    public LIRKind getObjectKind() {
        return LIRKind.reference(AArch64Kind.QWORD);
    }

    @Override
    public LIRKind getWordKind() {
        return LIRKind.value(AArch64Kind.QWORD);
    }

    @Override
    public LIRKind getNarrowOopKind() {
        return LIRKind.compressedReference(AArch64Kind.DWORD);
    }

    @Override
    public LIRKind getNarrowPointerKind() {
        return LIRKind.value(AArch64Kind.DWORD);
    }
}
