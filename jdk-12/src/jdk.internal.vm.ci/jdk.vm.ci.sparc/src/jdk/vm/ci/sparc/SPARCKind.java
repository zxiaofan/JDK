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
package jdk.vm.ci.sparc;

import jdk.vm.ci.meta.PlatformKind;

public enum SPARCKind implements PlatformKind {
    BYTE(1),
    HWORD(2),
    WORD(4),
    XWORD(8),
    SINGLE(4),
    DOUBLE(8),
    QUAD(16),

    V32_BYTE(4, BYTE),
    V32_HWORD(4, HWORD),

    V64_BYTE(8, BYTE),
    V64_HWORD(8, HWORD),
    V64_WORD(8, WORD),
    V64_SINGLE(8, SINGLE);

    private final int size;
    private final int vectorLength;

    private final SPARCKind scalar;
    private final EnumKey<SPARCKind> key = new EnumKey<>(this);

    SPARCKind(int size) {
        this.size = size;
        this.scalar = this;
        this.vectorLength = 1;
    }

    SPARCKind(int size, SPARCKind scalar) {
        this.size = size;
        this.scalar = scalar;

        assert size % scalar.size == 0;
        this.vectorLength = size / scalar.size;
    }

    public SPARCKind getScalar() {
        return scalar;
    }

    @Override
    public int getSizeInBytes() {
        return size;
    }

    public int getSizeInBits() {
        return getSizeInBytes() * 8;
    }

    @Override
    public int getVectorLength() {
        return vectorLength;
    }

    @Override
    public Key getKey() {
        return key;
    }

    public boolean isInteger() {
        switch (this) {
            case BYTE:
            case HWORD:
            case WORD:
            case XWORD:
                return true;
            default:
                return false;
        }
    }

    public boolean isFloat() {
        return !isInteger();
    }

    @Override
    public char getTypeChar() {
        switch (this) {
            case BYTE:
                return 'b';
            case HWORD:
                return 'h';
            case WORD:
                return 'w';
            case XWORD:
                return 'd';
            case SINGLE:
                return 'S';
            case DOUBLE:
            case V64_BYTE:
            case V64_HWORD:
            case V64_WORD:
                return 'D';
            default:
                return '-';
        }
    }
}
