/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.asm.amd64;

import static org.graalvm.compiler.asm.amd64.AVXKind.AVXSize.DWORD;
import static org.graalvm.compiler.asm.amd64.AVXKind.AVXSize.QWORD;
import static org.graalvm.compiler.asm.amd64.AVXKind.AVXSize.XMM;
import static org.graalvm.compiler.asm.amd64.AVXKind.AVXSize.YMM;

import jdk.vm.ci.meta.Value;
import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.amd64.AMD64Kind;

/**
 * Helper methods for dealing with AVX and SSE {@link AMD64Kind AMD64Kinds}.
 */
public final class AVXKind {

    public enum AVXSize {
        DWORD,
        QWORD,
        XMM,
        YMM;

        public int getBytes() {
            switch (this) {
                case DWORD:
                    return 4;
                case QWORD:
                    return 8;
                case XMM:
                    return 16;
                case YMM:
                    return 32;
                default:
                    return 0;
            }
        }
    }

    private AVXKind() {
    }

    public static AVXSize getRegisterSize(Value a) {
        AMD64Kind kind = (AMD64Kind) a.getPlatformKind();
        if (kind.isXMM()) {
            return getRegisterSize(kind);
        } else {
            return XMM;
        }
    }

    public static AVXSize getDataSize(AMD64Kind kind) {
        assert kind.isXMM() : "unexpected kind " + kind;
        switch (kind.getSizeInBytes()) {
            case 4:
                return DWORD;
            case 8:
                return QWORD;
            case 16:
                return XMM;
            case 32:
                return YMM;
            default:
                throw GraalError.shouldNotReachHere("unsupported kind: " + kind);
        }
    }

    public static AVXSize getRegisterSize(AMD64Kind kind) {
        assert kind.isXMM() : "unexpected kind " + kind;
        if (kind.getSizeInBytes() > 16) {
            return YMM;
        } else {
            return XMM;
        }
    }

    public static AMD64Kind changeSize(AMD64Kind kind, AVXSize newSize) {
        return getAVXKind(kind.getScalar(), newSize);
    }

    public static AMD64Kind getAVXKind(AMD64Kind base, AVXSize size) {
        for (AMD64Kind ret : AMD64Kind.values()) {
            if (ret.getScalar() == base && ret.getSizeInBytes() == size.getBytes()) {
                return ret;
            }
        }
        throw GraalError.shouldNotReachHere(String.format("unsupported vector kind: %s x %s", size, base));
    }

    public static AMD64Kind getAVXKind(AMD64Kind base, int length) {
        for (AMD64Kind ret : AMD64Kind.values()) {
            if (ret.getScalar() == base && ret.getVectorLength() == length) {
                return ret;
            }
        }
        throw GraalError.shouldNotReachHere(String.format("unsupported vector kind: %d x %s", length, base));
    }
}
