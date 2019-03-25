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


package org.graalvm.compiler.core.sparc;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.spi.LIRKindTool;
import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.sparc.SPARCKind;

public class SPARCLIRKindTool implements LIRKindTool {

    @Override
    public LIRKind getIntegerKind(int bits) {
        if (bits <= 8) {
            return LIRKind.value(SPARCKind.BYTE);
        } else if (bits <= 16) {
            return LIRKind.value(SPARCKind.HWORD);
        } else if (bits <= 32) {
            return LIRKind.value(SPARCKind.WORD);
        } else {
            assert bits <= 64;
            return LIRKind.value(SPARCKind.XWORD);
        }
    }

    @Override
    public LIRKind getFloatingKind(int bits) {
        switch (bits) {
            case 32:
                return LIRKind.value(SPARCKind.SINGLE);
            case 64:
                return LIRKind.value(SPARCKind.DOUBLE);
            default:
                throw GraalError.shouldNotReachHere();
        }
    }

    @Override
    public LIRKind getObjectKind() {
        return LIRKind.reference(SPARCKind.XWORD);
    }

    @Override
    public LIRKind getWordKind() {
        return LIRKind.value(SPARCKind.XWORD);
    }

    @Override
    public LIRKind getNarrowOopKind() {
        return LIRKind.compressedReference(SPARCKind.WORD);
    }

    @Override
    public LIRKind getNarrowPointerKind() {
        return LIRKind.value(SPARCKind.WORD);
    }
}
